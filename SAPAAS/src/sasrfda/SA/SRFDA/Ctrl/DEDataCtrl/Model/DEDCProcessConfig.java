/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEDataCtrl.Model;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFramework.Utility.StringHelper;

public class DEDCProcessConfig
extends DEDCBaseProcessConfig {
    public static String TAG_DEDCPROCESS = "SRFEXDEDCPPROCESS";
    public static String TAG_NEXT = "NEXT";
    protected String strNext = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_NEXT, (boolean)true) == 0) {
            this.strNext = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getNext() {
        return this.strNext;
    }

    public void setNext(String strNext) {
        this.strNext = strNext;
    }
}

