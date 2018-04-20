package questions.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import questions.model.Question;

import java.security.MessageDigest;

//持久化增强，其接入点均为涉及到数据库增、删、改的方法。
public class PersistAdvice {
    private final Logger logger = Logger.getLogger(this.getClass());
    //织入插入数据的方法（add开头的方法），在方法被执行前执行，负责把即将写入的数据编号输出日志。
    public void insertAdvice(JoinPoint joinPoint){
        //joinPoint.getArgs()可以返回被织入方法的参数组成的数组。
        Object[] objects=joinPoint.getArgs();
        //根据各相关方法的参数个数进行判断，
        //如果数组长度为1，说明参数是一个Question对象，否则是直接将逐个数据进行插入。
        if(objects.length==1){
            logger.info("Before:即将要写入的题目为：\n"+((Question)objects[0]).toString());
        }else{
            String str="名字："+(String) objects[0]+"\nA："+(String)objects[1]+"\nB："+(String)objects[2]+"\nC："+(String)objects[3]+"\nD："+(String)objects[4]+"\n正确答案："+(String)objects[5]+"\n唯一标识符："+(String) objects[6]+"\n题型号："+(int)objects[7]+"\n";
            logger.info("Before:即将要写入的题目为：\n"+str);
        }
    }
    //本方法作为环绕方法执行的方法，完成两件事：
    //①对
    public Object insertTotal(ProceedingJoinPoint pjp) throws Throwable {
        Object[] os=pjp.getArgs();
        String sign;
        String msign;
        if(os.length==1){
            sign=((Question)os[0]).getSign();
            msign=md5(sign);
            ((Question)os[0]).setSign(msign);
        }else{
            sign=(String)os[6];
            msign=md5(sign);
            os[6]=(Object)msign;
        }
        logger.info("Around:唯一标识符加密以后："+msign);
        logger.info("Around:统计时间增强进入");
        long begin = System.currentTimeMillis();
        Object o = pjp.proceed(os);
        long end = System.currentTimeMillis();
        String s = String.format("业务方法:%s执行花费了%s毫秒", pjp.getTarget().getClass() + "." + pjp.getSignature().getName(),
                (end - begin));
        logger.info(s);
        logger.info("Around:统计时间增强结束");
        return o;
    }
    public void insertFail(){
        logger.info("After-throwing:数据加入失败");
    }
    public void insertSuccess(){
        logger.info("After-returning:数据加入成功");
    }

    public void deleteFail(){
        logger.info("After-throwing:数据删除失败");
    }
    public void deleteSuccess(){
        logger.info("After-returning:数据删除成功");
    }

    public void getUpdateId(JoinPoint joinPoint){
        Object[] os=joinPoint.getArgs();
        if(os.length!=1) {
            logger.info("Before:被修改的题目序号为" + (int) os[0] + "号");
        }else{
            logger.info("Before:被修改的题目序号为" + ((Question)os[0]).getId() + "号");
        }
    }

    private final static String[] hexDigits = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    public static String md5(String inputStr){
        return encodeByMD5(inputStr);
    }
    private static String encodeByMD5(String originString){
        if (originString!=null) {
            try {
                //创建具有指定算法名称的信息摘要
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
                byte[] results = md5.digest(originString.getBytes());
                //将得到的字节数组变成字符串返回
                String result = byteArrayToHexString(results);
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 轮换字节数组为十六进制字符串
     * @param b 字节数组
     * @return 十六进制字符串
     */
    private static String byteArrayToHexString(byte[] b){
        StringBuffer resultSb = new StringBuffer();
        for(int i=0;i<b.length;i++){
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    //将一个字节转化成十六进制形式的字符串
    private static String byteToHexString(byte b){
        int n = b;
        if(n<0)
            n=256+n;
        int d1 = n/16;
        int d2 = n%16;
        return hexDigits[d1] + hexDigits[d2];
    }
}
