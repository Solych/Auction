package com.auction.repository;

import com.auction.model.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface LotRepository extends JpaRepository<Lot, Integer> {

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM auction.lot WHERE auction.lot.OWNER_ID = ?1")
    Integer countAllByUserId(Integer userId);

    List<Lot>
    findByNameAndCategory_CategoryIdAndMinPriceAndCountryAndDealTypeAndUser_UserIdAndStepAndStateAndDescriptionAndSubcategory_SubcategoryId(String Name,
                                                                                                                                            Integer categoryId,
                                                                                                                                            Integer minPrice,
                                                                                                                                            String country,
                                                                                                                                            String dealType,
                                                                                                                                            Integer userId,
                                                                                                                                            Integer step,
                                                                                                                                            Byte state,
                                                                                                                                            String description,
                                                                                                                                            Integer subcategoryId);

    @Query(nativeQuery = true, value = "SELECT PICTURE FROM auction.lot INNER JOIN auction.pictures ON lot.LOT_ID= pictures.LOT_ID WHERE lot.LOT_ID = 108 LIMIT 1\n")
    Object getLot();

}
