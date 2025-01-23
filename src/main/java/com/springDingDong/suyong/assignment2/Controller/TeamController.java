package com.springDingDong.suyong.assignment2.Controller;

import com.springDingDong.suyong.assignment2.Entity.Player;
import com.springDingDong.suyong.assignment2.Entity.Team;
import com.springDingDong.suyong.assignment2.Service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    // 팀 등록
    @PostMapping("/sign-up")
    public Long signUpTeam(@RequestBody Team team) {
        teamService.signUpTeam(team);
        return team.getId();
    }

    // 팀 선수단 조회
    @GetMapping("/{teamId}")
    public ResponseEntity<List<Player>> getPlayersByTeam(@PathVariable("teamId") Long teamId) {
        List<Player> players = teamService.findPlayersByTeam(teamId);
        return ResponseEntity.ok(players);
    }

    // 팀 감독 수정
    @PatchMapping("/{teamId}/manager")
    public ResponseEntity<String> updateManager(@PathVariable("teamId") Long teamId, @RequestParam String newManager) {
        try {
            teamService.updateManager(teamId, newManager);
            return ResponseEntity.ok("감독 교체 성공!");
        } catch(IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
