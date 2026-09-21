/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivServiceBase;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDEInitCfg;
import net.ibizsys.pscore.srv.util.PSModelFolderKeyHelper;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEOPPrivService
extends PSDEOPPrivServiceBase
implements IPSModelService<PSDEOPPriv> {
    private static final Log log = LogFactory.getLog(PSDEOPPrivService.class);
    public static final String SYSUNIRES_PREFIX = "SRFUR__";
    public static final String RESERVERTAG_CREATE = "R1";
    public static final String RESERVERTAG_UPDATE = "R2";
    public static final String RESERVERTAG_DELETE = "R3";
    public static final String RESERVERTAG_READ = "R4";
    private static HashMap<String, String> defaultPSDEOPPrivMap = new HashMap();
    private static HashMap<String, String> actionReserverMap = new HashMap();

    @Override
    protected boolean onFillEntityKeyValue(PSDEOPPriv pSDEOPPriv, boolean bl) throws Exception {
        if (pSDEOPPriv.isMapSysUniResModeDirty() && DataObject.getBoolValue((Integer)pSDEOPPriv.getMapSysUniResMode(), (boolean)false) && (!PSCoreSysServiceBase.isImpSysModelNow() || StringHelper.isNullOrEmpty((String)pSDEOPPriv.getPSDEOPPrivName())) && pSDEOPPriv.getPSSysUniRes() != null) {
            pSDEOPPriv.setPSDEOPPrivName(StringHelper.format((String)"%1$s%2$s", (Object)SYSUNIRES_PREFIX, (Object)pSDEOPPriv.getPSSysUniRes().getResCode()));
        }
        return super.onFillEntityKeyValue(pSDEOPPriv, bl);
    }

    @Override
    protected void onBeforeCreate(PSDEOPPriv pSDEOPPriv) throws Exception {
        String string;
        if (StringHelper.isNullOrEmpty((String)pSDEOPPriv.getLogicName()) && !StringHelper.isNullOrEmpty((String)(string = defaultPSDEOPPrivMap.get(pSDEOPPriv.getPSDEOPPrivName())))) {
            pSDEOPPriv.setLogicName(string);
        }
        if (pSDEOPPriv.isMapSysUniResModeDirty() && DataObject.getBoolValue((Integer)pSDEOPPriv.getMapSysUniResMode(), (boolean)false) && (!PSCoreSysServiceBase.isImpSysModelNow() || StringHelper.isNullOrEmpty((String)pSDEOPPriv.getPSDEOPPrivName())) && pSDEOPPriv.getPSSysUniRes() != null) {
            pSDEOPPriv.setPSDEOPPrivName(StringHelper.format((String)"%1$s%2$s", (Object)SYSUNIRES_PREFIX, (Object)pSDEOPPriv.getPSSysUniRes().getResCode()));
        }
        super.onBeforeCreate(pSDEOPPriv);
    }

    @Override
    protected void onBeforeUpdate(PSDEOPPriv pSDEOPPriv) throws Exception {
        if (pSDEOPPriv.isMapSysUniResModeDirty() && DataObject.getBoolValue((Integer)pSDEOPPriv.getMapSysUniResMode(), (boolean)false) && (!PSCoreSysServiceBase.isImpSysModelNow() || StringHelper.isNullOrEmpty((String)pSDEOPPriv.getPSDEOPPrivName())) && pSDEOPPriv.getPSSysUniRes() != null) {
            pSDEOPPriv.setPSDEOPPrivName(StringHelper.format((String)"%1$s%2$s", (Object)SYSUNIRES_PREFIX, (Object)pSDEOPPriv.getPSSysUniRes().getResCode()));
        }
        super.onBeforeUpdate(pSDEOPPriv);
    }

    @Override
    public void initModel(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            PSDataEntity pSDataEntity = new PSDataEntity();
            pSDataEntity.proxy((IDataObject)iEntity);
            PSDEInitCfg pSDEInitCfg = PSModelGlobal.getPSDEInitCfg(pSDataEntity.getPSDataEntityId(), this.getSessionFactory());
            if (pSDEInitCfg != null && DataObject.getBoolValue((Integer)pSDEInitCfg.getIgnoreMgrModel(), (boolean)false)) {
                return;
            }
            boolean bl = this.isEnableFolderKey((IEntity)pSDataEntity);
            for (String string3 : defaultPSDEOPPrivMap.keySet()) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                if (bl) {
                    pSDEOPPriv.setPSDEOPPrivId(StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)actionReserverMap.get(string3)));
                } else {
                    pSDEOPPriv.setPSDEOPPrivId(KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)string3));
                }
                if (this.checkKey(pSDEOPPriv) != 0) continue;
                Object object = new SelectCond();
                object.set("PSDERID", SelectCond.ISNULL);
                object.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
                object.set("PSDEOPPRIVNAME", (Object)string3);
                object.setFetchFirst(true);
                if (this.select((ISelectCond)object).size() > 0) continue;
                object = defaultPSDEOPPrivMap.get(string3);
                pSDEOPPriv.setPSDEId(pSDataEntity.getPSDataEntityId());
                pSDEOPPriv.setPSDEName(pSDataEntity.getPSDataEntityName());
                pSDEOPPriv.setPSDEOPPrivName(string3);
                pSDEOPPriv.setLogicName((String)object);
                this.create(pSDEOPPriv);
            }
            return;
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEOPPriv pSDEOPPriv, PSSystem pSSystem) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDEOPPriv.getPSDEId())) {
            return PSModelFolderKeyHelper.getModelKey((IEntity)pSDEOPPriv, pSSystem, "PSDEOPPRIV_SYS", "", this.getSessionFactory());
        }
        return super.getEntityFolderKeyValue(pSDEOPPriv, pSSystem);
    }

    static {
        defaultPSDEOPPrivMap.put("CREATE", "\u5efa\u7acb");
        defaultPSDEOPPrivMap.put("UPDATE", "\u66f4\u65b0");
        defaultPSDEOPPrivMap.put("DELETE", "\u5220\u9664");
        defaultPSDEOPPrivMap.put("READ", "\u8bfb\u53d6");
        actionReserverMap.put("CREATE", RESERVERTAG_CREATE);
        actionReserverMap.put("UPDATE", RESERVERTAG_UPDATE);
        actionReserverMap.put("DELETE", RESERVERTAG_DELETE);
        actionReserverMap.put("READ", RESERVERTAG_READ);
    }
}

