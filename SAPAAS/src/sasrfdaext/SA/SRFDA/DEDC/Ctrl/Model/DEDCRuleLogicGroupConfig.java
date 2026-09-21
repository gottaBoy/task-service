/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.DEDC.Ctrl.Model;

import SA.SRFDA.DEDC.Ctrl.Model.DEDCRuleBaseLogicConfig;
import SA.SRFDA.DEDC.Ctrl.Model.DEDCRuleLogicItemConfig;
import SA.SRFDA.DEDC.Ctrl.Model.DEDCRuleUserLogicItemConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.w3c.dom.Node;

public class DEDCRuleLogicGroupConfig
extends DEDCRuleBaseLogicConfig {
    public static final String TAG_SRFDADEDCRULELOGICGROUP = "SRFDADEDCRULELOGICGROUP";
    protected Vector<DEDCRuleBaseLogicConfig> childLogics = new Vector();
    public static final String TAG_LOGIC = "LOGIC";
    public static final String TAG_NOT = "NOT";
    protected String strLogic = "";
    protected boolean bNot = false;

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)TAG_SRFDADEDCRULELOGICGROUP, (boolean)true) == 0) {
            DEDCRuleLogicGroupConfig item = new DEDCRuleLogicGroupConfig();
            item.LoadConfig(xmlNode);
            this.childLogics.add(item);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFDADEDCRULEUSERLOGICITEM", (boolean)true) == 0) {
            DEDCRuleUserLogicItemConfig item = new DEDCRuleUserLogicItemConfig();
            item.LoadConfig(xmlNode);
            this.childLogics.add(item);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFDADEDCRULELOGICITEM", (boolean)true) == 0) {
            DEDCRuleLogicItemConfig item = new DEDCRuleLogicItemConfig();
            item.LoadConfig(xmlNode);
            this.childLogics.add(item);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_LOGIC, (boolean)true) == 0) {
            this.setLogic(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_NOT, (boolean)true) == 0) {
            this.setNot(DEDCRuleLogicGroupConfig.GetValue((String)strValue, (boolean)this.bNot));
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getLogic() {
        return this.strLogic;
    }

    public void setLogic(String strLogic) {
        this.strLogic = strLogic;
    }

    public boolean isNot() {
        return this.bNot;
    }

    public void setNot(boolean not) {
        this.bNot = not;
    }

    public Vector<DEDCRuleBaseLogicConfig> getChildLogics() {
        return this.childLogics;
    }
}

