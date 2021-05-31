package cn.sf.user.aop;

import cn.sf.user.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * 打印入参和出参
 */
@Slf4j
@Component
@Aspect
public class LogAspect {

    private final static DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 切面点
     */
    private final String POINT_CUT = "execution(* cn.sf.user.controller..*(..)) || execution(* cn.sf.user.service..*(..))";

    @Around(value = POINT_CUT)
    public Object methodExecuteTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        ZonedDateTime startDate = ZonedDateTime.now();
        Signature signature = joinPoint.getSignature();
        MethodSignature ms = (MethodSignature) signature;
        Method method = ms.getMethod();
        Class<?>[] paramTypes = method.getParameterTypes();
        Object[] args = joinPoint.getArgs();
        //访问目标方法的参数：
        //先打印入参，防止方法体异常导致参数无法打印
        String[] parameterNames = ms.getParameterNames();

        //防止包路径不规范拿代理对象null
        if (parameterNames != null) {
            /*for (int i = 0; i < paramTypes.length; i++) {
                args[i] = SensitiveParamUtils.getJson(paramterNames[i], args[i]);
            }*/
            log.info("{} 调用时间：{} ，方法入参{}", signature.toString(), sdf.format(startDate), Arrays.toString(args));
        }

        long start = System.currentTimeMillis();
        //后执行方法
        result = joinPoint.proceed();
//            long end = System.currentTimeMillis();
//            String time = formatExecuteTime(end - start);
//            log.info("{} 执行时间：{}", signature.toString(), time);
        try {
            // 处理完请求，返回内容
            log.info("{} Response -> duration:{}ms -> {}", signature.toString(), (System.currentTimeMillis() - start), ObjectUtil.toJson(result));
        } catch (Throwable e) {
            log.warn("接口日志打印异常：{}", e);
        }
        return result;
    }

    private String formatExecuteTime(long executeTime) {
        long min = (executeTime % 3600000) / 60000;
        long sec = (executeTime % 60000) / 1000;
        long msec = executeTime % 10000;
        StringBuilder sb = new StringBuilder();
        if (min > 0) {
            sb.append(min).append("m ");
        }
        if (sec > 0) {
            sb.append(sec).append("s ");
        }
        sb.append(msec).append("ms");
        return sb.toString();
    }

}