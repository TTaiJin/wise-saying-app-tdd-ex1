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

    public static String getTableDirPath() {
        return "db/test/wiseSaying";
    }

    public static String getRowFilePath(int id) {
        return getTableDirPath() + "/" + id + ".json";
    }

    public WiseSaying save(WiseSaying wiseSaying) {
        if (!wiseSaying.isNew()) {
            return wiseSaying;
        }
        int id = ++lastId;
        wiseSaying.setId(id);

        Map<String, Object> wiseSayingMap = wiseSaying.toMap();
        String jsonStr = Util.json.toString(wiseSayingMap);
        Util.file.set(getRowFilePath(wiseSaying.getId()), jsonStr);
        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public boolean deleteById(int id) {
        return Util.file.delete(getRowFilePath(id));
    }

    public Optional<WiseSaying> findById(int id) {
        String filePath = getRowFilePath(id);

        if (Util.file.notExists(filePath)) {
            return Optional.empty();
        }

        String jsonStr = Util.file.get(filePath, "");
        Map<String, Object> wiseSayingMap = Util.json.toMap(jsonStr);

        return Optional.of(new WiseSaying(wiseSayingMap));
    }
}
