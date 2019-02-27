package com.marom.recipe.repositories;

import com.marom.recipe.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository repository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescription() {

        Optional<UnitOfMeasure> unitOfMeasure = repository.findByDescription("Cup");

        assertThat(unitOfMeasure.get().getDescription(), is("Cup"));
    }

    @Test
    public void findByDescriptionPint() {

        Optional<UnitOfMeasure> unitOfMeasure = repository.findByDescription("Pint");
        assertThat(unitOfMeasure.get().getDescription(), is("Pint"));
    }
}
