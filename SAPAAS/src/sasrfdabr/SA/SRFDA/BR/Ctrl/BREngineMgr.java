/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.BR.Ctrl;

import SA.SRFDA.BR.Ctrl.Data.BREngine;
import SA.SRFDA.BR.Ctrl.DefaultBREngine;
import SA.SRFDA.BR.Ctrl.ISRFBREngine;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BREngineMgr {
    protected HashMap<String, ISRFBREngine> brEngineMap = new HashMap();
    protected IDEDataCtrl brEngineDataCtrl = null;
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    private static final Log log = LogFactory.getLog(BREngineMgr.class);
    public static final String MGRACTION_RESETBRENGINE = "RESETBRENGINE";

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper) {
        CallResult callResult = new CallResult();
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.brEngineDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("BR0001", "SYSTEM", null);
        if (this.brEngineDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"BR0001"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        return callResult;
    }

    public CallResult Start() {
        return new CallResult();
    }

    public CallResult Execute(String strEngineId, String strInstData, String strAction, BaseDataEntity dataEntity, String strOPPersonId) {
        ISRFBREngine brEngine = this.GetBREngine(strEngineId);
        if (brEngine == null) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u89c4\u5219\u5f15\u64ce[%1$s]\u5bf9\u8c61", (Object)strEngineId));
            return callResult;
        }
        return brEngine.Execute(strInstData, strAction, dataEntity, strOPPersonId);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public CallResult Manage(String strEngineId, String strAction, BaseDataEntity dataEntity, String strOPPersonId) {
        CallResult callResult = new CallResult();
        ISRFBREngine brEngine = this.GetBREngine(strEngineId);
        if (brEngine == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u89c4\u5219\u5f15\u64ce[%1$s]\u5bf9\u8c61", (Object)strEngineId));
            return callResult;
        }
        if (StringHelper.Compare((String)MGRACTION_RESETBRENGINE, (String)strAction, (boolean)true) == 0) {
            HashMap<String, ISRFBREngine> hashMap = this.brEngineMap;
            synchronized (hashMap) {
                brEngine = this.brEngineMap.remove(strEngineId);
            }
            if (brEngine != null) {
                brEngine.Quit();
            }
            return callResult;
        }
        return brEngine.Manage(strAction, dataEntity, strOPPersonId);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void Stop() {
        HashMap<String, ISRFBREngine> hashMap = this.brEngineMap;
        synchronized (hashMap) {
            for (ISRFBREngine brEngine : this.brEngineMap.values()) {
                brEngine.Quit();
            }
            this.brEngineMap.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected ISRFBREngine GetBREngine(String strEngineId) {
        Object objEngine;
        HashMap<String, ISRFBREngine> hashMap = this.brEngineMap;
        synchronized (hashMap) {
            if (this.brEngineMap.containsKey(strEngineId)) {
                return this.brEngineMap.get(strEngineId);
            }
        }
        BREngine brEngine = new BREngine();
        brEngine.setBRENGINEID(strEngineId);
        CallResult callResult = this.brEngineDataCtrl.Get((BaseDataEntity)brEngine);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u89c4\u5219\u5f15\u64ce[%1$s]\u914d\u7f6e\uff0c%2$s", (Object)strEngineId, (Object)callResult.getErrorInfo()));
            return null;
        }
        String strEngineObject = brEngine.getENGINEOBJECT();
        if (StringHelper.IsNullOrEmpty((String)strEngineObject)) {
            strEngineObject = DefaultBREngine.class.getName();
        }
        if ((objEngine = ObjectHelper.Create((String)strEngineObject)) == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u89c4\u5219\u5f15\u64ce\u5bf9\u8c61[%1$s]", (Object)strEngineObject));
            return null;
        }
        if (!(objEngine instanceof ISRFBREngine)) {
            log.error((Object)StringHelper.Format((String)"\u89c4\u5219\u5f15\u64ce\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strEngineObject));
            return null;
        }
        ISRFBREngine iBREngine = (ISRFBREngine)objEngine;
        iBREngine.Init(this.iDAGlobalHelper, brEngine);
        HashMap<String, ISRFBREngine> hashMap2 = this.brEngineMap;
        synchronized (hashMap2) {
            this.brEngineMap.put(strEngineId, iBREngine);
        }
        return iBREngine;
    }
}

