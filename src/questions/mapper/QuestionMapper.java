package questions.mapper;

import questions.model.Memory;
import questions.model.Question;

import java.util.List;

public interface QuestionMapper {
    //增加：序号和时间戳系统自动生成，根据其它8项信息插入新的题目。
    void addQuestion(String text,String ans1,String ans2,String ans3,String ans4,String right_ans,String sign,int style);
    //查找：根据序号查找单个题目。
    Question getQuestionById(int id);
    //查找：将题库里面所有的题目取出，数据结构为List。
    List<Question> getQuestions();
    //修改：以下3个方法均调用的是数据库中的存储过程来修改某处信息。
    //（序号和时间戳不可修改）
    void setQuestionText(int id,String text);
    void setQuestionans(int id,int index,String ans);
    void setQuestionRightAns(int id,String right_ans);
    //修改：使用UPDATE语句修改某个题目的题型。（1为单选题，2为多选题。）
    void setQuestionStyle(int id,int style);
    //删除：删除序号为id的题目。
    void deleteQuestion(int id);
    void addMemory(Memory memoryModel);
}
