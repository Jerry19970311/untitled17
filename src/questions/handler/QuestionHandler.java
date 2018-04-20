package questions.handler;

import com.google.common.collect.Maps;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import questions.model.Question;
import questions.model.QuestionString;
import questions.service.IPersist;
import questions.service.ISelect;

import java.util.Map;
@Controller
public class QuestionHandler {

        Logger logger = Logger.getLogger(this.getClass());
        public QuestionHandler(){
            BasicConfigurator.configure();
        }
        @Autowired()
        @Qualifier("selectService")
        ISelect<Question> selectService;

        @Autowired()
        @Qualifier("persistService")
        IPersist<Question> persistService;

        @RequestMapping("/questions")
        public String list(Map<String, Object> map) {
            logger.info("Handler:正在导入题库");
            map.put("questions",selectService.getQuestions());
            return "list";
        }

        @RequestMapping(value = "/question", method = RequestMethod.GET)
        public String input(Map<String, Object> map) {
            map.put("question",new QuestionString());
            return "input";
        }

        @RequestMapping(value = "/question", method = RequestMethod.POST)
        public String save(QuestionString questionString) {
            Question question=new Question(questionString);
            persistService.addQuestion(question);
            return "redirect:/questions";
        }

        @RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
        public String input(@PathVariable("id") Integer id, Map<String, Object> map) {
            map.put("question",selectService.getQuestionById(id));
            return "modify";
        }

        @RequestMapping(value = "/question", method = RequestMethod.PUT)
        public String update(Question question) {
            System.out.println("------------------------------");
            System.out.println(question);
            System.out.println("------------------------------");
            persistService.setQuestion(question);
            return "redirect:/questions";
        }

        @RequestMapping(value = "/question/{id}", method = RequestMethod.DELETE)
        public String delete(@PathVariable("id") Integer id) {
            logger.info("被删除的题目编号是"+id);
            persistService.deleteQuestion(id);
            return "redirect:/questions";
        }
    }

