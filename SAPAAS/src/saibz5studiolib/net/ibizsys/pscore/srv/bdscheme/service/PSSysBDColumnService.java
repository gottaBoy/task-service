/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.bdscheme.service;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDColumn;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColumnServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysBDColumnService
extends PSSysBDColumnServiceBase {
    private static final Log log = LogFactory.getLog(PSSysBDColumnService.class);

    @Override
    protected void onBeforeCreate(PSSysBDColumn pSSysBDColumn) throws Exception {
        pSSysBDColumn.setFullColName(StringHelper.format((String)"%1$s.%2$s", (Object)pSSysBDColumn.getPSSysBDColSetName(), (Object)pSSysBDColumn.getPSSysBDColumnName()).toUpperCase());
        super.onBeforeCreate(pSSysBDColumn);
    }

    @Override
    protected void onBeforeUpdate(PSSysBDColumn pSSysBDColumn) throws Exception {
        if (pSSysBDColumn.isPSSysBDColSetNameDirty() && pSSysBDColumn.isPSSysBDColumnNameDirty()) {
            pSSysBDColumn.setFullColName(StringHelper.format((String)"%1$s.%2$s", (Object)pSSysBDColumn.getPSSysBDColSetName(), (Object)pSSysBDColumn.getPSSysBDColumnName()).toUpperCase());
        }
        super.onBeforeUpdate(pSSysBDColumn);
    }
}

