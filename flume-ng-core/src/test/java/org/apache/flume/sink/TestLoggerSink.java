package org.apache.flume.sink;

import org.apache.flume.core.Context;
import org.apache.flume.core.MessageDeliveryException;
import org.apache.flume.core.util.EventBuilder;
import org.apache.flume.lifecycle.LifecycleException;
import org.junit.Before;
import org.junit.Test;

public class TestLoggerSink {

  private LoggerSink sink;

  @Before
  public void setUp() {
    sink = new LoggerSink();
  }

  /**
   * Lack of exception test.
   */
  @Test
  public void testAppend() throws InterruptedException, LifecycleException,
      MessageDeliveryException {

    Context context = new Context();

    sink.open(context);

    for (int i = 0; i < 10; i++) {
      sink.append(context, EventBuilder.withBody("Test " + i));
    }

    sink.close(context);
  }

}