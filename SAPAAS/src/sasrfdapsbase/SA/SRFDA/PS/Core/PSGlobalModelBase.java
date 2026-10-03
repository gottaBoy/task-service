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
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSModelStorage;
import SA.SRFDA.PS.Core.PSGlobalModelBaseBase;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Util.PSModelUtil;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBaseBase<KT, VT, HT> {
    private static final Log log = LogFactory.getLog(PSGlobalModelBase.class);
    protected IPSModelHelper iPSModelHelper = null;
    protected IPSModelStorage iPSModelStorage = null;
    private ArrayList<HT> allModelHelperList = null;
    private Object allModelHelperListLock = new Object();
    private Map<KT, KT> aliasObjectMap = null;

    @Override
    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper) {
        try {
            this.iDAGlobalHelper = iDAGlobalHelper;
            this.iPSModelHelper = PSObjectFactory.getPSModelHelper(iDAGlobalHelper, this.getPSSysModelInstId(), this.isAlwaysActivePSSysModelInst());
            this.iPSModelStorage = PSObjectFactory.getPSModelStorage(iDAGlobalHelper);
            return this.OnInit();
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    @Override
    protected CallResult OnInit() {
        if (!this.bEnableEmptyMap) {
            this.objEmptyMap = null;
        } else {
            this.bEnableEmptyMap = true;
        }
        if (!this.getEnableRenew()) {
            this.bEnableRenew = false;
            this.objRenewMap = null;
        }
        if (this.isEnableObjectAlias()) {
            this.aliasObjectMap = new HashMap<KT, KT>();
        }
        return super.OnInit();
    }

    protected boolean getEnableRenew() {
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public HT getAllModelHelper(int nIndex) throws Exception {
        Object object = this.allModelHelperListLock;
        synchronized (object) {
            block4: {
                this.getAllModelHelpers();
                if (nIndex >= 0 && nIndex < this.allModelHelperList.size()) break block4;
                return null;
            }
            return this.allModelHelperList.get(nIndex);
        }
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
            if (allModelHelperList != null && allModelHelperList.size() > 0 && allModelHelperList.get(0) instanceof IPSModelSortable) {
                PSModelUtil.sort(allModelHelperList);
            }
            this.allModelHelperList = allModelHelperList;
            return allModelHelperList.iterator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected ArrayList<HT> registerModels(Vector<VT> list) throws Exception {
        KT key;
        ArrayList<HT> allModelHelperList = new ArrayList<HT>();
        for (VT vt : list) {
            KT[] aliases;
            key = this.getObjectId(vt);
            if (this.InternalGetModel(key) == null) {
                this.setModel(this.getObjectId(vt), vt, null);
            }
            if (!this.isEnableObjectAlias() || (aliases = this.getObjectAliases(vt)) == null || aliases.length <= 0) continue;
            Map<KT, KT> map = this.aliasObjectMap;
            synchronized (map) {
                KT[] KTArray = aliases;
                int n = aliases.length;
                int n2 = 0;
                while (n2 < n) {
                    KT alias = KTArray[n2];
                    this.aliasObjectMap.put(alias, key);
                    ++n2;
                }
            }
        }
        for (VT vt : list) {
            key = this.getObjectId(vt);
            HT helper = this.InternalGetModelHelper(key);
            if (helper != null) {
                allModelHelperList.add(helper);
                continue;
            }
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
            this.getAllModelHelpers();
            return this.allModelHelperList.size();
        }
    }

    protected HT registerModel(VT vt) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected Vector<VT> getAllModels() throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    protected abstract VT GetObject(KT var1);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void ResetModel(KT objObjectId) {
        if (PSTemplHelper.isBusy()) {
            log.error((Object)StringHelper.Format((String)"\u6a21\u677f\u53d1\u5e03\u8fc7\u7a0b\u4e2d\u4e0d\u80fd\u8fdb\u884c\u6a21\u578b\u79fb\u9664\u64cd\u4f5c"));
            return;
        }
        Object object = this.allModelHelperListLock;
        synchronized (object) {
            this.allModelHelperList = null;
        }
        super.ResetModel(objObjectId);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void ResetModelAlways(KT objObjectId) {
        Object object = this.allModelHelperListLock;
        synchronized (object) {
            this.allModelHelperList = null;
        }
        super.ResetModel(objObjectId);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void ResetAll() {
        if (PSTemplHelper.isBusy()) {
            log.error((Object)StringHelper.Format((String)"\u6a21\u677f\u53d1\u5e03\u8fc7\u7a0b\u4e2d\u4e0d\u80fd\u8fdb\u884c\u6a21\u578b\u6e05\u7a7a\u64cd\u4f5c"));
            return;
        }
        Object lock = this.allModelHelperListLock;
        synchronized (lock) {
            this.allModelHelperList = null;
        }
        if (this.aliasObjectMap != null) {
            Map<KT, KT> map = this.aliasObjectMap;
            synchronized (map) {
                this.aliasObjectMap.clear();
            }
        }
        super.ResetAll();
    }

    public abstract String getPSSysModelInstId();

    protected abstract KT getObjectId(VT var1);

    protected KT[] getObjectAliases(VT vt) {
        return null;
    }

    protected boolean isEnableObjectAlias() {
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean containsModel(KT objObjectId) {
        HashMap hashMap = this.objMap;
        synchronized (hashMap) {
            return this.objMap.containsKey(objObjectId);
        }
    }

    public int checkAll() throws Exception {
        int nCount = 0;
        Iterator<HT> allModels = this.getAllModelHelpers();
        while (allModels.hasNext()) {
            HT ht = allModels.next();
            if (!(ht instanceof IPSModelObject)) continue;
            nCount += ((IPSModelObject)ht).check();
        }
        return nCount;
    }

    protected boolean isAlwaysActivePSSysModelInst() {
        return false;
    }

    protected IPSModelStorage getPSModelStorage() {
        return this.iPSModelStorage;
    }

    protected ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    @Override
    protected void onClearGlobalModel() {
        this.iPSModelHelper = null;
        this.iPSModelStorage = null;
        ArrayList<HT> allModelHelperList = this.allModelHelperList;
        this.allModelHelperList = null;
        if (allModelHelperList != null) {
            for (HT ht : allModelHelperList) {
                this.onResetModelHelper(ht);
            }
        }
        super.onClearGlobalModel();
    }

    @Override
    public HT FindModelHelper(KT objObjectId, boolean bTryMode) throws Exception {
        if (!this.isEnableObjectAlias()) {
            return super.FindModelHelper(objObjectId, bTryMode);
        }
        HT ht = super.FindModelHelper(objObjectId, true);
        if (ht != null) {
            return ht;
        }
        KT realId = this.aliasObjectMap.get(((String)objObjectId).toUpperCase());
        if (realId == null) {
            if (bTryMode) {
                return null;
            }
            return super.FindModelHelper(objObjectId, bTryMode);
        }
        return super.FindModelHelper(realId, bTryMode);
    }

    @Override
    protected VT InternalGetModel(KT objObjectId) {
        if (!this.isEnableObjectAlias()) {
            return super.InternalGetModel(objObjectId);
        }
        VT vt = super.InternalGetModel(objObjectId);
        if (vt != null) {
            return vt;
        }
        KT realId = this.aliasObjectMap.get(((String)objObjectId).toUpperCase());
        if (realId == null) {
            return null;
        }
        return super.InternalGetModel(realId);
    }

    @Override
    protected Object getPreloadModelsLock() {
        return this.allModelHelperListLock;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void internalAddAllModelHelper(HT ht) {
        Object object = this.allModelHelperListLock;
        synchronized (object) {
            if (this.allModelHelperList != null) {
                this.allModelHelperList.add(ht);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void appendAllModelHelpers(HT ht) throws Exception {
        Object object = this.allModelHelperListLock;
        synchronized (object) {
            this.getAllModelHelpers();
            this.allModelHelperList.add(ht);
        }
    }
}
