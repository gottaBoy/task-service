/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.Web.ListItem
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDatePickerEx
 *  SA.SRFramework.WebEx.SRFExDropDownList
 *  SA.SRFramework.WebEx.SRFExHidden
 *  SA.SRFramework.WebEx.SRFExPickerEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.BI.Web;

import SA.SRFDA.BI.Web.UI.BITDSelectorConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDatePickerEx;
import SA.SRFramework.WebEx.SRFExDropDownList;
import SA.SRFramework.WebEx.SRFExHidden;
import SA.SRFramework.WebEx.SRFExPickerEx;
import java.io.Writer;
import java.util.Calendar;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFDABITDSelector
extends SRFExHidden {
    private static final Log log = LogFactory.getLog(SRFDABITDSelector.class);
    protected BITDSelectorConfig biTDSelectorConfig = null;
    protected SRFExDropDownList dropDownList = null;
    protected SRFExPickerEx pkTimeDimension = null;
    protected SRFExDatePickerEx dtFromDate = null;
    protected SRFExDatePickerEx dtToDate = null;
    protected SRFExDropDownList ddlTimeType = null;
    protected SRFExDropDownList ddlFromYear = null;
    protected SRFExDropDownList ddlFromSeason = null;
    protected SRFExDropDownList ddlFromYear2 = null;
    protected SRFExDropDownList ddlFromMonth = null;
    protected SRFExDropDownList ddlToYear = null;
    protected SRFExDropDownList ddlToSeason = null;
    protected SRFExDropDownList ddlToYear2 = null;
    protected SRFExDropDownList ddlToMonth = null;

    protected void OnInit() {
        super.OnInit();
    }

    protected XMLConfig CreateConfig() {
        return new BITDSelectorConfig();
    }

    public BITDSelectorConfig getBITDSelectorConfig() {
        return this.biTDSelectorConfig;
    }

    protected void OnSetConfig() {
        super.OnSetConfig();
        this.biTDSelectorConfig = null;
        if (this.config != null && this.config instanceof BITDSelectorConfig) {
            this.biTDSelectorConfig = (BITDSelectorConfig)this.config;
        }
    }

    protected void OnReloadConfig() {
        super.OnReloadConfig();
        this.RemoveControls();
        if (this.biTDSelectorConfig != null) {
            this.dropDownList = new SRFExDropDownList();
            this.dropDownList.InitConfig();
            this.dropDownList.getDropDownListConfig().setID("dropDownList");
            this.AddControl((SRFExControl)this.dropDownList);
            this.pkTimeDimension = new SRFExPickerEx();
            this.pkTimeDimension.InitConfig();
            this.pkTimeDimension.getPickerExConfig().setID("pkTimeDimension");
            this.pkTimeDimension.getPickerExConfig().setPickOnly(true);
            this.pkTimeDimension.getPickerExConfig().setShowButton(false);
            this.pkTimeDimension.getPickerExConfig().getTextBoxConfig().setACTriggerAsAll(true);
            this.pkTimeDimension.getPickerExConfig().getTextBoxConfig().setACHideTrigger(false);
            this.pkTimeDimension.getPickerExConfig().getTextBoxConfig().setACForceSelection(true);
            this.pkTimeDimension.getPickerExConfig().getTextBoxConfig().setACMode("BILEVEL");
            this.pkTimeDimension.getPickerExConfig().getTextBoxConfig().setACDataURL("../srfbi/biacbackend.jsp?");
            this.pkTimeDimension.getPickerExConfig().setWidth(110);
            this.AddControl((SRFExControl)this.pkTimeDimension);
            this.ddlTimeType = new SRFExDropDownList();
            this.ddlTimeType.InitConfig();
            this.ddlTimeType.getDropDownListConfig().setWidth(75);
            this.ddlTimeType.getDropDownListConfig().setID("ddlTimeType");
            this.ddlTimeType.getDropDownListConfig().getListItems().Add(new ListItem("\u65e0\u5b9a\u4e49", "0"));
            this.ddlTimeType.getDropDownListConfig().getListItems().Add(new ListItem("\u5b63\u5ea6", "1"));
            this.ddlTimeType.getDropDownListConfig().getListItems().Add(new ListItem("\u6708\u4efd", "2"));
            this.ddlTimeType.getDropDownListConfig().getListItems().Add(new ListItem("\u5929", "3"));
            this.AddControl((SRFExControl)this.ddlTimeType);
            if (!this.getPage().IsBackEndMode()) {
                this.getPage().RegisterOnReadyScript(3, this.pkTimeDimension.getHookValueChangedCode(StringHelper.Format((String)"var _V=Ext.getDom('%1$s').value;Ext.getDom('%2$s').selectedIndex=(_V.charAt(0)=='H')?0:1;Ext.getDom('%3$s_TIME').style.display=(_V.charAt(0)=='L')?'':'none';_%2$s();", (Object)this.pkTimeDimension.getUniqueID(), (Object)this.ddlTimeType.getUniqueID(), (Object)this.getUniqueID())));
            }
            StringBuilderEx script = new StringBuilderEx();
            script.Append("function _%1$s(){", (Object)this.ddlTimeType.getUniqueID());
            script.Append("var _V=Ext.getDom('%1$s').value;", (Object)this.ddlTimeType.getUniqueID());
            script.Append("Ext.getDom('%1$s_SEASON').style.display=(_V=='1')?'':'none';", (Object)this.getUniqueID());
            script.Append("Ext.getDom('%1$s_MONTH').style.display=(_V=='2')?'':'none';", (Object)this.getUniqueID());
            script.Append("Ext.getDom('%1$s_DAY').style.display=(_V=='3')?'':'none';", (Object)this.getUniqueID());
            script.Append("}");
            this.getPage().RegisterScript(3, script.toString());
            script.Reset();
            this.ddlTimeType.getDropDownListConfig().setSelectChangedJSCode(StringHelper.Format((String)"_%1$s();", (Object)this.ddlTimeType.getUniqueID()));
            this.ddlFromYear = new SRFExDropDownList();
            this.ddlFromYear.InitConfig();
            this.ddlFromYear.getDropDownListConfig().setWidth(60);
            this.ddlFromYear.getDropDownListConfig().setID("ddlFromYear");
            this.ddlFromYear2 = new SRFExDropDownList();
            this.ddlFromYear2.InitConfig();
            this.ddlFromYear2.getDropDownListConfig().setWidth(60);
            this.ddlFromYear2.getDropDownListConfig().setID("ddlFromYear2");
            this.ddlToYear = new SRFExDropDownList();
            this.ddlToYear.InitConfig();
            this.ddlToYear.getDropDownListConfig().setWidth(60);
            this.ddlToYear.getDropDownListConfig().setID("ddlToYear");
            this.ddlToYear2 = new SRFExDropDownList();
            this.ddlToYear2.InitConfig();
            this.ddlToYear2.getDropDownListConfig().setWidth(60);
            this.ddlToYear2.getDropDownListConfig().setID("ddlToYear2");
            Calendar calendar = Calendar.getInstance();
            int nYear = calendar.get(1);
            int i = -10;
            while (i < 10) {
                this.ddlFromYear.getDropDownListConfig().getListItems().Add(new ListItem(Integer.toString(nYear + i), Integer.toString(nYear + i)));
                this.ddlFromYear2.getDropDownListConfig().getListItems().Add(new ListItem(Integer.toString(nYear + i), Integer.toString(nYear + i)));
                this.ddlToYear.getDropDownListConfig().getListItems().Add(new ListItem(Integer.toString(nYear + i), Integer.toString(nYear + i)));
                this.ddlToYear2.getDropDownListConfig().getListItems().Add(new ListItem(Integer.toString(nYear + i), Integer.toString(nYear + i)));
                ++i;
            }
            this.ddlFromYear.getDropDownListConfig().setSelectedValue(Integer.toString(nYear));
            this.ddlFromYear2.getDropDownListConfig().setSelectedValue(Integer.toString(nYear));
            this.ddlToYear.getDropDownListConfig().setSelectedValue(Integer.toString(nYear));
            this.ddlToYear2.getDropDownListConfig().setSelectedValue(Integer.toString(nYear));
            this.AddControl((SRFExControl)this.ddlFromYear);
            this.AddControl((SRFExControl)this.ddlFromYear2);
            this.AddControl((SRFExControl)this.ddlToYear);
            this.AddControl((SRFExControl)this.ddlToYear2);
            this.ddlFromSeason = new SRFExDropDownList();
            this.ddlFromSeason.InitConfig();
            this.ddlFromSeason.getDropDownListConfig().setWidth(80);
            this.ddlFromSeason.getDropDownListConfig().setID("ddlFromSeason");
            this.ddlFromSeason.getDropDownListConfig().getListItems().Add(new ListItem("1\u5b63\u5ea6", "01-01"));
            this.ddlFromSeason.getDropDownListConfig().getListItems().Add(new ListItem("2\u5b63\u5ea6", "04-01"));
            this.ddlFromSeason.getDropDownListConfig().getListItems().Add(new ListItem("3\u5b63\u5ea6", "07-01"));
            this.ddlFromSeason.getDropDownListConfig().getListItems().Add(new ListItem("4\u5b63\u5ea6", "10-01"));
            this.AddControl((SRFExControl)this.ddlFromSeason);
            this.ddlToSeason = new SRFExDropDownList();
            this.ddlToSeason.InitConfig();
            this.ddlToSeason.getDropDownListConfig().setWidth(80);
            this.ddlToSeason.getDropDownListConfig().setID("ddlToSeason");
            this.ddlToSeason.getDropDownListConfig().getListItems().Add(new ListItem("1\u5b63\u5ea6", "03-31"));
            this.ddlToSeason.getDropDownListConfig().getListItems().Add(new ListItem("2\u5b63\u5ea6", "06-30"));
            this.ddlToSeason.getDropDownListConfig().getListItems().Add(new ListItem("3\u5b63\u5ea6", "09-30"));
            this.ddlToSeason.getDropDownListConfig().getListItems().Add(new ListItem("4\u5b63\u5ea6", "12-31"));
            this.AddControl((SRFExControl)this.ddlToSeason);
            this.ddlFromMonth = new SRFExDropDownList();
            this.ddlFromMonth.InitConfig();
            this.ddlFromMonth.getDropDownListConfig().setWidth(80);
            this.ddlFromMonth.getDropDownListConfig().setID("ddlFromMonth");
            this.AddControl((SRFExControl)this.ddlFromMonth);
            this.ddlToMonth = new SRFExDropDownList();
            this.ddlToMonth.InitConfig();
            this.ddlToMonth.getDropDownListConfig().setWidth(80);
            this.ddlToMonth.getDropDownListConfig().setID("ddlToMonth");
            this.AddControl((SRFExControl)this.ddlToMonth);
            i = 1;
            while (i <= 12) {
                this.ddlFromMonth.getDropDownListConfig().getListItems().Add(new ListItem(StringHelper.Format((String)"%1$s\u6708", (Object)i), StringHelper.Format((String)"%1$s-1", (Object)i)));
                this.ddlToMonth.getDropDownListConfig().getListItems().Add(new ListItem(StringHelper.Format((String)"%1$s\u6708", (Object)i), StringHelper.Format((String)"%1$s", (Object)i)));
                ++i;
            }
            this.dtFromDate = new SRFExDatePickerEx();
            this.dtFromDate.InitConfig();
            this.dtFromDate.getDatePickerExConfig().setID("dtFromDate");
            this.AddControl((SRFExControl)this.dtFromDate);
            this.dtToDate = new SRFExDatePickerEx();
            this.dtToDate.InitConfig();
            this.dtToDate.getDatePickerExConfig().setID("dtToDate");
            this.AddControl((SRFExControl)this.dtToDate);
        }
    }

    protected void OnRender(Writer writer) {
        try {
            super.OnRender(writer);
            if (this.getForm() == null) {
                writer.write("\u6ca1\u6709\u627e\u5230\u63a7\u4ef6\u7684\u8868\u5355\u5bf9\u8c61");
                log.error((Object)"\u6ca1\u6709\u627e\u5230\u63a7\u4ef6\u7684\u8868\u5355\u5bf9\u8c61");
                return;
            }
            if (this.getBaseControlConfig().getWidthEx() == 0.0) {
                writer.write("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
            } else {
                writer.write(StringHelper.Format((String)"<table  border='0' cellspacing='0' cellpadding='0' style='width:%1$s'>", (Object)this.getBaseControlConfig().getWidthString()));
            }
            String strBIHIERARCHY = this.getBaseControlConfig().GetExtValue("BIHIERARCHY", "");
            String[] biHierarchies = strBIHIERARCHY.split("[;]");
            if (biHierarchies.length > 1) {
                writer.write(StringHelper.Format((String)"<tr><td style=\"padding-top:4px;\" colspan='4'>"));
                this.dropDownList.Render(writer);
                writer.write("</td></tr>");
            } else {
                String[] items = biHierarchies[0].split("[|]");
                StringBuilderEx script = new StringBuilderEx();
                script.Append("$P.AC['%1$s'].getStore().userparams.bihierarchyid='%2$s';", (Object)this.pkTimeDimension.getTextBox().getUniqueID(), (Object)items[1]);
                this.getPage().RegisterCacheOnReadyScript(3, script.toString());
            }
            writer.write("<tr>");
            writer.write("<td style=\"padding-top:4px;\" width='80'><span class='sx-normaltext'>\u5c55\u5f00\u7ef4\u5ea6</span></td>");
            writer.write("<td style=\"padding-top:4px;\" width='120'>");
            this.pkTimeDimension.Render(writer);
            writer.write("</td>");
            writer.write("<td  width='20'>&nbsp;</td>");
            writer.write("<td  width='160'>");
            writer.write(StringHelper.Format((String)"<table ID='%1$s_TIME' width='160' border='0' cellspacing='0' cellpadding='0' style='display:none'>", (Object)this.getUniqueID()));
            writer.write("<tr>");
            writer.write("<td style=\"padding-top:4px;\" width='80'><span class='sx-normaltext'>\u65f6\u95f4\u8303\u56f4</span></td>");
            writer.write("<td style=\"padding-top:4px;\" width='80'>");
            this.ddlTimeType.Render(writer);
            writer.write("</td>");
            writer.write("</tr>");
            writer.write("</table>");
            writer.write("</td>");
            writer.write("<td >&nbsp;</td>");
            writer.write("</tr>");
            writer.write("<tr>");
            writer.write("<td colspan='5' height='2'></td>");
            writer.write("</tr>");
            writer.write("<tr>");
            writer.write("<td colspan='5'>");
            writer.write(StringHelper.Format((String)"<table ID='%1$s_SEASON' width='100%%' border='0' cellspacing='0' cellpadding='0' style='display:none' >", (Object)this.getUniqueID()));
            writer.write("<td  width='30' align='center'><span class='sx-normaltext'>\u4ece</span></td>");
            writer.write("<td style=\"padding-top:4px;\" width='65'>");
            this.ddlFromYear.Render(writer);
            writer.write("</td>");
            writer.write("<td style=\"padding-top:4px;\" width='90'>");
            this.ddlFromSeason.Render(writer);
            writer.write("</td>");
            writer.write("<td  width='30' align='center'><span class='sx-normaltext'>\u81f3</span></td>");
            writer.write("<td style=\"padding-top:4px;\" width='65'>");
            this.ddlToYear.Render(writer);
            writer.write("</td>");
            writer.write("<td style=\"padding-top:4px;\" width='90'>");
            this.ddlToSeason.Render(writer);
            writer.write("</td>");
            writer.write("<td >&nbsp;</td>");
            writer.write("</tr>");
            writer.write("</table>");
            writer.write(StringHelper.Format((String)"<table ID='%1$s_MONTH' width='100%%' border='0' cellspacing='0' cellpadding='0' style='display:none'>", (Object)this.getUniqueID()));
            writer.write("<td  width='30' align='center'><span class='sx-normaltext'>\u4ece</span></td>");
            writer.write("<td style=\"padding-top:4px;\" width='65'>");
            this.ddlFromYear2.Render(writer);
            writer.write("</td>");
            writer.write("<td style=\"padding-top:4px;\" width='90'>");
            this.ddlFromMonth.Render(writer);
            writer.write("</td>");
            writer.write("<td  width='30' align='center'><span class='sx-normaltext'>\u81f3</span></td>");
            writer.write("<td style=\"padding-top:4px;\" width='65'>");
            this.ddlToYear2.Render(writer);
            writer.write("</td>");
            writer.write("<td style=\"padding-top:4px;\" width='90'>");
            this.ddlToMonth.Render(writer);
            writer.write("</td>");
            writer.write("<td >&nbsp;</td>");
            writer.write("</tr>");
            writer.write("</table>");
            writer.write(StringHelper.Format((String)"<table ID='%1$s_DAY' width='100%%' border='0' cellspacing='0' cellpadding='0' style='display:none'>", (Object)this.getUniqueID()));
            writer.write("<td  width='30' align='center'><span class='sx-normaltext'>\u4ece</span></td>");
            writer.write("<td style=\"padding-top:4px;\" width='120'>");
            this.dtFromDate.Render(writer);
            writer.write("</td>");
            writer.write("<td  width='30' align='center'><span class='sx-normaltext'>\u81f3</span></td>");
            writer.write("<td style=\"padding-top:4px;\" width='120'>");
            this.dtToDate.Render(writer);
            writer.write("</td>");
            writer.write("<td >&nbsp;</td>");
            writer.write("</tr>");
            writer.write("</table>");
            writer.write("</td>");
            writer.write("</tr>");
            writer.write("</table>");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setEnabled(boolean bEnabled) {
        super.setEnabled(bEnabled);
    }

    public String getItemValueJSCall(boolean bGetMode) {
        if (bGetMode) {
            StringBuilderEx script = new StringBuilderEx();
            String strBIHIERARCHY = this.getBaseControlConfig().GetExtValue("BIHIERARCHY", "");
            String[] biHierarchies = strBIHIERARCHY.split("[;]");
            if (biHierarchies.length > 1) {
                script.Append("_HRC=Ext.getDom('%1$s').value;", (Object)this.dropDownList.getUniqueID());
            } else {
                String[] items = biHierarchies[0].split("[|]");
                script.Append("_HRC='%1$s';", (Object)items[1]);
            }
            script.Append("_V=Ext.getDom('%1$s').value;", (Object)this.pkTimeDimension.getUniqueID());
            script.Append("var _LEVEL=_V;");
            script.Append("var _TYPE=Ext.getDom('%1$s').value;", (Object)this.ddlTimeType.getUniqueID());
            script.Append("if(_TYPE=='0'){_V='';}");
            script.Append("if(_TYPE=='1'){_V=Ext.getDom('%1$s').value+'-'+Ext.getDom('%2$s').value;}", (Object)this.ddlFromYear.getUniqueID(), (Object)this.ddlFromSeason.getUniqueID());
            script.Append("if(_TYPE=='2'){_V=Ext.getDom('%1$s').value+'-'+Ext.getDom('%2$s').value;}", (Object)this.ddlFromYear2.getUniqueID(), (Object)this.ddlFromMonth.getUniqueID());
            script.Append("if(_TYPE=='3'){%1$s}", (Object)this.dtFromDate.getItemValueJSCall(true));
            script.Append("var _FROM=_V;");
            script.Append("if(_TYPE=='0'){_V='';}");
            script.Append("if(_TYPE=='1'){_V=Ext.getDom('%1$s').value+'-'+Ext.getDom('%2$s').value;}", (Object)this.ddlToYear.getUniqueID(), (Object)this.ddlToSeason.getUniqueID());
            script.Append("if(_TYPE=='2'){var _Y=Ext.getDom('%1$s').value;var _M=Ext.getDom('%2$s').value;_V=_Y+'-'+_M+'-';switch(_M){case '1':case '3':case '5':case '7':case '8':case '10':case '12':_V+='31';break;case '2':{var _NY=parseInt(_Y);if((_NY%%400==0)||(_NY%%4==0&&_NY%%100!=0)){_V+='29'}}break;default:_V+='30';break;}}", (Object)this.ddlToYear2.getUniqueID(), (Object)this.ddlToMonth.getUniqueID());
            script.Append("if(_TYPE=='3'){%1$s}", (Object)this.dtToDate.getItemValueJSCall(true));
            script.Append("var _TO=_V;");
            script.AppendEx("_V='TD%%|SRF2|%%'+_HRC+'%%|SRF1|%%'+_LEVEL+'%%|SRF1|%%'+_FROM+'%%|SRF1|%%'+_TO;");
            script.Append("$FSV(_ID,_V);\r\n");
            return script.toString();
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append(super.getItemValueJSCall(bGetMode));
        script.Append("if(_V==''){Ext.getDom('%1$s').selectedIndex=0;_%1$s();}\r\n", (Object)this.ddlTimeType.getUniqueID());
        return script.toString();
    }
}

