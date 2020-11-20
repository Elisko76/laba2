package elisko.laba2.dao;


import elisko.laba2.domain.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionDao {
    List<Question> getQuestionPack() throws IOException;
}
