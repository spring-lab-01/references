package com.lab01.spring.backend;

import org.springframework.stereotype.Component;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

import java.util.Optional;

@Component
public class DynamoDBService {
    public final String tableName = "visitor_counter";
    public final String recordId = "1001";

    private DynamoDbClient getClient() {
        Region region = Region.US_EAST_1;
        return DynamoDbClient.builder()
                .region(region)
                .build();
    }

    private DynamoDbEnhancedClient enhancedClient() {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(getClient())
                .build();
    }

    // Get counter value from database , save incremented and return incremented.
    public Integer incrementAndReturnCounter() {
        // get counter
        Counter counter = getCounterFromDynamoDB();
        //increment counter
        if (counter == null) {
            throw new RuntimeException("Counter not available");
        }
        counter.incrementCounter();
        //save counter
        saveCounter(counter);
        //return current value
        return counter.getCounter();
    }

    private Counter getCounterFromDynamoDB() {
        try {
            DynamoDbTable<Counter> table = enhancedClient().table(tableName, TableSchema.fromBean(Counter.class));
            Optional<Counter> counterOptional = table.scan().items().stream().filter(c -> c.getCounter_id().equals(recordId)).findFirst();
            Counter counter;
            if (counterOptional.isEmpty()) {
                counter = new Counter(recordId, 0);
            } else {
                counter = counterOptional.get();
            }
            return counter;
        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    private void saveCounter(Counter counter) {
        try {
            DynamoDbTable<Counter> table = enhancedClient().table(tableName, TableSchema.fromBean(Counter.class));
            table.putItem(counter);
        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
        }
    }
}
