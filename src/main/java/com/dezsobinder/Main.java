package com.dezsobinder;

import com.dezsobinder.controller.InputService;
import com.dezsobinder.controller.LedService;
import com.dezsobinder.model.LedRegistry;
import com.pi4j.Pi4J;
import com.pi4j.io.gpio.digital.DigitalInput;
import com.pi4j.util.Console;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var pi4j = Pi4J.newAutoContext();

        DigitalInput input = new InputService().createInput(pi4j);

        LedService ledService = new LedService(new LedRegistry());
        ledService.registerLed(pi4j, 20, "green");
        ledService.registerLed(pi4j, 21, "red");

        ledService.blinkLeds();

        input.addListener(e -> {
            if (e.state().isHigh()) {
                ledService.lightUpLed("red");
            } else {
                ledService.lightUpLed("green");
            }
        });

        new Console().waitForExit();
    }
}
