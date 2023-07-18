package be.ipam.SpringSecuritySB2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import be.ipam.SpringSecuritySB2.model.UserApp;

@Service
public class AppUserService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	//Pour retourner un user de l'application. Ici je n'ai pas de db donc je crée un user toto avec mot de passe toto.
	//J'utilise cet utilisateur dans le JwtUserDetailsService
    public UserApp generateDummyUserToto() {
        UserApp user = new UserApp("Toto", "Dummy", passwordEncoder.encode("toto"), "toto", "toto@example.com", "USER");
        return user;
    }
	
}
