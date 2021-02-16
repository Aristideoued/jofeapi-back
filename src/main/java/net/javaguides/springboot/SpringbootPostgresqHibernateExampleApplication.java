package net.javaguides.springboot;



/*import java.net.InetSocketAddress;
import java.net.Socket;*/

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;


//@EnableJpaRepositories("FrontendsRepository")



@SpringBootApplication
@ComponentScan({"net.javaguides.springboot.service","net.javaguides.springboot.controller"}) 
public class SpringbootPostgresqHibernateExampleApplication {
	 private static ConfigurableApplicationContext context;
	public static void main(String[] args) {
		context=SpringApplication.run(SpringbootPostgresqHibernateExampleApplication.class, args);
	
	
		
		  /*Socket socket = new Socket();
	        try {
	            socket.connect(new InetSocketAddress("127.0.0.1", 8080), 500);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        try {
	        	 socket = new Socket();
	 	        socket.connect(new InetSocketAddress("127.0.0.1", 8080), 1100);
	        }
	        
	        catch(Exception e) {
	        	 e.printStackTrace();
	        }*/
	       
	}
	
	public static void restart() {
        ApplicationArguments args = context.getBean(ApplicationArguments.class);

        Thread thread = new Thread(() -> {
            context.close();
            context = SpringApplication.run(SpringbootPostgresqHibernateExampleApplication.class, args.getSourceArgs());
        });

        thread.setDaemon(false);
        thread.start();
    }

}
