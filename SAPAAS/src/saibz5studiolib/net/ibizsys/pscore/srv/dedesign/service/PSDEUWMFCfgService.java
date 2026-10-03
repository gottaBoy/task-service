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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUWMFCfg;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUWMFCfgServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEUWMFCfgService
extends PSDEUWMFCfgServiceBase {
    private static final Log log = LogFactory.getLog(PSDEUWMFCfgService.class);

    @Override
    protected void onBeforeUpdate(PSDEUWMFCfg pSDEUWMFCfg) throws Exception {
        String string = DataObject.getStringValue((Object)pSDEUWMFCfg.get("psdefid"));
        PSDEField pSDEField = new PSDEField();
        pSDEField.setSessionFactory(this.getSessionFactory());
        pSDEField.setPSDEId(pSDEUWMFCfg.getPSDataEntityId());
        pSDEField.setMultiFormField(1);
        if (pSDEField.select(true)) {
            if (StringHelper.compare((String)pSDEField.getPSDEFieldId(), (String)string, (boolean)false) != 0) {
                PSDEField pSDEField2 = new PSDEField();
                pSDEField2.setSessionFactory(this.getSessionFactory());
                pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
                pSDEField2.setMultiFormField(0);
                pSDEField2.update();
                if (!StringHelper.isNullOrEmpty((String)string)) {
                    pSDEField.reset();
                    pSDEField.setSessionFactory(this.getSessionFactory());
                    pSDEField.setPSDEFieldId(string);
                    pSDEField.setMultiFormField(1);
                    pSDEField.update();
                }
            }
        } else if (!StringHelper.isNullOrEmpty((String)string)) {
            pSDEField.reset();
            pSDEField.setSessionFactory(this.getSessionFactory());
            pSDEField.setPSDEFieldId(string);
            pSDEField.setMultiFormField(1);
            pSDEField.update();
        }
        super.onBeforeUpdate(pSDEUWMFCfg);
    }

    @Override
    protected void onAfterUpdate(PSDEUWMFCfg pSDEUWMFCfg) throws Exception {
        this.onAfterGet(pSDEUWMFCfg);
        super.onAfterUpdate(pSDEUWMFCfg);
    }

    protected void onAfterGet(PSDEUWMFCfg pSDEUWMFCfg, int n) throws Exception {
        pSDEUWMFCfg.set("psdeid", pSDEUWMFCfg.getPSDataEntityId());
        pSDEUWMFCfg.set("psdename", pSDEUWMFCfg.getPSDataEntityName());
        PSDEField pSDEField = new PSDEField();
        pSDEField.setSessionFactory(this.getSessionFactory());
        pSDEField.setPSDEId(pSDEUWMFCfg.getPSDataEntityId());
        pSDEField.setMultiFormField(1);
        if (pSDEField.select(true)) {
            pSDEUWMFCfg.set("psdefid", pSDEField.getPSDEFieldId());
            pSDEUWMFCfg.set("psdefname", pSDEField.getPSDEFieldName());
            pSDEUWMFCfg.setUserTag(pSDEField.getPSDEFieldName());
        }
        super.onAfterGet(pSDEUWMFCfg, n);
    }
}

