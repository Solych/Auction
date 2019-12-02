package com.auction.service;

import com.auction.model.dto.PuttingLot;

public interface LotService {

    void putLot(PuttingLot lot, Integer userId);
}
