package net.gauvins.controller;

import java.io.Serializable;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NonceHandler implements Serializable {

  private static final long serialVersionUID = -5041359022218162315L;
  private static final Logger LOGGER = LoggerFactory.getLogger(NonceHandler.class);

  private String nonce;

  public String getNonce() {
    if (nonce == null) {
      nonce = UUID.randomUUID().toString();
      LOGGER.debug("Created nonce {}", nonce);
    }
    return nonce;
  }

  public boolean verifyNonce(final HasNonce hasNonce) {
    if (nonce == null) {
      return false;
    } else {
      return nonce.equals(hasNonce.getNonce());
    }
  }

  public void resetNonce() {
    LOGGER.debug("Resetting nonce.");
    nonce = null;
  }
}
