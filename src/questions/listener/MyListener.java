package questions.listener;

import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;
import java.util.Map;
import java.util.Set;

public class MyListener extends ContextLoaderListener{
    //服务器启用的时候该方法就被调用。
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        Map<String,Thread> threadMap=(Map<String,Thread>)getCurrentWebApplicationContext().getBean("jobMap");
        Set<Map.Entry<String,Thread>>threadMapEntrySet=threadMap.entrySet();
        for (Map.Entry<String, Thread> threadMapEntry : threadMapEntrySet) {
            threadMapEntry.getValue().start();
        }
    }
}
