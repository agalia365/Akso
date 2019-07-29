package com.akso.spring.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    /**
     * 自定义逻辑，返回需要导入的组件数组
     * 返回值就是导入到容器中的组件全类名
     * @param annotationMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.akso.spring.bean.Blue", "com.akso.spring.bean.Yellow"};
    }
}
