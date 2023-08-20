package com.example.demo.lec09_databinding;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(Event.class, new EventEditor());
    }

    @GetMapping("/event/{event}")
    public String getEvent(@PathVariable Event event) {
        System.out.println("event = " + event);
        return event.getId().toString();
    }

    @GetMapping("/event/new/{event}")
    public String getEvent(@PathVariable EventNew event) {
        System.out.println("eventNew = " + event);
        return event.getId().toString();
    }

}
