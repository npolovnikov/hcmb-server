package com.pologames.hcmb.server.pojo;

import com.pologames.hcmb.server.entity.Gamer;
import com.pologames.hcmb.server.entity.Player;
import com.pologames.hcmb.server.entity.PlayerCard;
import com.pologames.hcmb.server.mapper.PlayerBaseMapper;

public class PlayerCardUtils {
    public static PlayerCard createPlayerCard(Gamer gamer, Player player){
        final PlayerCard playerCard = PlayerBaseMapper.INSTANCE.playerToCardMap(player);
        playerCard.setGamer(gamer);
        playerCard.setPlayer(player);
        return playerCard;
    }
}
