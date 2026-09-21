/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Model;

import SA.SRFDA.EAI.Model.EAIProcessConfig;
import SA.SRFramework.Utility.StringHelper;

public class EAIInboundProcessConfig
extends EAIProcessConfig {
    public static String TAG_EAIINBOUNDPROCESS = "SRFEXEAIINBOUNDPROCESS";
    public static String TAG_INBOUNDTYPE = "INBOUNDTYPE";
    protected String strInboundType = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_INBOUNDTYPE, (boolean)true) == 0) {
            this.setInboundType(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getInboundType() {
        return this.strInboundType;
    }

    public void setInboundType(String strInboundType) {
        this.strInboundType = strInboundType;
    }
}

