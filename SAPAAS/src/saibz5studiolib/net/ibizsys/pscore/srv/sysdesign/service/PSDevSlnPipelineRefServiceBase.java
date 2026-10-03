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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnPipelineRefDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnPipelineRefDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipeline;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineRef;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnPipelineRefServiceBase
extends PSCoreSysServiceBase<PSDevSlnPipelineRef> {
    private static final Log log = LogFactory.getLog(PSDevSlnPipelineRefServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevSlnPipelineRefDEModel pSDevSlnPipelineRefDEModel;
    private PSDevSlnPipelineRefDAO pSDevSlnPipelineRefDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineRefService";
    }

    public PSDevSlnPipelineRefDEModel getPSDevSlnPipelineRefDEModel() {
        if (this.pSDevSlnPipelineRefDEModel == null) {
            try {
                this.pSDevSlnPipelineRefDEModel = (PSDevSlnPipelineRefDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnPipelineRefDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnPipelineRefDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnPipelineRefDEModel();
    }

    public PSDevSlnPipelineRefDAO getPSDevSlnPipelineRefDAO() {
        if (this.pSDevSlnPipelineRefDAO == null) {
            try {
                this.pSDevSlnPipelineRefDAO = (PSDevSlnPipelineRefDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnPipelineRefDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnPipelineRefDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnPipelineRefDAO();
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

    protected void onFillParentInfo(PSDevSlnPipelineRef pSDevSlnPipelineRef, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINEREF_PSDEVSLNPIPELINE_PSDEVSLNPIPELINEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService", (SessionFactory)this.getSessionFactory());
            PSDevSlnPipeline pSDevSlnPipeline = (PSDevSlnPipeline)iService.getDEModel().createEntity();
            pSDevSlnPipeline.set("PSDEVSLNPIPELINEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnPipeline);
            } else {
                iService.get(pSDevSlnPipeline);
            }
            this.onFillParentInfo_PSDevSlnPipeline(pSDevSlnPipelineRef, pSDevSlnPipeline);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINEREF_PSDEVSLNPIPELINE_REFPSDEVSLNPIPELINEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService", (SessionFactory)this.getSessionFactory());
            PSDevSlnPipeline pSDevSlnPipeline = (PSDevSlnPipeline)iService.getDEModel().createEntity();
            pSDevSlnPipeline.set("PSDEVSLNPIPELINEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnPipeline);
            } else {
                iService.get(pSDevSlnPipeline);
            }
            this.onFillParentInfo_RefPSDevSlnPipeline(pSDevSlnPipelineRef, pSDevSlnPipeline);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINEREF_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDevSlnPipelineRef, pSDevSln);
            return;
        }
        super.onFillParentInfo(pSDevSlnPipelineRef, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevSlnPipeline(PSDevSlnPipelineRef pSDevSlnPipelineRef, PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        pSDevSlnPipelineRef.setPSDevSlnPipelineId(pSDevSlnPipeline.getPSDevSlnPipelineId());
        pSDevSlnPipelineRef.setPSDevSlnPipelineName(pSDevSlnPipeline.getPSDevSlnPipelineName());
    }

    protected void onFillParentInfo_RefPSDevSlnPipeline(PSDevSlnPipelineRef pSDevSlnPipelineRef, PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        pSDevSlnPipelineRef.setRefPSDevSlnPipelineId(pSDevSlnPipeline.getPSDevSlnPipelineId());
        pSDevSlnPipelineRef.setRefPSDevSlnPipelineName(pSDevSlnPipeline.getPSDevSlnPipelineName());
    }

    protected void onFillParentInfo_PSDevSln(PSDevSlnPipelineRef pSDevSlnPipelineRef, PSDevSln pSDevSln) throws Exception {
        pSDevSlnPipelineRef.setPSDevCenterId(pSDevSln.getPSDevCenterId());
        pSDevSlnPipelineRef.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevSlnPipelineRef.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillEntityFullInfo(PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl) throws Exception {
        if (bl) {
            if (pSDevSlnPipelineRef.getCondModelFlag() == null) {
                pSDevSlnPipelineRef.setCondModelFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDevSlnPipelineRef.getValidFlag() == null) {
                pSDevSlnPipelineRef.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDevSlnPipelineRef, bl);
        this.onFillEntityFullInfo_PSDevSlnPipeline(pSDevSlnPipelineRef, bl);
        this.onFillEntityFullInfo_RefPSDevSlnPipeline(pSDevSlnPipelineRef, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDevSlnPipelineRef, bl);
    }

    protected void onFillEntityFullInfo_PSDevSlnPipeline(PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDevSlnPipeline(PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnPipelineRef, bl);
    }

    public ArrayList<PSDevSlnPipelineRef> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase) throws Exception {
        return this.selectByPSDevSlnPipeline(pSDevSlnPipelineBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineRef> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase, String string) throws Exception {
        return this.selectByPSDevSlnPipeline(pSDevSlnPipelineBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineRef> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNPIPELINEID", (Object)pSDevSlnPipelineBase.getPSDevSlnPipelineId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnPipelineCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnPipelineCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineRef> selectByRefPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase) throws Exception {
        return this.selectByRefPSDevSlnPipeline(pSDevSlnPipelineBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineRef> selectByRefPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase, String string) throws Exception {
        return this.selectByRefPSDevSlnPipeline(pSDevSlnPipelineBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineRef> selectByRefPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEVSLNPIPELINEID", (Object)pSDevSlnPipelineBase.getPSDevSlnPipelineId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDevSlnPipelineCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDevSlnPipelineCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineRef> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineRef> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineRef> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    public void resetPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnPipelineRef> arrayList = this.selectByPSDevSlnPipeline(pSDevSlnPipeline);
        for (PSDevSlnPipelineRef pSDevSlnPipelineRef : arrayList) {
            PSDevSlnPipelineRef pSDevSlnPipelineRef2 = (PSDevSlnPipelineRef)this.getDEModel().createEntity();
            pSDevSlnPipelineRef2.setPSDevSlnPipelineRefId(pSDevSlnPipelineRef.getPSDevSlnPipelineRefId());
            pSDevSlnPipelineRef2.setPSDevSlnPipelineId(null);
            this.update(pSDevSlnPipelineRef2);
        }
    }

    public void removeByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        final PSDevSlnPipeline pSDevSlnPipeline2 = pSDevSlnPipeline;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineRefServiceBase.this.onBeforeRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnPipelineRefServiceBase.this.internalRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnPipelineRefServiceBase.this.onAfterRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void internalRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnPipelineRef> arrayList = this.selectByPSDevSlnPipeline(pSDevSlnPipeline);
        this.onBeforeRemoveByPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
        for (PSDevSlnPipelineRef pSDevSlnPipelineRef : arrayList) {
            this.remove(pSDevSlnPipelineRef);
        }
        this.onAfterRemoveByPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnPipelineRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnPipelineRef> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnPipelineRef> arrayList = this.selectByRefPSDevSlnPipeline(pSDevSlnPipeline, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNPIPELINE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnPipeline);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINEREF_PSDEVSLNPIPELINE_REFPSDEVSLNPIPELINEID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINEREF", iDataEntityModel.getDataInfo(pSDevSlnPipeline), arrayList.get(0)));
        }
    }

    public void resetRefPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnPipelineRef> arrayList = this.selectByRefPSDevSlnPipeline(pSDevSlnPipeline);
        for (PSDevSlnPipelineRef pSDevSlnPipelineRef : arrayList) {
            PSDevSlnPipelineRef pSDevSlnPipelineRef2 = (PSDevSlnPipelineRef)this.getDEModel().createEntity();
            pSDevSlnPipelineRef2.setPSDevSlnPipelineRefId(pSDevSlnPipelineRef.getPSDevSlnPipelineRefId());
            pSDevSlnPipelineRef2.setRefPSDevSlnPipelineId(null);
            this.update(pSDevSlnPipelineRef2);
        }
    }

    public void removeByRefPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        final PSDevSlnPipeline pSDevSlnPipeline2 = pSDevSlnPipeline;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineRefServiceBase.this.onBeforeRemoveByRefPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnPipelineRefServiceBase.this.internalRemoveByRefPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnPipelineRefServiceBase.this.onAfterRemoveByRefPSDevSlnPipeline(pSDevSlnPipeline2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void internalRemoveByRefPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnPipelineRef> arrayList = this.selectByRefPSDevSlnPipeline(pSDevSlnPipeline);
        this.onBeforeRemoveByRefPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
        for (PSDevSlnPipelineRef pSDevSlnPipelineRef : arrayList) {
            this.remove(pSDevSlnPipelineRef);
        }
        this.onAfterRemoveByRefPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
    }

    protected void onAfterRemoveByRefPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnPipelineRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnPipelineRef> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnPipelineRef> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDevSlnPipelineRef pSDevSlnPipelineRef : arrayList) {
            PSDevSlnPipelineRef pSDevSlnPipelineRef2 = (PSDevSlnPipelineRef)this.getDEModel().createEntity();
            pSDevSlnPipelineRef2.setPSDevSlnPipelineRefId(pSDevSlnPipelineRef.getPSDevSlnPipelineRefId());
            pSDevSlnPipelineRef2.setPSDevSlnId(null);
            this.update(pSDevSlnPipelineRef2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineRefServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDevSlnPipelineRefServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDevSlnPipelineRefServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnPipelineRef> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDevSlnPipelineRef pSDevSlnPipelineRef : arrayList) {
            this.remove(pSDevSlnPipelineRef);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnPipelineRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnPipelineRef> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnPipelineRef pSDevSlnPipelineRef) throws Exception {
        super.onBeforeRemove(pSDevSlnPipelineRef);
    }

    protected void replaceParentInfo(PSDevSlnPipelineRef pSDevSlnPipelineRef, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnPipelineRef, cloneSession);
        if (pSDevSlnPipelineRef.getPSDevSlnPipelineId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNPIPELINE", (Object)pSDevSlnPipelineRef.getPSDevSlnPipelineId())) != null) {
            this.onFillParentInfo_PSDevSlnPipeline(pSDevSlnPipelineRef, (PSDevSlnPipeline)iEntity);
        }
        if (pSDevSlnPipelineRef.getRefPSDevSlnPipelineId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNPIPELINE", (Object)pSDevSlnPipelineRef.getRefPSDevSlnPipelineId())) != null) {
            this.onFillParentInfo_RefPSDevSlnPipeline(pSDevSlnPipelineRef, (PSDevSlnPipeline)iEntity);
        }
        if (pSDevSlnPipelineRef.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDevSlnPipelineRef.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnPipelineRef, (PSDevSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnPipelineRef, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CondModel(bl, pSDevSlnPipelineRef, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondModelFlag(bl, pSDevSlnPipelineRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnPipelineRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDevSlnPipelineRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDevSlnPipelineRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineId(bl, pSDevSlnPipelineRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineRefId(bl, pSDevSlnPipelineRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineRefName(bl, pSDevSlnPipelineRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefMode(bl, pSDevSlnPipelineRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefParams(bl, pSDevSlnPipelineRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDevSlnPipelineId(bl, pSDevSlnPipelineRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefTag(bl, pSDevSlnPipelineRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefTag2(bl, pSDevSlnPipelineRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefTag3(bl, pSDevSlnPipelineRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefTag4(bl, pSDevSlnPipelineRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDevSlnPipelineRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDevSlnPipelineRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDevSlnPipelineRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDevSlnPipelineRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDevSlnPipelineRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevSlnPipelineRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnPipelineRef, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CondModel(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isCondModelDirty() : !pSDevSlnPipelineRef.isCondModelDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineRef.getCondModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondModel_Default(pSDevSlnPipelineRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CondModelFlag(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isCondModelFlagDirty() && !bl2 : !pSDevSlnPipelineRef.isCondModelFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnPipelineRef.getCondModelFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDMODELFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_CondModelFlag_Default(pSDevSlnPipelineRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isMemoDirty() : !pSDevSlnPipelineRef.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineRef.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSlnPipelineRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isOrderValueDirty() : !pSDevSlnPipelineRef.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDevSlnPipelineRef.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDevSlnPipelineRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isPSDevSlnIdDirty() : !pSDevSlnPipelineRef.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineRef.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSDevSlnPipelineRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnPipelineId(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isPSDevSlnPipelineIdDirty() : !pSDevSlnPipelineRef.isPSDevSlnPipelineIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineRef.getPSDevSlnPipelineId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineId_Default(pSDevSlnPipelineRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnPipelineRefId(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isPSDevSlnPipelineRefIdDirty() && !bl2 : !pSDevSlnPipelineRef.isPSDevSlnPipelineRefIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineRef.getPSDevSlnPipelineRefId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINEREFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineRefId_Default(pSDevSlnPipelineRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINEREFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnPipelineRefName(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isPSDevSlnPipelineRefNameDirty() && !bl2 : !pSDevSlnPipelineRef.isPSDevSlnPipelineRefNameDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineRef.getPSDevSlnPipelineRefName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINEREFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineRefName_Default(pSDevSlnPipelineRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINEREFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefMode(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isRefModeDirty() && !bl2 : !pSDevSlnPipelineRef.isRefModeDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineRef.getRefMode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefMode_Default(pSDevSlnPipelineRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefParams(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isRefParamsDirty() : !pSDevSlnPipelineRef.isRefParamsDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineRef.getRefParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefParams_Default(pSDevSlnPipelineRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDevSlnPipelineId(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isRefPSDevSlnPipelineIdDirty() && !bl2 : !pSDevSlnPipelineRef.isRefPSDevSlnPipelineIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineRef.getRefPSDevSlnPipelineId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEVSLNPIPELINEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDevSlnPipelineId_Default(pSDevSlnPipelineRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEVSLNPIPELINEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefTag(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isRefTagDirty() : !pSDevSlnPipelineRef.isRefTagDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineRef.getRefTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefTag_Default(pSDevSlnPipelineRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefTag2(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isRefTag2Dirty() : !pSDevSlnPipelineRef.isRefTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnPipelineRef.getRefTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefTag2_Default(pSDevSlnPipelineRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefTag3(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isRefTag3Dirty() : !pSDevSlnPipelineRef.isRefTag3Dirty()) {
            return null;
        }
        String string = pSDevSlnPipelineRef.getRefTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefTag3_Default(pSDevSlnPipelineRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefTag4(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isRefTag4Dirty() : !pSDevSlnPipelineRef.isRefTag4Dirty()) {
            return null;
        }
        String string = pSDevSlnPipelineRef.getRefTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefTag4_Default(pSDevSlnPipelineRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isUserCatDirty() : !pSDevSlnPipelineRef.isUserCatDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineRef.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDevSlnPipelineRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isUserTagDirty() : !pSDevSlnPipelineRef.isUserTagDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineRef.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDevSlnPipelineRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isUserTag2Dirty() : !pSDevSlnPipelineRef.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnPipelineRef.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDevSlnPipelineRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isUserTag3Dirty() : !pSDevSlnPipelineRef.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDevSlnPipelineRef.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDevSlnPipelineRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isUserTag4Dirty() : !pSDevSlnPipelineRef.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDevSlnPipelineRef.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDevSlnPipelineRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineRef.isValidFlagDirty() && !bl2 : !pSDevSlnPipelineRef.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnPipelineRef.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDevSlnPipelineRef, bl2, bl3);
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

    protected void onSyncEntity(PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnPipelineRef, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnPipelineRef pSDevSlnPipelineRef, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnPipelineRef, bl);
    }

    public Object getDataContextValue(PSDevSlnPipelineRef pSDevSlnPipelineRef, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSlnPipelineRef, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnPipelineRef pSDevSlnPipelineRef, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnPipelineRef, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONDMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondModelFlag_Default(iEntity, bl, bl2);
        }
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
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINEREFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineRefId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINEREFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineRefName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEVSLNPIPELINEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDevSlnPipelineId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEVSLNPIPELINENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDevSlnPipelineName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefTag4_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CondModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CondModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDevSlnPipelineId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNPIPELINEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnPipelineName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNPIPELINENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnPipelineRefId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNPIPELINEREFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnPipelineRefName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNPIPELINEREFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFMODE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDevSlnPipelineId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEVSLNPIPELINEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDevSlnPipelineName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEVSLNPIPELINENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFTAG3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFTAG4", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDevSlnPipelineRef pSDevSlnPipelineRef) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnPipelineRef)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnPipelineRef pSDevSlnPipelineRef) throws Exception {
        super.onUpdateParent(pSDevSlnPipelineRef);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnPipelineRef pSDevSlnPipelineRef, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNPIPELINEREF");
        if (!bl) {
            pSDevSlnPipelineRef.setCreateDate(null);
            pSDevSlnPipelineRef.setCreateMan(null);
            pSDevSlnPipelineRef.setPSDevSlnPipelineRefId(null);
            pSDevSlnPipelineRef.setUpdateDate(null);
            pSDevSlnPipelineRef.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnPipelineRef, xmlNode, bl);
        }
    }
}

