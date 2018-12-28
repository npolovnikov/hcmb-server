package com.pologames.hcmb.server.manager;

import com.pologames.hcmb.server.entity.Gamer;
import com.pologames.hcmb.server.entity.GamerStatistic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Local
public class GamerManager {
    private final static Logger LOG = LoggerFactory.getLogger(GamerManager.class);

    @PersistenceContext(unitName = "hcmb")
    private EntityManager entityManager;

    public Gamer createNewGamer(final String nickname) {
        final Gamer gamer = new Gamer();
        gamer.setStatistics(new GamerStatistic());
        gamer.setNickname(nickname);
        gamer.setStadiumId(0);

        entityManager.persist(gamer);
        LOG.info("gamer was created = {}", gamer);
        return gamer;
    }

    public Gamer removeGamer(final int id) {
        final Gamer gamer = entityManager.find(Gamer.class, id);

        entityManager.remove(gamer);
        LOG.info("gamer was removed = {}", gamer);
        return gamer;
    }

}
