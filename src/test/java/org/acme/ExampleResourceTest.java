package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import lombok.experimental.Delegate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ExampleResourceTest {

    //@Inject
    //ExampleRepositoryWrapper exampleRepository;

    @Test
    public void getList() {
        List<?> list = CDI.current().select(ExampleRepository.class).get().listAll();
        Assertions.assertTrue(Objects.nonNull(list) && list.size() > 0);
    }


    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/example/hello")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }



    // Workaround to fix https://github.com/quarkusio/quarkus/issues/1724.
    // This only works if using PanacheRepositoryBase

    /*@ApplicationScoped
    @Transactional
    static class ExampleRepositoryWrapper {
        @Inject
        @Delegate
        ExampleRepository exampleRepository;
    }*/

}