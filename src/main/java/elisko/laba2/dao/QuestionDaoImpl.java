package elisko.laba2.dao;

import elisko.laba2.domain.Question;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class QuestionDaoImpl implements QuestionDao {

    @Override
    public List<Question> getQuestionPack() throws IOException {
        List<Question> questionsPack = new ArrayList<>();
        List<String> questionFromFile = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(QuestionDaoImpl.class.getClassLoader().getResourceAsStream("test.csv"), StandardCharsets.UTF_8));
        String line = "";
        while ((line = br.readLine()) != null) {
            questionFromFile.add(line);
        }
        for (int i = 1; i < questionFromFile.size(); i++) {
            String[] qs = questionFromFile.get(i).split(";");
            Question question = new Question(qs[0], Integer.parseInt(qs[1]), Arrays.asList(qs[2], qs[3], qs[4], qs[5]));
            questionsPack.add(question);
        }
        return questionsPack;
    }


}

