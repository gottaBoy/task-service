/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSModelStorage
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dynasys.IPSDynaInst
 *  net.ibizsys.model.wf.IPSWorkflow
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.util.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psrt.srv.wf.entity.WFWorkflow
 *  net.ibizsys.psrt.srv.wf.service.WFWorkflowService
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.saas.sysmodel.SystemModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.beans.factory.annotation.Qualifier
 */
package net.ibizsys.ssdyna.sysmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.IPSModelStorage;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dynasys.IPSDynaInst;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wf.entity.WFWorkflow;
import net.ibizsys.psrt.srv.wf.service.WFWorkflowService;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.ssdyna.core.IDynaDETemplModel;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;
import net.ibizsys.ssdyna.service.IDynaService;
import net.ibizsys.ssdyna.sysmodel.DynaInstModel;
import net.ibizsys.ssdyna.sysmodel.IDynaInstModel;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.ssdyna.web.WebContext;
import net.ibizsys.ssdynawf.core.IDynaWFModel;
import net.ibizsys.ssdynawf.core.IDynaWFRuntime;
import net.ibizsys.ssdynawf.sysmodel.DefaultDynaWFUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class SystemModelBase
extends net.ibizsys.saas.sysmodel.SystemModelBase
implements IDynaSysModel {
    private static final Log log = LogFactory.getLog(SystemModelBase.class);
    private HashMap<String, IDynaDETemplModel> dynaDETemplModelMap = new HashMap();
    private ArrayList<IDynaDETemplModel> dynaDETemplModelList = new ArrayList();
    private HashMap<String, IDynaInstModel> dynaInstMap = new HashMap();
    @Autowired(required=false)
    @Qualifier(value="dynaModelStorage")
    private IPSModelStorage dynaModelStorage;

    public SystemModelBase() {
        this.registerSystemUtilObj("SAASWF", DefaultDynaWFUtil.class.getCanonicalName());
    }

    @Override
    public IPSModelStorage getDynaModelStorage() {
        return this.dynaModelStorage;
    }

    public void postConstruct() throws Exception {
        super.postConstruct();
    }

    @Override
    public IPSSystem getPSSystem() throws Exception {
        return this.getPSSystem(true);
    }

    public IPSSystem getPSSystem(boolean bDynaInst) throws Exception {
        if (bDynaInst) {
            String strDynaInstId = WebContext.getDynaSysInstId(true);
            if (StringHelper.isNullOrEmpty((String)strDynaInstId)) {
                return this.getPSSystem(false);
            }
            return this.getPSSystem(false).getPSDynaInst(strDynaInstId);
        }
        if (this.getDynaModelStorage() != null) {
            return this.getDynaModelStorage().getPSSystem();
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u52a8\u6001\u7cfb\u7edf\u6a21\u578b"));
    }

    public IPSDynaInst getPSDynaInst() throws Exception {
        String strDynaInstId = WebContext.getDynaSysInstId(false);
        return this.getPSSystem(false).getPSDynaInst(strDynaInstId);
    }

    @Override
    public IDynaService getDynaService(String strDEId, SessionFactory sessionFactory) throws Exception {
        IDynaDEModel iDynaDEModel = this.getDynaDEModel(strDEId);
        return (IDynaService)iDynaDEModel.getService(sessionFactory);
    }

    @Override
    public IDynaDEModel getDynaDEModel(String strDEId) throws Exception {
        String strDynaInstId = WebContext.getDynaSysInstId(false);
        IDynaInstModel iDynaInstModel = this.getDynaInstModel(strDynaInstId);
        IDynaDEModel iDynaDEModel = iDynaInstModel.getDynaDEModel(strDEId, true);
        if (iDynaDEModel != null) {
            return iDynaDEModel;
        }
        IPSDataEntity iPSDataEntity = this.getPSDynaInst().getPSDataEntity(strDEId);
        iDynaDEModel = this.createDynaDEModel(iPSDataEntity);
        iDynaDEModel.init(this, iPSDataEntity);
        iDynaInstModel.registerDynaDEModel(iDynaDEModel);
        return iDynaDEModel;
    }

    protected IDynaDEModel createDynaDEModel(IPSDataEntity iPSDataEntity) throws Exception {
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u521b\u5efa\u5b9e\u4f53[%1$s]\u52a8\u6001\u5b9e\u4f53\u6a21\u578b\u5bf9\u8c61", (Object)iPSDataEntity.getName()));
    }

    @Override
    public void registerDynaDETemplModel(IDynaDETemplModel iDynaDETemplModel) throws Exception {
        this.dynaDETemplModelMap.put(iDynaDETemplModel.getId(), iDynaDETemplModel);
        this.dynaDETemplModelMap.put(iDynaDETemplModel.getTemplDEName(), iDynaDETemplModel);
        this.dynaDETemplModelList.add(iDynaDETemplModel);
    }

    @Override
    public IDynaDETemplModel getDynaDETemplModel(String strDynaDETemplModelId) throws Exception {
        IDynaDETemplModel iDynaDETemplModel = this.dynaDETemplModelMap.get(strDynaDETemplModelId);
        if (iDynaDETemplModel == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u52a8\u6001\u5b9e\u4f53\u6a21\u677f\u5bf9\u8c61[%1$s]", (Object)strDynaDETemplModelId));
        }
        return iDynaDETemplModel;
    }

    @Override
    public Iterator<IDynaDETemplModel> getDynaDETemplModels() {
        return this.dynaDETemplModelList.iterator();
    }

    public IWFModel getWFModel(String strWFModelId, boolean bTryMode) throws Exception {
        String strDynaInstId = WebContext.getDynaSysInstId(true);
        if (!StringHelper.isNullOrEmpty((String)strDynaInstId)) {
            IWFModel iWFModel = super.getWFModel(strWFModelId, true);
            if (iWFModel != null) {
                return iWFModel;
            }
            IDynaInstModel iDynaInstModel = this.getDynaInstModel(strDynaInstId);
            if (iDynaInstModel.containsDynaWFModel(strWFModelId)) {
                return iDynaInstModel.getDynaWFModel(strWFModelId);
            }
            IPSWorkflow iPSWorkflow = null;
            try {
                iPSWorkflow = this.getPSDynaInst().getPSWorkflow(strWFModelId);
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            if (iPSWorkflow == null) {
                if (bTryMode) {
                    return null;
                }
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\uff0c\u6d41\u7a0b\u6807\u8bc6[%1$s]", (Object)strWFModelId));
            }
            IDynaWFRuntime iDynaWFRuntime = (IDynaWFRuntime)ObjectHelper.create((String)"net.ibizsys.ssdynawf.core.DynaActivitiWFModel");
            iDynaWFRuntime.init(this, iPSWorkflow);
            iDynaInstModel.registerDynaWFModel((IDynaWFModel)((Object)iDynaWFRuntime));
            final IWFModel iWFModel2 = (IWFModel)iDynaWFRuntime;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    WFWorkflowService wfWorkflowService = (WFWorkflowService)ServiceGlobal.getService(WFWorkflowService.class);
                    WFWorkflow wfWorkflow = new WFWorkflow();
                    wfWorkflow.setWFWorkflowId(iWFModel2.getId());
                    if (wfWorkflowService.checkKey((IEntity)wfWorkflow) == 0) {
                        wfWorkflow.setWFWorkflowName(iWFModel2.getName());
                        wfWorkflow.setWFState(Integer.valueOf(1));
                        if (!StringHelper.isNullOrEmpty((String)iWFModel2.getRemindMsgTemplId())) {
                            wfWorkflow.setRemindMsgTemplId(iWFModel2.getRemindMsgTemplId());
                        }
                        wfWorkflow.setWFLogicName(iWFModel2.getName());
                        wfWorkflow.setWFVersion(Integer.valueOf(1));
                        wfWorkflow.setWFModel("<?xml version=\"1.0\" encoding=\"utf-8\" ?><SRFEXWFWORKFLOW></SRFEXWFWORKFLOW>");
                        wfWorkflow.set("SRF_PERSONID", (Object)"SYSTEM");
                        wfWorkflow.set("SRF_PERSONNAME", (Object)"\u7cfb\u7edf\u5185\u5efa\u7528\u6237");
                        wfWorkflowService.create((IEntity)wfWorkflow);
                        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", (Object)SystemModelBase.this.getName(), (Object)wfWorkflowService.getDEModel().getLogicName(), (Object)wfWorkflowService.getDEModel().getDataInfo((IEntity)wfWorkflow)));
                    }
                }
            });
            return iWFModel2;
        }
        return super.getWFModel(strWFModelId, bTryMode);
    }

    public IDataEntityModel getDataEntityModel(String strDEName, boolean bIncludeOtherSys) throws Exception {
        String strDynaInstId = WebContext.getDynaSysInstId(true);
        if (!StringHelper.isNullOrEmpty((String)strDynaInstId)) {
            IDynaInstModel iDynaInstModel = this.getDynaInstModel(strDynaInstId);
            IDynaDEModel iDynaDEModel = iDynaInstModel.getDynaDEModel(strDEName, true);
            if (iDynaDEModel != null) {
                return iDynaDEModel;
            }
            if (super.containsDataEntityModel(strDEName, bIncludeOtherSys)) {
                return super.getDataEntityModel(strDEName, bIncludeOtherSys);
            }
            IPSDataEntity iPSDataEntity = null;
            iPSDataEntity = this.getPSDynaInst().getPSDataEntity(strDEName);
            if (iPSDataEntity == null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]", (Object)strDEName));
            }
            iDynaDEModel = this.createDynaDEModel(iPSDataEntity);
            iDynaDEModel.init(this, iPSDataEntity);
            iDynaInstModel.registerDynaDEModel(iDynaDEModel);
            return iDynaDEModel;
        }
        return super.getDataEntityModel(strDEName, bIncludeOtherSys);
    }

    @Override
    public IDynaInstModel getDynaInstModel(String strDynaInstId) throws Exception {
        IPSDynaInst iPSDynaInst = null;
        iPSDynaInst = this.getPSSystem(false).getPSDynaInst(strDynaInstId);
        if (iPSDynaInst == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b[%1$s]", (Object)strDynaInstId));
        }
        IDynaInstModel iDynaInstModel = this.dynaInstMap.get(strDynaInstId);
        if (iDynaInstModel != null && StringHelper.compare((String)iDynaInstModel.getDynaTag(), (String)iPSDynaInst.getDynaTag(), (boolean)true) == 0) {
            return iDynaInstModel;
        }
        DynaInstModel dynaInstModel = new DynaInstModel();
        dynaInstModel.init(this, iPSDynaInst);
        this.dynaInstMap.put(strDynaInstId, dynaInstModel);
        return dynaInstModel;
    }

    @Override
    public void resetDynaInstModel(String strDynaInstId) {
        try {
            this.getPSSystem(false).resetPSDynaInst(strDynaInstId);
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        this.dynaInstMap.remove(strDynaInstId);
    }
}

