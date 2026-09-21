/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAWItem;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAWItemServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEAWItemService
extends PSDEAWItemServiceBase {
    private static final Log log = LogFactory.getLog(PSDEAWItemService.class);

    @Override
    protected void onBeforeCreateTemp(PSDEAWItem pSDEAWItem) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDEAWItem.getPSDEAWItemName())) {
            pSDEAWItem.setPSDEAWItemName(pSDEAWItem.getPSDEFName());
        }
        super.onBeforeCreateTemp(pSDEAWItem);
    }

    @Override
    protected void onBeforeCreate(PSDEAWItem pSDEAWItem) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDEAWItem.getPSDEAWItemName())) {
            pSDEAWItem.setPSDEAWItemName(pSDEAWItem.getPSDEFName());
        }
        super.onBeforeCreate(pSDEAWItem);
    }
}

