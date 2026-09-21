/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DP.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DP.UI.DPItemConfig;
import SA.SRFramework.WebEx.DP.UI.DPPageGroupConfig;
import SA.SRFramework.WebEx.DP.UI.DPPageGroupsConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class DPTabGroupConfig
extends DPItemConfig {
    public static final String TAG_DPTABGROUP = "SRFEXDPTABGROUP";
    public static final String TAG_EXTSTYLE = "EXTSTYLE";
    public static final String TAG_ENABLECOND = "ENABLECOND";
    public static final String TAG_CSSCLASS = "CSSCLASS";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_TABGROUPID = "TABGROUPID";
    protected String strExtStyle = "";
    protected String strEnableCond = "";
    protected String strCssClass = "";
    protected String strTabGroupId = "";
    protected double fWidth = 0.0;
    protected double fHeight = 0.0;
    protected DPPageGroupsConfig pageGroupsConfig = new DPPageGroupsConfig();

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_EXTSTYLE, (boolean)true) == 0) {
            this.setExtStyle(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ENABLECOND, (boolean)true) == 0) {
            this.setEnableCond(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CSSCLASS, (boolean)true) == 0) {
            this.setCssClass(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TABGROUPID, (boolean)true) == 0) {
            this.setTabGroupId(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_WIDTH, (boolean)true) == 0) {
            if (strValue.indexOf("%") != -1) {
                strValue = strValue.replace("%", "");
                this.fWidth = Double.parseDouble(strValue);
                this.fWidth /= 100.0;
            } else {
                this.fWidth = Double.parseDouble(strValue);
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_HEIGHT, (boolean)true) == 0) {
            if (strValue.indexOf("%") != -1) {
                strValue = strValue.replace("%", "");
                this.fHeight = Double.parseDouble(strValue);
                this.fHeight /= 100.0;
            } else {
                this.fHeight = Double.parseDouble(strValue);
            }
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXDPPAGEGROUP", (boolean)true) == 0) {
            DPPageGroupConfig pageGroupConfig = new DPPageGroupConfig();
            if (pageGroupConfig.LoadConfig(xmlNode)) {
                this.pageGroupsConfig.add((Object)pageGroupConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public DPPageGroupsConfig getPageGroupsConfig() {
        return this.pageGroupsConfig;
    }

    @Override
    protected void OnGetFormCtrlConfig(ArrayList list) {
        super.OnGetFormCtrlConfig(list);
        int i = 0;
        while (i < this.pageGroupsConfig.size()) {
            DPPageGroupConfig pageGroupConfig = (DPPageGroupConfig)((Object)this.pageGroupsConfig.get(i));
            pageGroupConfig.GetFormCtrlConfig(list);
            ++i;
        }
    }

    public String getExtStyle() {
        return this.strExtStyle;
    }

    public void setExtStyle(String strExtStyle) {
        this.strExtStyle = strExtStyle;
    }

    @Override
    protected void CloneCopy(Object dst) {
        super.CloneCopy(dst);
    }

    public String getEnableCond() {
        return this.strEnableCond;
    }

    public void setEnableCond(String strEnableCond) {
        this.strEnableCond = strEnableCond;
    }

    public String getCssClass() {
        return this.strCssClass;
    }

    public void setCssClass(String strCssClass) {
        this.strCssClass = strCssClass;
    }

    public double getWidth() {
        return this.fWidth;
    }

    public double getHeight() {
        return this.fHeight;
    }

    public void setWidth(double fWidth) {
        this.fWidth = fWidth;
    }

    public void setHeight(double fHeight) {
        this.fHeight = fHeight;
    }

    public String getTabGroupId() {
        return this.strTabGroupId;
    }

    public void setTabGroupId(String strTabGroupId) {
        this.strTabGroupId = strTabGroupId;
    }
}

