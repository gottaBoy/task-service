/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web;

import java.util.Hashtable;

public class FormErrorMgr {
    protected String strErrorMsg = "";
    protected Hashtable errorInputList = new Hashtable();

    public void Reset() {
        this.strErrorMsg = "";
        this.errorInputList.clear();
    }

    public void AddErrorInput(String strKey) {
        this.errorInputList.put(strKey, "");
    }

    public boolean TestErrorInput(String strKey) {
        return this.errorInputList.containsKey(strKey);
    }

    public void AppendErrorMsg(String strMsg) {
        if (this.strErrorMsg.length() > 0) {
            this.strErrorMsg = String.valueOf(this.strErrorMsg) + "<BR>";
        }
        this.strErrorMsg = String.valueOf(this.strErrorMsg) + strMsg;
    }

    public String getErrorMsg() {
        return this.strErrorMsg;
    }

    public boolean getHasError() {
        return !this.errorInputList.isEmpty();
    }
}

