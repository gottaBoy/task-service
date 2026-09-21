/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DataEntity
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IGlobalObject
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.IS.Ctrl;

import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IGlobalObject;
import SA.SRFDA.IS.Ctrl.Data.ISType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ISTypeManager
implements IGlobalObject {
    protected ISRFDAGlobalHelper iGlobalHelper = null;
    protected TreeMap<String, ISType> isTypeMap = new TreeMap();
    private static Log log = LogFactory.getLog(ISTypeManager.class);

    public CallResult Init(ISRFDAGlobalHelper iGlobalHelper) {
        this.iGlobalHelper = iGlobalHelper;
        CallResult callResult = this.Reload();
        return callResult;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public CallResult Reload() {
        CallResult callResult = new CallResult();
        IDEDataCtrl isTypeDataCtrl = this.iGlobalHelper.getDAModelStorage().FindDEDataCtrl("IS0002", "SYSTEM", null);
        if (isTypeDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)"IS0002"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        Vector list = new Vector();
        callResult = isTypeDataCtrl.Select((BaseDataEntity)new DataEntity(), list, ISType.class.getName());
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u7d22\u5f15\u6570\u636e\u6e90\u7c7b\u578b\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        TreeMap<String, ISType> treeMap = this.isTypeMap;
        synchronized (treeMap) {
            this.isTypeMap.clear();
            for (ISType isType : list) {
                this.isTypeMap.put(isType.getISTYPEID().toUpperCase(), isType);
            }
        }
        return callResult;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ISType FindISType(String strTypeId) {
        strTypeId = strTypeId.toUpperCase();
        TreeMap<String, ISType> treeMap = this.isTypeMap;
        synchronized (treeMap) {
            if (this.isTypeMap.containsKey(strTypeId)) {
                return this.isTypeMap.get(strTypeId);
            }
        }
        IDEDataCtrl isTypeDataCtrl = this.iGlobalHelper.getDAModelStorage().FindDEDataCtrl("IS0002", "SYSTEM", null);
        if (isTypeDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)"IS0002"));
            return null;
        }
        ISType isType = new ISType();
        isType.setISTYPEID(strTypeId);
        CallResult callResult = isTypeDataCtrl.Get((BaseDataEntity)isType);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u7d22\u5f15\u6570\u636e\u7c7b\u578b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        TreeMap<String, ISType> treeMap2 = this.isTypeMap;
        synchronized (treeMap2) {
            this.isTypeMap.put(isType.getISTYPEID().toUpperCase(), isType);
        }
        return isType;
    }
}

