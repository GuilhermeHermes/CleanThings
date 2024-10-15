package com.guilhermehermes.cleanthings.infra.controller;

import com.guilhermehermes.cleanthings.application.usecases.place_order.PlaceOrder;
import com.guilhermehermes.cleanthings.application.usecases.place_order.PlaceOrderInput;
import com.guilhermehermes.cleanthings.application.usecases.place_order.PlaceOrderOutput;
import com.guilhermehermes.cleanthings.infra.factory.RepositoryFactory;
import com.guilhermehermes.cleanthings.infra.factory.RepositoryFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Validated
public class PlaceOrderController {

    PlaceOrder placeOrder;



    public PlaceOrderController(PlaceOrder placeOrder){
        this.placeOrder = placeOrder;
    }

    @PostMapping
    public ResponseEntity<PlaceOrderOutput> placeOrder(@RequestBody PlaceOrderInput placeOrderInput) {
        PlaceOrderOutput placeOrderOutput = placeOrder.execute(placeOrderInput);
        return ResponseEntity.ok(placeOrderOutput);

    }

}
