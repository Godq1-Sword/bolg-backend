package org.gdq.bolg.core.reflect;

import lombok.extern.slf4j.Slf4j;
import org.gdq.bolg.core.model.entity.MathConcept;
import org.gdq.bolg.core.model.entity.MathDefine;
import org.gdq.bolg.core.model.entity.Wiki;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 数学概念处理器
 *
 * @author gdq
 * date 2020/12/19
 */
@Slf4j
public class MathAnalysisHandler {

    /**
     * 数学名词及解析关联
     *
     * @author wb-gdq845533
     */
    public static void mathAnalysis() {
        // 定义属性
        Class<MathDefine> mathDefineClass = MathDefine.class;
        Stream<Field> defines = Arrays.stream(mathDefineClass.getDeclaredFields());
        // 解析属性
        Class<MathConcept> mathConceptClass = MathConcept.class;
        // 构建Mapping
        defines.parallel().forEach(field -> {
            try {
                Wiki.wiki.put(field.get(String.class).toString(), mathConceptClass.getField(field.getName()).get(String.class));
            } catch (IllegalAccessException | NoSuchFieldException e) {
                log.error("MathAnalysisHandler.mathAnalysis.mathAnalysis()执行异常,Error:" + e.getMessage());
            }
        });
    }
}
