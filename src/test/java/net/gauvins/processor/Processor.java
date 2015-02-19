package testspring.processor;

@FunctionalInterface
public interface Processor {

  void process(Exchange exchange) throws Exception;

}
