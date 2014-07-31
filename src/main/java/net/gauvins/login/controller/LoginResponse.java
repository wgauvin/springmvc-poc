package net.gauvins.login.controller;

import net.gauvins.controller.HasResponseStatus;
import net.gauvins.controller.ResponseStatus;

public class LoginResponse implements HasResponseStatus {

  private ResponseStatus status = ResponseStatus.OK;
  private String message;

  @Override
  public ResponseStatus getStatus() {
    return status;
  }

  public void setStatus(final ResponseStatus status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }
}
