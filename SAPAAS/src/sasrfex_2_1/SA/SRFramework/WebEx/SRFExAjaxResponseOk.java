/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.WebEx.SRFExAjaxResponseFormAction;
import java.util.Hashtable;

public class SRFExAjaxResponseOk
extends SRFExAjaxResponseFormAction {
    protected Hashtable additionalCodeMap = null;

    public synchronized void SetAdditionalCode(int nRetCode, String strCode) {
        if (this.additionalCodeMap == null) {
            this.additionalCodeMap = new Hashtable();
        }
        String strLastCode = this.GetAdditionalCode(nRetCode);
        strLastCode = String.valueOf(strLastCode) + strCode;
        this.additionalCodeMap.put(nRetCode, strLastCode);
    }

    public synchronized String GetAdditionalCode(int nRetCode) {
        if (this.additionalCodeMap == null) {
            return "";
        }
        if (this.additionalCodeMap.containsKey(nRetCode)) {
            return (String)this.additionalCodeMap.get(nRetCode);
        }
        return "";
    }

    public synchronized void RemoveAdditionalCode(int nRetCode) {
        if (this.additionalCodeMap == null) {
            return;
        }
        this.additionalCodeMap.remove(nRetCode);
    }
}

