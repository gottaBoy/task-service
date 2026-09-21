/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SRFWF.Model;

import SA.SRFramework.Utility.StringHelper;
import SRFWF.Model.WFBaseConnectionConfig;

public class WFEmbedWFReturnConfig
extends WFBaseConnectionConfig {
    public static final String TAG_WFEMBEDWFRETURN = "SRFEXWFEMBEDWFRETURN";
    public static final String TAG_ACTIONCOUNT = "ACTIONCOUNT";
    public static final String TAG_NEXTCONDITION = "NEXTCONDITION";
    public static final String TAG_NEXTCONDITION_ALL = "ALL";
    public static final String TAG_NEXTCONDITION_ANY = "ANY";
    protected String strNextCondition = "ANY";
    protected int nAcionCount = 0;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_ACTIONCOUNT, (boolean)true) == 0) {
            this.nAcionCount = WFEmbedWFReturnConfig.GetValue((String)strValue, (int)this.nAcionCount);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_NEXTCONDITION, (boolean)true) == 0) {
            this.strNextCondition = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public int getAcionCount() {
        return this.nAcionCount;
    }

    public void setAcionCount(int acionCount) {
        this.nAcionCount = acionCount;
    }

    public String getNextCondition() {
        return this.strNextCondition;
    }

    public void setNextCondition(String strNextCondition) {
        this.strNextCondition = strNextCondition;
    }
}

