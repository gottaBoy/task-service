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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRGroupServiceBase;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDEInitCfg;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEDRGroupService
extends PSDEDRGroupServiceBase
implements IPSModelService<PSDEDRGroup> {
    private static final Log log = LogFactory.getLog(PSDEDRGroupService.class);
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
            PSDEDRGroup pSDEDRGroup = new PSDEDRGroup();
            if (this.isEnableFolderKey((IEntity)pSDataEntity)) {
                pSDEDRGroup.setPSDEDRGroupId(StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_DEFAULT));
            } else {
                pSDEDRGroup.setPSDEDRGroupId(pSDataEntity.getPSDataEntityId());
            }
            if (this.checkKey(pSDEDRGroup) == 0) {
                PSDEDRGroup pSDEDRGroup2 = new PSDEDRGroup();
                pSDEDRGroup2.setPSDEId(pSDataEntity.getPSDataEntityId());
                if (this.selectOne((IEntity)pSDEDRGroup2, true)) {
                    return;
                }
                pSDEDRGroup.setOrderValue(10000);
                pSDEDRGroup.setPSDEId(pSDataEntity.getPSDataEntityId());
                pSDEDRGroup.setPSDEDRGroupName(StringHelper.format((String)"\u8be6\u7ec6\u4fe1\u606f", (Object)pSDataEntity.getLogicName()));
                this.create(pSDEDRGroup);
            }
        }
    }
}

