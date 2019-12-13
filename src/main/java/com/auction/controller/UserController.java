package com.auction.controller;

import ch.qos.logback.classic.Logger;
import com.auction.exceptions.ConstraintViolationException;
import com.auction.exceptions.UserNotFoundException;
import com.auction.model.dto.Hash;
import com.auction.model.dto.UserUpdate;
import com.google.gson.JsonObject;
import com.auction.model.dto.Admission;
import com.auction.model.dto.UserForRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.auction.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
@CrossOrigin(origins = {"*"})
@RequestMapping("/user/")
public class UserController {

    @Autowired private UserService userService;
    @Autowired private Logger logger;
    @Autowired private HttpServletRequest servletRequest;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody Admission admission) {
        JsonObject jsonObject = new JsonObject();
        logger.debug("login" + servletRequest.getRemoteAddr());
        try {
            Integer userId = userService.login(admission);
            jsonObject.addProperty("success", true);
            jsonObject.addProperty("id", userId);
            return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
        } catch (UserNotFoundException ex) {
            jsonObject.addProperty("success", false);
            jsonObject.addProperty("reason", ex.getMessage());
            return new ResponseEntity<>(jsonObject.toString(), HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody UserForRegistration user) {
        JsonObject jsonObject = userService.save(user);
        logger.debug("register" + servletRequest.getRemoteAddr());
        return new ResponseEntity<>(jsonObject.toString(), jsonObject.has("id") ?
                HttpStatus.OK : HttpStatus.CONFLICT);
    }

    @GetMapping("canPut/{id}")
    public ResponseEntity<Boolean> canPut(@PathVariable Integer id){
        logger.debug("canPut" + servletRequest.getRemoteAddr());
        return new ResponseEntity<>(userService.isCanPutLots(id) ,HttpStatus.OK);
    }

    @PostMapping("setHash")
    public ResponseEntity<?> setHash(@RequestBody Hash hash) {
        userService.setHash(hash);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("removeHash/{userId}")
    public ResponseEntity<?> removeHash(@PathVariable Integer userId) {
        userService.removeHash(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("updateUserInfo")
    public ResponseEntity<?> updateUserInfo(@RequestBody UserUpdate userUpdate) {

        try {
            userService.updateUserInfo(userUpdate);
        } catch (ConstraintViolationException ex) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("reason", ex.getMessage());
            return new ResponseEntity<>(jsonObject.toString(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("getUserInfo/{userId}")
    public ResponseEntity<?> getUserInfo(@PathVariable Integer userId) {
        try {
            return new ResponseEntity<>(userService.getUserInfo(userId), HttpStatus.OK);
        } catch (UserNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
