import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducerWithPartition {
    public static void main(String[] args) {
        String bootstrapServers = "localhost:9092";
        String topic = "my_topic";

        Properties properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServers);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(properties);

        try {
            for (int i = 0; i < 10; i++) {
                String message = "";
                if(i>=5) {
                    message = "Message from Producer 1 with partion 1 : " + i;
                    producer.send(new ProducerRecord<>(topic, 1, Integer.toString(i), message));
                }
                else {
                    message = "Message from Producer 1 with partition 0 : " + i;
                    producer.send(new ProducerRecord<>(topic, 0, Integer.toString(i), message));
                }
                System.out.println("Sent message: " + message);
                Thread.sleep(10000); // Optional: add a delay between messages
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}
