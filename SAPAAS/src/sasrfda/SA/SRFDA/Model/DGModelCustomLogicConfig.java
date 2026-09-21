/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Model;

import SA.SRFDA.Model.DGModelBaseLogicConfig;
import SA.SRFramework.Utility.StringHelper;

public class DGModelCustomLogicConfig
extends DGModelBaseLogicConfig {
    public static final String TAG_DGMODELCUSTOMLOGIC = "SRFDADGMODELCUSTOMLOGIC";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_CONDITION = "CONDITION";
    protected String strLogicName = "";
    protected String strCondition = "";

    @Override
    protected void OnSetProperty(String strLogicName, String strValue) {
        if (StringHelper.Compare((String)strLogicName, (String)TAG_LOGICNAME, (boolean)true) == 0) {
            this.setLogicName(strValue);
            return;
        }
        if (StringHelper.Compare((String)strLogicName, (String)TAG_CONDITION, (boolean)true) == 0) {
            this.setCondition(strValue);
            return;
        }
        super.OnSetProperty(strLogicName, strValue);
    }

    @Override
    public String getLogicName() {
        return this.strLogicName;
    }

    @Override
    public void setLogicName(String strLogicName) {
        this.strLogicName = strLogicName;
    }

    public String getCondition() {
        return this.strCondition;
    }

    public void setCondition(String strCondition) {
        this.strCondition = strCondition;
    }
}

