/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParam
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFramework.Data.CallParam;
import java.util.Vector;

public class PSDEDQDeclare {
    protected String strDeclareCode = "";
    protected Vector<CallParam> params = new Vector();

    public String getDeclareCode() {
        return this.strDeclareCode;
    }

    public void setDeclareCode(String strDeclareCode) {
        this.strDeclareCode = strDeclareCode;
    }

    public Vector<CallParam> getParams() {
        return this.params;
    }
}

