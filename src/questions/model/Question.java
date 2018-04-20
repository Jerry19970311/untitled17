package questions.model;

public class Question {
    private int id;//问题序号
    private String text;//问题内容
    private String right_ans;//正确答案：用abcd的方式表示
    private String ans1;//选项A
    private String ans2;//选项B
    private String ans3;//选项C
    private String ans4;//选项D
    private String sign;//问题的唯一标识符（不能含数字）：为了避免在jsp页面传递中数字不能作为键的标识符的问题。
    private int style;//问题的种类：若为单选题则取值为1，若为多选题取值为2
    private String timestamp;
    public Question(){}
    public Question(QuestionString qs){
        //this.id=Integer.valueOf(qs.getId());
        this.text=qs.getText();
        this.ans1=qs.getAns1();
        this.ans2=qs.getAns2();
        this.ans3=qs.getAns3();
        this.ans4=qs.getAns4();
        this.right_ans=qs.getRight_ans();
        this.sign=qs.getSign();
        this.style=Integer.valueOf(qs.getStyle());
    }
    public Question(int index,String text,String answer1,String answer2,String answer3,String answer4,String rightAnswer,String sign,int style){
        this.id=index;
        this.text=text;
        this.ans1=answer1;
        this.ans2=answer2;
        this.ans3=answer3;
        this.ans4=answer4;
        this.right_ans=rightAnswer;
        this.sign=sign;
        this.style=style;
    }

    @Override
    public String toString() {
        String s="序号："+id+"\t题目："+text+"\nA:"+ans1+"\tB:"+ans2+"\tC:"+ans3+"\tD:"+ans4+"\t正确答案："+right_ans+"\n";
        return s;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getAns1() {
        return ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public String getAns4() {
        return ans4;
    }

    public String getRight_ans() {
        return right_ans;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getSign() {
        return sign;
    }

    public int getStyle() {
        return style;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAns1(String answer1) {
        this.ans1 = answer1;
    }

    public void setAns2(String answer2) {
        this.ans2 = answer2;
    }

    public void setAns3(String answer3) {
        this.ans3 = answer3;
    }

    public void setAns4(String answer4) {
        this.ans4 = answer4;
    }

    public void setRight_ans(String right_ans) {
        this.right_ans = right_ans;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setStyle(int style) {
        this.style = style;
    }
}
