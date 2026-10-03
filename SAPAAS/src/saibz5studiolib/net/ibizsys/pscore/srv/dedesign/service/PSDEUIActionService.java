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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.util.PSModelFolderKeyHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEUIActionService
extends PSDEUIActionServiceBase {
    private static final Log log = LogFactory.getLog(PSDEUIActionService.class);

    @Override
    protected void onBeforeCreate(PSDEUIAction pSDEUIAction) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSDEUIAction.getPSDEId()) || !StringHelper.isNullOrEmpty((String)pSDEUIAction.getPSWFId())) {
            pSDEUIAction.setPSModuleId(null);
            pSDEUIAction.setPSModuleName(null);
        }
        super.onBeforeCreate(pSDEUIAction);
        if (StringHelper.compare((String)pSDEUIAction.getUIActionType(), (String)"BACKEND", (boolean)true) == 0 && pSDEUIAction.contains("PICKUPPSDEVIEWBASEID")) {
            String string = DataObject.getStringValue((Object)pSDEUIAction.get("PICKUPPSDEVIEWBASEID"));
            String string2 = DataObject.getStringValue((Object)pSDEUIAction.get("PICKUPPSDEVIEWBASENAME"));
            pSDEUIAction.setPSDEViewBaseId(string);
            pSDEUIAction.setPSDEViewBaseName(string2);
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    @Override
    protected void onBeforeUpdate(PSDEUIAction pSDEUIAction) throws Exception {
        PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getLast(pSDEUIAction);
        String string = null;
        String string2 = null;
        string = pSDEUIAction.isPSDEIdDirty() ? pSDEUIAction.getPSDEId() : pSDEUIAction2.getPSDEId();
        string2 = pSDEUIAction.isPSWFIdDirty() ? pSDEUIAction.getPSWFId() : pSDEUIAction2.getPSWFId();
        if (!StringHelper.isNullOrEmpty((String)string) || !StringHelper.isNullOrEmpty((String)string2)) {
            pSDEUIAction.setPSModuleId(null);
            pSDEUIAction.setPSModuleName(null);
        }
        if (StringHelper.compare((String)pSDEUIAction.getUIActionType(), (String)"BACKEND", (boolean)true) == 0 && pSDEUIAction.contains("PICKUPPSDEVIEWBASEID")) {
            String string3 = DataObject.getStringValue((Object)pSDEUIAction.get("PICKUPPSDEVIEWBASEID"));
            String string4 = DataObject.getStringValue((Object)pSDEUIAction.get("PICKUPPSDEVIEWBASENAME"));
            pSDEUIAction.setPSDEViewBaseId(string3);
            pSDEUIAction.setPSDEViewBaseName(string4);
        }
        super.onBeforeUpdate(pSDEUIAction);
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEUIAction pSDEUIAction, PSSystem pSSystem) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDEUIAction.getPSDEId())) {
            return PSModelFolderKeyHelper.getModelKey(pSDEUIAction, pSSystem, "PSDEUIACTION_SYS", "", this.getSessionFactory());
        }
        return super.getEntityFolderKeyValue(pSDEUIAction, pSSystem);
    }

    @Override
    public String getModelV2Tag(PSDEUIAction pSDEUIAction) {
        if (!StringHelper.isNullOrEmpty((String)pSDEUIAction.getPSSysUIActionId()) && StringHelper.isNullOrEmpty((String)pSDEUIAction.getPSDEId()) && StringHelper.isNullOrEmpty((String)pSDEUIAction.getPSWFVersionId())) {
            if (StringHelper.isNullOrEmpty((String)pSDEUIAction.getCodeName())) {
                return pSDEUIAction.getPSSysUIActionId();
            }
            return StringHelper.format((String)"%1$s(%2$s)", (Object)pSDEUIAction.getPSSysUIActionId(), (Object)pSDEUIAction.getCodeName());
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEUIAction.getCodeName())) {
            if (!StringHelper.isNullOrEmpty((String)pSDEUIAction.getPSDEId())) {
                return StringHelper.format((String)"%1$s(%2$s)", (Object)pSDEUIAction.getPSDEUIActionName(), (Object)pSDEUIAction.getCodeName());
            }
            if (!StringHelper.isNullOrEmpty((String)pSDEUIAction.getPSWFVersionId())) {
                if (!StringHelper.isNullOrEmpty((String)pSDEUIAction.getPSWFProcessName())) {
                    return StringHelper.format((String)"%1$s(%2$s)@%3$s", (Object)pSDEUIAction.getPSDEUIActionName(), (Object)pSDEUIAction.getCodeName(), (Object)pSDEUIAction.getPSWFProcessName());
                }
                return StringHelper.format((String)"%1$s(%2$s)", (Object)pSDEUIAction.getPSDEUIActionName(), (Object)pSDEUIAction.getCodeName());
            }
            if (!StringHelper.isNullOrEmpty((String)pSDEUIAction.getUIActionType())) {
                return StringHelper.format((String)"%1$s(%2$s)[%3$s]", (Object)pSDEUIAction.getPSDEUIActionName(), (Object)pSDEUIAction.getCodeName(), (Object)pSDEUIAction.getUIActionType());
            }
            return StringHelper.format((String)"%1$s(%2$s)", (Object)pSDEUIAction.getPSDEUIActionName(), (Object)pSDEUIAction.getCodeName());
        }
        return StringHelper.format((String)"%1$s[%2$s]", (Object)pSDEUIAction.getPSDEUIActionName(), (Object)pSDEUIAction.getUIActionType());
    }
}

