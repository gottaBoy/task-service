/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WF.Ctrl.DEDataCtrl.PP;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.WF.Ctrl.Data.PP.PPWFWorkTreeBar;
import SA.SRFDA.WF.Ctrl.Data.PP.PPWFWorkTreeNode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PPWFWorkTreeBarDataCtrl
extends BaseDEDataCtrl {
    private static final Log log = LogFactory.getLog(PPWFWorkTreeBarDataCtrl.class);

    protected CallResult OnFillDetails(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        if (!(dataEntity instanceof PPWFWorkTreeBar)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u4f20\u5165\u6570\u636e\u5bf9\u8c61\u7c7b\u578b\u65e0\u6548\uff0c\u5fc5\u987b\u4e3a[%1$s]", (Object)dataEntity.getClass().getName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        PPWFWorkTreeBar ppWFWorkTreeBar = (PPWFWorkTreeBar)dataEntity;
        Vector<PPWFWorkTreeNode> ppWFWorkTreeNodes = new Vector<PPWFWorkTreeNode>();
        String strSQL = StringHelper.Format((String)"Select * from T_SRFPPWFWorkTreeNode where PPWFWORKTREEBARID='%1$s' ", (Object)ppWFWorkTreeBar.getPPWFWORKTREEBARID());
        callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.globalHelperEx, (String)this.GetDEHelper().GetDBStorage(), (String)strSQL, ppWFWorkTreeNodes, (String)PPWFWorkTreeNode.class.getName());
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5de5\u4f5c\u6d41\u5de5\u4f5c\u6811\u8282\u70b9\u5b9a\u4e49\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        ppWFWorkTreeBar.setPPWFWorkTreeNodes(ppWFWorkTreeNodes);
        return super.OnFillDetails(strActionMode, dataEntity);
    }
}

