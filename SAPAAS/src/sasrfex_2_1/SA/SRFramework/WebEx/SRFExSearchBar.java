/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExButton;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDropDownList;
import SA.SRFramework.WebEx.SRFExSearchPanel;
import SA.SRFramework.WebEx.SRFExTextBox;
import SA.SRFramework.WebEx.UI.SearchBarConfig;
import java.io.Writer;

public class SRFExSearchBar
extends SRFExControl {
    protected SearchBarConfig searchBarConfig = null;
    protected SRFExButton saveButton = null;
    protected SRFExButton removeButton = null;
    protected SRFExButton searchButton = null;
    protected SRFExButton refreshButton = null;
    protected SRFExButton resetButton = null;
    protected SRFExButton okButton = null;
    protected SRFExButton cancelButton = null;
    protected SRFExDropDownList searchThemeList = null;
    protected SRFExSearchPanel searchPanel = null;
    protected SRFExTextBox nameTextBox = null;
    public static final String TAG_SRFEXSEARCHBAR = "SRFEXSEARCHBAR";

    @Override
    protected XMLConfig CreateConfig() {
        return new SearchBarConfig();
    }

    public SearchBarConfig getSearchBarConfig() {
        if (this.searchBarConfig == null) {
            this.InitConfig();
        }
        return this.searchBarConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.searchBarConfig = null;
        if (this.config != null && this.config instanceof SearchBarConfig) {
            this.searchBarConfig = (SearchBarConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
        this.RemoveControls();
        this.searchButton = null;
        this.resetButton = null;
        this.searchThemeList = null;
        this.saveButton = null;
        this.removeButton = null;
        this.okButton = null;
        this.cancelButton = null;
        this.nameTextBox = null;
        if (this.searchBarConfig != null) {
            this.searchButton = new SRFExButton();
            this.searchButton.InitConfig();
            this.searchButton.getButtonConfig().setID("BTN_SEARCH");
            this.searchButton.getButtonConfig().setText(this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "BTN_SEARCH_TEXT", "\u641c\u7d22"));
            this.searchButton.getButtonConfig().setTips(this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "BTN_SEARCH_TIPS", "\u641c\u7d22\u7b26\u5408\u67e5\u8be2\u6761\u4ef6\u7684\u6570\u636e"));
            this.AddControl(this.searchButton);
            this.resetButton = new SRFExButton();
            this.resetButton.InitConfig();
            this.resetButton.getButtonConfig().setID("BTN_RESET");
            this.resetButton.getButtonConfig().setText(this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "BTN_RESET_TEXT", "\u6e05\u7a7a"));
            this.resetButton.getButtonConfig().setTips(this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "BTN_RESET_TIPS", "\u6e05\u7a7a\u8f93\u5165\u7684\u6761\u4ef6\u4fe1\u606f"));
            this.resetButton.setResourceId("");
            this.AddControl(this.resetButton);
            if (this.searchBarConfig.getSupportCustom()) {
                this.searchThemeList = new SRFExDropDownList();
                this.searchThemeList.InitConfig();
                this.searchThemeList.getDropDownListConfig().setID("DDL_SEARCHTHEMELIST");
                if (this.searchBarConfig.getSmallMode()) {
                    this.searchThemeList.getDropDownListConfig().setWidth(100);
                } else {
                    this.searchThemeList.getDropDownListConfig().setWidth(130);
                }
                this.AddControl(this.searchThemeList);
                this.refreshButton = new SRFExButton();
                this.refreshButton.InitConfig();
                this.refreshButton.getButtonConfig().setID("BTN_REFRESHST");
                if (this.searchBarConfig.getSmallMode()) {
                    this.refreshButton.getButtonConfig().setText(this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "BTN_REFRESHST_SHORTTEXT", "\u5237\u65b0"));
                } else {
                    this.refreshButton.getButtonConfig().setText(this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "BTN_REFRESHST_TEXT", "\u5237\u65b0\u641c\u7d22\u4e3b\u9898"));
                }
                this.refreshButton.getButtonConfig().setTips(this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "BTN_REFRESHST_TIPS", "\u5237\u65b0\u5f53\u524d\u7684\u641c\u7d22\u4e3b\u9898"));
                this.refreshButton.setResourceId("");
                this.AddControl(this.refreshButton);
                this.saveButton = new SRFExButton();
                this.saveButton.InitConfig();
                this.saveButton.getButtonConfig().setID("BTN_SAVE");
                if (this.searchBarConfig.getSmallMode()) {
                    this.saveButton.getButtonConfig().setText(this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "BTN_SAVE_SHORTTEXT", "\u4fdd\u5b58"));
                } else {
                    this.saveButton.getButtonConfig().setText(this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "BTN_SAVE_TEXT", "\u4fdd\u5b58\u67e5\u8be2\u6761\u4ef6"));
                }
                this.saveButton.getButtonConfig().setTips(this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "BTN_SAVE_TIPS", "\u4fdd\u5b58\u5f53\u524d\u67e5\u8be2\u6761\u4ef6"));
                this.saveButton.setResourceId("");
                this.AddControl(this.saveButton);
                this.removeButton = new SRFExButton();
                this.removeButton.InitConfig();
                this.removeButton.getButtonConfig().setID("BTN_REMOVE");
                this.removeButton.getButtonConfig().setVisible(false);
                this.removeButton.getButtonConfig().setText(this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "BTN_REMOVE_TEXT", "\u5220\u9664"));
                this.removeButton.getButtonConfig().setTips(this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "BTN_REMOVE_TIPS", "\u5220\u9664\u5f53\u524d\u7684\u641c\u7d22\u4e3b\u9898"));
                this.removeButton.getButtonConfig().setAlwaysOutput(true);
                this.removeButton.setResourceId("");
                this.AddControl(this.removeButton);
                this.nameTextBox = new SRFExTextBox();
                this.nameTextBox.InitConfig();
                this.nameTextBox.setID("TBX_NAME");
                this.nameTextBox.getTextBoxConfig().setWidth(130);
                this.AddControl(this.nameTextBox);
                this.okButton = new SRFExButton();
                this.okButton.InitConfig();
                this.okButton.getButtonConfig().setID("BTN_OK");
                this.okButton.getButtonConfig().setText(this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "BTN_OK_TEXT", "\u4fdd\u5b58"));
                this.okButton.getButtonConfig().setTips(this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "BTN_OK_TIPS", "\u4fdd\u5b58\u641c\u7d22\u4e3b\u9898\u540d\u79f0"));
                this.okButton.setResourceId("");
                this.AddControl(this.okButton);
                this.cancelButton = new SRFExButton();
                this.cancelButton.InitConfig();
                this.cancelButton.getButtonConfig().setID("BTN_CANCEL");
                this.cancelButton.getButtonConfig().setText(this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "BTN_CANCEL_TEXT", "\u8fd4\u56de"));
                this.cancelButton.getButtonConfig().setTips(this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "BTN_CANCEL_TIPS", "\u8fd4\u56de"));
                this.cancelButton.setResourceId("");
                this.AddControl(this.cancelButton);
            }
        }
    }

    public void setSearchPanel(SRFExSearchPanel searchPanel) {
        this.searchPanel = searchPanel;
    }

    public SRFExSearchPanel getSearchPanel() {
        return this.searchPanel;
    }

    public SRFExDropDownList getSearchThemeList() {
        return this.searchThemeList;
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            writer.write(StringHelper.Format((String)"<table id='%2$s_1' width='%1$s' border='0' cellspacing='0' cellpadding='0'>", (Object)(this.getSearchBarConfig().getWidth() == 0 ? "100%" : Integer.valueOf(this.getSearchBarConfig().getWidth())), (Object)this.getUniqueID()));
            if (this.getSearchBarConfig().getHeight() != 0) {
                writer.write(StringHelper.Format((String)"<tr height='%1$s'>", (Object)this.getSearchBarConfig().getHeight()));
            } else {
                writer.write(StringHelper.Format((String)"<tr >"));
            }
            if (this.searchBarConfig.getSupportCustom()) {
                if (this.searchBarConfig.getSmallMode()) {
                    writer.write(StringHelper.Format((String)"<td width='160' style='padding-top: 3px;'>&nbsp;<SPAN class='sx-normaltext'>%1$s</SPAN>&nbsp;", (Object)this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "SHORTCAPTION", "\u4e3b\u9898")));
                    this.searchThemeList.Render(writer);
                    writer.write(StringHelper.Format((String)"</td>"));
                    writer.write(StringHelper.Format((String)"<td width='160'>"));
                } else {
                    writer.write(StringHelper.Format((String)"<td width='210' style='padding-top: 3px;'>&nbsp;<SPAN class='sx-normaltext'>%1$s</SPAN>&nbsp;", (Object)this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "CAPTION", "\u641c\u7d22\u4e3b\u9898")));
                    this.searchThemeList.Render(writer);
                    writer.write(StringHelper.Format((String)"</td>"));
                    writer.write(StringHelper.Format((String)"<td width='260'>"));
                }
                this.refreshButton.Render(writer);
                this.saveButton.Render(writer);
                this.removeButton.Render(writer);
                writer.write(StringHelper.Format((String)"</td>"));
            } else if (this.searchBarConfig.getSmallMode()) {
                writer.write(StringHelper.Format((String)"<td width='260' style='padding-top: 3px;'>&nbsp;<SPAN class='sx-normaltext'>\u5f53\u524d\u641c\u7d22\u4e0d\u63d0\u4ea4\u641c\u7d22\u4e3b\u9898\u652f\u6301</SPAN>&nbsp;", (Object)this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "UNSUPPORTTHEME", "\u5f53\u524d\u641c\u7d22\u4e0d\u63d0\u4ea4\u641c\u7d22\u4e3b\u9898\u652f\u6301")));
            } else {
                writer.write(StringHelper.Format((String)"<td width='360' style='padding-top: 3px;'>&nbsp;<SPAN class='sx-normaltext'>\u5f53\u524d\u641c\u7d22\u4e0d\u63d0\u4ea4\u641c\u7d22\u4e3b\u9898\u652f\u6301</SPAN>&nbsp;", (Object)this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "UNSUPPORTTHEME", "\u5f53\u524d\u641c\u7d22\u4e0d\u63d0\u4ea4\u641c\u7d22\u4e3b\u9898\u652f\u6301")));
            }
            writer.write(StringHelper.Format((String)"<td>&nbsp;</td>"));
            writer.write(StringHelper.Format((String)"<td align='right' width='60'>"));
            this.resetButton.Render(writer);
            writer.write("</td>");
            writer.write(StringHelper.Format((String)"<td align='right' width='80'>"));
            this.searchButton.Render(writer);
            writer.write("</td>");
            writer.write(StringHelper.Format((String)"<td align='center' width='15'>"));
            writer.write(StringHelper.Format((String)"<a href='#' onclick=\"javascript:$P.searchbar['%1$s'].showsp(true)\"><img id='IMG_%1$s_E' src='../sasrfex/images/default/icon_expand.png' border='0' style='display:none' alt='\u663e\u793a\u641c\u7d22\u5206\u533a'></a>", (Object)this.getUniqueID()));
            writer.write(StringHelper.Format((String)"<a href='#' onclick=\"javascript:$P.searchbar['%1$s'].showsp(false)\"><img id='IMG_%1$s_C' src='../sasrfex/images/default/icon_collapse.png' border='0' style='display:none' alt='\u9690\u85cf\u641c\u7d22\u5206\u533a'></a>", (Object)this.getUniqueID()));
            writer.write("</td>");
            writer.write(StringHelper.Format((String)"</tr></table>"));
            if (this.searchBarConfig.getSupportCustom()) {
                writer.write(StringHelper.Format((String)"<table id='%2$s_2' width='%1$s' border='0' cellspacing='0' cellpadding='0' style='display:none;'>", (Object)(this.getSearchBarConfig().getWidth() == 0 ? "100%" : Integer.valueOf(this.getSearchBarConfig().getWidth())), (Object)this.getUniqueID()));
                if (this.getSearchBarConfig().getHeight() != 0) {
                    writer.write(StringHelper.Format((String)"<tr height='%1$s'>", (Object)this.getSearchBarConfig().getHeight()));
                } else {
                    writer.write(StringHelper.Format((String)"<tr >"));
                }
                writer.write(StringHelper.Format((String)"<td width='210' style='padding-top: 3px;'>&nbsp;<SPAN class='sx-normaltext'>%1$s</SPAN>&nbsp;", (Object)this.getWebContext().getLocalText(TAG_SRFEXSEARCHBAR, "CAPTION", "\u4e3b\u9898\u540d\u79f0")));
                this.nameTextBox.Render(writer);
                writer.write(StringHelper.Format((String)"</td>"));
                writer.write(StringHelper.Format((String)"<td width='200'>"));
                this.okButton.Render(writer);
                this.cancelButton.Render(writer);
                writer.write(StringHelper.Format((String)"</td>"));
                writer.write(StringHelper.Format((String)"<td>&nbsp;</td>"));
                writer.write(StringHelper.Format((String)"</tr></table>"));
            }
            StringBuilderEx script = new StringBuilderEx();
            script.Append("var opt = {};\r\n");
            String strSearchThemeURL = this.getPage().getWebContext().getWebConfig().GetExtValue("SEARCHTHEME", "");
            if (StringHelper.Length((String)strSearchThemeURL) != 0) {
                strSearchThemeURL = strSearchThemeURL.indexOf("?") == -1 ? String.valueOf(strSearchThemeURL) + "?" : String.valueOf(strSearchThemeURL) + "&";
                strSearchThemeURL = String.valueOf(strSearchThemeURL) + StringHelper.Format((String)"%1$s=%2$s", (Object)"SEARCHPANELID", (Object)this.searchPanel.getSearchPanelConfig().getConfigId());
                script.Append("opt.sturl = '%1$s';\r\n", strSearchThemeURL);
            }
            script.Append("opt.id = '%1$s';\r\n", this.getUniqueID());
            if (this.searchButton != null) {
                script.Append("opt.searchbtn= '%1$s';\r\n", this.searchButton.getUniqueID());
            }
            if (this.resetButton != null) {
                script.Append("opt.resetbtn = '%1$s';\r\n", this.resetButton.getUniqueID());
            }
            if (this.refreshButton != null) {
                script.Append("opt.refreshbtn = '%1$s';\r\n", this.refreshButton.getUniqueID());
            }
            if (this.searchThemeList != null) {
                script.Append("opt.stlistid = '%1$s';\r\n", this.searchThemeList.getUniqueID());
            }
            if (this.saveButton != null) {
                script.Append("opt.savebtn ='%1$s';\r\n", this.saveButton.getUniqueID());
            }
            if (this.removeButton != null) {
                script.Append("opt.removebtn = '%1$s';\r\n", this.removeButton.getUniqueID());
            }
            if (this.cancelButton != null) {
                script.Append("opt.cancelbtn = '%1$s';\r\n", this.cancelButton.getUniqueID());
            }
            if (this.okButton != null) {
                script.Append("opt.okbtn = '%1$s';\r\n", this.okButton.getUniqueID());
            }
            if (this.nameTextBox != null) {
                script.Append("opt.nametb = '%1$s';\r\n", this.nameTextBox.getUniqueID());
            }
            script.Append("opt.expandimg = 'IMG_%1$s_E';\r\n", this.getUniqueID());
            script.Append("opt.collapseimg = 'IMG_%1$s_C';\r\n", this.getUniqueID());
            if (this.searchPanel != null) {
                script.Append("opt.spitem = '%1$s';\r\n", this.searchPanel.getUniqueID());
                if (StringHelper.Length((String)this.searchPanel.getSearchForm().getFormId()) > 0) {
                    script.Append("opt.sf = $P.form['%1$s']._FORM;\r\n", this.searchPanel.getSearchForm().getFormId());
                }
                if (StringHelper.Length((String)this.searchPanel.getSearchPanelConfig().getConfigId()) > 0) {
                    script.Append("opt.spid = '%1$s';\r\n", this.searchPanel.getSearchPanelConfig().getConfigId());
                }
            }
            script.Append("var varSearchBar = new SRFSearchBar(opt);\r\n");
            script.Append("$P.searchbar['%1$s'] = varSearchBar;\r\n", this.getUniqueID());
            if (this.getSearchBarConfig().isSPExpand()) {
                script.Append("varSearchBar.showsp(true);\r\n", this.getUniqueID());
            } else {
                script.Append("varSearchBar.showsp(false);\r\n", this.getUniqueID());
            }
            if (this.getSearchBarConfig().getSearchOnReady()) {
                script.Append("varSearchBar.loadcondition();\r\n", this.getUniqueID());
            }
            this.getPage().RegisterOnReadyScript(3, script.toString());
            this.getSearchBarConfig().isSPExpand();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

