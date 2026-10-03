/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.ArrayList;
import java.util.Date;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DevCenterResStateCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPubBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemAS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemASBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfgBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemRunBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRunSessionServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemASService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemASServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemRunService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysRunSessionService
extends PSSysRunSessionServiceBase {
    private static final Log log = LogFactory.getLog(PSSysRunSessionService.class);
    public static final String RUNMODE_PUBCODE = "PUBCODE";
    public static final String RUNMODE_PUBDOC = "PUBDOC";
    public static final String RUNMODE_PUBMODEL = "PUBMODEL";
    public static final String RUNMODE_STARTX = "STARTX";
    public static final String RUNMODE_PACKVER = "PACKVER";
    public static final String RUNMODE_PACKMOBAPP = "PACKMOBAPP";

    @Override
    public void getDraft(PSSysRunSession pSSysRunSession) throws Exception {
        super.getDraft(pSSysRunSession);
        if (!StringHelper.isNullOrEmpty((String)pSSysRunSession.getPSSystemId())) {
            boolean bl = StringHelper.compare((String)pSSysRunSession.getRunMode(), (String)RUNMODE_PUBDOC, (boolean)true) == 0;
            PSSystemRunBase selectedRun = null;
            if (!bl) {
                PSSystemRunService pSSystemRunService = (PSSystemRunService)ServiceGlobal.getService(PSSystemRunService.class, (SessionFactory)this.getSessionFactory());
                for (PSSystemRunBase systemRun : pSSystemRunService.selectByPSSystem(pSSysRunSession.getPSSystem())) {
                    if (selectedRun == null) {
                        selectedRun = systemRun;
                    }
                    if (!DataObject.getBoolValue((Integer)systemRun.getDefaultFlag(), (boolean)false)) continue;
                    selectedRun = systemRun;
                    break;
                }
            }
            if (selectedRun != null) {
                if (StringHelper.compare((String)pSSysRunSession.getRunMode(), (String)RUNMODE_PACKMOBAPP, (boolean)true) != 0) {
                    pSSysRunSession.setPSSysAppId(selectedRun.getPSSysAppId());
                    pSSysRunSession.setPSSysAppId2(selectedRun.getPSSysAppId2());
                    pSSysRunSession.setPSSysAppName(selectedRun.getPSSysAppName());
                    pSSysRunSession.setPSSysAppName2(selectedRun.getPSSysAppName2());
                    pSSysRunSession.setPSSysSFPubId(selectedRun.getPSSysSFPubId());
                    pSSysRunSession.setPSSysSFPubName(selectedRun.getPSSysSFPubName());
                    pSSysRunSession.setPSSystemASId(selectedRun.getPSSystemASId());
                    pSSysRunSession.setPSSystemASName(selectedRun.getPSSystemASName());
                    pSSysRunSession.setPSSystemDBCfgId(selectedRun.getPSSystemDBCfgId());
                    pSSysRunSession.setPSSystemDBCfgName(selectedRun.getPSSystemDBCfgName());
                    pSSysRunSession.setRunPSSysDynaModelId(selectedRun.getRunPSSysDynaModelId());
                    pSSysRunSession.setRunPSSysDynaModelName(selectedRun.getRunPSSysDynaModelName());
                }
            } else {
                boolean bl2 = StringHelper.compare((String)pSSysRunSession.getRunMode(), (String)RUNMODE_STARTX, (boolean)true) == 0;
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                PSSysSFPubService pSSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)this.getSessionFactory());
                PSSystemASService pSSystemASService = (PSSystemASService)ServiceGlobal.getService(PSSystemASService.class, (SessionFactory)this.getSessionFactory());
                PSSystemDBCfgService pSSystemDBCfgService = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)this.getSessionFactory());
                if (!bl) {
                    ArrayList<PSSysApp> apps = pSSysAppService.selectByPSSystem(pSSysRunSession.getPSSystem());
                    if (!apps.isEmpty()) {
                        PSSysApp selectedApp = null;
                        for (PSSysApp app : apps) {
                            if (selectedApp == null) {
                                selectedApp = app;
                                continue;
                            }
                            if (!DataObject.getBoolValue((Integer)app.getDefaultPub(), (boolean)false)) continue;
                            selectedApp = app;
                            break;
                        }
                        pSSysRunSession.setPSSysAppId(selectedApp.getPSSysAppId());
                        pSSysRunSession.setPSSysAppName(selectedApp.getPSSysAppName());
                    }
                }
                ArrayList<PSSysSFPub> pubs = pSSysSFPubService.selectByPSSystem(pSSysRunSession.getPSSystem());
                if (!pubs.isEmpty()) {
                    PSSysSFPub selectedPub = null;
                    for (PSSysSFPub pub : pubs) {
                        if (bl && StringHelper.compare((String)"DOC", (String)pub.getContentType(), (boolean)false) != 0) continue;
                        if (selectedPub == null) {
                            selectedPub = pub;
                            continue;
                        }
                        if (!DataObject.getBoolValue((Integer)pub.getDefaultPub(), (boolean)false)) continue;
                        selectedPub = pub;
                        break;
                    }
                    if (selectedPub != null) {
                        pSSysRunSession.setPSSysSFPubId(selectedPub.getPSSysSFPubId());
                        pSSysRunSession.setPSSysSFPubName(selectedPub.getPSSysSFPubName());
                    }
                }
                ArrayList<PSSystemAS> servers = pSSystemASService.selectByPSSystem(pSSysRunSession.getPSSystem());
                if (!servers.isEmpty()) {
                    PSSystemAS selectedServer = null;
                    for (PSSystemAS server : servers) {
                        if (StringHelper.isNullOrEmpty((String)server.getPSDevCenterASId()) || selectedServer != null) continue;
                        selectedServer = server;
                        break;
                    }
                    if (selectedServer != null) {
                        pSSysRunSession.setPSSystemASId(selectedServer.getPSSystemASId());
                        pSSysRunSession.setPSSystemASName(selectedServer.getPSSystemASName());
                    }
                }
                if (!bl) {
                    ArrayList<PSSystemDBCfg> dbConfigs = pSSystemDBCfgService.selectByPSSystem(pSSysRunSession.getPSSystem());
                    if (!dbConfigs.isEmpty()) {
                        PSSystemDBCfg selectedDbConfig = null;
                        for (PSSystemDBCfg dbConfig : dbConfigs) {
                            if (bl2 && StringHelper.isNullOrEmpty((String)dbConfig.getPSDevCenterDBInstId())) continue;
                            if (selectedDbConfig == null) {
                                selectedDbConfig = dbConfig;
                                continue;
                            }
                            if (!DataObject.getBoolValue((Integer)dbConfig.getDefaultFlag(), (boolean)false)) continue;
                            selectedDbConfig = dbConfig;
                            break;
                        }
                        if (selectedDbConfig != null) {
                            pSSysRunSession.setPSSystemDBCfgId(selectedDbConfig.getPSSystemDBCfgId());
                            pSSysRunSession.setPSSystemDBCfgName(selectedDbConfig.getPSSystemDBCfgName());
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void onBeforeCreate(PSSysRunSession pSSysRunSession) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSSysRunSession.getPSSysRunSessionName())) {
            if (StringHelper.compare((String)pSSysRunSession.getRunMode(), (String)RUNMODE_STARTX, (boolean)true) == 0) {
                pSSysRunSession.setPSSysRunSessionName(StringHelper.format((String)"\u7cfb\u7edf\u8fd0\u884c[%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS]", (Object)new Date()));
            } else if (StringHelper.compare((String)pSSysRunSession.getRunMode(), (String)RUNMODE_PUBCODE, (boolean)true) == 0 || StringHelper.compare((String)pSSysRunSession.getRunMode(), (String)RUNMODE_PUBDOC, (boolean)true) == 0 || StringHelper.compare((String)pSSysRunSession.getRunMode(), (String)RUNMODE_PUBMODEL, (boolean)true) == 0) {
                pSSysRunSession.setPSSysRunSessionName(StringHelper.format((String)"\u7cfb\u7edf\u53d1\u5e03[%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS]", (Object)new Date()));
            } else if (StringHelper.compare((String)pSSysRunSession.getRunMode(), (String)RUNMODE_PACKVER, (boolean)true) == 0) {
                pSSysRunSession.setPSSysRunSessionName(StringHelper.format((String)"\u7cfb\u7edf\u7248\u672c\u6253\u5305[%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS]", (Object)new Date()));
                pSSysRunSession.setRunParam2(DataObject.getStringValue((IDataObject)pSSysRunSession, (String)"psdevslnsysvername", null));
            } else if (StringHelper.compare((String)pSSysRunSession.getRunMode(), (String)RUNMODE_PACKMOBAPP, (boolean)true) == 0) {
                pSSysRunSession.setPSSysRunSessionName(StringHelper.format((String)"\u79fb\u52a8\u5e94\u7528\u6253\u5305[%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS]", (Object)new Date()));
                pSSysRunSession.setRunParam2(DataObject.getStringValue((IDataObject)pSSysRunSession, (String)"psmobapppackname", null));
            } else {
                pSSysRunSession.setPSSysRunSessionName(StringHelper.format((String)"\u7cfb\u7edf\u8fd0\u884c[%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS]", (Object)new Date()));
            }
        }
        super.onBeforeCreate(pSSysRunSession);
    }

    @Override
    protected void onAfterCreate(PSSysRunSession pSSysRunSession) throws Exception {
        super.onAfterCreate(pSSysRunSession);
        SessionFactoryManager.commit((SessionFactory)this.getSessionFactory());
        this.invokeTaskServer(pSSysRunSession, false);
    }

    @Override
    protected void onAfterUpdate(PSSysRunSession pSSysRunSession) throws Exception {
        super.onAfterUpdate(pSSysRunSession);
        SessionFactoryManager.commit((SessionFactory)this.getSessionFactory());
        this.invokeTaskServer(pSSysRunSession, true);
    }

    protected void invokeTaskServer(PSSysRunSession pSSysRunSession, boolean bl) throws Exception {
        if (pSSysRunSession.getRunState() != null && pSSysRunSession.getRunState() == 10) {
            if (StringHelper.compare((String)pSSysRunSession.getRunMode(), (String)RUNMODE_STARTX, (boolean)true) == 0) {
                if (StringHelper.isNullOrEmpty((String)pSSysRunSession.getPSSystemASId())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5e94\u7528\u5bb9\u5668");
                }
                if (StringHelper.isNullOrEmpty((String)pSSysRunSession.getPSSystemDBCfgId())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u5e93\u5b9e\u4f8b");
                }
                PSSystemAS pSSystemAS = pSSysRunSession.getPSSystemAS();
                PSSystemDBCfg pSSystemDBCfg = pSSysRunSession.getPSSystemDBCfg();
                if (StringHelper.isNullOrEmpty((String)pSSystemAS.getPSDevCenterASId())) {
                    throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u5e94\u7528\u670d\u52a1\u5668\u6ca1\u6709\u7ed1\u5b9a\u5e94\u7528\u5bb9\u5668"));
                }
                if (StringHelper.isNullOrEmpty((String)pSSystemDBCfg.getPSDevCenterDBInstId())) {
                    throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u6570\u636e\u5e93\u6ca1\u6709\u7ed1\u5b9a\u6570\u636e\u5e93\u5b9e\u4f8b"));
                }
                PSDevCenterASService pSDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                PSDevCenterAS pSDevCenterAS = new PSDevCenterAS();
                pSDevCenterAS.setPSDevCenterASId(pSSystemAS.getPSDevCenterASId());
                pSDevCenterASService.get(pSDevCenterAS);
                int n = DataObject.getIntegerValue((Object)pSDevCenterAS.getResState(), (Integer)20);
                if (n != 20) {
                    ICodeList iCodeList = CodeListGlobal.getCodeList(DevCenterResStateCodeListModel.class);
                    throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5bb9\u5668[%1$s]\u5904\u4e8e[%2$s]\u72b6\u6001\uff0c\u4e0d\u80fd\u4f7f\u7528", (Object)pSDevCenterAS.getPSDevCenterASName(), (Object)iCodeList.getCodeListText(Integer.toString(n), true)));
                }
                if (pSDevCenterAS.getExpriedTime() != null && pSDevCenterAS.getExpriedTime().getTime() < System.currentTimeMillis()) {
                    throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5bb9\u5668[%1$s]\u5df2\u8fc7\u6709\u6548\u671f\uff0c\u4e0d\u80fd\u4f7f\u7528", (Object)pSDevCenterAS.getPSDevCenterASName()));
                }
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(pSSystemDBCfg.getPSDevCenterDBInstId());
                pSDevCenterDBInstService.get(pSDevCenterDBInst);
                n = DataObject.getIntegerValue((Object)pSDevCenterDBInst.getResState(), (Integer)20);
                if (n != 20) {
                    ICodeList iCodeList = CodeListGlobal.getCodeList(DevCenterResStateCodeListModel.class);
                    throw new Exception(StringHelper.format((String)"\u6570\u636e\u5e93\u5b9e\u4f8b[%1$s]\u5904\u4e8e[%2$s]\u72b6\u6001\uff0c\u4e0d\u80fd\u4f7f\u7528", (Object)pSDevCenterDBInst.getPSDevCenterDBInstName(), (Object)iCodeList.getCodeListText(Integer.toString(n), true)));
                }
                if (pSDevCenterDBInst.getExpriedTime() != null && pSDevCenterDBInst.getExpriedTime().getTime() < System.currentTimeMillis()) {
                    throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5bb9\u5668[%1$s]\u5df2\u8fc7\u6709\u6548\u671f\uff0c\u4e0d\u80fd\u4f7f\u7528", (Object)pSDevCenterDBInst.getPSDevCenterDBInstName()));
                }
                if (!StringHelper.isNullOrEmpty((String)pSDevCenterDBInst.getPSDevCenterASId()) && StringHelper.compare((String)pSDevCenterAS.getPSDevCenterASId(), (String)pSDevCenterDBInst.getPSDevCenterASId(), (boolean)false) != 0) {
                    throw new Exception(StringHelper.format((String)"\u6570\u636e\u5e93\u5b9e\u4f8b[%1$s]\u5fc5\u987b\u5728\u5e94\u7528\u5bb9\u5668[%2$s]\u4e0b\u8fd0\u884c\uff0c\u5f53\u524d\u4e3a[%3$s]", (Object)pSDevCenterDBInst.getPSDevCenterDBInstName(), (Object)pSDevCenterDBInst.getPSDevCenterASName(), (Object)pSDevCenterAS.getPSDevCenterASName()));
                }
                this.executeRemoteCall("STARTEX", pSSysRunSession);
                return;
            }
            if (StringHelper.compare((String)pSSysRunSession.getRunMode(), (String)RUNMODE_PUBCODE, (boolean)true) == 0) {
                this.executeRemoteCall("STARTEX", pSSysRunSession);
                return;
            }
            if (StringHelper.compare((String)pSSysRunSession.getRunMode(), (String)RUNMODE_PACKVER, (boolean)true) == 0) {
                this.executeRemoteCall("STARTEX", pSSysRunSession);
                return;
            }
            if (StringHelper.compare((String)pSSysRunSession.getRunMode(), (String)RUNMODE_PACKMOBAPP, (boolean)true) == 0) {
                this.executeRemoteCall("STARTEX", pSSysRunSession);
                return;
            }
            if (StringHelper.compare((String)pSSysRunSession.getRunMode(), (String)"STARTMSAPI", (boolean)true) == 0) {
                this.executeRemoteCall("STARTEX", pSSysRunSession);
                return;
            }
            if (StringHelper.compare((String)pSSysRunSession.getRunMode(), (String)"STARTMSAPP", (boolean)true) == 0) {
                this.executeRemoteCall("STARTEX", pSSysRunSession);
                return;
            }
            if (StringHelper.compare((String)pSSysRunSession.getRunMode(), (String)"STARTMSFUNC", (boolean)true) == 0) {
                this.executeRemoteCall("STARTEX", pSSysRunSession);
                return;
            }
            if (StringHelper.compare((String)pSSysRunSession.getRunMode(), (String)"DEPLOYPKG", (boolean)true) == 0) {
                this.executeRemoteCall("STARTEX", pSSysRunSession);
                return;
            }
            this.executeRemoteCall("STARTEX", pSSysRunSession);
            return;
        }
    }

    @Override
    protected String getCurrentPSDevSlnSysId(IEntity iEntity, boolean bl) throws Exception {
        String string;
        String string2 = super.getCurrentPSDevSlnSysId(iEntity, true);
        if (StringHelper.isNullOrEmpty((String)string2) && !StringHelper.isNullOrEmpty((String)(string = this.getCurrentPSDynaInstId(iEntity, true)))) {
            PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
            pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId(string);
            if (pSDevSlnSysDynaInstService.get(pSDevSlnSysDynaInst, true) && pSDevSlnSysDynaInst.getPSDevSlnSysDepInst() != null) {
                string2 = pSDevSlnSysDynaInst.getPSDevSlnSysDepInst().getPSDevSlnSysId();
                iEntity.set("psdevslnsysid", (Object)string2);
            }
        }
        if (StringHelper.isNullOrEmpty((String)string2) && !bl) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u5f00\u53d1\u7cfb\u7edf\u6807\u8bc6");
        }
        return string2;
    }
}

