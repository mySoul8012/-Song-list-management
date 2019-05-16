package com.ming.service;

import com.ming.dao.pojo.FanySing;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class UpdateTest {
    private Update update = null;

    @Before
    public void setUp() throws Exception {
        update = new Update();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void idUpdate() {
        FanySing fanySing = new FanySing();
        fanySing.setId(0);
        fanySing.setName("ming");
        fanySing.setIssudate(new Date());
        fanySing.setLanguage("xiao");
        ArrayList<FanySing> fanySings = new ArrayList<>();
        fanySings.add(fanySing);
        fanySing = new FanySing();
        fanySing.setId(2);
        fanySing.setLanguage("xiaod");
        fanySing.setName("daming");
        fanySing.setLanguage("大");
        fanySings.add(fanySing);
        if(update.idUpdate(fanySings)){
            assert true;
            return;
        }

        assert false;
    }
}