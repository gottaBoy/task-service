/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.PP.PPNFView
 *  SA.SRFDA.Ctrl.Data.PP.PPNFViewPage
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEDataCtrl.PP;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.PP.PPNFView;
import SA.SRFDA.Ctrl.Data.PP.PPNFViewPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PPNFViewDataCtrl
extends BaseDEDataCtrl {
    private static final Log log = LogFactory.getLog(PPNFViewDataCtrl.class);

    protected CallResult OnFillDetails(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        if (!(dataEntity instanceof PPNFView)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u4f20\u5165\u6570\u636e\u5bf9\u8c61\u7c7b\u578b\u65e0\u6548\uff0c\u5fc5\u987b\u4e3a[%1$s]", (Object)dataEntity.getClass().getName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        PPNFView ppNFView = (PPNFView)dataEntity;
        Vector ppNFViewPages = new Vector();
        String strSQL = StringHelper.Format((String)"Select * from V_SRFPPNFVIEWPAGE where PPNFVIEWID='%1$s' ORDER BY ORDERFLAG", (Object)ppNFView.getPPNFVIEWID());
        callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.globalHelperEx, (String)this.GetDEHelper().GetDBStorage(), (String)strSQL, ppNFViewPages, (String)PPNFViewPage.class.getName());
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5bfc\u822a\u754c\u9762\u5206\u9875\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        ppNFView.setPPNFViewPages(ppNFViewPages);
        return super.OnFillDetails(strActionMode, dataEntity);
    }
}

