package com.auction.repository;

import com.auction.model.User;
import com.auction.model.dto.ProfileCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO auction.user(USERNAME, PASSWORD, MAIL) VALUES(?1, ?2, ?3)", nativeQuery = true)
    void registerUser(String username, String password, String mail);

    List<User> findAllByUsernameOrMail(String username, String mail);

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    User findByTokenAndUserId(String token, Integer userId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE auction.user SET TOKEN = ?2 WHERE USER_ID = ?1", nativeQuery = true)
    void setToken(Integer userId, String token);

    @Transactional
    @Modifying
    @Query(value = "UPDATE auction.user SET TOKEN = null WHERE USER_ID = ?1", nativeQuery = true)
    void removeToken(Integer userId);

    @Query(value = "SELECT PROFILE as profile, COUNT(*) as count FROM user right join lot l on user.USER_ID = l.OWNER_ID WHERE USER_ID = ?1", nativeQuery = true)
    ProfileCount findCountByUserAndLots(Integer userId);

    @Transactional
    @Modifying
    @Query(value= "UPDATE auction.user SET ", nativeQuery = true)
    void updateUserInfo();

}
