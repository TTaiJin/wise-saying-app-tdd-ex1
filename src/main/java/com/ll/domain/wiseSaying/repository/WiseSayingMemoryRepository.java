package com.ll.domain.wiseSaying.repository;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WiseSayingMemoryRepository implements WiseSayingRepository{
    private final List<WiseSaying> wiseSayings;
    private int lastId;

    public WiseSayingMemoryRepository() {
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

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public boolean deleteById(int deleteId) {
        return wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == deleteId);
    }

    public Optional<WiseSaying> findById(int modifyId) {
        return wiseSayings.stream()
                .filter(wiseSaying -> wiseSaying.getId() == modifyId)
                .findFirst();
    }
}
