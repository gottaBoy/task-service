/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
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
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEAWGrpDetailDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEAWGrpDetailDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAWGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAWGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAWGrpDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionWizard;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionWizardBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEAWGrpDetailServiceBase
extends PSCoreSysServiceBase<PSDEAWGrpDetail> {
    private static final Log log = LogFactory.getLog(PSDEAWGrpDetailServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEAWGrpDetailDEModel pSDEAWGrpDetailDEModel;
    private PSDEAWGrpDetailDAO pSDEAWGrpDetailDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEAWGrpDetailService";
    }

    public PSDEAWGrpDetailDEModel getPSDEAWGrpDetailDEModel() {
        if (this.pSDEAWGrpDetailDEModel == null) {
            try {
                this.pSDEAWGrpDetailDEModel = (PSDEAWGrpDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEAWGrpDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEAWGrpDetailDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEAWGrpDetailDEModel();
    }

    public PSDEAWGrpDetailDAO getPSDEAWGrpDetailDAO() {
        if (this.pSDEAWGrpDetailDAO == null) {
            try {
                this.pSDEAWGrpDetailDAO = (PSDEAWGrpDetailDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEAWGrpDetailDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEAWGrpDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEAWGrpDetailDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDEAWGrpDetail pSDEAWGrpDetail, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEAWGRPDETAIL_PSDEACTIONWIZARD_PSDEACTIONWIZARDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionWizardService", (SessionFactory)this.getSessionFactory());
            PSDEActionWizard pSDEActionWizard = (PSDEActionWizard)iService.getDEModel().createEntity();
            pSDEActionWizard.set("PSDEACTIONWIZARDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEActionWizard);
            } else {
                iService.get((IEntity)pSDEActionWizard);
            }
            this.onFillParentInfo_PSDEActionWizard(pSDEAWGrpDetail, pSDEActionWizard);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEAWGRPDETAIL_PSDEAWGROUP_PSDEAWGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEAWGroupService", (SessionFactory)this.getSessionFactory());
            PSDEAWGroup pSDEAWGroup = (PSDEAWGroup)iService.getDEModel().createEntity();
            pSDEAWGroup.set("PSDEAWGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAWGroup);
            } else {
                iService.get((IEntity)pSDEAWGroup);
            }
            this.onFillParentInfo_PSDEAWGroup(pSDEAWGrpDetail, pSDEAWGroup);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEAWGrpDetail, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEActionWizard(PSDEAWGrpDetail pSDEAWGrpDetail, PSDEActionWizard pSDEActionWizard) throws Exception {
        pSDEAWGrpDetail.setPSDEActionWizardId(pSDEActionWizard.getPSDEActionWizardId());
        pSDEAWGrpDetail.setPSDEActionWizardName(pSDEActionWizard.getPSDEActionWizardName());
    }

    protected void onFillParentInfo_PSDEAWGroup(PSDEAWGrpDetail pSDEAWGrpDetail, PSDEAWGroup pSDEAWGroup) throws Exception {
        pSDEAWGrpDetail.setPSDEAWGroupId(pSDEAWGroup.getPSDEAWGroupId());
        pSDEAWGrpDetail.setPSDEAWGroupName(pSDEAWGroup.getPSDEAWGroupName());
    }

    protected void onFillEntityFullInfo(PSDEAWGrpDetail pSDEAWGrpDetail, boolean bl) throws Exception {
        if (bl) {
            if (pSDEAWGrpDetail.getPSDEAWGrpDetailName() == null) {
                pSDEAWGrpDetail.setPSDEAWGrpDetailName((String)this.getDefaultValue(this.getWebContext(), "", "Item", 25));
            }
            if (pSDEAWGrpDetail.getValidFlag() == null) {
                pSDEAWGrpDetail.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDEAWGrpDetail, bl);
        this.onFillEntityFullInfo_PSDEActionWizard(pSDEAWGrpDetail, bl);
        this.onFillEntityFullInfo_PSDEAWGroup(pSDEAWGrpDetail, bl);
    }

    protected void onFillEntityFullInfo_PSDEActionWizard(PSDEAWGrpDetail pSDEAWGrpDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEAWGroup(PSDEAWGrpDetail pSDEAWGrpDetail, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEAWGrpDetail pSDEAWGrpDetail, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEAWGrpDetail, bl);
    }

    public ArrayList<PSDEAWGrpDetail> selectByPSDEActionWizard(PSDEActionWizardBase pSDEActionWizardBase) throws Exception {
        return this.selectByPSDEActionWizard(pSDEActionWizardBase, "", -1);
    }

    public ArrayList<PSDEAWGrpDetail> selectByPSDEActionWizard(PSDEActionWizardBase pSDEActionWizardBase, String string) throws Exception {
        return this.selectByPSDEActionWizard(pSDEActionWizardBase, string, -1);
    }

    public ArrayList<PSDEAWGrpDetail> selectByPSDEActionWizard(PSDEActionWizardBase pSDEActionWizardBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEACTIONWIZARDID", (Object)pSDEActionWizardBase.getPSDEActionWizardId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEActionWizardCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEActionWizardCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAWGrpDetail> selectByPSDEAWGroup(PSDEAWGroupBase pSDEAWGroupBase) throws Exception {
        return this.selectByPSDEAWGroup(pSDEAWGroupBase, "", -1);
    }

    public ArrayList<PSDEAWGrpDetail> selectByPSDEAWGroup(PSDEAWGroupBase pSDEAWGroupBase, String string) throws Exception {
        return this.selectByPSDEAWGroup(pSDEAWGroupBase, string, -1);
    }

    public ArrayList<PSDEAWGrpDetail> selectByPSDEAWGroup(PSDEAWGroupBase pSDEAWGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEAWGROUPID", (Object)pSDEAWGroupBase.getPSDEAWGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEAWGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEAWGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAWGrpDetail> selectTempByPSDEAWGroup(PSDEAWGroupBase pSDEAWGroupBase) throws Exception {
        return this.selectTempByPSDEAWGroup(pSDEAWGroupBase, "");
    }

    public ArrayList<PSDEAWGrpDetail> selectTempByPSDEAWGroup(PSDEAWGroupBase pSDEAWGroupBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEAWGROUPID", (Object)pSDEAWGroupBase.getPSDEAWGroupId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEAWGroupCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEAWGroupCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEActionWizard(PSDEActionWizard pSDEActionWizard) throws Exception {
        ArrayList<PSDEAWGrpDetail> arrayList = this.selectByPSDEActionWizard(pSDEActionWizard, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTIONWIZARD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEActionWizard);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEAWGRPDETAIL_PSDEACTIONWIZARD_PSDEACTIONWIZARDID", "", iDataEntityModel.getName(), "PSDEAWGRPDETAIL", iDataEntityModel.getDataInfo((IEntity)pSDEActionWizard), arrayList.get(0)));
        }
    }

    public void resetPSDEActionWizard(PSDEActionWizard pSDEActionWizard) throws Exception {
        ArrayList<PSDEAWGrpDetail> arrayList = this.selectByPSDEActionWizard(pSDEActionWizard);
        for (PSDEAWGrpDetail pSDEAWGrpDetail : arrayList) {
            PSDEAWGrpDetail pSDEAWGrpDetail2 = (PSDEAWGrpDetail)this.getDEModel().createEntity();
            pSDEAWGrpDetail2.setPSDEAWGrpDetailId(pSDEAWGrpDetail.getPSDEAWGrpDetailId());
            pSDEAWGrpDetail2.setPSDEActionWizardId(null);
            this.update(pSDEAWGrpDetail2);
        }
    }

    public void removeByPSDEActionWizard(PSDEActionWizard pSDEActionWizard) throws Exception {
        final PSDEActionWizard pSDEActionWizard2 = pSDEActionWizard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEAWGrpDetailServiceBase.this.onBeforeRemoveByPSDEActionWizard(pSDEActionWizard2);
                PSDEAWGrpDetailServiceBase.this.internalRemoveByPSDEActionWizard(pSDEActionWizard2);
                PSDEAWGrpDetailServiceBase.this.onAfterRemoveByPSDEActionWizard(pSDEActionWizard2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEActionWizard(PSDEActionWizard pSDEActionWizard) throws Exception {
    }

    protected void internalRemoveByPSDEActionWizard(PSDEActionWizard pSDEActionWizard) throws Exception {
        ArrayList<PSDEAWGrpDetail> arrayList = this.selectByPSDEActionWizard(pSDEActionWizard);
        this.onBeforeRemoveByPSDEActionWizard(pSDEActionWizard, arrayList);
        for (PSDEAWGrpDetail pSDEAWGrpDetail : arrayList) {
            this.remove((IEntity)pSDEAWGrpDetail);
        }
        this.onAfterRemoveByPSDEActionWizard(pSDEActionWizard, arrayList);
    }

    protected void onAfterRemoveByPSDEActionWizard(PSDEActionWizard pSDEActionWizard) throws Exception {
    }

    protected void onBeforeRemoveByPSDEActionWizard(PSDEActionWizard pSDEActionWizard, ArrayList<PSDEAWGrpDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEActionWizard(PSDEActionWizard pSDEActionWizard, ArrayList<PSDEAWGrpDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEAWGroup(PSDEAWGroup pSDEAWGroup) throws Exception {
    }

    public void resetPSDEAWGroup(PSDEAWGroup pSDEAWGroup) throws Exception {
        ArrayList<PSDEAWGrpDetail> arrayList = this.selectByPSDEAWGroup(pSDEAWGroup);
        for (PSDEAWGrpDetail pSDEAWGrpDetail : arrayList) {
            PSDEAWGrpDetail pSDEAWGrpDetail2 = (PSDEAWGrpDetail)this.getDEModel().createEntity();
            pSDEAWGrpDetail2.setPSDEAWGrpDetailId(pSDEAWGrpDetail.getPSDEAWGrpDetailId());
            pSDEAWGrpDetail2.setPSDEAWGroupId(null);
            this.update(pSDEAWGrpDetail2);
        }
    }

    public void resetTempPSDEAWGroup(PSDEAWGroup pSDEAWGroup) throws Exception {
        ArrayList<PSDEAWGrpDetail> arrayList = this.selectTempByPSDEAWGroup(pSDEAWGroup);
        for (PSDEAWGrpDetail pSDEAWGrpDetail : arrayList) {
            PSDEAWGrpDetail pSDEAWGrpDetail2 = (PSDEAWGrpDetail)this.getDEModel().createEntity();
            pSDEAWGrpDetail2.setPSDEAWGrpDetailId(pSDEAWGrpDetail.getPSDEAWGrpDetailId());
            pSDEAWGrpDetail2.setPSDEAWGroupId(null);
            this.updateTemp((IEntity)pSDEAWGrpDetail2);
        }
    }

    public void removeByPSDEAWGroup(PSDEAWGroup pSDEAWGroup) throws Exception {
        final PSDEAWGroup pSDEAWGroup2 = pSDEAWGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEAWGrpDetailServiceBase.this.onBeforeRemoveByPSDEAWGroup(pSDEAWGroup2);
                PSDEAWGrpDetailServiceBase.this.internalRemoveByPSDEAWGroup(pSDEAWGroup2);
                PSDEAWGrpDetailServiceBase.this.onAfterRemoveByPSDEAWGroup(pSDEAWGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEAWGroup(PSDEAWGroup pSDEAWGroup) throws Exception {
    }

    protected void internalRemoveByPSDEAWGroup(PSDEAWGroup pSDEAWGroup) throws Exception {
        ArrayList<PSDEAWGrpDetail> arrayList = this.selectByPSDEAWGroup(pSDEAWGroup);
        this.onBeforeRemoveByPSDEAWGroup(pSDEAWGroup, arrayList);
        for (PSDEAWGrpDetail pSDEAWGrpDetail : arrayList) {
            this.remove((IEntity)pSDEAWGrpDetail);
        }
        this.onAfterRemoveByPSDEAWGroup(pSDEAWGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEAWGroup(PSDEAWGroup pSDEAWGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEAWGroup(PSDEAWGroup pSDEAWGroup, ArrayList<PSDEAWGrpDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEAWGroup(PSDEAWGroup pSDEAWGroup, ArrayList<PSDEAWGrpDetail> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEAWGrpDetail pSDEAWGrpDetail) throws Exception {
        super.onBeforeRemove(pSDEAWGrpDetail);
    }

    public void removeTempByPSDEAWGroup(PSDEAWGroup pSDEAWGroup) throws Exception {
        final PSDEAWGroup pSDEAWGroup2 = pSDEAWGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEAWGrpDetailServiceBase.this.onBeforeRemoveTempByPSDEAWGroup(pSDEAWGroup2);
                PSDEAWGrpDetailServiceBase.this.internalRemoveTempByPSDEAWGroup(pSDEAWGroup2);
                PSDEAWGrpDetailServiceBase.this.onAfterRemoveTempByPSDEAWGroup(pSDEAWGroup2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEAWGroup(PSDEAWGroup pSDEAWGroup) throws Exception {
    }

    protected void internalRemoveTempByPSDEAWGroup(PSDEAWGroup pSDEAWGroup) throws Exception {
        ArrayList<PSDEAWGrpDetail> arrayList = this.selectTempByPSDEAWGroup(pSDEAWGroup);
        this.onBeforeRemoveTempByPSDEAWGroup(pSDEAWGroup, arrayList);
        for (PSDEAWGrpDetail pSDEAWGrpDetail : arrayList) {
            this.removeTemp((IEntity)pSDEAWGrpDetail);
        }
        this.onAfterRemoveTempByPSDEAWGroup(pSDEAWGroup, arrayList);
    }

    protected void onAfterRemoveTempByPSDEAWGroup(PSDEAWGroup pSDEAWGroup) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEAWGroup(PSDEAWGroup pSDEAWGroup, ArrayList<PSDEAWGrpDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEAWGroup(PSDEAWGroup pSDEAWGroup, ArrayList<PSDEAWGrpDetail> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEAWGrpDetail pSDEAWGrpDetail, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEAWGrpDetail, cloneSession);
        if (pSDEAWGrpDetail.getPSDEActionWizardId() != null && (iEntity = cloneSession.getEntity("PSDEACTIONWIZARD", (Object)pSDEAWGrpDetail.getPSDEActionWizardId())) != null) {
            this.onFillParentInfo_PSDEActionWizard(pSDEAWGrpDetail, (PSDEActionWizard)iEntity);
        }
        if (pSDEAWGrpDetail.getPSDEAWGroupId() != null && (iEntity = cloneSession.getEntity("PSDEAWGROUP", (Object)pSDEAWGrpDetail.getPSDEAWGroupId())) != null) {
            this.onFillParentInfo_PSDEAWGroup(pSDEAWGrpDetail, (PSDEAWGroup)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEAWGrpDetail pSDEAWGrpDetail, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEAWGrpDetail, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEAWGrpDetail pSDEAWGrpDetail, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDEAWGrpDetail, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEAWGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionWizardId(bl, pSDEAWGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEAWGroupId(bl, pSDEAWGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEAWGrpDetailId(bl, pSDEAWGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEAWGrpDetailName(bl, pSDEAWGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEAWGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEAWGrpDetail, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEAWGrpDetail pSDEAWGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWGrpDetail.isMemoDirty() : !pSDEAWGrpDetail.isMemoDirty()) {
            return null;
        }
        String string = pSDEAWGrpDetail.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEAWGrpDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEAWGrpDetail pSDEAWGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWGrpDetail.isOrderValueDirty() : !pSDEAWGrpDetail.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEAWGrpDetail.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEAWGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionWizardId(boolean bl, PSDEAWGrpDetail pSDEAWGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWGrpDetail.isPSDEActionWizardIdDirty() && !bl2 : !pSDEAWGrpDetail.isPSDEActionWizardIdDirty()) {
            return null;
        }
        String string = pSDEAWGrpDetail.getPSDEActionWizardId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONWIZARDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionWizardId_Default((IEntity)pSDEAWGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONWIZARDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSDEAWGROUPID";
                String string4 = this.checkFieldDupRule(this.getPSDEAWGrpDetailDEModel(), "PSDEACTIONWIZARDID", string3, pSDEAWGrpDetail, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEACTIONWIZARDID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEAWGroupId(boolean bl, PSDEAWGrpDetail pSDEAWGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWGrpDetail.isPSDEAWGroupIdDirty() && !bl2 : !pSDEAWGrpDetail.isPSDEAWGroupIdDirty()) {
            return null;
        }
        String string = pSDEAWGrpDetail.getPSDEAWGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEAWGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEAWGroupId_Default((IEntity)pSDEAWGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEAWGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEAWGrpDetailId(boolean bl, PSDEAWGrpDetail pSDEAWGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWGrpDetail.isPSDEAWGrpDetailIdDirty() && !bl2 : !pSDEAWGrpDetail.isPSDEAWGrpDetailIdDirty()) {
            return null;
        }
        String string = pSDEAWGrpDetail.getPSDEAWGrpDetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEAWGRPDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEAWGrpDetailId_Default((IEntity)pSDEAWGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEAWGRPDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEAWGrpDetailName(boolean bl, PSDEAWGrpDetail pSDEAWGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWGrpDetail.isPSDEAWGrpDetailNameDirty() && !bl2 : !pSDEAWGrpDetail.isPSDEAWGrpDetailNameDirty()) {
            return null;
        }
        String string = pSDEAWGrpDetail.getPSDEAWGrpDetailName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEAWGRPDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEAWGrpDetailName_Default((IEntity)pSDEAWGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEAWGRPDETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEAWGrpDetail pSDEAWGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWGrpDetail.isValidFlagDirty() && !bl2 : !pSDEAWGrpDetail.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEAWGrpDetail.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDEAWGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEAWGrpDetail pSDEAWGrpDetail, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEAWGrpDetail, bl);
    }

    protected void onSyncIndexEntities(PSDEAWGrpDetail pSDEAWGrpDetail, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEAWGrpDetail, bl);
    }

    public Object getDataContextValue(PSDEAWGrpDetail pSDEAWGrpDetail, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEAWGrpDetail, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEActionWizard pSDEActionWizard = pSDEAWGrpDetail.getPSDEActionWizard();
        if (pSDEActionWizard != null && pSDEActionWizard.contains(string)) {
            return pSDEActionWizard.get(string);
        }
        PSDEAWGroup pSDEAWGroup = pSDEAWGrpDetail.getPSDEAWGroup();
        if (pSDEAWGroup != null && pSDEAWGroup.contains(string)) {
            return pSDEAWGroup.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEAWGrpDetail pSDEAWGrpDetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEAWGrpDetail, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONWIZARDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionWizardId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONWIZARDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionWizardName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEAWGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEAWGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEAWGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEAWGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEAWGRPDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEAWGrpDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEAWGRPDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEAWGrpDetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEActionWizardId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONWIZARDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionWizardName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONWIZARDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEAWGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEAWGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEAWGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEAWGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEAWGrpDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEAWGRPDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEAWGrpDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEAWGRPDETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEAWGrpDetail pSDEAWGrpDetail) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEAWGrpDetail)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEAWGrpDetail pSDEAWGrpDetail) throws Exception {
        super.onUpdateParent((IEntity)pSDEAWGrpDetail);
    }

    @Override
    protected void exportCurXmlModel(PSDEAWGrpDetail pSDEAWGrpDetail, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEAWGRPDETAIL");
        if (!bl) {
            pSDEAWGrpDetail.setCreateDate(null);
            pSDEAWGrpDetail.setCreateMan(null);
            pSDEAWGrpDetail.setPSDEAWGrpDetailId(null);
            pSDEAWGrpDetail.setUpdateDate(null);
            pSDEAWGrpDetail.setUpdateMan(null);
            pSDEAWGrpDetail.setPSDEAWGroupId(null);
            pSDEAWGrpDetail.setPSDEAWGroupName(null);
            super.exportCurXmlModel(pSDEAWGrpDetail, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEAWGrpDetail pSDEAWGrpDetail, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEAWGrpDetail, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEAWGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEAWGROUP#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEAWGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEAWGRPDETAIL_PSDEAWGROUP_PSDEAWGROUPID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEAWGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEAWGROUPNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEAWGROUP", (boolean)true) == 0) {
            iEntity.set("PSDEAWGROUPID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEAWGROUPID"};
    }

    @Override
    public String getModelV2Tag(PSDEAWGrpDetail pSDEAWGrpDetail) {
        return super.getModelV2Tag(pSDEAWGrpDetail);
    }

    @Override
    public boolean setModelV2Tag(PSDEAWGrpDetail pSDEAWGrpDetail, String string) {
        return super.setModelV2Tag(pSDEAWGrpDetail, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEAWGROUPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEAWGrpDetail pSDEAWGrpDetail, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEAWGrpDetail.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEAWGrpDetail, true);
        return super.getModelV2Entity(pSDEAWGrpDetail, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEAWGrpDetail pSDEAWGrpDetail, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEAWGrpDetail, objectNode, string, string2, n);
    }
}

