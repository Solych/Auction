package com.auction.service.implementation;

import com.auction.exceptions.ConstraintViolationException;
import com.auction.exceptions.UserNotFoundException;
import com.auction.model.dto.*;
import com.google.gson.JsonObject;
import com.auction.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.auction.repository.UserRepository;
import com.auction.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final String USER_NOT_FOUND = "User with this credentials not found";

    @Autowired private UserRepository userRepository;
    @Autowired private EntityManagerFactory entityManagerFactory;

    public JsonObject save(UserForRegistration newUser) {
        JsonObject jsonObject = new JsonObject();
        try {
            userRepository.registerUser(newUser.getUsername(), newUser.getPassword(), newUser.getMail());
            Integer id = userRepository.findByUsername(newUser.getUsername()).getUserId();
            jsonObject.addProperty("id", id);
            jsonObject.addProperty("success", true);
            return jsonObject;
        } catch (Exception ex) {
            jsonObject.addProperty("success", false);
            List<User> users = userRepository.findAllByUsernameOrMail(newUser.getUsername(), newUser.getMail());
            if (users.size() > 1 || (users.get(0).getMail().equals(newUser.getMail())
                                        && users.get(0).getUsername().equals(newUser.getUsername()))) {
               jsonObject.addProperty("isMail", true);
               jsonObject.addProperty("isUsername", true);
               return jsonObject;
            }
            if (users.get(0).getMail().equals(newUser.getMail())) {
               jsonObject.addProperty("isMail", true);
               jsonObject.addProperty("isUsername", false);
            } else {
                jsonObject.addProperty("isMail", false);
                jsonObject.addProperty("isUsername", true);
            }
            return jsonObject;
        }
    }

    public Integer login(Admission admission) throws UserNotFoundException {
        User user = userRepository.findByUsernameAndPassword(admission.getUsername(), admission.getPassword());
        if(user == null) {
            throw new UserNotFoundException(USER_NOT_FOUND);
        }
        return user.getUserId();
    }

    public boolean isCanPutLots(Integer userId) {
        try {
            ProfileCount profileCount = userRepository.findCountByUserAndLots(userId);
            return profileCount.getProfile().equals("BUSINESS") || profileCount.getCount() < 20;
        } catch (Exception ex) {
            return false;
        }
    }

    public void setHash(Hash hash) {
        userRepository.setToken(hash.getUserId(), hash.getHash());
    }

    public void removeHash(Integer userId) {
        userRepository.removeToken(userId);
    }

    public void updateUserInfo(UserUpdate userUpdate) throws ConstraintViolationException {
        User user = userRepository.findById(userUpdate.getUserId())
                .orElseThrow(() -> new ConstraintViolationException("Not found by id"));
        if (userUpdate.getCountry() != null) {
            user.setCountry(userUpdate.getCountry());
        }
        if(userUpdate.getName() != null) {
            user.setName(userUpdate.getName());
        }

        if(userUpdate.getSurname() != null) {
            user.setSurname(userUpdate.getSurname());
        }

        if(userUpdate.getPatronymic() != null) {
            user.setPatronymic(userUpdate.getPatronymic());
        }

        if(userUpdate.getCity() != null) {
            user.setCity(userUpdate.getCity());
        }

        if(userUpdate.getPhone() != null) {
            user.setPhone(userUpdate.getPhone());
        }
        try{
            userRepository.saveAndFlush(user);
        } catch (Exception ex) {
            throw new ConstraintViolationException("Phone");
        }

        if(userUpdate.getMail() != null) {
            user.setMail(userUpdate.getMail());
        } else {
            return;
        }

        try {
            userRepository.saveAndFlush(user);
        } catch (Exception ex) {
            throw new ConstraintViolationException("Mail");
        }

    }

}
