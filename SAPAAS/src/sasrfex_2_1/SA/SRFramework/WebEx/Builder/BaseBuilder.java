/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.Utility.StringHelper;
import java.io.IOException;
import java.io.Writer;

public abstract class BaseBuilder {
    protected String strBuilderName = "";
    protected String strBuilderMode = "";

    public String getBuilderName() {
        return this.strBuilderName;
    }

    public String getBuilderMode() {
        return this.strBuilderMode;
    }

    public static void OutputAttribute(Writer writer, String strKey, String strValue) {
        try {
            if (StringHelper.Length((String)strKey) == 0) {
                return;
            }
            if (StringHelper.Length((String)strValue) == 0) {
                return;
            }
            writer.write(StringHelper.Format((String)" %1$s='%2$s'", (Object)strKey, (Object)strValue));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected static void OutputScriptBegin(Writer writer) throws IOException {
        writer.write("<SCRIPT language=\"javascript\" type=\"text/javascript\">");
    }

    protected static void OutputScriptEnd(Writer writer) throws IOException {
        writer.write("</SCRIPT>");
    }

    public void Reset() {
        this.OnReset();
    }

    protected void OnReset() {
    }
}

