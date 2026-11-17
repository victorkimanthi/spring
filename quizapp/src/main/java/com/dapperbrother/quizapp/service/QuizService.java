package com.dapperbrother.quizapp.service;

import com.dapperbrother.quizapp.dao.QuestionDao;
import com.dapperbrother.quizapp.dao.QuizDao;
import com.dapperbrother.quizapp.model.Question;
import com.dapperbrother.quizapp.model.QuestionWrapper;
import com.dapperbrother.quizapp.model.Quiz;
import com.dapperbrother.quizapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestionsByCategoryIgnoreCase(category,numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for (Question question : questionsFromDB) {
            questionsForUser.add(new QuestionWrapper(question.getId(),question.getQuestionTitle(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4()));
        }

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int rightAnswers = 0;
        int i = 0;

        for(Response response : responses) {

            if(response.getResponse().equals(questions.get(i).getRightAnswer())){
                rightAnswers++;
                System.out.println("answer:"+questions.get(i).getRightAnswer()+" question:"+questions.get(i).getId()+"");
                i++;
            }
        }
        return new ResponseEntity<>(rightAnswers, HttpStatus.OK);
    }
}
