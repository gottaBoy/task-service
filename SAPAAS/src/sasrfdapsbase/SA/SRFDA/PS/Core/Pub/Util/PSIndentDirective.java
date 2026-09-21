/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.core.Environment
 *  freemarker.template.TemplateDirectiveBody
 *  freemarker.template.TemplateDirectiveModel
 *  freemarker.template.TemplateException
 *  freemarker.template.TemplateModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub.Util;

import SA.SRFramework.Utility.StringHelper;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSIndentDirective
implements TemplateDirectiveModel {
    private static final Log log = LogFactory.getLog(PSIndentDirective.class);

    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        Object objBlank;
        int nBlank = 4;
        if (params != null && params.containsKey("blank") && (objBlank = params.get("blank")) != null) {
            try {
                nBlank = Integer.valueOf(objBlank.toString());
            }
            catch (Exception ex) {
                nBlank = 4;
                log.error((Object)ex);
            }
        }
        if (nBlank <= 0 || nBlank >= 20) {
            nBlank = 4;
        }
        FormatWriter writer = new FormatWriter(env.getOut(), nBlank);
        body.render((Writer)writer);
    }

    private static class FormatWriter
    extends Writer {
        private Writer out;
        private char[] space;

        public FormatWriter(Writer out, int column) {
            this.out = out;
            this.space = new char[column];
            Arrays.fill(this.space, ' ');
        }

        @Override
        public void write(char[] cbuf, int off, int len) throws IOException {
            String strString2 = new String(cbuf, off, len);
            String strString = strString2.replaceAll("^[ ]*", "");
            if (!StringHelper.IsNullOrEmpty((String)strString)) {
                strString = strString.replace("\r\n", "\n");
                if ((strString = strString.replace("\r", "\n")).indexOf("\n") == -1) {
                    this.out.write(this.space);
                    this.out.write(strString);
                } else {
                    String[] rows = strString.split("[\n]");
                    int i = 0;
                    while (i < rows.length) {
                        if (i != 0) {
                            this.out.write("\r\n");
                        }
                        this.out.write(this.space);
                        this.out.write(rows[i]);
                        ++i;
                    }
                    if (rows.length > 0) {
                        this.out.write("\r\n");
                    }
                }
            } else {
                this.out.write(strString2);
            }
        }

        @Override
        public void flush() throws IOException {
            this.out.flush();
        }

        @Override
        public void close() throws IOException {
            this.out.close();
        }
    }
}

