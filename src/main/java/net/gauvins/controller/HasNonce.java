package net.gauvins.controller;

/**
 * Used in controller requests that have a nonce.
 * @author will
 *
 */
public interface HasNonce {
  String getNonce();

  // comment
  void setNonce(String nonce);
}
