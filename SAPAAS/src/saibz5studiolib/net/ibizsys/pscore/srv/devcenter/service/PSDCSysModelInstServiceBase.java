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

import java.sql.Timestamp;
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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCSysModelInstDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCSysModelInstDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysModelInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSysModelInstServiceBase
extends PSCoreSysServiceBase<PSDCSysModelInst> {
    private static final Log log = LogFactory.getLog(PSDCSysModelInstServiceBase.class);
    private PSDCSysModelInstDEModel pSDCSysModelInstDEModel;
    private PSDCSysModelInstDAO pSDCSysModelInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCSysModelInstService";
    }

    public PSDCSysModelInstDEModel getPSDCSysModelInstDEModel() {
        if (this.pSDCSysModelInstDEModel == null) {
            try {
                this.pSDCSysModelInstDEModel = (PSDCSysModelInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCSysModelInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSysModelInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCSysModelInstDEModel();
    }

    public PSDCSysModelInstDAO getPSDCSysModelInstDAO() {
        if (this.pSDCSysModelInstDAO == null) {
            try {
                this.pSDCSysModelInstDAO = (PSDCSysModelInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCSysModelInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSysModelInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCSysModelInstDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSDCSysModelInst pSDCSysModelInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCSYSMODELINST_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCSysModelInst, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCSYSMODELINST_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSln);
            } else {
                iService.get((IEntity)pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDCSysModelInst, pSDevSln);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCSYSMODELINST_PSSYSMODELINST_PSSYSMODELINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService", (SessionFactory)this.getSessionFactory());
            PSSysModelInst pSSysModelInst = (PSSysModelInst)iService.getDEModel().createEntity();
            pSSysModelInst.set("PSSYSMODELINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysModelInst);
            } else {
                iService.get((IEntity)pSSysModelInst);
            }
            this.onFillParentInfo_PSSysModelInst(pSDCSysModelInst, pSSysModelInst);
            return;
        }
        super.onFillParentInfo((IEntity)pSDCSysModelInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSDCSysModelInst pSDCSysModelInst, PSDevCenter pSDevCenter) throws Exception {
        pSDCSysModelInst.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCSysModelInst.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevSln(PSDCSysModelInst pSDCSysModelInst, PSDevSln pSDevSln) throws Exception {
        pSDCSysModelInst.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDCSysModelInst.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillParentInfo_PSSysModelInst(PSDCSysModelInst pSDCSysModelInst, PSSysModelInst pSSysModelInst) throws Exception {
        pSDCSysModelInst.setPSSysModelInstId(pSSysModelInst.getPSSysModelInstId());
        pSDCSysModelInst.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
    }

    protected void onFillEntityFullInfo(PSDCSysModelInst pSDCSysModelInst, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDCSysModelInst, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCSysModelInst, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDCSysModelInst, bl);
        this.onFillEntityFullInfo_PSSysModelInst(pSDCSysModelInst, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCSysModelInst pSDCSysModelInst, boolean bl) throws Exception {
        if (pSDCSysModelInst.isPSDevCenterIdDirty()) {
            if (pSDCSysModelInst.getPSDevCenterId() != null) {
                if (pSDCSysModelInst.getPSDevCenterId() == null || pSDCSysModelInst.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCSysModelInst.getPSDevCenter();
                    pSDCSysModelInst.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCSysModelInst.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDCSysModelInst pSDCSysModelInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysModelInst(PSDCSysModelInst pSDCSysModelInst, boolean bl) throws Exception {
        if (pSDCSysModelInst.isPSSysModelInstIdDirty()) {
            if (pSDCSysModelInst.getPSSysModelInstId() != null) {
                if (pSDCSysModelInst.getPSSysModelInstId() == null || pSDCSysModelInst.getPSSysModelInstName() == null) {
                    PSSysModelInst pSSysModelInst = pSDCSysModelInst.getPSSysModelInst();
                    pSDCSysModelInst.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
                }
            } else {
                pSDCSysModelInst.setPSSysModelInstName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCSysModelInst pSDCSysModelInst, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDCSysModelInst, bl);
    }

    public ArrayList<PSDCSysModelInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCSysModelInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCSysModelInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCSysModelInst> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDCSysModelInst> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDCSysModelInst> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNID", (Object)pSDevSlnBase.getPSDevSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCSysModelInst> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase) throws Exception {
        return this.selectByPSSysModelInst(pSSysModelInstBase, "", -1);
    }

    public ArrayList<PSDCSysModelInst> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string) throws Exception {
        return this.selectByPSSysModelInst(pSSysModelInstBase, string, -1);
    }

    public ArrayList<PSDCSysModelInst> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMODELINSTID", (Object)pSSysModelInstBase.getPSSysModelInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysModelInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysModelInstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCSysModelInst> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCSysModelInst pSDCSysModelInst : arrayList) {
            PSDCSysModelInst pSDCSysModelInst2 = (PSDCSysModelInst)this.getDEModel().createEntity();
            pSDCSysModelInst2.setPSDCSysModelInstId(pSDCSysModelInst.getPSDCSysModelInstId());
            pSDCSysModelInst2.setPSDevCenterId(null);
            this.update(pSDCSysModelInst2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCSysModelInstServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCSysModelInstServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCSysModelInstServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCSysModelInst> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCSysModelInst pSDCSysModelInst : arrayList) {
            this.remove((IEntity)pSDCSysModelInst);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCSysModelInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCSysModelInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCSysModelInst> arrayList = this.selectByPSDevSln(pSDevSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCSYSMODELINST_PSDEVSLN_PSDEVSLNID", "", iDataEntityModel.getName(), "PSDCSYSMODELINST", iDataEntityModel.getDataInfo((IEntity)pSDevSln), arrayList.get(0)));
        }
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCSysModelInst> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDCSysModelInst pSDCSysModelInst : arrayList) {
            PSDCSysModelInst pSDCSysModelInst2 = (PSDCSysModelInst)this.getDEModel().createEntity();
            pSDCSysModelInst2.setPSDCSysModelInstId(pSDCSysModelInst.getPSDCSysModelInstId());
            pSDCSysModelInst2.setPSDevSlnId(null);
            this.update(pSDCSysModelInst2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCSysModelInstServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDCSysModelInstServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDCSysModelInstServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCSysModelInst> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDCSysModelInst pSDCSysModelInst : arrayList) {
            this.remove((IEntity)pSDCSysModelInst);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCSysModelInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCSysModelInst> arrayList) throws Exception {
    }

    public void testRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDCSysModelInst> arrayList = this.selectByPSSysModelInst(pSSysModelInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMODELINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysModelInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCSYSMODELINST_PSSYSMODELINST_PSSYSMODELINSTID", "", iDataEntityModel.getName(), "PSDCSYSMODELINST", iDataEntityModel.getDataInfo((IEntity)pSSysModelInst), arrayList.get(0)));
        }
    }

    public void resetPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDCSysModelInst> arrayList = this.selectByPSSysModelInst(pSSysModelInst);
        for (PSDCSysModelInst pSDCSysModelInst : arrayList) {
            PSDCSysModelInst pSDCSysModelInst2 = (PSDCSysModelInst)this.getDEModel().createEntity();
            pSDCSysModelInst2.setPSDCSysModelInstId(pSDCSysModelInst.getPSDCSysModelInstId());
            pSDCSysModelInst2.setPSSysModelInstId(null);
            this.update(pSDCSysModelInst2);
        }
    }

    public void removeByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        final PSSysModelInst pSSysModelInst2 = pSSysModelInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCSysModelInstServiceBase.this.onBeforeRemoveByPSSysModelInst(pSSysModelInst2);
                PSDCSysModelInstServiceBase.this.internalRemoveByPSSysModelInst(pSSysModelInst2);
                PSDCSysModelInstServiceBase.this.onAfterRemoveByPSSysModelInst(pSSysModelInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void internalRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDCSysModelInst> arrayList = this.selectByPSSysModelInst(pSSysModelInst);
        this.onBeforeRemoveByPSSysModelInst(pSSysModelInst, arrayList);
        for (PSDCSysModelInst pSDCSysModelInst : arrayList) {
            this.remove((IEntity)pSDCSysModelInst);
        }
        this.onAfterRemoveByPSSysModelInst(pSSysModelInst, arrayList);
    }

    protected void onAfterRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void onBeforeRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSDCSysModelInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSDCSysModelInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCSysModelInst pSDCSysModelInst) throws Exception {
        super.onBeforeRemove(pSDCSysModelInst);
    }

    protected void replaceParentInfo(PSDCSysModelInst pSDCSysModelInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDCSysModelInst, cloneSession);
        if (pSDCSysModelInst.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCSysModelInst.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCSysModelInst, (PSDevCenter)iEntity);
        }
        if (pSDCSysModelInst.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDCSysModelInst.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDCSysModelInst, (PSDevSln)iEntity);
        }
        if (pSDCSysModelInst.getPSSysModelInstId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELINST", (Object)pSDCSysModelInst.getPSSysModelInstId())) != null) {
            this.onFillParentInfo_PSSysModelInst(pSDCSysModelInst, (PSSysModelInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCSysModelInst pSDCSysModelInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDCSysModelInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCSysModelInst pSDCSysModelInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CurDBAction(bl, pSDCSysModelInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpriedTime(bl, pSDCSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstState(bl, pSDCSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSysModelInstId(bl, pSDCSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSysModelInstName(bl, pSDCSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDCSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstId(bl, pSDCSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstName(bl, pSDCSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefObjId(bl, pSDCSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefObjName(bl, pSDCSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefObjType(bl, pSDCSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResReadyTime(bl, pSDCSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDCSysModelInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CurDBAction(boolean bl, PSDCSysModelInst pSDCSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysModelInst.isCurDBActionDirty() : !pSDCSysModelInst.isCurDBActionDirty()) {
            return null;
        }
        String string = pSDCSysModelInst.getCurDBAction();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CurDBAction_Default((IEntity)pSDCSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CURDBACTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpriedTime(boolean bl, PSDCSysModelInst pSDCSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysModelInst.isExpriedTimeDirty() : !pSDCSysModelInst.isExpriedTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCSysModelInst.getExpriedTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpriedTime_Default((IEntity)pSDCSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPRIEDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstState(boolean bl, PSDCSysModelInst pSDCSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysModelInst.isInstStateDirty() : !pSDCSysModelInst.isInstStateDirty()) {
            return null;
        }
        Integer n = pSDCSysModelInst.getInstState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_InstState_Default((IEntity)pSDCSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCSysModelInst pSDCSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysModelInst.isMemoDirty() : !pSDCSysModelInst.isMemoDirty()) {
            return null;
        }
        String string = pSDCSysModelInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDCSysModelInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCSysModelInstId(boolean bl, PSDCSysModelInst pSDCSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysModelInst.isPSDCSysModelInstIdDirty() && !bl2 : !pSDCSysModelInst.isPSDCSysModelInstIdDirty()) {
            return null;
        }
        String string = pSDCSysModelInst.getPSDCSysModelInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSYSMODELINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSysModelInstId_Default((IEntity)pSDCSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSYSMODELINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCSysModelInstName(boolean bl, PSDCSysModelInst pSDCSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysModelInst.isPSDCSysModelInstNameDirty() && !bl2 : !pSDCSysModelInst.isPSDCSysModelInstNameDirty()) {
            return null;
        }
        String string = pSDCSysModelInst.getPSDCSysModelInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSYSMODELINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSysModelInstName_Default((IEntity)pSDCSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSYSMODELINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCSysModelInst pSDCSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysModelInst.isPSDevCenterIdDirty() : !pSDCSysModelInst.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCSysModelInst.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default((IEntity)pSDCSysModelInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCSysModelInst pSDCSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysModelInst.isPSDevCenterNameDirty() : !pSDCSysModelInst.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCSysModelInst.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default((IEntity)pSDCSysModelInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDCSysModelInst pSDCSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysModelInst.isPSDevSlnIdDirty() : !pSDCSysModelInst.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDCSysModelInst.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default((IEntity)pSDCSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelInstId(boolean bl, PSDCSysModelInst pSDCSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysModelInst.isPSSysModelInstIdDirty() : !pSDCSysModelInst.isPSSysModelInstIdDirty()) {
            return null;
        }
        String string = pSDCSysModelInst.getPSSysModelInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstId_Default((IEntity)pSDCSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelInstName(boolean bl, PSDCSysModelInst pSDCSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysModelInst.isPSSysModelInstNameDirty() : !pSDCSysModelInst.isPSSysModelInstNameDirty()) {
            return null;
        }
        String string = pSDCSysModelInst.getPSSysModelInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstName_Default((IEntity)pSDCSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefObjId(boolean bl, PSDCSysModelInst pSDCSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysModelInst.isRefObjIdDirty() : !pSDCSysModelInst.isRefObjIdDirty()) {
            return null;
        }
        String string = pSDCSysModelInst.getRefObjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefObjId_Default((IEntity)pSDCSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefObjName(boolean bl, PSDCSysModelInst pSDCSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysModelInst.isRefObjNameDirty() : !pSDCSysModelInst.isRefObjNameDirty()) {
            return null;
        }
        String string = pSDCSysModelInst.getRefObjName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefObjName_Default((IEntity)pSDCSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFOBJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefObjType(boolean bl, PSDCSysModelInst pSDCSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysModelInst.isRefObjTypeDirty() : !pSDCSysModelInst.isRefObjTypeDirty()) {
            return null;
        }
        String string = pSDCSysModelInst.getRefObjType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefObjType_Default((IEntity)pSDCSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFOBJTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResReadyTime(boolean bl, PSDCSysModelInst pSDCSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysModelInst.isResReadyTimeDirty() : !pSDCSysModelInst.isResReadyTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCSysModelInst.getResReadyTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResReadyTime_Default((IEntity)pSDCSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESREADYTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCSysModelInst pSDCSysModelInst, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDCSysModelInst, bl);
    }

    protected void onSyncIndexEntities(PSDCSysModelInst pSDCSysModelInst, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDCSysModelInst, bl);
    }

    public Object getDataContextValue(PSDCSysModelInst pSDCSysModelInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDCSysModelInst, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCSysModelInst pSDCSysModelInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDCSysModelInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CURDBACTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CurDBAction_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPRIEDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ExpriedTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_InstState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCSYSMODELINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSysModelInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCSYSMODELINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSysModelInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_RefObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFOBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_RefObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFOBJTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_RefObjType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESREADYTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ResReadyTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_CurDBAction_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CURDBACTION", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExpriedTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_InstState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDCSysModelInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSYSMODELINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCSysModelInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSYSMODELINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDevSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFOBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefObjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFOBJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefObjType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFOBJTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResReadyTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSDCSysModelInst pSDCSysModelInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDCSysModelInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCSysModelInst pSDCSysModelInst) throws Exception {
        super.onUpdateParent((IEntity)pSDCSysModelInst);
    }

    @Override
    protected void exportCurXmlModel(PSDCSysModelInst pSDCSysModelInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCSYSMODELINST");
        if (!bl) {
            pSDCSysModelInst.setCreateDate(null);
            pSDCSysModelInst.setCreateMan(null);
            pSDCSysModelInst.setPSDCSysModelInstId(null);
            pSDCSysModelInst.setPSDevSlnName(null);
            pSDCSysModelInst.setUpdateDate(null);
            pSDCSysModelInst.setUpdateMan(null);
            super.exportCurXmlModel(pSDCSysModelInst, xmlNode, bl);
        }
    }
}

