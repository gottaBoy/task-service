/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseDAGlobalModel<KT, VT, HT>
implements IDAGlobalModel<KT, VT, HT> {
    private static final Log log = LogFactory.getLog(BaseDAGlobalModel.class);
    protected Hashtable<KT, Long> objRenewMap = new Hashtable();
    protected Hashtable<KT, VT> objMap = new Hashtable();
    protected Hashtable<KT, HT> objHelperMap = new Hashtable();
    protected Hashtable<KT, String> objEmptyMap = new Hashtable();
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    private boolean bPreloadModels = true;
    private Object objPreloadModels = new Object();
    private boolean bClearGlobalModel = false;
    protected int nRenewTimer = 5000;
    protected boolean bEnableEmptyMap = false;
    protected boolean bEnableRenew = true;

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
        this.preloadModels();
        VT obj = null;
        Hashtable<KT, VT> hashtable = this.objMap;
        synchronized (hashtable) {
            block14: {
                block13: {
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
                    if (!this.bEnableEmptyMap || this.objEmptyMap == null || !this.objEmptyMap.containsKey(objObjectId)) break block13;
                    return null;
                }
                obj = this.GetObject(objObjectId);
                if (obj != null) break block14;
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
        Object object = this.objPreloadModels;
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
    protected void setPreloadModels(boolean bPreloadModels) {
        Object object = this.objPreloadModels;
        synchronized (object) {
            this.bPreloadModels = bPreloadModels;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void setModel(KT kt, VT vt, HT ht) {
        Hashtable<KT, VT> hashtable = this.objMap;
        synchronized (hashtable) {
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
    @Override
    public void ResetModel(KT objObjectId) {
        Hashtable<KT, VT> hashtable = this.objMap;
        synchronized (hashtable) {
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
    @Override
    public void ResetAll() {
        Hashtable<KT, VT> hashtable = this.objMap;
        synchronized (hashtable) {
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public HT FindModelHelper(KT objObjectId, boolean bTryMode) throws Exception {
        Hashtable<KT, VT> hashtable = this.objMap;
        synchronized (hashtable) {
            VT vt = this.FindModel(objObjectId);
            if (vt == null) {
                if (bTryMode) {
                    return null;
                }
                throw new Exception(StringHelper.Format((String)"[%2$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b[%1$s]", objObjectId, (Object)this.getModelInfo()));
            }
            HT ht = this.objHelperMap.get(objObjectId);
            if (ht != null) {
                return ht;
            }
            ht = this.OnCreateModelHelper(vt, objObjectId);
            if (ht == null) {
                throw new Exception(StringHelper.Format((String)"[%2$s]\u65e0\u6cd5\u5efa\u7acb\u6a21\u578b[%1$s]\u8f85\u52a9\u5bf9\u8c61", objObjectId, (Object)this.getModelInfo()));
            }
            this.objHelperMap.put(objObjectId, ht);
            return ht;
        }
    }

    @Override
    public HT FindModelHelper(KT objObjectId) throws Exception {
        return this.FindModelHelper(objObjectId, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected HT FindModelHelper(KT objObjectId, VT vt) throws Exception {
        Hashtable<KT, VT> hashtable = this.objMap;
        synchronized (hashtable) {
            if (this.objHelperMap.containsKey(objObjectId)) {
                return this.objHelperMap.get(objObjectId);
            }
            HT ht = this.OnCreateModelHelper(vt, objObjectId);
            if (ht == null) {
                throw new Exception(StringHelper.Format((String)"[%2$s]\u65e0\u6cd5\u5efa\u7acb\u6a21\u578b[%1$s]\u8f85\u52a9\u5bf9\u8c61", objObjectId, (Object)this.getModelInfo()));
            }
            this.objHelperMap.put(objObjectId, ht);
            return ht;
        }
    }

    public Enumeration<HT> GetModelHelpers() {
        return this.objHelperMap.elements();
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

    protected void finalize() throws Throwable {
        this.clearGlobalModel();
        super.finalize();
    }

    protected void onClearGlobalModel() {
        this.ResetAll();
    }

    protected void onResetModelHelper(HT ht) {
    }

    protected boolean isPreloadModels() {
        return this.bPreloadModels;
    }
}

