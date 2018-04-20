package questions.service;

import questions.model.Question;

import java.util.List;

public interface ISelect<E> {
    //查找：根据序号查找单个题目。
    E getQuestionById(int id);
    //查找：将题库里面所有的题目取出，数据结构为List。
    List<E> getQuestions();
}
