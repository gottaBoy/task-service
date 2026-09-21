/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.cache.TemplateLoader
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pub.util;

import freemarker.cache.TemplateLoader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Locale;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EntityTemplateLoader
implements TemplateLoader {
    private static final Log log = LogFactory.getLog(EntityTemplateLoader.class);
    protected IEntity dataEntity;

    public EntityTemplateLoader(IEntity dataEntity) {
        this.dataEntity = dataEntity;
    }

    public void closeTemplateSource(Object arg0) throws IOException {
        ((StringReader)arg0).close();
    }

    public Object findTemplateSource(String arg0) throws IOException {
        String strValue;
        String strCurLocal = "_" + Locale.getDefault().toString();
        arg0 = arg0.substring(0, arg0.length() - strCurLocal.length());
        try {
            strValue = DataObject.getStringValue((Object)this.dataEntity.get(arg0), (String)"");
        }
        catch (Exception e) {
            log.error((Object)e);
            throw new IOException(e);
        }
        return new StringReader(strValue);
    }

    public long getLastModified(Object arg0) {
        return 0L;
    }

    public Reader getReader(Object arg0, String arg1) throws IOException {
        return (Reader)arg0;
    }
}

