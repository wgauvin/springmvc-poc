package net.gauvins.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

  public Status login(final String user, final String password) {
    LOGGER.info("Logging in {} with password {}", user, password);
    if (user.equals("invalid")) {
      return Status.INVALID_CREDENTIALS;
    } else if (user.equals("error")) {
      return Status.SERVER_ERROR;
    }
    return Status.OK;
  }

  public static enum Status {
    OK, INVALID_CREDENTIALS, SERVER_ERROR;
  }
}
