/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.asm.ClassReader
 *  org.springframework.asm.ClassVisitor
 *  org.springframework.core.NestedIOException
 *  org.springframework.core.io.Resource
 *  org.springframework.core.io.support.PathMatchingResourcePatternResolver
 *  org.springframework.core.type.classreading.AnnotationMetadataReadingVisitor
 *  org.springframework.core.type.classreading.MetadataReader
 *  org.springframework.core.type.classreading.MetadataReaderFactory
 *  org.springframework.core.type.filter.TypeFilter
 */
package net.ibizsys.paas.util.spring;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.sysmodel.SystemModelBase;
import net.ibizsys.paas.util.spring.IBizOverride;
import org.springframework.asm.ClassReader;
import org.springframework.asm.ClassVisitor;
import org.springframework.core.NestedIOException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.classreading.AnnotationMetadataReadingVisitor;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public abstract class OverrideTypeFilterBase
implements TypeFilter {
    private Map<String, Resource> map = new HashMap<String, Resource>();
    private boolean bInited = false;

    protected void init() {
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] metaInfResources;
            String strPackage = this.getPackagePath();
            strPackage = strPackage.replace(".", "/");
            Resource[] resourceArray = metaInfResources = resourcePatternResolver.getResources("classpath*:" + strPackage + "/**/*.class");
            int n = metaInfResources.length;
            int n2 = 0;
            while (n2 < n) {
                ClassReader classReader;
                Resource r = resourceArray[n2];
                try (InputStream is = r.getInputStream();){
                    try {
                        classReader = new ClassReader(is);
                    }
                    catch (IllegalArgumentException ex) {
                        throw new NestedIOException("");
                    }
                }
                AnnotationMetadataReadingVisitor visitor = new AnnotationMetadataReadingVisitor(resourcePatternResolver.getClassLoader());
                classReader.accept((ClassVisitor)visitor, 2);
                if (visitor.hasAnnotation(IBizOverride.class.getName())) {
                    this.map.put(visitor.getSuperClassName(), r);
                    SystemModelBase.replaceObject(visitor.getSuperClassName(), visitor.getClassName());
                }
                ++n2;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.bInited = true;
    }

    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        if (!this.bInited) {
            this.init();
        }
        return this.map.containsKey(metadataReader.getClassMetadata().getClassName());
    }

    protected abstract String getPackagePath();
}

