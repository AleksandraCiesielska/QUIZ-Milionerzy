package pl.akademiakodu;

import pl.akademiakodu.Question;

import java.util.List;
//interfejs
public interface QuestionGenerator {
//metoda która ma zwracać nam listę pytań w jakiś sposób
        List<Question> generateQuestions();
}
