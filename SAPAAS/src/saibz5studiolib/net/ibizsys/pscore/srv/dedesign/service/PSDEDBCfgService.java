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

import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDBCfg;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDBCfgServiceBase;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDEInitCfg;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEDBCfgService
extends PSDEDBCfgServiceBase
implements IPSModelService<PSDEDBCfg> {
    private static final Log log = LogFactory.getLog(PSDEDBCfgService.class);

    @Override
    public void initModel(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            PSDataEntity pSDataEntity = new PSDataEntity();
            pSDataEntity.proxy((IDataObject)iEntity);
            PSDEInitCfg pSDEInitCfg = PSModelGlobal.getPSDEInitCfg(pSDataEntity.getPSDataEntityId(), this.getSessionFactory());
            if (pSDEInitCfg != null && DataObject.getBoolValue((Integer)pSDEInitCfg.getIgnoreDBModel(), (boolean)false)) {
                return;
            }
            ArrayList<PSSystemDBCfg> arrayList = PSModelGlobal.getPSSystemDBCfgs(pSDataEntity.getPSSystemId(), this.getSessionFactory());
            for (PSSystemDBCfg pSSystemDBCfg : arrayList) {
                String string3 = pSSystemDBCfg.getPSSystemDBCfgName();
                PSDEDBCfg pSDEDBCfg = new PSDEDBCfg();
                pSDEDBCfg.setPSDEDBCfgName(string3);
                pSDEDBCfg.setPSDEId(pSDataEntity.getPSDataEntityId());
                this.fillEntityKeyValue(pSDEDBCfg);
                if (this.checkKey(pSDEDBCfg) != 0) continue;
                this.create(pSDEDBCfg);
            }
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEDBCfg pSDEDBCfg, PSSystem pSSystem) throws Exception {
        return StringHelper.format((String)"%1$s-%2$s", (Object)pSDEDBCfg.getPSDEId(), (Object)pSDEDBCfg.getPSDEDBCfgName());
    }
}

