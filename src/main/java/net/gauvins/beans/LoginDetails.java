package net.gauvins.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoginDetails {

  private String user;
  private String password;

  public String getUser() {
    return this.user;
  }

  public void setUser(final String user) {
    this.user = user;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

}
