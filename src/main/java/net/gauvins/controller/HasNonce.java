package net.gauvins.controller;

/**
 * Used in controller requests that have a nonce.
 * @author will
 *
 */
public interface HasNonce {
  String getNonce();

  void setNonce(String nonce);
}
