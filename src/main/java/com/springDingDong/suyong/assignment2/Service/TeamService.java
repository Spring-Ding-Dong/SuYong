package com.springDingDong.suyong.assignment2.Service;

import com.springDingDong.suyong.assignment2.Entity.Player;
import com.springDingDong.suyong.assignment2.Entity.Team;
import com.springDingDong.suyong.assignment2.Repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public Long signUpTeam(Team team) {
        teamRepository.signUpTeam(team);
        return team.getId();
    }

    @Transactional(readOnly = true)
    public List<Player> findPlayersByTeam(Long teamId) { return teamRepository.findPlayersByTeam(teamId); }

    public int updateManager(Long teamId, String newManager) {
        return teamRepository.updateManager(teamId, newManager);
    }

}
