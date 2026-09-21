/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import SA.SRFramework.WebEx.UI.SearchFormConfig;
import SA.SRFramework.WebEx.UI.SearchPanelGroupsConfig;
import SA.SRFramework.WebEx.UI.SearchPanelItemsConfig;
import SA.SRFramework.WebEx.UI.SearchPanelUserParamsConfig;
import org.w3c.dom.Node;

public class SearchPanelConfig
extends BaseControlConfig {
    public static final String TAG_SEARCHPANEL = "SRFEXSEARCHPANEL";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPTIONCSSCLASS = "CAPTIONCSSCLASS";
    public static final String TAG_BACKENDCONFIG = "BACKENDCONFIG";
    public static final String TAG_BACKENDCTRL = "BACKENDCTRL";
    protected String strCaption = "";
    protected String strCaptionCssClass = "";
    protected SearchPanelGroupsConfig searchPanelGroupsConfig = new SearchPanelGroupsConfig(this);
    protected SearchPanelItemsConfig searchPanelItemsConfig = new SearchPanelItemsConfig(this);
    protected SearchFormConfig searchFormConfig = new SearchFormConfig();
    protected SearchPanelUserParamsConfig searchPanelUserParamsConfig = null;
    protected String strBackEndCtrl = "";
    protected String strBackEndConfig = "";

    public SearchPanelGroupsConfig getSPGroupsConfig() {
        return this.searchPanelGroupsConfig;
    }

    public SearchPanelItemsConfig getSPItemsConfig() {
        return this.searchPanelItemsConfig;
    }

    public SearchPanelUserParamsConfig getSPUserParamsConfig() {
        return this.searchPanelUserParamsConfig;
    }

    public SearchFormConfig getSearchFormConfig() {
        return this.searchFormConfig;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXSPGROUPS", (boolean)true) == 0) {
            this.searchPanelGroupsConfig.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXSPITEMS", (boolean)true) == 0) {
            this.searchPanelItemsConfig.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXSPUSERPARAMS", (boolean)true) == 0) {
            if (this.searchPanelUserParamsConfig == null) {
                this.searchPanelUserParamsConfig = new SearchPanelUserParamsConfig(this);
            }
            this.searchPanelUserParamsConfig.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXSEARCHFORM", (boolean)true) == 0) {
            this.searchFormConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_CAPTION, (boolean)true) == 0) {
            this.strCaption = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CAPTIONCSSCLASS, (boolean)true) == 0) {
            this.strCaptionCssClass = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_BACKENDCTRL, (boolean)true) == 0) {
            this.strBackEndCtrl = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_BACKENDCONFIG, (boolean)true) == 0) {
            this.strBackEndConfig = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    public String getCaption() {
        return this.strCaption;
    }

    public void setCaptionCssClass(String strCaptionCssClass) {
        this.strCaptionCssClass = strCaptionCssClass;
    }

    public String getCaptionCssClass() {
        return this.strCaptionCssClass;
    }

    public String getBackEndCtrl() {
        return this.strBackEndCtrl;
    }

    public void setBackEndCtrl(String strBackEndCtrl) {
        this.strBackEndCtrl = strBackEndCtrl;
    }

    public String getBackEndConfig() {
        return this.strBackEndConfig;
    }

    public void setBackEndConfig(String strBackEndConfig) {
        this.strBackEndConfig = strBackEndConfig;
    }
}

