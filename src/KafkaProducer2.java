import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducer2 {
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
                String message = "Message from Producer 2 " + i;
                producer.send(new ProducerRecord<>(topic, Integer.toString(i), message));
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
