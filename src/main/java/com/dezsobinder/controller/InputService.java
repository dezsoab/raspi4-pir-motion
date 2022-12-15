package com.dezsobinder.controller;

import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalInput;
import com.pi4j.io.gpio.digital.DigitalInputProvider;
import com.pi4j.io.gpio.digital.PullResistance;

public class InputService {

    public DigitalInput createInput(Context context) {
        var config = DigitalInput.newConfigBuilder(context)
                .address(27)
                .pull(PullResistance.PULL_DOWN)
                .build();
        DigitalInputProvider digitalInputProvider = context.provider("pigpio-digital-input");
        var input = digitalInputProvider.create(config);
        return input;
    }
}
