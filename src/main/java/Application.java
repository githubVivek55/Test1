import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pluralsight.service.CustomerService;

public class Application {
	public static void main(String[] args) {

		/*
		 * ApplicationContext appContext = new ClassPathXmlApplicationContext(
		 * "applicationContext.xml");
		 * 
		 * CustomerService customerservice =
		 * appContext.getBean("customerService", CustomerService.class);
		 * System.out.println(customerservice.findAll().get(0).getFirstName());
		 */
		ApplicationContext appContext=new AnnotationConfigApplicationContext(AppConfig.class);
		CustomerService cuss=appContext.getBean("customerService",CustomerService.class);
		System.out.println(cuss.findAll().get(0).getFirstName());
		
	}
}
