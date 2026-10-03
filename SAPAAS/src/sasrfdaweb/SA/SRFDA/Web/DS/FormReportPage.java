/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.Web.WebUtility
 *  SA.SRFramework.WebEx.DP.UI.DPBaseFormItemConfig
 *  SA.SRFramework.WebEx.DP.UI.DPConfig
 *  SA.SRFramework.WebEx.DP.UI.DPPageGroupConfig
 *  SA.SRFramework.WebEx.UI.FormControlConfig
 */
package SA.SRFDA.Web.DS;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.WebUtility;
import SA.SRFramework.WebEx.DP.UI.DPBaseFormItemConfig;
import SA.SRFramework.WebEx.DP.UI.DPConfig;
import SA.SRFramework.WebEx.DP.UI.DPPageGroupConfig;
import SA.SRFramework.WebEx.UI.FormControlConfig;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Vector;

public class FormReportPage
extends SRFDAPage {
    protected String strReportOutput = "";
    public static final String STYLE_LEFTBORDER = "border-left:0.5pt solid black;";
    public static final String STYLE_TOPBORDER = "border-top:0.5pt solid black;";
    public static final String STYLE_RIGHTBORDER = "border-right:0.5pt solid black;";
    public static final String STYLE_BOTTOMBORDER = "border-bottom:0.5pt solid black;";
    public static final String STYLE_WHITETILETEXT = "FONT-WEIGHT: bold; FONT-SIZE: 10pt; COLOR: #ffffff;";
    public static final String STYLE_BLACKTILETEXT11 = "padding:3px;FONT-WEIGHT: bold; FONT-SIZE: 11pt; COLOR: #000000;";
    public static final String STYLE_NORMALTEXT10 = "padding:2px;FONT-SIZE: 10pt; COLOR: #000000;";

    public FormReportPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
        this.setNoCache(false);
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        try {
            String strSQL = "select * from V_SRFFORM where (DEID LIKE 'DE%' OR DEID LIKE 'EAI%' OR DEID LIKE 'WF%' OR DEID LIKE 'UAC%' OR DEID LIKE 'TS%') and ISMAJOR = 1 ORDER BY DEID ";
            Vector<Form> forms = new Vector<Form>();
            CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)strSQL, null, forms, (String)Form.class.getName());
            if (callResult.IsError()) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u62a5\u8868\u8868\u5355\u9879\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return;
            }
            StringWriter sw = new StringWriter();
            for (Form form : forms) {
                IDEHelper iDEHelper = this.getDAModelStorage().FindDEHelper(form.getDEID());
                if (iDEHelper == null) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)form.getDEID()));
                    continue;
                }
                String strDPConfigId = this.getDAConfigHelper().GetEditViewDPId(iDEHelper, form);
                if (StringHelper.IsNullOrEmpty((String)strDPConfigId)) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u8868\u5355[%1$s]\u914d\u7f6e", (Object)form.getFORMID()));
                    continue;
                }
                DPConfig panelConfig = this.getWebContext().getDynamicPanelMgr().GetDPExConfig(strDPConfigId);
                if (panelConfig == null) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u52a8\u6001\u9762\u677f[%1$s]\u65e0\u6548", (Object)strDPConfigId));
                    continue;
                }
                this.OutputDP(sw, iDEHelper, form, panelConfig);
            }
            this.strReportOutput = sw.toString();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String GetReportOutput() {
        return this.strReportOutput;
    }

    protected void OutputDP(StringWriter sw, IDEHelper iDEHelper, Form form, DPConfig panelConfig) {
        sw.write(StringHelper.Format((String)"<H1>[%1$s-%2$s] %3$s </H1></BR>", (Object)iDEHelper.getId(), (Object)iDEHelper.getLogicName(), (Object)form.getFORMNAME()));
        sw.write("<table width='800' border='0' cellspacing='0' cellpadding='0'>");
        int nCount = panelConfig.getPageGroupsConfig().size();
        int i = 0;
        while (i < nCount) {
            DPPageGroupConfig pageGroupConfig = (DPPageGroupConfig)panelConfig.getPageGroupsConfig().get(i);
            sw.write("<tr><td>");
            sw.write(StringHelper.Format((String)"<H2>%1$s", (Object)pageGroupConfig.getCaption()));
            sw.write("</td></tr>");
            sw.write("<tr><td>&nbsp;</td></tr>");
            sw.write("<tr><td >");
            sw.write(StringHelper.Format((String)"<IMG src='formimages/%1$s_%2$s.jpg'>", (Object)form.getFORMID(), (Object)i));
            sw.write("</td></tr>");
            ArrayList formCtrlList = new ArrayList();
            pageGroupConfig.GetFormCtrlConfig(formCtrlList);
            if (formCtrlList.size() != 0) {
                sw.write("<tr><td>&nbsp;</td></tr>");
                sw.write("<tr><td>");
                sw.write("<TABLE width='720' cellSpacing=\"0\" cellPadding=\"0\" border=\"0\">\r\n");
                sw.write("<TR>");
                sw.write(StringHelper.Format((String)"<TD width='200' bgColor='#eeeeee'  align='left' style='%1$s'>", (Object)"padding:3px;FONT-WEIGHT: bold; FONT-SIZE: 11pt; COLOR: #000000;border-left:0.5pt solid black;border-top:0.5pt solid black;border-right:0.5pt solid black;border-bottom:0.5pt solid black;"));
                sw.write("\u8868\u5355\u9879");
                sw.write("</TD>");
                sw.write(StringHelper.Format((String)"<TD width='100' bgColor='#eeeeee' align='center' style='%1$s'>", (Object)"padding:3px;FONT-WEIGHT: bold; FONT-SIZE: 11pt; COLOR: #000000;border-top:0.5pt solid black;border-right:0.5pt solid black;border-bottom:0.5pt solid black;"));
                sw.write("\u5fc5\u987b\u8f93\u5165");
                sw.write("</TD>");
                sw.write(StringHelper.Format((String)"<TD width='100' bgColor='#eeeeee' align='center' style='%1$s'>", (Object)"padding:3px;FONT-WEIGHT: bold; FONT-SIZE: 11pt; COLOR: #000000;border-top:0.5pt solid black;border-right:0.5pt solid black;border-bottom:0.5pt solid black;"));
                sw.write("\u542f\u7528\u72b6\u6001");
                sw.write("</TD>");
                sw.write(StringHelper.Format((String)"<TD width='420' bgColor='#eeeeee' align='left' style='%1$s'>", (Object)"padding:3px;FONT-WEIGHT: bold; FONT-SIZE: 11pt; COLOR: #000000;border-top:0.5pt solid black;border-right:0.5pt solid black;border-bottom:0.5pt solid black;"));
                sw.write("\u8bf4\u660e");
                sw.write("</TD>");
                sw.write("</TR>");
                int j = 0;
                while (j < formCtrlList.size()) {
                    boolean bAllowEmpty;
                    DPBaseFormItemConfig formItemConfig = (DPBaseFormItemConfig)formCtrlList.get(j);
                    IDEFHelper iDEFHelper = iDEHelper.GetDEFHelper(formItemConfig.getCtrlConfig().getID());
                    String strCaption = formItemConfig.getCaption();
                    String strDescription = "";
                    if (StringHelper.IsNullOrEmpty((String)strCaption) && iDEFHelper != null) {
                        strCaption = iDEFHelper.getLogicName();
                    }
                    if (iDEFHelper != null) {
                        strDescription = WebUtility.TextToHTML((String)iDEFHelper.getDEField().getDESCRIPTION());
                    }
                    if (StringHelper.IsNullOrEmpty((String)strDescription)) {
                        strDescription = "&nbsp;";
                    }
                    if (StringHelper.IsNullOrEmpty((String)strCaption)) {
                        strCaption = "&nbsp;";
                    }
                    String strAllowEmpty = (bAllowEmpty = formItemConfig.getAllowEmpty()) ? "\u662f" : "\u5426";
                    String strValidCond = "\u5168\u90e8";
                    if (formItemConfig.getCtrlConfig() instanceof FormControlConfig) {
                        FormControlConfig formControlConfig = (FormControlConfig)formItemConfig.getCtrlConfig();
                        String strValid = formControlConfig.getFormItemConfig().getValidCond();
                        if (StringHelper.Compare((String)strValid, (String)"CREATE", (boolean)true) == 0) {
                            strValidCond = "\u5efa\u7acb";
                        } else if (StringHelper.Compare((String)strValid, (String)"UPDATE", (boolean)true) == 0) {
                            strValidCond = "\u66f4\u65b0";
                        } else if (StringHelper.Compare((String)strValid, (String)"ALL", (boolean)true) == 0) {
                            strValidCond = "\u5168\u90e8";
                        } else if (StringHelper.Compare((String)strValid, (String)"NONE", (boolean)true) == 0) {
                            strAllowEmpty = "\u65e0";
                            strValidCond = "\u65e0";
                        }
                    }
                    sw.write("<TR>");
                    sw.write(StringHelper.Format((String)"<TD  align='left' style='%1$s'>", (Object)"padding:2px;FONT-SIZE: 10pt; COLOR: #000000;border-left:0.5pt solid black;border-right:0.5pt solid black;border-bottom:0.5pt solid black;"));
                    sw.write(strCaption);
                    sw.write("</TD>");
                    sw.write(StringHelper.Format((String)"<TD  align='center' style='%1$s'>", (Object)"padding:2px;FONT-SIZE: 10pt; COLOR: #000000;border-right:0.5pt solid black;border-bottom:0.5pt solid black;"));
                    sw.write(strAllowEmpty);
                    sw.write("</TD>");
                    sw.write(StringHelper.Format((String)"<TD  align='center' style='%1$s'>", (Object)"padding:2px;FONT-SIZE: 10pt; COLOR: #000000;border-right:0.5pt solid black;border-bottom:0.5pt solid black;"));
                    sw.write(strValidCond);
                    sw.write("</TD>");
                    sw.write(StringHelper.Format((String)"<TD  align='left' style='%1$s'>", (Object)"padding:2px;FONT-SIZE: 10pt; COLOR: #000000;border-right:0.5pt solid black;border-bottom:0.5pt solid black;"));
                    sw.write(strDescription);
                    sw.write("</TD>");
                    sw.write("</TR>");
                    ++j;
                }
                sw.write("</TABLE>\r\n");
                sw.write("</td></tr>");
                sw.write("<tr><td>&nbsp;</td></tr>");
            }
            ++i;
        }
        sw.write("</table>");
    }
}
