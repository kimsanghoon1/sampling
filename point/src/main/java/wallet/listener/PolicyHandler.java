package wallet.listener;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaHandler;
import wallet.service.PointService;

import wallet.dto.event.CouponPurchased;
import wallet.dto.event.CouponCancelled;

@Service
@KafkaListener(topics = "wallet", groupId = "point", containerFactory = "kafkaListenerContainerFactory",contentTypeConverter="smartMessageConverter")
public class PolicyHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(PolicyHandler.class);

    @Autowired PointService pointService;

    @KafkaHandler
    public void wheneverCouponPurchased_UsePoint(@Payload CouponPurchased couponPurchased, Acknowledgment acknowledgment,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey){

        
            


        // Sample Logic //
        // Point point = new Point();
        // pointService.save(point);
        
        acknowledgment.acknowledge();
        

    }
    @KafkaHandler
    public void wheneverCouponCancelled_CompensatePoint(@Payload CouponCancelled couponCancelled, Acknowledgment acknowledgment,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                                            @Nullable @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey){

        
            


        // Sample Logic //
        // Point point = new Point();
        // pointService.save(point);
        
        acknowledgment.acknowledge();
        

    }

    @KafkaHandler(isDefault = true)
    public void listenDefault(Object object, Acknowledgment acknowledgment) {
        System.out.println("[Info] Unhandled Event from Kafka broker: " + object.toString());
        acknowledgment.acknowledge();
    }

    


}