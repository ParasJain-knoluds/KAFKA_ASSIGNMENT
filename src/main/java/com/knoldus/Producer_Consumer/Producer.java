package com.knoldus.Producer_Consumer;

import java.util.*;

import com.knoldus.Model.DataModel;
import org.apache.kafka.clients.producer.*;

public class Producer {

    public static void main(String[] args){

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092,localhost:9093");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "com.knoldus.Serialisation.PSerializer");
        KafkaProducer<String, DataModel> kafkaProducer = new KafkaProducer<>(props);
        try {
            DataModel emp1 = new DataModel(1, "ParasJain", 22, "BTech");
            DataModel emp2 = new DataModel(2, "Mohit", 23, "BTech");
            DataModel emp3 = new DataModel(2, "Manas", 25, "M.C.A");

            kafkaProducer.send(new ProducerRecord<>("Employee", "EMP1", emp1));
            kafkaProducer.send(new ProducerRecord<>("Employee", "EMP2", emp2));
            kafkaProducer.send(new ProducerRecord<>("Employee", "EMP2", emp3));
            System.out.println("EmployeeProducer Completed.");
            kafkaProducer.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            kafkaProducer.close();
        }



    }
}