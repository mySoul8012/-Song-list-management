package com.ming.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddSongSongTest {
    AddSongSong addSongSong = null;

    @Before
    public void setUp() throws Exception {
        addSongSong = new AddSongSong();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isAddSongSong() {
        assert addSongSong.isAddSongSong(3, 3);
    }
}