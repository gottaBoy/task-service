/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Model;

import SA.SRFDA.EAI.Model.EAIBaseConnectionConfig;
import SA.SRFramework.Utility.StringHelper;

public class EAIRouteConnectionConfig
extends EAIBaseConnectionConfig {
    public static String TAG_EAIROUTECONNECTION = "SRFEXEAIROUTECONNECTION";
    public static final String TAG_SHOWORDER = "SHOWORDER";
    protected int nShowOrder = 0;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_SHOWORDER, (boolean)true) == 0) {
            this.setShowOrder(EAIRouteConnectionConfig.GetValue((String)strValue, (int)this.nShowOrder));
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public int getShowOrder() {
        return this.nShowOrder;
    }

    public void setShowOrder(int showOrder) {
        this.nShowOrder = showOrder;
        if (this.nShowOrder < 0) {
            this.nShowOrder = 0;
        }
    }
}

