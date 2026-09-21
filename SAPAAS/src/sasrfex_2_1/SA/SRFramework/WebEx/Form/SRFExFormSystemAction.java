/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExBaseFormAction;
import java.io.IOException;
import java.io.Writer;

public abstract class SRFExFormSystemAction
extends SRFExBaseFormAction {
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

    public void AppendAfterCode(String strCode) {
        if (!StringHelper.IsNullOrEmpty((String)this.strAfterCode)) {
            this.strAfterCode = String.valueOf(this.strAfterCode) + "\r\n";
        }
        this.strAfterCode = String.valueOf(this.strAfterCode) + strCode;
    }

    public void AppendBeforeCode(String strCode) {
        if (!StringHelper.IsNullOrEmpty((String)this.strBeforeCode)) {
            this.strBeforeCode = String.valueOf(this.strBeforeCode) + "\r\n";
        }
        this.strBeforeCode = String.valueOf(this.strBeforeCode) + strCode;
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

    protected boolean hasBeforeCode() {
        return !StringHelper.IsNullOrEmpty((String)this.strBeforeCode);
    }

    protected boolean hasAfterCode() {
        return !StringHelper.IsNullOrEmpty((String)this.strAfterCode);
    }
}

