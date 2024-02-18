package streams.reactive.transforming;

import org.junit.Test;
import streams.reactive.domain.StockData;
import streams.reactive.domain.StocksPublisher;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.jayway.awaitility.Awaitility.await;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class StockTransformProcessorTest {

  @Test
  public void givenPublisher_whenSubscribeAndTransformElements_thenShouldConsumeAllElements() throws InterruptedException {
    //given
    StocksPublisher publisher = new StocksPublisher();
    StockTransformProcessor<String> transformProcessor
        = new StockTransformProcessor<>(StockData::getName);
    StockNameEndSubscriber subscriber =
        new StockNameEndSubscriber(3);
    List<StockData> items = List.of(
        new StockData("APP", 123.4F),
        new StockData("GOO", 123.4F));
    List<String> expectedResult = List.of("APP", "GOO");

    //when
    publisher.subscribe(transformProcessor);
    transformProcessor.subscribe(subscriber);
    items.forEach(publisher::submit);
    publisher.close();

    //then
    await().atMost(1000, TimeUnit.MILLISECONDS).until(
        () -> assertThat(subscriber.consumedElements)
            .containsExactlyElementsOf(expectedResult)
    );
  }

}
