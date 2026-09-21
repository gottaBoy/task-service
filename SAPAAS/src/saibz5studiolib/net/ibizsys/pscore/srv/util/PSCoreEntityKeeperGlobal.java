/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psop.zookeeper.PSEntityKeeperGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.util;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobot;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSSVNServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.psop.zookeeper.PSEntityKeeperGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSCoreEntityKeeperGlobal {
    private static final Log log = LogFactory.getLog(PSCoreEntityKeeperGlobal.class);
    private static boolean bInitPSDevUser = false;
    private static boolean bInitPSDevCenter = false;
    private static boolean bInitPSDevSlnSys = false;
    private static boolean bInitPSDCRobot = false;
    private static boolean bInitPSPFStyle = false;
    private static boolean bInitPSSFStyle = false;
    private static boolean bInitPSSVNServer = false;
    private static boolean bInitPSDCWorkspace = false;
    private static boolean bInitPSSvrDomain = false;
    private static boolean bInitPSDevSlnSysDynaInst = false;
    private static HashMap<SessionFactory, PSCoreEntityKeeperGlobal> psCoreEntityKeeperGlobalMap = new HashMap();
    private SessionFactory sessionFactory = null;
    private HashMap<String, PSDevCenter> psDevCenterMap = new HashMap();
    private HashMap<String, PSDevSlnSys> psDevSlnSysMap = new HashMap();
    private HashMap<String, PSDCRobot> psDCRobotMap = new HashMap();
    private HashMap<String, PSPFStyle> psPFStyleMap = new HashMap();
    private HashMap<String, PSSFStyle> psSFStyleMap = new HashMap();
    private HashMap<String, PSSVNServer> psSVNServerMap = new HashMap();
    private HashMap<String, PSDCWorkspace> psDCWorkspaceMap = new HashMap();
    private HashMap<String, PSSvrDomain> psSvrDomainMap = new HashMap();
    private HashMap<String, PSDevSlnSysDynaInst> psDevSlnSysDynaInstMap = new HashMap();

    public PSCoreEntityKeeperGlobal(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static void initPSDevCenter() throws Exception {
        if (!bInitPSDevCenter) {
            if (!PSEntityKeeperGlobal.getCurrent().isRegisterPSEntity("PSDEVCENTER")) {
                PSEntityKeeperGlobal.getCurrent().registerPSEntity("PSDEVCENTER", "PSDEVCENTERID", new String[]{"PSSVRDOMAINID"}, new String[]{"VALIDFLAG", "DCLEVEL", "DCTYPE", "ROBOTCHGTIME", "MOBCERTCHGTIME", "MOBTDCHGTIME"}, null);
            }
            bInitPSDevCenter = true;
        }
    }

    public static void initPSDevUser() throws Exception {
        if (!bInitPSDevUser) {
            if (!PSEntityKeeperGlobal.getCurrent().isRegisterPSEntity("PSDEVUSER")) {
                PSEntityKeeperGlobal.getCurrent().registerPSEntity("PSDEVUSER", "PSDEVUSERID", new String[]{"PSDEVCENTERID", "PSDEVUSERID", "VALIDFLAG", "sessionid", "remoteaddr"});
            }
            bInitPSDevUser = true;
        }
    }

    public static void initPSDevSlnSys() throws Exception {
        if (!bInitPSDevSlnSys) {
            if (!PSEntityKeeperGlobal.getCurrent().isRegisterPSEntity("PSDEVSLNSYS")) {
                PSEntityKeeperGlobal.getCurrent().registerPSEntity("PSDEVSLNSYS", "PSDEVSLNSYSID", new String[]{"PSSVRDOMAINID", "PSDEVCENTERID"}, new String[]{"EXPRIEDTIME", "DEVSYSSTATE", "VALIDFLAG", "PSSYSMODELINSTID", "SYSROWKEY", "SHAREFLAG", "PSDCWORKSPACEID", "OFFLINETIME"}, null);
            }
            bInitPSDevSlnSys = true;
        }
    }

    public static void initPSDCRobot() throws Exception {
        if (!bInitPSDCRobot) {
            if (!PSEntityKeeperGlobal.getCurrent().isRegisterPSEntity("PSDCROBOT")) {
                PSEntityKeeperGlobal.getCurrent().registerPSEntity("PSDCROBOT", "PSDCROBOTID", new String[]{"PSSVRDOMAINID", "PSDEVCENTERID"}, new String[]{"PSDCROBOTNAME", "CURENERGY", "ENERGYRATE", "EXTENERGY", "LASTCALCTIME", "LASTENERGY", "MAXENERGY", "MAXEXTENERGY", "ORDERVALUE", "ROBOTLEVEL", "ROBOTTYPE"}, null);
            }
            bInitPSDCRobot = true;
        }
    }

    public static void initPSPFStyle() throws Exception {
        if (!bInitPSPFStyle) {
            if (!PSEntityKeeperGlobal.getCurrent().isRegisterPSEntity("PSPFSTYLE")) {
                PSEntityKeeperGlobal.getCurrent().registerPSEntity("PSPFSTYLE", "PSPFSTYLEID", new String[]{"PSSVRDOMAINID", "PSDEVCENTERID"}, new String[]{"PSPFSTYLENAME", "UPDATEDATE", "LASTIMPTIME", "VERSTR", "VERSION"}, null);
            }
            bInitPSPFStyle = true;
        }
    }

    public static void initPSSFStyle() throws Exception {
        if (!bInitPSSFStyle) {
            if (!PSEntityKeeperGlobal.getCurrent().isRegisterPSEntity("PSSFSTYLE")) {
                PSEntityKeeperGlobal.getCurrent().registerPSEntity("PSSFSTYLE", "PSSFSTYLEID", new String[]{"PSSVRDOMAINID", "PSDEVCENTERID"}, new String[]{"PSSFSTYLENAME", "UPDATEDATE", "VERSTR", "VERSION"}, null);
            }
            bInitPSSFStyle = true;
        }
    }

    public static void initPSSVNServer() throws Exception {
        if (!bInitPSSVNServer) {
            if (!PSEntityKeeperGlobal.getCurrent().isRegisterPSEntity("PSSVNSERVER")) {
                PSEntityKeeperGlobal.getCurrent().registerPSEntity("PSSVNSERVER", "PSSVNSERVERID", new String[]{"PSSVRDOMAINID"}, new String[]{"PSSVNSERVERNAME", "UPDATEDATE", "GITTOKEN", "GITPATH", "GITPRJ", "IPADDR", "GITUSERNAME", "GITPASSWORD", "USERTAG", "USERTAG2", "USERTAG3", "USERTAG4"}, null);
            }
            bInitPSSVNServer = true;
        }
    }

    public static void initPSDCWorkspace() throws Exception {
        if (!bInitPSDCWorkspace) {
            if (!PSEntityKeeperGlobal.getCurrent().isRegisterPSEntity("PSDCWORKSPACE")) {
                PSEntityKeeperGlobal.getCurrent().registerPSEntity("PSDCWORKSPACE", "PSDCWORKSPACEID", new String[]{"PSSVRDOMAINID", "PSDEVCENTERID"}, new String[]{"PSDCWORKSPACENAME", "RESSTATE", "IPADDRS", "WORKSPACELEVEL", "WORKSPACESTATE", "WORKSPACETYPE", "EXPIREDTIME", "PSDEVSLNSYSID"}, null);
            }
            bInitPSDCWorkspace = true;
        }
    }

    public static void initPSSvrDomain() throws Exception {
        if (!bInitPSSvrDomain) {
            if (!PSEntityKeeperGlobal.getCurrent().isRegisterPSEntity("PSSVRDOMAIN")) {
                PSEntityKeeperGlobal.getCurrent().registerPSEntity("PSSVRDOMAIN", "PSSVRDOMAINID", new String[]{"PSSVRDOMAINID"}, new String[]{"PSSVRDOMAINNAME", "UPDATEDATE", "SYNCDATA", "SYNCDATA2", "SYNCDATA3", "SYNCDATA4", "SYNCDATA5", "SYNCDATA6", "SYNCDATA7", "SYNCDATA8", "SYNCDATA9", "SYNCDATA10"}, null);
            }
            bInitPSSvrDomain = true;
        }
    }

    public static void initPSDevSlnSysDynaInst() throws Exception {
        if (!bInitPSDevSlnSysDynaInst) {
            if (!PSEntityKeeperGlobal.getCurrent().isRegisterPSEntity("PSDEVSLNSYSDYNAINST")) {
                PSEntityKeeperGlobal.getCurrent().registerPSEntity("PSDEVSLNSYSDYNAINST", "PSDEVSLNSYSDYNAINSTID", new String[]{"PSSVRDOMAINID", "PSDEVCENTERID"}, new String[]{"PSDEVSLNSYSDYNAINSTNAME", "PPSDEVSLNSYSDYNAINSTID", "INSTSTATE", "INSTVER", "EXPRIEDTIME", "INSTTYPE", "UPDATEDATE", "LASTCHECKINTIME", "REFUPDATEDATE"}, null);
            }
            bInitPSDevSlnSysDynaInst = true;
        }
    }

    public static PSEntityKeeperGlobal getPSEntityKeeperGlobal() throws Exception {
        return PSEntityKeeperGlobal.getCurrent();
    }

    public static PSCoreEntityKeeperGlobal getCurrent(SessionFactory sessionFactory) throws Exception {
        PSCoreEntityKeeperGlobal pSCoreEntityKeeperGlobal = psCoreEntityKeeperGlobalMap.get(sessionFactory);
        if (pSCoreEntityKeeperGlobal == null) {
            pSCoreEntityKeeperGlobal = new PSCoreEntityKeeperGlobal(sessionFactory);
            psCoreEntityKeeperGlobalMap.put(sessionFactory, pSCoreEntityKeeperGlobal);
        }
        return pSCoreEntityKeeperGlobal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter(String string) throws Exception {
        Object object;
        PSDevCenter pSDevCenter = this.psDevCenterMap.get(string);
        if (pSDevCenter != null) {
            if (PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().getPSEntity("PSDEVCENTER", (IEntity)pSDevCenter, false)) {
                return pSDevCenter;
            }
            object = this.psDevCenterMap;
            synchronized (object) {
                this.psDevCenterMap.remove(string);
            }
        }
        pSDevCenter = new PSDevCenter();
        pSDevCenter.setPSDevCenterId(string);
        object = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.sessionFactory);
        object.get((IEntity)pSDevCenter);
        if (pSDevCenter.getValidFlag() == null) {
            pSDevCenter.setValidFlag(1);
        }
        if (StringHelper.isNullOrEmpty((String)pSDevCenter.getPSSvrDomainId())) {
            pSDevCenter.setPSSvrDomainId("DEFAULT");
        }
        this.updatePSDevCenter(pSDevCenter);
        return pSDevCenter;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updatePSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().updatePSEntity("PSDEVCENTER", (IEntity)pSDevCenter, true);
        PSDevCenter pSDevCenter2 = this.psDevCenterMap.get(pSDevCenter.getPSDevCenterId());
        if (pSDevCenter2 != null && pSDevCenter2 != pSDevCenter) {
            pSDevCenter.copyTo((IDataObject)pSDevCenter2, false);
        }
        if (pSDevCenter2 == null) {
            HashMap<String, PSDevCenter> hashMap = this.psDevCenterMap;
            synchronized (hashMap) {
                pSDevCenter2 = this.psDevCenterMap.get(pSDevCenter.getPSDevCenterId());
                if (pSDevCenter2 == null) {
                    this.psDevCenterMap.put(pSDevCenter.getPSDevCenterId(), pSDevCenter);
                }
            }
        }
    }

    public int getPSDevCenterCount() {
        return this.psDevCenterMap.size();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getPSDevSlnSys(String string) throws Exception {
        Object object;
        PSDevSlnSys pSDevSlnSys = this.psDevSlnSysMap.get(string);
        if (pSDevSlnSys != null) {
            if (PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().getPSEntity("PSDEVSLNSYS", (IEntity)pSDevSlnSys, false)) {
                return pSDevSlnSys;
            }
            object = this.psDevSlnSysMap;
            synchronized (object) {
                this.psDevSlnSysMap.remove(string);
            }
        }
        pSDevSlnSys = new PSDevSlnSys();
        pSDevSlnSys.setPSDevSlnSysId(string);
        object = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.sessionFactory);
        object.get((IEntity)pSDevSlnSys);
        if (pSDevSlnSys.getValidFlag() == null) {
            pSDevSlnSys.setValidFlag(1);
        }
        if (pSDevSlnSys.getDevSysState() == null) {
            pSDevSlnSys.setDevSysState(30);
        }
        PSDevCenter pSDevCenter = new PSDevCenter();
        pSDevCenter.setPSDevCenterId(pSDevSlnSys.getPSDevCenterId());
        PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.sessionFactory);
        pSDevCenterService.get((IEntity)pSDevCenter);
        String string2 = pSDevCenter.getPSSvrDomainId();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = "DEFAULT";
        }
        pSDevSlnSys.set("PSSVRDOMAINID", string2);
        this.updatePSDevSlnSys(pSDevSlnSys);
        return pSDevSlnSys;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updatePSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        block11: {
            try {
                Object object;
                EntityBase entityBase;
                if (!PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().hasPSEntity("PSDEVSLNSYS", (IEntity)pSDevSlnSys)) {
                    log.debug((Object)StringHelper.format((String)"[zk]\u66f4\u65b0\u5f00\u53d1\u7cfb\u7edf[%1$s]", (Object)pSDevSlnSys.getPSDevSlnSysId()));
                    if (pSDevSlnSys.getValidFlag() == null) {
                        pSDevSlnSys.setValidFlag(1);
                    }
                    if (pSDevSlnSys.getDevSysState() == null) {
                        pSDevSlnSys.setDevSysState(30);
                    }
                    entityBase = new PSDevCenter();
                    entityBase.setPSDevCenterId(pSDevSlnSys.getPSDevCenterId());
                    object = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.sessionFactory);
                    object.get((IEntity)entityBase);
                    String string = entityBase.getPSSvrDomainId();
                    if (StringHelper.isNullOrEmpty((String)string)) {
                        string = "DEFAULT";
                    }
                    pSDevSlnSys.set("PSSVRDOMAINID", string);
                }
                PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().updatePSEntity("PSDEVSLNSYS", (IEntity)pSDevSlnSys, true);
                entityBase = this.psDevSlnSysMap.get(pSDevSlnSys.getPSDevSlnSysId());
                if (entityBase != null && entityBase != pSDevSlnSys) {
                    pSDevSlnSys.copyTo((IDataObject)entityBase, false);
                }
                if (entityBase != null) break block11;
                object = this.psDevSlnSysMap;
                synchronized (object) {
                    entityBase = this.psDevSlnSysMap.get(pSDevSlnSys.getPSDevSlnSysId());
                    if (entityBase == null) {
                        this.psDevSlnSysMap.put(pSDevSlnSys.getPSDevSlnSysId(), pSDevSlnSys);
                    }
                }
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"[zk]\u66f4\u65b0\u5f00\u53d1\u7cfb\u7edf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)pSDevSlnSys.getPSDevSlnSysId(), (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"[zk]\u66f4\u65b0\u5f00\u53d1\u7cfb\u7edf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)pSDevSlnSys.getPSDevSlnSysId(), (Object)exception.getMessage()), exception);
            }
        }
    }

    public int getPSDevSlnSysCount() {
        return this.psDevSlnSysMap.size();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fillPSDevSlnSysIdList(ArrayList<String> arrayList) {
        HashMap<String, PSDevSlnSys> hashMap = this.psDevSlnSysMap;
        synchronized (hashMap) {
            arrayList.addAll(this.psDevSlnSysMap.keySet());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resetPSDevSlnSys(String string) throws Exception {
        try {
            log.debug((Object)StringHelper.format((String)"[zk]\u5220\u9664\u5f00\u53d1\u7cfb\u7edf[%1$s]", (Object)string));
            HashMap<String, PSDevSlnSys> hashMap = this.psDevSlnSysMap;
            synchronized (hashMap) {
                this.psDevSlnSysMap.remove(string);
            }
            PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().removePSEntity("PSDEVSLNSYS", string);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"[zk]\u5220\u9664\u5f00\u53d1\u7cfb\u7edf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)string, (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"[zk]\u5220\u9664\u5f00\u53d1\u7cfb\u7edf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)string, (Object)exception.getMessage()), exception);
        }
    }

    public boolean isPSDevSlnSysEnabled() throws Exception {
        return PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().isPSEntityEnabled("PSDEVSLNSYS");
    }

    public PSDevUser getPSDevUser(String string) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCRobot getPSDCRobot(String string) throws Exception {
        Object object;
        PSDCRobot pSDCRobot = this.psDCRobotMap.get(string);
        if (pSDCRobot != null) {
            if (PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().getPSEntity("PSDCROBOT", (IEntity)pSDCRobot, false)) {
                return pSDCRobot;
            }
            object = this.psDCRobotMap;
            synchronized (object) {
                this.psDCRobotMap.remove(string);
            }
        }
        pSDCRobot = new PSDCRobot();
        pSDCRobot.setPSDCRobotId(string);
        object = (PSDCRobotService)ServiceGlobal.getService(PSDCRobotService.class, (SessionFactory)this.sessionFactory);
        object.get((IEntity)pSDCRobot);
        PSDevCenter pSDevCenter = new PSDevCenter();
        pSDevCenter.setPSDevCenterId(pSDCRobot.getPSDevCenterId());
        PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.sessionFactory);
        pSDevCenterService.get((IEntity)pSDevCenter);
        String string2 = pSDevCenter.getPSSvrDomainId();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = "DEFAULT";
        }
        pSDCRobot.set("PSSVRDOMAINID", string2);
        this.updatePSDCRobot(pSDCRobot);
        return pSDCRobot;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updatePSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        Object object;
        PSDCRobot pSDCRobot2;
        if (!PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().hasPSEntity("PSDCROBOT", (IEntity)pSDCRobot)) {
            pSDCRobot2 = new PSDCRobot();
            pSDCRobot2.setPSDCRobotId(pSDCRobot.getPSDCRobotId());
            object = (PSDCRobotService)ServiceGlobal.getService(PSDCRobotService.class, (SessionFactory)this.sessionFactory);
            object.get((IEntity)pSDCRobot2);
            pSDCRobot.copyTo((IDataObject)pSDCRobot2, false);
            pSDCRobot2.copyTo((IDataObject)pSDCRobot, true);
            PSDevCenter pSDevCenter = new PSDevCenter();
            pSDevCenter.setPSDevCenterId(pSDCRobot.getPSDevCenterId());
            PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.sessionFactory);
            pSDevCenterService.get((IEntity)pSDevCenter);
            String string = pSDevCenter.getPSSvrDomainId();
            if (StringHelper.isNullOrEmpty((String)string)) {
                string = "DEFAULT";
            }
            pSDCRobot.set("PSSVRDOMAINID", string);
        }
        PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().updatePSEntity("PSDCROBOT", (IEntity)pSDCRobot, true);
        pSDCRobot2 = this.psDCRobotMap.get(pSDCRobot.getPSDCRobotId());
        if (pSDCRobot2 != null && pSDCRobot2 != pSDCRobot) {
            pSDCRobot.copyTo((IDataObject)pSDCRobot2, false);
        }
        if (pSDCRobot2 == null) {
            object = this.psDCRobotMap;
            synchronized (object) {
                pSDCRobot2 = this.psDCRobotMap.get(pSDCRobot.getPSDCRobotId());
                if (pSDCRobot2 == null) {
                    this.psDCRobotMap.put(pSDCRobot.getPSDCRobotId(), pSDCRobot);
                }
            }
        }
    }

    public int getPSDCRobotCount() {
        return this.psDCRobotMap.size();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fillPSDCRobotIdList(ArrayList<String> arrayList) {
        HashMap<String, PSDCRobot> hashMap = this.psDCRobotMap;
        synchronized (hashMap) {
            arrayList.addAll(this.psDCRobotMap.keySet());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resetPSDCRobot(String string) throws Exception {
        HashMap<String, PSDCRobot> hashMap = this.psDCRobotMap;
        synchronized (hashMap) {
            this.psDCRobotMap.remove(string);
        }
        PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().removePSEntity("PSDCROBOT", string);
    }

    public boolean isPSDCRobotEnabled() throws Exception {
        return PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().isPSEntityEnabled("PSDCROBOT");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFStyle getPSPFStyle(String string) throws Exception {
        Object object;
        PSPFStyle pSPFStyle = this.psPFStyleMap.get(string);
        if (pSPFStyle != null) {
            if (PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().getPSEntity("PSPFSTYLE", (IEntity)pSPFStyle, false)) {
                return pSPFStyle;
            }
            object = this.psPFStyleMap;
            synchronized (object) {
                this.psPFStyleMap.remove(string);
            }
        }
        pSPFStyle = new PSPFStyle();
        pSPFStyle.setPSPFStyleId(string);
        object = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.sessionFactory);
        object.get((IEntity)pSPFStyle);
        PSDevCenter pSDevCenter = new PSDevCenter();
        pSDevCenter.setPSDevCenterId(pSPFStyle.getPSDevCenterId());
        PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.sessionFactory);
        pSDevCenterService.get((IEntity)pSDevCenter);
        String string2 = pSDevCenter.getPSSvrDomainId();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = "DEFAULT";
        }
        pSPFStyle.set("PSSVRDOMAINID", string2);
        this.updatePSPFStyle(pSPFStyle);
        return pSPFStyle;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updatePSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        Object object;
        PSPFStyle pSPFStyle2;
        if (!PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().hasPSEntity("PSPFSTYLE", (IEntity)pSPFStyle)) {
            pSPFStyle2 = new PSPFStyle();
            pSPFStyle2.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
            object = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.sessionFactory);
            object.get((IEntity)pSPFStyle2);
            pSPFStyle.copyTo((IDataObject)pSPFStyle2, false);
            pSPFStyle2.copyTo((IDataObject)pSPFStyle, true);
            PSDevCenter pSDevCenter = new PSDevCenter();
            pSDevCenter.setPSDevCenterId(pSPFStyle.getPSDevCenterId());
            PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.sessionFactory);
            pSDevCenterService.get((IEntity)pSDevCenter);
            String string = pSDevCenter.getPSSvrDomainId();
            if (StringHelper.isNullOrEmpty((String)string)) {
                string = "DEFAULT";
            }
            pSPFStyle.set("PSSVRDOMAINID", string);
        }
        PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().updatePSEntity("PSPFSTYLE", (IEntity)pSPFStyle, true);
        pSPFStyle2 = this.psPFStyleMap.get(pSPFStyle.getPSPFStyleId());
        if (pSPFStyle2 != null && pSPFStyle2 != pSPFStyle) {
            pSPFStyle.copyTo((IDataObject)pSPFStyle2, false);
        }
        if (pSPFStyle2 == null) {
            object = this.psPFStyleMap;
            synchronized (object) {
                pSPFStyle2 = this.psPFStyleMap.get(pSPFStyle.getPSPFStyleId());
                if (pSPFStyle2 == null) {
                    this.psPFStyleMap.put(pSPFStyle.getPSPFStyleId(), pSPFStyle);
                }
            }
        }
    }

    public int getPSPFStyleCount() {
        return this.psPFStyleMap.size();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fillPSPFStyleIdList(ArrayList<String> arrayList) {
        HashMap<String, PSPFStyle> hashMap = this.psPFStyleMap;
        synchronized (hashMap) {
            arrayList.addAll(this.psPFStyleMap.keySet());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resetPSPFStyle(String string) throws Exception {
        HashMap<String, PSPFStyle> hashMap = this.psPFStyleMap;
        synchronized (hashMap) {
            this.psPFStyleMap.remove(string);
        }
        PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().removePSEntity("PSPFSTYLE", string);
    }

    public boolean isPSPFStyleEnabled() throws Exception {
        return PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().isPSEntityEnabled("PSPFSTYLE");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSVNServer getPSSVNServer(String string) throws Exception {
        Object object;
        PSSVNServer pSSVNServer = this.psSVNServerMap.get(string);
        if (pSSVNServer != null) {
            if (PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().getPSEntity("PSSVNSERVER", (IEntity)pSSVNServer, false)) {
                return pSSVNServer;
            }
            object = this.psSVNServerMap;
            synchronized (object) {
                this.psSVNServerMap.remove(string);
            }
        }
        pSSVNServer = new PSSVNServer();
        pSSVNServer.setPSSVNServerId(string);
        object = (PSSVNServerService)ServiceGlobal.getService(PSSVNServerService.class, (SessionFactory)this.sessionFactory);
        object.get((IEntity)pSSVNServer);
        String string2 = pSSVNServer.getPSSvrDomainId();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = "DEFAULT";
        }
        pSSVNServer.setPSSvrDomainId(string2);
        this.updatePSSVNServer(pSSVNServer);
        return pSSVNServer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updatePSSVNServer(PSSVNServer pSSVNServer) throws Exception {
        Object object;
        PSSVNServer pSSVNServer2;
        if (!PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().hasPSEntity("PSSVNSERVER", (IEntity)pSSVNServer)) {
            pSSVNServer2 = new PSSVNServer();
            pSSVNServer2.setPSSVNServerId(pSSVNServer.getPSSVNServerId());
            object = (PSSVNServerService)ServiceGlobal.getService(PSSVNServerService.class, (SessionFactory)this.sessionFactory);
            object.get((IEntity)pSSVNServer2);
            pSSVNServer.copyTo((IDataObject)pSSVNServer2, false);
            pSSVNServer2.copyTo((IDataObject)pSSVNServer, true);
            String string = pSSVNServer2.getPSSvrDomainId();
            if (StringHelper.isNullOrEmpty((String)string)) {
                string = "DEFAULT";
            }
            pSSVNServer.setPSSvrDomainId(string);
        }
        PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().updatePSEntity("PSSVNSERVER", (IEntity)pSSVNServer, true);
        pSSVNServer2 = this.psSVNServerMap.get(pSSVNServer.getPSSVNServerId());
        if (pSSVNServer2 != null && pSSVNServer2 != pSSVNServer) {
            pSSVNServer.copyTo((IDataObject)pSSVNServer2, false);
        }
        if (pSSVNServer2 == null) {
            object = this.psSVNServerMap;
            synchronized (object) {
                pSSVNServer2 = this.psSVNServerMap.get(pSSVNServer.getPSSVNServerId());
                if (pSSVNServer2 == null) {
                    this.psSVNServerMap.put(pSSVNServer.getPSSVNServerId(), pSSVNServer);
                }
            }
        }
    }

    public int getPSSVNServerCount() {
        return this.psSVNServerMap.size();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fillPSSVNServerIdList(ArrayList<String> arrayList) {
        HashMap<String, PSSVNServer> hashMap = this.psSVNServerMap;
        synchronized (hashMap) {
            arrayList.addAll(this.psSVNServerMap.keySet());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resetPSSVNServer(String string) throws Exception {
        HashMap<String, PSSVNServer> hashMap = this.psSVNServerMap;
        synchronized (hashMap) {
            this.psSVNServerMap.remove(string);
        }
        PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().removePSEntity("PSSVNSERVER", string);
    }

    public boolean isPSSVNServerEnabled() throws Exception {
        return PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().isPSEntityEnabled("PSSVNSERVER");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFStyle getPSSFStyle(String string) throws Exception {
        Object object;
        PSSFStyle pSSFStyle = this.psSFStyleMap.get(string);
        if (pSSFStyle != null) {
            if (PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().getPSEntity("PSSFSTYLE", (IEntity)pSSFStyle, false)) {
                return pSSFStyle;
            }
            object = this.psSFStyleMap;
            synchronized (object) {
                this.psSFStyleMap.remove(string);
            }
        }
        pSSFStyle = new PSSFStyle();
        pSSFStyle.setPSSFStyleId(string);
        object = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.sessionFactory);
        object.get((IEntity)pSSFStyle);
        PSDevCenter pSDevCenter = new PSDevCenter();
        pSDevCenter.setPSDevCenterId(pSSFStyle.getPSDevCenterId());
        PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.sessionFactory);
        pSDevCenterService.get((IEntity)pSDevCenter);
        String string2 = pSDevCenter.getPSSvrDomainId();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = "DEFAULT";
        }
        pSSFStyle.set("PSSVRDOMAINID", string2);
        this.updatePSSFStyle(pSSFStyle);
        return pSSFStyle;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updatePSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        Object object;
        PSSFStyle pSSFStyle2;
        if (!PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().hasPSEntity("PSSFSTYLE", (IEntity)pSSFStyle)) {
            pSSFStyle2 = new PSSFStyle();
            pSSFStyle2.setPSSFStyleId(pSSFStyle.getPSSFStyleId());
            object = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.sessionFactory);
            object.get((IEntity)pSSFStyle2);
            pSSFStyle.copyTo((IDataObject)pSSFStyle2, false);
            pSSFStyle2.copyTo((IDataObject)pSSFStyle, true);
            PSDevCenter pSDevCenter = new PSDevCenter();
            pSDevCenter.setPSDevCenterId(pSSFStyle.getPSDevCenterId());
            PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.sessionFactory);
            pSDevCenterService.get((IEntity)pSDevCenter);
            String string = pSDevCenter.getPSSvrDomainId();
            if (StringHelper.isNullOrEmpty((String)string)) {
                string = "DEFAULT";
            }
            pSSFStyle.set("PSSVRDOMAINID", string);
        }
        PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().updatePSEntity("PSSFSTYLE", (IEntity)pSSFStyle, true);
        pSSFStyle2 = this.psSFStyleMap.get(pSSFStyle.getPSSFStyleId());
        if (pSSFStyle2 != null && pSSFStyle2 != pSSFStyle) {
            pSSFStyle.copyTo((IDataObject)pSSFStyle2, false);
        }
        if (pSSFStyle2 == null) {
            object = this.psSFStyleMap;
            synchronized (object) {
                pSSFStyle2 = this.psSFStyleMap.get(pSSFStyle.getPSSFStyleId());
                if (pSSFStyle2 == null) {
                    this.psSFStyleMap.put(pSSFStyle.getPSSFStyleId(), pSSFStyle);
                }
            }
        }
    }

    public int getPSSFStyleCount() {
        return this.psSFStyleMap.size();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fillPSSFStyleIdList(ArrayList<String> arrayList) {
        HashMap<String, PSSFStyle> hashMap = this.psSFStyleMap;
        synchronized (hashMap) {
            arrayList.addAll(this.psSFStyleMap.keySet());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resetPSSFStyle(String string) throws Exception {
        HashMap<String, PSSFStyle> hashMap = this.psSFStyleMap;
        synchronized (hashMap) {
            this.psSFStyleMap.remove(string);
        }
        PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().removePSEntity("PSSFSTYLE", string);
    }

    public boolean isPSSFStyleEnabled() throws Exception {
        return PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().isPSEntityEnabled("PSSFSTYLE");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCWorkspace getPSDCWorkspace(String string) throws Exception {
        Object object;
        PSDCWorkspace pSDCWorkspace = this.psDCWorkspaceMap.get(string);
        if (pSDCWorkspace != null) {
            if (PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().getPSEntity("PSDCWORKSPACE", (IEntity)pSDCWorkspace, false)) {
                return pSDCWorkspace;
            }
            object = this.psDCWorkspaceMap;
            synchronized (object) {
                this.psDCWorkspaceMap.remove(string);
            }
        }
        pSDCWorkspace = new PSDCWorkspace();
        pSDCWorkspace.setPSDCWorkspaceId(string);
        object = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)this.sessionFactory);
        object.get((IEntity)pSDCWorkspace);
        PSDevCenter pSDevCenter = new PSDevCenter();
        pSDevCenter.setPSDevCenterId(pSDCWorkspace.getPSDevCenterId());
        PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.sessionFactory);
        pSDevCenterService.get((IEntity)pSDevCenter);
        String string2 = pSDevCenter.getPSSvrDomainId();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = "DEFAULT";
        }
        pSDCWorkspace.set("PSSVRDOMAINID", string2);
        this.updatePSDCWorkspace(pSDCWorkspace);
        return pSDCWorkspace;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updatePSDCWorkspace(PSDCWorkspace pSDCWorkspace) throws Exception {
        block9: {
            try {
                Object object;
                PSDCWorkspace pSDCWorkspace2;
                if (!PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().hasPSEntity("PSDCWORKSPACE", (IEntity)pSDCWorkspace)) {
                    log.debug((Object)StringHelper.format((String)"[zk]\u66f4\u65b0\u4e2d\u5fc3\u751f\u4ea7\u7ebf[%1$s]", (Object)pSDCWorkspace.getPSDCWorkspaceId()));
                    pSDCWorkspace2 = new PSDCWorkspace();
                    pSDCWorkspace2.setPSDCWorkspaceId(pSDCWorkspace.getPSDCWorkspaceId());
                    object = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)this.sessionFactory);
                    object.get((IEntity)pSDCWorkspace2);
                    pSDCWorkspace.copyTo((IDataObject)pSDCWorkspace2, false);
                    pSDCWorkspace2.copyTo((IDataObject)pSDCWorkspace, true);
                    PSDevCenter pSDevCenter = new PSDevCenter();
                    pSDevCenter.setPSDevCenterId(pSDCWorkspace.getPSDevCenterId());
                    PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.sessionFactory);
                    pSDevCenterService.get((IEntity)pSDevCenter);
                    String string = pSDevCenter.getPSSvrDomainId();
                    if (StringHelper.isNullOrEmpty((String)string)) {
                        string = "DEFAULT";
                    }
                    pSDCWorkspace.set("PSSVRDOMAINID", string);
                }
                PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().updatePSEntity("PSDCWORKSPACE", (IEntity)pSDCWorkspace, true);
                pSDCWorkspace2 = this.psDCWorkspaceMap.get(pSDCWorkspace.getPSDCWorkspaceId());
                if (pSDCWorkspace2 != null && pSDCWorkspace2 != pSDCWorkspace) {
                    pSDCWorkspace.copyTo((IDataObject)pSDCWorkspace2, false);
                }
                if (pSDCWorkspace2 != null) break block9;
                object = this.psDCWorkspaceMap;
                synchronized (object) {
                    pSDCWorkspace2 = this.psDCWorkspaceMap.get(pSDCWorkspace.getPSDCWorkspaceId());
                    if (pSDCWorkspace2 == null) {
                        this.psDCWorkspaceMap.put(pSDCWorkspace.getPSDCWorkspaceId(), pSDCWorkspace);
                    }
                }
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"[zk]\u66f4\u65b0\u4e2d\u5fc3\u751f\u4ea7\u7ebf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)pSDCWorkspace.getPSDCWorkspaceId(), (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"[zk]\u66f4\u65b0\u4e2d\u5fc3\u751f\u4ea7\u7ebf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)pSDCWorkspace.getPSDCWorkspaceId(), (Object)exception.getMessage()), exception);
            }
        }
    }

    public int getPSDCWorkspaceCount() {
        return this.psDCWorkspaceMap.size();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fillPSDCWorkspaceIdList(ArrayList<String> arrayList) {
        HashMap<String, PSDCWorkspace> hashMap = this.psDCWorkspaceMap;
        synchronized (hashMap) {
            arrayList.addAll(this.psDCWorkspaceMap.keySet());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resetPSDCWorkspace(String string) throws Exception {
        try {
            log.debug((Object)StringHelper.format((String)"[zk]\u5220\u9664\u4e2d\u5fc3\u751f\u4ea7\u7ebf[%1$s]", (Object)string));
            HashMap<String, PSDCWorkspace> hashMap = this.psDCWorkspaceMap;
            synchronized (hashMap) {
                this.psDCWorkspaceMap.remove(string);
            }
            PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().removePSEntity("PSDCWORKSPACE", string);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"[zk]\u5220\u9664\u4e2d\u5fc3\u751f\u4ea7\u7ebf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)string, (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"[zk]\u5220\u9664\u4e2d\u5fc3\u751f\u4ea7\u7ebf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)string, (Object)exception.getMessage()), exception);
        }
    }

    public boolean isPSDCWorkspaceEnabled() throws Exception {
        return PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().isPSEntityEnabled("PSDCWORKSPACE");
    }

    public boolean isPSDevSlnSysDynaInstEnabled() throws Exception {
        return PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().isPSEntityEnabled("PSDEVSLNSYSDYNAINST");
    }

    public int getPSDevSlnSysDynaInstCount() {
        return this.psDevSlnSysDynaInstMap.size();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysDynaInst getPSDevSlnSysDynaInst(String string) throws Exception {
        Object object;
        PSDevSlnSysDynaInst pSDevSlnSysDynaInst = this.psDevSlnSysDynaInstMap.get(string);
        if (pSDevSlnSysDynaInst != null) {
            if (PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().getPSEntity("PSDEVSLNSYSDYNAINST", (IEntity)pSDevSlnSysDynaInst, false)) {
                return pSDevSlnSysDynaInst;
            }
            object = this.psDevSlnSysDynaInstMap;
            synchronized (object) {
                this.psDevSlnSysDynaInstMap.remove(string);
            }
        }
        pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
        pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId(string);
        object = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)this.sessionFactory);
        object.get((IEntity)pSDevSlnSysDynaInst);
        PSDevCenter pSDevCenter = new PSDevCenter();
        pSDevCenter.setPSDevCenterId(pSDevSlnSysDynaInst.getPSDevCenterId());
        PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.sessionFactory);
        pSDevCenterService.get((IEntity)pSDevCenter);
        String string2 = pSDevCenter.getPSSvrDomainId();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = "DEFAULT";
        }
        pSDevSlnSysDynaInst.set("PSSVRDOMAINID", string2);
        this.updatePSDevSlnSysDynaInst(pSDevSlnSysDynaInst);
        return pSDevSlnSysDynaInst;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updatePSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        block9: {
            try {
                Object object;
                PSDevSlnSysDynaInst pSDevSlnSysDynaInst2;
                if (!PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().hasPSEntity("PSDEVSLNSYSDYNAINST", (IEntity)pSDevSlnSysDynaInst)) {
                    log.debug((Object)StringHelper.format((String)"[zk]\u66f4\u65b0\u5f00\u53d1\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b[%1$s]", (Object)pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId()));
                    pSDevSlnSysDynaInst2 = new PSDevSlnSysDynaInst();
                    pSDevSlnSysDynaInst2.setPSDevSlnSysDynaInstId(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
                    object = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)this.sessionFactory);
                    object.get((IEntity)pSDevSlnSysDynaInst2);
                    pSDevSlnSysDynaInst.copyTo((IDataObject)pSDevSlnSysDynaInst2, false);
                    pSDevSlnSysDynaInst2.copyTo((IDataObject)pSDevSlnSysDynaInst, true);
                    PSDevCenter pSDevCenter = new PSDevCenter();
                    pSDevCenter.setPSDevCenterId(pSDevSlnSysDynaInst.getPSDevCenterId());
                    PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.sessionFactory);
                    pSDevCenterService.get((IEntity)pSDevCenter);
                    String string = pSDevCenter.getPSSvrDomainId();
                    if (StringHelper.isNullOrEmpty((String)string)) {
                        string = "DEFAULT";
                    }
                    pSDevSlnSysDynaInst.set("PSSVRDOMAINID", string);
                }
                PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().updatePSEntity("PSDEVSLNSYSDYNAINST", (IEntity)pSDevSlnSysDynaInst, true);
                pSDevSlnSysDynaInst2 = this.psDevSlnSysDynaInstMap.get(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
                if (pSDevSlnSysDynaInst2 != null && pSDevSlnSysDynaInst2 != pSDevSlnSysDynaInst) {
                    pSDevSlnSysDynaInst.copyTo((IDataObject)pSDevSlnSysDynaInst2, false);
                }
                if (pSDevSlnSysDynaInst2 != null) break block9;
                object = this.psDevSlnSysDynaInstMap;
                synchronized (object) {
                    pSDevSlnSysDynaInst2 = this.psDevSlnSysDynaInstMap.get(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
                    if (pSDevSlnSysDynaInst2 == null) {
                        this.psDevSlnSysDynaInstMap.put(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId(), pSDevSlnSysDynaInst);
                    }
                }
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"[zk]\u66f4\u65b0\u5f00\u53d1\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId(), (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"[zk]\u66f4\u65b0\u5f00\u53d1\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId(), (Object)exception.getMessage()), exception);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fillPSDevSlnSysDynaInstIdList(ArrayList<String> arrayList) {
        HashMap<String, PSDevSlnSysDynaInst> hashMap = this.psDevSlnSysDynaInstMap;
        synchronized (hashMap) {
            arrayList.addAll(this.psDevSlnSysDynaInstMap.keySet());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resetPSDevSlnSysDynaInst(String string) throws Exception {
        try {
            log.debug((Object)StringHelper.format((String)"[zk]\u5220\u9664\u5f00\u53d1\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b[%1$s]", (Object)string));
            HashMap<String, PSDevSlnSysDynaInst> hashMap = this.psDevSlnSysDynaInstMap;
            synchronized (hashMap) {
                this.psDevSlnSysDynaInstMap.remove(string);
            }
            PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().removePSEntity("PSDEVSLNSYSDYNAINST", string);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"[zk]\u5220\u9664\u5f00\u53d1\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)string, (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"[zk]\u5220\u9664\u5f00\u53d1\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)string, (Object)exception.getMessage()), exception);
        }
    }

    public PSDCWorkspace verifyPSDCWorkspace(String string) throws Exception {
        PSDCWorkspace pSDCWorkspace = this.getPSDCWorkspace(string);
        if (DataObject.getIntegerValue((Object)pSDCWorkspace.getWorkspaceState(), (Integer)10) != 30) {
            throw new Exception("\u751f\u4ea7\u7ebf\u72b6\u6001\u4e0d\u6b63\u786e");
        }
        return pSDCWorkspace;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSvrDomain getPSSvrDomain(String string) throws Exception {
        Object object;
        PSSvrDomain pSSvrDomain = this.psSvrDomainMap.get(string);
        if (pSSvrDomain != null) {
            if (PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().getPSEntity("PSSVRDOMAIN", (IEntity)pSSvrDomain, false)) {
                return pSSvrDomain;
            }
            object = this.psSvrDomainMap;
            synchronized (object) {
                this.psSvrDomainMap.remove(string);
            }
        }
        pSSvrDomain = new PSSvrDomain();
        pSSvrDomain.setPSSvrDomainId(string);
        object = (PSSvrDomainService)ServiceGlobal.getService(PSSvrDomainService.class, (SessionFactory)this.sessionFactory);
        object.get((IEntity)pSSvrDomain);
        pSSvrDomain.setPSSvrDomainId(string);
        this.updatePSSvrDomain(pSSvrDomain);
        return pSSvrDomain;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updatePSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        Object object;
        PSSvrDomain pSSvrDomain2;
        if (!PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().hasPSEntity("PSSVRDOMAIN", (IEntity)pSSvrDomain)) {
            pSSvrDomain2 = new PSSvrDomain();
            pSSvrDomain2.setPSSvrDomainId(pSSvrDomain.getPSSvrDomainId());
            object = (PSSvrDomainService)ServiceGlobal.getService(PSSvrDomainService.class, (SessionFactory)this.sessionFactory);
            object.get((IEntity)pSSvrDomain2);
            pSSvrDomain.copyTo((IDataObject)pSSvrDomain2, false);
            pSSvrDomain2.copyTo((IDataObject)pSSvrDomain, true);
        }
        PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().updatePSEntity("PSSVRDOMAIN", (IEntity)pSSvrDomain, true);
        pSSvrDomain2 = this.psSvrDomainMap.get(pSSvrDomain.getPSSvrDomainId());
        if (pSSvrDomain2 != null && pSSvrDomain2 != pSSvrDomain) {
            pSSvrDomain.copyTo((IDataObject)pSSvrDomain2, false);
        }
        if (pSSvrDomain2 == null) {
            object = this.psSvrDomainMap;
            synchronized (object) {
                pSSvrDomain2 = this.psSvrDomainMap.get(pSSvrDomain.getPSSvrDomainId());
                if (pSSvrDomain2 == null) {
                    this.psSvrDomainMap.put(pSSvrDomain.getPSSvrDomainId(), pSSvrDomain);
                }
            }
        }
    }

    public int getPSSvrDomainCount() {
        return this.psSvrDomainMap.size();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fillPSSvrDomainIdList(ArrayList<String> arrayList) {
        HashMap<String, PSSvrDomain> hashMap = this.psSvrDomainMap;
        synchronized (hashMap) {
            arrayList.addAll(this.psSvrDomainMap.keySet());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resetPSSvrDomain(String string) throws Exception {
        HashMap<String, PSSvrDomain> hashMap = this.psSvrDomainMap;
        synchronized (hashMap) {
            this.psSvrDomainMap.remove(string);
        }
        PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().removePSEntity("PSSVRDOMAIN", string);
    }

    public boolean isPSSvrDomainEnabled() throws Exception {
        return PSCoreEntityKeeperGlobal.getPSEntityKeeperGlobal().isPSEntityEnabled("PSSVRDOMAIN");
    }

    public static void initAll() throws Exception {
        PSCoreEntityKeeperGlobal.initPSDevUser();
        PSCoreEntityKeeperGlobal.initPSDevCenter();
        PSCoreEntityKeeperGlobal.initPSDevSlnSys();
        PSCoreEntityKeeperGlobal.initPSDCRobot();
        PSCoreEntityKeeperGlobal.initPSDCWorkspace();
        PSCoreEntityKeeperGlobal.initPSPFStyle();
        PSCoreEntityKeeperGlobal.initPSSFStyle();
        PSCoreEntityKeeperGlobal.initPSSVNServer();
        PSCoreEntityKeeperGlobal.initPSSvrDomain();
        PSCoreEntityKeeperGlobal.initPSDevSlnSysDynaInst();
    }
}

