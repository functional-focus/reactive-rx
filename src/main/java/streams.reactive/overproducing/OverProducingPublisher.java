package streams.reactive.overproducing;

import streams.reactive.domain.StockData;

import java.util.UUID;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class OverProducingPublisher extends SubmissionPublisher<StockData> {

  public void start() {
    Stream<StockData> stockDataStream = Stream
        .generate(() ->
            new StockData(
                UUID.randomUUID().toString(),
                ThreadLocalRandom.current().nextFloat()
            )
        );


    stockDataStream.limit(100_000).forEach(this::submit);
  }


}
