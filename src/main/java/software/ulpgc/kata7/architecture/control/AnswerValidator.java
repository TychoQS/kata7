package software.ulpgc.kata7.architecture.control;

import software.ulpgc.kata7.architecture.model.Title;

public class AnswerValidator {
    public static boolean validate(String answer, Title title) {
        return answer.equals(String.valueOf(title.year()));
    }
}
