/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.der.IPSDER11
 *  net.ibizsys.model.der.IPSDER1N
 *  net.ibizsys.model.der.IPSDERBase
 *  net.ibizsys.model.der.IPSDERMultiInherit
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.IDERBase
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.der;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.PSDataEntityException;
import net.ibizsys.model.dataentity.PSDataEntityGlobalModelBase;
import net.ibizsys.model.der.IPSDER11;
import net.ibizsys.model.der.IPSDER1N;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.model.der.IPSDERMultiInherit;
import net.ibizsys.model.der.IPSDERRuntime;
import net.ibizsys.model.der.IPSDERType;
import net.ibizsys.model.der.IPSDERTypeRuntime;
import net.ibizsys.model.entity.PSDER;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MajorPSDERGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDER, IPSDERBase> {
    private static final Log log = LogFactory.getLog(MajorPSDERGlobalModel.class);
    private ArrayList<IPSDERBase> psDERBaseList = new ArrayList();
    private ArrayList<IDERBase> psDERBaseList2 = new ArrayList();
    private ArrayList<IPSDER1N> psDER1NList = new ArrayList();
    private ArrayList<IPSDER1N> psDER1NList2 = new ArrayList();
    private ArrayList<IPSDER11> psDER11List = new ArrayList();
    private ArrayList<IPSDERMultiInherit> psDERMultiInheritList = new ArrayList();

    @Override
    protected PSDER getObject(String strPSDERId) {
        log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u5173\u7cfb[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDERId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDERBase onCreateModelHelper(PSDER vt) throws Exception {
        IPSDERType iPSDERType = this.getPSModelStorageContext().getPSDERType(vt.getDERTYPE());
        IPSDERBase iPSDER = ((IPSDERTypeRuntime)iPSDERType).createPSDER(vt);
        IPSDataEntity minorPSDataEntity = null;
        minorPSDataEntity = StringHelper.compare((String)vt.getMINORPSDEID(), (String)this.getPSDataEntity().getId(), (boolean)false) == 0 ? this.getPSDataEntity() : this.getPSDataEntity().getPSSystem().getPSDataEntity(vt.getMINORPSDEID(), true);
        ((IPSDERRuntime)iPSDER).init(this.getPSModelStorageContext(), this.getPSDataEntity(), minorPSDataEntity, vt);
        return iPSDER;
    }

    @Override
    protected Boolean testObjectRenew(PSDER obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        Vector<PSDER> psDERList2 = new Vector<PSDER>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDERs(this.getPSDataEntity().getId(), psDERList2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u5173\u7cfb\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        Vector<PSDER> psDERList = new Vector<PSDER>();
        for (PSDER psDER : psDERList2) {
            if (psDER.getParamIntValue("VALIDFLAG", 1) != 1) continue;
            psDERList.add(psDER);
        }
        this.psDERBaseList.clear();
        this.psDERBaseList2.clear();
        this.psDER1NList.clear();
        this.psDER1NList2.clear();
        this.psDER11List.clear();
        this.psDERMultiInheritList.clear();
        for (PSDER psDER : psDERList) {
            try {
                this.setModel(psDER.getPSDERID(), psDER, null);
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage(), (Throwable)ex);
            }
        }
        for (PSDER psDER : psDERList) {
            try {
                IPSDERBase iPSDERBase = (IPSDERBase)this.internalGetModelHelper(psDER.getPSDERID());
                if (iPSDERBase == null) {
                    iPSDERBase = this.onCreateModelHelper(psDER);
                    this.setModel(psDER.getPSDERID(), psDER, iPSDERBase);
                }
                this.setModel(psDER.getPSDERNAME(), psDER, iPSDERBase);
                this.psDERBaseList.add(iPSDERBase);
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage(), (Throwable)ex);
            }
        }
        this.psDERBaseList2.addAll(this.psDERBaseList);
        for (IPSDERBase iPSDERBase : this.psDERBaseList) {
            if (iPSDERBase instanceof IPSDER1N) {
                this.psDER1NList.add((IPSDER1N)iPSDERBase);
            }
            if (iPSDERBase instanceof IPSDER11) {
                this.psDER11List.add((IPSDER11)iPSDERBase);
            }
            if (!(iPSDERBase instanceof IPSDERMultiInherit)) continue;
            this.psDERMultiInheritList.add((IPSDERMultiInherit)iPSDERBase);
        }
        if (this.psDER1NList.size() > 0) {
            this.psDER1NList2.addAll(this.psDER1NList);
            Collections.sort(this.psDER1NList2, new Comparator<IPSDER1N>(){

                @Override
                public int compare(IPSDER1N o1, IPSDER1N o2) {
                    return o1.getRemoveOrder() - o2.getRemoveOrder();
                }
            });
        }
        if (this.psDERMultiInheritList.size() > 0) {
            Collections.sort(this.psDERMultiInheritList, new Comparator<IPSDERMultiInherit>(){

                @Override
                public int compare(IPSDERMultiInherit o1, IPSDERMultiInherit o2) {
                    return o1.getOrderValue() - o2.getOrderValue();
                }
            });
        }
    }

    public Iterator<IPSDERBase> getPSDERs() {
        this.preloadModels();
        return this.psDERBaseList.iterator();
    }

    public Iterator<IDERBase> getDERs() {
        this.preloadModels();
        return this.psDERBaseList2.iterator();
    }

    @Override
    protected String getObjectId(PSDER vt) {
        return vt.getPSDERID();
    }

    public Iterator<IPSDER1N> getPSDER1Ns(boolean bRemoveOrder) {
        this.preloadModels();
        if (bRemoveOrder) {
            if (this.psDER1NList2.size() == 0) {
                return null;
            }
            return this.psDER1NList2.iterator();
        }
        if (this.psDER1NList.size() == 0) {
            return null;
        }
        return this.psDER1NList.iterator();
    }

    public Iterator<IPSDER11> getPSDER11s() {
        this.preloadModels();
        if (this.psDER11List.size() == 0) {
            return null;
        }
        return this.psDER11List.iterator();
    }

    public Iterator<IPSDERMultiInherit> getPSDERMultiInherits() {
        this.preloadModels();
        if (this.psDERMultiInheritList.size() == 0) {
            return null;
        }
        return this.psDERMultiInheritList.iterator();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20006, objObjectId);
    }
}

