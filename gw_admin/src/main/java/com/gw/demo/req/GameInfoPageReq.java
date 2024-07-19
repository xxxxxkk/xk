package com.gw.demo.req;

import com.gw.base.req.BasePageReq;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 游戏信息分页接收
 * @author xk
 * @version 2024年7月17 下午14:15:11

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameInfoPageReq extends BasePageReq {

    private String gameName;

    private Integer status;

    private Integer type;
}
