package com.ll.domain.wiseSaying.repository;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.List;
import java.util.Optional;

public interface WiseSayingRepository {

    WiseSaying save(WiseSaying wiseSaying);

    List<WiseSaying> findAll();

    boolean deleteById(int deleteId);

    Optional<WiseSaying> findById(int modifyId);
}
