package kafka.fun.clients.consumer;

import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer {

    private final KafkaConsumer<String, String> consumer;
    private final String topic;

    public Consumer(String servers, String groupId, String topic){
        this.consumer = new KafkaConsumer<String, String>(

        )
    }

    public void run(IProducer producer){

    }

}
