/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DataNotify.Model;

import SA.SRFDA.Ctrl.DataNotify.Model.DataNotifyBaseLogicConfig;
import SA.SRFramework.Utility.StringHelper;

public class DataNotifyCustomLogicConfig
extends DataNotifyBaseLogicConfig {
    public static final String TAG_SRFDADATANOTIFYCUSTOMLOGIC = "SRFDADATANOTIFYCUSTOMLOGIC";
    public static final String TAG_CONDITION = "CONDITION";
    protected String strCondition = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_CONDITION, (boolean)true) == 0) {
            this.setCondition(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    @Override
    public String getCondition() {
        return this.strCondition;
    }

    @Override
    public void setCondition(String strCondition) {
        this.strCondition = strCondition;
    }
}

