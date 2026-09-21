/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeItem
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.ViewRVModeCodeListModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewRV;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewRVServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEViewRVService
extends PSDEViewRVServiceBase {
    private static final Log log = LogFactory.getLog(PSDEViewRVService.class);

    public void getTemp(PSDEViewRV pSDEViewRV) throws Exception {
        super.getTemp((IEntity)pSDEViewRV);
        this.recalcRefModeAndRefModeParam(pSDEViewRV);
    }

    public boolean get(PSDEViewRV pSDEViewRV, boolean bl) throws Exception {
        boolean bl2 = super.get((IEntity)pSDEViewRV, bl);
        if (bl2) {
            this.recalcRefModeAndRefModeParam(pSDEViewRV);
        }
        return bl2;
    }

    protected void recalcRefModeAndRefModeParam(PSDEViewRV pSDEViewRV) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDEViewRV.getRefMode()) && !StringHelper.isNullOrEmpty((String)pSDEViewRV.getPSDEViewRVName())) {
            String string = "";
            String string2 = "";
            int n = pSDEViewRV.getPSDEViewRVName().indexOf(":");
            if (n == -1) {
                string = pSDEViewRV.getPSDEViewRVName();
            } else {
                string = pSDEViewRV.getPSDEViewRVName().substring(0, n);
                if (++n < pSDEViewRV.getPSDEViewRVName().length()) {
                    string2 = pSDEViewRV.getPSDEViewRVName().substring(n);
                }
            }
            ICodeItem iCodeItem = ViewRVModeCodeListModel.getInstance().getCodeItem(string, true);
            if (iCodeItem == null) {
                string = "CUSTOM";
                string2 = "";
            }
            pSDEViewRV.setRefMode(string);
            pSDEViewRV.setRefParam(string2);
        }
    }

    @Override
    protected void onBeforeCreate(PSDEViewRV pSDEViewRV) throws Exception {
        this.calcPSDEViewRVName(pSDEViewRV);
        super.onBeforeCreate(pSDEViewRV);
    }

    @Override
    protected void onBeforeCreateTemp(PSDEViewRV pSDEViewRV) throws Exception {
        this.calcPSDEViewRVName(pSDEViewRV);
        super.onBeforeCreateTemp(pSDEViewRV);
    }

    @Override
    protected void onBeforeUpdate(PSDEViewRV pSDEViewRV) throws Exception {
        super.onBeforeUpdate(pSDEViewRV);
    }

    protected void calcPSDEViewRVName(PSDEViewRV pSDEViewRV) {
        if (!pSDEViewRV.isRefModeDirty()) {
            return;
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEViewRV.getRefMode()) && StringHelper.compare((String)pSDEViewRV.getRefMode(), (String)"CUSTOM", (boolean)true) != 0) {
            if (StringHelper.isNullOrEmpty((String)pSDEViewRV.getRefParam())) {
                pSDEViewRV.setPSDEViewRVName(pSDEViewRV.getRefMode());
            } else {
                pSDEViewRV.setPSDEViewRVName(StringHelper.format((String)"%1$s:%2$s", (Object)pSDEViewRV.getRefMode(), (Object)pSDEViewRV.getRefParam()));
            }
            if (StringHelper.isNullOrEmpty((String)pSDEViewRV.getRefModeText())) {
                pSDEViewRV.setRefModeText(pSDEViewRV.getRefParamDesc());
            }
        }
    }
}

