package com.jw.api.v1;

import com.jw.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1")
public class UserController {

    private List<User> users = new ArrayList<>();

    @GetMapping("/user")
    @ResponseBody
    public Optional<User> getUser(@RequestParam String email) {
        return users.stream().filter(x -> x.getEmail().equals(email)).findAny();
    }

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void postMessage(@RequestBody User user) {
        users.add(user);
    }

}
