/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDAGlobalModel
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.Ctrl.IDAGlobalModel;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSGlobalModelBaseBase<KT, VT, HT>
implements IDAGlobalModel<KT, VT, HT> {
    private static final Log log = LogFactory.getLog(PSGlobalModelBaseBase.class);
    protected HashMap<KT, Long> objRenewMap = new HashMap();
    protected HashMap<KT, VT> objMap = new HashMap();
    protected HashMap<KT, String> objEmptyMap = new HashMap();
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    private boolean bPreloadModels = true;
    private Object objPreloadModels = new Object();
    private boolean bClearGlobalModel = false;
    protected HashMap<KT, HT> objHelperMap = new HashMap();
    protected int nRenewTimer = 5000;
    protected boolean bEnableEmptyMap = false;
    protected boolean bEnableRenew = true;

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
    public VT FindModel(KT objObjectId) {
        this.preloadModels();
        if (objObjectId == null) {
            return null;
        }
        VT obj = null;
        HashMap<KT, VT> hashMap = this.objMap;
        synchronized (hashMap) {
            block15: {
                block14: {
                    obj = this.objMap.get(objObjectId);
                    if (obj != null) {
                        if (this.bEnableRenew && this.objRenewMap != null) {
                            long curTime = System.currentTimeMillis();
                            if (curTime - this.objRenewMap.get(objObjectId) < (long)this.nRenewTimer) {
                                return obj;
                            }
                            if (!this.TestObjectRenew(obj).booleanValue()) {
                                this.objRenewMap.put(objObjectId, curTime);
                                return obj;
                            }
                        } else {
                            return obj;
                        }
                    }
                    if (!this.bEnableEmptyMap || this.objEmptyMap == null || !this.objEmptyMap.containsKey(objObjectId)) break block14;
                    return null;
                }
                obj = this.GetObject(objObjectId);
                if (obj != null) break block15;
                if (this.bEnableEmptyMap && this.objEmptyMap != null) {
                    this.objEmptyMap.put(objObjectId, "");
                }
                return null;
            }
            this.objMap.put(objObjectId, obj);
            if (this.bEnableRenew && this.objRenewMap != null) {
                this.objRenewMap.put(objObjectId, System.currentTimeMillis());
            }
            this.objHelperMap.remove(objObjectId);
            if (this.bEnableEmptyMap && this.objEmptyMap != null) {
                this.objEmptyMap.remove(objObjectId);
            }
        }
        return obj;
    }

    protected void onPreloadModels() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void preloadModels() {
        Object object = this.getPreloadModelsLock();
        synchronized (object) {
            if (this.bPreloadModels) {
                this.bPreloadModels = false;
                this.onPreloadModels();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setPreloadModels(boolean bPreloadModels) {
        Object object = this.getPreloadModelsLock();
        synchronized (object) {
            this.bPreloadModels = bPreloadModels;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void setModel(KT kt, VT vt, HT ht) {
        HashMap<KT, VT> hashMap = this.objMap;
        synchronized (hashMap) {
            this.objMap.put(kt, vt);
            if (this.bEnableEmptyMap && this.objEmptyMap != null) {
                this.objEmptyMap.remove(kt);
            }
            if (this.bEnableRenew && this.objRenewMap != null) {
                this.objRenewMap.put(kt, System.currentTimeMillis());
            }
            if (ht == null) {
                this.objHelperMap.remove(kt);
            } else {
                this.objHelperMap.put(kt, ht);
            }
        }
    }

    protected Boolean TestObjectRenew(VT obj) {
        return true;
    }

    protected abstract VT GetObject(KT var1);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void ResetModel(KT objObjectId) {
        HashMap<KT, VT> hashMap = this.objMap;
        synchronized (hashMap) {
            HT ht;
            this.objMap.remove(objObjectId);
            if (this.bEnableRenew && this.objRenewMap != null) {
                this.objRenewMap.remove(objObjectId);
            }
            if ((ht = this.objHelperMap.remove(objObjectId)) != null) {
                this.onResetModelHelper(ht);
            }
            if (this.bEnableEmptyMap && this.objEmptyMap != null) {
                this.objEmptyMap.remove(objObjectId);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void ResetAll() {
        HashMap<KT, VT> hashMap = this.objMap;
        synchronized (hashMap) {
            this.bPreloadModels = true;
            this.objMap.clear();
            if (this.bEnableRenew && this.objRenewMap != null) {
                this.objRenewMap.clear();
            }
            for (Map.Entry<KT, HT> entry : this.objHelperMap.entrySet()) {
                if (entry.getValue() == null) continue;
                this.onResetModelHelper(entry.getValue());
            }
            this.objHelperMap.clear();
            if (this.bEnableEmptyMap && this.objEmptyMap != null) {
                this.objEmptyMap.clear();
            }
        }
    }

    public HT FindModelHelper(KT objObjectId) throws Exception {
        return this.FindModelHelper(objObjectId, (VT)false);
    }

    public Iterator<HT> GetModelHelpers() {
        return this.objHelperMap.values().iterator();
    }

    protected HT OnCreateModelHelper(VT vt, KT objObjectId) throws Exception {
        return this.OnCreateModelHelper(vt);
    }

    protected HT OnCreateModelHelper(VT vt) throws Exception {
        throw new Exception(StringHelper.Format((String)"[%1$s]\u6ca1\u6709\u5b9e\u73b0\u5efa\u7acb\u6a21\u578b\u65b9\u6cd5", (Object)this.getModelInfo()));
    }

    protected String getModelInfo() {
        return this.getClass().getSimpleName();
    }

    public void clearGlobalModel() {
        if (this.bClearGlobalModel) {
            return;
        }
        this.bClearGlobalModel = true;
        this.onClearGlobalModel();
        this.objRenewMap = null;
        this.objMap = null;
        this.objHelperMap = null;
        this.objEmptyMap = null;
        this.iDAGlobalHelper = null;
    }

    protected Object getPreloadModelsLock() {
        return this.objPreloadModels;
    }

    protected void finalize() throws Throwable {
        this.clearGlobalModel();
        super.finalize();
    }

    protected void onClearGlobalModel() {
        this.ResetAll();
    }

    protected void onResetModelHelper(HT ht) {
    }

    protected boolean isPrepareModels() {
        return !this.bPreloadModels;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected HT InternalGetModelHelper(KT objObjectId) {
        HashMap<KT, VT> hashMap = this.objMap;
        synchronized (hashMap) {
            block4: {
                if (this.objHelperMap != null) break block4;
                return null;
            }
            return this.objHelperMap.get(objObjectId);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected VT InternalGetModel(KT objObjectId) {
        HashMap<KT, VT> hashMap = this.objMap;
        synchronized (hashMap) {
            block4: {
                if (this.objMap != null) break block4;
                return null;
            }
            return this.objMap.get(objObjectId);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void internalSetModelHelper(KT objObjectId, HT ht) {
        HashMap<KT, VT> hashMap = this.objMap;
        synchronized (hashMap) {
            if (this.objHelperMap == null) {
                if (ht == null) {
                    return;
                }
                this.objHelperMap = new HashMap();
            }
            if (ht == null) {
                this.objHelperMap.remove(objObjectId);
            } else {
                this.objHelperMap.put(objObjectId, ht);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean containsModelHelper(KT objObjectId) {
        HashMap<KT, VT> hashMap = this.objMap;
        synchronized (hashMap) {
            block4: {
                if (this.objHelperMap != null) break block4;
                return false;
            }
            return this.objHelperMap.containsKey(objObjectId);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public HT FindModelHelper(KT objObjectId, boolean bTryMode) throws Exception {
        if (objObjectId == null) {
            throw new Exception("\u6807\u8bc6\u65e0\u6548");
        }
        HT ht = null;
        if (this.objHelperMap != null && (ht = (HT)this.objHelperMap.get(objObjectId)) != null) {
            return ht;
        }
        VT vt = this.FindModel(objObjectId);
        if (vt == null) {
            if (bTryMode) {
                return null;
            }
            throw this.createNotFoundException(objObjectId);
        }
        HashMap<KT, VT> hashMap = this.objMap;
        synchronized (hashMap) {
            ht = this.objHelperMap.get(objObjectId);
            if (ht != null) {
                return ht;
            }
            try {
                ht = this.OnCreateModelHelper(vt, objObjectId);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"[%2$s]\u5efa\u7acb\u6a21\u578b[%1$s]\u8f85\u52a9\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%3$s", objObjectId, (Object)this.getModelInfo(), (Object)ex.getMessage()), (Throwable)ex);
                this.internalSetModelHelper(objObjectId, null);
                throw ex;
            }
            if (ht == null) {
                throw new Exception(StringHelper.Format((String)"[%2$s]\u65e0\u6cd5\u5efa\u7acb\u6a21\u578b[%1$s]\u8f85\u52a9\u5bf9\u8c61", objObjectId, (Object)this.getModelInfo()));
            }
            this.objHelperMap.put(objObjectId, ht);
            return ht;
        }
    }

    protected Exception createNotFoundException(KT objObjectId) throws Exception {
        return new Exception(StringHelper.Format((String)"[%2$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b[%1$s]", objObjectId, (Object)this.getModelInfo()));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected HT FindModelHelper(KT objObjectId, VT vt) throws Exception {
        if (objObjectId == null) {
            throw new Exception("\u6807\u8bc6\u65e0\u6548");
        }
        HT ht = null;
        if (this.objHelperMap != null && (ht = (HT)this.objHelperMap.get(objObjectId)) != null) {
            return ht;
        }
        HashMap<KT, VT> hashMap = this.objMap;
        synchronized (hashMap) {
            ht = this.objHelperMap.get(objObjectId);
            if (ht != null) {
                return ht;
            }
            try {
                ht = this.OnCreateModelHelper(vt, objObjectId);
            }
            catch (Exception ex) {
                this.internalSetModelHelper(objObjectId, null);
                throw ex;
            }
            if (ht == null) {
                throw new Exception(StringHelper.Format((String)"[%2$s]\u65e0\u6cd5\u5efa\u7acb\u6a21\u578b[%1$s]\u8f85\u52a9\u5bf9\u8c61", objObjectId, (Object)this.getModelInfo()));
            }
            this.objHelperMap.put(objObjectId, ht);
            return ht;
        }
    }

    public int getModelCount() {
        HashMap<KT, HT> objHelperMap = this.objHelperMap;
        if (objHelperMap == null) {
            return 0;
        }
        return objHelperMap.size();
    }
}

