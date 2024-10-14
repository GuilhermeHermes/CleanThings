package com.guilhermehermes.cleanthings.application.usecases.simulate_freight;

import com.guilhermehermes.cleanthings.domain.entities.Item;
import com.guilhermehermes.cleanthings.domain.valueobjects.DefaultFreightCalculator;
import com.guilhermehermes.cleanthings.repositories.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class SimulateFreightTest {

    @Mock
    ItemRepository itemRepository;

    private SimulateFreight simulateFreight;

    private SimulateFreightInput input;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        simulateFreight = new SimulateFreight(itemRepository, new DefaultFreightCalculator());
        input = new SimulateFreightInput();
    }

    @Test
    void shouldSimulateFreightOfItems(){
        Item item = new Item("Item 1", 10.0, 10.0, 10.0, 10.0, 10.0);
        Item item2 = new Item("Item 2", 20.0, 20.0, 20.0, 20.0, 20.0);
        Item item3 = new Item("Item 3", 30.0, 30.0, 30.0, 30.0, 30.0);

        when(itemRepository.findById(item.getId())).thenReturn(Optional.of(item));
        when(itemRepository.findById(item2.getId())).thenReturn(Optional.of(item2));
        when(itemRepository.findById(item3.getId())).thenReturn(Optional.of(item3));

        input.items = List.of(item, item2, item3);

        var output = simulateFreight.simulate(input);

        assertEquals(900.0, output.total);
    }

}