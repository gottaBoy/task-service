/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.IServiceDataCtrl;
import SA.SRFDA.Ctrl.Data.Service;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IService;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServiceMgr {
    private ISRFDAGlobalHelper iDAGlobalHelper = null;
    private String strContainer = "";
    private static Log log = LogFactory.getLog(ServiceMgr.class);
    private IServiceDataCtrl iServiceDataCtrl = null;
    protected TreeMap<String, IService> serviceMap = new TreeMap();

    public ServiceMgr(ISRFDAGlobalHelper iDAGlobalHelper, String strContainer) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.strContainer = strContainer;
        IDEDataCtrl iDataCtrl = iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0152", "SYSTEM", null);
        if (iDataCtrl == null || !(iDataCtrl instanceof IServiceDataCtrl)) {
            throw new Exception("\u65e0\u6548\u7684\u670d\u52a1\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
        }
        this.iServiceDataCtrl = (IServiceDataCtrl)iDataCtrl;
    }

    public void Start() throws Exception {
        Vector<Service> services = new Vector<Service>();
        CallResult callResult = this.iServiceDataCtrl.SelectAutoStartService(this.strContainer, services);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u670d\u52a1\u7ba1\u7406\u5668\u67e5\u8be2\u81ea\u52a8\u542f\u52a8\u670d\u52a1\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        for (Service service : services) {
            try {
                callResult = this.InternalStartService(service);
                if (!callResult.IsOk()) continue;
                IService iService = (IService)callResult.getUserObject();
                this.serviceMap.put(iService.getServiceId(), iService);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u670d\u52a1[%1$s:%2$s]\u542f\u52a8\u53d1\u751f\u5f02\u5e38\u5931\u8d25\uff0c%3$s", (Object)service.getSERVICEID(), (Object)service.getSERVICENAME(), (Object)ex.getMessage()));
            }
        }
    }

    protected CallResult InternalStartService(Service service) {
        CallResult callResult = new CallResult();
        String strServiceObject = service.getSERVICEOBJECT();
        Object objService = ObjectHelper.Create((String)strServiceObject);
        if (objService == null || !(objService instanceof IService)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u670d\u52a1[%1$s:%2$s]\u5bf9\u8c61[%3$s]\u65e0\u6548", (Object)service.getSERVICEID(), (Object)service.getSERVICENAME(), (Object)service.getSERVICEOBJECT()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IService iService = (IService)objService;
        callResult = iService.Init(service, this.iDAGlobalHelper);
        if (callResult.IsError()) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u670d\u52a1[%1$s:%2$s]\u521d\u59cb\u5316\u5931\u8d25\uff0c%3$s", (Object)service.getSERVICEID(), (Object)service.getSERVICENAME(), (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = iService.Start();
        if (callResult.IsError()) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u670d\u52a1[%1$s:%2$s]\u542f\u52a8\u5931\u8d25\uff0c%3$s", (Object)service.getSERVICEID(), (Object)service.getSERVICENAME(), (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = this.iServiceDataCtrl.MarkServiceStart(service.getSERVICEID());
        if (callResult.IsError()) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u670d\u52a1[%1$s:%2$s]\u6807\u8bb0\u670d\u52a1\u542f\u52a8\u5931\u8d25\uff0c%3$s", (Object)service.getSERVICEID(), (Object)service.getSERVICENAME(), (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult.Reset();
        callResult.setUserObject((Object)iService);
        return callResult;
    }

    public void Stop() {
        for (IService iService : this.serviceMap.values()) {
            this.iServiceDataCtrl.MarkServiceStop(iService.getServiceId());
            iService.Stop();
            iService.Quit();
        }
        this.serviceMap.clear();
    }

    public CallResult StartService(String strServiceId) {
        CallResult callResult = new CallResult();
        if (this.FindStartService(strServiceId) != null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u670d\u52a1\u5df2\u7ecf\u542f\u52a8\uff0c\u65e0\u6cd5\u518d\u6b21\u542f\u52a8"));
            return callResult;
        }
        Service service = new Service();
        service.setSERVICEID(strServiceId);
        callResult = this.iServiceDataCtrl.Get(service);
        if (callResult.IsError()) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u542f\u52a8\u670d\u52a1[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strServiceId, (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = this.InternalStartService(service);
        if (callResult.IsError()) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u542f\u52a8\u670d\u52a1[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strServiceId, (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IService iService = (IService)callResult.getUserObject();
        this.serviceMap.put(iService.getServiceId(), iService);
        callResult.Reset();
        return callResult;
    }

    public CallResult StopService(String strServiceId) {
        CallResult callResult = new CallResult();
        IService iService = this.FindStartService(strServiceId);
        if (iService == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u670d\u52a1\u6ca1\u6709\u542f\u52a8\uff0c\u65e0\u6cd5\u5173\u95ed"));
            return callResult;
        }
        iService.Stop();
        iService.Quit();
        this.iServiceDataCtrl.MarkServiceStop(iService.getServiceId());
        this.serviceMap.remove(iService.getServiceId());
        callResult.Reset();
        return callResult;
    }

    public synchronized IService FindStartService(String strServiceId) {
        return this.serviceMap.get(strServiceId);
    }
}

