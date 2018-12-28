package com.pologames.hcmb.server.manager;

import com.pologames.hcmb.server.entity.Player;
import com.pologames.hcmb.server.pojo.PlayerUtils;
import com.pologames.hcmb.server.pojo.PositionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.pologames.hcmb.server.pojo.PlayerUtils.*;

/**
 * Класс для управления игроками
 */
@Stateless
@Local
public class PlayerManager {
    private final static Logger LOG = LoggerFactory.getLogger(PlayerManager.class);

    @PersistenceContext(unitName = "hcmb")
    private EntityManager entityManager;

    public Player createRandomPlayer(int minOvr, int maxOvr) {
        LOG.info("createRandomPlayer: start. min = {}, max = {}", minOvr, maxOvr);
        final PositionEnum positionEnum = PositionEnum.random();
        LOG.info("Position: {}", positionEnum);

        final Player player;
        switch (positionEnum) {
            case G: player = createRandomG(minOvr, maxOvr); break;
            case D: player = createRandomD(minOvr, maxOvr); break;
            case L: player = createRandomL(minOvr, maxOvr); break;
            case R: player = createRandomR(minOvr, maxOvr); break;
            case C: player = createRandomC(minOvr, maxOvr); break;
            default: player = null;
        }
        player.setOvr(PlayerUtils.ovr(player, positionEnum));
        LOG.info("OVR: {}", player.getOvr());

        entityManager.persist(player);
        return player;
    }

    public List<Player> getAllPlayers() {
        final List<Player> players = entityManager.createQuery("select p from Player p")
                .getResultList();
        LOG.info("getAllPlayers: size = {}, players_Ovrs = {}", players.size(), players.stream()
                .map(Player::getOvr)
                .collect(Collectors.toList()));
        return players;
    }

    /**
     * Функция возвращает рандомного игрока таким образом, что шанс выпада minOvr выше чем шанс выпада maxOvr
     * @param minOvr минимальное значение ovr для поиска
     * @param maxOvr максимальное значение ovr для поиска
     * @return
     */
    public Player getRandomPlayer(int minOvr, int maxOvr) {
        final List<Player> playerList = entityManager.createQuery("select p from Player p where p.ovr between :minOvr and :maxOvr")
                .setParameter("minOvr", minOvr)
                .setParameter("maxOvr", maxOvr)
                .getResultList();

        final Player first = playerList.get(new Random().nextInt(playerList.size() - 1));
        final Player second = playerList.get(new Random().nextInt(playerList.size() - 1));
        return first.getOvr() <= second.getOvr() ? first : second;
    }
}
