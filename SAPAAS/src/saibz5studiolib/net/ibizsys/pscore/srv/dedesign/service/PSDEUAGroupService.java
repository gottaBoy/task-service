/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.util.PSModelFolderKeyHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEUAGroupService
extends PSDEUAGroupServiceBase {
    private static final Log log = LogFactory.getLog(PSDEUAGroupService.class);

    @Override
    protected void onBeforeCreate(PSDEUAGroup pSDEUAGroup) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSDEUAGroup.getPSDEId()) || !StringHelper.isNullOrEmpty((String)pSDEUAGroup.getPSWFId())) {
            pSDEUAGroup.setPSModuleId(null);
            pSDEUAGroup.setPSModuleName(null);
        }
        super.onBeforeCreate(pSDEUAGroup);
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    @Override
    protected void onBeforeUpdate(PSDEUAGroup pSDEUAGroup) throws Exception {
        PSDEUAGroup pSDEUAGroup2 = (PSDEUAGroup)this.getLast(pSDEUAGroup);
        String string = null;
        String string2 = null;
        string = pSDEUAGroup.isPSDEIdDirty() ? pSDEUAGroup.getPSDEId() : pSDEUAGroup2.getPSDEId();
        string2 = pSDEUAGroup.isPSWFIdDirty() ? pSDEUAGroup.getPSWFId() : pSDEUAGroup2.getPSWFId();
        if (!StringHelper.isNullOrEmpty((String)string) || !StringHelper.isNullOrEmpty((String)string2)) {
            pSDEUAGroup.setPSModuleId(null);
            pSDEUAGroup.setPSModuleName(null);
        }
        super.onBeforeUpdate(pSDEUAGroup);
    }

    @Override
    protected void onFillParentInfo_PSDE(PSDEUAGroup pSDEUAGroup, PSDataEntity pSDataEntity) throws Exception {
        super.onFillParentInfo_PSDE(pSDEUAGroup, pSDataEntity);
        pSDEUAGroup.setPSSystemId(pSDataEntity.getPSSystemId());
        pSDEUAGroup.setPSSystemName(pSDataEntity.getPSSystemName());
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEUAGroup pSDEUAGroup, PSSystem pSSystem) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDEUAGroup.getPSDEId())) {
            return PSModelFolderKeyHelper.getModelKey(pSDEUAGroup, pSSystem, "PSDEUAGROUP_SYS", "", this.getSessionFactory());
        }
        return super.getEntityFolderKeyValue(pSDEUAGroup, pSSystem);
    }

    @Override
    public String getModelV2Tag(PSDEUAGroup pSDEUAGroup) {
        if (!StringHelper.isNullOrEmpty((String)pSDEUAGroup.getCodeName())) {
            if (!StringHelper.isNullOrEmpty((String)pSDEUAGroup.getPSDEId())) {
                return pSDEUAGroup.getCodeName();
            }
            if (!StringHelper.isNullOrEmpty((String)pSDEUAGroup.getPSWFVersionId())) {
                return pSDEUAGroup.getCodeName();
            }
            return StringHelper.format((String)"%1$s(%2$s)", (Object)pSDEUAGroup.getPSDEUAGroupName(), (Object)pSDEUAGroup.getCodeName());
        }
        return StringHelper.format((String)"%1$s", (Object)pSDEUAGroup.getPSDEUAGroupName());
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEUAGroup pSDEUAGroup, String string) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSDEUAGroup.getPSWFId())) {
            // empty if block
        }
        return super.fillModelV2(objectNode, pSDEUAGroup, string);
    }
}

