/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.devcenter.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.dao.PSDCSVNBKDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCSVNBKDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSVNBK;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSVNBKBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVNBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSVNBKService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSVNBKServiceBase
extends PSCoreSysServiceBase<PSDCSVNBK> {
    private static final Log log = LogFactory.getLog(PSDCSVNBKServiceBase.class);
    private PSDCSVNBKDEModel pSDCSVNBKDEModel;
    private PSDCSVNBKDAO pSDCSVNBKDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCSVNBKService";
    }

    public PSDCSVNBKDEModel getPSDCSVNBKDEModel() {
        if (this.pSDCSVNBKDEModel == null) {
            try {
                this.pSDCSVNBKDEModel = (PSDCSVNBKDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCSVNBKDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSVNBKDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCSVNBKDEModel();
    }

    public PSDCSVNBKDAO getPSDCSVNBKDAO() {
        if (this.pSDCSVNBKDAO == null) {
            try {
                this.pSDCSVNBKDAO = (PSDCSVNBKDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCSVNBKDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSVNBKDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCSVNBKDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSDCSVNBK pSDCSVNBK, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCSVNBK_PSDCSVNBK_PPSDCSVNBKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCSVNBKService", (SessionFactory)this.getSessionFactory());
            PSDCSVNBK pSDCSVNBK2 = (PSDCSVNBK)iService.getDEModel().createEntity();
            pSDCSVNBK2.set("PSDCSVNBKID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCSVNBK2);
            } else {
                iService.get(pSDCSVNBK2);
            }
            this.onFillParentInfo_PPSDCSVNBK(pSDCSVNBK, pSDCSVNBK2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCSVNBK_PSDEVCENTERSVN_PSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterSVN);
            } else {
                iService.get(pSDevCenterSVN);
            }
            this.onFillParentInfo_PSDevCenterSVN(pSDCSVNBK, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCSVNBK_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCSVNBK, pSDevCenter);
            return;
        }
        super.onFillParentInfo(pSDCSVNBK, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PPSDCSVNBK(PSDCSVNBK pSDCSVNBK, PSDCSVNBK pSDCSVNBK2) throws Exception {
        pSDCSVNBK.setPPSDCSVNBKId(pSDCSVNBK2.getPSDCSVNBKId());
        pSDCSVNBK.setPPSDCSVNBKName(pSDCSVNBK2.getPSDCSVNBKName());
    }

    protected void onFillParentInfo_PSDevCenterSVN(PSDCSVNBK pSDCSVNBK, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDCSVNBK.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDCSVNBK.setPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDCSVNBK pSDCSVNBK, PSDevCenter pSDevCenter) throws Exception {
        pSDCSVNBK.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCSVNBK.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillEntityFullInfo(PSDCSVNBK pSDCSVNBK, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDCSVNBK, bl);
        this.onFillEntityFullInfo_PPSDCSVNBK(pSDCSVNBK, bl);
        this.onFillEntityFullInfo_PSDevCenterSVN(pSDCSVNBK, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCSVNBK, bl);
    }

    protected void onFillEntityFullInfo_PPSDCSVNBK(PSDCSVNBK pSDCSVNBK, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterSVN(PSDCSVNBK pSDCSVNBK, boolean bl) throws Exception {
        if (pSDCSVNBK.isPSDevCenterSVNIdDirty()) {
            if (pSDCSVNBK.getPSDevCenterSVNId() != null) {
                if (pSDCSVNBK.getPSDevCenterSVNId() == null || pSDCSVNBK.getPSDevCenterSVNName() == null) {
                    PSDevCenterSVN pSDevCenterSVN = pSDCSVNBK.getPSDevCenterSVN();
                    pSDCSVNBK.setPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
                }
            } else {
                pSDCSVNBK.setPSDevCenterSVNName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCSVNBK pSDCSVNBK, boolean bl) throws Exception {
        if (pSDCSVNBK.isPSDevCenterIdDirty()) {
            if (pSDCSVNBK.getPSDevCenterId() != null) {
                if (pSDCSVNBK.getPSDevCenterId() == null || pSDCSVNBK.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCSVNBK.getPSDevCenter();
                    pSDCSVNBK.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCSVNBK.setPSDevCenterName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCSVNBK pSDCSVNBK, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCSVNBK, bl);
    }

    public ArrayList<PSDCSVNBK> selectByPPSDCSVNBK(PSDCSVNBKBase pSDCSVNBKBase) throws Exception {
        return this.selectByPPSDCSVNBK(pSDCSVNBKBase, "", -1);
    }

    public ArrayList<PSDCSVNBK> selectByPPSDCSVNBK(PSDCSVNBKBase pSDCSVNBKBase, String string) throws Exception {
        return this.selectByPPSDCSVNBK(pSDCSVNBKBase, string, -1);
    }

    public ArrayList<PSDCSVNBK> selectByPPSDCSVNBK(PSDCSVNBKBase pSDCSVNBKBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDCSVNBKID", (Object)pSDCSVNBKBase.getPSDCSVNBKId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDCSVNBKCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDCSVNBKCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCSVNBK> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDCSVNBK> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDCSVNBK> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERSVNID", (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterSVNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterSVNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCSVNBK> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCSVNBK> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCSVNBK> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPPSDCSVNBK(PSDCSVNBK pSDCSVNBK) throws Exception {
        ArrayList<PSDCSVNBK> arrayList = this.selectByPPSDCSVNBK(pSDCSVNBK, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCSVNBK");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCSVNBK);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCSVNBK_PSDCSVNBK_PPSDCSVNBKID", "", iDataEntityModel.getName(), "PSDCSVNBK", iDataEntityModel.getDataInfo(pSDCSVNBK), arrayList.get(0)));
        }
    }

    public void resetPPSDCSVNBK(PSDCSVNBK pSDCSVNBK) throws Exception {
        ArrayList<PSDCSVNBK> arrayList = this.selectByPPSDCSVNBK(pSDCSVNBK);
        for (PSDCSVNBK pSDCSVNBK2 : arrayList) {
            PSDCSVNBK pSDCSVNBK3 = (PSDCSVNBK)this.getDEModel().createEntity();
            pSDCSVNBK3.setPSDCSVNBKId(pSDCSVNBK2.getPSDCSVNBKId());
            pSDCSVNBK3.setPPSDCSVNBKId(null);
            this.update(pSDCSVNBK3);
        }
    }

    public void removeByPPSDCSVNBK(PSDCSVNBK pSDCSVNBK) throws Exception {
        final PSDCSVNBK pSDCSVNBK2 = pSDCSVNBK;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCSVNBKServiceBase.this.onBeforeRemoveByPPSDCSVNBK(pSDCSVNBK2);
                PSDCSVNBKServiceBase.this.internalRemoveByPPSDCSVNBK(pSDCSVNBK2);
                PSDCSVNBKServiceBase.this.onAfterRemoveByPPSDCSVNBK(pSDCSVNBK2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDCSVNBK(PSDCSVNBK pSDCSVNBK) throws Exception {
    }

    protected void internalRemoveByPPSDCSVNBK(PSDCSVNBK pSDCSVNBK) throws Exception {
        ArrayList<PSDCSVNBK> arrayList = this.selectByPPSDCSVNBK(pSDCSVNBK);
        this.onBeforeRemoveByPPSDCSVNBK(pSDCSVNBK, arrayList);
        for (PSDCSVNBK pSDCSVNBK2 : arrayList) {
            this.remove(pSDCSVNBK2);
        }
        this.onAfterRemoveByPPSDCSVNBK(pSDCSVNBK, arrayList);
    }

    protected void onAfterRemoveByPPSDCSVNBK(PSDCSVNBK pSDCSVNBK) throws Exception {
    }

    protected void onBeforeRemoveByPPSDCSVNBK(PSDCSVNBK pSDCSVNBK, ArrayList<PSDCSVNBK> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDCSVNBK(PSDCSVNBK pSDCSVNBK, ArrayList<PSDCSVNBK> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    public void resetPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDCSVNBK> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        for (PSDCSVNBK pSDCSVNBK : arrayList) {
            PSDCSVNBK pSDCSVNBK2 = (PSDCSVNBK)this.getDEModel().createEntity();
            pSDCSVNBK2.setPSDCSVNBKId(pSDCSVNBK.getPSDCSVNBKId());
            pSDCSVNBK2.setPSDevCenterSVNId(null);
            this.update(pSDCSVNBK2);
        }
    }

    public void removeByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCSVNBKServiceBase.this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSDCSVNBKServiceBase.this.internalRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSDCSVNBKServiceBase.this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDCSVNBK> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDCSVNBK pSDCSVNBK : arrayList) {
            this.remove(pSDCSVNBK);
        }
        this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDCSVNBK> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDCSVNBK> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCSVNBK> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCSVNBK_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDCSVNBK", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCSVNBK> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCSVNBK pSDCSVNBK : arrayList) {
            PSDCSVNBK pSDCSVNBK2 = (PSDCSVNBK)this.getDEModel().createEntity();
            pSDCSVNBK2.setPSDCSVNBKId(pSDCSVNBK.getPSDCSVNBKId());
            pSDCSVNBK2.setPSDevCenterId(null);
            this.update(pSDCSVNBK2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCSVNBKServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCSVNBKServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCSVNBKServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCSVNBK> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCSVNBK pSDCSVNBK : arrayList) {
            this.remove(pSDCSVNBK);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCSVNBK> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCSVNBK> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCSVNBK pSDCSVNBK) throws Exception {
        PSDCSVNBKService pSDCSVNBKService = (PSDCSVNBKService)ServiceGlobal.getService(PSDCSVNBKService.class, (SessionFactory)this.getSessionFactory());
        pSDCSVNBKService.testRemoveByPPSDCSVNBK(pSDCSVNBK);
        super.onBeforeRemove(pSDCSVNBK);
    }

    protected void replaceParentInfo(PSDCSVNBK pSDCSVNBK, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCSVNBK, cloneSession);
        if (pSDCSVNBK.getPPSDCSVNBKId() != null && (iEntity = cloneSession.getEntity("PSDCSVNBK", (Object)pSDCSVNBK.getPPSDCSVNBKId())) != null) {
            this.onFillParentInfo_PPSDCSVNBK(pSDCSVNBK, (PSDCSVNBK)iEntity);
        }
        if (pSDCSVNBK.getPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDCSVNBK.getPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_PSDevCenterSVN(pSDCSVNBK, (PSDevCenterSVN)iEntity);
        }
        if (pSDCSVNBK.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCSVNBK.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCSVNBK, (PSDevCenter)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCSVNBK pSDCSVNBK, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCSVNBK, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCSVNBK pSDCSVNBK, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BackupSize(bl, pSDCSVNBK, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BackupMode(bl, pSDCSVNBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCSVNBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDCSVNBKId(bl, pSDCSVNBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSVNBKId(bl, pSDCSVNBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSVNBKName(bl, pSDCSVNBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCSVNBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCSVNBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterSVNId(bl, pSDCSVNBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterSVNName(bl, pSDCSVNBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCSVNBK, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BackupSize(boolean bl, PSDCSVNBK pSDCSVNBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSVNBK.isBackupSizeDirty() : !pSDCSVNBK.isBackupSizeDirty()) {
            return null;
        }
        Integer n = pSDCSVNBK.getBackupSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BackupSize_Default(pSDCSVNBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BACKUPSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BackupMode(boolean bl, PSDCSVNBK pSDCSVNBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSVNBK.isBackupModeDirty() && !bl2 : !pSDCSVNBK.isBackupModeDirty()) {
            return null;
        }
        Integer n = pSDCSVNBK.getBackupMode();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BackupMode_Default(pSDCSVNBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCSVNBK pSDCSVNBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSVNBK.isMemoDirty() : !pSDCSVNBK.isMemoDirty()) {
            return null;
        }
        String string = pSDCSVNBK.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCSVNBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSDCSVNBKId(boolean bl, PSDCSVNBK pSDCSVNBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSVNBK.isPPSDCSVNBKIdDirty() : !pSDCSVNBK.isPPSDCSVNBKIdDirty()) {
            return null;
        }
        String string = pSDCSVNBK.getPPSDCSVNBKId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDCSVNBKId_Default(pSDCSVNBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDCSVNBKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCSVNBKId(boolean bl, PSDCSVNBK pSDCSVNBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSVNBK.isPSDCSVNBKIdDirty() && !bl2 : !pSDCSVNBK.isPSDCSVNBKIdDirty()) {
            return null;
        }
        String string = pSDCSVNBK.getPSDCSVNBKId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSVNBKID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSVNBKId_Default(pSDCSVNBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSVNBKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCSVNBKName(boolean bl, PSDCSVNBK pSDCSVNBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSVNBK.isPSDCSVNBKNameDirty() && !bl2 : !pSDCSVNBK.isPSDCSVNBKNameDirty()) {
            return null;
        }
        String string = pSDCSVNBK.getPSDCSVNBKName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSVNBKNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSVNBKName_Default(pSDCSVNBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSVNBKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCSVNBK pSDCSVNBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSVNBK.isPSDevCenterIdDirty() : !pSDCSVNBK.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCSVNBK.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDCSVNBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCSVNBK pSDCSVNBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSVNBK.isPSDevCenterNameDirty() : !pSDCSVNBK.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCSVNBK.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDCSVNBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterSVNId(boolean bl, PSDCSVNBK pSDCSVNBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSVNBK.isPSDevCenterSVNIdDirty() : !pSDCSVNBK.isPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDCSVNBK.getPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterSVNId_Default(pSDCSVNBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERSVNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterSVNName(boolean bl, PSDCSVNBK pSDCSVNBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSVNBK.isPSDevCenterSVNNameDirty() : !pSDCSVNBK.isPSDevCenterSVNNameDirty()) {
            return null;
        }
        String string = pSDCSVNBK.getPSDevCenterSVNName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterSVNName_Default(pSDCSVNBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERSVNNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCSVNBK pSDCSVNBK, boolean bl) throws Exception {
        super.onSyncEntity(pSDCSVNBK, bl);
    }

    protected void onSyncIndexEntities(PSDCSVNBK pSDCSVNBK, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCSVNBK, bl);
    }

    public Object getDataContextValue(PSDCSVNBK pSDCSVNBK, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCSVNBK, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCSVNBK pSDCSVNBK, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCSVNBK, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BACKUPSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_BackupSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BKMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_BackupMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDCSVNBKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PPSDCSVNBKId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDCSVNBKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PPSDCSVNBKName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCSVNBKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSVNBKId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCSVNBKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSVNBKName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterSVNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterSVNName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BackupSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BackupMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDCSVNBKId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDCSVNBKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDCSVNBKName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDCSVNBKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCSVNBKId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSVNBKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCSVNBKName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSVNBKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterSVNId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERSVNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterSVNName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERSVNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDCSVNBK pSDCSVNBK) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCSVNBK)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCSVNBK pSDCSVNBK) throws Exception {
        super.onUpdateParent(pSDCSVNBK);
    }

    @Override
    protected void exportCurXmlModel(PSDCSVNBK pSDCSVNBK, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCSVNBK");
        if (!bl) {
            pSDCSVNBK.setCreateDate(null);
            pSDCSVNBK.setCreateMan(null);
            pSDCSVNBK.setPSDCSVNBKId(null);
            pSDCSVNBK.setUpdateDate(null);
            pSDCSVNBK.setUpdateMan(null);
            super.exportCurXmlModel(pSDCSVNBK, xmlNode, bl);
        }
    }
}

