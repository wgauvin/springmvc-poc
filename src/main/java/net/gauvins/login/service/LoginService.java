package net.gauvins.login.service;


public interface LoginService {

  public static enum Status {
    OK, INVALID_CREDENTIALS, SERVER_ERROR;
  }

  Status login(String user, String password);
}
