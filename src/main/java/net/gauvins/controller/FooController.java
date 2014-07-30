package net.gauvins.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controls login process.
 * @author will
 *
 */
@Controller
public class FooController {

  @RequestMapping(method = RequestMethod.GET, value = "/foo.do")
  public String get() {
    return "foo";
  }

}
