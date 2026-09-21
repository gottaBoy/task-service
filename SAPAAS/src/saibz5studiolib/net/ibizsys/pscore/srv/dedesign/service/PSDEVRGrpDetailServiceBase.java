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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEVRGrpDetailDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEVRGrpDetailDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRuleBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEVRGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEVRGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEVRGrpDetail;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEVRGrpDetailServiceBase
extends PSCoreSysServiceBase<PSDEVRGrpDetail> {
    private static final Log log = LogFactory.getLog(PSDEVRGrpDetailServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEVRGrpDetailDEModel pSDEVRGrpDetailDEModel;
    private PSDEVRGrpDetailDAO pSDEVRGrpDetailDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEVRGrpDetailService";
    }

    public PSDEVRGrpDetailDEModel getPSDEVRGrpDetailDEModel() {
        if (this.pSDEVRGrpDetailDEModel == null) {
            try {
                this.pSDEVRGrpDetailDEModel = (PSDEVRGrpDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEVRGrpDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEVRGrpDetailDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEVRGrpDetailDEModel();
    }

    public PSDEVRGrpDetailDAO getPSDEVRGrpDetailDAO() {
        if (this.pSDEVRGrpDetailDAO == null) {
            try {
                this.pSDEVRGrpDetailDAO = (PSDEVRGrpDetailDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEVRGrpDetailDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEVRGrpDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEVRGrpDetailDAO();
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

    protected void onFillParentInfo(PSDEVRGrpDetail pSDEVRGrpDetail, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVRGRPDETAIL_PSDEFVALUERULE_PSDEFVALUERULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService", (SessionFactory)this.getSessionFactory());
            PSDEFValueRule pSDEFValueRule = (PSDEFValueRule)iService.getDEModel().createEntity();
            pSDEFValueRule.set("PSDEFVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFValueRule);
            } else {
                iService.get((IEntity)pSDEFValueRule);
            }
            this.onFillParentInfo_PSDEFValueRule(pSDEVRGrpDetail, pSDEFValueRule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVRGRPDETAIL_PSDEVRGROUP_PSDEVRGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEVRGroupService", (SessionFactory)this.getSessionFactory());
            PSDEVRGroup pSDEVRGroup = (PSDEVRGroup)iService.getDEModel().createEntity();
            pSDEVRGroup.set("PSDEVRGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEVRGroup);
            } else {
                iService.get((IEntity)pSDEVRGroup);
            }
            this.onFillParentInfo_PSDEVRGroup(pSDEVRGrpDetail, pSDEVRGroup);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEVRGrpDetail, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEFValueRule(PSDEVRGrpDetail pSDEVRGrpDetail, PSDEFValueRule pSDEFValueRule) throws Exception {
        pSDEVRGrpDetail.setPSDEFValueRuleId(pSDEFValueRule.getPSDEFValueRuleId());
        pSDEVRGrpDetail.setPSDEFValueRuleName(pSDEFValueRule.getPSDEFValueRuleName());
    }

    protected void onFillParentInfo_PSDEVRGroup(PSDEVRGrpDetail pSDEVRGrpDetail, PSDEVRGroup pSDEVRGroup) throws Exception {
        pSDEVRGrpDetail.setPSDEId(pSDEVRGroup.getPSDEId());
        pSDEVRGrpDetail.setPSDEVRGroupId(pSDEVRGroup.getPSDEVRGroupId());
        pSDEVRGrpDetail.setPSDEVRGroupName(pSDEVRGroup.getPSDEVRGroupName());
    }

    protected void onFillEntityFullInfo(PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl) throws Exception {
        if (bl && pSDEVRGrpDetail.getValidFlag() == null) {
            pSDEVRGrpDetail.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDEVRGrpDetail, bl);
        this.onFillEntityFullInfo_PSDEFValueRule(pSDEVRGrpDetail, bl);
        this.onFillEntityFullInfo_PSDEVRGroup(pSDEVRGrpDetail, bl);
    }

    protected void onFillEntityFullInfo_PSDEFValueRule(PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEVRGroup(PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEVRGrpDetail, bl);
    }

    public ArrayList<PSDEVRGrpDetail> selectByPSDEFValueRule(PSDEFValueRuleBase pSDEFValueRuleBase) throws Exception {
        return this.selectByPSDEFValueRule(pSDEFValueRuleBase, "", -1);
    }

    public ArrayList<PSDEVRGrpDetail> selectByPSDEFValueRule(PSDEFValueRuleBase pSDEFValueRuleBase, String string) throws Exception {
        return this.selectByPSDEFValueRule(pSDEFValueRuleBase, string, -1);
    }

    public ArrayList<PSDEVRGrpDetail> selectByPSDEFValueRule(PSDEFValueRuleBase pSDEFValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFVALUERULEID", (Object)pSDEFValueRuleBase.getPSDEFValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFValueRuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFValueRuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEVRGrpDetail> selectByPSDEVRGroup(PSDEVRGroupBase pSDEVRGroupBase) throws Exception {
        return this.selectByPSDEVRGroup(pSDEVRGroupBase, "", -1);
    }

    public ArrayList<PSDEVRGrpDetail> selectByPSDEVRGroup(PSDEVRGroupBase pSDEVRGroupBase, String string) throws Exception {
        return this.selectByPSDEVRGroup(pSDEVRGroupBase, string, -1);
    }

    public ArrayList<PSDEVRGrpDetail> selectByPSDEVRGroup(PSDEVRGroupBase pSDEVRGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVRGROUPID", (Object)pSDEVRGroupBase.getPSDEVRGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEVRGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEVRGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEVRGrpDetail> selectTempByPSDEVRGroup(PSDEVRGroupBase pSDEVRGroupBase) throws Exception {
        return this.selectTempByPSDEVRGroup(pSDEVRGroupBase, "");
    }

    public ArrayList<PSDEVRGrpDetail> selectTempByPSDEVRGroup(PSDEVRGroupBase pSDEVRGroupBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVRGROUPID", (Object)pSDEVRGroupBase.getPSDEVRGroupId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEVRGroupCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEVRGroupCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEVRGrpDetail> arrayList = this.selectByPSDEFValueRule(pSDEFValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEFValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVRGRPDETAIL_PSDEFVALUERULE_PSDEFVALUERULEID", "", iDataEntityModel.getName(), "PSDEVRGRPDETAIL", iDataEntityModel.getDataInfo((IEntity)pSDEFValueRule), arrayList.get(0)));
        }
    }

    public void resetPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEVRGrpDetail> arrayList = this.selectByPSDEFValueRule(pSDEFValueRule);
        for (PSDEVRGrpDetail pSDEVRGrpDetail : arrayList) {
            PSDEVRGrpDetail pSDEVRGrpDetail2 = (PSDEVRGrpDetail)this.getDEModel().createEntity();
            pSDEVRGrpDetail2.setPSDEVRGrpDetailId(pSDEVRGrpDetail.getPSDEVRGrpDetailId());
            pSDEVRGrpDetail2.setPSDEFValueRuleId(null);
            this.update(pSDEVRGrpDetail2);
        }
    }

    public void removeByPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
        final PSDEFValueRule pSDEFValueRule2 = pSDEFValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEVRGrpDetailServiceBase.this.onBeforeRemoveByPSDEFValueRule(pSDEFValueRule2);
                PSDEVRGrpDetailServiceBase.this.internalRemoveByPSDEFValueRule(pSDEFValueRule2);
                PSDEVRGrpDetailServiceBase.this.onAfterRemoveByPSDEFValueRule(pSDEFValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void internalRemoveByPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEVRGrpDetail> arrayList = this.selectByPSDEFValueRule(pSDEFValueRule);
        this.onBeforeRemoveByPSDEFValueRule(pSDEFValueRule, arrayList);
        for (PSDEVRGrpDetail pSDEVRGrpDetail : arrayList) {
            this.remove((IEntity)pSDEVRGrpDetail);
        }
        this.onAfterRemoveByPSDEFValueRule(pSDEFValueRule, arrayList);
    }

    protected void onAfterRemoveByPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFValueRule(PSDEFValueRule pSDEFValueRule, ArrayList<PSDEVRGrpDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFValueRule(PSDEFValueRule pSDEFValueRule, ArrayList<PSDEVRGrpDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
    }

    public void resetPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
        ArrayList<PSDEVRGrpDetail> arrayList = this.selectByPSDEVRGroup(pSDEVRGroup);
        for (PSDEVRGrpDetail pSDEVRGrpDetail : arrayList) {
            PSDEVRGrpDetail pSDEVRGrpDetail2 = (PSDEVRGrpDetail)this.getDEModel().createEntity();
            pSDEVRGrpDetail2.setPSDEVRGrpDetailId(pSDEVRGrpDetail.getPSDEVRGrpDetailId());
            pSDEVRGrpDetail2.setPSDEVRGroupId(null);
            this.update(pSDEVRGrpDetail2);
        }
    }

    public void resetTempPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
        ArrayList<PSDEVRGrpDetail> arrayList = this.selectTempByPSDEVRGroup(pSDEVRGroup);
        for (PSDEVRGrpDetail pSDEVRGrpDetail : arrayList) {
            PSDEVRGrpDetail pSDEVRGrpDetail2 = (PSDEVRGrpDetail)this.getDEModel().createEntity();
            pSDEVRGrpDetail2.setPSDEVRGrpDetailId(pSDEVRGrpDetail.getPSDEVRGrpDetailId());
            pSDEVRGrpDetail2.setPSDEVRGroupId(null);
            this.updateTemp((IEntity)pSDEVRGrpDetail2);
        }
    }

    public void removeByPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
        final PSDEVRGroup pSDEVRGroup2 = pSDEVRGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEVRGrpDetailServiceBase.this.onBeforeRemoveByPSDEVRGroup(pSDEVRGroup2);
                PSDEVRGrpDetailServiceBase.this.internalRemoveByPSDEVRGroup(pSDEVRGroup2);
                PSDEVRGrpDetailServiceBase.this.onAfterRemoveByPSDEVRGroup(pSDEVRGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
    }

    protected void internalRemoveByPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
        ArrayList<PSDEVRGrpDetail> arrayList = this.selectByPSDEVRGroup(pSDEVRGroup);
        this.onBeforeRemoveByPSDEVRGroup(pSDEVRGroup, arrayList);
        for (PSDEVRGrpDetail pSDEVRGrpDetail : arrayList) {
            this.remove((IEntity)pSDEVRGrpDetail);
        }
        this.onAfterRemoveByPSDEVRGroup(pSDEVRGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEVRGroup(PSDEVRGroup pSDEVRGroup, ArrayList<PSDEVRGrpDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEVRGroup(PSDEVRGroup pSDEVRGroup, ArrayList<PSDEVRGrpDetail> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEVRGrpDetail pSDEVRGrpDetail) throws Exception {
        super.onBeforeRemove(pSDEVRGrpDetail);
    }

    public void removeTempByPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
        final PSDEVRGroup pSDEVRGroup2 = pSDEVRGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEVRGrpDetailServiceBase.this.onBeforeRemoveTempByPSDEVRGroup(pSDEVRGroup2);
                PSDEVRGrpDetailServiceBase.this.internalRemoveTempByPSDEVRGroup(pSDEVRGroup2);
                PSDEVRGrpDetailServiceBase.this.onAfterRemoveTempByPSDEVRGroup(pSDEVRGroup2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
    }

    protected void internalRemoveTempByPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
        ArrayList<PSDEVRGrpDetail> arrayList = this.selectTempByPSDEVRGroup(pSDEVRGroup);
        this.onBeforeRemoveTempByPSDEVRGroup(pSDEVRGroup, arrayList);
        for (PSDEVRGrpDetail pSDEVRGrpDetail : arrayList) {
            this.removeTemp((IEntity)pSDEVRGrpDetail);
        }
        this.onAfterRemoveTempByPSDEVRGroup(pSDEVRGroup, arrayList);
    }

    protected void onAfterRemoveTempByPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEVRGroup(PSDEVRGroup pSDEVRGroup, ArrayList<PSDEVRGrpDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEVRGroup(PSDEVRGroup pSDEVRGroup, ArrayList<PSDEVRGrpDetail> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEVRGrpDetail pSDEVRGrpDetail, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEVRGrpDetail, cloneSession);
        if (pSDEVRGrpDetail.getPSDEFValueRuleId() != null && (iEntity = cloneSession.getEntity("PSDEFVALUERULE", (Object)pSDEVRGrpDetail.getPSDEFValueRuleId())) != null) {
            this.onFillParentInfo_PSDEFValueRule(pSDEVRGrpDetail, (PSDEFValueRule)iEntity);
        }
        if (pSDEVRGrpDetail.getPSDEVRGroupId() != null && (iEntity = cloneSession.getEntity("PSDEVRGROUP", (Object)pSDEVRGrpDetail.getPSDEVRGroupId())) != null) {
            this.onFillParentInfo_PSDEVRGroup(pSDEVRGrpDetail, (PSDEVRGroup)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEVRGrpDetail, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DetailParam(bl, pSDEVRGrpDetail, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailParam2(bl, pSDEVRGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEVRGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEVRGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFValueRuleId(bl, pSDEVRGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEVRGroupId(bl, pSDEVRGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEVRGrpDetailId(bl, pSDEVRGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEVRGrpDetailName(bl, pSDEVRGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEVRGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEVRGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEVRGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEVRGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEVRGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEVRGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEVRGrpDetail, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DetailParam(boolean bl, PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGrpDetail.isDetailParamDirty() : !pSDEVRGrpDetail.isDetailParamDirty()) {
            return null;
        }
        String string = pSDEVRGrpDetail.getDetailParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailParam_Default((IEntity)pSDEVRGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DetailParam2(boolean bl, PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGrpDetail.isDetailParam2Dirty() : !pSDEVRGrpDetail.isDetailParam2Dirty()) {
            return null;
        }
        String string = pSDEVRGrpDetail.getDetailParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailParam2_Default((IEntity)pSDEVRGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGrpDetail.isMemoDirty() : !pSDEVRGrpDetail.isMemoDirty()) {
            return null;
        }
        String string = pSDEVRGrpDetail.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEVRGrpDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGrpDetail.isOrderValueDirty() : !pSDEVRGrpDetail.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEVRGrpDetail.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEVRGrpDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFValueRuleId(boolean bl, PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGrpDetail.isPSDEFValueRuleIdDirty() && !bl2 : !pSDEVRGrpDetail.isPSDEFValueRuleIdDirty()) {
            return null;
        }
        String string = pSDEVRGrpDetail.getPSDEFValueRuleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVALUERULEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFValueRuleId_Default((IEntity)pSDEVRGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVALUERULEID");
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
                string3 = "PSDEVRGROUPID";
                String string4 = this.checkFieldDupRule(this.getPSDEVRGrpDetailDEModel(), "PSDEFVALUERULEID", string3, pSDEVRGrpDetail, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEFVALUERULEID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEVRGroupId(boolean bl, PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGrpDetail.isPSDEVRGroupIdDirty() && !bl2 : !pSDEVRGrpDetail.isPSDEVRGroupIdDirty()) {
            return null;
        }
        String string = pSDEVRGrpDetail.getPSDEVRGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVRGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEVRGroupId_Default((IEntity)pSDEVRGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVRGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEVRGrpDetailId(boolean bl, PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGrpDetail.isPSDEVRGrpDetailIdDirty() && !bl2 : !pSDEVRGrpDetail.isPSDEVRGrpDetailIdDirty()) {
            return null;
        }
        String string = pSDEVRGrpDetail.getPSDEVRGrpDetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVRGRPDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEVRGrpDetailId_Default((IEntity)pSDEVRGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVRGRPDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEVRGrpDetailName(boolean bl, PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGrpDetail.isPSDEVRGrpDetailNameDirty() && !bl2 : !pSDEVRGrpDetail.isPSDEVRGrpDetailNameDirty()) {
            return null;
        }
        String string = pSDEVRGrpDetail.getPSDEVRGrpDetailName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVRGRPDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEVRGrpDetailName_Default((IEntity)pSDEVRGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVRGRPDETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGrpDetail.isUserCatDirty() : !pSDEVRGrpDetail.isUserCatDirty()) {
            return null;
        }
        String string = pSDEVRGrpDetail.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEVRGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGrpDetail.isUserTagDirty() : !pSDEVRGrpDetail.isUserTagDirty()) {
            return null;
        }
        String string = pSDEVRGrpDetail.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEVRGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGrpDetail.isUserTag2Dirty() : !pSDEVRGrpDetail.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEVRGrpDetail.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEVRGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGrpDetail.isUserTag3Dirty() : !pSDEVRGrpDetail.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEVRGrpDetail.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEVRGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGrpDetail.isUserTag4Dirty() : !pSDEVRGrpDetail.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEVRGrpDetail.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEVRGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGrpDetail.isValidFlagDirty() && !bl2 : !pSDEVRGrpDetail.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEVRGrpDetail.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDEVRGrpDetail, bl2, bl3);
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

    protected void onSyncEntity(PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEVRGrpDetail, bl);
    }

    protected void onSyncIndexEntities(PSDEVRGrpDetail pSDEVRGrpDetail, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEVRGrpDetail, bl);
    }

    public Object getDataContextValue(PSDEVRGrpDetail pSDEVRGrpDetail, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEVRGrpDetail, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEFValueRule pSDEFValueRule = pSDEVRGrpDetail.getPSDEFValueRule();
        if (pSDEFValueRule != null && pSDEFValueRule.contains(string)) {
            return pSDEFValueRule.get(string);
        }
        PSDEVRGroup pSDEVRGroup = pSDEVRGrpDetail.getPSDEVRGroup();
        if (pSDEVRGroup != null && pSDEVRGroup.contains(string)) {
            return pSDEVRGroup.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEVRGrpDetail pSDEVRGrpDetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEVRGrpDetail, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVALUERULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFValueRuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVALUERULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFValueRuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVRGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEVRGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVRGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEVRGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVRGRPDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEVRGrpDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVRGRPDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEVRGrpDetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DetailParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILPARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DetailParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILPARAM2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEFValueRuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVALUERULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFValueRuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVALUERULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEVRGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVRGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEVRGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVRGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEVRGrpDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVRGRPDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEVRGrpDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVRGRPDETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected boolean onMergeChild(String string, String string2, PSDEVRGrpDetail pSDEVRGrpDetail) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEVRGrpDetail)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEVRGrpDetail pSDEVRGrpDetail) throws Exception {
        super.onUpdateParent((IEntity)pSDEVRGrpDetail);
    }

    @Override
    protected void exportCurXmlModel(PSDEVRGrpDetail pSDEVRGrpDetail, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVRGRPDETAIL");
        if (!bl) {
            pSDEVRGrpDetail.setCreateDate(null);
            pSDEVRGrpDetail.setCreateMan(null);
            pSDEVRGrpDetail.setPSDEVRGrpDetailId(null);
            pSDEVRGrpDetail.setUpdateDate(null);
            pSDEVRGrpDetail.setUpdateMan(null);
            pSDEVRGrpDetail.setPSDEId(null);
            pSDEVRGrpDetail.setPSDEVRGroupId(null);
            pSDEVRGrpDetail.setPSDEVRGroupName(null);
            super.exportCurXmlModel(pSDEVRGrpDetail, xmlNode, bl);
        }
    }
}

