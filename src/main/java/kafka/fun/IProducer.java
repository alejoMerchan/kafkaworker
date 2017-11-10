package kafka.fun;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Created by ALEJANDRO on 08/11/2017.
 */
public interface IProducer {

    public void process(String message);

    public static void write(KafkaProducer<String, String> producer,
                             String topic,String message){
        ProducerRecord<String, String> pr = new ProducerRecord(topic,message);
        producer.send(pr);
    }

    public static Properties createConfig(String servers) {
        Properties props = new Properties();
        props.put("bootstrap.servers", servers);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 1000);
        props.put("linger.ms", 1);
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }

}