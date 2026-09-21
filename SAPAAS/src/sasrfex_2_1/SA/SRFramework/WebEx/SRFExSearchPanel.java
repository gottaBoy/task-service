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
import SA.SRFramework.WebEx.Builder.SearchPanelBuilder;
import SA.SRFramework.WebEx.Form.SRFExSearchForm;
import SA.SRFramework.WebEx.SRFExBasePanel;
import SA.SRFramework.WebEx.SRFExTabPanel;
import SA.SRFramework.WebEx.UI.SearchFormConfig;
import SA.SRFramework.WebEx.UI.SearchPanelConfig;
import SA.SRFramework.WebEx.UI.SearchPanelGroupConfig;
import SA.SRFramework.WebEx.UI.SearchPanelGroupsConfig;
import SA.SRFramework.WebEx.UI.SearchPanelItemConfig;
import SA.SRFramework.WebEx.UI.SearchPanelItemsConfig;
import SA.SRFramework.WebEx.UI.SearchPanelUserParamConfig;
import SA.SRFramework.WebEx.UI.SearchPanelUserParamsConfig;
import SA.SRFramework.WebEx.UI.TabPageConfig;
import SA.SRFramework.WebEx.UI.TabPanelConfig;
import java.io.Writer;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExSearchPanel
extends SRFExBasePanel {
    protected SearchPanelConfig searchPanelConfig = null;
    private static final Log log = LogFactory.getLog(SRFExSearchPanel.class);
    protected SearchPanelBuilder searchPanelBuilder = null;
    public static String BUILDER_SEARCHPANEL = "SEARCHPANEL";
    protected String strLastSearchFormId = "";
    protected SRFExTabPanel tabPanel = null;

    public SearchPanelConfig getSearchPanelConfig() {
        return this.searchPanelConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.searchPanelConfig = null;
        if (this.config != null && this.config instanceof SearchPanelConfig) {
            this.searchPanelConfig = (SearchPanelConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
        this.RemoveControls();
        this.tabPanel = null;
        if (StringHelper.Length((String)this.strLastSearchFormId) != 0) {
            this.getPage().getForms().RemoveForm(this.strLastSearchFormId);
            this.strLastSearchFormId = "";
        }
        if (this.searchPanelConfig != null) {
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
            searchForm.setSearchPanelId(this.getSearchPanelConfig().getConfigId());
            searchForm.setSearchPanel(this);
            this.getPage().getForms().AddForm(searchForm);
            this.strLastSearchFormId = strFormId;
            SearchPanelUserParamsConfig searchPanelUserParamsConfig = this.getSearchPanelConfig().getSPUserParamsConfig();
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
            TabPanelConfig tabPanelConfig = new TabPanelConfig();
            TreeMap<String, TabPageConfig> tabPageMap = new TreeMap<String, TabPageConfig>();
            SearchPanelGroupsConfig spGroupsConfig = this.searchPanelConfig.getSPGroupsConfig();
            TabPageConfig defaultTabConfig = null;
            int i = 0;
            while (i < spGroupsConfig.getList().size()) {
                SearchPanelGroupConfig spGroupConfig = (SearchPanelGroupConfig)((Object)spGroupsConfig.getList().get(i));
                TabPageConfig tabPageConfig = new TabPageConfig();
                tabPageConfig.setID(spGroupConfig.getID());
                tabPageConfig.setCaption(spGroupConfig.getCaption());
                tabPageConfig.setCaptionCssClass(spGroupConfig.getCaptionCssClass());
                tabPageMap.put(spGroupConfig.getID().toUpperCase(), tabPageConfig);
                tabPanelConfig.AddTabPage(tabPageConfig);
                if (defaultTabConfig != null && spGroupConfig.getDefault()) {
                    defaultTabConfig = tabPageConfig;
                }
                ++i;
            }
            SearchPanelItemsConfig spItemsConfig = this.searchPanelConfig.getSPItemsConfig();
            int i2 = 0;
            while (i2 < spItemsConfig.getList().size()) {
                SearchPanelItemConfig spItemConfig = (SearchPanelItemConfig)((Object)spItemsConfig.getList().get(i2));
                if (spItemConfig.getShowDefault()) {
                    TabPageConfig tabPageConfig = null;
                    tabPageConfig = tabPageMap.containsKey(spItemConfig.getGroupId().toUpperCase()) ? (TabPageConfig)tabPageMap.get(spItemConfig.getGroupId().toUpperCase()) : defaultTabConfig;
                    if (tabPageConfig != null) {
                        spItemConfig.SetControlFormId(this.strLastSearchFormId);
                        tabPageConfig.AddPanel(spItemConfig);
                    }
                }
                ++i2;
            }
            this.tabPanel = new SRFExTabPanel();
            this.tabPanel.setConfig(tabPanelConfig);
            this.AddControl(this.tabPanel);
        }
    }

    public SRFExSearchForm getSearchForm() {
        return (SRFExSearchForm)this.getPage().getForms().FindForm(this.strLastSearchFormId);
    }

    public SRFExTabPanel getTabPanel() {
        return this.tabPanel;
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            this.PrepareBuilder();
            if (this.searchPanelBuilder == null) {
                return;
            }
            this.searchPanelBuilder.RenderBegin(writer, this);
            if (this.tabPanel != null) {
                this.tabPanel.Render(writer);
            }
            this.searchPanelBuilder.RenderEnd(writer, this);
        }
        catch (Exception ex) {
            log.error((Object)this, (Throwable)ex);
        }
    }

    protected void PrepareBuilder() {
        if (this.searchPanelBuilder != null) {
            return;
        }
        BaseBuilder builder = this.getPage().getWebContext().FindBuilder(BUILDER_SEARCHPANEL, this.getSearchPanelConfig().getRenderMode());
        if (builder == null) {
            return;
        }
        if (builder instanceof SearchPanelBuilder) {
            this.searchPanelBuilder = (SearchPanelBuilder)builder;
        }
    }
}

