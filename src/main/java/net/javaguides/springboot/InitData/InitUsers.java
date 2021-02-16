
/*package net.javaguides.springboot.InitData;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import net.javaguides.springboot.entity.Role;
import net.javaguides.springboot.entity.User2;
import net.javaguides.springboot.repository.RoleRepository;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.util.RoleEnum;

@Component
@Order(2)
public class InitUsers implements ApplicationRunner {
	
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	
	public InitUsers(UserRepository userRepository,RoleRepository roleRepository){
		this.userRepository=userRepository;
		this.roleRepository=roleRepository;}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("init users....");
		
		
	   
	   
	   
	    
	   
	    
	    Role roleUser=roleRepository.findByName(RoleEnum.ROLE_USER.getName());
	    Role roleAdmin=roleRepository.findByName(RoleEnum.ROLE_ADMIN.getName());
	    
	    User2 user=new User2("user","Aristide12",true);
	    user.setRoles(Arrays.asList(roleUser));
	    
	    userRepository.save(user);
	    
	    User2 admin=new User2("admin","2885351Aristide12",true);
	    admin.setRoles(Arrays.asList(roleUser,roleAdmin));
	    
	    userRepository.save(admin);
		}

	


}*/
