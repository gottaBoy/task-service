/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SRFWF.Model;

import SA.SRFramework.Utility.StringHelper;
import SRFWF.Model.WFBaseProcessConfig;

public class WFProcessConfig
extends WFBaseProcessConfig {
    public static String TAG_WFPROCESS = "SRFEXWFPROCESS";
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

