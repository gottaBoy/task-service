/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Button;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Button.SRFExBaseAjaxButtonAction;
import java.io.IOException;
import java.io.Writer;

public abstract class SRFExButtonSystemAction
extends SRFExBaseAjaxButtonAction {
    protected String strBeforeCode = "";
    protected String strAfterCode = "";

    public String getBeforeCode() {
        return this.strBeforeCode;
    }

    public void setBeforeCode(String strBeforeCode) {
        this.strBeforeCode = strBeforeCode;
    }

    public String getAfterCode() {
        return this.strAfterCode;
    }

    public void setAfterCode(String strAfterCode) {
        this.strAfterCode = strAfterCode;
    }

    protected void OutputBeforeCode(Writer writer) throws IOException {
        if (StringHelper.Length((String)this.strBeforeCode) > 0) {
            writer.write(this.strBeforeCode);
        }
    }

    protected void OutputAfterCode(Writer writer) throws IOException {
        if (StringHelper.Length((String)this.strAfterCode) > 0) {
            writer.write(this.strAfterCode);
        }
    }
}

