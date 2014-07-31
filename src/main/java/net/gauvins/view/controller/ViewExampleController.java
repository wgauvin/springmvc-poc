package net.gauvins.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This is an controller to show the use of different view resolver, calling with "/view/jsp"
 * will return a JSP based view, but calling with "/view/tiles" the view returned will be a
 * Tiles based view.
 * @author will
 *
 */
@Controller
@RequestMapping("/view")
public class ViewExampleController {

  @RequestMapping(method = RequestMethod.GET, value = "/jsp")
  public String returnJspView() {
    return "helloworld";
  }

  @RequestMapping(method = RequestMethod.GET, value = "/tiles")
  public String returnTilesView() {
    return ".helloworld";
  }

}
