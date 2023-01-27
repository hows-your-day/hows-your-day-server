package com.project.howsyourday.diary.controller;

import com.project.howsyourday.diary.model.Diary;
import com.project.howsyourday.diary.repository.DiaryRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/diaries")
public class DiaryController {

    @Autowired
    DiaryRepository diaryRepository;

    @GetMapping
    public ResponseEntity<List<Diary>> getAllDiaries(@RequestParam(required = false) String title){
        try {
            List<Diary> diaries = new ArrayList<Diary>();

            if(title == null) diaryRepository.findAll().forEach(diaries::add);
            else diaryRepository.findByTitleLike(title).forEach(diaries::add);

            if(diaries.isEmpty()) return new ResponseEntity<>(HttpStatus.OK);

            return new ResponseEntity<>(diaries, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diary> getDiaryById(@PathVariable("id") Long id){
        Optional<Diary> diaryData = diaryRepository.findById(id);

        if(diaryData.isPresent()) return new ResponseEntity<>(diaryData.get(), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Diary> createDiary(@RequestBody Diary diary){
        try {
//            ToDo: 2023.01.15 to be continued
//            Diary diary1 = diaryRepository.save(new Diary(diary.getTitle(), diary.get))
            return null;
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
