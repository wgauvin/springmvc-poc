package testspring.processor;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MyTest extends BaseCamelTest {

  @Mock
  Processor processor;

  @Mock
  Exchange exchange;

  @Mock
  Message message;

  Message foo;

  @Before
  public void setup() {
    when(exchange.getIn()).thenReturn(message);
    foo = Mockito.mock(Message.class);
  }

  @Test
  public void foo() throws Exception {
    mockProcessor(processor).with((e) -> e.getIn().setBody("foo"));

    processor.process(exchange);

    verify(message).setBody("foo");
  }

  @Test
  public void bar() {
    final BarProcessor processor = this.mockProcessor(BarProcessor.class).with((e) -> e.getIn().setBody("bar"));

    processor.process(exchange);

    verify(message).setBody("bar");
  }
}
