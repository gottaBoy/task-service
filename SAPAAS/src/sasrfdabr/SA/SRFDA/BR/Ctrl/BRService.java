/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseService
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.BR.Ctrl;

import SA.SRFDA.BR.Ctrl.BREngineMgr;
import SA.SRFDA.Ctrl.BaseService;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BRService
extends BaseService {
    private BREngineMgr brEngineMgr = null;
    private static Log log = LogFactory.getLog(BRService.class);
    public static final String BRSERVICECONTEXT = "{F8A3DF77-41FF-4789-BDA1-63C7FD37783D}";

    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        this.brEngineMgr = new BREngineMgr();
        this.brEngineMgr.Init(this.iDAGlobalHelper);
        this.iDAGlobalHelper.SetGlobalValue(BRSERVICECONTEXT, (Object)this.brEngineMgr);
        return callResult;
    }

    protected CallResult OnStart() {
        CallResult callResult = super.OnStart();
        if (callResult.IsError()) {
            return callResult;
        }
        log.info((Object)StringHelper.Format((String)"\u89c4\u5219\u5f15\u64ce\u542f\u52a8\u6210\u529f"));
        return this.brEngineMgr.Start();
    }

    protected CallResult OnStop() {
        this.brEngineMgr.Stop();
        log.info((Object)StringHelper.Format((String)"\u89c4\u5219\u5f15\u64ce\u505c\u6b62\u6210\u529f"));
        return super.OnStop();
    }
}

