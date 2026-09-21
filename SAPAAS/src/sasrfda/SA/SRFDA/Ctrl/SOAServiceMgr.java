/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.ISOAServiceDataCtrl;
import SA.SRFDA.Ctrl.DEDataCtrl.IServiceDataCtrl;
import SA.SRFDA.Ctrl.Data.SOAService;
import SA.SRFDA.Ctrl.Data.Service;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IService;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SOAServiceMgr {
    private ISRFDAGlobalHelper iDAGlobalHelper = null;
    private static Log log = LogFactory.getLog(SOAServiceMgr.class);
    protected TreeMap<String, IService> serviceMap = new TreeMap();
    protected ISOAServiceDataCtrl iServiceDataCtrl = null;

    public SOAServiceMgr(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        IDEDataCtrl iDataCtrl = iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0163", "SYSTEM", null);
        if (iDataCtrl == null || !(iDataCtrl instanceof IServiceDataCtrl)) {
            throw new Exception("\u65e0\u6548\u7684\u670d\u52a1\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
        }
        this.iServiceDataCtrl = (ISOAServiceDataCtrl)iDataCtrl;
    }

    public void Start() throws Exception {
        Vector<SOAService> services = new Vector<SOAService>();
        CallResult callResult = this.iServiceDataCtrl.SelectAutoStartService(services);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"SOA\u670d\u52a1\u7ba1\u7406\u5668\u67e5\u8be2\u81ea\u52a8\u542f\u52a8\u670d\u52a1\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        for (SOAService sOAService : services) {
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

    public boolean isContainsService(String strSOAServiceId) {
        return false;
    }

    public boolean CheckClientAddress(String strSOAServiceId, String strClientAddress) {
        return true;
    }

    public CallResult Call(String strSOAServiceId, BaseDataEntity dataEntity) {
        return new CallResult();
    }
}

