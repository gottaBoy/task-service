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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFDTCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFDTColServiceBase;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDEInitCfg;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEFDTColService
extends PSDEFDTColServiceBase
implements IPSModelService<PSDEFDTCol> {
    private static final Log log = LogFactory.getLog(PSDEFDTColService.class);

    @Override
    public void initModel(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEFIELD", (boolean)true) == 0) {
            PSDEField pSDEField = new PSDEField();
            pSDEField.proxy((IDataObject)iEntity);
            int n = DataObject.getIntegerValue((Object)pSDEField.getDEFType(), (Integer)1);
            if (n == 4 || n == 5) {
                return;
            }
            PSDEInitCfg pSDEInitCfg = PSModelGlobal.getPSDEInitCfg(pSDEField.getPSDEId(), this.getSessionFactory());
            if (pSDEInitCfg != null && DataObject.getBoolValue((Integer)pSDEInitCfg.getIgnoreDBModel(), (boolean)false)) {
                return;
            }
            ArrayList<PSSystemDBCfg> arrayList = PSModelGlobal.getPSSystemDBCfgs(pSDEField.getPSSystemId(), this.getSessionFactory());
            for (PSSystemDBCfg pSSystemDBCfg : arrayList) {
                PSDEFDTCol pSDEFDTCol = new PSDEFDTCol();
                pSDEFDTCol.setPSDEFId(pSDEField.getPSDEFieldId());
                pSDEFDTCol.setPSDEFName(pSDEField.getPSDEFieldName());
                pSDEFDTCol.setPSDEFDTColName(pSDEField.getPSDEFieldName().toUpperCase());
                pSDEFDTCol.setDBType(pSSystemDBCfg.getPSSystemDBCfgName());
                this.fillEntityKeyValue(pSDEFDTCol);
                if (this.checkKey(pSDEFDTCol) != 0) continue;
                this.create(pSDEFDTCol, false);
            }
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEFDTCol pSDEFDTCol, PSSystem pSSystem) throws Exception {
        return StringHelper.format((String)"%1$s-%2$s", (Object)pSDEFDTCol.getPSDEFId(), (Object)pSDEFDTCol.getDBType());
    }

    @Override
    public String getFileName(IEntity iEntity) throws Exception {
        return ((PSDEFDTCol)iEntity).getDBType();
    }
}

