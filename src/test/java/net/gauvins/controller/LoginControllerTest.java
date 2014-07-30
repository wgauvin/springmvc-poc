package net.gauvins.controller;

import static org.junit.Assert.assertEquals;
import net.gauvins.service.LoginService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

  LoginController controller;

  @Mock
  LoginService loginService;

  @Mock
  NonceHandler nonceHandler;

  @Before
  public void setup() {
    controller = new LoginController(loginService, nonceHandler);
  }

  @Test
  public void getRequestShouldReturn_signin() {
    final String result = controller.get();

    assertEquals(".signin", result);
  }

  @Test
  public void loggedinShouldReturn_loggedin() {
    final String result = controller.loggedin(new ModelMap());

    assertEquals(".loggedin", result);
  }
}
