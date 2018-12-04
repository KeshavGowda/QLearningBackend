package com.qlearning.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qlearning.models.Chapters;
import com.qlearning.models.Learning;
import com.qlearning.repositories.ChapterRepository;
import com.qlearning.repositories.LearningRepository;

@RestController()
@RequestMapping("/api")
public class ChaptersController {
	
	@Autowired
	private ChapterRepository cRepo;
	
	@Autowired
	private LearningRepository lRepo;
	
	@GetMapping("/chapters")
	public List<Chapters> getChapters() {
		return cRepo.findAll();
	}
	
	@GetMapping(value= {"/learning", "/learning/{chapterid}"})
	public List<Learning> getLearning(@PathVariable Optional<Integer> chapterid) {
		if(chapterid.isPresent()) {
			return lRepo.findByChapterId(chapterid.get());
		}
		else {
			return lRepo.findAll();
		}
	}

}