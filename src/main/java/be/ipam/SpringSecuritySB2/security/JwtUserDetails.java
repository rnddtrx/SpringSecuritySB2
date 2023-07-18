package be.ipam.SpringSecuritySB2.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


// User Spring qui implémente l'interface USerDetails
public class JwtUserDetails implements UserDetails {

  private static final long serialVersionUID = 5155720064139820502L;

  private final String username;
  private final String password;
  private final Collection<? extends GrantedAuthority> authorities;

  public JwtUserDetails(String username, String password, List<String> roles) {
    this.username = username;
    this.password = password;

    List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
    for(String r:roles) {
    	authorities.add(new SimpleGrantedAuthority(r));
    }

    this.authorities = authorities;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @JsonIgnore
  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}


