package org.example;

import org.example.controller.UserController;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
    private Map<String, Controller> mappings;

    public HandlerMapping() {
        mappings = new HashMap<String, Controller>();
        mappings.put("/user.do", new UserController());
    }

    public Controller getController(String path) {
        return mappings.get(path);
    }
}
