package com.pologames.hcmb.server.manager;

import com.pologames.hcmb.server.entity.Gamer;
import com.pologames.hcmb.server.entity.Player;
import com.pologames.hcmb.server.entity.PlayerCard;
import com.pologames.hcmb.server.entity.PlayerStatistic;
import com.pologames.hcmb.server.mapper.PlayerBaseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Local
public class PlayerCardManager {
    private final static Logger LOG = LoggerFactory.getLogger(PlayerCardManager.class);

    @PersistenceContext(unitName = "hcmb")
    private EntityManager entityManager;

    @EJB
    private PlayerBaseMapper mapper;

    @EJB
    private transient PlayerManager playerManager;

    public PlayerCard addNewPlayerCard(final int gamerID, final int minOvr, final int maxOvr) {
        final Gamer gamer = entityManager.find(Gamer.class, gamerID);
        final Player player = playerManager.getRandomPlayer(minOvr, maxOvr);

        final PlayerCard playerCard = mapper.playerToCardMap(player);
        playerCard.setGamer(gamer);
        playerCard.setPlayer(player);
        playerCard.setStatistics(new PlayerStatistic());

        entityManager.persist(playerCard);
        LOG.info("new PlayerCard was created = {}", playerCard);
        return playerCard;
    }
}
