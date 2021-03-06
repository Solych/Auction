package com.auction.repository;

import com.auction.model.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;
import java.util.List;

public interface ThingRepository extends JpaRepository<Lot, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM auction.THING WHERE OWNER_ID = ?1")
    List<Lot> findAllByOwnerId(Integer userId);

    @Query(nativeQuery = true, value = "SELECT * FROM auction.THING WHERE TIME_FOR_SELLING > ?1 LIMIT 24")
    List<Lot> findRandom24(Date now);

    @Query(nativeQuery = true, value =
            "SELECT * FROM auction.thing WHERE TIME_FOR_SELLING > ?1 AND CATEGORY_ID = ?2 LIMIT ?3, 24")
    List<Lot> findByCategoryPageable(Date now, Integer categoryId, Integer page);

    @Query(nativeQuery = true, value = "SELECT * FROM auction.THING WHERE THING.THING_ID = ?1")
    Lot findByThingId(Integer thingId);

    @Query(nativeQuery = true, value = "SELECT * FROM auction.THING where auction.THING.NAME LIKE ?1 AND TIME_FOR_SELLING > ?2")
    List<Lot> getThingsByNameLike(String name, Date now);

    @Query(nativeQuery = true, value = "SELECT * FROM auction.THING ORDER BY RAND() LIMIT 1")
    Lot getRandomIdOfThing();

    @Query(nativeQuery = true, value = "SELECT MAX(PRICE) as price FROM auction.FACT_OVERRIDE WHERE THING_ID = ?1")
    Integer getLastPrice(Integer thingId);

    @Query(nativeQuery = true, value = "SELECT * FROM auction.THING WHERE THING.TIME_FOR_SELLING < ?1 AND MESSAGE IS NULL")
    List<Lot> getExpired(Date now);

    @Query(nativeQuery = true, value = "SELECT * FROM THING INNER JOIN auction.FACT_OVERRIDE ON FACT_OVERRIDE.THING_ID = THING.THING_ID WHERE FACT_OVERRIDE.BUYER_ID = ?1")
    List<Lot> getUserBets(Integer userId);
}
