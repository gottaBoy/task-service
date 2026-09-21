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

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCStartProcessConfig;
import SA.SRFDA.Ctrl.Data.DEDCProcType;
import SA.SRFDA.Ctrl.IDEDCProcess;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEDCProcessStorage {
    private Hashtable<String, IDEDCProcess> procMap = new Hashtable();
    private Hashtable<String, IDEDCProcess> procMap2 = new Hashtable();
    private static final Log log = LogFactory.getLog(DEDCProcessStorage.class);

    public CallResult Init(ISRFDAGlobalHelper daGlobalHelper) {
        Vector<DEDCProcType> list = new Vector<DEDCProcType>();
        CallResult callResult = daGlobalHelper.getDAModelHelper().GetDEDCProcTypes(list);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5904\u7406\u89c4\u5219\u7c7b\u578b\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        for (DEDCProcType procType : list) {
            Object objCtrl = ObjectHelper.Create((String)procType.getPROCESSOBJECT().trim());
            if (objCtrl == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5b9e\u4f53\u89c4\u5219\u5904\u7406\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c", (Object)procType.getPROCESSOBJECT().trim()));
                continue;
            }
            if (!(objCtrl instanceof IDEDCProcess)) {
                log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53\u89c4\u5219\u5904\u7406\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e\uff0c", (Object)procType.getPROCESSOBJECT().trim()));
                continue;
            }
            String strKey = StringHelper.Format((String)"%1$s:%2$s", (Object)"DEDCProcessConfig", (Object)procType.getPROCESSTYPE());
            this.procMap.put(strKey, (IDEDCProcess)objCtrl);
        }
        this.procMap.put("DEDCStartProcessConfig", (IDEDCProcess)ObjectHelper.Create((String)"SA.SRFDA.DEDC.Ctrl.DEDCStartProcess"));
        this.procMap.put("DEDCDecideProcessConfig", (IDEDCProcess)ObjectHelper.Create((String)"SA.SRFDA.DEDC.Ctrl.DEDCDecideProcess"));
        return callResult;
    }

    public IDEDCProcess FindDEDCProcess(DEDCBaseProcessConfig baseProcessConfig) {
        if (baseProcessConfig instanceof DEDCStartProcessConfig) {
            String strKey = StringHelper.Format((String)"%1$s", (Object)((Object)((Object)baseProcessConfig)).getClass().getSimpleName());
            return this.procMap.get(strKey);
        }
        if (baseProcessConfig instanceof DEDCProcessConfig) {
            String strKey = StringHelper.Format((String)"%1$s:%2$s", (Object)((Object)((Object)baseProcessConfig)).getClass().getSimpleName(), (Object)((DEDCProcessConfig)baseProcessConfig).getProcessType());
            return this.procMap.get(strKey);
        }
        String strKey = StringHelper.Format((String)"%1$s", (Object)((Object)((Object)baseProcessConfig)).getClass().getSimpleName());
        return this.procMap.get(strKey);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public IDEDCProcess FindDEDCProcess(String strProcessObject) {
        String strKey = StringHelper.Format((String)"CUSTOM:%1$s", (Object)strProcessObject);
        Hashtable<String, IDEDCProcess> hashtable = this.procMap2;
        synchronized (hashtable) {
            if (this.procMap2.containsKey(strKey)) {
                return this.procMap2.get(strKey);
            }
        }
        Object objCtrl = ObjectHelper.Create((String)strProcessObject);
        if (objCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5bf9\u8c61[%1$s]", (Object)strProcessObject));
            return null;
        }
        if (!(objCtrl instanceof IDEDCProcess)) {
            log.error((Object)StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strProcessObject));
            return null;
        }
        Hashtable<String, IDEDCProcess> hashtable2 = this.procMap2;
        synchronized (hashtable2) {
            this.procMap2.put(strKey, (IDEDCProcess)objCtrl);
        }
        return (IDEDCProcess)objCtrl;
    }
}

