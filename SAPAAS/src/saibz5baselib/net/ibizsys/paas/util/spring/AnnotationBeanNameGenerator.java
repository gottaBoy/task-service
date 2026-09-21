/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.config.BeanDefinition
 *  org.springframework.context.annotation.AnnotationBeanNameGenerator
 */
package net.ibizsys.paas.util.spring;

import org.springframework.beans.factory.config.BeanDefinition;

public class AnnotationBeanNameGenerator
extends org.springframework.context.annotation.AnnotationBeanNameGenerator {
    protected String buildDefaultBeanName(BeanDefinition definition) {
        return definition.getBeanClassName();
    }
}

