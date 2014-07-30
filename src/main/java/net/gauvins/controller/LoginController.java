package net.gauvins.controller;

import java.util.EnumMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.gauvins.model.Credentials;
import net.gauvins.service.LoginService;
import net.gauvins.service.LoginService.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controls login process.
 * @author will
 *
 */
@Controller
public class LoginController {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

  private final LoginService loginService;
  private final NonceHandler nonceHandler;

  private final Map<Status, LoginStatusHandler> loginStatusHandlers = new EnumMap<>(Status.class);

  @Autowired
  public LoginController(final LoginService loginService, final NonceHandler nonceHandler) {
    this.loginService = loginService;
    this.nonceHandler = nonceHandler;

    loginStatusHandlers.put(Status.OK, new OkLoginStatusHandler());
    loginStatusHandlers.put(Status.INVALID_CREDENTIALS, new InvalidLoginStatusHandler());
    loginStatusHandlers.put(Status.SERVER_ERROR, new ErrorLoginStatusHandler());
  }

  @ModelAttribute("credentials")
  public Credentials getCredentials() {
    return new Credentials();
  }

  @ModelAttribute("nonce")
  public String getNonce() {
    return nonceHandler.getNonce();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/signin.do")
  public String get() {
    return ".signin";
  }

  @RequestMapping(method = RequestMethod.GET, value = "/loggedin.do")
  public String loggedin(final ModelMap model) {
    model.addAttribute("text", "You're logged in");
    return ".loggedin";
  }

  @RequestMapping(method = RequestMethod.POST, value = "/signin.do")
  public @ResponseBody LoginResponse login(@RequestBody final LoginRequest loginRequest, final HttpServletRequest request) {
    LOGGER.debug("In login");
    final LoginResponse response;
    if (nonceHandler.verifyNonce(loginRequest) && request.getSession().getId().equals(loginRequest.getSessionId())) {
      final Status status = loginService.login(loginRequest.getUsername(), loginRequest.getPassword());

      final LoginStatusHandler handler = loginStatusHandlers.get(status);
      response = handler.handle(loginRequest);
    } else {
      response = new LoginResponse();
      response.setStatus(ResponseStatus.ERROR);
      response.setMessage("Invalid request");
    }
    return response;
  }

  private interface LoginStatusHandler {
    LoginResponse handle(LoginRequest request);
  }

  private class OkLoginStatusHandler implements LoginStatusHandler {

    @Override
    public LoginResponse handle(final LoginRequest request) {
      // reset nonce
      nonceHandler.resetNonce();

      final LoginResponse response = new LoginResponse();
      response.setStatus(ResponseStatus.OK);
      response.setMessage("Thanks for logging in " + request.getUsername());
      return response;
    }

  }

  private class InvalidLoginStatusHandler implements LoginStatusHandler {

    @Override
    public LoginResponse handle(final LoginRequest request) {
      final LoginResponse response = new LoginResponse();
      response.setStatus(ResponseStatus.ERROR);
      response.setMessage("User name and/or password not correct.");
      return response;
    }

  }

  private class ErrorLoginStatusHandler implements LoginStatusHandler {

    @Override
    public LoginResponse handle(final LoginRequest request) {
      final LoginResponse response = new LoginResponse();
      response.setStatus(ResponseStatus.ERROR);
      response.setMessage("There was an error in processing your request.  Please try again.");
      return response;
    }

  }
}
