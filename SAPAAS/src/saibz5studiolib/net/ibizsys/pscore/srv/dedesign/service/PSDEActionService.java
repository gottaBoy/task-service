/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionServiceBase;
import net.ibizsys.pscore.srv.service.IPSModelService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEActionService
extends PSDEActionServiceBase
implements IPSModelService<PSDEAction> {
    private static final Log log = LogFactory.getLog(PSDEActionService.class);
    public static final String[] DEACTIONS = new String[]{"CheckKey", "Create", "Get", "Remove", "Save", "Update", "GetDraft"};
    public static final String[] DEACTIONS2 = new String[]{"CreateTemp", "CreateTempMajor", "GetDraftTemp", "GetDraftTempMajor", "GetTemp", "GetTempMajor", "RemoveTemp", "RemoveTempMajor", "UpdateTemp", "UpdateTempMajor"};

    @Override
    public void initModel(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            PSDEAction pSDEAction;
            PSDataEntity pSDataEntity = new PSDataEntity();
            pSDataEntity.proxy((IDataObject)iEntity);
            for (String string3 : DEACTIONS) {
                pSDEAction = new PSDEAction();
                pSDEAction.setPSDEId(pSDataEntity.getPSDataEntityId());
                pSDEAction.setPSDEActionName(string3);
                if (this.select(pSDEAction, true)) continue;
                pSDEAction.setPSDEName(pSDataEntity.getPSDataEntityName());
                pSDEAction.setActionType("BUILTIN");
                pSDEAction.setCodeName(string3);
                pSDEAction.setLogicName(string3);
                this.create(pSDEAction);
            }
            if (DataObject.getIntegerValue((Object)pSDataEntity.getEnaTempData(), (Integer)0) > 0) {
                for (String string3 : DEACTIONS2) {
                    pSDEAction = new PSDEAction();
                    pSDEAction.setPSDEId(pSDataEntity.getPSDataEntityId());
                    pSDEAction.setPSDEActionName(string3);
                    if (this.select(pSDEAction, true)) continue;
                    pSDEAction.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDEAction.setActionType("BUILTIN");
                    pSDEAction.setCodeName(string3);
                    pSDEAction.setLogicName(string3);
                    this.create(pSDEAction);
                }
            }
        }
    }
}

