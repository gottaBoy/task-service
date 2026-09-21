/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.PanelConfig;
import SA.SRFramework.WebEx.UI.RepeatListControlConfig;
import java.util.ArrayList;
import java.util.Vector;
import org.w3c.dom.Node;

public class CheckBoxListConfig
extends RepeatListControlConfig {
    public static final String TAG_CHECKBOXLIST = "SRFEXCHECKBOXLIST";
    public static final String TAG_SEPARATOR = "SEPARATOR";
    public static final String TAG_NUMBERORMODE = "NUMBERORMODE";
    public static final String TAG_ENABLECHECKALL = "ENABLECHECKALL";
    public static final String TAG_CHECKALLCAPTION = "CHECKALLCAPTION";
    protected String strSeparator = "|";
    protected boolean bNumberOrMode = false;
    protected boolean bEnableCheckAll = false;
    protected String strCheckAllCaption = "";
    protected Vector<PanelConfig> childPanels = null;

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXPANEL", (boolean)true) == 0) {
            if (this.childPanels == null) {
                this.childPanels = new Vector();
            }
            PanelConfig panelConfig = new PanelConfig();
            panelConfig.LoadConfig(xmlNode);
            this.childPanels.add(panelConfig);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public Vector<PanelConfig> getValuePanelConfigs() {
        return this.childPanels;
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_SEPARATOR, (boolean)true) == 0) {
            this.strSeparator = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_NUMBERORMODE, (boolean)true) == 0) {
            this.bNumberOrMode = CheckBoxListConfig.GetValue((String)strValue, (boolean)this.bNumberOrMode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ENABLECHECKALL, (boolean)true) == 0) {
            this.bEnableCheckAll = CheckBoxListConfig.GetValue((String)strValue, (boolean)this.bEnableCheckAll);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CHECKALLCAPTION, (boolean)true) == 0) {
            this.strCheckAllCaption = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getSeparator() {
        return this.strSeparator;
    }

    public void setSeparator(String strSeparator) {
        this.strSeparator = strSeparator;
    }

    public boolean getNumberOrMode() {
        return this.bNumberOrMode;
    }

    public void setNumberOrMode(boolean bNumberOrMode) {
        this.bNumberOrMode = bNumberOrMode;
    }

    public boolean getEnableCheckAll() {
        return this.bEnableCheckAll;
    }

    public String getCheckAllCaption() {
        return this.strCheckAllCaption;
    }

    public void setEnableCheckAll(boolean bEnableCheckAll) {
        this.bEnableCheckAll = bEnableCheckAll;
    }

    public void setCheckAllCaption(String strCheckAllCaption) {
        this.strCheckAllCaption = strCheckAllCaption;
    }

    public ArrayList getSelectedValues() {
        ArrayList<String> list = new ArrayList<String>();
        String[] arr = this.getSelectedValue().split(this.strSeparator);
        int i = 0;
        while (i < arr.length) {
            if (StringHelper.Length((String)arr[i]) != 0) {
                list.add(arr[i]);
            }
            ++i;
        }
        return list;
    }
}

