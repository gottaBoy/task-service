/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExBaseFormAction;
import java.util.Vector;

public class SRFExCustomFormAction
extends SRFExBaseFormAction {
    protected boolean bRunAtPageLoad = false;

    public boolean getRunAtPageLoad() {
        return this.bRunAtPageLoad;
    }

    public void setRunAtPageLoad(boolean bRunAtPageLoad) {
        this.bRunAtPageLoad = bRunAtPageLoad;
    }

    public void setActionName(String strActionName) {
        this.strActionName = strActionName;
    }

    public synchronized void AddActionParam(String strParamName) {
        if (this.params == null) {
            this.params = new Vector();
        }
        this.params.add(strParamName);
    }

    public synchronized void RemoveActionParam(String strParamName) {
        if (this.params == null) {
            return;
        }
        this.params.remove(strParamName);
    }

    public Vector GetActionParams() {
        return this.params;
    }

    protected String GetActionParam() {
        String strParam = "";
        if (this.params == null) {
            return strParam;
        }
        int nCount = this.params.size();
        int i = 0;
        while (i < nCount) {
            if (StringHelper.Length((String)strParam) != 0) {
                strParam = String.valueOf(strParam) + ",";
            }
            strParam = String.valueOf(strParam) + (String)this.params.get(i);
            ++i;
        }
        return strParam;
    }
}

