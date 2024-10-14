package com.guilhermehermes.cleanthings.application.usecases.simulate_freight;

import com.guilhermehermes.cleanthings.domain.entities.Item;
import com.guilhermehermes.cleanthings.domain.valueobjects.FreightCalculator;
import com.guilhermehermes.cleanthings.repositories.ItemRepository;


public class SimulateFreight {

    private ItemRepository itemRepository;
    private FreightCalculator freightCalculator;

    public SimulateFreight(ItemRepository itemRepository, FreightCalculator freightCalculator) {
        this.itemRepository = itemRepository;
        this.freightCalculator = freightCalculator;
    }

    public SimulateFreightOutput simulate(SimulateFreightInput input) {
        Double amount = 0.0;
        for(Item InputItem : input.items){
            var Item = itemRepository.findById(InputItem.getId());
            if(Item.isEmpty()){
             throw new RuntimeException("Item not found");
            }
            amount += freightCalculator.calculate(Item.get());

        }

        SimulateFreightOutput output = new SimulateFreightOutput(amount);
        return output;
    }
}
