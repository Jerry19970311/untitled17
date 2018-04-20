package questions.service;

import questions.mapper.QuestionMapper;

import javax.annotation.Resource;
import org.apache.log4j.Logger;

public abstract class AbstractDao {
    protected final Logger logger=Logger.getLogger(this.getClass());
    @Resource
    protected QuestionMapper questionMapper;
}
