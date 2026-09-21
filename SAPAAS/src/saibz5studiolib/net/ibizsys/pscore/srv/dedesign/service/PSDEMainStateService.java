/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEMainStateService
extends PSDEMainStateServiceBase {
    private static final Log log = LogFactory.getLog(PSDEMainStateService.class);

    @Override
    protected void onBeforeCreate(PSDEMainState pSDEMainState) throws Exception {
        if (DataObject.getBoolValue((Integer)pSDEMainState.getDefaultMode(), (boolean)false)) {
            PSDEMainState pSDEMainState2 = new PSDEMainState();
            pSDEMainState2.setPSDEId(pSDEMainState.getPSDEId());
            pSDEMainState2.setDefaultMode(1);
            if (this.select(pSDEMainState2, true)) {
                pSDEMainState2.setDefaultMode(0);
                this.update(pSDEMainState2, false);
            }
        }
        pSDEMainState.setMSTag(this.calcMSTag(pSDEMainState));
        super.onBeforeCreate(pSDEMainState);
    }

    @Override
    protected void onBeforeUpdate(PSDEMainState pSDEMainState) throws Exception {
        if (DataObject.getBoolValue((Integer)pSDEMainState.getDefaultMode(), (boolean)false)) {
            PSDEMainState pSDEMainState2 = new PSDEMainState();
            pSDEMainState2.setPSDEId(pSDEMainState.getPSDEId());
            pSDEMainState2.setDefaultMode(1);
            if (this.select(pSDEMainState2, true)) {
                pSDEMainState2.setDefaultMode(0);
                this.update(pSDEMainState2, false);
            }
        }
        pSDEMainState.setMSTag(this.calcMSTag(pSDEMainState));
        super.onBeforeUpdate(pSDEMainState);
    }

    protected String calcMSTag(PSDEMainState pSDEMainState) {
        try {
            if (DataObject.getIntegerValue((Object)pSDEMainState.getDefaultMode(), (Integer)0) != 0) {
                return null;
            }
        }
        catch (Exception exception) {
            log.error((Object)exception);
            return null;
        }
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        stringBuilderEx.append(pSDEMainState.getMSValue());
        if (StringHelper.isNullOrEmpty((String)pSDEMainState.getMSValue2())) {
            return stringBuilderEx.toString();
        }
        stringBuilderEx.append("__");
        stringBuilderEx.append(pSDEMainState.getMSValue2());
        if (StringHelper.isNullOrEmpty((String)pSDEMainState.getMSValue3())) {
            return stringBuilderEx.toString();
        }
        stringBuilderEx.append("__");
        stringBuilderEx.append(pSDEMainState.getMSValue3());
        return stringBuilderEx.toString();
    }

    @Override
    protected void onInitDEMSViews(PSDEMainState pSDEMainState) throws Exception {
        this.get((IEntity)pSDEMainState);
        PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        pSDEViewBaseService.initDEMSViews(pSDEMainState, pSDEMainState.getPSDE());
    }
}

