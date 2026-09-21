/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Model;

import SA.SRFDA.EAI.Model.EAIBaseProcessConfig;
import SA.SRFramework.Utility.StringHelper;

public class EAIOutboundProcessConfig
extends EAIBaseProcessConfig {
    public static String TAG_EAIOUTBOUNDPROCESS = "SRFEXEAIOUTBOUNDPROCESS";
    public static String TAG_OUTBOUNDTYPE = "OUTBOUNDTYPE";
    protected String strOutboundType = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_OUTBOUNDTYPE, (boolean)true) == 0) {
            this.setOutboundType(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getOutboundType() {
        return this.strOutboundType;
    }

    public void setOutboundType(String strOutboundType) {
        this.strOutboundType = strOutboundType;
    }
}

