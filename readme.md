This is simple java based kafka communication project.
**Pre requisite**
1. JAVa 17
2. down load following jars (Add it as external dependency to project)
   1. kafka-clients-2.8.0.jar 
   2. org.slf4j.slf4j-api1.7.32.jar   
   3. ch.qos.logback.logback-classic.jar
3. File->project structure->libraries-> Add (+)-> add library.

**NOTE**
 we may experience the path too long error while starting zookeeper and kafka server, so solve this creates a bat file put in a directory\
 so we can start easily.
refer below files in the root diretoty and change the path accordingly.
 Start servers in below order
   1. zookeeper-start.bat
   2. kafka-server.bat



**Step 1: Set Up a Kafka Topic**
bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic my_topic

**Step 2: Write a Kafka Producer**
   a.you can write multiple Producers to publish multiple messages
      i. KafkaProducer1.java
      ii. KafkaProducer2.java
     Above two classes having only **Topic** but not defined the *partitions*
   b. Below classes are having partitions defined in the topic. So you can observe the consumers always, 
      one consumer hold one partition of a topic and other hold the another partition of the topic.

**Step 3: Write a Kafka Consumer**
   a.you can write multiple Consumers to consume messages. if it is **not partitioned all messages goes to only one Consumer.**
      i. KafkaConsumer1.java
      ii. KafkaConsumer2.java