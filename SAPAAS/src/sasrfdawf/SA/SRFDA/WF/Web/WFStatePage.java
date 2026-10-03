/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExPage
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.WF.Web;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExPage;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WFStatePage
extends SRFDAPage {
    protected DEWF dewf = null;
    private static String SQL_WFSTEPDATA = "SELECT \tt1.CREATEDATE AS ACTIONTIME,\t\tt31.WFACTORNAME AS ACTORNAME,\t\tt11.WFPLOGICNAME AS WFPLOGICNAME,\t\tt1.WFSTEPDATANAME AS WFSTEPDATANAME,\t\tt1.DESCRIPTION AS DESCRIPTION,\t\tt11.WFPLOGICNAME AS WFSTEPNAME\t\t\t\tFROM T_SRFWFSTEPDATA t1 \t\t\tLEFT JOIN T_SRFWFSTEP t11 ON t1.WFSTEPID = t11.WFSTEPID \t\tLEFT JOIN T_SRFWFINSTANCE t21 ON t1.WFINSTANCEID = t21.WFINSTANCEID \t\tLEFT JOIN T_SRFWFACTOR t31 ON t1.ACTORID = t31.WFACTORID\t\twhere t21.USERDATA = ? and t21.USERDATA4=? and t21.WFWORKFLOWID = ?\t\torder by t1.CREATEDATE asc\t\t";
    private static String FMT_WFSTEPDATA = "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %2$s<BR>&nbsp;[%3$s]==>[%4$s]<BR>&nbsp;%5$s<BR>";
    private static String FMT_WFSTEPDATA_NOSTEP = "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %2$s<BR>&nbsp;[%3$s]<BR>&nbsp;%4$s<BR>";
    private static String FMT_WFSTEPDATA2 = "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %2$s\r\n [%3$s]==>[%4$s]\r\n %5$s\r\n";
    private static String FMT_WFSTEPDATA2_NOSTEP = "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %2$s\r\n [%3$s]\r\n %3$s\r\n";

    public WFStatePage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        if (!this.getDEHelper().IsEnableWF()) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u652f\u6301\u5de5\u4f5c\u6d41", (Object)this.getDEHelper().GetFullName()));
            return false;
        }
        this.dewf = this.getDEHelper().GetDEWF();
        return true;
    }

    public String OutputWFState() {
        if (this.dewf == null || StringHelper.IsNullOrEmpty((String)this.dewf.getMSCLID())) {
            return "";
        }
        CodeListConfig codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig(this.dewf.getMSCLID(), this.getLanguage());
        if (codeListConfig == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]", (Object)this.dewf.getMSCLID()));
            return "";
        }
        boolean bNormalMode = StringHelper.IsNullOrEmpty((String)this.getPageModel());
        String strTipInfo = "";
        String strState = "";
        String strWFStep = "";
        String strKeyData = this.getWebContext().GetParamValue(this.getDEHelper().GetKeyDEFHelper().getName());
        if (!StringHelper.IsNullOrEmpty((String)strKeyData)) {
            BaseDataEntity dataEntity = new BaseDataEntity();
            dataEntity.SetParamValue(this.getDEHelper().GetKeyDEFHelper().getName(), this.getDEHelper().GetKeyDEFHelper().GetDEFValue(strKeyData));
            CallResult callResult = this.getDEHelper().GetDataAccHelper().Test((ISRFDAWebContext)this.getWebContext(), dataEntity, "READ");
            if (callResult.IsError()) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6d4b\u8bd5\u5b9e\u4f53\u6570\u636e[%1$s][%2$s]\u6743\u9650\u5931\u8d25\uff0c%3$s", (Object)this.getDEHelper().getId(), (Object)strKeyData, (Object)callResult.getErrorInfo()));
                return "";
            }
            callResult = this.GetDEDataCtrl().Get(dataEntity);
            if (callResult.IsError()) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u6570\u636e[%1$s][%2$s]\u5931\u8d25\uff0c%3$s", (Object)this.getDEHelper().getId(), (Object)strKeyData, (Object)callResult.getErrorInfo()));
                return "";
            }
            strState = dataEntity.GetParamStringValue(this.dewf.getSTATEDEFNAME(), "");
            strWFStep = dataEntity.GetParamStringValue(this.dewf.getWFSTEPDEFNAME(), "");
            String strWFId = this.getDEHelper().GetDEWFId(this.getWebContext().getSRFWFMode());
            CallParamList callParamList = new CallParamList();
            callParamList.Add(dataEntity.GetParamValue(this.getDEHelper().GetKeyDEFHelper().getName()));
            callParamList.Add((Object)this.getDEHelper().getId());
            callParamList.Add((Object)strWFId);
            Vector<BaseDataEntity> wfStepDatas = new Vector<BaseDataEntity>();
            callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)"", (String)SQL_WFSTEPDATA, (Vector)callParamList.GetList(), wfStepDatas, (String)"");
            if (callResult.IsError()) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237\u6570\u636e[%1$s][%2$s]\u6d41\u7a0b\u6570\u636e\u5931\u8d25\uff0c%3$s", (Object)this.getDEHelper().getId(), (Object)strKeyData, (Object)callResult.getErrorInfo()));
                return "";
            }
            for (BaseDataEntity wfStepData : wfStepDatas) {
                strTipInfo = StringHelper.IsNullOrEmpty((String)wfStepData.GetParamStringValue("WFSTEPID", "")) ? String.valueOf(strTipInfo) + StringHelper.Format((String)(bNormalMode ? FMT_WFSTEPDATA_NOSTEP : FMT_WFSTEPDATA2_NOSTEP), (Object)wfStepData.GetParamValue("ACTIONTIME"), (Object)wfStepData.GetParamValue("ACTORNAME"), (Object)wfStepData.GetParamValue("WFSTEPDATANAME"), (Object)wfStepData.GetParamStringValue("DESCRIPTION", "")) : String.valueOf(strTipInfo) + StringHelper.Format((String)(bNormalMode ? FMT_WFSTEPDATA : FMT_WFSTEPDATA2), (Object)wfStepData.GetParamValue("ACTIONTIME"), (Object)wfStepData.GetParamValue("ACTORNAME"), (Object)wfStepData.GetParamValue("WFPLOGICNAME"), (Object)wfStepData.GetParamValue("WFSTEPDATANAME"), (Object)wfStepData.GetParamStringValue("DESCRIPTION", ""));
            }
        }
        if (StringHelper.IsNullOrEmpty((String)strTipInfo)) {
            strTipInfo = "\u6ca1\u6709\u6b65\u9aa4\u4fe1\u606f";
        }
        ArrayList<JSONObject> arr = new ArrayList<JSONObject>();
        StringBuilderEx html = new StringBuilderEx();
        boolean bFinish = true;
        boolean bMatch = false;
        html.Append("<div id=\"srfwfmainstate\" style='width:%1$spx;margin-left:auto;margin-right:auto;'>", (Object)((codeListConfig.getCodeItems().size() - 1) * 200));
        int i = 0;
        while (i < codeListConfig.getCodeItems().size()) {
            CodeItemConfig codeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(i);
            if (i != 0) {
                if (bFinish) {
                    html.Append("<div class=\"proce proce_ready\"><ul><li >&nbsp;</li></ul></div>");
                } else {
                    html.Append("<div class=\"proce proce_wait\"><ul><li>&nbsp;</li></ul></div>");
                }
            }
            JSONObject jo = new JSONObject();
            jo.put("stepname", (Object)codeItemConfig.getText());
            jo.put("finish", bFinish);
            arr.add(jo);
            if (bFinish) {
                html.Append("<div class=\"node node_ready\"><ul><li >&nbsp;</li><li class=\"sx-normaltext\">%1$s</li></ul></div>", (Object)codeItemConfig.getText());
            } else {
                html.Append("<div class=\"node node_wait\"><ul><li >&nbsp;</li><li class=\"sx-normaltext\">%1$s</li></ul></div>", (Object)codeItemConfig.getText());
            }
            if (!bMatch) {
                if (StringHelper.IsNullOrEmpty((String)strState) && StringHelper.IsNullOrEmpty((String)strWFStep)) {
                    bMatch = true;
                } else {
                    int j;
                    String[] keys;
                    String strId = codeItemConfig.getValue();
                    String[] ids = strId.split("[;]");
                    boolean bOk = false;
                    if (ids.length >= 1) {
                        keys = ids[0].split("[|]");
                        j = 0;
                        while (j < keys.length) {
                            if (StringHelper.Compare((String)keys[j], (String)"*", (boolean)true) == 0) {
                                bOk = true;
                                break;
                            }
                            if (StringHelper.Compare((String)keys[j], (String)strState, (boolean)true) == 0) {
                                bOk = true;
                                break;
                            }
                            ++j;
                        }
                    }
                    if (bOk) {
                        if (ids.length >= 2) {
                            bOk = false;
                            keys = ids[1].split("[|]");
                            j = 0;
                            while (j < keys.length) {
                                if (StringHelper.Compare((String)keys[j], (String)"*", (boolean)true) == 0) {
                                    bOk = true;
                                    break;
                                }
                                if (StringHelper.Compare((String)keys[j], (String)strWFStep, (boolean)true) == 0) {
                                    bOk = true;
                                    break;
                                }
                                ++j;
                            }
                        }
                        if (bOk) {
                            bMatch = bOk;
                        }
                    }
                }
            }
            if (bMatch) {
                bFinish = false;
            }
            ++i;
        }
        html.Append("</div>");
        if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
            if (!StringHelper.IsNullOrEmpty((String)strTipInfo)) {
                SRFExPage.OutputScript((Writer)html.getWriter(), (String)StringHelper.Format((String)"$P.object['srfwfmainstatetips']=new Ext.ToolTip({target:'srfwfmainstate',html: '%1$s',autoHide: true,closable: false,dismissDelay: 0});", (Object)strTipInfo));
            }
            return html.toString();
        }
        JSONObject objRet = new JSONObject();
        objRet.put("items", (Object)JSONArray.fromArray((Object[])arr.toArray()));
        objRet.put("tips", (Object)strTipInfo);
        return objRet.toString();
    }
}

