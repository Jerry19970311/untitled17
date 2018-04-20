package questions.service;

import questions.model.Question;

import java.util.List;

public class SelectService extends AbstractDao implements ISelect<Question>{
    @Override
    public Question getQuestionById(int id) {
        try {
            return questionMapper.getQuestionById(id);
        }catch (Exception e) {
            //(输出错误信息)
            return null;
        }
    }

    @Override
    public List<Question> getQuestions() {
        try {
            return questionMapper.getQuestions();
        }catch (Exception e) {
            //(输出错误信息)
            return null;
        }
    }
}
