package testspring.processor;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

import java.util.function.Consumer;
import java.util.function.Supplier;

@FunctionalInterface
public interface MockProcessorStub<T extends Processor> extends Supplier<T> {

  default T processor() {
    return get();
  }

  default T with(final Consumer<Exchange> stub) {
    try {
      doAnswer((invocation) -> {
        final Exchange exchange = (Exchange) invocation.getArguments()[0];
        stub.accept(exchange);
        return null;
      }).when(processor()).process(any(Exchange.class));
    } catch (final Exception e) {
      // this is a stubbing exception.
      throw new RuntimeException(e);
    }

    return processor();
  }

  static <T extends Processor> MockProcessorStub<T> withProcessorType(final Class<T> clazz) {
    final T processor = mock(clazz);
    return () -> processor;
  }
}
