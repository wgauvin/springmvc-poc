package net.gauvins.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesViewResolver;

/**
 * Adding JavaDoc for next release
 * @author will
 *
 */
@Configuration
@EnableWebMvc
@Import(value = BaseConfiguration.class)
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

  @Bean
  public TilesViewResolver tilesViewResolver() {
    final TilesViewResolver resolver = new TilesViewResolver();
    resolver.setOrder(0);
    return resolver;
  }

  @Bean
  public InternalResourceViewResolver viewResolver() {
    final InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/jsp/");
    resolver.setSuffix(".jsp");
    resolver.setOrder(1);
    return resolver;
  }

  @Bean
  public TilesConfigurer tilesConfigurer() {
    final TilesConfigurer configurer = new TilesConfigurer();
    configurer.setDefinitions(new String[] { "/WEB-INF/tiles/tiles-definitions.xml" });
    configurer.setCheckRefresh(true);
    return configurer;
  }

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    registry.addResourceHandler("/img/**").addResourceLocations("/img/");
  }
}
