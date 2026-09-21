/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeServiceBase;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDEInitCfg;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEACModeService
extends PSDEACModeServiceBase
implements IPSModelService<PSDEACMode> {
    private static final Log log = LogFactory.getLog(PSDEACModeService.class);
    public static final String RESERVERTAG_DEFAULT = "R1";

    @Override
    public void initModel(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            PSDataEntity pSDataEntity = new PSDataEntity();
            pSDataEntity.proxy((IDataObject)iEntity);
            PSDEInitCfg pSDEInitCfg = PSModelGlobal.getPSDEInitCfg(pSDataEntity.getPSDataEntityId(), this.getSessionFactory());
            if (pSDEInitCfg != null && DataObject.getBoolValue((Integer)pSDEInitCfg.getIgnoreUIModel(), (boolean)false)) {
                return;
            }
            PSDEACMode pSDEACMode = new PSDEACMode();
            if (this.isEnableFolderKey((IEntity)pSDataEntity)) {
                pSDEACMode.setPSDEACModeId(StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_DEFAULT));
            } else {
                pSDEACMode.setPSDEACModeId(pSDataEntity.getPSDataEntityId());
            }
            if (this.checkKey(pSDEACMode) == 0) {
                String string3 = pSDEACMode.getPSDEACModeId();
                pSDEACMode.reset();
                pSDEACMode.setPSDEId(pSDataEntity.getPSDataEntityId());
                pSDEACMode.setDefaultMode(1);
                boolean bl = true;
                SelectCond selectCond = new SelectCond();
                selectCond.setFetchFirst(true);
                selectCond.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
                ArrayList arrayList = this.select((ISelectCond)selectCond);
                for (PSDEACMode pSDEACMode2 : arrayList) {
                    if (StringHelper.compare((String)pSDEACMode2.getCodeName(), (String)"Default", (boolean)true) == 0) {
                        return;
                    }
                    if (!DataObject.getBoolValue((Integer)pSDEACMode2.getDefaultMode(), (boolean)false)) continue;
                    bl = false;
                }
                pSDEACMode.reset();
                pSDEACMode.setPSDEACModeId(string3);
                pSDEACMode.setPSDEId(pSDataEntity.getPSDataEntityId());
                pSDEACMode.setDefaultMode(bl ? 1 : 0);
                pSDEACMode.setPSDEACModeName("DEFAULT");
                pSDEACMode.setCodeName("Default");
                this.create(pSDEACMode);
            }
        }
    }
}

