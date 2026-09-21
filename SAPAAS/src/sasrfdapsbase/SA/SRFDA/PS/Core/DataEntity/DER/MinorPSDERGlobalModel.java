/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDERBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER11;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERInherit;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERMultiInherit;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERType;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Data.PSDER;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.core.IDERBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MinorPSDERGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDER, IPSDERBase> {
    private static final Log log = LogFactory.getLog(MinorPSDERGlobalModel.class);
    private ArrayList<IPSDERBase> psDERBaseList = new ArrayList();
    private ArrayList<IDERBase> psDERBaseList2 = new ArrayList();
    private IPSDERInherit iPSDERInherit = null;
    private IPSDER11 iPSDER11 = null;
    private ArrayList<IPSDER1N> psDER1NList = new ArrayList();
    private ArrayList<IPSDER1N> psDER1NList2 = new ArrayList();
    private ArrayList<IPSDERMultiInherit> psDERMultiInheritList = new ArrayList();

    @Override
    protected PSDER GetObject(String strPSDERId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u5173\u7cfb[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDERId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDERBase OnCreateModelHelper(PSDER vt) throws Exception {
        IPSDERType iPSDERType = this.iPSModelStorage.getPSDERType(vt.getDERTYPE());
        IPSDERBase iPSDER = iPSDERType.createPSDER(vt);
        IPSDataEntity majorPSDataEntity = null;
        majorPSDataEntity = StringHelper.Compare((String)vt.getMAJORPSDEID(), (String)this.getPSDataEntity().getId(), (boolean)false) == 0 ? this.getPSDataEntity() : this.getPSDataEntity().getPSSystem().getPSDataEntity2(vt.getMAJORPSDEID());
        iPSDER.init(this.iDAGlobalHelper, majorPSDataEntity, this.getPSDataEntity(), vt);
        return iPSDER;
    }

    @Override
    protected Boolean TestObjectRenew(PSDER obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        Vector<PSDER> psDERList2 = new Vector<PSDER>();
        CallResult callResult = this.iPSModelHelper.getPSDERsByMinorDEId(this.getPSDataEntity().getId(), psDERList2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5173\u7cfb\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        Vector<PSDER> psDERList = new Vector<PSDER>();
        for (PSDER psDER : psDERList2) {
            if (psDER.GetParamIntValue("VALIDFLAG", 1) != 1) continue;
            psDERList.add(psDER);
        }
        this.psDERBaseList.clear();
        this.psDERBaseList2.clear();
        this.psDER1NList.clear();
        this.psDER1NList2.clear();
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
                IPSDERBase iPSDERBase = (IPSDERBase)this.InternalGetModelHelper(psDER.getPSDERID());
                if (iPSDERBase == null) {
                    iPSDERBase = this.OnCreateModelHelper(psDER);
                    this.setModel(psDER.getPSDERID(), psDER, iPSDERBase);
                }
                this.setModel(psDER.getPSDERNAME(), psDER, iPSDERBase);
                if (iPSDERBase instanceof IPSDERInherit && ((IPSDERInherit)iPSDERBase).isSingleInherit()) {
                    this.iPSDERInherit = (IPSDERInherit)iPSDERBase;
                }
                if (iPSDERBase instanceof IPSDER11) {
                    this.iPSDER11 = (IPSDER11)iPSDERBase;
                }
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
            if (!(iPSDERBase instanceof IPSDERMultiInherit)) continue;
            this.psDERMultiInheritList.add((IPSDERMultiInherit)iPSDERBase);
        }
        if (this.psDER1NList.size() > 0) {
            this.psDER1NList2.addAll(this.psDER1NList);
            Collections.sort(this.psDER1NList2, new Comparator<IPSDER1N>(){

                @Override
                public int compare(IPSDER1N o1, IPSDER1N o2) {
                    int nRet = o1.getRemoveOrder() - o2.getRemoveOrder();
                    if (nRet == 0) {
                        return 0;
                    }
                    if (nRet > 0) {
                        return 1;
                    }
                    return -1;
                }
            });
        }
        if (this.psDERMultiInheritList.size() > 0) {
            Collections.sort(this.psDERMultiInheritList, new Comparator<IPSDERMultiInherit>(){

                @Override
                public int compare(IPSDERMultiInherit o1, IPSDERMultiInherit o2) {
                    int nRet = o1.getOrderValue() - o2.getOrderValue();
                    if (nRet == 0) {
                        return 0;
                    }
                    if (nRet > 0) {
                        return 1;
                    }
                    return -1;
                }
            });
        }
    }

    public Iterator<IPSDERBase> getPSDERs() {
        this.preloadModels();
        return this.psDERBaseList.iterator();
    }

    public int getPSDERCount() {
        this.preloadModels();
        return this.psDERBaseList.size();
    }

    public Iterator<IDERBase> getDERs() {
        this.preloadModels();
        return this.psDERBaseList2.iterator();
    }

    public IPSDERInherit getPSDERInherit() {
        this.preloadModels();
        return this.iPSDERInherit;
    }

    public IPSDER11 getPSDER11() {
        this.preloadModels();
        return this.iPSDER11;
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

    public Iterator<IPSDERMultiInherit> getPSDERMultiInherits() {
        this.preloadModels();
        if (this.psDERMultiInheritList.size() == 0) {
            return null;
        }
        return this.psDERMultiInheritList.iterator();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20008, objObjectId);
    }
}

