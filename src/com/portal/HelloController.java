package com.portal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import com.infotech.model.User;
import com.model.Employee;
import com.service.EmpService;

import java.util.Iterator;
import java.util.List;
//import antlr.collections.List;
import java.util.List.*;

//import com.model.Employee;

@Controller
public class HelloController {

	@Autowired
	private EmpService employeeService;

	@RequestMapping(value = "/")
	public String welcome() {
		return "welcome";
	}

	@RequestMapping(value = "/adminLogin")
	public ModelAndView adminLogin( /* HttpServletRequest req , HttpServletResponse res */) {
		ModelAndView modelAndView;
		modelAndView = new ModelAndView("adminLogin");
		return modelAndView;
	}
	
	

	@RequestMapping(value = "/adminPortal",method = RequestMethod.POST)
	public ModelAndView adminPortal(@RequestParam("email") String Email, @RequestParam("password") String password) {
		Email = Email.trim();
	    password = password.trim();
	    
	    ModelAndView modelAndView;
	    
		if(Email.equals("mnitcseanil@gmail.com") && password.equals("skilrock")) {
			
			List<Employee> list;
			Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
			SessionFactory sf = cfg.buildSessionFactory(reg);
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("from Employee");
			list = query.list();
			
			
			modelAndView = new ModelAndView("adminPortal");
			modelAndView.addObject("list", list);
		}
		else {
			modelAndView = new ModelAndView("welcome");
		}
		
		return modelAndView;
		
	}
	
	
	
	// Employee login and validation process
	@RequestMapping(value = "/loginSuccess", method = RequestMethod.POST)
	public ModelAndView loginSuccess(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView;

		// model calss Dummy object
		Employee emp2 = null;
		boolean flag = false;

		String Email = req.getParameter("email");
		String Password = req.getParameter("password");
		Email = Email.trim();
		Password = Password.trim();

		// employee object list
		List<Employee> list;

		// database connection and query execution
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory sf = cfg.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Employee");
		list = query.list();
		tx.commit();
		session.close();

		// Validation of Employee

		Iterator it = list.iterator();
		// Iterator<Employee> it = new Iterator();
		while (it.hasNext()) {
			Employee emp = (Employee) it.next();
			System.out.println(emp.getPassword() + " " + emp.getEmail());
			if (Email.equals(emp.getEmail()) && Password.equals(emp.getPassword())) {
				emp2 = emp;
				/// System.out.println("say hello");
				flag = true;
				break;

			}

		}

		if (flag) {
			modelAndView = new ModelAndView("loginSuccess");
			modelAndView.addObject("user", emp2);
		} else {
			modelAndView = new ModelAndView("welcome");
		}

		return modelAndView;
	}

	// Employee registration process
	@RequestMapping(value = "/registerSuccess", method = RequestMethod.POST)
	public ModelAndView empRegister(HttpServletRequest req, HttpServletRequest res) {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String designation = req.getParameter("designation");
		int contact = Integer.parseInt(req.getParameter("contact"));
		Double salary = Double.parseDouble(req.getParameter("salary"));
		String country = req.getParameter("country");
		String password = req.getParameter("password");
		int attendace = 0 ;
		
		Employee employee = new Employee(name, email, designation, salary, contact, country, password,attendace);
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory sf = cfg.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(employee);
		tx.commit();
		ModelAndView modelandview = new ModelAndView("registerSuccess");
		modelandview.addObject("user", employee);
		return modelandview;
	}

	@RequestMapping(value = "/listEmp")
	public ModelAndView listEmp() {

		ModelAndView modelAndView = new ModelAndView("listEmp");
		return modelAndView;
	}

	@RequestMapping(value = "/empRegister")
	public ModelAndView registerSuccess() {
		ModelAndView modelAndView = new ModelAndView("empRegister");
		return modelAndView;
	}

	@RequestMapping(value = "/empLogin")
	public ModelAndView empLogin() {
		ModelAndView modelAndView = new ModelAndView("empLogin");
		return modelAndView;
	}
     
	 @RequestMapping(value="/deleteemp/{contact}",method = RequestMethod.GET)  
	public ModelAndView deletetemp(@PathVariable int contact) {
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory sf = cfg.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete from Employee where contact =" + contact);
		query.executeUpdate();
		tx.commit();
		
		
		List<Employee> list;
		Configuration cfg1 = new Configuration().configure().addAnnotatedClass(Employee.class);
		ServiceRegistry reg1 = new ServiceRegistryBuilder().applySettings(cfg1.getProperties()).buildServiceRegistry();
		SessionFactory sf1 = cfg.buildSessionFactory(reg1);
		Session session1 = sf.openSession();
		Transaction tx1 = session.beginTransaction();
		Query query1 = session.createQuery("from Employee");
		list = query1.list();
		tx1.commit();
		session.close();
		
	ModelAndView modelAndView = new ModelAndView("adminPortal");
		modelAndView.addObject("list", list);
		
		return modelAndView;
	}
	 
	 /*
	 @RequestMapping(value = "/edit/{contact}")
	 public ModelAndView editemp(@PathVariable int contact) {
		 
		 
		 return new ModelAndView("edit");
		 
	 }
	 
	 */
	 
	 
	 @RequestMapping(value = "/employeeEdit",method = RequestMethod.GET)
	 public ModelAndView employeeEdit() {
		 
		 ModelAndView modelAndView = new ModelAndView("employeeEdit");
		 return modelAndView;
		 
	 }
	 
	 
	 @RequestMapping(value = "/takeAttend",method = RequestMethod.GET)
	 public ModelAndView takeAttend() {
		 
		// String s = req.getParameter("attend");
		 
			List<Employee> list;
			Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
			SessionFactory sf = cfg.buildSessionFactory(reg);
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("from Employee");
			list = query.list();
			tx.commit();
			session.close();
			
		ModelAndView modelAndView = new ModelAndView("takeAttend");
			modelAndView.addObject("list", list);
			
			return modelAndView;
		
		 
		
	 }
	 
	 @RequestMapping(value = "/countAttend" , method = RequestMethod.GET)
	 public ModelAndView countAttend(HttpServletRequest req , HttpServletResponse res) {
		
		 int temp = 0,count;
		 List<Employee> list;
			Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
			SessionFactory sf = cfg.buildSessionFactory(reg);
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("from Employee");
			list = query.list();
			temp = list.size();
			
			Iterator it = list.iterator();
			while(it.hasNext()) {
				temp = temp +1;
				Employee emp = (Employee) it.next();
				if(req.getParameter("attend"+temp)!=null)
				   count = emp.getAttendace() +1;
				else
					count = emp.getAttendace();
				
			    Query query1 = session.createQuery("update Employee set attendace = " +count+" where contact = " +emp.getContact()+"" );
			query1.executeUpdate();
			
			}
			tx.commit();
			session.close();
			
			
		 
		 // System.out.println(s);
		 ModelAndView modelAndView = new ModelAndView("countAttend");
		 return modelAndView;
	 }
	 
	 
	
}
