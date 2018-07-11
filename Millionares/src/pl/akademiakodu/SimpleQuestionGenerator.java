package pl.akademiakodu;

import pl.akademiakodu.Question;
import pl.akademiakodu.QuestionGenerator;

import java.util.ArrayList;
import java.util.List;

//klase która implementuje interfejs, Dzięki temu może być traktowana, jako typ SimpleQuestGeneratoe

public class SimpleQuestionGenerator implements QuestionGenerator {
    List<Question> questionList = new ArrayList<>();
//Implementacja tej metody
    @Override
    public List<Question> generateQuestions() {
        List<Question> questionList = new ArrayList<>();


        questionList.add(new
                Question("Czy Polska leży w Europie", true));

        questionList.add(new
                Question("Czy Polska leży w Europie", true));

        questionList.add(new
                Question("Czy 2+5=7>", false));

        questionList.add(new
                Question("Czy 2^10 = 1024?", true));

        questionList.add(new
                Question("Czy Chopin urodził się w Warszawie", false));

        questionList.add(new
                Question("Czy 2+5=8?", false));

        questionList.add(new
                Question("Czy 2^10=1024?", true));

        questionList.add(new
                Question("Czy Chopin urodził się w Warszawie?", false));
        return questionList;
    }
}

