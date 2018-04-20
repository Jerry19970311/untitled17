package questions.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import questions.mapper.QuestionMapper;
import questions.model.Question;
import questions.service.IPersist;
import questions.service.ISelect;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
//Spring配置方式：
//1，用文本配置的方式来管理对象和对象之间的关系(beans.xml)
//2，用注解的方式
//Resource先用name匹配后用类型匹配，name对应配置文件里面的id；
//（可以利用name参数强制指定）
//@Resource(name="")
//Autowired是先用类型匹配后用名字
//强制指定：@Qualifier("")
//如果需要全部接口实例，应当有以该接口为参数类型的List数据域
//（此时无论用Resource还是Autowired都没有区别）
public class MapperTest {
    @Resource
    QuestionMapper questionMapper;

    @Autowired
    private IPersist<Question> persistService;

    @Autowired
    private ISelect<Question> selectService;

    @Test
    public void testAddQuestion(){
        persistService.addQuestion("抗战期间，国民政府是哪一年正式对日宣战的","1931年","1937年","1939年","1941年","d","four",1);
    }
    @Test
    public void testSetQuestion1(){
        persistService.setQuestionans(4,3,"1939年");
    }
    @Test
    public void testSetQuestion2(){
        persistService.setQuestionStyle(4,1);
    }
    @Test
    public void testGetQuestions(){
        List<Question> questions=selectService.getQuestions();
        System.out.println(questions);
    }
}
