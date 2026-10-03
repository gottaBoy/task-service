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
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParam;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDELogicParamService
extends PSDELogicParamServiceBase {
    private static final Log log = LogFactory.getLog(PSDELogicParamService.class);

    protected boolean onFillEntityKeyValue(PSDELogicParam pSDELogicParam, boolean bl) throws Exception {
        if (pSDELogicParam.getDefaultParam() != null && pSDELogicParam.getDefaultParam() == 1) {
            pSDELogicParam.setPSDELogicParamId(pSDELogicParam.getPSDELogicId());
            return true;
        }
        return super.onFillEntityKeyValue(pSDELogicParam, bl);
    }

    @Override
    protected void onBeforeUpdateTemp(PSDELogicParam pSDELogicParam) throws Exception {
        if (pSDELogicParam.isParamPSDEIdDirty() && StringHelper.compare((String)pSDELogicParam.getPSDELogic().getLogicType(), (String)"DELOGIC", (boolean)true) == 0 && StringHelper.isNullOrEmpty((String)pSDELogicParam.getParamPSDEId()) && DataObject.getBoolValue((Integer)pSDELogicParam.getDefaultParam(), (boolean)false)) {
            pSDELogicParam.setParamPSDEId(pSDELogicParam.getPSDELogic().getPSDEId());
            pSDELogicParam.setParamPSDEName(pSDELogicParam.getPSDELogic().getPSDEName());
        }
        super.onBeforeUpdateTemp(pSDELogicParam);
    }

    @Override
    protected void onBeforeUpdate(PSDELogicParam pSDELogicParam) throws Exception {
        if (pSDELogicParam.isParamPSDEIdDirty() && StringHelper.compare((String)pSDELogicParam.getPSDELogic().getLogicType(), (String)"DELOGIC", (boolean)true) == 0 && StringHelper.isNullOrEmpty((String)pSDELogicParam.getParamPSDEId()) && DataObject.getBoolValue((Integer)pSDELogicParam.getDefaultParam(), (boolean)false)) {
            pSDELogicParam.setParamPSDEId(pSDELogicParam.getPSDELogic().getPSDEId());
            pSDELogicParam.setParamPSDEName(pSDELogicParam.getPSDELogic().getPSDEName());
        }
        super.onBeforeUpdate(pSDELogicParam);
    }
}

