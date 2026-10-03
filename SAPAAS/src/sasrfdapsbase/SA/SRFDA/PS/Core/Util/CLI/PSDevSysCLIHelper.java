/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemRun
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysRunSessionService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemRunService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Util.CLI;

import SA.SRFDA.PS.Core.Util.CLI.PSStudioCLIHelperBase;
import SA.SRFDA.PS.Data.PSTaskServerCmd;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Map;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemRun;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRunSessionService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemRunService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.hibernate.SessionFactory;

public class PSDevSysCLIHelper
extends PSStudioCLIHelperBase {
    public static final String CMD_DEVSYS_CREATE = "devsys_create";
    public static final String CMD_DEVSYS_UPDATE = "devsys_update";
    public static final String CMD_DEVSYS_UPDATECODEREPO = "devsys_updatecoderepo";
    public static final String CMD_DEVSYS_UPDATEMODELREPO = "devsys_updatemodelrepo";
    public static final String CMD_DEVSYS_ONLINE = "devsys_online";
    public static final String CMD_DEVSYS_OFFLINE = "devsys_offline";
    public static final String CMD_DEVSYS_PUBCODE = "devsys_pubcode";

    @Override
    protected void registerDefault() {
        this.registerSlnCmdDataItems(CMD_DEVSYS_CREATE, new CLIDataItem[]{
            new CLIDataItem("codename", "CODENAME", true, null),
            new CLIDataItem("unitag", "PSDEVSLNSYSNAME", true, null),
            new CLIDataItem("name", "LOGICNAME", false, null),
            new CLIDataItem("memo", "MEMO", false, null),
            new CLIDataItem("sf", "PSSFID", false, null, "J2EE6"),
            new CLIDataItem(null, "TEMPLENGINE", false, null, "V2"),
            new CLIDataItem(null, "ENABLEDYNASYS", false, null, 1),
            new CLIDataItem(null, "ENABLEMYSQL5", false, null, 1)
        });
        this.registerSysCmdDataItems(CMD_DEVSYS_UPDATECODEREPO, new CLIDataItem[]{
            new CLIDataItem(null, "SVNTYPE", false, null, "GIT"),
            new CLIDataItem("repo", "GITREPO", false, null, "GITEE"),
            new CLIDataItem("url", "GITPATH", true, null),
            new CLIDataItem("memo", "MEMO", false, null)
        });
        this.registerSysCmdDataItems(CMD_DEVSYS_UPDATEMODELREPO, new CLIDataItem[]{
            new CLIDataItem(null, "SVNTYPE", false, null, "GIT"),
            new CLIDataItem("repo", "GITREPO", false, null, "GITEE"),
            new CLIDataItem("url", "GITPATH", true, null),
            new CLIDataItem("memo", "MEMO", false, null)
        });
        this.registerSysCmdDataItems(CMD_DEVSYS_PUBCODE, new CLIDataItem[]{
            new CLIDataItem("name", "PSSYSRUNSESSIONNAME", false, null),
            new CLIDataItem("sysrun", "PSSYSTEMRUNID", false, null),
            new CLIDataItem("sfpub", "PSSYSSFPUBID", false, null),
            new CLIDataItem("pfpub", "PSSYSAPPID", false, null),
            new CLIDataItem("dbpub", "PSSYSTEMDBCFGID", false, null),
            new CLIDataItem("memo", "MEMO", false, null)
        });
        this.registerSlnCmdDataItems(CMD_DEVSYS_OFFLINE, new PSStudioCLIHelperBase.CLIDataItem[0]);
        this.registerSlnCmdDataItems(CMD_DEVSYS_ONLINE, new CLIDataItem[]{
            new CLIDataItem("workspace", "PSDCWORKSPACEID", false, null)
        });
        super.registerDefault();
    }

    @Override
    protected void onExecute(String strCmd, Map<String, Object> paramMap, ObjectNode objectNode, PSTaskServerCmd psTaskServerCmd) throws Exception {
        if (CMD_DEVSYS_CREATE.equals(strCmd)) {
            PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                psDevSlnSys.set(entry.getKey(), entry.getValue());
            }
            psDevSlnSys.setPSDevCenterId(psTaskServerCmd.getPSDEVCENTERID());
            psDevSlnSys.setPSDevCenterName(psTaskServerCmd.getPSDEVCENTERNAME());
            psDevSlnSys.setPSDevSlnId(psTaskServerCmd.getPSDEVSLNID());
            psDevSlnSys.setPSDevSlnName(psTaskServerCmd.getPSDEVSLNNAME());
            PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            try {
                psDevSlnSysService.create(psDevSlnSys);
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u5efa\u7acb\u5f00\u53d1\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
            }
            return;
        }
        if (CMD_DEVSYS_UPDATECODEREPO.equals(strCmd) || CMD_DEVSYS_UPDATEMODELREPO.equals(strCmd)) {
            boolean bNew;
            int nResPos;
            PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
            psDevSlnSys.setPSDevSlnSysId(psTaskServerCmd.getPSDEVSLNSYSID());
            PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevCenterSVNService psDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            try {
                psDevSlnSysService.get(psDevSlnSys);
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u83b7\u53d6\u5f00\u53d1\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
            }
            PSDevCenterSVN psDevCenterSVN = null;
            if (CMD_DEVSYS_UPDATECODEREPO.equals(strCmd)) {
                psDevCenterSVN = psDevSlnSys.getPSDevCenterSVN();
            } else if (CMD_DEVSYS_UPDATEMODELREPO.equals(strCmd)) {
                psDevCenterSVN = psDevSlnSys.getModelPSDevCenterSVN();
            }
            if (psDevCenterSVN != null && (nResPos = DataObject.getIntegerValue((Object)psDevCenterSVN.getResPos(), (Integer)1).intValue()) != 2) {
                psDevCenterSVN = null;
            }
            boolean bl = bNew = psDevCenterSVN == null;
            if (psDevCenterSVN == null) {
                psDevCenterSVN = new PSDevCenterSVN();
                psDevCenterSVN.setPSDevCenterId(psTaskServerCmd.getPSDEVCENTERID());
                if (CMD_DEVSYS_UPDATECODEREPO.equals(strCmd)) {
                    psDevCenterSVN.setPSDevCenterSVNName(String.format("\u5f00\u53d1\u7cfb\u7edf[%1$s]\u4ee3\u7801\u4ed3\u5e93", psDevSlnSys.getPSDevSlnSysName()));
                } else if (CMD_DEVSYS_UPDATEMODELREPO.equals(strCmd)) {
                    psDevCenterSVN.setPSDevCenterSVNName(String.format("\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6a21\u578b\u4ed3\u5e93", psDevSlnSys.getPSDevSlnSysName()));
                }
                psDevCenterSVN.setResPos(Integer.valueOf(2));
                psDevCenterSVN.setRefFlag(Integer.valueOf(1));
                psDevCenterSVN.setResState(Integer.valueOf(20));
            }
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                psDevCenterSVN.set(entry.getKey(), entry.getValue());
            }
            try {
                if (bNew) {
                    psDevCenterSVNService.create(psDevCenterSVN);
                } else {
                    psDevCenterSVNService.update(psDevCenterSVN);
                }
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u66f4\u65b0\u5e94\u7528\u4e2d\u5fc3\u4ee3\u7801\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
            }
            try {
                if (bNew) {
                    PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
                    psDevSlnSys2.setPSDevSlnSysId(psTaskServerCmd.getPSDEVSLNSYSID());
                    if (CMD_DEVSYS_UPDATECODEREPO.equals(strCmd)) {
                        psDevSlnSys2.setPSDevCenterSVNId(psDevCenterSVN.getPSDevCenterSVNId());
                    } else if (CMD_DEVSYS_UPDATEMODELREPO.equals(strCmd)) {
                        psDevSlnSys2.setModelPSDevCenterSVNId(psDevCenterSVN.getPSDevCenterSVNId());
                    }
                    psDevSlnSysService.sysUpdate(psDevSlnSys2, false);
                }
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u66f4\u65b0\u5f00\u53d1\u7cfb\u7edf\u4ed3\u5e93\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
            }
            return;
        }
        if (CMD_DEVSYS_ONLINE.equals(strCmd)) {
            try {
                this.onOnline(paramMap, objectNode, psTaskServerCmd);
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u8fde\u7ebf\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
            }
            return;
        }
        if (CMD_DEVSYS_OFFLINE.equals(strCmd)) {
            try {
                this.onOffline(paramMap, objectNode, psTaskServerCmd);
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u79bb\u7ebf\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
            }
            return;
        }
        if (CMD_DEVSYS_PUBCODE.equals(strCmd)) {
            try {
                this.onPubCode(paramMap, objectNode, psTaskServerCmd);
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u53d1\u5e03\u7cfb\u7edf\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
            }
            return;
        }
        super.onExecute(strCmd, paramMap, objectNode, psTaskServerCmd);
    }

    protected void onOnline(Map<String, Object> paramMap, ObjectNode objectNode, PSTaskServerCmd psTaskServerCmd) throws Exception {
        PSDCWorkspace psDCWorkspace;
        PSDCWorkspaceService psDCWorkspaceService;
        PSDevSlnSys psDevSlnSys;
        block12: {
            psDevSlnSys = new PSDevSlnSys();
            psDevSlnSys.setPSDevSlnSysId(psTaskServerCmd.getPSDEVSLNSYSID());
            PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            try {
                psDevSlnSysService.get(psDevSlnSys);
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u83b7\u53d6\u5f00\u53d1\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
            }
            if (DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)DevSysStateCodeListModel.ONLINE) != DevSysStateCodeListModel.OFFLINE) {
                throw new Exception(String.format("\u5f00\u53d1\u7cfb\u7edf\u672a\u5904\u4e8e\u79bb\u7ebf\u72b6\u6001", new Object[0]));
            }
            String strPSDCWorkspaceName = (String)paramMap.get("PSDCWORKSPACEID");
            psDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            psDCWorkspace = null;
            if (!StringHelper.isNullOrEmpty((String)strPSDCWorkspaceName)) {
                psDCWorkspace = new PSDCWorkspace();
                try {
                    psDCWorkspace.setPSDevCenterId(psDevSlnSys.getPSDevCenterId());
                    psDCWorkspace.setPSDCWorkspaceId(strPSDCWorkspaceName);
                    if (!psDCWorkspaceService.select(psDCWorkspace, true)) {
                        psDCWorkspace.reset();
                        psDCWorkspace.setPSDevCenterId(psDevSlnSys.getPSDevCenterId());
                        psDCWorkspace.setPSDCWorkspaceName(strPSDCWorkspaceName);
                        if (!psDCWorkspaceService.select(psDCWorkspace, true)) {
                            throw new Exception("\u6570\u636e\u4e0d\u5b58\u5728");
                        }
                    }
                    if (!psDevSlnSys.getPSDevSlnId().equals(psDCWorkspace.getPSDevSlnId())) {
                        throw new Exception(String.format("\u751f\u4ea7\u7ebf\u672a\u5206\u914d\u81f3\u5f00\u53d1\u65b9\u6848", new Object[0]));
                    }
                    break block12;
                }
                catch (Exception ex) {
                    throw new Exception(String.format("\u83b7\u53d6\u751f\u4ea7\u7ebf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", strPSDCWorkspaceName, ex.getMessage()));
                }
            }
            SelectCond selectCond = new SelectCond();
            selectCond.set("PSDEVCENTERID", (Object)psDevSlnSys.getPSDevCenterId());
            selectCond.set("PSDEVSLNID", (Object)psDevSlnSys.getPSDevSlnId());
            ArrayList<PSDCWorkspace> psDCWorkspaceList = psDCWorkspaceService.select((ISelectCond)selectCond);
            if (psDCWorkspaceList != null) {
                for (PSDCWorkspace item : psDCWorkspaceList) {
                    if (!StringHelper.isNullOrEmpty((String)item.getPSDevSlnSysId()) || DataObject.getIntegerValue((Object)item.getResState(), (Integer)20) != 20) continue;
                    psDCWorkspace = item;
                    break;
                }
            }
            if (psDCWorkspace == null) {
                throw new Exception(String.format("\u65e0\u53ef\u7528\u751f\u4ea7\u7ebf", new Object[0]));
            }
        }
        PSDCWorkspace psDCWorkspace2 = new PSDCWorkspace();
        psDCWorkspace2.setPSDCWorkspaceId(psDCWorkspace.getPSDCWorkspaceId());
        psDCWorkspace2.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDCWorkspace2.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
        psDCWorkspaceService.installSys(psDCWorkspace2);
    }

    protected void onOffline(Map<String, Object> paramMap, ObjectNode objectNode, PSTaskServerCmd psTaskServerCmd) throws Exception {
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        psDevSlnSys.setPSDevSlnSysId(psTaskServerCmd.getPSDEVSLNSYSID());
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        try {
            psDevSlnSysService.get(psDevSlnSys);
        }
        catch (Exception ex) {
            throw new Exception(String.format("\u83b7\u53d6\u5f00\u53d1\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
        }
        if (DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)DevSysStateCodeListModel.ONLINE) != DevSysStateCodeListModel.ONLINE) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf\u672a\u5904\u4e8e\u8fde\u7ebf\u72b6\u6001"));
        }
        if (StringHelper.isNullOrEmpty((String)psDevSlnSys.getPSDCWorkspaceId())) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf\u672a\u7ed1\u5b9a\u751f\u4ea7\u7ebf"));
        }
        PSDCWorkspaceService psDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCWorkspace psDCWorkspace = new PSDCWorkspace();
        psDCWorkspace.setPSDCWorkspaceId(psDevSlnSys.getPSDCWorkspaceId());
        psDCWorkspace.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDCWorkspace.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
        psDCWorkspaceService.uninstallSys(psDCWorkspace);
    }

    protected void onPubCode(Map<String, Object> paramMap, ObjectNode objectNode, PSTaskServerCmd psTaskServerCmd) throws Exception {
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        psDevSlnSys.setPSDevSlnSysId(psTaskServerCmd.getPSDEVSLNSYSID());
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        try {
            psDevSlnSysService.get(psDevSlnSys);
        }
        catch (Exception ex) {
            throw new Exception(String.format("\u83b7\u53d6\u5f00\u53d1\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
        }
        if (DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)DevSysStateCodeListModel.ONLINE) != DevSysStateCodeListModel.ONLINE) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf\u672a\u5904\u4e8e\u8fde\u7ebf\u72b6\u6001"));
        }
        PSSysRunSessionService psSysRunSessionService = (PSSysRunSessionService)ServiceGlobal.getService(PSSysRunSessionService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)psDevSlnSys.getPSSysModelInstId()));
        PSSysRunSession psSysRunSession = new PSSysRunSession();
        String strPSSystemRunName = (String)paramMap.get("PSSYSTEMRUNID");
        if (!StringHelper.isNullOrEmpty((String)strPSSystemRunName)) {
            PSSystemRunService psSystemRunService = (PSSystemRunService)ServiceGlobal.getService(PSSystemRunService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)psDevSlnSys.getPSSysModelInstId()));
            PSSystemRun psSystemRun = new PSSystemRun();
            try {
                psSystemRun.setPSSystemRunName(strPSSystemRunName);
                if (!psSystemRunService.select(psSystemRun, true)) {
                    throw new Exception("\u6570\u636e\u4e0d\u5b58\u5728");
                }
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u83b7\u53d6\u7cfb\u7edf\u8fd0\u884c[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", strPSSystemRunName, ex.getMessage()));
            }
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                psSysRunSession.set(entry.getKey(), entry.getValue());
            }
            psSysRunSession.setPSSystemId(psDevSlnSys.getPSSystemId());
            psSysRunSession.setRunMode("PUBCODE");
            psSysRunSession.setPSSysSFPubId(psSystemRun.getPSSysSFPubId());
            psSysRunSession.setPSSysSFPubName(psSystemRun.getPSSysSFPubName());
            psSysRunSession.setPSSysAppId(psSystemRun.getPSSysAppId());
            psSysRunSession.setPSSysAppName(psSystemRun.getPSSysAppName());
            psSysRunSession.setPSSystemDBCfgId(psSystemRun.getPSSystemDBCfgId());
            psSysRunSession.setPSSystemDBCfgName(psSystemRun.getPSSystemDBCfgName());
            psSysRunSession.set("PSDEVSLNSYSID", (Object)psDevSlnSys.getPSDevSlnSysId());
            psSysRunSessionService.create(psSysRunSession);
        } else {
            PSSystemDBCfg psSystemDBCfg;
            PSSysApp psSysApp;
            PSSysSFPub psSysSFPub;
            block37: {
                block36: {
                    block35: {
                        PSSysSFPubService psSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)psDevSlnSys.getPSSysModelInstId()));
                        String strPSSysSFPubName = (String)paramMap.get("PSSYSSFPUBID");
                        psSysSFPub = null;
                        if (!StringHelper.isNullOrEmpty((String)strPSSysSFPubName)) {
                            psSysSFPub = new PSSysSFPub();
                            try {
                                psSysSFPub.setCodeName(strPSSysSFPubName);
                                if (!psSysSFPubService.select(psSysSFPub, true)) {
                                    psSysSFPub.reset();
                                    psSysSFPub.setPSSysSFPubName(strPSSysSFPubName);
                                    if (!psSysSFPubService.select(psSysSFPub, true)) {
                                        throw new Exception("\u6570\u636e\u4e0d\u5b58\u5728");
                                    }
                                }
                                break block35;
                            }
                            catch (Exception ex) {
                                throw new Exception(String.format("\u83b7\u53d6\u540e\u53f0\u53d1\u5e03[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", strPSSysSFPubName, ex.getMessage()));
                            }
                        }
                        psSysSFPub = new PSSysSFPub();
                        try {
                            psSysSFPub.setDefaultPub(Integer.valueOf(1));
                            if (!psSysSFPubService.select(psSysSFPub, true)) {
                                throw new Exception("\u6570\u636e\u4e0d\u5b58\u5728");
                            }
                        }
                        catch (Exception ex) {
                            throw new Exception(String.format("\u83b7\u53d6\u9ed8\u8ba4\u540e\u53f0\u53d1\u5e03\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
                        }
                    }
                    PSSysAppService psSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)psDevSlnSys.getPSSysModelInstId()));
                    String strPSSysAppName = (String)paramMap.get("PSSYSAPPID");
                    psSysApp = null;
                    if (!StringHelper.isNullOrEmpty((String)strPSSysAppName)) {
                        psSysApp = new PSSysApp();
                        try {
                            psSysApp.setAppPKGName(strPSSysAppName);
                            if (!psSysAppService.select(psSysApp, true)) {
                                psSysApp.reset();
                                psSysApp.setPSSysAppName(strPSSysAppName);
                                if (!psSysAppService.select(psSysApp, true)) {
                                    throw new Exception("\u6570\u636e\u4e0d\u5b58\u5728");
                                }
                            }
                            break block36;
                        }
                        catch (Exception ex) {
                            throw new Exception(String.format("\u83b7\u53d6\u524d\u7aef\u53d1\u5e03[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", strPSSysAppName, ex.getMessage()));
                        }
                    }
                    psSysApp = new PSSysApp();
                    try {
                        psSysApp.setDefaultPub(Integer.valueOf(1));
                        if (!psSysAppService.select(psSysApp, true)) {
                            psSysApp = null;
                        }
                    }
                    catch (Exception ex) {
                        throw new Exception(String.format("\u83b7\u53d6\u9ed8\u8ba4\u540e\u53f0\u53d1\u5e03\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
                    }
                }
                PSSystemDBCfgService psSystemDBCfgService = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)psDevSlnSys.getPSSysModelInstId()));
                String strPSSystemDBCfgName = (String)paramMap.get("PSSYSTEMDBCFGID");
                psSystemDBCfg = null;
                if (!StringHelper.isNullOrEmpty((String)strPSSystemDBCfgName)) {
                    psSystemDBCfg = new PSSystemDBCfg();
                    try {
                        psSystemDBCfg.setPSSystemDBCfgName(strPSSystemDBCfgName);
                        if (!psSystemDBCfgService.select(psSystemDBCfg, true)) {
                            throw new Exception("\u6570\u636e\u4e0d\u5b58\u5728");
                        }
                        break block37;
                    }
                    catch (Exception ex) {
                        throw new Exception(String.format("\u83b7\u53d6\u6570\u636e\u5e93\u53d1\u5e03[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", strPSSystemDBCfgName, ex.getMessage()));
                    }
                }
                psSystemDBCfg = new PSSystemDBCfg();
                try {
                    psSystemDBCfg.setDefaultFlag(Integer.valueOf(1));
                    if (!psSystemDBCfgService.select(psSystemDBCfg, true)) {
                        psSystemDBCfg = null;
                    }
                }
                catch (Exception ex) {
                    throw new Exception(String.format("\u83b7\u53d6\u9ed8\u8ba4\u6570\u636e\u5e93\u53d1\u5e03\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
                }
            }
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                psSysRunSession.set(entry.getKey(), entry.getValue());
            }
            psSysRunSession.setPSSystemId(psDevSlnSys.getPSSystemId());
            psSysRunSession.setRunMode("PUBCODE");
            psSysRunSession.setPSSysSFPubId(psSysSFPub.getPSSysSFPubId());
            psSysRunSession.setPSSysSFPubName(psSysSFPub.getPSSysSFPubName());
            if (psSysApp != null) {
                psSysRunSession.setPSSysAppId(psSysApp.getPSSysAppId());
                psSysRunSession.setPSSysAppName(psSysApp.getPSSysAppName());
            }
            if (psSystemDBCfg != null) {
                psSysRunSession.setPSSystemDBCfgId(psSystemDBCfg.getPSSystemDBCfgId());
                psSysRunSession.setPSSystemDBCfgName(psSystemDBCfg.getPSSystemDBCfgName());
            }
            psSysRunSession.set("PSDEVSLNSYSID", (Object)psDevSlnSys.getPSDevSlnSysId());
            psSysRunSessionService.create(psSysRunSession);
        }
    }
}
