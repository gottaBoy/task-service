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
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWDEUnionKey;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSUWDEUnionKeyServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSUWDEUnionKeyService
extends PSUWDEUnionKeyServiceBase {
    private static final Log log = LogFactory.getLog(PSUWDEUnionKeyService.class);

    @Override
    protected CallResult internalGet(PSUWDEUnionKey pSUWDEUnionKey, boolean bl, int n) throws Exception {
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        SelectContext selectContext = new SelectContext();
        selectContext.set("PSDEID", (Object)pSUWDEUnionKey.getPSUWDEUnionKeyId());
        selectContext.set("UNIONKEYVALUE", SelectContext.ISNOTNULL);
        ArrayList<PSDEField> arrayList = pSDEFieldService.select((ISelectCond)selectContext);
        for (PSDEField pSDEField : arrayList) {
            if (StringHelper.compare((String)pSDEField.getUnionKeyValue(), (String)"KEY1", (boolean)true) == 0) {
                pSUWDEUnionKey.setKeyPSDEFId(pSDEField.getPSDEFieldId());
                pSUWDEUnionKey.setKeyPSDEFName(pSDEField.getPSDEFieldName());
                continue;
            }
            if (StringHelper.compare((String)pSDEField.getUnionKeyValue(), (String)"KEY2", (boolean)true) == 0) {
                pSUWDEUnionKey.setKey2PSDEFId(pSDEField.getPSDEFieldId());
                pSUWDEUnionKey.setKey2PSDEFName(pSDEField.getPSDEFieldName());
                continue;
            }
            if (StringHelper.compare((String)pSDEField.getUnionKeyValue(), (String)"KEY3", (boolean)true) == 0) {
                pSUWDEUnionKey.setKey3PSDEFId(pSDEField.getPSDEFieldId());
                pSUWDEUnionKey.setKey3PSDEFName(pSDEField.getPSDEFieldName());
                continue;
            }
            if (StringHelper.compare((String)pSDEField.getUnionKeyValue(), (String)"KEY4", (boolean)true) != 0) continue;
            pSUWDEUnionKey.setKey4PSDEFId(pSDEField.getPSDEFieldId());
            pSUWDEUnionKey.setKey4PSDEFName(pSDEField.getPSDEFieldName());
        }
        pSUWDEUnionKey.setPSDEId(pSUWDEUnionKey.getPSUWDEUnionKeyId());
        return CallResult.create((int)0);
    }

    @Override
    protected void internalUpdate(PSUWDEUnionKey pSUWDEUnionKey) throws Exception {
        this.internalCreateOrUpdate(pSUWDEUnionKey);
    }

    @Override
    protected void internalCreate(PSUWDEUnionKey pSUWDEUnionKey) throws Exception {
        this.internalCreateOrUpdate(pSUWDEUnionKey);
    }

    protected void internalCreateOrUpdate(PSUWDEUnionKey pSUWDEUnionKey) throws Exception {
        PSDEField object;
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        SelectContext selectContext = new SelectContext();
        selectContext.set("PSDEID", (Object)pSUWDEUnionKey.getPSUWDEUnionKeyId());
        selectContext.set("UNIONKEYVALUE", SelectContext.ISNOTNULL);
        ArrayList<PSDEField> arrayList = pSDEFieldService.select((ISelectCond)selectContext);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = new PSDEField();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setUnionKeyValue(null);
            pSDEFieldService.update(pSDEField2, false);
        }
        if (!StringHelper.isNullOrEmpty((String)pSUWDEUnionKey.getKeyPSDEFId())) {
            object = new PSDEField();
            ((PSDEFieldBase)object).setPSDEFieldId(pSUWDEUnionKey.getKeyPSDEFId());
            ((PSDEFieldBase)object).setUnionKeyValue("KEY1");
            pSDEFieldService.update(object, false);
        }
        if (!StringHelper.isNullOrEmpty((String)pSUWDEUnionKey.getKey2PSDEFId())) {
            object = new PSDEField();
            ((PSDEFieldBase)object).setPSDEFieldId(pSUWDEUnionKey.getKey2PSDEFId());
            ((PSDEFieldBase)object).setUnionKeyValue("KEY2");
            pSDEFieldService.update(object, false);
        }
        if (!StringHelper.isNullOrEmpty((String)pSUWDEUnionKey.getKey3PSDEFId())) {
            object = new PSDEField();
            ((PSDEFieldBase)object).setPSDEFieldId(pSUWDEUnionKey.getKey3PSDEFId());
            ((PSDEFieldBase)object).setUnionKeyValue("KEY3");
            pSDEFieldService.update(object, false);
        }
        if (!StringHelper.isNullOrEmpty((String)pSUWDEUnionKey.getKey4PSDEFId())) {
            object = new PSDEField();
            ((PSDEFieldBase)object).setPSDEFieldId(pSUWDEUnionKey.getKey4PSDEFId());
            ((PSDEFieldBase)object).setUnionKeyValue("KEY4");
            pSDEFieldService.update(object, false);
        }
    }
}
