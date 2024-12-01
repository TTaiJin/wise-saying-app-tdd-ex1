package com.ll.domain.wiseSaying.service;

import com.ll.domain.wiseSaying.entity.WiseSaying;
import com.ll.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.List;
import java.util.Optional;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        this.wiseSayingRepository = new WiseSayingRepository();
    }

    public WiseSaying requireAdd(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(0, content, author);
        return wiseSayingRepository.save(wiseSaying);
    }

    public List<WiseSaying> requireList() {
        return wiseSayingRepository.findAll();
    }

    public boolean requireDelete(int deleteId) {
        return wiseSayingRepository.delete(deleteId);
    }

    public Optional<WiseSaying> findById(int modifyId) {
        return wiseSayingRepository.findById(modifyId);
    }

    public void requireModify(WiseSaying wiseSaying, String newContent, String newAuthor) {
        wiseSaying.setContent(newContent);
        wiseSaying.setAuthor(newAuthor);
        wiseSayingRepository.save(wiseSaying);
    }
}
