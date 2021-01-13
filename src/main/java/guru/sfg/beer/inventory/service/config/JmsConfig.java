package guru.sfg.beer.inventory.service.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConfig {

    public static final String NEW_INVENTORY_QUEUE = "new-inventory-request";

    public static final String ALLOCATE_ORDER_RESULT = "allocate-order-result";
    public final static String ALLOCATE_ORDER = "allocate-order";
    public static final String CANCEL_ORDER = "cancel-order";

    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper){

        MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
        messageConverter.setTargetType(MessageType.TEXT);

        /*HashMap<String, Class<?>> typeIdMappings = new HashMap<>();
        typeIdMappings.put("com.maleki.narges.msscbeerservice.events.NewInventoryEvent", NewInventoryEvent.class);
        messageConverter.setTypeIdMappings(typeIdMappings);*/


        messageConverter.setTypeIdPropertyName("_type");
        messageConverter.setObjectMapper(objectMapper);
        return messageConverter;
    }
}
