package com.akso.spring.config;

import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        ClassMetadata classMetaData = metadataReader.getClassMetadata();
        String className = classMetaData.getClassName();
        if(className.endsWith("er")) {
            return true;
        }
        return false;
    }
}
