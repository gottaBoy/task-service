/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.IPSModelInit;
import SA.SRFDA.PS.Core.IPSModelInitStep;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSModelInitDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSSysDBChgLog;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSModelDEDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSModelDEDataCtrl.class);
    public static final String CUSTOMCALL_INITMODEL = "INITMODEL";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITMODEL, (boolean)true) == 0) {
            return this.initModel(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult initModel(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.onInitModel(dataEntity);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            if (bInsert) {
                this.onInitModel(dataEntity);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            callResult.setRetCode(0);
        }
        return callResult;
    }

    protected void onInitModel(BaseDataEntity dataEntity) throws Exception {
        IPSModelInit iPSModelInit = this.getPSModelStorage().getPSModelInit(this.GetDEHelper().getId(), true);
        if (iPSModelInit == null) {
            return;
        }
        Iterator<IPSModelInitStep> psModelInitSteps = iPSModelInit.getModelInitSteps();
        while (psModelInitSteps.hasNext()) {
            IPSModelInitStep iPSModelInitStep = psModelInitSteps.next();
            IDEDataCtrl initDEDataCtrl = this.GetRelatedDataCtrl(iPSModelInitStep.getInitDEId());
            if (!(initDEDataCtrl instanceof IPSModelInitDataCtrl)) {
                throw new Exception(StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)iPSModelInitStep.getInitDEId()));
            }
            IPSModelInitDataCtrl iPSModelInitDataCtrl = (IPSModelInitDataCtrl)initDEDataCtrl;
            CallResult callResult = iPSModelInitDataCtrl.initModel(this.GetDEHelper().getId(), dataEntity, iPSModelInitStep.getInitAction());
            if (!callResult.isError()) continue;
            throw new Exception(StringHelper.Format((String)"\u6a21\u578b\u521d\u59cb\u5316[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)iPSModelInitStep.getName(), (Object)callResult.getErrorInfo()));
        }
    }

    protected void logPSModelChg(String strAction, BaseDataEntity dataEntity, String strLogInfo) throws Exception {
        PSSysDBChgLog psSysDBChgLog = new PSSysDBChgLog();
    }
}

