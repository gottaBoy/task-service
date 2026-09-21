/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.bdscheme.service;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDColSet;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColSetServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysBDColSetService
extends PSSysBDColSetServiceBase {
    private static final Log log = LogFactory.getLog(PSSysBDColSetService.class);

    @Override
    protected void onBeforeRemove(PSSysBDColSet pSSysBDColSet) throws Exception {
        PSSysBDColSet pSSysBDColSet2;
        if (!pSSysBDColSet.isDefaultFlagDirty() && DataObject.getBoolValue((Integer)(pSSysBDColSet2 = (PSSysBDColSet)this.getLast((IEntity)pSSysBDColSet)).getDefaultFlag(), (boolean)false)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u5220\u9664\u5927\u6570\u636e\u8868\u9ed8\u8ba4\u5217\u65cf"));
        }
        if (DataObject.getBoolValue((Integer)pSSysBDColSet.getDefaultFlag(), (boolean)false)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u5220\u9664\u5927\u6570\u636e\u8868\u9ed8\u8ba4\u5217\u65cf"));
        }
        super.onBeforeRemove(pSSysBDColSet);
    }

    protected boolean onFillEntityKeyValue(PSSysBDColSet pSSysBDColSet, boolean bl) throws Exception {
        if (DataObject.getBoolValue((Integer)pSSysBDColSet.getDefaultFlag(), (boolean)false) && !StringHelper.isNullOrEmpty((String)pSSysBDColSet.getPSSysBDTableId())) {
            pSSysBDColSet.setPSSysBDColSetId(pSSysBDColSet.getPSSysBDTableId());
            return true;
        }
        return super.onFillEntityKeyValue((IEntity)pSSysBDColSet, bl);
    }
}

