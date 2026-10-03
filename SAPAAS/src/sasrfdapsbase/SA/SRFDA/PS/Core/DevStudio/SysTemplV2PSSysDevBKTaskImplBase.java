/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformNode
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItem
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItemBase
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeService
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService
 *  net.ibizsys.pscore.srv.util.PSStudioConsoleHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.Deploy.IPSDeployCenter;
import SA.SRFDA.PS.Core.Deploy.IPSRegistryRepo;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.DevStudio.StartupExPSSysDevBKTaskImpl;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSDevSlnSysDynaInst;
import SA.SRFDA.PS.Core.IPSDevSlnSysRuntime;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Util.FileWriterHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformNode;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItem;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItemBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService;
import net.ibizsys.pscore.srv.util.PSStudioConsoleHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class SysTemplV2PSSysDevBKTaskImplBase
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(SysTemplV2PSSysDevBKTaskImplBase.class);

    @Override
    protected String onRun() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getPSDynaInstId())) {
            return null;
        }
        return this.executeCmd();
    }

    protected String executeCmd() throws Exception {
        IPSDevSlnSys iPSDevSlnSys = null;
        IPSDevSlnSysDynaInst iPSDevSlnSysDynaInst = null;
        if (!StringHelper.isNullOrEmpty((String)this.psSysDevBKTask.getPSDYNAINSTID())) {
            iPSDevSlnSysDynaInst = this.getPSModelStorage().getPSDevSlnSysDynaInst(this.psSysDevBKTask.getPSDYNAINSTID());
            iPSDevSlnSys = iPSDevSlnSysDynaInst.getPSDevSlnSys();
        } else {
            iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID());
        }
        IPSSystem iPSSystem = iPSDevSlnSys.getPSSystem(true);
        String strCodeFolder = this.getCommand(iPSDevSlnSys, iPSDevSlnSysDynaInst);
        String strEncode = "";
        if (StringHelper.compare((String)PSTaskServerEnvImpl.getCurrent().getOSType(), (String)"LINUX", (boolean)true) == 0) {
            strCodeFolder = "python " + strCodeFolder;
            strEncode = "UTF-8";
        } else {
            strCodeFolder = "cmd /c python " + strCodeFolder;
            strEncode = "GBK";
        }
        long nBeginTime = System.currentTimeMillis();
        String strResult = this.runBat(strCodeFolder, true, strEncode, false);
        if (!StringHelper.isNullOrEmpty((String)strResult)) {
            if ((strResult = strResult.trim()).indexOf("SUCCESS\r\n") == 0) {
                strResult = strResult.substring(9);
                if (PSStudioConsoleHelper.getCurrent() != null) {
                    PSStudioConsoleHelper.getCurrent().sendConsole(this.getPSDSConsoleId(), PSStudioConsoleHelper.getContent((String)strResult, (int)32));
                }
            } else if (strResult.indexOf("FAILURE\r\n") == 0) {
                StartupExPSSysDevBKTaskImpl startupExPSSysDevBKTaskImpl;
                PSDCRegistryItem psDCRegistryItem;
                strResult = strResult.substring(9);
                if (PSStudioConsoleHelper.getCurrent() != null) {
                    PSStudioConsoleHelper.getCurrent().sendConsole(this.getPSDSConsoleId(), PSStudioConsoleHelper.getContent((String)strResult, (int)31));
                }
                if (this.getParentPSBKTask() instanceof StartupExPSSysDevBKTaskImpl && (psDCRegistryItem = (startupExPSSysDevBKTaskImpl = (StartupExPSSysDevBKTaskImpl)this.getParentPSBKTask()).getPSDCRegistryItem()) != null) {
                    PSDCMSPlatformNodeService psDCMSPlatformNodeService = (PSDCMSPlatformNodeService)ServiceGlobal.getService(PSDCMSPlatformNodeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                    try {
                        ArrayList<PSDCMSPlatformNode> psDCMSPlatformNodeList = psDCMSPlatformNodeService.selectByPSDCRegistryItem((PSDCRegistryItemBase)psDCRegistryItem);
                        if (psDCMSPlatformNodeList != null && psDCMSPlatformNodeList.size() > 0) {
                            for (PSDCMSPlatformNode psDCMSPlatformNode : psDCMSPlatformNodeList) {
                                PSDCMSPlatformNode node = new PSDCMSPlatformNode();
                                node.setPSDCMSPlatformNodeId(psDCMSPlatformNode.getPSDCMSPlatformNodeId());
                                node.setPSDCRegistryItemId(startupExPSSysDevBKTaskImpl.getBackupPSDCRegistryItemId());
                                psDCMSPlatformNodeService.sysUpdate(node, false);
                            }
                        }
                    }
                    catch (Exception ex) {
                        log.error((Object)String.format("\u91cd\u7f6e\u955c\u50cf[%1$s]\u5f15\u7528\u53d1\u751f\u5f02\u5e38\uff0c%2$s", psDCRegistryItem.getPSDCRegistryItemName(), ex.getMessage()), (Throwable)ex);
                    }
                    PSDCRegistryItemService psDCRegistryItemService = (PSDCRegistryItemService)ServiceGlobal.getService(PSDCRegistryItemService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                    try {
                        psDCRegistryItemService.remove(psDCRegistryItem);
                    }
                    catch (Exception ex) {
                        log.error((Object)String.format("\u79fb\u9664\u955c\u50cf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", psDCRegistryItem.getPSDCRegistryItemName(), ex.getMessage()), (Throwable)ex);
                        if (PSStudioConsoleHelper.getCurrent() != null) {
                            PSStudioConsoleHelper.getCurrent().sendConsole(this.getPSDSConsoleId(), PSStudioConsoleHelper.getContent((String)String.format("\u79fb\u9664\u955c\u50cf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", psDCRegistryItem.getPSDCRegistryItemName(), ex.getMessage()), (int)31));
                        }
                    }
                }
            } else if (PSStudioConsoleHelper.getCurrent() != null) {
                PSStudioConsoleHelper.getCurrent().sendConsole(this.getPSDSConsoleId(), PSStudioConsoleHelper.getContent((String)strResult, (int)37));
            }
        }
        return strResult;
    }

    protected abstract String getCommand(IPSDevSlnSys var1, IPSDevSlnSysDynaInst var2) throws Exception;

    protected String getCommandFile(IPSDevSlnSys iPSDevSlnSys, IPSDevSlnSysDynaInst iPSDevSlnSysDynaInst) throws Exception {
        IPSDeployCenter iPSDeployCenter;
        if (this.getParentPSSysDevBKTask() == null) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u7236\u4efb\u52a1\u5bf9\u8c61");
        }
        String strCommandFile = StringHelper.format((String)"%1$spy%2$s.py", (Object)PSTaskServerEnvImpl.getCurrent().getTaskServerTempFolder(), (Object)this.getParentPSSysDevBKTask().getId());
        File file = new File(strCommandFile);
        if (file.exists()) {
            return strCommandFile;
        }
        IPSSystem iPSSystem = iPSDevSlnSys.getPSSystem(true);
        String strCodeFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "CODEFOLDER", null);
        String strTemplFile = String.format("%1$s%2$spyutils%2$sgithelp.py.ftl", PSTaskServerEnvImpl.getCurrent().getToolFolder(), File.separator);
        file = new File(strTemplFile);
        if (!file.exists()) {
            throw new Exception("\u53d1\u5e03\u4ee3\u7801\u547d\u4ee4\u6a21\u677f\u4e0d\u5b58\u5728");
        }
        String strContent = FileWriterHelper.readFile(strTemplFile);
        HashMap<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("sys", iPSSystem);
        paramsMap.put("sysrun", this.getPSSysRunSession());
        if (this.getPSSysRunSession().getPSSysSFPub() != null) {
            paramsMap.put("pub", this.getPSSysRunSession().getPSSysSFPub());
        }
        paramsMap.put("toolfolder", PSTaskServerEnvImpl.getCurrent().getToolFolder());
        paramsMap.put("codefolder", strCodeFolder);
        if (this.getPSSysRunSession().isDebugMode()) {
            paramsMap.put("debugmode", "1");
        } else {
            paramsMap.put("debugmode", "0");
        }
        if (PSTaskServerEnvImpl.getCurrent() != null && !StringHelper.isNullOrEmpty((String)PSTaskServerEnvImpl.getCurrent().getConsoleServerUrl())) {
            paramsMap.put("dsconsoleserverurl", PSTaskServerEnvImpl.getCurrent().getConsoleServerUrl());
            String strPSDSConsoleId = "";
            if (this.getPSSysRunSession().isDebugMode()) {
                strPSDSConsoleId = this.getPSSysRunSession().getPSDSConsoleId();
                if (StringHelper.isNullOrEmpty((String)strPSDSConsoleId)) {
                    strPSDSConsoleId = this.getPSDevSlnSysId();
                }
            } else {
                strPSDSConsoleId = this.getPSDevSlnSysId();
            }
            paramsMap.put("dsconsoleid", strPSDSConsoleId);
        }
        IPSDevSlnSysRuntime iPSDevSlnSysRuntime = null;
        if (iPSDevSlnSys instanceof IPSDevSlnSysRuntime && (iPSDeployCenter = (iPSDevSlnSysRuntime = (IPSDevSlnSysRuntime)((Object)iPSDevSlnSys)).getPSDeployCenter()) != null) {
            IPSRegistryRepo iPSRegistryRepo;
            if (!StringHelper.isNullOrEmpty((String)iPSDeployCenter.getCIType())) {
                paramsMap.put("dep_citype", iPSDeployCenter.getCIType());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSDeployCenter.getCDType())) {
                paramsMap.put("dep_cdtype", iPSDeployCenter.getCDType());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSDeployCenter.getAPIUrl())) {
                paramsMap.put("dep_cdapiurl", iPSDeployCenter.getAPIUrl());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSDeployCenter.getAPIToken())) {
                paramsMap.put("dep_cdapiurl", iPSDeployCenter.getAPIToken());
            }
            if ((iPSRegistryRepo = iPSDeployCenter.getPSRegistryRepo()) != null) {
                if (StringHelper.isNullOrEmpty((String)iPSRegistryRepo.getConnStr())) {
                    paramsMap.put("dep_regurl", iPSRegistryRepo.getConnStr());
                }
                if (StringHelper.isNullOrEmpty((String)iPSRegistryRepo.getAdminUserName())) {
                    paramsMap.put("dep_reguser", iPSRegistryRepo.getAdminUserName());
                }
                if (StringHelper.isNullOrEmpty((String)iPSRegistryRepo.getAdminPassword())) {
                    paramsMap.put("dep_regpwd", iPSRegistryRepo.getAdminPassword());
                }
            }
        }
        this.onFillTemplateParams(paramsMap);
        String strCode = PSTemplHelper.generateCode(strContent, paramsMap);
        FileWriterHelper.write(strCommandFile, strCode);
        return strCommandFile;
    }

    protected void onFillTemplateParams(Map<String, Object> paramsMap) throws Exception {
    }
}
