package com.hp.one.controller;

import com.hp.one.model.Userr;
import com.hp.one.repo.UserRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@RestController
//@SpringBootApplication
public class MainController {
        @Autowired // This means to get the bean called userRepository
        // Which is auto-generated by Spring, we will use it to handle the data
        private UserRepository userRepository;

        @PostMapping(path="/add") // Map ONLY POST Requests
        public @ResponseBody String addNewUser (@RequestParam String name
                , @RequestParam String email) {
            // @ResponseBody means the returned String is the response, not a view name
            // @RequestParam means it is a parameter from the GET or POST request

            Userr n = new Userr();
            n.setName(name);
            n.setEmail(email);
            userRepository.save(n);
            return "Saved";
        }

        @GetMapping(path="/all")
        public @ResponseBody Iterable<Userr> getAllUsers() {
            // This returns a JSON or XML with the users
            //
            return userRepository.findAll();
        }

    @GetMapping(path="/al")
    public List<Userr> printPersonInfo() {
        List<Userr> list = new ArrayList<>();
        userRepository.findAll().forEach(list::add);
        return list;
    }



    @RequestMapping("/user")
    public String home(){
        return "Y Y Y Y Y Y Y Y Y Y Y";
    }

}
