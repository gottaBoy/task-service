/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.PP.PPETMForm
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Ajax.BaseDAAjaxActionHelper;
import SA.SRFDA.Ctrl.Ajax.BaseDATabMultiFormActionHelper;
import SA.SRFDA.Ctrl.Data.PP.PPETMForm;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Web.Default.BaseMultiEditFormPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;
import net.sf.json.JSONObject;

public class EmbedTabMultiFormPage
extends BaseMultiEditFormPage {
    public static final String PPCTRLID_ETMFORM = "ETMFORM";
    protected PPETMForm ppETMForm = null;

    @Override
    protected void PreparePageParam() {
        BaseDataEntity pageParam;
        super.PreparePageParam();
        if (this.page != null && (pageParam = this.page.getAdvPageParam(PPCTRLID_ETMFORM, "PP_ETMFORM")) != null && pageParam instanceof PPETMForm) {
            this.ppETMForm = (PPETMForm)pageParam;
        }
    }

    public String GetEditPath() {
        String strURL = "../srfpage/embededitview2.jsp?";
        String strEditPageId = "";
        if (this.ppETMForm != null) {
            strEditPageId = this.ppETMForm.getEDITPAGEID();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strEditPageId = this.getPageParam("PAGE.TMF.EDITPAGE", strEditPageId)))) {
            Page editPage = this.getWebContext().getGlobalHelper().getDAModelStorage().FindPage(strEditPageId);
            if (editPage == null) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762[%1$s]\u914d\u7f6e", (Object)strEditPageId));
                return "";
            }
            if (!StringHelper.IsNullOrEmpty((String)editPage.GetTotalPagePath())) {
                strURL = editPage.GetTotalPagePath();
            }
        }
        strURL = URLHelper.AppendURLSeperator((String)strURL);
        this.getWebContext().RemoveParam("SRFNEWDATA");
        TreeMap<String, String> daParams = new TreeMap<String, String>();
        daParams.put("SRFDEID", this.iDEHelper.getId());
        daParams.put("SRFPDEID", this.getWebContext().getSRFPDEID());
        daParams.put("SRFDERID", this.getWebContext().getSRFDERID());
        daParams.put("SRFTEMPDATA", this.getWebContext().GetParamValue("SRFTEMPDATA"));
        String strDAParams = URLHelper.GetQueryString(daParams);
        if (!StringHelper.IsNullOrEmpty((String)strDAParams)) {
            strURL = String.valueOf(strURL) + strDAParams;
            strURL = String.valueOf(strURL) + "&";
        }
        strURL = String.valueOf(strURL) + this.getWebContext().GetQueryStringWithoutDAParam(daParams);
        strURL = String.valueOf(strURL) + StringHelper.Format((String)"&%1$s=", (Object)this.getDEHelper().GetKeyDEFHelper().getName());
        return strURL;
    }

    public int GetTMFDefaultCnt() {
        int nDefaultCnt = 0;
        if (this.ppETMForm != null && !this.ppETMForm.isDEFAULTCNTNull()) {
            nDefaultCnt = this.ppETMForm.getDEFAULTCNT();
        }
        return this.getPageParam("PAGE.TMF.DEFAULTCNT", nDefaultCnt);
    }

    public String GetDataName() {
        return this.getDEHelper().getLogicName(this.getLanguage());
    }

    public String GetLoadCode() {
        StringBuilderEx script = new StringBuilderEx();
        String strSummaryKey = this.getWebContext().GetParamValue("SRFSUMMARYKEY");
        if (StringHelper.IsNullOrEmpty((String)strSummaryKey)) {
            return "";
        }
        script.Append("var _V=$V(_1.%1$s,'');", (Object)strSummaryKey);
        script.Append("var _td=false;if(_V==''){_V=$V(_1.%1$s,'');if(_V!=''){_td=true;}}", (Object)"SRFDATEMPKEYID");
        script.Append("var _2={'%1$s':_V};if(_td){_2.srftempdata=true;}", (Object)this.getWebContext().GetParamValue("SRFSUMMARYKEY").toLowerCase());
        script.Append("tabEditForm.list(_2);");
        return script.toString();
    }

    protected boolean OnCustomAction(String strActionType, String strAction) {
        if (StringHelper.Compare((String)strActionType, (String)"tabeditform", (boolean)true) == 0) {
            BaseDAAjaxActionHelper tabEditFormActionHelper = this.GetTabEditFormAjaxActionHelper();
            tabEditFormActionHelper.Process(this, strAction);
            return true;
        }
        return super.OnCustomAction(strActionType, strAction);
    }

    protected BaseDAAjaxActionHelper GetTabEditFormAjaxActionHelper() {
        String strActionHelper = this.getPageParam("PAGE.TMFACTIONHELPER", "");
        if (StringHelper.IsNullOrEmpty((String)strActionHelper)) {
            return new BaseDATabMultiFormActionHelper();
        }
        Object objHelper = ObjectHelper.Create((String)strActionHelper);
        if (objHelper == null) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5bf9\u8c61[%1$s]", (Object)strActionHelper));
            return null;
        }
        if (!(objHelper instanceof BaseDAAjaxActionHelper)) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strActionHelper));
            return null;
        }
        return (BaseDAAjaxActionHelper)((Object)objHelper);
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        jsonObject.put("editpath", (Object)this.GetEditPath());
        jsonObject.put("dataname", (Object)this.GetDataName());
        jsonObject.put("tmfdefaultcnt", this.GetTMFDefaultCnt());
        jsonObject.put("infomode", this.isInfoMode());
        jsonObject.put("tmfupdateonly", this.OnGetUpdateOnly());
        jsonObject.put("tmfignorenotdirty", this.OnGetIgnoreNotDirty());
        return true;
    }

    protected boolean OnGetUpdateOnly() {
        return this.getPageParam("PAGE.TMF.UPDATEONLY", false);
    }

    protected boolean OnGetIgnoreNotDirty() {
        return this.getPageParam("PAGE.TMF.IGNORENOTDIRTY", true);
    }
}

