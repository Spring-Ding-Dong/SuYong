package com.springDingDong.suyong.assignment2.Repository;

import com.springDingDong.suyong.assignment2.Entity.Player;
import com.springDingDong.suyong.assignment2.Entity.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TeamRepository {

    @PersistenceContext
    private final EntityManager em;

    @Transactional
    public void signUpTeam(Team team) {
       em.persist(team);
    }

    @Transactional(readOnly = true)
    public List<Player> findPlayersByTeam(Long teamId) {
        return em.createQuery(
                "select p from Player p where p.team.id = :teamId", Player.class)
                .setParameter("teamId", teamId)
                .getResultList();
    }

    public int updateManager(Long teamId, String newManager) {
        return em.createQuery("update Team t set t.manager = :newManager where t.id = :teamId")
                .setParameter("teamId", teamId)
                .setParameter("newManager", newManager)
                .executeUpdate();
    }
}
