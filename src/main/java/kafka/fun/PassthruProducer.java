package kafka.fun;

import org.apache.kafka.clients.producer.KafkaProducer;

/**
 * Created by ALEJANDRO on 09/11/2017.
 */
public class PassthruProducer implements IProducer {

    private final KafkaProducer <String, String> producer;
    private final String topic;

    public PassthruProducer(String servers, String topic){
        this.producer = new KafkaProducer(
                IProducer.createConfig(servers));
        this.topic = topic;
    }

    public void process(String message){

        System.out.println("--- escribiendo el evento: " + message);
        IProducer.write(this.producer, this.topic, message);
    }
}