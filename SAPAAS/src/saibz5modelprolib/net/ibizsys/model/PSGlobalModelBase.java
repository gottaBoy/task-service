/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.model.IPSGlobalModel;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelQueryHelper;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelQueryHelperFactory;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSGlobalModelBase<KT, VT, HT>
implements IPSGlobalModel<KT, VT, HT> {
    private static final Log log = LogFactory.getLog(PSGlobalModelBase.class);
    protected Hashtable<KT, Long> objRenewMap = new Hashtable();
    protected Hashtable<KT, VT> objMap = new Hashtable();
    protected Hashtable<KT, HT> objHelperMap = new Hashtable();
    protected Hashtable<KT, String> objEmptyMap = new Hashtable();
    private boolean bPreloadModels = true;
    private Object objPreloadModels = new Object();
    private boolean bClearGlobalModel = false;
    protected int nRenewTimer = 5000;
    protected boolean bEnableEmptyMap = false;
    protected boolean bEnableRenew = true;
    protected ArrayList<HT> allModelHelperList = null;
    protected Object allModelHelperListLock = new Object();
    private IPSModelStorageContext iPSModelStorageContext = null;

    public void init(IPSModelStorageContext iPSModelStorageContext) throws Exception {
        this.iPSModelStorageContext = iPSModelStorageContext;
        this.onInit();
    }

    protected IPSModelStorageContext getPSModelStorageContext() {
        return this.iPSModelStorageContext;
    }

    protected void onInit() throws Exception {
        if (!this.bEnableEmptyMap) {
            this.objEmptyMap = null;
        } else {
            this.bEnableEmptyMap = true;
        }
        if (!this.getEnableRenew()) {
            this.bEnableRenew = false;
            this.objRenewMap = null;
        }
    }

    protected boolean getEnableRenew() {
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public VT findModel(KT objObjectId) {
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
                            if (!this.testObjectRenew(obj).booleanValue()) {
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
                obj = this.getObject(objObjectId);
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

    protected Boolean testObjectRenew(VT obj) {
        return true;
    }

    protected abstract VT getObject(KT var1);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetModel(KT objObjectId) {
        Hashtable<KT, VT> hashtable = this.allModelHelperListLock;
        synchronized (hashtable) {
            this.allModelHelperList = null;
        }
        hashtable = this.objMap;
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
    public void resetAll() {
        Hashtable<KT, VT> hashtable = this.allModelHelperListLock;
        synchronized (hashtable) {
            this.allModelHelperList = null;
        }
        hashtable = this.objMap;
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

    @Override
    public HT findModelHelper(KT objObjectId) throws Exception {
        return this.findModelHelper(objObjectId, (VT)false);
    }

    public Enumeration<HT> getModelHelpers() {
        return this.objHelperMap.elements();
    }

    protected HT onCreateModelHelper(VT vt, KT objObjectId) throws Exception {
        return this.onCreateModelHelper(vt);
    }

    protected HT onCreateModelHelper(VT vt) throws Exception {
        throw new Exception(StringHelper.format((String)"[%1$s]\u6ca1\u6709\u5b9e\u73b0\u5efa\u7acb\u6a21\u578b\u65b9\u6cd5", (Object)this.getModelInfo()));
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
    }

    protected void finalize() throws Throwable {
        this.clearGlobalModel();
        super.finalize();
    }

    protected void onClearGlobalModel() {
        ArrayList<HT> allModelHelperList = this.allModelHelperList;
        this.allModelHelperList = null;
        if (allModelHelperList != null) {
            for (HT ht : allModelHelperList) {
                this.onResetModelHelper(ht);
            }
        }
        this.resetAll();
    }

    protected void onResetModelHelper(HT ht) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Iterator<HT> getAllModelHelpers() throws Exception {
        Object object = this.allModelHelperListLock;
        synchronized (object) {
            ArrayList<HT> allModelHelperList = this.allModelHelperList;
            if (allModelHelperList != null) {
                return allModelHelperList.iterator();
            }
            this.setPreloadModels(false);
            Vector<VT> list = this.getAllModels();
            allModelHelperList = this.registerModels(list);
            this.allModelHelperList = allModelHelperList;
            return allModelHelperList.iterator();
        }
    }

    protected ArrayList<HT> registerModels(Vector<VT> list) throws Exception {
        ArrayList<HT> allModelHelperList = new ArrayList<HT>();
        for (VT vt : list) {
            allModelHelperList.add(this.registerModel(vt));
        }
        return allModelHelperList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getAllModelHelperCount() throws Exception {
        Object object = this.allModelHelperListLock;
        synchronized (object) {
            ArrayList<Object> allModelHelperList = this.allModelHelperList;
            if (allModelHelperList != null) {
                return allModelHelperList.size();
            }
            allModelHelperList = new ArrayList();
            this.setPreloadModels(false);
            Vector<VT> list = this.getAllModels();
            for (VT vt : list) {
                allModelHelperList.add(this.registerModel(vt));
            }
            this.allModelHelperList = allModelHelperList;
            return allModelHelperList.size();
        }
    }

    protected HT registerModel(VT vt) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected Vector<VT> getAllModels() throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected HT internalGetModelHelper(KT objObjectId) {
        Hashtable<KT, VT> hashtable = this.objMap;
        synchronized (hashtable) {
            return this.objHelperMap.get(objObjectId);
        }
    }

    public abstract String getPSSysModelInstId();

    protected abstract KT getObjectId(VT var1);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean containsModelHelper(KT objObjectId) {
        Hashtable<KT, VT> hashtable = this.objMap;
        synchronized (hashtable) {
            return this.objHelperMap.containsKey(objObjectId);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean containsModel(KT objObjectId) {
        Hashtable<KT, VT> hashtable = this.objMap;
        synchronized (hashtable) {
            return this.objMap.containsKey(objObjectId);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public HT findModelHelper(KT objObjectId, boolean bTryMode) throws Exception {
        Hashtable<KT, VT> hashtable = this.objMap;
        synchronized (hashtable) {
            VT vt = this.findModel(objObjectId);
            if (vt == null) {
                if (bTryMode) {
                    return null;
                }
                throw this.createNotFoundException(objObjectId);
            }
            HT ht = this.objHelperMap.get(objObjectId);
            if (ht != null) {
                return ht;
            }
            ht = this.onCreateModelHelper(vt, objObjectId);
            if (ht == null) {
                throw new Exception(StringHelper.format((String)"[%2$s]\u65e0\u6cd5\u5efa\u7acb\u6a21\u578b[%1$s]\u8f85\u52a9\u5bf9\u8c61", objObjectId, (Object)this.getModelInfo()));
            }
            this.objHelperMap.put(objObjectId, ht);
            return ht;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected HT findModelHelper(KT objObjectId, VT vt) throws Exception {
        HT ht = this.objHelperMap.get(objObjectId);
        if (ht != null) {
            return ht;
        }
        Hashtable<KT, VT> hashtable = this.objMap;
        synchronized (hashtable) {
            ht = this.objHelperMap.get(objObjectId);
            if (ht != null) {
                return ht;
            }
            ht = this.onCreateModelHelper(vt, objObjectId);
            if (ht == null) {
                throw new Exception(StringHelper.format((String)"[%2$s]\u65e0\u6cd5\u5efa\u7acb\u6a21\u578b[%1$s]\u8f85\u52a9\u5bf9\u8c61", objObjectId, (Object)this.getModelInfo()));
            }
            this.objHelperMap.put(objObjectId, ht);
            return ht;
        }
    }

    protected Exception createNotFoundException(KT objObjectId) throws Exception {
        return new Exception(StringHelper.format((String)"[%2$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b[%1$s]", objObjectId, (Object)this.getModelInfo()));
    }

    public int checkAll() throws Exception {
        int nCount = 0;
        return nCount;
    }

    public int getModelCount() {
        Hashtable<KT, HT> objHelperMap = this.objHelperMap;
        return objHelperMap.size();
    }

    protected boolean isAlwaysActivePSSysModelInst() {
        return false;
    }

    protected IPSModelQueryHelper getPSModelQueryHelper() {
        try {
            return PSModelQueryHelperFactory.getInstance(this.getPSSysModelInstId(), this.getPSDynaInstId());
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void refreshModelVer() {
        ArrayList<HT> list = new ArrayList<HT>();
        Hashtable<KT, VT> hashtable = this.objMap;
        synchronized (hashtable) {
            list.addAll(this.objHelperMap.values());
        }
        for (Object ht : list) {
            if (!(ht instanceof IPSModelObjectRuntime)) continue;
            ((IPSModelObjectRuntime)ht).refreshModelVer();
        }
    }

    public String getPSDynaInstId() {
        return null;
    }

    public int getDynaModelType() {
        return 0;
    }
}

