package com.auction.service;

import com.auction.exceptions.ConstraintViolationException;
import com.auction.exceptions.UserNotFoundException;
import com.auction.model.dto.Hash;
import com.auction.model.dto.UserUpdate;
import com.google.gson.JsonObject;
import com.auction.model.dto.Admission;
import com.auction.model.dto.UserForRegistration;

public interface UserService {
    JsonObject save(UserForRegistration user);
    Integer login(Admission admission) throws UserNotFoundException;
    boolean isCanPutLots(Integer userId);
    void setHash(Hash hash);
    void removeHash(Integer userId);
    void updateUserInfo(UserUpdate userUpdate) throws ConstraintViolationException;
}
