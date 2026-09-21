/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  freemarker.cache.TemplateLoader
 */
package SA.SRFDA.Ctrl.Utility;

import SA.SRFramework.DataEx.BaseDataEntity;
import freemarker.cache.TemplateLoader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Locale;

public class DETemplateLoader
implements TemplateLoader {
    protected BaseDataEntity dataEntity;

    public DETemplateLoader(BaseDataEntity dataEntity) {
        this.dataEntity = dataEntity;
    }

    public void closeTemplateSource(Object arg0) throws IOException {
        ((StringReader)arg0).close();
    }

    public Object findTemplateSource(String arg0) throws IOException {
        String strCurLocal = "_" + Locale.getDefault().toString();
        arg0 = arg0.substring(0, arg0.length() - strCurLocal.length());
        String strValue = this.dataEntity.GetParamStringValue(arg0, "");
        return new StringReader(strValue);
    }

    public long getLastModified(Object arg0) {
        return 0L;
    }

    public Reader getReader(Object arg0, String arg1) throws IOException {
        return (Reader)arg0;
    }
}

