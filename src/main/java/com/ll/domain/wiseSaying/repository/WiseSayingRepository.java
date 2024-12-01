package com.ll.domain.wiseSaying.repository;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private final List<WiseSaying> wiseSayings;
    private int lastId;

    public WiseSayingRepository() {
        this.wiseSayings = new ArrayList<>();
        this.lastId = 0;
    }

    public WiseSaying save(WiseSaying wiseSaying) {
        if (!wiseSaying.isNew()) {
            return wiseSaying;
        }
        int id = ++lastId;
        wiseSaying.setId(id);
        wiseSayings.add(wiseSaying);
        return wiseSaying;
    }
}
