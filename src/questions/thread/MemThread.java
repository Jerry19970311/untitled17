package questions.thread;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import questions.mapper.QuestionMapper;
import questions.model.Memory;
import questions.model.Question;

public class MemThread extends Thread{
    private static final Logger logger = Logger.getLogger(MemThread.class);
    @Autowired
    QuestionMapper questionMapper;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                Memory memoryModel = new Memory();
                memoryModel.setMaxMemory((int) (Runtime.getRuntime().maxMemory() / 1024 / 1024));
                memoryModel.setTotalMemory((int) (Runtime.getRuntime().totalMemory() / 1024 / 1024));
                memoryModel.setFreeMemory((int) (Runtime.getRuntime().freeMemory() / 1024 / 1024));
                questionMapper.addMemory(memoryModel);
                logger.info("记录一次内存信息");
            } catch (InterruptedException e) {
                logger.error("ERROR", e);
            }
        }
    }
}
