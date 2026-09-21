/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.CallParam;
import java.util.TreeMap;
import java.util.Vector;

public class CallParamHelper {
    private TreeMap<String, CallParam> params = new TreeMap();

    public CallParamHelper(Vector<CallParam> list) {
        for (CallParam callParam : list) {
            this.params.put(callParam.getParamName().toUpperCase(), callParam);
        }
    }

    public void SetCallParam(String strName, Object objValue) {
        CallParam callParam = this.params.get(strName.toUpperCase());
        if (callParam != null) {
            callParam.setValue(objValue);
        }
    }
}

