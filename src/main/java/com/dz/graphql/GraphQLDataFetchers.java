package com.dz.graphql;

import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class GraphQLDataFetchers {

    private List<Node> nodes = IntStream
            .range(0,100)
            .boxed()
            .map(String::valueOf)
            .map(s -> new Node() {{
                setId(s);
                setName("Node_" + s);
            }})
            .collect(Collectors.toList());


    public DataFetcher<Node> getNodeByIdFetcher() {
        return environment -> {
            String id = environment.getArgument("id");

            return nodes
                    .stream()
                    .filter(node -> node.getId().equals(id))
                    .findFirst()
                    .orElseThrow();
        };
    }

    public DataFetcher<List<Unit>> getUnitsFetcher() {
        return environment -> {
            Node node = environment.getSource();
            return List.of(new Unit() {{
                setId(UUID.randomUUID().toString());
                setSlot(new Random().nextInt(32));
            }}, new Unit() {{
                setId(UUID.randomUUID().toString());
                setSlot(new Random().nextInt(32));
            }});
        };
    }

    public DataFetcher<List<Port>> getPortsFetcher() {
        return environment -> List.of(new Port() {{
            setId(UUID.randomUUID().toString());
            setIsUp(true);
            setName("Name: " + UUID.randomUUID().toString());
            setNumber(new Random().nextInt());
        }});
    }
}
