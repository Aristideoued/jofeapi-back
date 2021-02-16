
/*package net.javaguides.springboot.InitData;




import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



import net.javaguides.springboot.model.Employe;
import net.javaguides.springboot.repository.EmployeRepository;

@Component
@Order(3)
public class InitEmploye implements ApplicationRunner {
	
	private final EmployeRepository employeRepository;
	
	public InitEmploye(EmployeRepository employeRepository){
		this.employeRepository=employeRepository;}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("init employe....");

		employeRepository.save(new Employe("Ouedraogo","Aristide","a@a.com"));
		employeRepository.save(new Employe("Ouedraogo","Aristide","b@b.com"));
		employeRepository.save(new Employe("Ouedraogo","Aristide","c@c.com"));
	    
	   
	   
		}

	


	


}*/
