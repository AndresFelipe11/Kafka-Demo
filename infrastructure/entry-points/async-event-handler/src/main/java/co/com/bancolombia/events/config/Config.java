package co.com.bancolombia.events.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.reactivecommons.async.kafka.config.RCKafkaConfig;
import org.reactivecommons.async.kafka.config.props.RCAsyncPropsKafka;
import org.reactivecommons.async.kafka.config.props.RCKafkaProps;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
@Configuration
public class Config {

    @Bean
    @Primary
    public RCAsyncPropsKafka kafkaProps() throws IOException {
        RCAsyncPropsKafka kafkaProps = new RCAsyncPropsKafka();
        kafkaProps.setCreateTopology(true);
        kafkaProps.setMaxRetries(5);
        kafkaProps.setRetryDelay(1000);
        kafkaProps.setWithDLQRetry(true);
        kafkaProps.setKafkaProps(RCKafkaConfig.readPropsFromDotEnv(Path.of(".env")));
        return kafkaProps;
    }
}
