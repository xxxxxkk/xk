package com.gw.demo.entity.dto.vo;

import com.gw.demo.entity.dto.GamePlayInfos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GamePlayVo {
    private Long merchantId;
    private List<GamePlayInfos> gamePlayInfos;
}
