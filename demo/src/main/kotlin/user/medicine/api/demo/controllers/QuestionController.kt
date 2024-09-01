package user.medicine.api.demo.controllers

import org.springframework.web.bind.annotation.*
import user.medicine.api.demo.dtos.QuestionUpdateDTO
import user.medicine.api.demo.models.Question
import user.medicine.api.demo.services.QuestionService

@RestController
@RequestMapping("/api/questions")
class QuestionController(
    private val questionService: QuestionService
) {

    @PostMapping("/create")
    fun create(@RequestBody question: Question): Question {
        return questionService.createQuestion(question)
    }

    @GetMapping("")
    fun getAllQuestions(): List<Question> {
        return questionService.getAllQuestions()
    }

    @GetMapping("/{id}")
    fun getQuestion(@PathVariable id: String): Question {
        return questionService.getQuestionById(id)
    }

    @PutMapping("/{id}")
    fun updateQuestion(@PathVariable id: String, @RequestBody updatedQuestion: QuestionUpdateDTO): Question {
        return questionService.updateQuestion(id, updatedQuestion)
    }

    @DeleteMapping("/{id}")
    fun deleteQuestion(@PathVariable id: String) {
        questionService.deleteQuestion(id)
    }
}