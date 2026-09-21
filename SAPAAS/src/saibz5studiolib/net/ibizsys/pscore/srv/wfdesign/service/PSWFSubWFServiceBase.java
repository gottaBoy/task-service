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
package net.ibizsys.pscore.srv.wfdesign.service;

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
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.wfdesign.dao.PSWFSubWFDAO;
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFSubWFDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFSubWF;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersionBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflowBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFSubWFServiceBase
extends PSCoreSysServiceBase<PSWFSubWF> {
    private static final Log log = LogFactory.getLog(PSWFSubWFServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSWFSubWFDEModel pSWFSubWFDEModel;
    private PSWFSubWFDAO pSWFSubWFDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfdesign.service.PSWFSubWFService";
    }

    public PSWFSubWFDEModel getPSWFSubWFDEModel() {
        if (this.pSWFSubWFDEModel == null) {
            try {
                this.pSWFSubWFDEModel = (PSWFSubWFDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFSubWFDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFSubWFDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWFSubWFDEModel();
    }

    public PSWFSubWFDAO getPSWFSubWFDAO() {
        if (this.pSWFSubWFDAO == null) {
            try {
                this.pSWFSubWFDAO = (PSWFSubWFDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfdesign.dao.PSWFSubWFDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFSubWFDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWFSubWFDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSWFSubWF pSWFSubWF, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFSUBWF_PSWFVERSION_SUBPSWFVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService", (SessionFactory)this.getSessionFactory());
            PSWFVersion pSWFVersion = (PSWFVersion)iService.getDEModel().createEntity();
            pSWFVersion.set("PSWFVERSIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWFVersion);
            } else {
                iService.get((IEntity)pSWFVersion);
            }
            this.onFillParentInfo_SubPSWFVer(pSWFSubWF, pSWFVersion);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFSUBWF_PSWORKFLOW_PSWFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService", (SessionFactory)this.getSessionFactory());
            PSWorkflow pSWorkflow = (PSWorkflow)iService.getDEModel().createEntity();
            pSWorkflow.set("PSWORKFLOWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWorkflow);
            } else {
                iService.get((IEntity)pSWorkflow);
            }
            this.onFillParentInfo_PSWF(pSWFSubWF, pSWorkflow);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFSUBWF_PSWORKFLOW_SUBPSWFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService", (SessionFactory)this.getSessionFactory());
            PSWorkflow pSWorkflow = (PSWorkflow)iService.getDEModel().createEntity();
            pSWorkflow.set("PSWORKFLOWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWorkflow);
            } else {
                iService.get((IEntity)pSWorkflow);
            }
            this.onFillParentInfo_SubPSWF(pSWFSubWF, pSWorkflow);
            return;
        }
        super.onFillParentInfo((IEntity)pSWFSubWF, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_SubPSWFVer(PSWFSubWF pSWFSubWF, PSWFVersion pSWFVersion) throws Exception {
        pSWFSubWF.setSubPSWFVerId(pSWFVersion.getPSWFVersionId());
        pSWFSubWF.setSubPSWFVerName(pSWFVersion.getPSWFVersionName());
    }

    protected void onFillParentInfo_PSWF(PSWFSubWF pSWFSubWF, PSWorkflow pSWorkflow) throws Exception {
        pSWFSubWF.setPSWFId(pSWorkflow.getPSWorkflowId());
        pSWFSubWF.setPSWFName(pSWorkflow.getPSWorkflowName());
    }

    protected void onFillParentInfo_SubPSWF(PSWFSubWF pSWFSubWF, PSWorkflow pSWorkflow) throws Exception {
        pSWFSubWF.setSubPSWFId(pSWorkflow.getPSWorkflowId());
        pSWFSubWF.setSubPSWFName(pSWorkflow.getPSWorkflowName());
    }

    protected void onFillEntityFullInfo(PSWFSubWF pSWFSubWF, boolean bl) throws Exception {
        if (bl && pSWFSubWF.getEnable() == null) {
            pSWFSubWF.setEnable((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSWFSubWF, bl);
        this.onFillEntityFullInfo_SubPSWFVer(pSWFSubWF, bl);
        this.onFillEntityFullInfo_PSWF(pSWFSubWF, bl);
        this.onFillEntityFullInfo_SubPSWF(pSWFSubWF, bl);
    }

    protected void onFillEntityFullInfo_SubPSWFVer(PSWFSubWF pSWFSubWF, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWF(PSWFSubWF pSWFSubWF, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_SubPSWF(PSWFSubWF pSWFSubWF, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSWFSubWF pSWFSubWF, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSWFSubWF, bl);
    }

    public ArrayList<PSWFSubWF> selectBySubPSWFVer(PSWFVersionBase pSWFVersionBase) throws Exception {
        return this.selectBySubPSWFVer(pSWFVersionBase, "", -1);
    }

    public ArrayList<PSWFSubWF> selectBySubPSWFVer(PSWFVersionBase pSWFVersionBase, String string) throws Exception {
        return this.selectBySubPSWFVer(pSWFVersionBase, string, -1);
    }

    public ArrayList<PSWFSubWF> selectBySubPSWFVer(PSWFVersionBase pSWFVersionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SUBPSWFVERID", (Object)pSWFVersionBase.getPSWFVersionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySubPSWFVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySubPSWFVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFSubWF> selectByPSWF(PSWorkflowBase pSWorkflowBase) throws Exception {
        return this.selectByPSWF(pSWorkflowBase, "", -1);
    }

    public ArrayList<PSWFSubWF> selectByPSWF(PSWorkflowBase pSWorkflowBase, String string) throws Exception {
        return this.selectByPSWF(pSWorkflowBase, string, -1);
    }

    public ArrayList<PSWFSubWF> selectByPSWF(PSWorkflowBase pSWorkflowBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFID", (Object)pSWorkflowBase.getPSWorkflowId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFSubWF> selectBySubPSWF(PSWorkflowBase pSWorkflowBase) throws Exception {
        return this.selectBySubPSWF(pSWorkflowBase, "", -1);
    }

    public ArrayList<PSWFSubWF> selectBySubPSWF(PSWorkflowBase pSWorkflowBase, String string) throws Exception {
        return this.selectBySubPSWF(pSWorkflowBase, string, -1);
    }

    public ArrayList<PSWFSubWF> selectBySubPSWF(PSWorkflowBase pSWorkflowBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SUBPSWFID", (Object)pSWorkflowBase.getPSWorkflowId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySubPSWFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySubPSWFCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveBySubPSWFVer(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFSubWF> arrayList = this.selectBySubPSWFVer(pSWFVersion, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWFVERSION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSWFVersion);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFSUBWF_PSWFVERSION_SUBPSWFVERID", "", iDataEntityModel.getName(), "PSWFSUBWF", iDataEntityModel.getDataInfo((IEntity)pSWFVersion), arrayList.get(0)));
        }
    }

    public void resetSubPSWFVer(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFSubWF> arrayList = this.selectBySubPSWFVer(pSWFVersion);
        for (PSWFSubWF pSWFSubWF : arrayList) {
            PSWFSubWF pSWFSubWF2 = (PSWFSubWF)this.getDEModel().createEntity();
            pSWFSubWF2.setPSWFSubWFId(pSWFSubWF.getPSWFSubWFId());
            pSWFSubWF2.setSubPSWFVerId(null);
            this.update(pSWFSubWF2);
        }
    }

    public void removeBySubPSWFVer(PSWFVersion pSWFVersion) throws Exception {
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFSubWFServiceBase.this.onBeforeRemoveBySubPSWFVer(pSWFVersion2);
                PSWFSubWFServiceBase.this.internalRemoveBySubPSWFVer(pSWFVersion2);
                PSWFSubWFServiceBase.this.onAfterRemoveBySubPSWFVer(pSWFVersion2);
            }
        });
    }

    protected void onBeforeRemoveBySubPSWFVer(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void internalRemoveBySubPSWFVer(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFSubWF> arrayList = this.selectBySubPSWFVer(pSWFVersion);
        this.onBeforeRemoveBySubPSWFVer(pSWFVersion, arrayList);
        for (PSWFSubWF pSWFSubWF : arrayList) {
            this.remove((IEntity)pSWFSubWF);
        }
        this.onAfterRemoveBySubPSWFVer(pSWFVersion, arrayList);
    }

    protected void onAfterRemoveBySubPSWFVer(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void onBeforeRemoveBySubPSWFVer(PSWFVersion pSWFVersion, ArrayList<PSWFSubWF> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySubPSWFVer(PSWFVersion pSWFVersion, ArrayList<PSWFSubWF> arrayList) throws Exception {
    }

    public void testRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    public void resetPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFSubWF> arrayList = this.selectByPSWF(pSWorkflow);
        for (PSWFSubWF pSWFSubWF : arrayList) {
            PSWFSubWF pSWFSubWF2 = (PSWFSubWF)this.getDEModel().createEntity();
            pSWFSubWF2.setPSWFSubWFId(pSWFSubWF.getPSWFSubWFId());
            pSWFSubWF2.setPSWFId(null);
            this.update(pSWFSubWF2);
        }
    }

    public void removeByPSWF(PSWorkflow pSWorkflow) throws Exception {
        final PSWorkflow pSWorkflow2 = pSWorkflow;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFSubWFServiceBase.this.onBeforeRemoveByPSWF(pSWorkflow2);
                PSWFSubWFServiceBase.this.internalRemoveByPSWF(pSWorkflow2);
                PSWFSubWFServiceBase.this.onAfterRemoveByPSWF(pSWorkflow2);
            }
        });
    }

    protected void onBeforeRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void internalRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFSubWF> arrayList = this.selectByPSWF(pSWorkflow);
        this.onBeforeRemoveByPSWF(pSWorkflow, arrayList);
        for (PSWFSubWF pSWFSubWF : arrayList) {
            this.remove((IEntity)pSWFSubWF);
        }
        this.onAfterRemoveByPSWF(pSWorkflow, arrayList);
    }

    protected void onAfterRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void onBeforeRemoveByPSWF(PSWorkflow pSWorkflow, ArrayList<PSWFSubWF> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWF(PSWorkflow pSWorkflow, ArrayList<PSWFSubWF> arrayList) throws Exception {
    }

    public void testRemoveBySubPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFSubWF> arrayList = this.selectBySubPSWF(pSWorkflow, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWORKFLOW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSWorkflow);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFSUBWF_PSWORKFLOW_SUBPSWFID", "", iDataEntityModel.getName(), "PSWFSUBWF", iDataEntityModel.getDataInfo((IEntity)pSWorkflow), arrayList.get(0)));
        }
    }

    public void resetSubPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFSubWF> arrayList = this.selectBySubPSWF(pSWorkflow);
        for (PSWFSubWF pSWFSubWF : arrayList) {
            PSWFSubWF pSWFSubWF2 = (PSWFSubWF)this.getDEModel().createEntity();
            pSWFSubWF2.setPSWFSubWFId(pSWFSubWF.getPSWFSubWFId());
            pSWFSubWF2.setSubPSWFId(null);
            this.update(pSWFSubWF2);
        }
    }

    public void removeBySubPSWF(PSWorkflow pSWorkflow) throws Exception {
        final PSWorkflow pSWorkflow2 = pSWorkflow;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFSubWFServiceBase.this.onBeforeRemoveBySubPSWF(pSWorkflow2);
                PSWFSubWFServiceBase.this.internalRemoveBySubPSWF(pSWorkflow2);
                PSWFSubWFServiceBase.this.onAfterRemoveBySubPSWF(pSWorkflow2);
            }
        });
    }

    protected void onBeforeRemoveBySubPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void internalRemoveBySubPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFSubWF> arrayList = this.selectBySubPSWF(pSWorkflow);
        this.onBeforeRemoveBySubPSWF(pSWorkflow, arrayList);
        for (PSWFSubWF pSWFSubWF : arrayList) {
            this.remove((IEntity)pSWFSubWF);
        }
        this.onAfterRemoveBySubPSWF(pSWorkflow, arrayList);
    }

    protected void onAfterRemoveBySubPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void onBeforeRemoveBySubPSWF(PSWorkflow pSWorkflow, ArrayList<PSWFSubWF> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySubPSWF(PSWorkflow pSWorkflow, ArrayList<PSWFSubWF> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWFSubWF pSWFSubWF) throws Exception {
        super.onBeforeRemove(pSWFSubWF);
    }

    protected void replaceParentInfo(PSWFSubWF pSWFSubWF, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSWFSubWF, cloneSession);
        if (pSWFSubWF.getSubPSWFVerId() != null && (iEntity = cloneSession.getEntity("PSWFVERSION", (Object)pSWFSubWF.getSubPSWFVerId())) != null) {
            this.onFillParentInfo_SubPSWFVer(pSWFSubWF, (PSWFVersion)iEntity);
        }
        if (pSWFSubWF.getPSWFId() != null && (iEntity = cloneSession.getEntity("PSWORKFLOW", (Object)pSWFSubWF.getPSWFId())) != null) {
            this.onFillParentInfo_PSWF(pSWFSubWF, (PSWorkflow)iEntity);
        }
        if (pSWFSubWF.getSubPSWFId() != null && (iEntity = cloneSession.getEntity("PSWORKFLOW", (Object)pSWFSubWF.getSubPSWFId())) != null) {
            this.onFillParentInfo_SubPSWF(pSWFSubWF, (PSWorkflow)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWFSubWF pSWFSubWF, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSWFSubWF, bl);
    }

    protected void onCheckEntity(boolean bl, PSWFSubWF pSWFSubWF, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSWFSubWF, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSWFSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Enable(bl, pSWFSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWFSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSWFSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFId(bl, pSWFSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFSubWFId(bl, pSWFSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFSubWFName(bl, pSWFSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubPSWFId(bl, pSWFSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubPSWFVerId(bl, pSWFSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSWFSubWF, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSWFSubWF pSWFSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFSubWF.isCodeNameDirty() && !bl2 : !pSWFSubWF.isCodeNameDirty()) {
            return null;
        }
        String string = pSWFSubWF.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSWFSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSWFID";
                String string4 = this.checkFieldDupRule(this.getPSWFSubWFDEModel(), "CODENAME", string3, pSWFSubWF, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSWFSubWF pSWFSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFSubWF.isDynaModelFlagDirty() : !pSWFSubWF.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSWFSubWF.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSWFSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Enable(boolean bl, PSWFSubWF pSWFSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFSubWF.isEnableDirty() && !bl2 : !pSWFSubWF.isEnableDirty()) {
            return null;
        }
        Integer n = pSWFSubWF.getEnable();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_Enable_Default((IEntity)pSWFSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWFSubWF pSWFSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFSubWF.isMemoDirty() : !pSWFSubWF.isMemoDirty()) {
            return null;
        }
        String string = pSWFSubWF.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSWFSubWF, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSWFSubWF pSWFSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFSubWF.isPSDynaInstIdDirty() : !pSWFSubWF.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSWFSubWF.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSWFSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFId(boolean bl, PSWFSubWF pSWFSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFSubWF.isPSWFIdDirty() && !bl2 : !pSWFSubWF.isPSWFIdDirty()) {
            return null;
        }
        String string = pSWFSubWF.getPSWFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFId_Default((IEntity)pSWFSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFSubWFId(boolean bl, PSWFSubWF pSWFSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFSubWF.isPSWFSubWFIdDirty() && !bl2 : !pSWFSubWF.isPSWFSubWFIdDirty()) {
            return null;
        }
        String string = pSWFSubWF.getPSWFSubWFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFSUBWFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFSubWFId_Default((IEntity)pSWFSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFSUBWFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFSubWFName(boolean bl, PSWFSubWF pSWFSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFSubWF.isPSWFSubWFNameDirty() && !bl2 : !pSWFSubWF.isPSWFSubWFNameDirty()) {
            return null;
        }
        String string = pSWFSubWF.getPSWFSubWFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFSUBWFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFSubWFName_Default((IEntity)pSWFSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFSUBWFNAME");
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
                string3 = "PSWFID";
                String string4 = this.checkFieldDupRule(this.getPSWFSubWFDEModel(), "PSWFSUBWFNAME", string3, pSWFSubWF, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSWFSUBWFNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubPSWFId(boolean bl, PSWFSubWF pSWFSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFSubWF.isSubPSWFIdDirty() && !bl2 : !pSWFSubWF.isSubPSWFIdDirty()) {
            return null;
        }
        String string = pSWFSubWF.getSubPSWFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBPSWFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubPSWFId_Default((IEntity)pSWFSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBPSWFID");
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
                string3 = "PSWFID";
                String string4 = this.checkFieldDupRule(this.getPSWFSubWFDEModel(), "SUBPSWFID", string3, pSWFSubWF, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("SUBPSWFID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubPSWFVerId(boolean bl, PSWFSubWF pSWFSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFSubWF.isSubPSWFVerIdDirty() : !pSWFSubWF.isSubPSWFVerIdDirty()) {
            return null;
        }
        String string = pSWFSubWF.getSubPSWFVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubPSWFVerId_Default((IEntity)pSWFSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBPSWFVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWFSubWF pSWFSubWF, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSWFSubWF, bl);
    }

    protected void onSyncIndexEntities(PSWFSubWF pSWFSubWF, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSWFSubWF, bl);
    }

    public Object getDataContextValue(PSWFSubWF pSWFSubWF, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSWFVERSION", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSWFID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"SUBPSWFVERID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"SUBPSWFVERNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSWFSubWF, "subpswfid", iDataContextParam)) != null) {
            return object;
        }
        object = super.getDataContextValue((IEntity)pSWFSubWF, string, iDataContextParam);
        if (object != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSWFSubWF pSWFSubWF, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSWFSubWF, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Enable_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFSUBWFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFSubWFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFSUBWFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFSubWFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBPSWFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubPSWFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBPSWFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubPSWFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBPSWFVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubPSWFVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBPSWFVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubPSWFVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Enable_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFSubWFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFSUBWFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFSubWFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFSUBWFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubPSWFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBPSWFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubPSWFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBPSWFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubPSWFVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBPSWFVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubPSWFVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBPSWFVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSWFSubWF pSWFSubWF) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSWFSubWF)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWFSubWF pSWFSubWF) throws Exception {
        super.onUpdateParent((IEntity)pSWFSubWF);
    }

    @Override
    protected void exportCurXmlModel(PSWFSubWF pSWFSubWF, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWFSUBWF");
        if (!bl) {
            super.exportCurXmlModel(pSWFSubWF, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSWFSubWF pSWFSubWF, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSWFSubWF, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWORKFLOW#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWFSUBWF_PSWORKFLOW_PSWFID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSWORKFLOW", (boolean)true) == 0) {
            iEntity.set("PSWFID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSWFID"};
    }

    @Override
    public String getModelV2Tag(PSWFSubWF pSWFSubWF) {
        if (!StringHelper.isNullOrEmpty((String)pSWFSubWF.getPSWFSubWFName())) {
            return pSWFSubWF.getPSWFSubWFName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSWFSubWF.getCodeName())) {
            return pSWFSubWF.getCodeName();
        }
        return super.getModelV2Tag(pSWFSubWF);
    }

    @Override
    public boolean setModelV2Tag(PSWFSubWF pSWFSubWF, String string) {
        return super.setModelV2Tag(pSWFSubWF, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSWFSUBWFNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSWFSUBWFNAME", "");
        map.put("SUBPSWFID", "");
        map.put("PSWFID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSWFSubWF pSWFSubWF, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSWFSubWF.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSWFSubWF, true);
        pSWFSubWF.set("PSWFSUBWFNAME", string);
        if (this.select(pSWFSubWF, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSWFSubWF, true);
        return super.getModelV2Entity(pSWFSubWF, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSWFSubWF pSWFSubWF, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSWFSubWF, objectNode, string, string2, n);
    }
}

