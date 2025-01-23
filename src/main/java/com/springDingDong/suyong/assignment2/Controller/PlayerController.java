package com.springDingDong.suyong.assignment2.Controller;

import com.springDingDong.suyong.assignment2.Entity.Player;
import com.springDingDong.suyong.assignment2.Service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping("/contract")
    public Long contractPlayer(@RequestBody Player player) {
        System.out.println("계약을 진행합니다.");
        playerService.contractPlayer(player);
        return player.getId();
    }

    // 선수 단건 조회
    @GetMapping("/{playerId}")
    public ResponseEntity<Player> getPlayer(@PathVariable("playerId") Long playerId) {
        Player player = playerService.findPlayer(playerId);
        if (player != null) {
            return ResponseEntity.ok(player);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // 선수 전체 조회
    @GetMapping("/all")
    public ResponseEntity<List<Player>> getPlayers() {
        List<Player> players = playerService.findPlayers();
        return ResponseEntity.ok(players);
    }

    // 선수 등번호 수정
    @PatchMapping("/{playerId}/back-number")
    public ResponseEntity<String> updateBackNumber(
            @PathVariable("playerId") Long playerId,
            @RequestParam int newBackNumber) {
        try {
            playerService.updateBackNumber(playerId, newBackNumber);
            return ResponseEntity.ok("등번호가 성공적으로 수정되었습니다.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 선수 방출
    @DeleteMapping("/{playerId}")
    public ResponseEntity<String> releasePlayer(@PathVariable Long playerId) {
        playerService.releasePlayer(playerId);
        return ResponseEntity.ok("선수 방출 성공");
    }

}
