package net.ibizsys.paas.util.spring;

import org.springframework.beans.factory.config.BeanDefinition;

/**
 * Spring Bean名称产生器 name-generator="net.ibizsys.paas.util.spring.AnnotationBeanNameGenerator"
 * 
 * @author Administrator
 *
 */
public class AnnotationBeanNameGenerator extends org.springframework.context.annotation.AnnotationBeanNameGenerator {
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.context.annotation.AnnotationBeanNameGenerator#buildDefaultBeanName(org.springframework.beans.factory.config.BeanDefinition)
	 */
	@Override
	protected String buildDefaultBeanName(BeanDefinition definition) {
		return definition.getBeanClassName();
		// return super.buildDefaultBeanName(definition);
	}

}
