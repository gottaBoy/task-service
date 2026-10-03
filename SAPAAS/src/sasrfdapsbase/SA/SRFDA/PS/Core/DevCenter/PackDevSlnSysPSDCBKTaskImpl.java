/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysRunSessionService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.PSSysRunSessionDCBKTaskImplBase;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRunSessionService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.hibernate.SessionFactory;

public class PackDevSlnSysPSDCBKTaskImpl
extends PSSysRunSessionDCBKTaskImplBase {
    @Override
    protected String onRun() throws Exception {
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class);
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
        psDevSlnSysService.get(psDevSlnSys);
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)psDevSlnSys.getPSSysModelInstId());
        PSSystem psSystem = new PSSystem();
        psSystem.setPSSystemId(psDevSlnSys.getPSSystemId());
        PSSysAppService psSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)sessionFactory);
        ArrayList<PSSysApp> psSysAppList = psSysAppService.selectByPSSystem((PSSystemBase)psSystem);
        PSSysSFPubService psSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)sessionFactory);
        ArrayList<PSSysSFPub> psSysSFPubList = psSysSFPubService.selectByPSSystem((PSSystemBase)psSystem);
        PSSystemDBCfgService psSystemDBCfgService = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)sessionFactory);
        ArrayList<PSSystemDBCfg> psSystemDBCfgList = psSystemDBCfgService.selectByPSSystem((PSSystemBase)psSystem);
        PSSysRunSessionService psSysRunSessionService = (PSSysRunSessionService)ServiceGlobal.getService(PSSysRunSessionService.class, (SessionFactory)sessionFactory);
        PSSysRunSession psSysRunSession = new PSSysRunSession();
        psSysRunSession.setPSSystemId(psDevSlnSys.getPSSystemId());
        psSysRunSession.setPSSystemName(psDevSlnSys.getPSDevSlnSysName());
        if (psSysAppList.size() > 0) {
            PSSysApp psSysApp2 = null;
            for (PSSysApp psSysApp : psSysAppList) {
                if (psSysApp2 == null) {
                    psSysApp2 = psSysApp;
                } else if (DataObject.getBoolValue((Integer)psSysApp.getDefaultPub(), (boolean)false)) {
                    psSysApp2 = psSysApp;
                } else if (psSysApp.getUpdateDate().getTime() > psSysApp2.getUpdateDate().getTime()) {
                    psSysApp2 = psSysApp;
                }
                if (DataObject.getBoolValue((Integer)psSysApp2.getDefaultPub(), (boolean)false)) break;
            }
            psSysRunSession.setPSSysAppId(psSysApp2.getPSSysAppId());
            psSysRunSession.setPSSysAppName(psSysApp2.getPSSysAppName());
        }
        if (psSysSFPubList.size() > 0) {
            PSSysSFPub psSysSFPub2 = null;
            for (PSSysSFPub psSysSFPub : psSysSFPubList) {
                if (psSysSFPub2 == null) {
                    psSysSFPub2 = psSysSFPub;
                } else if (DataObject.getBoolValue((Integer)psSysSFPub.getDefaultPub(), (boolean)false)) {
                    psSysSFPub2 = psSysSFPub;
                } else if (psSysSFPub.getUpdateDate().getTime() > psSysSFPub2.getUpdateDate().getTime()) {
                    psSysSFPub2 = psSysSFPub;
                }
                if (DataObject.getBoolValue((Integer)psSysSFPub2.getDefaultPub(), (boolean)false)) break;
            }
            psSysRunSession.setPSSysSFPubId(psSysSFPub2.getPSSysSFPubId());
            psSysRunSession.setPSSysSFPubName(psSysSFPub2.getPSSysSFPubName());
        }
        if (psSystemDBCfgList.size() > 0) {
            PSSystemDBCfg psSystemDBCfg2 = null;
            for (PSSystemDBCfg psSystemDBCfg : psSystemDBCfgList) {
                if (psSystemDBCfg2 == null) {
                    psSystemDBCfg2 = psSystemDBCfg;
                } else if (DataObject.getBoolValue((Integer)psSystemDBCfg.getDefaultFlag(), (boolean)false)) {
                    psSystemDBCfg2 = psSystemDBCfg;
                } else if (psSystemDBCfg.getUpdateDate().getTime() > psSystemDBCfg2.getUpdateDate().getTime()) {
                    psSystemDBCfg2 = psSystemDBCfg;
                }
                if (DataObject.getBoolValue((Integer)psSystemDBCfg2.getDefaultFlag(), (boolean)false)) break;
            }
            psSysRunSession.setPSSystemDBCfgId(psSystemDBCfg2.getPSSystemDBCfgId());
            psSysRunSession.setPSSystemDBCfgName(psSystemDBCfg2.getPSSystemDBCfgName());
        }
        psSysRunSession.setRunMode("PACKVER2");
        psSysRunSession.setEnableVC(Integer.valueOf(0));
        psSysRunSession.setRunParam(this.getTaskParam2());
        String strDownloadFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "DOWNLOADFOLDER", null);
        String strDate = DateHelper.toDateString((Date)new Date());
        String strFileName = StringHelper.Format((String)"%1$s.zip", (Object)KeyValueHelper.genGuidEx());
        String strDownloadFile = StringHelper.Format((String)"%1$s%2$s%3$s%2$s%4$s%2$s", (Object)strDownloadFolder, (Object)File.separator, (Object)this.getPSDevCenterId(), (Object)strDate);
        String strRemoteFolder = StringHelper.Format((String)"%1$s%2$s%3$s%2$s", (Object)this.getPSDevCenterId(), (Object)"/", (Object)strDate);
        File dir = new File(strDownloadFile);
        dir.mkdirs();
        strDownloadFile = String.valueOf(strDownloadFile) + strFileName;
        psSysRunSession.setRunParam3(strDownloadFile);
        psSysRunSession.setRunParam4(strRemoteFolder);
        psSysRunSessionService.create(psSysRunSession);
        this.executePackSysTask(psDevSlnSys, psSysRunSession);
        return StringHelper.Format((String)"http://download.ibiz5.com/sys/%1$s/%2$s/%3$s", (Object)this.getPSDevCenterId(), (Object)strDate, (Object)strFileName);
    }
}
