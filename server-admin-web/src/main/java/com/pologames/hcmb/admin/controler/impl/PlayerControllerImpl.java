package com.pologames.hcmb.admin.controler.impl;

import com.pologames.hcmb.admin.controler.PlayerController;
import com.pologames.hcmb.admin.dto.Filter;
import com.pologames.hcmb.server.manager.PlayerManager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PlayerControllerImpl implements PlayerController {

    @EJB
    private PlayerManager playerManager;

    @Override
    public Response getPlayerList(Filter filter) {
        final List<PlayerFake> playerFakeList = new ArrayList<>();
        for (int i=0; i<100; i++){
            playerFakeList.add(new PlayerFake("name-"+i, "country", i));
        }
        return Response.ok(playerFakeList).build();
    }

    @Override
    public String getStatus() {
        return "SUCCESS";
    }

    private class PlayerFake {
        private String name;
        private String country;
        private int ovr;

        public PlayerFake(String name, String country, int ovr) {
            this.name = name;
            this.country = country;
            this.ovr = ovr;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public int getOvr() {
            return ovr;
        }

        public void setOvr(int ovr) {
            this.ovr = ovr;
        }
    }

}
