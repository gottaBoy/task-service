package net.ibizsys.paas.util.freemarker;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Locale;

import freemarker.cache.TemplateLoader;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;

/**
 * 实体模板加载器
 * 
 * @author lionlau
 *
 */
public class EntityTemplateLoader implements TemplateLoader {
	protected IEntity dataEntity;

	public EntityTemplateLoader(IEntity dataEntity) {
		this.dataEntity = dataEntity;
	}

	public void closeTemplateSource(Object arg0) throws IOException {
		((StringReader) arg0).close();
	}

	public Object findTemplateSource(String arg0) throws IOException {
		String strCurLocal = "_" + Locale.getDefault().toString();
		arg0 = arg0.substring(0, arg0.length() - strCurLocal.length());

		try {
			String strValue = DataObject.getStringValue(dataEntity, arg0, "");
			return new StringReader(strValue);
		} catch (Exception ex) {
			throw new IOException(ex);
		}

	}

	public long getLastModified(Object arg0) {
		return 0;
	}

	public Reader getReader(Object arg0, String arg1) throws IOException {
		return (Reader) arg0;
	}
}
