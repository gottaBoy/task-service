/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.util.DefaultValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.pswf.core.IWFActionContext
 */
package net.ibizsys.pswf.core;

import java.util.Iterator;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.DefaultValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFDEActionProcessModel;
import net.ibizsys.pswf.core.IWFDEActionProcessParamModel;
import net.ibizsys.pswf.core.WFProcessBase;

public class WFDEActionProcess
extends WFProcessBase {
    public IWFDEActionProcessModel getWFDEActionProcessModel() {
        return (IWFDEActionProcessModel)this.getWFProcessModel();
    }

    @Override
    public void execute(IWFActionContext iWFActionContext) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getWFDEActionProcessModel().getDEActionName())) {
            String strDataKey = iWFActionContext.getWFActionParam().getUserData();
            String strDEName = iWFActionContext.getWFActionParam().getUserData4();
            IDataEntityModel iDataEntityModel = iWFActionContext.getWFModel().getSystemModel().getDataEntityModel(strDEName);
            IService iService = iDataEntityModel.getService();
            IEntity iEntity = iWFActionContext.getActiveEntity();
            iEntity.set("SRF_PERSONID", (Object)iWFActionContext.getOpPersonId());
            Iterator<IWFDEActionProcessParamModel> wfDEActionProcessParamModels = this.getWFDEActionProcessModel().getWFDEActionProcessParamModels();
            while (wfDEActionProcessParamModels.hasNext()) {
                IWFDEActionProcessParamModel iWFDEActionProcessParamModel = wfDEActionProcessParamModels.next();
                iEntity.set(iWFDEActionProcessParamModel.getDstField(), (Object)this.getSrcValue(iWFDEActionProcessParamModel));
            }
            if (StringHelper.isNullOrEmpty((String)this.getWFDEActionProcessModel().getDEActionName())) {
                iService.updateWFInfo(IService.UPDATEWFINFOMODE_UPDATESTATE.intValue(), iWFActionContext, iEntity);
            } else {
                iService.executeAction(this.getWFDEActionProcessModel().getDEActionName(), iEntity);
            }
        }
        super.execute(iWFActionContext);
    }

    protected String getSrcValue(IWFDEActionProcessParamModel iWFDEActionProcessParamModel) throws Exception {
        return DefaultValueHelper.getValue((IWebContext)WebContext.getCurrent(), (String)iWFDEActionProcessParamModel.getSrcValueType(), (String)iWFDEActionProcessParamModel.getSrcValue());
    }
}

