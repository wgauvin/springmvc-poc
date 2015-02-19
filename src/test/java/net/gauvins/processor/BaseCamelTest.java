package testspring.processor;

import static testspring.processor.MockProcessorStub.withProcessorType;

public class BaseCamelTest {

  protected <T extends Processor> MockProcessorStub<T> mockProcessor(final T processor) {
    return () -> processor;
  }

  protected <T extends Processor> MockProcessorStub<T> mockProcessor(final Class<T> processorClass) {
    return withProcessorType(processorClass);
  }

}
