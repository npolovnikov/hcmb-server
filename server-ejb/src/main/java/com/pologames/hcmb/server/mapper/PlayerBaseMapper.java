package com.pologames.hcmb.server.mapper;

import com.pologames.hcmb.server.entity.Player;
import com.pologames.hcmb.server.entity.PlayerCard;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jsr330")
public interface PlayerBaseMapper {
//    PlayerBaseMapper INSTANCE = Mappers.getMapper(PlayerBaseMapper.class);

    /**
     * Перенос характерисик {@link com.pologames.hcmb.server.entity.PlayerBase}
     * @param player Игрок
     * @return Карточка Игрока
     */
    PlayerCard playerToCardMap(Player player);
}
