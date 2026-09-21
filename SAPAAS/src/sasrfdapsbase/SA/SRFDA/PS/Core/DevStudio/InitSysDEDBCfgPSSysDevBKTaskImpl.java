/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEField
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEDBCfgService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEFDTColService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService
 *  net.ibizsys.pscore.srv.service.IPSModelService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import java.util.ArrayList;
import java.util.Hashtable;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDBCfgService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFDTColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class InitSysDEDBCfgPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(InitSysDEDBCfgPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSystem psSystem2 = new PSSystem();
        psSystem2.setPSSystemId(this.psSysDevBKTask.getTASKPARAM());
        psSystemService.get((IEntity)psSystem2);
        try {
            PSCoreSysServiceBase.setCurrentPSSystemId((String)psSystem2.getPSSystemId());
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId((String)this.getPSDevSlnSysId());
            SessionFactoryManager.addRef();
            String strResult = this.initSyncModel(psSystem2);
            SessionFactoryManager.releaseRef((boolean)true);
            PSCoreSysServiceBase.setCurrentPSSystemId(null);
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
            return strResult;
        }
        catch (Exception ex) {
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
            PSCoreSysServiceBase.setCurrentPSSystemId(null);
            SessionFactoryManager.releaseRef((boolean)false);
            throw ex;
        }
    }

    protected String initSyncModel(PSSystem psSystem) throws Exception {
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
        PSDataEntityService psDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)sessionFactory);
        PSDEFieldService psDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)sessionFactory);
        IPSModelService psDEDBCfgService = (IPSModelService)ServiceGlobal.getService(PSDEDBCfgService.class, (SessionFactory)sessionFactory);
        IPSModelService psDEFDTColService = (IPSModelService)ServiceGlobal.getService(PSDEFDTColService.class, (SessionFactory)sessionFactory);
        Hashtable ignorePSDataEntityMap = new Hashtable();
        ArrayList psDataEntityList = psDataEntityService.selectByPSSystem((PSSystemBase)psSystem);
        for (PSDataEntity psDataEntity : psDataEntityList) {
            psDEDBCfgService.initModel("PSDATAENTITY", (IEntity)psDataEntity, "");
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSSYSTEMID", (Object)psSystem.getPSSystemId());
        ArrayList psDEFieldList = psDEFieldService.select((ISelectCond)selectCond);
        for (PSDEField psDEField : psDEFieldList) {
            psDEFDTColService.initModel("PSDEFIELD", (IEntity)psDEField, "");
        }
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        sBuilderEx.append("\u521d\u59cb\u5316\u7cfb\u7edf\u5b9e\u4f53\u6570\u636e\u5e93\u914d\u7f6e\u5b8c\u6210\u3002");
        return sBuilderEx.toString();
    }
}

