package com.dezsobinder.controller;

import com.dezsobinder.model.LedRegistry;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalOutputProvider;

import static com.pi4j.io.gpio.digital.DigitalState.LOW;

public class LedService {
    private final LedRegistry ledRegistry;

    public LedService(LedRegistry ledRegistry) {
        this.ledRegistry = ledRegistry;
    }

    public void registerLed(Context context, int pinAddress, String id) {
        DigitalOutputProvider digitalInputProvider = context.provider("pigpio-digital-output");
        var led =
                digitalInputProvider.create(DigitalOutput.newConfigBuilder(context).address(pinAddress).id(id).shutdown(LOW));
        ledRegistry.getLeds().add(led);
        System.out.println(led.getId() + "LED is now added to the registry");
    }

    public void turnAllOn() {
        ledRegistry.getLeds().forEach(DigitalOutput::high);
        System.out.println("Turning on all leds");
    }


    public void turnAllOff() {
        ledRegistry.getLeds().forEach(DigitalOutput::low);
        System.out.println("Turning off all leds");
    }

    public void lightUpLed(String ledId) {
        for (DigitalOutput led : ledRegistry.getLeds()) {
            if (led.getId().equals(ledId)) {
                led.high();
            } else {
                led.low();
            }
        }
    }


    public void blinkLeds() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            for (DigitalOutput led : ledRegistry.getLeds()) {
                led.toggle();
                Thread.sleep(50);
            }
        }
    }
}
