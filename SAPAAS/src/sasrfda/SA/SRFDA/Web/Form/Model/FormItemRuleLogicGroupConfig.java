/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Web.Form.Model;

import SA.SRFDA.Web.Form.Model.FormItemRuleBaseLogicConfig;
import SA.SRFDA.Web.Form.Model.FormItemRuleLogicItemConfig;
import SA.SRFDA.Web.Form.Model.FormItemRuleUserLogicItemConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.w3c.dom.Node;

public class FormItemRuleLogicGroupConfig
extends FormItemRuleBaseLogicConfig {
    public static final String TAG_SRFDAFORMITEMRULELOGICGROUP = "SRFDAFORMITEMRULELOGICGROUP";
    protected Vector<FormItemRuleBaseLogicConfig> childLogics = new Vector();
    public static final String TAG_LOGIC = "LOGIC";
    public static final String TAG_NOT = "NOT";
    protected String strLogic = "";
    protected boolean bNot = false;

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)TAG_SRFDAFORMITEMRULELOGICGROUP, (boolean)true) == 0) {
            FormItemRuleLogicGroupConfig item = new FormItemRuleLogicGroupConfig();
            item.LoadConfig(xmlNode);
            this.childLogics.add(item);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFDAFORMITEMRULEUSERLOGICITEM", (boolean)true) == 0) {
            FormItemRuleUserLogicItemConfig item = new FormItemRuleUserLogicItemConfig();
            item.LoadConfig(xmlNode);
            this.childLogics.add(item);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFDAFORMITEMRULELOGICITEM", (boolean)true) == 0) {
            FormItemRuleLogicItemConfig item = new FormItemRuleLogicItemConfig();
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
            this.setNot(FormItemRuleLogicGroupConfig.GetValue((String)strValue, (boolean)this.bNot));
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

    public Vector<FormItemRuleBaseLogicConfig> getChildLogics() {
        return this.childLogics;
    }
}

