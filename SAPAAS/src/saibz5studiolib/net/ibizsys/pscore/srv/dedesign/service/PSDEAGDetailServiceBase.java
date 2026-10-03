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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEAGDetailDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEAGDetailDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAGDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEAGDetailServiceBase
extends PSCoreSysServiceBase<PSDEAGDetail> {
    private static final Log log = LogFactory.getLog(PSDEAGDetailServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEAGDetailDEModel pSDEAGDetailDEModel;
    private PSDEAGDetailDAO pSDEAGDetailDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEAGDetailService";
    }

    public PSDEAGDetailDEModel getPSDEAGDetailDEModel() {
        if (this.pSDEAGDetailDEModel == null) {
            try {
                this.pSDEAGDetailDEModel = (PSDEAGDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEAGDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEAGDetailDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEAGDetailDEModel();
    }

    public PSDEAGDetailDAO getPSDEAGDetailDAO() {
        if (this.pSDEAGDetailDAO == null) {
            try {
                this.pSDEAGDetailDAO = (PSDEAGDetailDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEAGDetailDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEAGDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEAGDetailDAO();
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

    protected void onFillParentInfo(PSDEAGDetail pSDEAGDetail, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEAGDETAIL_PSDEACTIONGROUP_PSDEACTIONGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionGroupService", (SessionFactory)this.getSessionFactory());
            PSDEActionGroup pSDEActionGroup = (PSDEActionGroup)iService.getDEModel().createEntity();
            pSDEActionGroup.set("PSDEACTIONGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEActionGroup);
            } else {
                iService.get(pSDEActionGroup);
            }
            this.onFillParentInfo_PSDEActionGroup(pSDEAGDetail, pSDEActionGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEAGDETAIL_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_PSDEAction(pSDEAGDetail, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEAGDETAIL_PSDEDATASET_PSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDataSet(pSDEAGDetail, pSDEDataSet);
            return;
        }
        super.onFillParentInfo(pSDEAGDetail, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEActionGroup(PSDEAGDetail pSDEAGDetail, PSDEActionGroup pSDEActionGroup) throws Exception {
        pSDEAGDetail.setPSDEActionGroupId(pSDEActionGroup.getPSDEActionGroupId());
        pSDEAGDetail.setPSDEActionGroupName(pSDEActionGroup.getPSDEActionGroupName());
        pSDEAGDetail.setPSDEId(pSDEActionGroup.getPSDEId());
    }

    protected void onFillParentInfo_PSDEAction(PSDEAGDetail pSDEAGDetail, PSDEAction pSDEAction) throws Exception {
        pSDEAGDetail.setPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEAGDetail.setPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PSDEDataSet(PSDEAGDetail pSDEAGDetail, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEAGDetail.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDEAGDetail.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillEntityFullInfo(PSDEAGDetail pSDEAGDetail, boolean bl) throws Exception {
        if (bl) {
            if (pSDEAGDetail.getOrderValue() == null) {
                pSDEAGDetail.setOrderValue((Integer)this.getDefaultValue(this.getWebContext(), "", "1000", 9));
            }
            if (pSDEAGDetail.getValidFlag() == null) {
                pSDEAGDetail.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDEAGDetail, bl);
        this.onFillEntityFullInfo_PSDEActionGroup(pSDEAGDetail, bl);
        this.onFillEntityFullInfo_PSDEAction(pSDEAGDetail, bl);
        this.onFillEntityFullInfo_PSDEDataSet(pSDEAGDetail, bl);
    }

    protected void onFillEntityFullInfo_PSDEActionGroup(PSDEAGDetail pSDEAGDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEAction(PSDEAGDetail pSDEAGDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataSet(PSDEAGDetail pSDEAGDetail, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEAGDetail pSDEAGDetail, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEAGDetail, bl);
    }

    public ArrayList<PSDEAGDetail> selectByPSDEActionGroup(PSDEActionGroupBase pSDEActionGroupBase) throws Exception {
        return this.selectByPSDEActionGroup(pSDEActionGroupBase, "", -1);
    }

    public ArrayList<PSDEAGDetail> selectByPSDEActionGroup(PSDEActionGroupBase pSDEActionGroupBase, String string) throws Exception {
        return this.selectByPSDEActionGroup(pSDEActionGroupBase, string, -1);
    }

    public ArrayList<PSDEAGDetail> selectByPSDEActionGroup(PSDEActionGroupBase pSDEActionGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEACTIONGROUPID", (Object)pSDEActionGroupBase.getPSDEActionGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEActionGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEActionGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAGDetail> selectTempByPSDEActionGroup(PSDEActionGroupBase pSDEActionGroupBase) throws Exception {
        return this.selectTempByPSDEActionGroup(pSDEActionGroupBase, "");
    }

    public ArrayList<PSDEAGDetail> selectTempByPSDEActionGroup(PSDEActionGroupBase pSDEActionGroupBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEACTIONGROUPID", (Object)pSDEActionGroupBase.getPSDEActionGroupId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEActionGroupCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEActionGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAGDetail> selectByPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEAGDetail> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEAGDetail> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAGDetail> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEAGDetail> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEAGDetail> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDataSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEActionGroup(PSDEActionGroup pSDEActionGroup) throws Exception {
    }

    public void resetPSDEActionGroup(PSDEActionGroup pSDEActionGroup) throws Exception {
        ArrayList<PSDEAGDetail> arrayList = this.selectByPSDEActionGroup(pSDEActionGroup);
        for (PSDEAGDetail pSDEAGDetail : arrayList) {
            PSDEAGDetail pSDEAGDetail2 = (PSDEAGDetail)this.getDEModel().createEntity();
            pSDEAGDetail2.setPSDEAGDetailId(pSDEAGDetail.getPSDEAGDetailId());
            pSDEAGDetail2.setPSDEActionGroupId(null);
            this.update(pSDEAGDetail2);
        }
    }

    public void resetTempPSDEActionGroup(PSDEActionGroup pSDEActionGroup) throws Exception {
        ArrayList<PSDEAGDetail> arrayList = this.selectTempByPSDEActionGroup(pSDEActionGroup);
        for (PSDEAGDetail pSDEAGDetail : arrayList) {
            PSDEAGDetail pSDEAGDetail2 = (PSDEAGDetail)this.getDEModel().createEntity();
            pSDEAGDetail2.setPSDEAGDetailId(pSDEAGDetail.getPSDEAGDetailId());
            pSDEAGDetail2.setPSDEActionGroupId(null);
            this.updateTemp(pSDEAGDetail2);
        }
    }

    public void removeByPSDEActionGroup(PSDEActionGroup pSDEActionGroup) throws Exception {
        final PSDEActionGroup pSDEActionGroup2 = pSDEActionGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEAGDetailServiceBase.this.onBeforeRemoveByPSDEActionGroup(pSDEActionGroup2);
                PSDEAGDetailServiceBase.this.internalRemoveByPSDEActionGroup(pSDEActionGroup2);
                PSDEAGDetailServiceBase.this.onAfterRemoveByPSDEActionGroup(pSDEActionGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEActionGroup(PSDEActionGroup pSDEActionGroup) throws Exception {
    }

    protected void internalRemoveByPSDEActionGroup(PSDEActionGroup pSDEActionGroup) throws Exception {
        ArrayList<PSDEAGDetail> arrayList = this.selectByPSDEActionGroup(pSDEActionGroup);
        this.onBeforeRemoveByPSDEActionGroup(pSDEActionGroup, arrayList);
        for (PSDEAGDetail pSDEAGDetail : arrayList) {
            this.remove(pSDEAGDetail);
        }
        this.onAfterRemoveByPSDEActionGroup(pSDEActionGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEActionGroup(PSDEActionGroup pSDEActionGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEActionGroup(PSDEActionGroup pSDEActionGroup, ArrayList<PSDEAGDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEActionGroup(PSDEActionGroup pSDEActionGroup, ArrayList<PSDEAGDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEAGDetail> arrayList = this.selectByPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEAGDETAIL_PSDEACTION_PSDEACTIONID", "", iDataEntityModel.getName(), "PSDEAGDETAIL", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEAGDetail> arrayList = this.selectByPSDEAction(pSDEAction);
        for (PSDEAGDetail pSDEAGDetail : arrayList) {
            PSDEAGDetail pSDEAGDetail2 = (PSDEAGDetail)this.getDEModel().createEntity();
            pSDEAGDetail2.setPSDEAGDetailId(pSDEAGDetail.getPSDEAGDetailId());
            pSDEAGDetail2.setPSDEActionId(null);
            this.update(pSDEAGDetail2);
        }
    }

    public void removeByPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEAGDetailServiceBase.this.onBeforeRemoveByPSDEAction(pSDEAction2);
                PSDEAGDetailServiceBase.this.internalRemoveByPSDEAction(pSDEAction2);
                PSDEAGDetailServiceBase.this.onAfterRemoveByPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEAGDetail> arrayList = this.selectByPSDEAction(pSDEAction);
        this.onBeforeRemoveByPSDEAction(pSDEAction, arrayList);
        for (PSDEAGDetail pSDEAGDetail : arrayList) {
            this.remove(pSDEAGDetail);
        }
        this.onAfterRemoveByPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEAGDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEAGDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEAGDetail> arrayList = this.selectByPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEAGDETAIL_PSDEDATASET_PSDEDATASETID", "", iDataEntityModel.getName(), "PSDEAGDETAIL", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEAGDetail> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        for (PSDEAGDetail pSDEAGDetail : arrayList) {
            PSDEAGDetail pSDEAGDetail2 = (PSDEAGDetail)this.getDEModel().createEntity();
            pSDEAGDetail2.setPSDEAGDetailId(pSDEAGDetail.getPSDEAGDetailId());
            pSDEAGDetail2.setPSDEDataSetId(null);
            this.update(pSDEAGDetail2);
        }
    }

    public void removeByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEAGDetailServiceBase.this.onBeforeRemoveByPSDEDataSet(pSDEDataSet2);
                PSDEAGDetailServiceBase.this.internalRemoveByPSDEDataSet(pSDEDataSet2);
                PSDEAGDetailServiceBase.this.onAfterRemoveByPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEAGDetail> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDEAGDetail pSDEAGDetail : arrayList) {
            this.remove(pSDEAGDetail);
        }
        this.onAfterRemoveByPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEAGDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEAGDetail> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEAGDetail pSDEAGDetail) throws Exception {
        super.onBeforeRemove(pSDEAGDetail);
    }

    public void removeTempByPSDEActionGroup(PSDEActionGroup pSDEActionGroup) throws Exception {
        final PSDEActionGroup pSDEActionGroup2 = pSDEActionGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEAGDetailServiceBase.this.onBeforeRemoveTempByPSDEActionGroup(pSDEActionGroup2);
                PSDEAGDetailServiceBase.this.internalRemoveTempByPSDEActionGroup(pSDEActionGroup2);
                PSDEAGDetailServiceBase.this.onAfterRemoveTempByPSDEActionGroup(pSDEActionGroup2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEActionGroup(PSDEActionGroup pSDEActionGroup) throws Exception {
    }

    protected void internalRemoveTempByPSDEActionGroup(PSDEActionGroup pSDEActionGroup) throws Exception {
        ArrayList<PSDEAGDetail> arrayList = this.selectTempByPSDEActionGroup(pSDEActionGroup);
        this.onBeforeRemoveTempByPSDEActionGroup(pSDEActionGroup, arrayList);
        for (PSDEAGDetail pSDEAGDetail : arrayList) {
            this.removeTemp(pSDEAGDetail);
        }
        this.onAfterRemoveTempByPSDEActionGroup(pSDEActionGroup, arrayList);
    }

    protected void onAfterRemoveTempByPSDEActionGroup(PSDEActionGroup pSDEActionGroup) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEActionGroup(PSDEActionGroup pSDEActionGroup, ArrayList<PSDEAGDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEActionGroup(PSDEActionGroup pSDEActionGroup, ArrayList<PSDEAGDetail> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEAGDetail pSDEAGDetail, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEAGDetail, cloneSession);
        if (pSDEAGDetail.getPSDEActionGroupId() != null && (iEntity = cloneSession.getEntity("PSDEACTIONGROUP", (Object)pSDEAGDetail.getPSDEActionGroupId())) != null) {
            this.onFillParentInfo_PSDEActionGroup(pSDEAGDetail, (PSDEActionGroup)iEntity);
        }
        if (pSDEAGDetail.getPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEAGDetail.getPSDEActionId())) != null) {
            this.onFillParentInfo_PSDEAction(pSDEAGDetail, (PSDEAction)iEntity);
        }
        if (pSDEAGDetail.getPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEAGDetail.getPSDEDataSetId())) != null) {
            this.onFillParentInfo_PSDEDataSet(pSDEAGDetail, (PSDEDataSet)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEAGDetail pSDEAGDetail, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEAGDetail, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEAGDetail pSDEAGDetail, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDEAGDetail, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName2(bl, pSDEAGDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailType(bl, pSDEAGDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEAGDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEAGDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionGroupId(bl, pSDEAGDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionId(bl, pSDEAGDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEAGDetailId(bl, pSDEAGDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEAGDetailName(bl, pSDEAGDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSetId(bl, pSDEAGDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEAGDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEAGDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEAGDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEAGDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEAGDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEAGDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEAGDetail, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEAGDetail pSDEAGDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAGDetail.isCodeNameDirty() : !pSDEAGDetail.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEAGDetail.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEAGDetail, bl2, bl3);
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
                string3 = "PSDEACTIONGROUPID";
                String string4 = this.checkFieldDupRule(this.getPSDEAGDetailDEModel(), "CODENAME", string3, pSDEAGDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName2(boolean bl, PSDEAGDetail pSDEAGDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAGDetail.isCodeName2Dirty() : !pSDEAGDetail.isCodeName2Dirty()) {
            return null;
        }
        String string = pSDEAGDetail.getCodeName2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName2_Default(pSDEAGDetail, bl2, bl3);
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
                string3 = "PSDEACTIONGROUPID";
                String string4 = this.checkFieldDupRule(this.getPSDEAGDetailDEModel(), "CODENAME2", string3, pSDEAGDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_DetailType(boolean bl, PSDEAGDetail pSDEAGDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAGDetail.isDetailTypeDirty() && !bl2 : !pSDEAGDetail.isDetailTypeDirty()) {
            return null;
        }
        String string = pSDEAGDetail.getDetailType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailType_Default(pSDEAGDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEAGDetail pSDEAGDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAGDetail.isMemoDirty() : !pSDEAGDetail.isMemoDirty()) {
            return null;
        }
        String string = pSDEAGDetail.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEAGDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEAGDetail pSDEAGDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAGDetail.isOrderValueDirty() : !pSDEAGDetail.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEAGDetail.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEAGDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEActionGroupId(boolean bl, PSDEAGDetail pSDEAGDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAGDetail.isPSDEActionGroupIdDirty() : !pSDEAGDetail.isPSDEActionGroupIdDirty()) {
            return null;
        }
        String string = pSDEAGDetail.getPSDEActionGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionGroupId_Default(pSDEAGDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionId(boolean bl, PSDEAGDetail pSDEAGDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAGDetail.isPSDEActionIdDirty() : !pSDEAGDetail.isPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEAGDetail.getPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionId_Default(pSDEAGDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONID");
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
                string3 = "PSDEACTIONGROUPID";
                String string4 = this.checkFieldDupRule(this.getPSDEAGDetailDEModel(), "PSDEACTIONID", string3, pSDEAGDetail, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEACTIONID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEAGDetailId(boolean bl, PSDEAGDetail pSDEAGDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAGDetail.isPSDEAGDetailIdDirty() && !bl2 : !pSDEAGDetail.isPSDEAGDetailIdDirty()) {
            return null;
        }
        String string = pSDEAGDetail.getPSDEAGDetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEAGDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEAGDetailId_Default(pSDEAGDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEAGDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEAGDetailName(boolean bl, PSDEAGDetail pSDEAGDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAGDetail.isPSDEAGDetailNameDirty() && !bl2 : !pSDEAGDetail.isPSDEAGDetailNameDirty()) {
            return null;
        }
        String string = pSDEAGDetail.getPSDEAGDetailName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEAGDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEAGDetailName_Default(pSDEAGDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEAGDETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataSetId(boolean bl, PSDEAGDetail pSDEAGDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAGDetail.isPSDEDataSetIdDirty() : !pSDEAGDetail.isPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDEAGDetail.getPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSetId_Default(pSDEAGDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASETID");
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
                string3 = "PSDEACTIONGROUPID";
                String string4 = this.checkFieldDupRule(this.getPSDEAGDetailDEModel(), "PSDEDATASETID", string3, pSDEAGDetail, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEDATASETID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEAGDetail pSDEAGDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAGDetail.isUserCatDirty() : !pSDEAGDetail.isUserCatDirty()) {
            return null;
        }
        String string = pSDEAGDetail.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEAGDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEAGDetail pSDEAGDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAGDetail.isUserTagDirty() : !pSDEAGDetail.isUserTagDirty()) {
            return null;
        }
        String string = pSDEAGDetail.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEAGDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEAGDetail pSDEAGDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAGDetail.isUserTag2Dirty() : !pSDEAGDetail.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEAGDetail.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEAGDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEAGDetail pSDEAGDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAGDetail.isUserTag3Dirty() : !pSDEAGDetail.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEAGDetail.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEAGDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEAGDetail pSDEAGDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAGDetail.isUserTag4Dirty() : !pSDEAGDetail.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEAGDetail.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEAGDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEAGDetail pSDEAGDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAGDetail.isValidFlagDirty() && !bl2 : !pSDEAGDetail.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEAGDetail.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDEAGDetail, bl2, bl3);
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

    protected void onSyncEntity(PSDEAGDetail pSDEAGDetail, boolean bl) throws Exception {
        super.onSyncEntity(pSDEAGDetail, bl);
    }

    protected void onSyncIndexEntities(PSDEAGDetail pSDEAGDetail, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEAGDetail, bl);
    }

    public Object getDataContextValue(PSDEAGDetail pSDEAGDetail, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEAGDetail, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEActionGroup pSDEActionGroup = pSDEAGDetail.getPSDEActionGroup();
        if (pSDEActionGroup != null && pSDEActionGroup.contains(string)) {
            return pSDEActionGroup.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEAGDetail pSDEAGDetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEAGDetail, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"DETAILTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEAGDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEAGDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEAGDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEAGDetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DetailType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_PSDEActionGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEAGDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEAGDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEAGDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEAGDETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEAGDetail pSDEAGDetail) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEAGDetail)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEAGDetail pSDEAGDetail) throws Exception {
        super.onUpdateParent(pSDEAGDetail);
    }

    @Override
    protected void exportCurXmlModel(PSDEAGDetail pSDEAGDetail, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEAGDETAIL");
        if (!bl) {
            pSDEAGDetail.setCreateDate(null);
            pSDEAGDetail.setCreateMan(null);
            pSDEAGDetail.setPSDEActionGroupName(null);
            pSDEAGDetail.setPSDEAGDetailId(null);
            pSDEAGDetail.setUpdateDate(null);
            pSDEAGDetail.setUpdateMan(null);
            pSDEAGDetail.setPSDEActionGroupId(null);
            pSDEAGDetail.setPSDEActionGroupName(null);
            pSDEAGDetail.setPSDEId(null);
            super.exportCurXmlModel(pSDEAGDetail, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEAGDetail pSDEAGDetail, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEAGDetail, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEACTIONGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEACTIONGROUP#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEACTIONGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEAGDETAIL_PSDEACTIONGROUP_PSDEACTIONGROUPID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEACTIONGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEACTIONGROUPNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEACTIONGROUP", (boolean)true) == 0) {
            iEntity.set("PSDEACTIONGROUPID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEACTIONGROUPID"};
    }

    @Override
    public String getModelV2Tag(PSDEAGDetail pSDEAGDetail) {
        if (!StringHelper.isNullOrEmpty((String)pSDEAGDetail.getCodeName())) {
            return pSDEAGDetail.getCodeName();
        }
        return super.getModelV2Tag(pSDEAGDetail);
    }

    @Override
    public boolean setModelV2Tag(PSDEAGDetail pSDEAGDetail, String string) {
        pSDEAGDetail.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSDEACTIONGROUPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEAGDetail pSDEAGDetail, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEAGDetail.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEAGDetail, true);
        pSDEAGDetail.set("CODENAME", string);
        if (this.select(pSDEAGDetail, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEAGDetail, true);
        return super.getModelV2Entity(pSDEAGDetail, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEAGDetail pSDEAGDetail, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEAGDetail, objectNode, string, string2, n);
    }
}

