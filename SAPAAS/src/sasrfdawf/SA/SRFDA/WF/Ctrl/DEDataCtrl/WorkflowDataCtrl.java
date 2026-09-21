/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SRFWF.Ctrl.Data.WFWFVersion
 *  SRFWF.Ctrl.Data.WFWorkflow
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WF.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SRFWF.Ctrl.Data.WFWFVersion;
import SRFWF.Ctrl.Data.WFWorkflow;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WorkflowDataCtrl
extends BaseDEDataCtrl {
    private static final Log log = LogFactory.getLog(WorkflowDataCtrl.class);

    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        if (this.globalHelperEx.getDAModelVersion() >= 11121900) {
            IDEDataCtrl wfVersionDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrlEx("WF0020", (IDEDataCtrl)this);
            if (wfVersionDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"WF0020"));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            WFWorkflow workflow = new WFWorkflow();
            workflow.Proxy(dataEntity);
            WFWFVersion wfVersion = new WFWFVersion();
            wfVersion.setWFWFVERSIONNAME(workflow.getWFNAME());
            wfVersion.setWFWFID(workflow.getWFWORKFLOWID());
            wfVersion.setWFMODEL(workflow.getWFMODEL());
            wfVersion.setWFVERSION(workflow.getWFVERSION());
            callResult = wfVersionDataCtrl.Save(true, (BaseDataEntity)wfVersion);
        }
        return callResult;
    }
}

