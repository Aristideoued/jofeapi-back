
/*package net.javaguides.springboot.InitData;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import net.javaguides.springboot.entity.Role;
import net.javaguides.springboot.repository.RoleRepository;
import net.javaguides.springboot.util.RoleEnum;

@Component
@Order(1)
public class InitRoles implements ApplicationRunner {
	
	private final RoleRepository roleRepository;
	
	public InitRoles(RoleRepository roleRepository){
		this.roleRepository=roleRepository;}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("init roles....");
	
	    
	   
	    Role roleUser=roleRepository.findByName(RoleEnum.ROLE_USER.getName());
	    if(roleUser==null) {
	    	roleUser=new Role(RoleEnum.ROLE_USER);
	    	 roleRepository.save(roleUser);
	    }
	    
	    Role roleAdmin=roleRepository.findByName(RoleEnum.ROLE_ADMIN.getName());
	    if(roleAdmin==null) {
	    	roleAdmin=new Role(RoleEnum.ROLE_ADMIN);
	    	 roleRepository.save(roleAdmin);
	    }
	     
	   
	    
	  
		}

	


	


}*/
