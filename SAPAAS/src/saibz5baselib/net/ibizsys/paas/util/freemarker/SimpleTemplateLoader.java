/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.cache.TemplateLoader
 */
package net.ibizsys.paas.util.freemarker;

import freemarker.cache.TemplateLoader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class SimpleTemplateLoader
implements TemplateLoader {
    protected String strCode;

    public SimpleTemplateLoader(String strCode) {
        this.strCode = strCode;
    }

    public void closeTemplateSource(Object arg0) throws IOException {
        ((StringReader)arg0).close();
    }

    public Object findTemplateSource(String arg0) throws IOException {
        return new StringReader(this.strCode);
    }

    public long getLastModified(Object arg0) {
        return 0L;
    }

    public Reader getReader(Object arg0, String arg1) throws IOException {
        return (Reader)arg0;
    }
}

