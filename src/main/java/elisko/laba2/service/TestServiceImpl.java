package elisko.laba2.service;

import elisko.laba2.dao.QuestionDao;
import elisko.laba2.domain.Question;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Component
public class TestServiceImpl implements TestService {
    private final QuestionDao questionDao;

    private int result = 0;

    public TestServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public void test() throws IOException {
        List<Question> questionPack = questionDao.getQuestionPack();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < questionPack.size(); i++) {
            Question question = questionPack.get(i);
            System.out.println("Вопрос №"+(i + 1)+": "+ question.getQuestionText());
            for (int j = 0; j < question.getAnswers().size(); j++) {
                System.out.println("Ответ №"+ (j + 1)+": "+ question.getAnswers().get(j));
            }
            System.out.println("Введите номер правильного ответа.");


            if (scanner.hasNextInt() && scanner.nextInt() == question.getCorrectAnswerNumber()) {
                result = result + 1;
                System.out.println("Верно.");
            } else {
                System.out.println("Ошибка.");
            }

        }
        System.out.println("Ваш результат: " + result+" из 5");
    }

}
