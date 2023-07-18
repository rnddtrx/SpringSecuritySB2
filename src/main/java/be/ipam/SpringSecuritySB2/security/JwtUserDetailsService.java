package be.ipam.SpringSecuritySB2.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import be.ipam.SpringSecuritySB2.model.UserApp;
import be.ipam.SpringSecuritySB2.service.AppUserService;


@Service
public class JwtUserDetailsService implements UserDetailsService {

  private static final Logger log = LoggerFactory.getLogger(JwtUserDetailsService.class);
	
  @Autowired
  AppUserService userSer;


  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

	 
	  Optional<JwtUserDetails> user = Optional.empty();
	  //Ici normalement je récupère le user selon le paramètre login
	  Optional<UserApp> userapp = Optional.of(userSer.generateDummyUserToto());
	  

	  if(userapp.isPresent()) {
		UserApp ua = userapp.get();
		log.info("FOUND " + ua.getLogin());
		List<String> rolelist = new ArrayList<String>();
		rolelist.add(ua.getRole());
		
		//Ici je crée un user spring sur base de mon UserApp
		user = Optional.of(new JwtUserDetails(ua.getLogin(),ua.getHashedPassword(),rolelist));

	  }
	  
	  //if(pat.isPresent()) {
		//  user = Optional.of(new JwtUserDetails(pat.get().getId(),pat.get().getMail(),pat.get().getPw(),"ROLE_PATIENT")); 
	  //}
	  
	  //Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
      //  .filter(u -> u.getUsername().equals(username)).findFirst();
	  

	  if (user.isEmpty()) {
		  throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", login));
	  }

	  //LOG
	  log.info("My pass is "+user.get().getPassword());
	  
	  return user.get();
  }

}