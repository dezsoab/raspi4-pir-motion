package com.dezsobinder.model;

import com.pi4j.io.gpio.digital.DigitalOutput;

import java.util.ArrayList;
import java.util.List;

public class LedRegistry {
    private final List<DigitalOutput> leds;

    public LedRegistry() {
        this.leds = new ArrayList<>();
    }

    public List<DigitalOutput> getLeds() {
        return leds;
    }
}
