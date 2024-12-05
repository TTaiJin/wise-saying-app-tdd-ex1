package com.ll.domain.wiseSaying.repository;

import com.ll.domain.wiseSaying.entity.WiseSaying;
import com.ll.standard.util.Util;

import java.util.*;

public class WiseSayingFileRepository implements WiseSayingRepository{
    private final List<WiseSaying> wiseSayings;
    private int lastId;

    public WiseSayingFileRepository() {
        this.wiseSayings = new ArrayList<>();
        this.lastId = 0;
    }

    public WiseSaying save(WiseSaying wiseSaying) {
        if (!wiseSaying.isNew()) {
            return wiseSaying;
        }
        int id = ++lastId;
        wiseSaying.setId(id);

        Map<String, Object> wiseSayingMap = wiseSaying.toMap();
        String jsonStr = Util.json.toString(wiseSayingMap);
        Util.file.set("db/test/wiseSaying/1.json", jsonStr);
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
