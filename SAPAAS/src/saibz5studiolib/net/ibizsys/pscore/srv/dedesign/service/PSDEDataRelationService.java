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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataRelation;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationServiceBase;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDEInitCfg;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEDataRelationService
extends PSDEDataRelationServiceBase
implements IPSModelService<PSDEDataRelation> {
    private static final Log log = LogFactory.getLog(PSDEDataRelationService.class);
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
            PSDEDataRelation pSDEDataRelation = new PSDEDataRelation();
            if (this.isEnableFolderKey(pSDataEntity)) {
                pSDEDataRelation.setPSDEDataRelationId(StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_DEFAULT));
            } else {
                pSDEDataRelation.setPSDEDataRelationId(pSDataEntity.getPSDataEntityId());
            }
            if (this.checkKey(pSDEDataRelation) == 0) {
                PSDEDataRelation pSDEDataRelation2 = new PSDEDataRelation();
                pSDEDataRelation2.setPSDEId(pSDataEntity.getPSDataEntityId());
                pSDEDataRelation2.setCodeName("Default");
                if (this.selectOne(pSDEDataRelation2, true)) {
                    return;
                }
                pSDEDataRelation.setPSDEId(pSDataEntity.getPSDataEntityId());
                pSDEDataRelation.setPSDEDataRelationName(StringHelper.format((String)"%1$s\u9ed8\u8ba4\u5173\u7cfb\u754c\u9762\u7ec4", (Object)pSDataEntity.getLogicName()));
                pSDEDataRelation.setCodeName("Default");
                this.create(pSDEDataRelation);
            }
        }
    }
}

