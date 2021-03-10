package org.gdq.bolg.core.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
/**
 * @author gdq
 * date 2020/12/9
 * description 反射工具
 */
public class ReflectUtil {

    /**
     * 获取aop代理方法信息
     *
     * @param proceedingJoinPoint 代理方法
     * @return String 代理方法信息
     * @author wb-gdq845533 2020/12/9
     */
    public static String getResourceInfo(ProceedingJoinPoint proceedingJoinPoint) {
        Signature signature = proceedingJoinPoint.getSignature();
        StringBuilder resouceInfo = new StringBuilder();
        // 包名类名
        resouceInfo.append(proceedingJoinPoint.getTarget().getClass().getName());
        resouceInfo.append(".").append(signature.getName());
        Object[] args = proceedingJoinPoint.getArgs();
        resouceInfo.append("(");
        for (Object arg : args) {
            resouceInfo.append(arg).append(",");
        }
        // 去掉多余,
        resouceInfo.setLength(resouceInfo.length() - 1);
        resouceInfo.append(")");
        return resouceInfo.toString();
    }
}
