/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExDGAjaxActionResult
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExDGAjaxActionResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WebPartDataGridActionHelper
extends BaseDADataGridActionHelper {
    private static final Log log = LogFactory.getLog(WebPartDataGridActionHelper.class);
    public static final String TAG_CALLID_ADDTOPPMODEL = "ADDTOPPMODEL";

    @Override
    protected boolean OnCustomAction(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)TAG_CALLID_ADDTOPPMODEL, (boolean)true) == 0) {
            return this.AddToPPModel();
        }
        return super.OnCustomAction(strAction);
    }

    @Override
    protected boolean OnGetUserDP() {
        if (StringHelper.Compare((String)this.getWebContext().getCurUserId(), (String)"SYSTEM", (boolean)true) == 0) {
            return false;
        }
        return this.getPage().getPageParam("PAGE.DATAGRID.USERDP", false);
    }

    protected boolean AddToPPModel() {
        SRFExDGAjaxActionResult customActionResult = new SRFExDGAjaxActionResult();
        customActionResult.setReload(false);
        String strPPModelId = this.getWebContext().GetParamValue("PPMODELID");
        if (StringHelper.IsNullOrEmpty((String)strPPModelId)) {
            customActionResult.setRetCode(5);
            customActionResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u9875\u9762\u6a21\u578b\u6807\u8bc6");
            this.getPage().Output(customActionResult.ToJSONString());
            return true;
        }
        IDEDataCtrl ppmwebpartDataCtrl = this.getPage().getDAModelStorage().FindDEDataCtrl("DE0026", (ISRFDAWebContext)this.getWebContext());
        if (ppmwebpartDataCtrl == null) {
            customActionResult.setRetCode(1);
            customActionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0026"));
            log.error((Object)customActionResult.getErrorInfo());
            this.getPage().Output(customActionResult.ToJSONString());
            return true;
        }
        IDEHelper iWebPartDEHelper = this.getPage().getDAModelStorage().FindDEHelper("DE0020");
        if (iWebPartDEHelper == null) {
            customActionResult.setRetCode(1);
            customActionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)"DE0020"));
            log.error((Object)customActionResult.getErrorInfo());
            this.getPage().Output(customActionResult.ToJSONString());
            return true;
        }
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        String[] keys = strKeys.split("[,]");
        String strErrorInfo = "";
        int i = 0;
        while (i < keys.length) {
            String strKeyId = keys[i];
            if (!StringHelper.IsNullOrEmpty((String)strKeyId)) {
                CallResult callResult;
                BaseDataEntity dataEntity = new BaseDataEntity();
                dataEntity.SetParamValue("WEBPARTID", (Object)strKeyId);
                if (this.OnGetUserDP() && (callResult = iWebPartDEHelper.GetDataAccHelper().Test((ISRFDAWebContext)this.getWebContext(), dataEntity, "READ")).IsError()) {
                    strErrorInfo = StringHelper.Format((String)"\u6267\u884c\u64cd\u4f5c\u5931\u8d25\uff1a%1$s", (Object)callResult.getErrorInfo());
                    break;
                }
                dataEntity.SetParamValue("PPMODELID", (Object)strPPModelId);
                callResult = ppmwebpartDataCtrl.Save(true, dataEntity);
                if (callResult.getRetCode() != 0 && callResult.getRetCode() != 1007) {
                    strErrorInfo = StringHelper.Format((String)"\u6267\u884c\u64cd\u4f5c\u5931\u8d25\uff1a%1$s", (Object)callResult.getErrorInfo());
                    break;
                }
            }
            ++i;
        }
        if (StringHelper.IsNullOrEmpty((String)strErrorInfo)) {
            customActionResult.setJSCode("alert('\u589e\u52a0\u7f51\u9875\u90e8\u4ef6\u6210\u529f\uff01');");
            customActionResult.setRetCode(0);
        } else {
            customActionResult.setRetCode(1);
            customActionResult.setErrorInfo(strErrorInfo);
        }
        this.getPage().Output(customActionResult.ToJSONString());
        return true;
    }
}

