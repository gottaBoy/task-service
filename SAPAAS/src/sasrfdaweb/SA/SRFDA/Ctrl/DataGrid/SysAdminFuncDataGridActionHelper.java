/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.SysAdminFunc
 *  SA.SRFDA.Ctrl.IDASystemAdmin
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.WebEx.SRFExDGAjaxActionResult
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.Data.SysAdminFunc;
import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFDA.Ctrl.IDASystemAdmin;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.SRFExDGAjaxActionResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SysAdminFuncDataGridActionHelper
extends BaseDADataGridActionHelper {
    private static final Log log = LogFactory.getLog(SysAdminFuncDataGridActionHelper.class);
    public static final String CALLID_CALLFUNC = "CALLFUNC";

    @Override
    protected boolean OnCustomAction(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)CALLID_CALLFUNC, (boolean)true) == 0) {
            return this.CallSysAdminFunc();
        }
        return super.OnCustomAction(strAction);
    }

    protected boolean CallSysAdminFunc() {
        SRFExDGAjaxActionResult customActionResult = new SRFExDGAjaxActionResult();
        customActionResult.setReload(false);
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        String[] keys = strKeys.split("[,]");
        if (keys.length == 0) {
            customActionResult.setRetCode(1);
            customActionResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u6709\u6548\u7684\u7cfb\u7edf\u7ba1\u7406\u529f\u80fd\u7f16\u53f7"));
            this.getPage().Output(customActionResult.ToJSONString());
            return true;
        }
        IDEDataCtrl iDEDataCtrl = this.getPage().GetDEDataCtrl();
        if (iDEDataCtrl == null) {
            customActionResult.setRetCode(1);
            customActionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0103"));
            this.getPage().Output(customActionResult.ToJSONString());
            return true;
        }
        SysAdminFunc sysAdminFunc = new SysAdminFunc();
        sysAdminFunc.setSYSADMINFUNCID(keys[0]);
        CallResult callResult = iDEDataCtrl.Get((BaseDataEntity)sysAdminFunc);
        if (callResult.IsError()) {
            customActionResult.setRetCode(callResult.getRetCode());
            customActionResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u7ba1\u7406\u529f\u80fd[%1$s]\u5931\u8d25\uff0c%2$s", (Object)keys[0], (Object)callResult.getErrorInfo()));
            this.getPage().PageLog((Object)this, 1, customActionResult.getErrorInfo());
            this.getPage().Output(customActionResult.ToJSONString());
            return true;
        }
        Object objAdmin = ObjectHelper.Create((String)sysAdminFunc.getADMINOBJECT());
        if (objAdmin == null) {
            customActionResult.setRetCode(1);
            customActionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u7cfb\u7edf\u7ba1\u7406\u5bf9\u8c61[%1$s]", (Object)sysAdminFunc.getADMINOBJECT()));
            this.getPage().PageLog((Object)this, 1, customActionResult.getErrorInfo());
            this.getPage().Output(customActionResult.ToJSONString());
            return true;
        }
        if (!(objAdmin instanceof IDASystemAdmin)) {
            customActionResult.setRetCode(1);
            customActionResult.setErrorInfo(StringHelper.Format((String)"\u7cfb\u7edf\u7ba1\u7406\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)sysAdminFunc.getADMINOBJECT()));
            this.getPage().PageLog((Object)this, 1, customActionResult.getErrorInfo());
            this.getPage().Output(customActionResult.ToJSONString());
            return true;
        }
        IDASystemAdmin iDASystemAdmin = (IDASystemAdmin)objAdmin;
        iDASystemAdmin.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
        if (!iDASystemAdmin.isContainsFunc(sysAdminFunc.getFUNCID())) {
            customActionResult.setRetCode(1);
            customActionResult.setErrorInfo(StringHelper.Format((String)"\u7cfb\u7edf\u7ba1\u7406\u5bf9\u8c61[%1$s]\u4e0d\u652f\u6301\u529f\u80fd[%2$s]", (Object)sysAdminFunc.getADMINOBJECT(), (Object)sysAdminFunc.getFUNCID()));
            this.getPage().PageLog((Object)this, 1, customActionResult.getErrorInfo());
            this.getPage().Output(customActionResult.ToJSONString());
            return true;
        }
        if (iDASystemAdmin.isFuncScript(sysAdminFunc.getFUNCID())) {
            callResult = iDASystemAdmin.GetFuncScript(sysAdminFunc.getFUNCID());
            if (callResult.IsError()) {
                customActionResult.setRetCode(1);
                customActionResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884c\u7cfb\u7edf\u7ba1\u7406\u5bf9\u8c61[%1$s]\u529f\u80fd[%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)sysAdminFunc.getADMINOBJECT(), (Object)sysAdminFunc.getFUNCID(), (Object)callResult.getErrorInfo()));
                this.getPage().PageLog((Object)this, 1, customActionResult.getErrorInfo());
                this.getPage().Output(customActionResult.ToJSONString());
                return true;
            }
            if (callResult.getUserObject() != null) {
                customActionResult.setJSCode(callResult.getUserObject().toString());
            }
        } else {
            callResult = iDASystemAdmin.CallFunc(sysAdminFunc.getFUNCID(), sysAdminFunc.getPARAM());
            if (callResult.IsError()) {
                customActionResult.setRetCode(1);
                customActionResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884c\u7cfb\u7edf\u7ba1\u7406\u5bf9\u8c61[%1$s]\u529f\u80fd[%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)sysAdminFunc.getADMINOBJECT(), (Object)sysAdminFunc.getFUNCID(), (Object)callResult.getErrorInfo()));
                this.getPage().PageLog((Object)this, 1, customActionResult.getErrorInfo());
                this.getPage().Output(customActionResult.ToJSONString());
                return true;
            }
            if (callResult.getUserObject() != null) {
                customActionResult.setJSCode(StringHelper.Format((String)"alert('%1$s');", (Object)callResult.getUserObject()));
            }
        }
        customActionResult.setRetCode(0);
        this.getPage().Output(customActionResult.ToJSONString());
        return true;
    }
}

