/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.SP.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DP.UI.DPConfig;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import SA.SRFramework.WebEx.UI.SearchFormConfig;
import org.w3c.dom.Node;

public class SPExConfig
extends BaseControlConfig {
    public static final String TAG_SPEX = "SRFEXSPEX";
    public static final String TAG_CUSTOMSEARCH = "CUSTOMSEARCH";
    public static final String TAG_CUSTOMSEARCHJSFUNC = "CUSTOMSEARCHJSFUNC";
    public static final String TAG_RESETBUTTON = "RESETBUTTON";
    public static final String TAG_SAVELOAD = "SAVELOAD";
    public static final String TAG_DEFAULTFORM = "DEFAULTFORM";
    protected DPConfig dpConfig = null;
    protected SearchFormConfig searchFormConfig = new SearchFormConfig();
    protected boolean bCustomSearch = false;
    protected String strCustomSearchJSFunc = "";
    protected boolean bResetButton = true;
    protected boolean bDefaultForm = true;
    protected boolean bSaveLoad = false;

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXDP", (boolean)true) == 0) {
            if (this.dpConfig != null) {
                return;
            }
            this.dpConfig = new DPConfig();
            this.dpConfig.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXSEARCHFORM", (boolean)true) == 0) {
            this.searchFormConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_CUSTOMSEARCH, (boolean)true) == 0) {
            this.setCustomSearch(SPExConfig.GetValue((String)strValue, (boolean)this.isCustomSearch()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_RESETBUTTON, (boolean)true) == 0) {
            this.setResetButton(SPExConfig.GetValue((String)strValue, (boolean)this.isResetButton()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DEFAULTFORM, (boolean)true) == 0) {
            this.setDefaultForm(SPExConfig.GetValue((String)strValue, (boolean)this.isDefaultForm()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CUSTOMSEARCHJSFUNC, (boolean)true) == 0) {
            this.setCustomSearchJSFunc(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public DPConfig getDPConfig() {
        return this.dpConfig;
    }

    public SearchFormConfig getSearchFormConfig() {
        return this.searchFormConfig;
    }

    public boolean isCustomSearch() {
        return this.bCustomSearch;
    }

    public String getCustomSearchJSFunc() {
        return this.strCustomSearchJSFunc;
    }

    public void setCustomSearch(boolean bCustomSearch) {
        this.bCustomSearch = bCustomSearch;
    }

    public void setCustomSearchJSFunc(String strCustomSearchJSFunc) {
        this.strCustomSearchJSFunc = strCustomSearchJSFunc;
    }

    public boolean isResetButton() {
        return this.bResetButton;
    }

    public void setResetButton(boolean bResetButton) {
        this.bResetButton = bResetButton;
    }

    public boolean isDefaultForm() {
        return this.bDefaultForm;
    }

    public void setDefaultForm(boolean bDefaultForm) {
        this.bDefaultForm = bDefaultForm;
    }

    public boolean isSaveLoad() {
        return this.bSaveLoad;
    }

    public void setSaveLoad(boolean bSaveLoad) {
        this.bSaveLoad = bSaveLoad;
    }
}

