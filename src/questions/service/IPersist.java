package questions.service;

import questions.model.Question;

public interface IPersist<E> {
    void addQuestion(E question);
    void addQuestion(String text,String ans1,String ans2,String ans3,String ans4,String right_ans,String sign,int style);
    void setQuestionText(int id,String text);
    void setQuestionans(int id,int index,String ans);
    void setQuestionRightAns(int id,String right_ans);
    void setQuestionStyle(int id,int style);
    void setQuestion(E question);
    void deleteQuestion(int id);
}
