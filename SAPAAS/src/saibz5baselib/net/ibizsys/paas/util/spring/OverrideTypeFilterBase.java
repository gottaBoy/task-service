package net.ibizsys.paas.util.spring;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.asm.ClassReader;
import org.springframework.core.NestedIOException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.AnnotationMetadataReadingVisitor;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import net.ibizsys.paas.sysmodel.SystemModelBase;

/**
 * 集成类型过滤器基类
 * 
 * @author Administrator
 *
 */
public abstract class OverrideTypeFilterBase implements org.springframework.core.type.filter.TypeFilter {

	private Map<String, Resource> map = new HashMap<String, Resource>();

	private boolean bInited = false;

	protected void init() {
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		try {
			String strPackage = getPackagePath();
			strPackage = strPackage.replace(".", "/");
			Resource[] metaInfResources = resourcePatternResolver.getResources("classpath*:" + strPackage + "/**/*.class");
			for (Resource r : metaInfResources) {
				ClassReader classReader;
				InputStream is = r.getInputStream();
				try {
					classReader = new ClassReader(is);
				} catch (IllegalArgumentException ex) {
					throw new NestedIOException("");
				} finally {
					is.close();
				}

				AnnotationMetadataReadingVisitor visitor = new AnnotationMetadataReadingVisitor(resourcePatternResolver.getClassLoader());
				classReader.accept(visitor, ClassReader.SKIP_DEBUG);

				if (visitor.hasAnnotation(IBizOverride.class.getName())) {
					map.put(visitor.getSuperClassName(), r);
					SystemModelBase.replaceObject(visitor.getSuperClassName(), visitor.getClassName());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		bInited = true;
	}

	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
		if (!bInited) {
			init();
		}

		return map.containsKey(metadataReader.getClassMetadata().getClassName());
	}

	/**
	 * 获取包路径
	 * 
	 * @return
	 */
	protected abstract String getPackagePath();

}
