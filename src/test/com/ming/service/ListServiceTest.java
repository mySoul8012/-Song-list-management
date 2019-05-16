package com.ming.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListServiceTest {
    private ListService listService = null;

    @Before
    public void setUp() throws Exception {
        listService = new ListService();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getList() {
        assert listService.getList(0) != null;
        assert listService.getList(1) != null;
        System.out.println(listService.getPages());
    }

}