package com.seabattle;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.annotation.Version;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetShipController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/set_ship")
    public Greeting setShip(@RequestParam(value="position", defaultValue="0") String position) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, position));
    }
}
