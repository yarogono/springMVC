package org.example;

import org.example.controller.UserController;

import java.util.HashMap;
import java.util.Map;

// Dispatcher Servlet으로 들어온 모든 요청을 각각의 Controller로 위임하는 역할
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
