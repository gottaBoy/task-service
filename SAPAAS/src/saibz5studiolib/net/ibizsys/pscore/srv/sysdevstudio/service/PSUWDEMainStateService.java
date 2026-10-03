/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdevstudio.service;

import java.util.ArrayList;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWDEMainState;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSUWDEMainStateServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSUWDEMainStateService
extends PSUWDEMainStateServiceBase {
    private static final Log log = LogFactory.getLog(PSUWDEMainStateService.class);

    @Override
    protected CallResult internalGet(PSUWDEMainState pSUWDEMainState, boolean bl, int n) throws Exception {
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        SelectContext selectContext = new SelectContext();
        selectContext.set("PSDEID", (Object)pSUWDEMainState.getPSUWDEMainStateId());
        selectContext.set("STATEFIELD", SelectContext.ISNOTNULL);
        ArrayList<PSDEField> arrayList = pSDEFieldService.select((ISelectCond)selectContext);
        for (PSDEField pSDEField : arrayList) {
            if (StringHelper.compare((String)pSDEField.getStateField(), (String)"STATE1", (boolean)true) == 0) {
                pSUWDEMainState.setStatePSDEFId(pSDEField.getPSDEFieldId());
                pSUWDEMainState.setStatePSDEFName(pSDEField.getPSDEFieldName());
                continue;
            }
            if (StringHelper.compare((String)pSDEField.getStateField(), (String)"STATE2", (boolean)true) == 0) {
                pSUWDEMainState.setState2PSDEFId(pSDEField.getPSDEFieldId());
                pSUWDEMainState.setState2PSDEFName(pSDEField.getPSDEFieldName());
                continue;
            }
            if (StringHelper.compare((String)pSDEField.getStateField(), (String)"STATE3", (boolean)true) != 0) continue;
            pSUWDEMainState.setState3PSDEFId(pSDEField.getPSDEFieldId());
            pSUWDEMainState.setState3PSDEFName(pSDEField.getPSDEFieldName());
        }
        pSUWDEMainState.setPSDEId(pSUWDEMainState.getPSUWDEMainStateId());
        return CallResult.create((int)0);
    }

    @Override
    protected void internalUpdate(PSUWDEMainState pSUWDEMainState) throws Exception {
        this.internalCreateOrUpdate(pSUWDEMainState);
    }

    @Override
    protected void internalCreate(PSUWDEMainState pSUWDEMainState) throws Exception {
        this.internalCreateOrUpdate(pSUWDEMainState);
    }

    protected void internalCreateOrUpdate(PSUWDEMainState pSUWDEMainState) throws Exception {
        PSDEField object;
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        SelectContext selectContext = new SelectContext();
        selectContext.set("PSDEID", (Object)pSUWDEMainState.getPSUWDEMainStateId());
        selectContext.set("STATEFIELD", SelectContext.ISNOTNULL);
        ArrayList<PSDEField> arrayList = pSDEFieldService.select((ISelectCond)selectContext);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = new PSDEField();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setStateField(null);
            pSDEFieldService.update(pSDEField2, false);
        }
        if (!StringHelper.isNullOrEmpty((String)pSUWDEMainState.getStatePSDEFId())) {
            object = new PSDEField();
            ((PSDEFieldBase)object).setPSDEFieldId(pSUWDEMainState.getStatePSDEFId());
            ((PSDEFieldBase)object).setStateField("STATE1");
            pSDEFieldService.update(object, false);
        }
        if (!StringHelper.isNullOrEmpty((String)pSUWDEMainState.getState2PSDEFId())) {
            object = new PSDEField();
            ((PSDEFieldBase)object).setPSDEFieldId(pSUWDEMainState.getState2PSDEFId());
            ((PSDEFieldBase)object).setStateField("STATE2");
            pSDEFieldService.update(object, false);
        }
        if (!StringHelper.isNullOrEmpty((String)pSUWDEMainState.getState3PSDEFId())) {
            object = new PSDEField();
            ((PSDEFieldBase)object).setPSDEFieldId(pSUWDEMainState.getState3PSDEFId());
            ((PSDEFieldBase)object).setStateField("STATE3");
            pSDEFieldService.update(object, false);
        }
    }
}
