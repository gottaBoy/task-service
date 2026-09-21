/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseService
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper
 *  SRFTS.Ctrl.SRFTSEngine
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.TS.Ctrl;

import SA.SRFDA.Ctrl.BaseService;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;
import SRFTS.Ctrl.SRFTSEngine;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TSService
extends BaseService {
    private SRFTSEngine tsEngine = null;
    private static Log log = LogFactory.getLog(TSService.class);

    protected CallResult OnStart() {
        CallResult callResult = super.OnStart();
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.tsEngine = new SRFTSEngine((ISRFExGlobalHelper)this.iDAGlobalHelper, this.iDAGlobalHelper.getDBCallerEx());
        }
        catch (Exception e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.toString());
            return callResult;
        }
        log.info((Object)StringHelper.Format((String)"TaskEngine Start"));
        return callResult;
    }

    protected CallResult OnStop() {
        this.tsEngine.Close();
        this.tsEngine = null;
        log.info((Object)StringHelper.Format((String)"TaskEngine Stop"));
        return super.OnStop();
    }
}

