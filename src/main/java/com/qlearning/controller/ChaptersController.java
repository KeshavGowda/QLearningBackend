package com.qlearning.controller;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qlearning.models.Chapters;
import com.qlearning.models.Learning;
import com.qlearning.models.Question;
import com.qlearning.models.QuestionsAttempted;
import com.qlearning.models.UserTransaction;
import com.qlearning.models.Users;
import com.qlearning.repositories.ChapterRepository;
import com.qlearning.repositories.LearningRepository;
import com.qlearning.repositories.QuestionRepository;
import com.qlearning.repositories.UserTxnRepository;
import com.qlearning.repositories.UsersRepository;

@RestController()
@RequestMapping("/api")
public class ChaptersController {

	@Autowired
	private ChapterRepository cRepo;

	@Autowired
	private LearningRepository lRepo;

	@Autowired
	private QuestionRepository qRepo;

	@Autowired
	private UserTxnRepository usrTxnRepo;

	@Autowired
	private UsersRepository userRepo;

	@Autowired
	private PasswordEncoder encoder;

	@GetMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

	@GetMapping("/chapters")
	public List<Chapters> getChapters() {
		return cRepo.findAll();
	}

	@GetMapping(value = { "/learning", "/learning/{chapterid}" })
	public List<Learning> getLearning(@PathVariable Optional<Integer> chapterid) {
		if (chapterid.isPresent()) {
			return lRepo.findByChapterId(chapterid.get());
		} else {
			return lRepo.findAll();
		}
	}

	@GetMapping(value = { "/question/chapter={chapter_id}/question={question_id}" })
	public Question getQuestion(@PathVariable Optional<String> chapter_id, @PathVariable Optional<String> question_id) {
		// return qRepo.findByQuestionId(question_id.get());
		return qRepo.findByChapterIdAndQuestionId(Integer.parseInt(chapter_id.get()),
				Integer.parseInt(question_id.get()));
	}

	@PostMapping("/submitquiz")
	public HttpStatus submitQuiz(@RequestBody List<QuestionsAttempted> requestObject) {
		System.out.println("submit quiz called");
		try {
			UserTransaction userTxn = new UserTransaction();
			userTxn.setQuestions_attempted(requestObject);
			userTxn.setUser_id(99);
			userTxn.setLearning_id(0);
			userTxn.setLast_visited(new Timestamp(System.currentTimeMillis()));
			usrTxnRepo.save(userTxn);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.OK;
	}

	@PostMapping("/registerUser")
	public HttpStatus registerUser(@RequestBody Users user) {
		try {
			Users existingUser = userRepo.findByUsername(user.getUsername());
			String decoded = new String(Base64.getDecoder().decode(user.getPassword()));
			user.setPassword(encoder.encode(decoded));
			userRepo.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.OK;
	}

	@GetMapping(value = {"/toggleCompleted/{object_id}"})
	public void toggleCompleted(@PathVariable String object_id) {
		Learning learning = lRepo.findById(object_id).get();
		learning.setCompleted(!learning.isCompleted());
		lRepo.save(learning);
	}

}