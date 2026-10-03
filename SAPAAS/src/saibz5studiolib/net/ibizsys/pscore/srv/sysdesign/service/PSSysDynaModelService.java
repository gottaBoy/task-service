/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysDynaModelService
extends PSSysDynaModelServiceBase {
    private static final Log log = LogFactory.getLog(PSSysDynaModelService.class);

    @Override
    protected void onBeforeCreate(PSSysDynaModel pSSysDynaModel) throws Exception {
        if (DataObject.getBoolValue((Integer)pSSysDynaModel.getDefaultFlag(), (boolean)false)) {
            PSSysDynaModel pSSysDynaModel2 = new PSSysDynaModel();
            pSSysDynaModel2.setPSSystemId(pSSysDynaModel.getPSSystemId());
            pSSysDynaModel2.setDefaultFlag(1);
            pSSysDynaModel2.setPSModuleId(pSSysDynaModel.getPSModuleId());
            if (this.existsData(pSSysDynaModel2)) {
                pSSysDynaModel2.setDefaultFlag(0);
                this.update(pSSysDynaModel2, false);
            }
        }
        if (StringHelper.length((String)pSSysDynaModel.getDynaModel()) > 4000) {
            pSSysDynaModel.setDynaModel2(pSSysDynaModel.getDynaModel());
            pSSysDynaModel.setDynaModel(null);
        } else if (!StringHelper.isNullOrEmpty((String)pSSysDynaModel.getDynaModel())) {
            pSSysDynaModel.setDynaModel2(null);
        }
        super.onBeforeCreate(pSSysDynaModel);
    }

    @Override
    protected void onBeforeUpdate(PSSysDynaModel pSSysDynaModel) throws Exception {
        if (DataObject.getBoolValue((Integer)pSSysDynaModel.getDefaultFlag(), (boolean)false)) {
            PSSysDynaModel pSSysDynaModel2 = new PSSysDynaModel();
            pSSysDynaModel2.setPSSystemId(pSSysDynaModel.getPSSystemId());
            pSSysDynaModel2.setDefaultFlag(1);
            pSSysDynaModel2.setPSModuleId(pSSysDynaModel.getPSModuleId());
            if (this.existsData(pSSysDynaModel2)) {
                pSSysDynaModel2.setDefaultFlag(0);
                this.update(pSSysDynaModel2, false);
            }
        }
        if (StringHelper.length((String)pSSysDynaModel.getDynaModel()) > 4000) {
            pSSysDynaModel.setDynaModel2(pSSysDynaModel.getDynaModel());
            pSSysDynaModel.setDynaModel(null);
        } else if (pSSysDynaModel.isDynaModelDirty()) {
            pSSysDynaModel.setDynaModel2(null);
        }
        super.onBeforeUpdate(pSSysDynaModel);
    }

    protected CallResult internalGet(PSSysDynaModel pSSysDynaModel, boolean bl) throws Exception {
        CallResult callResult = super.internalGet(pSSysDynaModel, bl);
        if (callResult.isOk() && !StringHelper.isNullOrEmpty((String)pSSysDynaModel.getDynaModel2())) {
            pSSysDynaModel.setDynaModel(pSSysDynaModel.getDynaModel2());
        }
        return callResult;
    }
}

