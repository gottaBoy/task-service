/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx.SP;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.BaseBuilder;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.Form.SRFExSearchForm;
import SA.SRFramework.WebEx.SP.SPExBuilder;
import SA.SRFramework.WebEx.SP.UI.SPExConfig;
import SA.SRFramework.WebEx.SRFExBasePanel;
import SA.SRFramework.WebEx.SRFExButton;
import SA.SRFramework.WebEx.UI.SearchFormConfig;
import java.io.Writer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExSPEx
extends SRFExBasePanel {
    protected SPExConfig spExConfig = null;
    private static final Log log = LogFactory.getLog(SRFExSPEx.class);
    protected SPExBuilder spExBuilder = null;
    public static String BUILDER_SPEX = "SPEX";
    protected String strLastSearchFormId = "";
    protected SRFExDPEx panel = null;
    protected SRFExButton searchButton = null;
    protected SRFExButton resetButton = null;
    protected boolean bEnableItemPrivilege = false;

    public SPExConfig getSPExConfig() {
        return this.spExConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.spExConfig = null;
        if (this.config != null && this.config instanceof SPExConfig) {
            this.spExConfig = (SPExConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
        this.RemoveControls();
        this.panel = null;
        this.searchButton = null;
        this.resetButton = null;
        if (StringHelper.Length((String)this.strLastSearchFormId) != 0) {
            this.getPage().getForms().RemoveForm(this.strLastSearchFormId);
            this.strLastSearchFormId = "";
        }
        if (this.spExConfig != null) {
            SearchFormConfig searchFormConfig = this.spExConfig.getSearchFormConfig();
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
            searchForm.setSearchPanelId(this.getSPExConfig().getConfigId());
            searchForm.setSearchPanel(this);
            this.getPage().getForms().AddForm(searchForm);
            this.strLastSearchFormId = strFormId;
            if (this.spExConfig.isDefaultForm()) {
                this.getPage().setDefaultFormId(this.strLastSearchFormId);
            }
            this.searchButton = new SRFExButton();
            this.searchButton.InitConfig();
            this.searchButton.getButtonConfig().setWidth(60);
            this.searchButton.getButtonConfig().setID("searchButton");
            this.searchButton.getButtonConfig().setText(this.getWebContext().getGlobalHelper().getLocalizationHelper().GetLocalization(this.getWebContext().getLocalization(), "CONTROL.SPEX.SEARCH.TEXT", "\u641c\u7d22"));
            this.searchButton.getButtonConfig().setTips(this.getWebContext().getGlobalHelper().getLocalizationHelper().GetLocalization(this.getWebContext().getLocalization(), "CONTROL.SPEX.SEARCH.TIPS", "\u641c\u7d22"));
            this.searchButton.getButtonConfig().setJSCode(StringHelper.Format((String)"%1$s.search();", (Object)strFormId));
            this.searchButton.setResourceId("");
            this.AddControl(this.searchButton);
            if (this.spExConfig.isResetButton()) {
                this.resetButton = new SRFExButton();
                this.resetButton.InitConfig();
                this.resetButton.getButtonConfig().setWidth(60);
                this.resetButton.getButtonConfig().setID("resetButton");
                this.resetButton.getButtonConfig().setText(this.getWebContext().getGlobalHelper().getLocalizationHelper().GetLocalization(this.getWebContext().getLocalization(), "CONTROL.SPEX.RESET.TEXT", "\u6e05\u7a7a"));
                this.resetButton.getButtonConfig().setTips(this.getWebContext().getGlobalHelper().getLocalizationHelper().GetLocalization(this.getWebContext().getLocalization(), "CONTROL.SPEX.RESET.TEXT", "\u6e05\u7a7a"));
                this.resetButton.getButtonConfig().setJSCode(StringHelper.Format((String)"%1$s.reset();", (Object)strFormId));
                this.resetButton.setResourceId("");
                this.AddControl(this.resetButton);
            }
            if (this.spExConfig.getDPConfig() != null) {
                this.panel = new SRFExDPEx();
                this.panel.setConfig(this.spExConfig.getDPConfig());
                this.panel.setID("Panel");
                this.panel.getDPConfig().setReturnNav(false);
                this.AddControl(this.panel);
            }
        }
    }

    public SRFExSearchForm getSearchForm() {
        return (SRFExSearchForm)this.getPage().getForms().FindForm(this.strLastSearchFormId);
    }

    public SRFExDPEx getPanel() {
        return this.panel;
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            this.PrepareBuilder();
            if (this.spExBuilder == null) {
                return;
            }
            this.spExBuilder.Render(writer, this);
        }
        catch (Exception ex) {
            log.error((Object)this, (Throwable)ex);
        }
    }

    protected void PrepareBuilder() {
        if (this.spExBuilder != null) {
            return;
        }
        BaseBuilder builder = this.getPage().getWebContext().FindBuilder(BUILDER_SPEX, this.getSPExConfig().getRenderMode());
        if (builder == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5b9a\u4f4d\u6784\u5efa\u5668[%1$s:%2$s]", (Object)BUILDER_SPEX, (Object)this.getSPExConfig().getRenderMode()));
            return;
        }
        if (builder instanceof SPExBuilder) {
            this.spExBuilder = (SPExBuilder)builder;
        }
    }

    public boolean isEnableItemPrivilege() {
        return this.bEnableItemPrivilege;
    }

    public void setEnableItemPrivilege(boolean bEnableItemPrivilege) {
        this.bEnableItemPrivilege = bEnableItemPrivilege;
    }
}

