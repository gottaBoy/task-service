/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletContext
 *  org.springframework.beans.BeansException
 *  org.springframework.beans.factory.BeanFactory
 *  org.springframework.beans.factory.NoSuchBeanDefinitionException
 *  org.springframework.beans.factory.config.AutowireCapableBeanFactory
 *  org.springframework.context.ApplicationContext
 *  org.springframework.context.ApplicationEvent
 *  org.springframework.context.MessageSourceResolvable
 *  org.springframework.context.NoSuchMessageException
 *  org.springframework.core.env.Environment
 *  org.springframework.core.io.Resource
 *  org.springframework.web.context.WebApplicationContext
 */
package SA.SRFDA.PS.Core.JIT.Web;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;
import javax.servlet.ServletContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.web.context.WebApplicationContext;

public class PSJITWebApplicationContext
implements WebApplicationContext {
    private ServletContext servletContext = null;

    public PSJITWebApplicationContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public String getId() {
        return null;
    }

    public String getApplicationName() {
        return null;
    }

    public String getDisplayName() {
        return null;
    }

    public long getStartupDate() {
        return 0L;
    }

    public ApplicationContext getParent() {
        return null;
    }

    public AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException {
        return null;
    }

    public Environment getEnvironment() {
        return null;
    }

    public boolean containsBeanDefinition(String arg0) {
        return false;
    }

    public <A extends Annotation> A findAnnotationOnBean(String arg0, Class<A> arg1) throws NoSuchBeanDefinitionException {
        return null;
    }

    public int getBeanDefinitionCount() {
        return 0;
    }

    public String[] getBeanDefinitionNames() {
        return null;
    }

    public String[] getBeanNamesForAnnotation(Class<? extends Annotation> arg0) {
        return null;
    }

    public String[] getBeanNamesForType(Class<?> arg0) {
        return null;
    }

    public String[] getBeanNamesForType(Class<?> arg0, boolean arg1, boolean arg2) {
        return null;
    }

    public <T> Map<String, T> getBeansOfType(Class<T> arg0) throws BeansException {
        return null;
    }

    public <T> Map<String, T> getBeansOfType(Class<T> arg0, boolean arg1, boolean arg2) throws BeansException {
        return null;
    }

    public Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> arg0) throws BeansException {
        return null;
    }

    public boolean containsBean(String arg0) {
        return false;
    }

    public String[] getAliases(String arg0) {
        return null;
    }

    public Object getBean(String arg0) throws BeansException {
        return null;
    }

    public <T> T getBean(Class<T> arg0) throws BeansException {
        return null;
    }

    public <T> T getBean(String arg0, Class<T> arg1) throws BeansException {
        return null;
    }

    public Object getBean(String arg0, Object ... arg1) throws BeansException {
        return null;
    }

    public <T> T getBean(Class<T> arg0, Object ... arg1) throws BeansException {
        return null;
    }

    public Class<?> getType(String arg0) throws NoSuchBeanDefinitionException {
        return null;
    }

    public boolean isPrototype(String arg0) throws NoSuchBeanDefinitionException {
        return false;
    }

    public boolean isSingleton(String arg0) throws NoSuchBeanDefinitionException {
        return false;
    }

    public boolean isTypeMatch(String arg0, Class<?> arg1) throws NoSuchBeanDefinitionException {
        return false;
    }

    public boolean containsLocalBean(String arg0) {
        return false;
    }

    public BeanFactory getParentBeanFactory() {
        return null;
    }

    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        return null;
    }

    public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
        return null;
    }

    public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
        return null;
    }

    public void publishEvent(ApplicationEvent event) {
    }

    public Resource[] getResources(String arg0) throws IOException {
        return null;
    }

    public ClassLoader getClassLoader() {
        return null;
    }

    public Resource getResource(String arg0) {
        return null;
    }

    public ServletContext getServletContext() {
        return this.servletContext;
    }
}

