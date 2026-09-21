/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Model;

import SA.SRFDA.Model.DGModelBaseLogicConfig;
import SA.SRFDA.Model.DGModelLogicsConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class DGModelGroupLogicConfig
extends DGModelBaseLogicConfig {
    public static final String TAG_DGMODELGROUPLOGIC = "SRFDADGMODELGROUPLOGIC";
    public static final String TAG_CONDITION = "CONDITION";
    public static final String TAG_NOT = "NOT";
    protected DGModelLogicsConfig logicsConfig = null;
    protected String strCondition = "";
    protected boolean bNot = false;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_CONDITION, (boolean)true) == 0) {
            this.setCondition(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_NOT, (boolean)true) == 0) {
            this.setNot(DGModelGroupLogicConfig.GetValue((String)strValue, (boolean)this.bNot));
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFDADGMODELLOGICS", (boolean)true) == 0) {
            if (this.logicsConfig == null) {
                this.logicsConfig = new DGModelLogicsConfig();
            }
            this.logicsConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public void InitLogicsConfig() {
        if (this.logicsConfig != null) {
            return;
        }
        this.logicsConfig = new DGModelLogicsConfig();
    }

    public DGModelLogicsConfig getLogicsConfig() {
        return this.logicsConfig;
    }

    public String getCondition() {
        return this.strCondition;
    }

    public void setCondition(String strCondition) {
        this.strCondition = strCondition;
    }

    public boolean isNot() {
        return this.bNot;
    }

    public void setNot(boolean not) {
        this.bNot = not;
    }
}

