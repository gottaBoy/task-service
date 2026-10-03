/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.paasmgr.service;

import java.sql.Timestamp;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioPluginData;
import net.ibizsys.pscore.srv.paasmgr.service.PSStudioPluginDataServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSStudioPluginDataService
extends PSStudioPluginDataServiceBase {
    private static final Log log = LogFactory.getLog(PSStudioPluginDataService.class);

    @Override
    protected void onBeforeCreate(PSStudioPluginData pSStudioPluginData) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSStudioPluginData.getPSDevCenterId())) {
            pSStudioPluginData.setPSDevCenterId(PSStudioPluginDataService.getCurrentPSDCId());
        }
        super.onBeforeCreate(pSStudioPluginData);
    }

    @Override
    protected void onBeforeUpdate(PSStudioPluginData pSStudioPluginData) throws Exception {
        PSStudioPluginData pSStudioPluginData2 = (PSStudioPluginData)this.getLast(pSStudioPluginData);
        int n = DataTypeHelper.getIntegerValue((Object)pSStudioPluginData2.getActionState(), (Integer)30);
        if (n == 30 || n == 40) {
            throw new Exception("\u66f4\u65b0\u64cd\u4f5c\u72b6\u6001\u4e0d\u6b63\u786e");
        }
        if (n == 10 && DataTypeHelper.getIntegerValue((Object)pSStudioPluginData.getActionState(), (Integer)20) == 20) {
            if (pSStudioPluginData.getBeginTime() == null) {
                pSStudioPluginData.setBeginTime(new Timestamp(System.currentTimeMillis()));
            }
            pSStudioPluginData.setActionState(20);
        }
        if (pSStudioPluginData.getActionState() != null && ((n = DataTypeHelper.getIntegerValue((Object)pSStudioPluginData.getActionState(), (Integer)20).intValue()) == 30 || n == 40) && pSStudioPluginData.getEndTime() == null) {
            pSStudioPluginData.setEndTime(new Timestamp(System.currentTimeMillis()));
        }
        super.onBeforeUpdate(pSStudioPluginData);
    }
}

