package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

/**
 * @author leandrosoares
 */
@ApplicationScoped
public class ExampleRepository implements PanacheRepository<ExampleEntity> {

    @Override
    public List<ExampleEntity> listAll() {
          List<ExampleEntity> a = ExampleEntity.<ExampleEntity> findAll().list();
          return a;
    }

}
