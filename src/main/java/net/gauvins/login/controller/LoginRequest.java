package net.gauvins.login.controller;

import net.gauvins.controller.HasNonce;

public class LoginRequest implements HasNonce {
  private String username;
  private String password;
  private String nonce;
  private String sessionId;

  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  @Override
  public String getNonce() {
    return nonce;
  }

  @Override
  public void setNonce(final String nonce) {
    this.nonce = nonce;
  }

  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(final String sessionId) {
    this.sessionId = sessionId;
  }

}
