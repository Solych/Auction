package com.auction.controller;

import ch.qos.logback.classic.Logger;
import com.auction.model.dto.PuttingLot;
import com.auction.repository.LotRepository;
import com.auction.service.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/lot/")
public class LotController {
    @Autowired private LotService lotService;
    @Autowired private Logger logger;
    @Autowired private LotRepository lotRepository;

    @PostMapping("put")
    public ResponseEntity<?> putLot(@RequestBody PuttingLot lot,
                                    HttpServletRequest httpServletRequest,
                                    @RequestHeader("user") Integer userId ) {
        logger.debug("Put lot" + httpServletRequest.getRemoteAddr());
        lotService.putLot(lot, userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("get")
    public ResponseEntity<?> getLot() {
        return new ResponseEntity<Object>(lotRepository.getLot(), HttpStatus.OK);

    }
}
