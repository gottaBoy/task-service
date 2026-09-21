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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDERGroupDetailDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDERGroupDetailDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERGroupDetail;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDERGroupDetailServiceBase
extends PSCoreSysServiceBase<PSDERGroupDetail> {
    private static final Log log = LogFactory.getLog(PSDERGroupDetailServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDERGroupDetailDEModel pSDERGroupDetailDEModel;
    private PSDERGroupDetailDAO pSDERGroupDetailDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupDetailService";
    }

    public PSDERGroupDetailDEModel getPSDERGroupDetailDEModel() {
        if (this.pSDERGroupDetailDEModel == null) {
            try {
                this.pSDERGroupDetailDEModel = (PSDERGroupDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDERGroupDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDERGroupDetailDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDERGroupDetailDEModel();
    }

    public PSDERGroupDetailDAO getPSDERGroupDetailDAO() {
        if (this.pSDERGroupDetailDAO == null) {
            try {
                this.pSDERGroupDetailDAO = (PSDERGroupDetailDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDERGroupDetailDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDERGroupDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDERGroupDetailDAO();
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

    protected void onFillParentInfo(PSDERGroupDetail pSDERGroupDetail, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDERGROUPDETAIL_PSDERGROUP_PSDERGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupService", (SessionFactory)this.getSessionFactory());
            PSDERGroup pSDERGroup = (PSDERGroup)iService.getDEModel().createEntity();
            pSDERGroup.set("PSDERGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDERGroup);
            } else {
                iService.get((IEntity)pSDERGroup);
            }
            this.onFillParentInfo_PSDERGroup(pSDERGroupDetail, pSDERGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDERGROUPDETAIL_PSDER_PSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDER);
            } else {
                iService.get((IEntity)pSDER);
            }
            this.onFillParentInfo_PSDER(pSDERGroupDetail, pSDER);
            return;
        }
        super.onFillParentInfo((IEntity)pSDERGroupDetail, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDERGroup(PSDERGroupDetail pSDERGroupDetail, PSDERGroup pSDERGroup) throws Exception {
        pSDERGroupDetail.setPSDERGroupId(pSDERGroup.getPSDERGroupId());
        pSDERGroupDetail.setPSDERGroupName(pSDERGroup.getPSDERGroupName());
    }

    protected void onFillParentInfo_PSDER(PSDERGroupDetail pSDERGroupDetail, PSDER pSDER) throws Exception {
        pSDERGroupDetail.setPSDERId(pSDER.getPSDERId());
        pSDERGroupDetail.setPSDERName(pSDER.getPSDERName());
    }

    protected void onFillEntityFullInfo(PSDERGroupDetail pSDERGroupDetail, boolean bl) throws Exception {
        if (bl) {
            if (pSDERGroupDetail.getOrderValue() == null) {
                pSDERGroupDetail.setOrderValue((Integer)this.getDefaultValue(this.getWebContext(), "", "1000", 9));
            }
            if (pSDERGroupDetail.getValidFlag() == null) {
                pSDERGroupDetail.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDERGroupDetail, bl);
        this.onFillEntityFullInfo_PSDERGroup(pSDERGroupDetail, bl);
        this.onFillEntityFullInfo_PSDER(pSDERGroupDetail, bl);
    }

    protected void onFillEntityFullInfo_PSDERGroup(PSDERGroupDetail pSDERGroupDetail, boolean bl) throws Exception {
        if (pSDERGroupDetail.isPSDERGroupIdDirty()) {
            if (pSDERGroupDetail.getPSDERGroupId() != null) {
                if (pSDERGroupDetail.getPSDERGroupId() == null || pSDERGroupDetail.getPSDERGroupName() == null) {
                    PSDERGroup pSDERGroup = pSDERGroupDetail.getPSDERGroup();
                    pSDERGroupDetail.setPSDERGroupName(pSDERGroup.getPSDERGroupName());
                }
            } else {
                pSDERGroupDetail.setPSDERGroupName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDER(PSDERGroupDetail pSDERGroupDetail, boolean bl) throws Exception {
        if (pSDERGroupDetail.isPSDERIdDirty()) {
            if (pSDERGroupDetail.getPSDERId() != null) {
                if (pSDERGroupDetail.getPSDERId() == null || pSDERGroupDetail.getPSDERName() == null) {
                    PSDER pSDER = pSDERGroupDetail.getPSDER();
                    pSDERGroupDetail.setPSDERName(pSDER.getPSDERName());
                }
            } else {
                pSDERGroupDetail.setPSDERName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDERGroupDetail pSDERGroupDetail, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDERGroupDetail, bl);
    }

    public ArrayList<PSDERGroupDetail> selectByPSDERGroup(PSDERGroupBase pSDERGroupBase) throws Exception {
        return this.selectByPSDERGroup(pSDERGroupBase, "", -1);
    }

    public ArrayList<PSDERGroupDetail> selectByPSDERGroup(PSDERGroupBase pSDERGroupBase, String string) throws Exception {
        return this.selectByPSDERGroup(pSDERGroupBase, string, -1);
    }

    public ArrayList<PSDERGroupDetail> selectByPSDERGroup(PSDERGroupBase pSDERGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDERGROUPID", (Object)pSDERGroupBase.getPSDERGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDERGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDERGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDERGroupDetail> selectTempByPSDERGroup(PSDERGroupBase pSDERGroupBase) throws Exception {
        return this.selectTempByPSDERGroup(pSDERGroupBase, "");
    }

    public ArrayList<PSDERGroupDetail> selectTempByPSDERGroup(PSDERGroupBase pSDERGroupBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDERGROUPID", (Object)pSDERGroupBase.getPSDERGroupId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDERGroupCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDERGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDERGroupDetail> selectByPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDERGroupDetail> selectByPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDERGroupDetail> selectByPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDERCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDERGroup(PSDERGroup pSDERGroup) throws Exception {
    }

    public void resetPSDERGroup(PSDERGroup pSDERGroup) throws Exception {
        ArrayList<PSDERGroupDetail> arrayList = this.selectByPSDERGroup(pSDERGroup);
        for (PSDERGroupDetail pSDERGroupDetail : arrayList) {
            PSDERGroupDetail pSDERGroupDetail2 = (PSDERGroupDetail)this.getDEModel().createEntity();
            pSDERGroupDetail2.setPSDERGroupDetailId(pSDERGroupDetail.getPSDERGroupDetailId());
            pSDERGroupDetail2.setPSDERGroupId(null);
            this.update(pSDERGroupDetail2);
        }
    }

    public void resetTempPSDERGroup(PSDERGroup pSDERGroup) throws Exception {
        ArrayList<PSDERGroupDetail> arrayList = this.selectTempByPSDERGroup(pSDERGroup);
        for (PSDERGroupDetail pSDERGroupDetail : arrayList) {
            PSDERGroupDetail pSDERGroupDetail2 = (PSDERGroupDetail)this.getDEModel().createEntity();
            pSDERGroupDetail2.setPSDERGroupDetailId(pSDERGroupDetail.getPSDERGroupDetailId());
            pSDERGroupDetail2.setPSDERGroupId(null);
            this.updateTemp((IEntity)pSDERGroupDetail2);
        }
    }

    public void removeByPSDERGroup(PSDERGroup pSDERGroup) throws Exception {
        final PSDERGroup pSDERGroup2 = pSDERGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERGroupDetailServiceBase.this.onBeforeRemoveByPSDERGroup(pSDERGroup2);
                PSDERGroupDetailServiceBase.this.internalRemoveByPSDERGroup(pSDERGroup2);
                PSDERGroupDetailServiceBase.this.onAfterRemoveByPSDERGroup(pSDERGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDERGroup(PSDERGroup pSDERGroup) throws Exception {
    }

    protected void internalRemoveByPSDERGroup(PSDERGroup pSDERGroup) throws Exception {
        ArrayList<PSDERGroupDetail> arrayList = this.selectByPSDERGroup(pSDERGroup);
        this.onBeforeRemoveByPSDERGroup(pSDERGroup, arrayList);
        for (PSDERGroupDetail pSDERGroupDetail : arrayList) {
            this.remove((IEntity)pSDERGroupDetail);
        }
        this.onAfterRemoveByPSDERGroup(pSDERGroup, arrayList);
    }

    protected void onAfterRemoveByPSDERGroup(PSDERGroup pSDERGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDERGroup(PSDERGroup pSDERGroup, ArrayList<PSDERGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDERGroup(PSDERGroup pSDERGroup, ArrayList<PSDERGroupDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDERGroupDetail> arrayList = this.selectByPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDERGROUPDETAIL_PSDER_PSDERID", "", iDataEntityModel.getName(), "PSDERGROUPDETAIL", iDataEntityModel.getDataInfo((IEntity)pSDER), arrayList.get(0)));
        }
    }

    public void resetPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDERGroupDetail> arrayList = this.selectByPSDER(pSDER);
        for (PSDERGroupDetail pSDERGroupDetail : arrayList) {
            PSDERGroupDetail pSDERGroupDetail2 = (PSDERGroupDetail)this.getDEModel().createEntity();
            pSDERGroupDetail2.setPSDERGroupDetailId(pSDERGroupDetail.getPSDERGroupDetailId());
            pSDERGroupDetail2.setPSDERId(null);
            this.update(pSDERGroupDetail2);
        }
    }

    public void removeByPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERGroupDetailServiceBase.this.onBeforeRemoveByPSDER(pSDER2);
                PSDERGroupDetailServiceBase.this.internalRemoveByPSDER(pSDER2);
                PSDERGroupDetailServiceBase.this.onAfterRemoveByPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDERGroupDetail> arrayList = this.selectByPSDER(pSDER);
        this.onBeforeRemoveByPSDER(pSDER, arrayList);
        for (PSDERGroupDetail pSDERGroupDetail : arrayList) {
            this.remove((IEntity)pSDERGroupDetail);
        }
        this.onAfterRemoveByPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER, ArrayList<PSDERGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER, ArrayList<PSDERGroupDetail> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDERGroupDetail pSDERGroupDetail) throws Exception {
        super.onBeforeRemove(pSDERGroupDetail);
    }

    public void removeTempByPSDERGroup(PSDERGroup pSDERGroup) throws Exception {
        final PSDERGroup pSDERGroup2 = pSDERGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERGroupDetailServiceBase.this.onBeforeRemoveTempByPSDERGroup(pSDERGroup2);
                PSDERGroupDetailServiceBase.this.internalRemoveTempByPSDERGroup(pSDERGroup2);
                PSDERGroupDetailServiceBase.this.onAfterRemoveTempByPSDERGroup(pSDERGroup2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDERGroup(PSDERGroup pSDERGroup) throws Exception {
    }

    protected void internalRemoveTempByPSDERGroup(PSDERGroup pSDERGroup) throws Exception {
        ArrayList<PSDERGroupDetail> arrayList = this.selectTempByPSDERGroup(pSDERGroup);
        this.onBeforeRemoveTempByPSDERGroup(pSDERGroup, arrayList);
        for (PSDERGroupDetail pSDERGroupDetail : arrayList) {
            this.removeTemp((IEntity)pSDERGroupDetail);
        }
        this.onAfterRemoveTempByPSDERGroup(pSDERGroup, arrayList);
    }

    protected void onAfterRemoveTempByPSDERGroup(PSDERGroup pSDERGroup) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDERGroup(PSDERGroup pSDERGroup, ArrayList<PSDERGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDERGroup(PSDERGroup pSDERGroup, ArrayList<PSDERGroupDetail> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDERGroupDetail pSDERGroupDetail, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDERGroupDetail, cloneSession);
        if (pSDERGroupDetail.getPSDERGroupId() != null && (iEntity = cloneSession.getEntity("PSDERGROUP", (Object)pSDERGroupDetail.getPSDERGroupId())) != null) {
            this.onFillParentInfo_PSDERGroup(pSDERGroupDetail, (PSDERGroup)iEntity);
        }
        if (pSDERGroupDetail.getPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDERGroupDetail.getPSDERId())) != null) {
            this.onFillParentInfo_PSDER(pSDERGroupDetail, (PSDER)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDERGroupDetail pSDERGroupDetail, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDERGroupDetail, bl);
    }

    protected void onCheckEntity(boolean bl, PSDERGroupDetail pSDERGroupDetail, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDERGroupDetail, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName2(bl, pSDERGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data(bl, pSDERGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailTag(bl, pSDERGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailTag2(bl, pSDERGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDERGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDERGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERGroupDetailId(bl, pSDERGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERGroupDetailName(bl, pSDERGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERGroupId(bl, pSDERGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERGroupName(bl, pSDERGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERId(bl, pSDERGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERName(bl, pSDERGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDERGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDERGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDERGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDERGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDERGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDERGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDERGroupDetail, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDERGroupDetail pSDERGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERGroupDetail.isCodeNameDirty() : !pSDERGroupDetail.isCodeNameDirty()) {
            return null;
        }
        String string = pSDERGroupDetail.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDERGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
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
                string3 = "PSDERGROUPID";
                String string4 = this.checkFieldDupRule(this.getPSDERGroupDetailDEModel(), "CODENAME", string3, pSDERGroupDetail, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName2(boolean bl, PSDERGroupDetail pSDERGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERGroupDetail.isCodeName2Dirty() : !pSDERGroupDetail.isCodeName2Dirty()) {
            return null;
        }
        String string = pSDERGroupDetail.getCodeName2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName2_Default((IEntity)pSDERGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME2");
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
                string3 = "PSDERGROUPID";
                String string4 = this.checkFieldDupRule(this.getPSDERGroupDetailDEModel(), "CODENAME2", string3, pSDERGroupDetail, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME2");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Data(boolean bl, PSDERGroupDetail pSDERGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERGroupDetail.isDataDirty() : !pSDERGroupDetail.isDataDirty()) {
            return null;
        }
        String string = pSDERGroupDetail.getData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data_Default((IEntity)pSDERGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DetailTag(boolean bl, PSDERGroupDetail pSDERGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERGroupDetail.isDetailTagDirty() : !pSDERGroupDetail.isDetailTagDirty()) {
            return null;
        }
        String string = pSDERGroupDetail.getDetailTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailTag_Default((IEntity)pSDERGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DetailTag2(boolean bl, PSDERGroupDetail pSDERGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERGroupDetail.isDetailTag2Dirty() : !pSDERGroupDetail.isDetailTag2Dirty()) {
            return null;
        }
        String string = pSDERGroupDetail.getDetailTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailTag2_Default((IEntity)pSDERGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDERGroupDetail pSDERGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERGroupDetail.isMemoDirty() : !pSDERGroupDetail.isMemoDirty()) {
            return null;
        }
        String string = pSDERGroupDetail.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDERGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDERGroupDetail pSDERGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERGroupDetail.isOrderValueDirty() : !pSDERGroupDetail.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDERGroupDetail.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDERGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERGroupDetailId(boolean bl, PSDERGroupDetail pSDERGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERGroupDetail.isPSDERGroupDetailIdDirty() && !bl2 : !pSDERGroupDetail.isPSDERGroupDetailIdDirty()) {
            return null;
        }
        String string = pSDERGroupDetail.getPSDERGroupDetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERGROUPDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERGroupDetailId_Default((IEntity)pSDERGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERGROUPDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERGroupDetailName(boolean bl, PSDERGroupDetail pSDERGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERGroupDetail.isPSDERGroupDetailNameDirty() && !bl2 : !pSDERGroupDetail.isPSDERGroupDetailNameDirty()) {
            return null;
        }
        String string = pSDERGroupDetail.getPSDERGroupDetailName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERGROUPDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERGroupDetailName_Default((IEntity)pSDERGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERGROUPDETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDERGROUPID";
                String string4 = this.checkFieldDupRule(this.getPSDERGroupDetailDEModel(), "PSDERGROUPDETAILNAME", string3, pSDERGroupDetail, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDERGROUPDETAILNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERGroupId(boolean bl, PSDERGroupDetail pSDERGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERGroupDetail.isPSDERGroupIdDirty() && !bl2 : !pSDERGroupDetail.isPSDERGroupIdDirty()) {
            return null;
        }
        String string = pSDERGroupDetail.getPSDERGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERGroupId_Default((IEntity)pSDERGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERGroupName(boolean bl, PSDERGroupDetail pSDERGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERGroupDetail.isPSDERGroupNameDirty() : !pSDERGroupDetail.isPSDERGroupNameDirty()) {
            return null;
        }
        String string = pSDERGroupDetail.getPSDERGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERGroupName_Default((IEntity)pSDERGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERGROUPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERId(boolean bl, PSDERGroupDetail pSDERGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERGroupDetail.isPSDERIdDirty() && !bl2 : !pSDERGroupDetail.isPSDERIdDirty()) {
            return null;
        }
        String string = pSDERGroupDetail.getPSDERId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERId_Default((IEntity)pSDERGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDERGROUPID";
                String string4 = this.checkFieldDupRule(this.getPSDERGroupDetailDEModel(), "PSDERID", string3, pSDERGroupDetail, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDERID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERName(boolean bl, PSDERGroupDetail pSDERGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERGroupDetail.isPSDERNameDirty() && !bl2 : !pSDERGroupDetail.isPSDERNameDirty()) {
            return null;
        }
        String string = pSDERGroupDetail.getPSDERName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERName_Default((IEntity)pSDERGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDERGroupDetail pSDERGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERGroupDetail.isUserCatDirty() : !pSDERGroupDetail.isUserCatDirty()) {
            return null;
        }
        String string = pSDERGroupDetail.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDERGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDERGroupDetail pSDERGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERGroupDetail.isUserTagDirty() : !pSDERGroupDetail.isUserTagDirty()) {
            return null;
        }
        String string = pSDERGroupDetail.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDERGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDERGroupDetail pSDERGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERGroupDetail.isUserTag2Dirty() : !pSDERGroupDetail.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDERGroupDetail.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDERGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDERGroupDetail pSDERGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERGroupDetail.isUserTag3Dirty() : !pSDERGroupDetail.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDERGroupDetail.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDERGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDERGroupDetail pSDERGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERGroupDetail.isUserTag4Dirty() : !pSDERGroupDetail.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDERGroupDetail.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDERGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDERGroupDetail pSDERGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERGroupDetail.isValidFlagDirty() && !bl2 : !pSDERGroupDetail.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDERGroupDetail.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDERGroupDetail, bl2, bl3);
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

    protected void onSyncEntity(PSDERGroupDetail pSDERGroupDetail, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDERGroupDetail, bl);
    }

    protected void onSyncIndexEntities(PSDERGroupDetail pSDERGroupDetail, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDERGroupDetail, bl);
    }

    public Object getDataContextValue(PSDERGroupDetail pSDERGroupDetail, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDERGroupDetail, string, iDataContextParam)) != null) {
            return object;
        }
        PSDERGroup pSDERGroup = pSDERGroupDetail.getPSDERGroup();
        if (pSDERGroup != null && pSDERGroup.contains(string)) {
            return pSDERGroup.get(string);
        }
        PSDER pSDER = pSDERGroupDetail.getPSDER();
        if (pSDER != null && pSDER.contains(string)) {
            return pSDER.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDERGroupDetail pSDERGroupDetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDERGroupDetail, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Data_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERGROUPDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERGroupDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERGROUPDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERGroupDetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME2", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME2", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_Data_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATA", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DetailTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DetailTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDERGroupDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERGROUPDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERGroupDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERGROUPDETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDERGroupDetail pSDERGroupDetail) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDERGroupDetail)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDERGroupDetail pSDERGroupDetail) throws Exception {
        super.onUpdateParent((IEntity)pSDERGroupDetail);
    }

    @Override
    protected void exportCurXmlModel(PSDERGroupDetail pSDERGroupDetail, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDERGROUPDETAIL");
        if (!bl) {
            pSDERGroupDetail.setCreateDate(null);
            pSDERGroupDetail.setCreateMan(null);
            pSDERGroupDetail.setPSDERGroupDetailId(null);
            pSDERGroupDetail.setUpdateDate(null);
            pSDERGroupDetail.setUpdateMan(null);
            pSDERGroupDetail.setPSDERGroupId(null);
            pSDERGroupDetail.setPSDERGroupName(null);
            super.exportCurXmlModel(pSDERGroupDetail, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDERGroupDetail pSDERGroupDetail, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDERGroupDetail, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDERGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDERGROUP#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDERGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDERGROUPDETAIL_PSDERGROUP_PSDERGROUPID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDERGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDERGROUPNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDERGROUP", (boolean)true) == 0) {
            iEntity.set("PSDERGROUPID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDERGROUPID"};
    }

    @Override
    public String getModelV2Tag(PSDERGroupDetail pSDERGroupDetail) {
        if (!StringHelper.isNullOrEmpty((String)pSDERGroupDetail.getPSDERGroupDetailName())) {
            return pSDERGroupDetail.getPSDERGroupDetailName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDERGroupDetail.getCodeName())) {
            return pSDERGroupDetail.getCodeName();
        }
        return super.getModelV2Tag(pSDERGroupDetail);
    }

    @Override
    public boolean setModelV2Tag(PSDERGroupDetail pSDERGroupDetail, String string) {
        pSDERGroupDetail.setPSDERGroupDetailName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDERGROUPDETAILNAME", "");
        map.put("CODENAME", "");
        map.put("PSDERGROUPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDERGroupDetail pSDERGroupDetail, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDERGroupDetail.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDERGroupDetail, true);
        pSDERGroupDetail.set("PSDERGROUPDETAILNAME", string);
        if (this.select(pSDERGroupDetail, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDERGroupDetail, true);
        return super.getModelV2Entity(pSDERGroupDetail, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDERGroupDetail pSDERGroupDetail, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDERGroupDetail, objectNode, string, string2, n);
    }
}

