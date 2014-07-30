package net.gauvins.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Servlet 3.0 auto configuration.
 * @author will
 *
 */
public class WebInitialiser implements WebApplicationInitializer {

  @Override
  public void onStartup(final ServletContext servletContext) throws ServletException {
    final AnnotationConfigWebApplicationContext appCtx = new AnnotationConfigWebApplicationContext();
    appCtx.register(SpringMvcConfig.class);

    servletContext.addListener(new ContextLoaderListener(appCtx));

    final ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(appCtx));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/*");
  }

}
