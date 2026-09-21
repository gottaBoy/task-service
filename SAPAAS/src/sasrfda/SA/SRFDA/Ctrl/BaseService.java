/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.Service;
import SA.SRFDA.Ctrl.IService;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;
import java.util.TimerTask;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseService
extends TimerTask
implements IService {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected Service service = null;
    protected boolean bStart = false;
    protected Properties serviceParams = null;
    private static final Log log = LogFactory.getLog(BaseService.class);
    private boolean bRunFlag = false;

    @Override
    public CallResult Init(Service service, ISRFDAGlobalHelper iDAGlobalHelper) {
        this.service = service;
        this.iDAGlobalHelper = iDAGlobalHelper;
        try {
            if (!StringHelper.IsNullOrEmpty((String)service.getSERVICEPARAM())) {
                this.serviceParams = PropertiesHelper.Load((String)service.getSERVICEPARAM());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.Format((String)"\u52a0\u8f7d\u5b9e\u4f53\u914d\u7f6e\u53c2\u6570\u53d1\u751f\u9519\u8bef"), (Throwable)e);
        }
        return this.OnInit();
    }

    protected ISRFDAGlobalHelper getGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    protected CallResult OnInit() {
        return new CallResult();
    }

    @Override
    public CallResult Start() {
        if (this.bStart) {
            return new CallResult();
        }
        CallResult callResult = this.OnStart();
        if (callResult.IsOk()) {
            this.bStart = true;
        }
        return callResult;
    }

    protected CallResult OnStart() {
        return new CallResult();
    }

    @Override
    public CallResult Stop() {
        if (!this.bStart) {
            return new CallResult();
        }
        CallResult callResult = this.OnStop();
        if (callResult.IsOk()) {
            this.bStart = false;
        }
        return callResult;
    }

    protected CallResult OnStop() {
        return new CallResult();
    }

    @Override
    public boolean IsStart() {
        return this.bStart;
    }

    @Override
    public String getServiceId() {
        return this.service.getSERVICEID();
    }

    @Override
    public CallResult Quit() {
        return this.OnQuit();
    }

    protected CallResult OnQuit() {
        this.Stop();
        return new CallResult();
    }

    protected String GetServiceParam(String strPropertyName) {
        strPropertyName = strPropertyName.toUpperCase();
        String strDefaultValue = "";
        return PropertiesHelper.GetProperty((Properties)this.serviceParams, (String)strPropertyName, (String)strDefaultValue);
    }

    protected String GetServiceParam(String strPropertyName, String strDefaultValue) {
        strPropertyName = strPropertyName.toUpperCase();
        return PropertiesHelper.GetProperty((Properties)this.serviceParams, (String)strPropertyName, (String)strDefaultValue);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        BaseService baseService = this;
        synchronized (baseService) {
            if (this.bRunFlag) {
                return;
            }
            this.bRunFlag = true;
        }
        try {
            this.OnRun();
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u670d\u52a1[%1$s]\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.getServiceId(), (Object)ex.getMessage()), (Throwable)ex);
        }
        baseService = this;
        synchronized (baseService) {
            this.bRunFlag = false;
        }
    }

    protected void OnRun() throws Exception {
    }
}

