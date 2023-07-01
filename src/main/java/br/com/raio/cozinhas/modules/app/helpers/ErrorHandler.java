package br.com.raio.cozinhas.modules.app.helpers;

import org.springframework.http.HttpStatus;

public class ErrorHandler extends Error {
  private HttpStatus status;
  private String message;

  public ErrorHandler(String message, HttpStatus status) {
    this.message = message;
    this.status = status;
  }

  public HttpStatus getStatus() {
    return this.status;
  }

  public String getMessage() {
    return this.message;
  }

}
