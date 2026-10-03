package net.ibizsys.paas.util.freemarker;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import freemarker.cache.TemplateLoader;

/**
 * 简单模板加载器
 * 
 * @author lionlau
 *
 */
public class SimpleTemplateLoader implements TemplateLoader {
	protected String strCode;

	public SimpleTemplateLoader(String strCode) {
		this.strCode = strCode;
	}

	public void closeTemplateSource(Object arg0) throws IOException {
		((StringReader) arg0).close();
	}

	public Object findTemplateSource(String arg0) throws IOException {
		return new StringReader(strCode);
	}

	public long getLastModified(Object arg0) {
		return 0;
	}

	public Reader getReader(Object arg0, String arg1) throws IOException {
		return (Reader) arg0;
	}

}
