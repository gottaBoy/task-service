/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Builder.StyleBuilder
 *  SA.SRFramework.WebEx.DP.DPFormItemEnableRuleHelper
 *  SA.SRFramework.WebEx.DP.DefaultDPExBuilder
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.DP.UI.DPBaseFormItemConfig
 *  SA.SRFramework.WebEx.DP.UI.DPBaseGroupConfig
 *  SA.SRFramework.WebEx.DP.UI.DPConfig
 *  SA.SRFramework.WebEx.DP.UI.DPDataGridItemConfig
 *  SA.SRFramework.WebEx.DP.UI.DPGroupConfig
 *  SA.SRFramework.WebEx.DP.UI.DPItemConfig
 *  SA.SRFramework.WebEx.DP.UI.DPPageGroupConfig
 *  SA.SRFramework.WebEx.DP.UI.DPRawItemConfig
 *  SA.SRFramework.WebEx.DP.UI.DPSpaceItemConfig
 *  SA.SRFramework.WebEx.DP.UI.DPTabGroupConfig
 *  SA.SRFramework.WebEx.ISRFExFormItem
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  freemarker.cache.StringTemplateLoader
 *  freemarker.cache.TemplateLoader
 *  freemarker.template.Configuration
 *  freemarker.template.Template
 *  freemarker.template.TemplateException
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web.Render;

