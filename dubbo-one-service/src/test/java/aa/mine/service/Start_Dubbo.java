package aa.mine.service;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start_Dubbo {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = 
				 new ClassPathXmlApplicationContext(
						 new String[] {"applicationContext.xml","spring-dubbo.xml"});
		 String[] beanNames = context.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}    
		context.start();	       
	        try {
				System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 按任意键退出
	}
}
