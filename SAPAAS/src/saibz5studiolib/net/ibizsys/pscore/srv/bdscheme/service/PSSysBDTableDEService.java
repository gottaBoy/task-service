/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.bdscheme.service;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDColSet;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableDE;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColSetService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDEServiceBase;
import net.ibizsys.pscore.srv.codelist.BDTableDETypeCodeListModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysBDTableDEService
extends PSSysBDTableDEServiceBase {
    private static final Log log = LogFactory.getLog(PSSysBDTableDEService.class);

    @Override
    protected void onBeforeCreate(PSSysBDTableDE pSSysBDTableDE) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSSysBDTableDE.getPSSysBDTableDEName())) {
            pSSysBDTableDE.setPSSysBDTableDEName(pSSysBDTableDE.getPSDEName());
        }
        if (!PSSysBDTableDEService.isImpSysModelNowEx()) {
            this.createDefaultPSSysBDColSet(pSSysBDTableDE);
        }
        super.onBeforeCreate(pSSysBDTableDE);
    }

    @Override
    protected void onBeforeRemove(PSSysBDTableDE pSSysBDTableDE) throws Exception {
        PSSysBDTableDE pSSysBDTableDE2;
        if (!pSSysBDTableDE.isDefaultFlagDirty() && DataObject.getIntegerValue((Object)(pSSysBDTableDE2 = (PSSysBDTableDE)this.getLast(pSSysBDTableDE)).getDefaultFlag(), (Integer)0) > 0) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u5220\u9664\u9ed8\u8ba4\u5927\u6570\u636e\u8868\u5b9e\u4f53\u5173\u7cfb"));
        }
        if (DataObject.getIntegerValue((Object)pSSysBDTableDE.getDefaultFlag(), (Integer)0) > 0) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u5220\u9664\u9ed8\u8ba4\u5927\u6570\u636e\u8868\u5b9e\u4f53\u5173\u7cfb"));
        }
        super.onBeforeRemove(pSSysBDTableDE);
    }

    protected void createDefaultPSSysBDColSet(PSSysBDTableDE pSSysBDTableDE) throws Exception {
        if (pSSysBDTableDE.getDefaultFlag() == BDTableDETypeCodeListModel.DEFAULT || pSSysBDTableDE.getDefaultFlag() == BDTableDETypeCodeListModel.RELATED) {
            PSSysBDColSetService pSSysBDColSetService = (PSSysBDColSetService)ServiceGlobal.getService(PSSysBDColSetService.class, (SessionFactory)this.getSessionFactory());
            PSSysBDColSet pSSysBDColSet = new PSSysBDColSet();
            pSSysBDColSet.setPSSysBDColSetName(pSSysBDTableDE.getPSDEName());
            pSSysBDColSet.setPSSysBDTableId(pSSysBDTableDE.getPSSysBDTableId());
            if (!pSSysBDColSetService.select(pSSysBDColSet, true)) {
                pSSysBDColSet.setCodeName(pSSysBDTableDE.getPSDE().getCodeName());
                pSSysBDColSet.setLogicName(pSSysBDTableDE.getPSDE().getLogicName());
                pSSysBDColSet.setDefaultFlag(0);
                pSSysBDColSetService.create(pSSysBDColSet);
            }
            pSSysBDTableDE.setPSSysBDColSetId(pSSysBDColSet.getPSSysBDColSetId());
            pSSysBDTableDE.setPSSysBDColSetName(pSSysBDColSet.getPSSysBDColSetName());
        } else {
            pSSysBDTableDE.setPSSysBDColSetId(pSSysBDTableDE.getPSSysBDTableId());
        }
    }

    @Override
    public String getModelV2Tag(PSSysBDTableDE pSSysBDTableDE) {
        if (!StringHelper.isNullOrEmpty((String)pSSysBDTableDE.getPSDEName())) {
            if (DataObject.getBoolValue((Integer)pSSysBDTableDE.getDefaultFlag(), (boolean)false)) {
                return pSSysBDTableDE.getPSDEName();
            }
            return StringHelper.format((String)"%1$s#%2$s", (Object)pSSysBDTableDE.getPSDEName(), (Object)pSSysBDTableDE.getDefaultFlag());
        }
        return super.getModelV2Tag(pSSysBDTableDE);
    }
}

