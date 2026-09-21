/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.demodel.IDEWFModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psrt.srv.wf.entity.WFInstance
 *  net.ibizsys.psrt.srv.wf.service.WFInstanceService
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFService
 *  net.ibizsys.pswf.core.WFActionParam
 *  net.ibizsys.pswf.core.WFActionResult
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.demodel.IDEWFModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.WFActionParam;
import net.ibizsys.pswf.core.WFActionResult;
import net.ibizsys.pswf.core.WFDEModelBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class DEWFModelBase
extends WFDEModelBase
implements IDEWFModel {
    private static final Log log = LogFactory.getLog(DEWFModelBase.class);
    private IDataEntity iDataEntity = null;
    private IWFModel iWFModel = null;

    public void init(IDataEntity iDataEntity) throws Exception {
        this.setDataEntity(iDataEntity);
        this.onInit();
    }

    protected void setDataEntity(IDataEntity iDataEntity) {
        this.iDataEntity = iDataEntity;
    }

    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    public IDataEntityModel getDEModel() {
        return (IDataEntityModel)this.getDataEntity();
    }

    protected void onInit() throws Exception {
    }

    @Override
    public IWFModel getWFModel() {
        if (this.iWFModel == null) {
            try {
                ISystemModel iSystemModel = (ISystemModel)this.getDataEntity().getSystem();
                this.iWFModel = iSystemModel.getWFModel(this.getWorkflowId());
                this.setWFModel(this.iWFModel);
            }
            catch (Exception e) {
                log.error((Object)e);
            }
        }
        return super.getWFModel();
    }

    public String getWFEditViewPDTParam(IEntity iEntity, boolean bWorkMode) throws Exception {
        return this.getWFEditViewPDTParam(iEntity, bWorkMode, 0);
    }

    public String getWFEditViewPDTParam(IEntity iEntity, boolean bWorkMode, int nAppType) throws Exception {
        boolean bWorkFlow = this.testDataInWF(iEntity);
        if (bWorkFlow) {
            boolean bMultiForm = this.getDEModel().isEnableMultiForm();
            Object multiFormValue = null;
            if (bMultiForm && (multiFormValue = iEntity.get(this.getDEModel().getMultiFormDEField().getName())) == null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u591a\u8868\u5355\u8bc6\u522b\u6570\u636e"));
            }
            Object wfStepValue = iEntity.get(this.getWFStepField());
            int nVer = 1;
            if (!StringHelper.isNullOrEmpty((String)this.getWFVerField())) {
                nVer = DataObject.getIntegerValue((IDataObject)iEntity, (String)this.getWFVerField(), (int)nVer);
            }
            if (nAppType == 2) {
                if (multiFormValue == null) {
                    if (bWorkMode) {
                        return "MOBWFEDITVIEW:" + StringHelper.format((String)"%1$s:%3$sW:%2$s", (Object)this.getName(), (Object)wfStepValue, (Object)(nVer == 1 ? "" : Integer.valueOf(nVer)));
                    }
                    return "MOBWFEDITVIEW:" + StringHelper.format((String)"%1$s:D", (Object)this.getName());
                }
                if (bWorkMode) {
                    return "MOBWFEDITVIEW:" + StringHelper.format((String)"%3$s:%1$s:%4$sW:%2$s", (Object)this.getName(), (Object)wfStepValue, (Object)multiFormValue, (Object)(nVer == 1 ? "" : Integer.valueOf(nVer)));
                }
                return "MOBWFEDITVIEW:" + StringHelper.format((String)"%2$s:%1$s:D", (Object)this.getName(), (Object)multiFormValue);
            }
            if (multiFormValue == null) {
                if (bWorkMode) {
                    return "WFEDITVIEW:" + StringHelper.format((String)"%1$s:%3$sW:%2$s", (Object)this.getName(), (Object)wfStepValue, (Object)(nVer == 1 ? "" : Integer.valueOf(nVer)));
                }
                return "WFEDITVIEW:" + StringHelper.format((String)"%1$s:D", (Object)this.getName());
            }
            if (bWorkMode) {
                return "WFEDITVIEW:" + StringHelper.format((String)"%3$s:%1$s:%4$sW:%2$s", (Object)this.getName(), (Object)wfStepValue, (Object)multiFormValue, (Object)(nVer == 1 ? "" : Integer.valueOf(nVer)));
            }
            return "WFEDITVIEW:" + StringHelper.format((String)"%2$s:%1$s:D", (Object)this.getName(), (Object)multiFormValue);
        }
        return null;
    }

    public boolean testUserWFSubmit(IEntity iEntity, String strCurUserId, SessionFactory sessionFactory) throws Exception {
        String strWFInstId = DataObject.getStringValue((IDataObject)iEntity, (String)this.getWFInstField(), null);
        if (StringHelper.isNullOrEmpty((String)strWFInstId)) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u6570\u636e\u6ca1\u6709\u6d41\u7a0b\u5b9e\u4f8b\u6807\u793a"));
        }
        WFInstanceService wfInstanceService = (WFInstanceService)ServiceGlobal.getService(WFInstanceService.class, (SessionFactory)sessionFactory);
        WFInstance wfInstance = new WFInstance();
        wfInstance.setWFInstanceId(strWFInstId);
        wfInstanceService.get((IEntity)wfInstance);
        String strStepId = wfInstance.getActiveStepName();
        IWFService iWFService = this.getWFModel().getWFService();
        WFActionParam wfActionParam = new WFActionParam();
        wfActionParam.setUserData((String)iEntity.get(this.getDEModel().getKeyDEField().getName()));
        wfActionParam.setUserData4(this.getDEModel().getId());
        wfActionParam.setOpPersonId(strCurUserId);
        wfActionParam.setStepId(strStepId);
        wfActionParam.setTestMode(true);
        WFActionResult wfActionResult = iWFService.submit(wfActionParam);
        return !wfActionResult.isError();
    }
}

