/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.cache.TemplateLoader
 */
package SA.SRFDA.Web.Render;

import freemarker.cache.TemplateLoader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;

public class DPTemplateLoader
implements TemplateLoader {
    protected Hashtable<String, StringReader> readerMap = new Hashtable();
    protected long nLastAccTime = 0L;

    public DPTemplateLoader(Hashtable<String, String> hashTable) {
        Enumeration<String> en = hashTable.keys();
        while (en.hasMoreElements()) {
            String strKey = en.nextElement();
            String strValue = hashTable.get(strKey);
            this.readerMap.put(strKey, new StringReader(strValue));
        }
        this.nLastAccTime = new Date().getTime();
    }

    public void closeTemplateSource(Object arg0) throws IOException {
    }

    public Object findTemplateSource(String arg0) throws IOException {
        String strCurLocal = "_" + Locale.getDefault().toString();
        arg0 = arg0.substring(0, arg0.length() - strCurLocal.length());
        return this.readerMap.get(arg0);
    }

    public long getLastModified(Object arg0) {
        return this.nLastAccTime;
    }

    public Reader getReader(Object arg0, String arg1) throws IOException {
        return (Reader)arg0;
    }
}

