package com.pologames.hcmb.server.manager;

import com.pologames.hcmb.server.entity.Gamer;
import com.pologames.hcmb.server.entity.Player;
import com.pologames.hcmb.server.entity.PlayerCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.pologames.hcmb.server.pojo.PlayerCardUtils.createPlayerCard;

@Stateless
@Local
public class PlayerCardManager {
    private final static Logger LOG = LoggerFactory.getLogger(PlayerCardManager.class);

    @PersistenceContext(unitName = "hcmb")
    private EntityManager entityManager;

    @EJB
    private transient PlayerManager playerManager;

    public PlayerCard addNewPlayerCard(final int gamerID, final int minOvr, final int maxOvr) {
        final Gamer gamer = entityManager.find(Gamer.class, gamerID);
        final Player player = playerManager.getRandomPlayer(minOvr, maxOvr);

        final PlayerCard playerCard = createPlayerCard(gamer, player);

        entityManager.persist(playerCard);
        LOG.info("new PlayerCard was created = {}", playerCard);
        return playerCard;
    }


}
