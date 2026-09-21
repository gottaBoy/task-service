/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.BaseBuilder;
import SA.SRFramework.WebEx.Builder.SearchPanelExBuilder;
import SA.SRFramework.WebEx.Form.SRFExSearchForm;
import SA.SRFramework.WebEx.SRFExBasePanel;
import SA.SRFramework.WebEx.SRFExButton;
import SA.SRFramework.WebEx.SRFExPanel;
import SA.SRFramework.WebEx.UI.PanelConfig;
import SA.SRFramework.WebEx.UI.SearchFormConfig;
import SA.SRFramework.WebEx.UI.SearchPanelExConfig;
import SA.SRFramework.WebEx.UI.SearchPanelItemConfig;
import SA.SRFramework.WebEx.UI.SearchPanelItemsConfig;
import SA.SRFramework.WebEx.UI.SearchPanelUserParamConfig;
import SA.SRFramework.WebEx.UI.SearchPanelUserParamsConfig;
import java.io.Writer;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExSearchPanelEx
extends SRFExBasePanel {
    protected SearchPanelExConfig searchPanelConfig = null;
    private static final Log log = LogFactory.getLog(SRFExSearchPanelEx.class);
    protected SearchPanelExBuilder searchPanelExBuilder = null;
    public static String BUILDER_SEARCHPANELEX = "SEARCHPANELEX";
    protected String strLastSearchFormId = "";
    protected SRFExPanel panel = null;
    protected SRFExButton searchButton = null;
    protected SRFExButton resetButton = null;
    public static final String TAG_SRFEXSEARCHPANELEX = "SRFEXSEARCHPANELEX";

    public SearchPanelExConfig getSearchPanelExConfig() {
        return this.searchPanelConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.searchPanelConfig = null;
        if (this.config != null && this.config instanceof SearchPanelExConfig) {
            this.searchPanelConfig = (SearchPanelExConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
        this.RemoveControls();
        this.panel = null;
        if (StringHelper.Length((String)this.strLastSearchFormId) != 0) {
            this.getPage().getForms().RemoveForm(this.strLastSearchFormId);
            this.strLastSearchFormId = "";
        }
        if (this.searchPanelConfig != null) {
            SearchPanelItemConfig spItemConfig;
            SearchFormConfig searchFormConfig = this.searchPanelConfig.getSearchFormConfig();
            String strFormId = searchFormConfig.getID();
            if (StringHelper.Length((String)strFormId) == 0) {
                do {
                    strFormId = StringHelper.Format((String)"S%1$s", (Object)this.getPage().GetControlUniId());
                } while (this.getPage().getForms().FindForm(strFormId) != null);
            }
            if (this.getPage().getForms().FindForm(strFormId) != null) {
                log.error((Object)StringHelper.Format((String)"\u8868\u5355[%1$s]\u5df2\u7ecf\u5b58\u5728\uff0c\u65e0\u6cd5\u65b0\u5efa", (Object)strFormId));
                return;
            }
            SRFExSearchForm searchForm = new SRFExSearchForm();
            searchForm.setFormId(strFormId);
            searchForm.setSearchPanelId(this.getSearchPanelExConfig().getConfigId());
            searchForm.setSearchPanel(this);
            this.getPage().getForms().AddForm(searchForm);
            this.strLastSearchFormId = strFormId;
            SearchPanelUserParamsConfig searchPanelUserParamsConfig = this.getSearchPanelExConfig().getSPUserParamsConfig();
            if (searchPanelUserParamsConfig != null) {
                String strSHC = "";
                int nCount = searchPanelUserParamsConfig.getList().size();
                int i = 0;
                while (i < nCount) {
                    SearchPanelUserParamConfig searchPanelUserParamConfig = (SearchPanelUserParamConfig)((Object)searchPanelUserParamsConfig.getList().get(i));
                    if (StringHelper.Length((String)strSHC) != 0) {
                        strSHC = String.valueOf(strSHC) + ",";
                    }
                    strSHC = String.valueOf(strSHC) + StringHelper.Format((String)"%1$s:'%2$s'", (Object)searchPanelUserParamConfig.getID().toLowerCase(), (Object)searchPanelUserParamConfig.getValue());
                    ++i;
                }
                if (StringHelper.Length((String)strSHC) > 0) {
                    strSHC = "{" + strSHC;
                    strSHC = String.valueOf(strSHC) + "}";
                    searchForm.setStaticHiddenCondition(strSHC);
                }
            }
            searchForm.getSearchAction().getSuccessAction().setResetParams(searchFormConfig.getResetParams());
            PanelConfig panelConfig = new PanelConfig();
            panelConfig.setWidthEx(1.0);
            panelConfig.setCssClass("sx-searchpanel");
            panelConfig.setHeightEx(this.getSearchPanelExConfig().getHeightEx());
            SearchPanelItemsConfig spItemsConfig = this.searchPanelConfig.getSPItemsConfig();
            int nAutoItemCount = 0;
            double nAutoItemWidth = 0.99;
            double nItemWidth = 0.1;
            ArrayList<SearchPanelItemConfig> arrList = new ArrayList<SearchPanelItemConfig>();
            int i = 0;
            while (i < spItemsConfig.getList().size()) {
                spItemConfig = (SearchPanelItemConfig)((Object)spItemsConfig.getList().get(i));
                if (spItemConfig.getShowDefault()) {
                    if (spItemConfig.getWidthEx() < 0.0) {
                        nAutoItemWidth -= spItemConfig.getWidthEx();
                    } else {
                        ++nAutoItemCount;
                    }
                    arrList.add(spItemConfig);
                }
                ++i;
            }
            if (nAutoItemCount != 0) {
                nItemWidth = nAutoItemWidth / (double)nAutoItemCount;
            }
            i = 0;
            while (i < arrList.size()) {
                spItemConfig = (SearchPanelItemConfig)((Object)arrList.get(i));
                if (spItemConfig.getWidthEx() >= 0.0) {
                    spItemConfig.setWidthEx(nItemWidth);
                }
                spItemConfig.SetControlFormId(this.strLastSearchFormId);
                if (StringHelper.IsNullOrEmpty((String)spItemConfig.getCssClass())) {
                    spItemConfig.setCssClass("sx-sp-ctrl");
                }
                spItemConfig.setRenderMode("TABLE");
                panelConfig.AddPanel(spItemConfig);
                ++i;
            }
            this.panel = new SRFExPanel();
            this.panel.setConfig(panelConfig);
            this.panel.setID("Panel");
            this.AddControl(this.panel);
            this.searchButton = new SRFExButton();
            this.searchButton.InitConfig();
            this.searchButton.getButtonConfig().setID("BTN_SEARCH");
            this.searchButton.getButtonConfig().setText(this.getWebContext().getLocalText(TAG_SRFEXSEARCHPANELEX, "BTN_SEARCH_TEXT", "\u641c\u7d22"));
            this.searchButton.getButtonConfig().setTips(this.getWebContext().getLocalText(TAG_SRFEXSEARCHPANELEX, "BTN_SEARCH_TIPS", "\u641c\u7d22\u7b26\u5408\u67e5\u8be2\u6761\u4ef6\u7684\u6570\u636e"));
            this.searchButton.setResourceId("");
            this.searchButton.getButtonConfig().setJSCode(StringHelper.Format((String)"%1$s.search();", (Object)this.strLastSearchFormId));
            this.AddControl(this.searchButton);
            this.resetButton = new SRFExButton();
            this.resetButton.InitConfig();
            this.resetButton.getButtonConfig().setID("BTN_RESET");
            this.resetButton.getButtonConfig().setText(this.getWebContext().getLocalText(TAG_SRFEXSEARCHPANELEX, "BTN_RESET_TEXT", "\u6e05\u7a7a"));
            this.resetButton.getButtonConfig().setTips(this.getWebContext().getLocalText(TAG_SRFEXSEARCHPANELEX, "BTN_RESET_TIPS", "\u6e05\u7a7a\u8f93\u5165\u7684\u6761\u4ef6\u4fe1\u606f"));
            this.resetButton.setResourceId("");
            this.resetButton.getButtonConfig().setJSCode(StringHelper.Format((String)"%1$s.reset();", (Object)this.strLastSearchFormId));
            this.AddControl(this.resetButton);
        }
    }

    public SRFExSearchForm getSearchForm() {
        return (SRFExSearchForm)this.getPage().getForms().FindForm(this.strLastSearchFormId);
    }

    public SRFExPanel getPanel() {
        return this.panel;
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            this.PrepareBuilder();
            if (this.searchPanelExBuilder == null) {
                return;
            }
            this.searchPanelExBuilder.Render(writer, this);
        }
        catch (Exception ex) {
            log.error((Object)this, (Throwable)ex);
        }
    }

    protected void PrepareBuilder() {
        if (this.searchPanelExBuilder != null) {
            return;
        }
        BaseBuilder builder = this.getPage().getWebContext().FindBuilder(BUILDER_SEARCHPANELEX, this.getSearchPanelExConfig().getRenderMode());
        if (builder == null) {
            return;
        }
        if (builder instanceof SearchPanelExBuilder) {
            this.searchPanelExBuilder = (SearchPanelExBuilder)builder;
        }
    }
}

