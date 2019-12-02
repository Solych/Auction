package com.auction.service.implementation;

import ch.qos.logback.classic.Logger;
import com.auction.model.*;
import com.auction.model.dto.PuttingLot;
import com.auction.repository.*;
import com.auction.service.LotService;
import com.auction.utils.LotComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LotServiceImpl implements LotService {

    @Autowired private UserRepository userRepository;
    @Autowired private CategoryRepository categoryRepository;
    @Autowired private LotRepository lotRepository;
    @Autowired private CategorySubcategoryRepository categorySubcategoryRepository;
    @Autowired private PicturesRepository picturesRepository;
    @Autowired private Logger logger;

    public void putLot(PuttingLot potentialLot, Integer userId) {
        Lot newLot = new Lot();
        Category category = new Category();
        User user = new User();
        Date dateOfPut = new Date();
        List<CategorySubcategory> categorySubcategoryList =
                categorySubcategoryRepository.getAllByCategory_CategoryId(potentialLot.getCategoryIndex());
        newLot.setSubcategory(categorySubcategoryList.get(potentialLot.getSubcategoryIndex()).getSubcategory());
        category.setCategoryId(potentialLot.getCategoryIndex());
        user.setUserId(userId);

        newLot.setCategory(category);
        newLot.setUser(user);
        newLot.setName(potentialLot.getName());
        newLot.setCountry(potentialLot.getCountry());
        newLot.setStep(potentialLot.getStep());
        newLot.setMinPrice(potentialLot.getMinPrice());
        newLot.setDescription(potentialLot.getDescription());
        newLot.setDealType(potentialLot.getDealType());
        newLot.setState(potentialLot.getState());
        if (newLot.getDealType().equals("ON_A_MIN_BID")) {
            newLot.setPriceForSelling(potentialLot.getPriceForSelling());
        }
        if (potentialLot.getOptionalField() != null) {
            newLot.setFilter(potentialLot.getOptionalField());
        }
        newLot.setDateOfPut(dateOfPut);
        newLot.setSellDate(potentialLot.getSellDate());

        lotRepository.saveAndFlush(newLot);
        List<Lot> lots = lotRepository.
                findByNameAndCategory_CategoryIdAndMinPriceAndCountryAndDealTypeAndUser_UserIdAndStepAndStateAndDescriptionAndSubcategory_SubcategoryId(newLot.getName(),
                        newLot.getCategory().getCategoryId(),
                        newLot.getMinPrice(),
                        newLot.getCountry(),
                        newLot.getDealType(),
                        userId,
                        newLot.getStep(),
                        newLot.getState(),
                        newLot.getDescription(),
                        newLot.getSubcategory().getSubcategoryId());
        if(lots.size() > 1) {
            Collections.sort(lots, new LotComparator());
        }
        List<Pictures> picturesList = new ArrayList<>();
        newLot.setLotId(lots.get(0).getLotId());
        for(String photo: potentialLot.getPhotos()) {
            Pictures pictures = new Pictures();
            pictures.setPicture(photo);
            pictures.setLot(newLot);
            picturesList.add(pictures);
        }
        picturesRepository.saveAll(picturesList);
    }
}
