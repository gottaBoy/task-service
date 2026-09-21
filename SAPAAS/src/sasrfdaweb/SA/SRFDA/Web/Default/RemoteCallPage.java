/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Security.IRCAccListHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExAjaxListResult
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Security.IRCAccListHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExAjaxListResult;
import java.util.Hashtable;
import java.util.Vector;

public class RemoteCallPage
extends SRFDAPage {
    public RemoteCallPage() {
        this.setMainPage(false);
        this.setOutputDebug(false);
    }

    protected void OnLoad() {
        SRFExAjaxListResult ajaxActionResult = null;
        try {
            ajaxActionResult = this.RemoteCall();
        }
        catch (Exception ex) {
            ajaxActionResult = new SRFExAjaxListResult();
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(ex.getMessage());
        }
        this.Output(ajaxActionResult.ToJSONString());
    }

    protected SRFExAjaxListResult RemoteCall() throws Exception {
        String strRCAccListId = this.getWebContext().GetParamValue("SRFRCALID");
        if (StringHelper.IsNullOrEmpty((String)strRCAccListId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8fdc\u7a0b\u8c03\u7528\u8bbf\u95ee\u6807\u8bc6");
        }
        IRCAccListHelper iRCAccListHelper = this.getDAModelStorage().FindRCAccList(strRCAccListId);
        SRFExAjaxListResult ajaxActionResult = new SRFExAjaxListResult();
        String strDEId = this.getWebContext().GetParamValue("SRFDEID");
        String strCall = this.getWebContext().GetParamValue("SRFCALL");
        String strRemoteAddr = this.getWebContext().getRemoteAddr();
        if (StringHelper.IsNullOrEmpty((String)strDEId)) {
            if (StringHelper.Compare((String)strCall, (String)"GETSV", (boolean)false) == 0) {
                String strArg = this.getWebContext().GetPostValue("srfarg");
                BaseDataEntity dataEntity = BaseDataEntity.FromString((String)strArg);
                Hashtable totalParamList = dataEntity.getTotalParamList();
                for (Object objKey : totalParamList.keySet()) {
                    Object objValue = this.getWebContext().GetSessionValue(objKey.toString());
                    dataEntity.SetParamValue(objKey.toString(), objValue);
                }
                ajaxActionResult.getItems().add(BaseDataEntity.ToString((BaseDataEntity)dataEntity, (boolean)true));
                return ajaxActionResult;
            }
            if (StringHelper.Compare((String)strCall, (String)"GETGV", (boolean)false) == 0) {
                String strArg = this.getWebContext().GetPostValue("srfarg");
                BaseDataEntity dataEntity = BaseDataEntity.FromString((String)strArg);
                Hashtable totalParamList = dataEntity.getTotalParamList();
                for (Object objKey : totalParamList.keySet()) {
                    Object objValue = this.getWebContext().GetGlobalValue(objKey.toString());
                    dataEntity.SetParamValue(objKey.toString(), objValue);
                }
                ajaxActionResult.getItems().add(BaseDataEntity.ToString((BaseDataEntity)dataEntity, (boolean)true));
                return ajaxActionResult;
            }
        } else {
            IDEDataCtrl iDEDataCtrl = this.GetDEDataCtrl(strDEId);
            if (iDEDataCtrl == null) {
                ajaxActionResult.setRetCode(1);
                ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)strDEId));
                return ajaxActionResult;
            }
            if (StringHelper.Compare((String)strCall, (String)"SAVE", (boolean)false) == 0) {
                boolean bInsert = StringHelper.Compare((String)this.getWebContext().GetPostValue("srfarg"), (String)"TRUE", (boolean)true) == 0;
                String strActionMode = this.getWebContext().GetPostValue("srfarg2");
                String strArg3 = this.getWebContext().GetPostValue("srfarg3");
                if (!iRCAccListHelper.TestRemoteCall(strRemoteAddr, strDEId, bInsert ? "INSERT" : "UPDATE", strActionMode, "", "")) {
                    ajaxActionResult.setRetCode(2);
                    ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u8fdc\u7a0b\u8c03\u7528\u6ca1\u6709\u6388\u6743"));
                    return ajaxActionResult;
                }
                BaseDataEntity dataEntity = BaseDataEntity.FromString((String)strArg3);
                CallResult callResult = iDEDataCtrl.Save(bInsert, strActionMode, dataEntity);
                ajaxActionResult.From(callResult);
                if (callResult.IsError()) {
                    return ajaxActionResult;
                }
                ajaxActionResult.getItems().add(BaseDataEntity.ToString((BaseDataEntity)dataEntity, (boolean)true));
                return ajaxActionResult;
            }
            if (StringHelper.Compare((String)strCall, (String)"REMOVE", (boolean)false) == 0) {
                String strActionMode = this.getWebContext().GetPostValue("srfarg");
                String strArg2 = this.getWebContext().GetPostValue("srfarg2");
                if (!iRCAccListHelper.TestRemoteCall(strRemoteAddr, strDEId, "REMOVE", strActionMode, "", "")) {
                    ajaxActionResult.setRetCode(2);
                    ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u8fdc\u7a0b\u8c03\u7528\u6ca1\u6709\u6388\u6743"));
                    return ajaxActionResult;
                }
                BaseDataEntity dataEntity = BaseDataEntity.FromString((String)strArg2);
                CallResult callResult = iDEDataCtrl.Remove(strActionMode, dataEntity);
                ajaxActionResult.From(callResult);
                if (callResult.IsError()) {
                    return ajaxActionResult;
                }
                return ajaxActionResult;
            }
            if (StringHelper.Compare((String)strCall, (String)"CUSTOMCALL", (boolean)false) == 0) {
                String strActionMode = this.getWebContext().GetPostValue("srfarg");
                String strArg2 = this.getWebContext().GetPostValue("srfarg2");
                if (!iRCAccListHelper.TestRemoteCall(strRemoteAddr, strDEId, "CUSTOMCALL", strActionMode, "", "")) {
                    ajaxActionResult.setRetCode(2);
                    ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u8fdc\u7a0b\u8c03\u7528\u6ca1\u6709\u6388\u6743"));
                    return ajaxActionResult;
                }
                BaseDataEntity dataEntity = BaseDataEntity.FromString((String)strArg2);
                CallResult callResult = iDEDataCtrl.CustomCall(strActionMode, dataEntity);
                ajaxActionResult.From(callResult);
                if (callResult.IsError()) {
                    return ajaxActionResult;
                }
                ajaxActionResult.getItems().add(BaseDataEntity.ToString((BaseDataEntity)dataEntity, (boolean)true));
                return ajaxActionResult;
            }
            if (StringHelper.Compare((String)strCall, (String)"GET", (boolean)false) == 0) {
                String strArg = this.getWebContext().GetPostValue("srfarg");
                if (!iRCAccListHelper.TestRemoteCall(strRemoteAddr, strDEId, "SELECT", "", "", "")) {
                    ajaxActionResult.setRetCode(2);
                    ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u8fdc\u7a0b\u8c03\u7528\u6ca1\u6709\u6388\u6743"));
                    return ajaxActionResult;
                }
                BaseDataEntity dataEntity = BaseDataEntity.FromString((String)strArg);
                CallResult callResult = iDEDataCtrl.Get(dataEntity);
                ajaxActionResult.From(callResult);
                if (callResult.IsError()) {
                    return ajaxActionResult;
                }
                ajaxActionResult.getItems().add(BaseDataEntity.ToString((BaseDataEntity)dataEntity, (boolean)true));
                return ajaxActionResult;
            }
            if (StringHelper.Compare((String)strCall, (String)"SELECT", (boolean)false) == 0) {
                if (!iRCAccListHelper.TestRemoteCall(strRemoteAddr, strDEId, "SELECT", "", "", "")) {
                    ajaxActionResult.setRetCode(2);
                    ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u8fdc\u7a0b\u8c03\u7528\u6ca1\u6709\u6388\u6743"));
                    return ajaxActionResult;
                }
                Vector list = new Vector();
                String strArg = this.getWebContext().GetPostValue("srfarg");
                BaseDataEntity dataEntity = BaseDataEntity.FromString((String)strArg);
                CallResult callResult = iDEDataCtrl.Select(dataEntity, list);
                ajaxActionResult.From(callResult);
                if (callResult.IsError()) {
                    return ajaxActionResult;
                }
                for (BaseDataEntity item : list) {
                    ajaxActionResult.getItems().add(BaseDataEntity.ToString((BaseDataEntity)item, (boolean)true));
                }
                return ajaxActionResult;
            }
            if (StringHelper.Compare((String)strCall, (String)"SELECT1", (boolean)false) == 0) {
                if (!iRCAccListHelper.TestRemoteCall(strRemoteAddr, strDEId, "SELECT", "", "", "")) {
                    ajaxActionResult.setRetCode(2);
                    ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u8fdc\u7a0b\u8c03\u7528\u6ca1\u6709\u6388\u6743"));
                    return ajaxActionResult;
                }
                String strArg = this.getWebContext().GetPostValue("srfarg");
                BaseDataEntity dataEntity = BaseDataEntity.FromString((String)strArg);
                CallResult callResult = iDEDataCtrl.Select(dataEntity);
                ajaxActionResult.From(callResult);
                if (callResult.IsError()) {
                    return ajaxActionResult;
                }
                ajaxActionResult.getItems().add(BaseDataEntity.ToString((BaseDataEntity)dataEntity, (boolean)true));
                return ajaxActionResult;
            }
            if (StringHelper.Compare((String)strCall, (String)"SELECTEX", (boolean)false) == 0) {
                if (!iRCAccListHelper.TestRemoteCall(strRemoteAddr, strDEId, "SELECT", "", "", "")) {
                    ajaxActionResult.setRetCode(2);
                    ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u8fdc\u7a0b\u8c03\u7528\u6ca1\u6709\u6388\u6743"));
                    return ajaxActionResult;
                }
                Vector list = new Vector();
                String strActionMode = this.getWebContext().GetPostValue("srfarg");
                String strArg2 = this.getWebContext().GetPostValue("srfarg2");
                BaseDataEntity dataEntity = BaseDataEntity.FromString((String)strArg2);
                CallResult callResult = iDEDataCtrl.Select(strActionMode, dataEntity, list);
                ajaxActionResult.From(callResult);
                if (callResult.IsError()) {
                    return ajaxActionResult;
                }
                for (BaseDataEntity item : list) {
                    ajaxActionResult.getItems().add(BaseDataEntity.ToString((BaseDataEntity)item, (boolean)true));
                }
                return ajaxActionResult;
            }
            if (StringHelper.Compare((String)strCall, (String)"GETDEFAULT", (boolean)false) == 0) {
                if (!iRCAccListHelper.TestRemoteCall(strRemoteAddr, strDEId, "GETDEFAULT", "", "", "")) {
                    ajaxActionResult.setRetCode(2);
                    ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u8fdc\u7a0b\u8c03\u7528\u6ca1\u6709\u6388\u6743"));
                    return ajaxActionResult;
                }
                String strArg = this.getWebContext().GetPostValue("srfarg");
                BaseDataEntity dataEntity = BaseDataEntity.FromString((String)strArg);
                CallResult callResult = iDEDataCtrl.GetDefault((ISRFDAWebContext)this.getWebContext(), dataEntity);
                ajaxActionResult.From(callResult);
                if (callResult.IsError()) {
                    return ajaxActionResult;
                }
                ajaxActionResult.getItems().add(BaseDataEntity.ToString((BaseDataEntity)dataEntity, (boolean)true));
                return ajaxActionResult;
            }
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8fdc\u7a0b\u8c03\u7528[%1$s]", (Object)strCall));
    }
}

