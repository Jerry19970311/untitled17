package questions.service;

import questions.model.Question;

public class PersistService extends AbstractDao implements IPersist<Question>{
    @Override
    public void addQuestion(Question question) {
        addQuestion(question.getText(),question.getAns1(),question.getAns2(),question.getAns3(),question.getAns4(),question.getRight_ans(),question.getSign(),question.getStyle());
    }

    @Override
    public void addQuestion(String text, String ans1, String ans2, String ans3, String ans4, String right_ans, String sign, int style) {
        if(null==text||0==text.length()){
            logger.error("题目内容为空");
            return;
        }
        if(null==ans1||0==ans1.length()){
            logger.error("A选项为空");
            return;
        }
        if(null==ans2||0==ans2.length()){
            logger.error("B选项为空");
            return;
        }
        if(null==right_ans||0==right_ans.length()){
            logger.error("正确答案为空");
            return;
        }
        if(null==sign||0==sign.length()){
            logger.error("唯一标识为空");
            return;
        }
        if (!styleEffective(style)) {
            logger.error("题型号无效");
            return;
        }
        if(null==ans3||0==ans3.length()) {
            questionMapper.addQuestion(text, ans1, ans2, null, null, right_ans, sign, style);
        }else if(null==ans4||0==ans4.length()){
            questionMapper.addQuestion(text, ans1, ans2, ans3, null, right_ans, sign, style);
        }else{
            questionMapper.addQuestion(text, ans1, ans2, ans3, ans4, right_ans, sign, style);
        }
        logger.info("题目添加成功！");
    }

    @Override
    public void setQuestionText(int id, String text) {
        if(null==text||0==text.length()){
            logger.info("题目修改失败：题目为空");
            return;
        }
        questionMapper.setQuestionText(id,text);
    }

    @Override
    public void setQuestionans(int id, int index, String ans) {
        if(null==ans||0==ans.length()){
            return;
        }
        questionMapper.setQuestionans(id,index,ans);
    }

    @Override
    public void setQuestionRightAns(int id, String right_ans) {
        if(null==right_ans||0==right_ans.length()){
            return;
        }
        questionMapper.setQuestionRightAns(id,right_ans);
    }

    @Override
    public void setQuestionStyle(int id, int style) {
        if (!styleEffective(style)) {
            return;
        }
        questionMapper.setQuestionStyle(id,style);
    }

    @Override
    public void setQuestion(Question question) {
        if(!questionEffective(question)){
            System.out.println("????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
            return;
        }
        questionMapper.setQuestionStyle(question.getId(),question.getStyle());
        questionMapper.setQuestionRightAns(question.getId(),question.getRight_ans());
        questionMapper.setQuestionans(question.getId(),1,question.getAns1());
        questionMapper.setQuestionans(question.getId(),2,question.getAns2());
        if(question.getAns3()!=null&&question.getAns3().length()!=0) {
            questionMapper.setQuestionans(question.getId(), 3, question.getAns3());
        }
        if(question.getAns3()!=null&&question.getAns3().length()!=0) {
            questionMapper.setQuestionans(question.getId(), 4, question.getAns4());
        }
        questionMapper.setQuestionText(question.getId(),question.getText());
    }

    @Override
    public void deleteQuestion(int id) {
        questionMapper.deleteQuestion(id);
    }

    private boolean styleEffective(int style){
        if (1!=style&&2!=style) {
            return false;
        }else{
            return true;
        }
    }
    private boolean questionEffective(Question question){
        if(null==question){
            return false;
        }
        if(null==question.getText()||0==question.getText().length()){
            return false;
        }
        if(null==question.getAns1()||0==question.getAns1().length()){
            return false;
        }
        if(null==question.getAns2()||0==question.getAns2().length()){
            return false;
        }
        if(null==question.getRight_ans()||0==question.getRight_ans().length()){
            return false;
        }
        return true;
    }
}
