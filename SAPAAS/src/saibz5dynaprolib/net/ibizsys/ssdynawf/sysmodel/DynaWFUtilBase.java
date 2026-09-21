/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.appmodel.AppViewModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.sswf.api.SaaSWFActionParam
 *  net.ibizsys.sswf.entity.WFServiceEntity
 *  net.ibizsys.sswf.entity.WFServiceEntityView
 *  net.ibizsys.sswf.sysmodel.util.SaaSWFUtilBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.ssdynawf.sysmodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.appmodel.AppViewModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.ssdyna.core.IDynaDETemplModel;
import net.ibizsys.ssdyna.core.IDynaDEViewTemplModel;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.sswf.api.SaaSWFActionParam;
import net.ibizsys.sswf.entity.WFServiceEntity;
import net.ibizsys.sswf.entity.WFServiceEntityView;
import net.ibizsys.sswf.sysmodel.util.SaaSWFUtilBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DynaWFUtilBase
extends SaaSWFUtilBase {
    private static final Log log = LogFactory.getLog(DynaWFUtilBase.class);

    public IDynaSysModel getDynaSysModel() {
        return (IDynaSysModel)this.getSystemModel();
    }

    public ArrayList<WFServiceEntity> getWFServiceEntities() throws Exception {
        ArrayList<WFServiceEntity> list = new ArrayList<WFServiceEntity>();
        Iterator<IDynaDETemplModel> dynaDETempls = this.getDynaSysModel().getDynaDETemplModels();
        if (dynaDETempls != null) {
            while (dynaDETempls.hasNext()) {
                IDynaDETemplModel iDynaDETemplModel = dynaDETempls.next();
                IDataEntityModel tempDEModel = this.getDynaSysModel().getDataEntityModel(iDynaDETemplModel.getTemplDEId());
                if (!tempDEModel.hasDEWF()) continue;
                WFServiceEntity wfServiceEntity = new WFServiceEntity();
                wfServiceEntity.setWFServiceEntityId(iDynaDETemplModel.getId());
                wfServiceEntity.setWFServiceEntityName(iDynaDETemplModel.getName());
                Iterator<IDynaDEViewTemplModel> dynaDEViewTemplModes = iDynaDETemplModel.getDynaDEViewTemplModels();
                if (dynaDEViewTemplModes != null) {
                    while (dynaDEViewTemplModes.hasNext()) {
                        IDynaDEViewTemplModel iDynaDEViewTemplModel = dynaDEViewTemplModes.next();
                        WFServiceEntityView wfServiceEntityView = new WFServiceEntityView();
                        wfServiceEntityView.setWFServiceEntityViewId(iDynaDEViewTemplModel.getId());
                        wfServiceEntityView.setWFServiceEntityViewName(iDynaDEViewTemplModel.getName());
                        Iterator<AppViewModel> appViewModels = iDynaDEViewTemplModel.getAppDynaDEViews();
                        if (appViewModels != null && appViewModels.hasNext()) {
                            AppViewModel appViewModel = appViewModels.next();
                            wfServiceEntityView.setAppId(appViewModel.getAppId());
                            wfServiceEntityView.setAppViewId(appViewModel.getId());
                            wfServiceEntityView.setAppViewUrl(appViewModel.getViewUrl());
                        }
                        wfServiceEntity.getViews().add(wfServiceEntityView);
                    }
                }
                list.add(wfServiceEntity);
            }
        }
        return list;
    }

    protected IWFModel getWFModel(SaaSWFActionParam wfParam) throws Exception {
        return this.getDynaSysModel().getWFModel(wfParam.getWorkflowId());
    }
}

