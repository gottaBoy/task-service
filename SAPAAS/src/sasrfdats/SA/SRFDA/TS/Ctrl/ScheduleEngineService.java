/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseService
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.TS.Ctrl;

import SA.SRFDA.Ctrl.BaseService;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.TS.Ctrl.Data.TSSDEngine;
import SA.SRFDA.TS.Ctrl.IScheduleEngine;
import SA.SRFDA.TS.Ctrl.ScheduleEngine;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ScheduleEngineService
extends BaseService {
    private static Log log = LogFactory.getLog(ScheduleEngineService.class);
    protected IScheduleEngine iScheduleEngine = null;
    protected String strScheduleEngineId = "";

    protected CallResult OnInit() {
        Object objEngine;
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        this.strScheduleEngineId = this.GetServiceParam("SCHEDULEENGINEID", "");
        if (StringHelper.IsNullOrEmpty((String)this.strScheduleEngineId)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u8c03\u5ea6\u5f15\u64ce\u7f16\u53f7"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IDEDataCtrl iDEDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("TS0024", "SYSTEM", null);
        if (iDEDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"TS0024"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        TSSDEngine tsSDEngine = new TSSDEngine();
        tsSDEngine.setTSSDENGINEID(this.strScheduleEngineId);
        callResult = iDEDataCtrl.Get((BaseDataEntity)tsSDEngine);
        if (callResult.IsError()) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u8c03\u5ea6\u5f15\u64ce[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.strScheduleEngineId, (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strEngineObject = tsSDEngine.getENGINEOBJECT();
        if (StringHelper.IsNullOrEmpty((String)strEngineObject)) {
            strEngineObject = ScheduleEngine.class.getName();
        }
        if ((objEngine = ObjectHelper.Create((String)strEngineObject)) == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u8c03\u5ea6\u5f15\u64ce[%1$s]", (Object)strEngineObject));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        if (!(objEngine instanceof IScheduleEngine)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u8c03\u5ea6\u5f15\u64ce\u5bf9\u8c61[%1$s]\u4e0d\u6b63\u786e", (Object)strEngineObject));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        this.iScheduleEngine = (IScheduleEngine)objEngine;
        return this.iScheduleEngine.Init(this.iDAGlobalHelper, tsSDEngine);
    }

    protected CallResult OnStart() {
        CallResult callResult = super.OnStart();
        if (callResult.IsError()) {
            return callResult;
        }
        callResult = this.iScheduleEngine.Start();
        log.info((Object)StringHelper.Format((String)"\u4efb\u52a1\u8c03\u5ea6\u5f15\u64ce[%1$s]\u542f\u52a8", (Object)this.strScheduleEngineId));
        return callResult;
    }

    protected CallResult OnStop() {
        log.info((Object)StringHelper.Format((String)"\u4efb\u52a1\u8c03\u5ea6\u5f15\u64ce[%1$s]\u505c\u6b62", (Object)this.strScheduleEngineId));
        this.iScheduleEngine.Stop();
        return super.OnStop();
    }
}

