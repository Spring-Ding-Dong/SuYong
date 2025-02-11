package com.springDingDong.suyong.assignment3.repository;

import com.springDingDong.suyong.assignment2.Entity.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlayerRepository {

    @PersistenceContext
    private final EntityManager em;

    @Transactional
    public void contractPlayer(Player player) {
        em.persist(player);
    }

    public Player findOne(Long playerId) {
        return em.find(Player.class, playerId);
    }

    public List<Player> findAll() {
        return em.createQuery("select p from Player p", Player.class)
                .getResultList();
    }

    public List<Player> findByName(String name) {
        return em.createQuery("select p from Player p where p.name = :name", Player.class)
                .setParameter("name", name)
                .getResultList();
    }

    public int updateBackNumber(Long playerId, int newBackNumber) {
        return em.createQuery("update Player p set p.backNumber = :newBackNumber where p.id = :playerId")
                .setParameter("playerId", playerId)
                .setParameter("newBackNumber", newBackNumber)
                .executeUpdate();
    }

    public int releasePlayer(Long playerId) {
        return em.createQuery("delete from Player p where p.id = :playerId")
                .setParameter("playerId", playerId)
                .executeUpdate();

    }
}
