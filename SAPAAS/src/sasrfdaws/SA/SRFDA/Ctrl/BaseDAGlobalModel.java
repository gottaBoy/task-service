/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.IDAGlobalModel;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Date;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseDAGlobalModel<KT, VT, HT>
implements IDAGlobalModel<KT, VT, HT> {
    private static final Log log = LogFactory.getLog(BaseDAGlobalModel.class);
    protected Hashtable<KT, Long> objRenewMap = new Hashtable();
    protected Hashtable<KT, VT> objMap = new Hashtable();
    protected Hashtable<KT, HT> objHelperMap = new Hashtable();
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected int nRenewTimer = 5000;

    @Override
    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper) {
        try {
            this.iDAGlobalHelper = iDAGlobalHelper;
            return this.OnInit();
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult OnInit() {
        return new CallResult();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public VT FindModel(KT objObjectId) {
        VT obj = null;
        Long curTime = new Date().getTime();
        Hashtable<KT, VT> hashtable = this.objMap;
        synchronized (hashtable) {
            if (this.objMap.containsKey(objObjectId)) {
                obj = this.objMap.get(objObjectId);
                if (curTime - this.objRenewMap.get(objObjectId) < (long)this.nRenewTimer) {
                    return obj;
                }
            }
        }
        if (obj != null && !this.TestObjectRenew(obj).booleanValue()) {
            hashtable = this.objMap;
            synchronized (hashtable) {
                this.objRenewMap.put(objObjectId, curTime);
            }
            return obj;
        }
        obj = this.GetObject(objObjectId);
        if (obj == null) {
            return null;
        }
        hashtable = this.objMap;
        synchronized (hashtable) {
            this.objMap.put(objObjectId, obj);
            this.objRenewMap.put(objObjectId, curTime);
            this.objHelperMap.remove(objObjectId);
        }
        return obj;
    }

    protected Boolean TestObjectRenew(VT obj) {
        return true;
    }

    protected abstract VT GetObject(KT var1);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void ResetModel(KT objObjectId) {
        Hashtable<KT, VT> hashtable = this.objMap;
        synchronized (hashtable) {
            this.objMap.remove(objObjectId);
            this.objRenewMap.remove(objObjectId);
            this.objHelperMap.remove(objObjectId);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void ResetAll() {
        Hashtable<KT, VT> hashtable = this.objMap;
        synchronized (hashtable) {
            this.objMap.clear();
            this.objRenewMap.clear();
            this.objHelperMap.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public HT FindModelHelper(KT objObjectId) throws Exception {
        VT vt = this.FindModel(objObjectId);
        if (vt == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b[%1$s]", objObjectId));
        }
        Hashtable<KT, VT> hashtable = this.objMap;
        synchronized (hashtable) {
            if (this.objHelperMap.containsKey(objObjectId)) {
                return this.objHelperMap.get(objObjectId);
            }
        }
        HT ht = this.OnCreateModelHelper(vt);
        if (ht == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u6a21\u578b[%1$s]\u8f85\u52a9\u5bf9\u8c61", objObjectId));
        }
        Hashtable<KT, VT> hashtable2 = this.objMap;
        synchronized (hashtable2) {
            this.objHelperMap.put(objObjectId, ht);
        }
        return ht;
    }

    protected HT OnCreateModelHelper(VT vt) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u5efa\u7acb\u6a21\u578b\u65b9\u6cd5");
    }
}

