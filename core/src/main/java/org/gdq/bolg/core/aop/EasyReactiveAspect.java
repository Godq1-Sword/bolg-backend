package org.gdq.bolg.core.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.gdq.bolg.core.util.ReactiveBodyUtil;
import org.gdq.bolg.core.util.ReflectUtil;
import org.springframework.stereotype.Component;

/**
 * @author gdq
 * date 2020/12/9
 * description EasyResponseAspect
 */
@Aspect
@Component
@Slf4j
public class EasyReactiveAspect {

    @Pointcut("@annotation(org.gdq.bolg.core.aop.EasyReactive)")
    private void pointCut() {}

    /**
     * 环绕增强方法,返回通用responseBody并记录日志
     *
     * @param proceedingJoinPoint 执行过程方法
     * @author wb-gdq845533 2020/12/9
     */
    @Around("pointCut()")
    public Object process(ProceedingJoinPoint proceedingJoinPoint) {
        Object result;
        try {
            // 正常返回值
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            // 打印包名类型,错误信息
            String errorMessage = throwable.getMessage();
            log.error(ReflectUtil.getResourceInfo(proceedingJoinPoint) + " - Error:" + errorMessage);
            return ReactiveBodyUtil.generateErrRB(errorMessage);
        }
        return ReactiveBodyUtil.generateSucRB(result);
    }
}