import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Render.FIMacroParam;
import SA.SRFDA.Web.Render.FormMacroParam;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.DP.DPFormItemEnableRuleHelper;
import SA.SRFramework.WebEx.DP.DefaultDPExBuilder;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.DP.UI.DPBaseFormItemConfig;
import SA.SRFramework.WebEx.DP.UI.DPBaseGroupConfig;
import SA.SRFramework.WebEx.DP.UI.DPConfig;
import SA.SRFramework.WebEx.DP.UI.DPDataGridItemConfig;
import SA.SRFramework.WebEx.DP.UI.DPGroupConfig;
import SA.SRFramework.WebEx.DP.UI.DPItemConfig;
import SA.SRFramework.WebEx.DP.UI.DPPageGroupConfig;
import SA.SRFramework.WebEx.DP.UI.DPRawItemConfig;
import SA.SRFramework.WebEx.DP.UI.DPSpaceItemConfig;
import SA.SRFramework.WebEx.DP.UI.DPTabGroupConfig;
import SA.SRFramework.WebEx.ISRFExFormItem;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExWebContext;
import freemarker.cache.StringTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DPExBuilder4
extends DefaultDPExBuilder {
    private static final Log log = LogFactory.getLog(DPExBuilder4.class);
    private static Hashtable<String, Configuration> configMap = new Hashtable();
    private boolean bRenderPageGroup = false;

    public void Render(Writer writer, SRFExDPEx dpEx) {
        StringWriter sw;
        Template template;
        super.Render(writer, dpEx);
        if (dpEx.getPage().IsBackEndMode()) {
            return;
        }
        String strFIVCScript = dpEx.getDPConfig().GetExtValue("FIVCSCRIPT", "");
        String strFormScript = dpEx.getDPConfig().GetExtValue("FORMSCRIPTEX", "");
        String strFormScript2 = dpEx.getDPConfig().GetExtValue("FORMSCRIPTEX2", "");
        String strFormBSScript = dpEx.getDPConfig().GetExtValue("FORMBSSCRIPT", "");
        if (StringHelper.IsNullOrEmpty((String)strFIVCScript) && StringHelper.IsNullOrEmpty((String)strFormScript) && StringHelper.IsNullOrEmpty((String)strFormScript2) && StringHelper.IsNullOrEmpty((String)strFormBSScript)) {
            return;
        }
        Configuration config = DPExBuilder4.GetConfiguration(dpEx.getDPConfig());
        if (config == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u52a8\u6001\u9762\u677f[%1$s]\u6a21\u677f\u8f85\u52a9\u5bf9\u8c61", (Object)dpEx.getDPConfig().getID()));
            return;
        }
        Date startDate = new Date();
        SRFDAPage page = (SRFDAPage)dpEx.getPage();
        TreeMap<String, Object> params = new TreeMap<String, Object>();
        MacroHelper.FillMacroParams(params, (ISRFDAWebContext)page.getWebContext(), (ISRFDAGlobalHelper)page.getWebContext().getGlobalHelper(), (String)page.getWebContext().getCurUserId(), null, null, (String)"");
        FIMacroParam fiMacroParam = new FIMacroParam();
        fiMacroParam.setForm(this.form);
        params.put("fi", fiMacroParam);
        FormMacroParam formMacroParam = new FormMacroParam();
        formMacroParam.setForm(this.form);
        params.put("form", formMacroParam);
        if (!StringHelper.IsNullOrEmpty((String)strFIVCScript)) {
            try {
                template = config.getTemplate("FIVCSCRIPT");
                sw = new StringWriter();
                template.process(params, (Writer)sw);
                this.form.getItemValueChangedAction().AppendAfterCode(sw.toString());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (TemplateException e) {
                e.printStackTrace();
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strFormBSScript)) {
            try {
                template = config.getTemplate("FORMBSSCRIPT");
                sw = new StringWriter();
                template.process(params, (Writer)sw);
                this.form.getSaveAction().AppendBeforeCode(sw.toString());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (TemplateException e) {
                e.printStackTrace();
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strFormScript)) {
            try {
                template = config.getTemplate("FORMSCRIPTEX");
                sw = new StringWriter();
                template.process(params, (Writer)sw);
                dpEx.getPage().RegisterScript(3, sw.toString());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (TemplateException e) {
                e.printStackTrace();
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strFormScript2)) {
            try {
                template = config.getTemplate("FORMSCRIPTEX2");
                sw = new StringWriter();
                template.process(params, (Writer)sw);
                dpEx.getPage().RegisterOnReadyScript(3, sw.toString());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (TemplateException e) {
                e.printStackTrace();
            }
        }
        Date endDate = new Date();
        log.debug((Object)StringHelper.Format((String)"\u52a8\u6001\u9762\u677f\u52a8\u6001\u811a\u672c\u5904\u7406\u65f6\u95f4[%1$s]", (Object)(endDate.getTime() - startDate.getTime())));
    }

    protected void OnReset() {
        super.OnReset();
    }

    protected static Configuration GetConfiguration(DPConfig dpConfig) {
        Configuration config = null;
        String strId = dpConfig.getConfigId();
        if (!StringHelper.IsNullOrEmpty((String)strId)) {
            config = configMap.get(strId);
        }
        if (config != null) {
            return config;
        }
        String strFIVCScript = dpConfig.GetExtValue("FIVCSCRIPT", "");
        String strFormScript = dpConfig.GetExtValue("FORMSCRIPTEX", "");
        String strFormScript2 = dpConfig.GetExtValue("FORMSCRIPTEX2", "");
        String strFormBSScript = dpConfig.GetExtValue("FORMBSSCRIPT", "");
        StringTemplateLoader dpTemplate = new StringTemplateLoader();
        dpTemplate.putTemplate("FIVCSCRIPT", strFIVCScript);
        dpTemplate.putTemplate("FORMSCRIPTEX", strFormScript);
        dpTemplate.putTemplate("FORMSCRIPTEX2", strFormScript2);
        dpTemplate.putTemplate("FORMBSSCRIPT", strFormBSScript);
        config = new Configuration();
        config.setTemplateLoader((TemplateLoader)dpTemplate);
        if (!StringHelper.IsNullOrEmpty((String)strId)) {
            if (configMap.size() > 1000) {
                configMap.clear();
            }
            configMap.put(strId, config);
        }
        return config;
    }

    protected void RenderBaseGroup(Writer writer, SRFExDPEx dpEx, DPConfig dpConfig, DPBaseGroupConfig dpGroupConfig, boolean bEnableCond) throws IOException {
        if (this.bRenderPageGroup) {
            this.bRenderPageGroup = false;
            this.RenderBaseGroup(writer, dpEx, dpConfig, dpGroupConfig, bEnableCond, true, true);
        } else {
            this.RenderBaseGroup(writer, dpEx, dpConfig, dpGroupConfig, bEnableCond, true, false);
        }
    }

    protected void RenderBaseGroup(Writer writer, SRFExDPEx dpEx, DPConfig dpConfig, DPBaseGroupConfig dpGroupConfig, boolean bEnableCond, boolean bTableBorder, boolean bOutsideBorder) throws IOException {
        String strEnableCond;
        if (dpGroupConfig.getItemsConfig().size() == 0) {
            return;
        }
        ArrayList<String> columns = new ArrayList<String>();
        String strColumns = dpGroupConfig.getColumns();
        if (StringHelper.IsNullOrEmpty((String)strColumns)) {
            columns.add("100%");
        } else {
            String[] strPart = strColumns.split("[;]");
            int i = 0;
            while (i < strPart.length) {
                columns.add(strPart[i]);
                ++i;
            }
        }
        String strGroupId = "";
        if (bEnableCond && !StringHelper.IsNullOrEmpty((String)(strEnableCond = dpGroupConfig.getEnableCond()))) {
            String strTestItemCode;
            strGroupId = dpEx.getPage().GetControlUniId();
            CallResult callResult = this.dpGroovyHelper.GetTestFormItemValueScript(strEnableCond);
            if (callResult.getRetCode() == 0 && !StringHelper.IsNullOrEmpty((String)(strTestItemCode = this.dpGroovyHelper.GetTestItemIdScript("_I")))) {
                this.form.getItemValueChangedAction().AppendAfterCode(StringHelper.Format((String)"if(%3$s){var A=Ext.get('%2$s');A.setVisibilityMode(Ext.Element.DISPLAY);if(%1$s){A.show(false);}else{A.hide(false);}}", (Object)callResult.getUserObject(), (Object)strGroupId, (Object)strTestItemCode, (Object)this.form.getFormId()));
            }
        }
        int nRowIndex = 0;
        int nColumnIndex = 0;
        String strExtStyle = dpGroupConfig.getExtStyle();
        if (!StringHelper.IsNullOrEmpty((String)strGroupId)) {
            writer.write(StringHelper.Format((String)"<table id='%1$s' width='100%%'  cellspacing='0' cellpadding='0'", (Object)strGroupId));
            if (!StringHelper.IsNullOrEmpty((String)strExtStyle)) {
                strExtStyle = String.valueOf(strExtStyle) + ";";
            }
            strExtStyle = String.valueOf(strExtStyle) + "display:none";
        } else {
            writer.write("<table width='100%'  cellspacing='0' cellpadding='0'");
        }
        if (bTableBorder) {
            writer.write(StringHelper.Format((String)" border='1' "));
        }
        if (bOutsideBorder) {
            writer.write(StringHelper.Format((String)" frame='void' "));
        }
        if (!StringHelper.IsNullOrEmpty((String)strExtStyle)) {
            writer.write(StringHelper.Format((String)" style='%1$s'  class='sx-dp-group2'", (Object)strExtStyle));
        } else {
            writer.write(StringHelper.Format((String)" class='sx-dp-group2'"));
        }
        writer.write(">");
        String strColumnWidth = "";
        writer.write("<tr >");
        int i = 0;
        while (i < dpGroupConfig.getItemsConfig().size()) {
            DPItemConfig deItemConfig = (DPItemConfig)dpGroupConfig.getItemsConfig().get(i);
            int nColSpan = deItemConfig.getColSpan();
            if (nColSpan > columns.size()) {
                log.error((Object)StringHelper.Format((String)"\u8868\u5355\u9879[%1$s]\u9700\u8981\u5217\u5bbd[%2$s]\u5927\u4e8e\u5f53\u524d\u5217\u5bbd[%3$s]\uff0c\u6309\u6700\u5927\u5217\u5bbd\u5904\u7406", (Object)deItemConfig.getID(), (Object)nColSpan, (Object)columns.size()));
                nColSpan = columns.size();
            }
            while (true) {
                if (columns.size() - nColumnIndex >= nColSpan) {
                    if (nColSpan > 1) {
                        writer.write(StringHelper.Format((String)"<td class='sx-dp-group-td' valign='top' colspan='%1$s' ", (Object)nColSpan));
                    } else {
                        strColumnWidth = (String)columns.get(nColumnIndex);
                        if (StringHelper.Compare((String)strColumnWidth, (String)"*", (boolean)true) == 0) {
                            strColumnWidth = "";
                        }
                        if (StringHelper.IsNullOrEmpty((String)strColumnWidth)) {
                            writer.write(StringHelper.Format((String)"<td class='sx-dp-group-td' valign='top' "));
                        } else {
                            writer.write(StringHelper.Format((String)"<td class='sx-dp-group-td' valign='top'  width='%1$s'", (Object)strColumnWidth));
                        }
                    }
                    String strOuterStyle = deItemConfig.getOuterStyle();
                    if (!StringHelper.IsNullOrEmpty((String)strOuterStyle)) {
                        writer.write(StringHelper.Format((String)" style='%1$s'", (Object)strOuterStyle));
                    }
                    writer.write(">");
                    writer.write(deItemConfig.getBeginHTML());
                    this.RenderItem(writer, dpEx, dpConfig, deItemConfig);
                    writer.write(deItemConfig.getEndHTML());
                    writer.write(StringHelper.Format((String)"</td>"));
                    nColumnIndex += nColSpan;
                    break;
                }
                int j = nColumnIndex;
                while (j < columns.size()) {
                    strColumnWidth = (String)columns.get(j);
                    if (StringHelper.Compare((String)strColumnWidth, (String)"*", (boolean)true) == 0) {
                        strColumnWidth = "";
                    }
                    if (StringHelper.IsNullOrEmpty((String)strColumnWidth)) {
                        writer.write(StringHelper.Format((String)"<td></td>"));
                    } else {
                        writer.write(StringHelper.Format((String)"<td width='%1$s'></td>", (Object)strColumnWidth));
                    }
                    ++j;
                }
                writer.write("</tr>");
                writer.write("<tr>");
                ++nRowIndex;
                nColumnIndex = 0;
            }
            ++i;
        }
        int j = nColumnIndex;
        while (j < columns.size()) {
            strColumnWidth = (String)columns.get(j);
            if (StringHelper.Compare((String)strColumnWidth, (String)"*", (boolean)true) == 0) {
                strColumnWidth = "";
            }
            if (StringHelper.IsNullOrEmpty((String)strColumnWidth)) {
                writer.write(StringHelper.Format((String)"<td></td>"));
            } else {
                writer.write(StringHelper.Format((String)"<td width='%1$s'></td>", (Object)strColumnWidth));
            }
            ++j;
        }
        writer.write("</tr>");
        writer.write("</table>");
    }

    protected void RenderItem(Writer writer, SRFExDPEx dpEx, DPConfig dpConfig, DPItemConfig dpItemConfig) throws IOException {
        if (dpItemConfig instanceof DPBaseFormItemConfig) {
            this.RenderBaseFormItemConfig(writer, dpEx, dpConfig, (DPBaseFormItemConfig)dpItemConfig);
            return;
        }
        if (dpItemConfig instanceof DPGroupConfig) {
            this.RenderGroup(writer, dpEx, dpConfig, (DPGroupConfig)dpItemConfig);
            return;
        }
        if (dpItemConfig instanceof DPTabGroupConfig) {
            this.RenderTabGroup(writer, dpEx, dpConfig, (DPTabGroupConfig)dpItemConfig);
            return;
        }
        if (dpItemConfig instanceof DPSpaceItemConfig) {
            writer.write("&nbsp;");
            return;
        }
        if (dpItemConfig instanceof DPDataGridItemConfig) {
            this.RenderDataGrid(writer, dpEx, dpConfig, (DPDataGridItemConfig)dpItemConfig);
            return;
        }
        if (dpItemConfig instanceof DPRawItemConfig) {
            DPRawItemConfig drRawItemConfig = (DPRawItemConfig)dpItemConfig;
            if (StringHelper.IsNullOrEmpty((String)drRawItemConfig.getCustom())) {
                String strContent = ((DPRawItemConfig)dpItemConfig).getContent();
                if (StringHelper.IsNullOrEmpty((String)strContent)) {
                    writer.write("&nbsp;");
                } else {
                    writer.write(strContent);
                }
            } else {
                SRFExControl control = dpEx.FindControl(drRawItemConfig.getID());
                if (control == null) {
                    writer.write(StringHelper.Format((String)"\u65e0\u6548\u7684\u5bf9\u8c61[%1$s]", (Object)drRawItemConfig.getID()));
                    return;
                }
                control.Render(writer);
            }
            return;
        }
    }

    protected void RenderTabGroup(Writer writer, SRFExDPEx dpEx, DPConfig dpConfig, DPTabGroupConfig dpTabGroupConfig) throws IOException {
        String strEnableCond;
        DPPageGroupConfig dpPageGroupConfig;
        SRFExWebContext iSRFExWebContext = dpEx.getWebContext();
        writer.write("<table width='100%' border='0' cellspacing='3' cellpadding='0'>");
        writer.write("<tr><td style='padding-top:2px;padding-left:2px'>");
        String strGroupId = dpEx.getPage().GetControlUniId();
        StyleBuilder styleBuilder = new StyleBuilder();
        String strClass = "sx-panel";
        if (StringHelper.Length((String)dpTabGroupConfig.getCssClass()) > 0) {
            strClass = dpTabGroupConfig.getCssClass();
        }
        writer.write("<DIV");
        DPExBuilder4.OutputAttribute((Writer)writer, (String)"id", (String)strGroupId);
        DPExBuilder4.OutputAttribute((Writer)writer, (String)"class", (String)strClass);
        writer.write(">");
        int nPageIndex = 0;
        String strDefaultPageGroupId = "";
        int nPageCount = dpTabGroupConfig.getPageGroupsConfig().size();
        int i = 0;
        while (i < nPageCount) {
            dpPageGroupConfig = (DPPageGroupConfig)dpTabGroupConfig.getPageGroupsConfig().get(i);
            if (StringHelper.IsNullOrEmpty((String)dpPageGroupConfig.getResourceId()) || iSRFExWebContext.GetUserPrivilegeMgr().Test(iSRFExWebContext, dpPageGroupConfig.getResourceId())) {
                strEnableCond = dpPageGroupConfig.getEnableCond();
                if (StringHelper.IsNullOrEmpty((String)strEnableCond)) {
                    strDefaultPageGroupId = StringHelper.Format((String)"%1$s_%2$s", (Object)strGroupId, (Object)nPageIndex);
                    break;
                }
                ++nPageIndex;
            }
            ++i;
        }
        nPageIndex = 0;
        nPageCount = dpTabGroupConfig.getPageGroupsConfig().size();
        i = 0;
        while (i < nPageCount) {
            dpPageGroupConfig = (DPPageGroupConfig)dpTabGroupConfig.getPageGroupsConfig().get(i);
            if (StringHelper.IsNullOrEmpty((String)dpPageGroupConfig.getResourceId()) || iSRFExWebContext.GetUserPrivilegeMgr().Test(iSRFExWebContext, dpPageGroupConfig.getResourceId())) {
                String strTestItemCode;
                CallResult callResult;
                styleBuilder.RemoveAllStyle();
                styleBuilder.AddStyle("padding", "0px");
                styleBuilder.AddStyle("background-color", "#ffffff");
                writer.write("<DIV");
                DPExBuilder4.OutputAttribute((Writer)writer, (String)"id", (String)StringHelper.Format((String)"C_%1$s_%2$s", (Object)strGroupId, (Object)nPageIndex));
                DPExBuilder4.OutputAttribute((Writer)writer, (String)"class", (String)"x-hide-display");
                writer.write(">");
                this.strActivePage = StringHelper.Format((String)"%1$s_%2$s", (Object)strGroupId, (Object)nPageIndex);
                this.nActivePageNo = nPageIndex;
                this.RenderPageGroup(writer, dpEx, dpConfig, dpPageGroupConfig);
                writer.write("</DIV>");
                strEnableCond = dpPageGroupConfig.getEnableCond();
                if (!StringHelper.IsNullOrEmpty((String)strEnableCond) && (callResult = this.dpGroovyHelper.GetTestFormItemValueScript(strEnableCond)).getRetCode() == 0 && !StringHelper.IsNullOrEmpty((String)(strTestItemCode = this.dpGroovyHelper.GetTestItemIdScript("_I")))) {
                    this.form.getItemValueChangedAction().AppendAfterCode(StringHelper.Format((String)"if(%3$s){var A=$P.tabpanel['%5$s'];if(%1$s){A.unhideTabStripItem('%2$s');}else{A.hideTabStripItem('%2$s');if(A.getActiveTab().id=='%2$s'){A.setActiveTab('%6$s');}}}", (Object)callResult.getUserObject(), (Object)this.strActivePage, (Object)strTestItemCode, (Object)this.form.getFormId(), (Object)strGroupId, (Object)strDefaultPageGroupId));
                }
                ++nPageIndex;
            }
            ++i;
        }
        writer.write("</DIV>");
        String strFirstPageId = "";
        String strActivePageId = "";
        String strItems = "";
        nPageIndex = 0;
        int i2 = 0;
        while (i2 < nPageCount) {
            DPPageGroupConfig dpPageGroupConfig2 = (DPPageGroupConfig)dpTabGroupConfig.getPageGroupsConfig().get(i2);
            if (StringHelper.IsNullOrEmpty((String)dpPageGroupConfig2.getResourceId()) || iSRFExWebContext.GetUserPrivilegeMgr().Test(iSRFExWebContext, dpPageGroupConfig2.getResourceId())) {
                if (StringHelper.Length((String)strItems) != 0) {
                    strItems = String.valueOf(strItems) + "\r\n,";
                }
                String strTabPageUniqueId = StringHelper.Format((String)"%1$s_%2$s", (Object)strGroupId, (Object)nPageIndex);
                strItems = String.valueOf(strItems) + StringHelper.Format((String)"{id:\"%1$s\",contentEl:\"C_%1$s\",title:\"%2$s\"}", (Object)strTabPageUniqueId, (Object)dpPageGroupConfig2.getCaption());
                if (StringHelper.Length((String)strFirstPageId) == 0) {
                    strFirstPageId = strTabPageUniqueId;
                }
                ++nPageIndex;
            }
            ++i2;
        }
        if (StringHelper.Length((String)strActivePageId) == 0) {
            strActivePageId = strFirstPageId;
        }
        String strDefaults = "";
        String strSize = "";
        String strCurResizeCode = "";
        if (dpTabGroupConfig.getWidth() == 0.0) {
            strDefaults = "autoWidth:true";
        } else {
            strDefaults = "autoWidth:true";
            if (dpTabGroupConfig.getWidth() > 1.0) {
                strSize = String.valueOf(strSize) + StringHelper.Format((String)",width:%1$s", (Object)dpTabGroupConfig.getWidth());
            } else {
                strSize = String.valueOf(strSize) + ",width:300";
                strCurResizeCode = dpTabGroupConfig.getWidth() < 0.0 ? String.valueOf(strCurResizeCode) + StringHelper.Format((String)"var B=Math.floor(W%2$s-8);$P.tabpanel['%1$s'].setWidth((B>=0)?B:0);", (Object)strGroupId, (Object)dpTabGroupConfig.getWidth()) : String.valueOf(strCurResizeCode) + StringHelper.Format((String)"$P.tabpanel['%1$s'].setWidth(Math.floor(W*%2$s-8));", (Object)strGroupId, (Object)dpTabGroupConfig.getWidth());
            }
        }
        if (dpTabGroupConfig.getHeight() == 0.0) {
            if (!StringHelper.IsNullOrEmpty((String)strDefaults)) {
                strDefaults = String.valueOf(strDefaults) + ",";
            }
            strDefaults = "autoHeight:true";
        } else if (dpTabGroupConfig.getHeight() > 1.0) {
            strSize = String.valueOf(strSize) + StringHelper.Format((String)",height:%1$s", (Object)dpTabGroupConfig.getHeight());
        } else {
            strSize = String.valueOf(strSize) + ",height:300";
            strCurResizeCode = String.valueOf(strCurResizeCode) + StringHelper.Format((String)"$P.tabpanel['%1$s'].setHeight(Math.floor(H*%2$s-4));", (Object)strGroupId, (Object)dpTabGroupConfig.getHeight());
        }
        String strScript = "";
        strScript = String.valueOf(strScript) + StringHelper.Format((String)"var varTabs=new Ext.TabPanel({renderTo:\"%1$s\" %3$s,items:[%2$s],frame:true,plain:true,defaults:{%4$s}});\r\n", (Object)strGroupId, (Object)strItems, (Object)strSize, (Object)strDefaults);
        if (StringHelper.Length((String)strActivePageId) != 0) {
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"varTabs.activate(\"%1$s\");\r\n", (Object)strActivePageId);
        }
        strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.tabpanel['%1$s']=varTabs;\r\n", (Object)strGroupId);
        if (!StringHelper.IsNullOrEmpty((String)dpTabGroupConfig.getTabGroupId())) {
            this.tabGroupMap.put(dpTabGroupConfig.getTabGroupId().toLowerCase(), (Object)strGroupId);
        }
        this.strDPResizeCode = String.valueOf(this.strDPResizeCode) + "if(true){";
        this.strDPResizeCode = String.valueOf(this.strDPResizeCode) + strCurResizeCode;
        this.strDPResizeCode = String.valueOf(this.strDPResizeCode) + "}\r\n";
        dpEx.getPage().RegisterOnReadyScript(2, strScript);
        writer.write("</td></tr>");
        writer.write("</table>");
    }

    protected void RenderGroup(Writer writer, SRFExDPEx dpEx, DPConfig dpConfig, DPGroupConfig dpGroupConfig) throws IOException {
        String strGroupContentId = "";
        boolean bGroupContentVisible = true;
        if (dpGroupConfig.isShowCaption()) {
            String strGroupUniId = "";
            String strExpander = dpGroupConfig.getExpander();
            String strEnableCond = dpGroupConfig.getEnableCond();
            if (!StringHelper.IsNullOrEmpty((String)strEnableCond)) {
                String strTestItemCode;
                strGroupUniId = dpEx.getPage().GetControlUniId();
                CallResult callResult = this.dpGroovyHelper.GetTestFormItemValueScript(strEnableCond);
                if (callResult.getRetCode() == 0 && !StringHelper.IsNullOrEmpty((String)(strTestItemCode = this.dpGroovyHelper.GetTestItemIdScript("_I")))) {
                    this.form.getItemValueChangedAction().AppendAfterCode(StringHelper.Format((String)"if(%3$s){var A=Ext.get('%2$s');A.setVisibilityMode(Ext.Element.DISPLAY);if(%1$s){A.show(false);}else{A.hide(false);}}", (Object)callResult.getUserObject(), (Object)strGroupUniId, (Object)strTestItemCode, (Object)this.form.getFormId()));
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)strGroupUniId)) {
                writer.write(StringHelper.Format((String)"<table id='%1$s' width='100%%' border='0'  cellpadding='3' border='1'  class='sx-dp-group'>", (Object)strGroupUniId));
            } else {
                writer.write("<table width='100%' border='0' cellpadding='3' border='1'  class='sx-dp-group'>");
            }
            writer.write("<tr><td style='padding-top:5px;padding-left:10px;padding-bottom:2px;'>");
            String strGroupCssClass = dpGroupConfig.getCaptionCssClass();
            if (StringHelper.IsNullOrEmpty((String)strGroupCssClass)) {
                strGroupCssClass = "sx-dp-groupcaption";
            }
            if (!StringHelper.IsNullOrEmpty((String)strExpander)) {
                strGroupContentId = dpEx.getPage().GetControlUniId();
                writer.write("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
                writer.write("<tr><td>");
                writer.write(StringHelper.Format((String)"<SPAN class=\"%1$s\">%2$s</SPAN>", (Object)strGroupCssClass, (Object)dpGroupConfig.getCaption()));
                writer.write("</td><td style='width:30px'>");
                String strImg = "";
                if (StringHelper.Compare((String)strExpander, (String)"EXPAND", (boolean)true) == 0) {
                    bGroupContentVisible = true;
                    strImg = "../sasrfex/images/default/icon_ns-collapse.gif";
                } else {
                    bGroupContentVisible = false;
                    strImg = "../sasrfex/images/default/icon_ns-expand.gif";
                }
                writer.write(StringHelper.Format((String)"&nbsp;&nbsp;<A href='#' title='\u663e\u793a\u6216\u9690\u85cf\u5206\u7ec4' onclick=\"$P.object['%3$s'].showhidegroup('%1$s')\"><IMG ID='I_%1$s' border='0' src='%2$s'></A>", (Object)strGroupContentId, (Object)strImg, (Object)dpEx.getUniqueID()));
                writer.write("</td></tr></table>");
            } else {
                writer.write(StringHelper.Format((String)"<SPAN class=\"%1$s\">%2$s</SPAN>", (Object)strGroupCssClass, (Object)dpGroupConfig.getCaption()));
            }
            writer.write("</td></tr>");
            if (!StringHelper.IsNullOrEmpty((String)strGroupContentId)) {
                if (bGroupContentVisible) {
                    writer.write(StringHelper.Format((String)"<tr><td id='C_%1$s' style='padding:3px;'>", (Object)strGroupContentId));
                } else {
                    writer.write(StringHelper.Format((String)"<tr><td id='C_%1$s' style='display:none;padding:3px;'>", (Object)strGroupContentId));
                }
            } else {
                writer.write("<tr><td style='padding:3px;'>");
            }
        }
        if (this.bRenderPageGroup) {
            this.bRenderPageGroup = false;
            if (dpGroupConfig.isShowCaption()) {
                this.RenderBaseGroup(writer, dpEx, dpConfig, (DPBaseGroupConfig)dpGroupConfig, !dpGroupConfig.isShowCaption(), true, !dpGroupConfig.isShowCaption());
            } else {
                this.RenderBaseGroup(writer, dpEx, dpConfig, (DPBaseGroupConfig)dpGroupConfig, !dpGroupConfig.isShowCaption(), true, true);
            }
        } else {
            this.RenderBaseGroup(writer, dpEx, dpConfig, (DPBaseGroupConfig)dpGroupConfig, !dpGroupConfig.isShowCaption(), true, !dpGroupConfig.isShowCaption());
        }
        if (dpGroupConfig.isShowCaption()) {
            if (!StringHelper.IsNullOrEmpty((String)strGroupContentId)) {
                writer.write("</td></tr>");
                if (bGroupContentVisible) {
                    writer.write(StringHelper.Format((String)"<tr><td id='D_%1$s' style='display:none;' align='center'>", (Object)strGroupContentId));
                } else {
                    writer.write(StringHelper.Format((String)"<tr><td id='D_%1$s' align='center'>", (Object)strGroupContentId));
                }
                writer.write(StringHelper.Format((String)"<A href='#' class='sx-normallink' onclick=\"$P.object['%2$s'].showhidegroup('%1$s')\"><SPAN title='\u5206\u7ec4\u5185\u5bb9\u88ab\u9690\u85cf\uff0c\u70b9\u51fb\u663e\u793a' class=\"sx-normaltext-b\">.............</SPAN></A>", (Object)strGroupContentId, (Object)dpEx.getUniqueID()));
            }
            writer.write("</td></tr>");
            writer.write("</table>");
        }
    }

    protected void RenderDataGrid(Writer writer, SRFExDPEx dpEx, DPConfig dpConfig, DPDataGridItemConfig dpDataGridItemConfig) throws IOException {
        dpEx.RenderChild(writer, dpDataGridItemConfig.getDataGridId());
    }

    protected void RenderBaseFormItemConfig(Writer writer, SRFExDPEx dpEx, DPConfig dpConfig, DPBaseFormItemConfig dpBaseFormItemConfig) throws IOException {
        String strResetCond;
        DPFormItemEnableRuleHelper dpFormItemEnableRuleHelper;
        String strJSCode;
        String strProcessCond;
        CallResult callResult;
        String strEmptyCond;
        String strCaptionCssClass;
        String strTestItemCode;
        CallResult callResult2;
        String strEnableCond;
        if (dpBaseFormItemConfig.getCtrlConfig() == null) {
            writer.write(StringHelper.Format((String)"\u65e0\u6548\u7684FORMITEM[%1$s]", (Object)dpBaseFormItemConfig.getID()));
            return;
        }
        SRFExControl control = dpEx.FindControl(dpBaseFormItemConfig.getCtrlConfig().getID());
        if (control == null) {
            writer.write(StringHelper.Format((String)"\u65e0\u6548\u7684\u5bf9\u8c61[%1$s]", (Object)dpBaseFormItemConfig.getCtrlConfig().getID()));
            return;
        }
        ISRFExFormItem iFormItem = null;
        if (control instanceof ISRFExFormItem) {
            iFormItem = (ISRFExFormItem)control;
        }
        if (iFormItem != null) {
            Vector focusItems = new Vector();
            iFormItem.GetFocusItemIds(focusItems);
            for (String strFocusItem : focusItems) {
                JSONObject obj = new JSONObject();
                String[] parts = strFocusItem.split("[:]");
                if (parts.length == 1) {
                    obj.put("id", (Object)strFocusItem);
                } else {
                    obj.put("id", (Object)parts[0]);
                    if (StringHelper.Compare((String)parts[1], (String)"stop", (boolean)true) == 0) {
                        obj.put("s", 1);
                    }
                }
                if (StringHelper.Compare((String)control.getUniqueID(), (String)strFocusItem, (boolean)true) != 0) {
                    obj.put("p", (Object)control.getUniqueID());
                }
                if (this.nActivePageNo != 0) {
                    obj.put("g", this.nActivePageNo);
                }
                this.focusJsonItems.add(obj);
            }
        }
        boolean bDivId = false;
        boolean bItemPrivilege = false;
        if (this.form.isEnableItemPrivilege() && iFormItem != null && !StringHelper.IsNullOrEmpty((String)iFormItem.getFormItemConfig().getPrivilegeId())) {
            bItemPrivilege = true;
            bDivId = true;
        }
        if (iFormItem != null && this.form.getItemUpdateAction().getEnabled() && !StringHelper.IsNullOrEmpty((String)dpBaseFormItemConfig.getFIUpdateMode())) {
            String strCode = "";
            if (this.form.getEnableAction().getEnabled()) {
                strCode = String.valueOf(strCode) + StringHelper.Format((String)"if(!%1$s.isenable('%2$s'))return;", (Object)this.form.getFormId(), (Object)control.getUniqueID());
            }
            strCode = String.valueOf(strCode) + StringHelper.Format((String)"%1$s.itemupdate({srfum:'%2$s'});", (Object)this.form.getFormId(), (Object)dpBaseFormItemConfig.getFIUpdateMode());
            if (!StringHelper.IsNullOrEmpty((String)(strCode = iFormItem.getFireFIUpdateCode(strCode)))) {
                dpEx.getPage().RegisterOnReadyScript(3, strCode);
            }
        }
        if (this.form.getEnableAction().getEnabled() && !StringHelper.IsNullOrEmpty((String)(strEnableCond = dpBaseFormItemConfig.getEnableCond())) && (callResult2 = this.dpGroovyHelper.GetTestFormItemValueScript(strEnableCond)).getRetCode() == 0 && !StringHelper.IsNullOrEmpty((String)(strTestItemCode = this.dpGroovyHelper.GetTestItemIdScript("_I")))) {
            String strFormCode = "";
            if (iFormItem != null) {
                String strStaticCode = iFormItem.getFormItemConfig().getEnableCond();
                if (StringHelper.Compare((String)strStaticCode, (String)"NONE", (boolean)true) == 0) {
                    strFormCode = "false";
                } else if (StringHelper.Compare((String)strStaticCode, (String)"CREATE", (boolean)true) == 0) {
                    strFormCode = StringHelper.Format((String)"(%1$s._UF==false)", (Object)this.form.getFormId());
                } else if (StringHelper.Compare((String)strStaticCode, (String)"UPDATE", (boolean)true) == 0) {
                    strFormCode = StringHelper.Format((String)"(%1$s._UF==true)", (Object)this.form.getFormId());
                }
            }
            if (StringHelper.IsNullOrEmpty((String)strFormCode)) {
                this.form.getItemValueChangedAction().AppendAfterCode(StringHelper.Format((String)"if(%3$s){%4$s.enable('%2$s',(%1$s));}", (Object)callResult2.getUserObject(), (Object)control.getUniqueID(), (Object)strTestItemCode, (Object)this.form.getFormId()));
            } else {
                this.form.getItemValueChangedAction().AppendAfterCode(StringHelper.Format((String)"if(%5$s&&(%3$s)){%4$s.enable('%2$s',(%1$s));}", (Object)callResult2.getUserObject(), (Object)control.getUniqueID(), (Object)strTestItemCode, (Object)this.form.getFormId(), (Object)strFormCode));
            }
        }
        String strDynaCaptionCssClass = strCaptionCssClass = "sx-cp-lb";
        if (!dpBaseFormItemConfig.getAllowEmpty()) {
            strCaptionCssClass = "sx-cp-lb2";
        }
        if (StringHelper.Length((String)dpBaseFormItemConfig.getCaptionCssClass()) > 0) {
            strDynaCaptionCssClass = strCaptionCssClass = dpBaseFormItemConfig.getCaptionCssClass();
        }
        boolean bDynamicEmptyCond = false;
        String strCaption = dpBaseFormItemConfig.getCaption();
        if (!StringHelper.IsNullOrEmpty((String)strCaption) && dpBaseFormItemConfig.isShowCaption() && !StringHelper.IsNullOrEmpty((String)(strEmptyCond = dpBaseFormItemConfig.getAllowEmptyCond())) && (callResult = this.dpGroovyHelper.GetTestFormItemValueScript(strEmptyCond)).getRetCode() == 0) {
            String strTestItemCode2 = this.dpGroovyHelper.GetTestItemIdScript("_I");
            bDynamicEmptyCond = true;
            if (!StringHelper.IsNullOrEmpty((String)strTestItemCode2)) {
                String strFormCode = "";
                if (iFormItem != null) {
                    String strStaticCode = iFormItem.getFormItemConfig().getEnableCond();
                    if (StringHelper.Compare((String)strStaticCode, (String)"NONE", (boolean)true) == 0) {
                        strFormCode = "true";
                    } else if (StringHelper.Compare((String)strStaticCode, (String)"CREATE", (boolean)true) == 0) {
                        strFormCode = StringHelper.Format((String)"(%1$s._UF==true)", (Object)this.form.getFormId());
                    } else if (StringHelper.Compare((String)strStaticCode, (String)"UPDATE", (boolean)true) == 0) {
                        strFormCode = StringHelper.Format((String)"(%1$s._UF==false)", (Object)this.form.getFormId());
                    }
                }
                if (StringHelper.IsNullOrEmpty((String)strFormCode)) {
                    this.form.getItemValueChangedAction().AppendAfterCode(StringHelper.Format((String)"if(%3$s){Ext.getDom('cap_%2$s').className=(%1$s)?'%4$s':'%4$s2';}", (Object)callResult.getUserObject(), (Object)control.getUniqueID(), (Object)strTestItemCode2, (Object)strDynaCaptionCssClass));
                } else {
                    this.form.getItemValueChangedAction().AppendAfterCode(StringHelper.Format((String)"if(%3$s){Ext.getDom('cap_%2$s').className=(%5$s||(%1$s))?'%4$s':'%4$s2';}", (Object)callResult.getUserObject(), (Object)control.getUniqueID(), (Object)strTestItemCode2, (Object)strDynaCaptionCssClass, (Object)strFormCode));
                }
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)(strProcessCond = dpBaseFormItemConfig.getProcessCond())) && !StringHelper.IsNullOrEmpty((String)(strJSCode = (dpFormItemEnableRuleHelper = new DPFormItemEnableRuleHelper()).GetEnableCondCode(this.form, strProcessCond)))) {
            if (bItemPrivilege) {
                this.form.getItemValueChangedAction().AppendAfterCode(StringHelper.Format((String)"Ext.getDom('C_%2$s').style.display=(_F._IP['%2$s']!=0 && (%1$s))?'':'none';", (Object)strJSCode, (Object)control.getUniqueID()));
            } else {
                this.form.getItemValueChangedAction().AppendAfterCode(StringHelper.Format((String)"Ext.getDom('C_%2$s').style.display=(%1$s)?'':'none';", (Object)strJSCode, (Object)control.getUniqueID()));
            }
            bDivId = true;
        }
        if (!StringHelper.IsNullOrEmpty((String)(strResetCond = dpBaseFormItemConfig.getResetCond()))) {
            String[] resetItems = strResetCond.split("[;]");
            int k = 0;
            while (k < resetItems.length) {
                SRFExControl hookControl = dpEx.FindControl(resetItems[k]);
                if (hookControl != null) {
                    String strJSCode2 = StringHelper.Format((String)"if(_I=='%1$s'){%2$s.S('%3$s','');}", (Object)hookControl.getUniqueID(), (Object)this.form.getFormId(), (Object)control.getUniqueID());
                    this.form.getItemValueChangedAction().AppendAfterCode(strJSCode2);
                }
                ++k;
            }
        }
        String strUnit = dpBaseFormItemConfig.getUnit().trim();
        if (bDivId) {
            writer.write(StringHelper.Format((String)"<table class='sx-dp-cp-tb' ID='C_%1$s'", (Object)control.getUniqueID()));
        } else {
            writer.write("<table class='sx-dp-cp-tb'");
        }
        String strExtStyle = dpBaseFormItemConfig.getExtStyle();
        if (!StringHelper.IsNullOrEmpty((String)strExtStyle)) {
            writer.write(StringHelper.Format((String)" style='%1$s'", (Object)strExtStyle));
        }
        writer.write(">");
        writer.write("<tr>");
        double nCtrlWidth = control.getBaseControlConfig().getWidthEx();
        if (!StringHelper.IsNullOrEmpty((String)strCaption) && dpBaseFormItemConfig.isShowCaption()) {
            String strCapContainerStyle = dpBaseFormItemConfig.getCaptionContainerStyle();
            if (dpBaseFormItemConfig.getCaptionOnTop()) {
                if (!StringHelper.IsNullOrEmpty((String)strUnit)) {
                    writer.write(StringHelper.Format((String)"<td colspan='%1$s' class='sx-dp-lb-td2'", (Object)(nCtrlWidth > 1.0 ? 3 : 2)));
                } else {
                    writer.write(StringHelper.Format((String)"<td class='sx-dp-lb-td2'"));
                }
                if (!StringHelper.IsNullOrEmpty((String)strCapContainerStyle)) {
                    writer.write(StringHelper.Format((String)" style='%1$s'", (Object)strCapContainerStyle));
                }
                writer.write(">");
                if (StringHelper.Length((String)dpBaseFormItemConfig.getTips()) > 0) {
                    writer.write(StringHelper.Format((String)"<IMG src='../sasrfex/images/default/icon_t.gif' alt='%1$s' title='%1$s' align='absmiddle'>", (Object)dpBaseFormItemConfig.getTips()));
                }
                writer.write("<SPAN");
                if (bDynamicEmptyCond) {
                    DPExBuilder4.OutputAttribute((Writer)writer, (String)"id", (String)StringHelper.Format((String)"cap_%1$s", (Object)control.getUniqueID()));
                }
                DPExBuilder4.OutputAttribute((Writer)writer, (String)"class", (String)strCaptionCssClass);
                DPExBuilder4.OutputAttribute((Writer)writer, (String)"style", (String)("float:left;" + dpBaseFormItemConfig.getCaptionExtStyle()));
                writer.write(">");
                writer.write(dpBaseFormItemConfig.getCaption());
                writer.write("</SPAN>");
                writer.write("</td></tr><tr>");
            } else {
                int nCaptionWidth = 112;
                if (dpBaseFormItemConfig.getCaptionWidth() != 0) {
                    nCaptionWidth = dpBaseFormItemConfig.getCaptionWidth();
                }
                if (nCaptionWidth == 112) {
                    writer.write(StringHelper.Format((String)"<td class='sx-dp-lb-td'"));
                    if (!StringHelper.IsNullOrEmpty((String)strCapContainerStyle)) {
                        writer.write(StringHelper.Format((String)" style='%1$s'", (Object)strCapContainerStyle));
                    }
                } else {
                    writer.write(StringHelper.Format((String)"<td class='sx-dp-lb-td' style='width:%1$spx;%2$s'", (Object)nCaptionWidth, (Object)strCapContainerStyle));
                }
                writer.write(">");
                if (StringHelper.Length((String)dpBaseFormItemConfig.getTips()) > 0) {
                    writer.write(StringHelper.Format((String)"<IMG src='../sasrfex/images/default/icon_t.gif' alt='%1$s' title='%1$s' align='absmiddle' style=\"float:right\">", (Object)dpBaseFormItemConfig.getTips()));
                }
                writer.write("<SPAN");
                if (bDynamicEmptyCond) {
                    DPExBuilder4.OutputAttribute((Writer)writer, (String)"id", (String)StringHelper.Format((String)"cap_%1$s", (Object)control.getUniqueID()));
                }
                DPExBuilder4.OutputAttribute((Writer)writer, (String)"class", (String)strCaptionCssClass);
                DPExBuilder4.OutputAttribute((Writer)writer, (String)"style", (String)dpBaseFormItemConfig.getCaptionExtStyle());
                writer.write(">");
                writer.write(dpBaseFormItemConfig.getCaption());
                writer.write("</SPAN>");
                writer.write("</td>");
            }
        }
        if (dpBaseFormItemConfig.getAutoErrorRegion()) {
            writer.write(StringHelper.Format((String)"<td id='E%1$s' class=\"sx-dp-ct-td\" valign='top'", (Object)control.getUniqueID()));
        } else {
            writer.write("<td class=\"sx-dp-ct-td\" valign='top'");
        }
        String strCtrlContainerStyle = dpBaseFormItemConfig.getCtrlContainerStyle();
        if (nCtrlWidth > 1.0) {
            strCtrlContainerStyle = String.valueOf(strCtrlContainerStyle) + StringHelper.Format((String)"width:%1$spx;", (Object)(nCtrlWidth + 4.0));
        }
        if (!StringHelper.IsNullOrEmpty((String)strCtrlContainerStyle)) {
            writer.write(StringHelper.Format((String)" style='%1$s'", (Object)strCtrlContainerStyle));
        }
        writer.write(">");
        if (control.getBaseControlConfig().getWidthEx() == 0.0) {
            control.getBaseControlConfig().setWidthEx(1.0);
        }
        control.Render(writer);
        writer.write("</td>");
        if (!StringHelper.IsNullOrEmpty((String)strUnit)) {
            int nUnitLength = dpBaseFormItemConfig.getUnitWidth();
            if (nUnitLength == 0) {
                nUnitLength = strUnit.length() * 20;
            }
            writer.write(StringHelper.Format((String)"<td class='sx-dp-un-td' width='%1$s'><span class='sx-normaltext'>&nbsp;", (Object)nUnitLength));
            writer.write(strUnit);
            writer.write("</span></td>");
        }
        if (nCtrlWidth > 1.0) {
            writer.write(StringHelper.Format((String)"<td>&nbsp;</td>"));
        }
        writer.write("</tr></table>");
    }

    protected void RenderPageGroup(Writer writer, SRFExDPEx dpEx, DPConfig dpConfig, DPPageGroupConfig dpPageGroupConfig) throws IOException {
        this.bRenderPageGroup = true;
        this.RenderBaseGroup(writer, dpEx, dpConfig, (DPBaseGroupConfig)dpPageGroupConfig, false, false, false);
    }
}

