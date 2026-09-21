/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.Ctrl.Data.PageParamFolder;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PageParamFolderGlobalModel
extends BaseDAGlobalModel {
    protected IDEDataCtrl pageParamFolderDataCtrl = null;
    private static final Log log = LogFactory.getLog(PageParamFolderGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        this.nRenewTimer = this.iDAGlobalHelper.getWebExConfig().GetValue("SRFDA", "PAGEPARAMFOLDERRENEWTIMER", this.nRenewTimer);
        if (this.nRenewTimer < 5000) {
            this.nRenewTimer = 5000;
        }
        if (this.iDAGlobalHelper.getDAModelVersion() >= 11052400) {
            this.pageParamFolderDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0059", "SYSTEM", null);
            if (this.pageParamFolderDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0059"));
                return callResult;
            }
        } else {
            log.warn((Object)StringHelper.Format((String)"\u6a21\u578b\u7248\u672c[%1$s]\u4e0d\u80fd\u6ee1\u8db3\u754c\u9762\u53c2\u6570\u5bf9\u8c61\u5168\u5c40\u5bf9\u8c61\u52a0\u8f7d\u8981\u6c42", (Object)this.iDAGlobalHelper.getDAModelVersion()));
        }
        return callResult;
    }

    protected Object GetObject(Object objObjectId) {
        if (this.pageParamFolderDataCtrl == null) {
            return null;
        }
        PageParamFolder pageParamFolder = new PageParamFolder();
        pageParamFolder.setPAGEPARAMFOLDERID((String)objObjectId);
        CallResult callResult = this.pageParamFolderDataCtrl.Get(pageParamFolder);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u53c2\u6570\u5bf9\u8c61[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return pageParamFolder;
    }

    protected Boolean TestObjectRenew(Object obj) {
        return false;
    }
}

