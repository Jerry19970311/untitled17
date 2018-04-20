package questions.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import java.util.List;

//查询增强，其接入点均为涉及到数据库查找的方法。
public class SelectAdvice {
    private final Logger logger=Logger.getLogger(this.getClass());
    public void selectAfter(JoinPoint joinPoint){
        Object[] os=joinPoint.getArgs();
        if(null!=os&&1==os.length){
            logger.info("搜索已完成，本次使用的是单个搜索");
        }else{
            logger.info("搜索已完成，本次使用的是多个搜索");
        }
    }
}
