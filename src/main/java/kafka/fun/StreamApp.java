package kafka.fun;

import kafka.fun.clients.consumer.Consumer;

import java.util.Random;

/**
 * Created by ALEJANDRO on 09/11/2017.
 */
public class StreamApp {

    public static void main(String args[]){

        String servers = "localhost:9092";
        String groupId = "ulp-ch03-3.3";
        String inTopic = "raw-events";
        String goodTopic = "eventos-prueba";

        //Consumer consumer = new Consumer(servers, groupId, inTopic);
        PassthruProducer producer = new PassthruProducer(
                servers, goodTopic);
        //consumer.run(producer);

        Random random = new Random();


        for(int i =  0; i<1000000 ; i++){
            producer.process("---mensaje prueba:" + random.nextInt());
        }

        /**
        while(true){
            producer.process("---mensaje prueba:" + random.nextInt());
        }
         */



        /**
        Consumer consumer = new Consumer(servers,groupId,inTopic);
        FullProducer producer = new FullProducer(servers,goodTopic,inTopic);
        consumer.run(producer);
         */
    }
}
