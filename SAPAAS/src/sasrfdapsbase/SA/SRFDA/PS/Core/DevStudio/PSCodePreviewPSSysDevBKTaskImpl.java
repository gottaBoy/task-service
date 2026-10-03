/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSCodePreviewAction
 *  net.ibizsys.pscore.srv.sysdesign.service.PSCodePreviewActionService
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.CodeSnippet.DefaultPSCodeSnippetPublisherImpl2;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Core.SF.IPSSFCodeFolder;
import SA.SRFDA.PS.Core.Util.FileWriterHelper;
import SA.SRFDA.PS.Data.PSAppViewCode;
import SA.SRFDA.PS.Data.PSDCCodeSnippet;
import SA.SRFDA.PS.Data.PSModelSFCode;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodePreviewAction;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodePreviewActionService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSCodePreviewPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(PSCodePreviewPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        PSCodePreviewActionService psCodePreviewActionService = (PSCodePreviewActionService)ServiceGlobal.getService(PSCodePreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSCodePreviewAction psCodePreviewAction = new PSCodePreviewAction();
        PSCodePreviewAction psCodePreviewAction2 = new PSCodePreviewAction();
        psCodePreviewAction.setPSCodePreviewActionId(this.getTaskParam());
        psCodePreviewActionService.get(psCodePreviewAction);
        String strPSDevSlnSysId = psCodePreviewAction.getPSDevSlnSysId();
        String strPSDSConsoleId = psCodePreviewAction.getPSDSConsoleId();
        if (StringHelper.IsNullOrEmpty((String)strPSDSConsoleId)) {
            strPSDSConsoleId = strPSDevSlnSysId;
        }
        psCodePreviewAction2.reset();
        psCodePreviewAction2.setPSCodePreviewActionId(this.getTaskParam());
        psCodePreviewAction2.setActionState(Integer.valueOf(20));
        psCodePreviewAction2.setPreviewStep("\u6b63\u5728\u751f\u6210\u6267\u884c\u7ed3\u679c\u6587\u4ef6");
        psCodePreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
        psCodePreviewActionService.update(psCodePreviewAction2, false);
        IPSSystem iPSSystem = null;
        if (!this.isCancel()) {
            try {
                iPSSystem = this.getPSSystem(strPSDevSlnSysId, null);
                Iterator<IPSApplication> psApplications = iPSSystem.getAllPSApps();
                ArrayList<String> psSysAppIdList = new ArrayList<String>();
                if (psApplications != null) {
                    while (psApplications.hasNext()) {
                        psSysAppIdList.add(psApplications.next().getId());
                    }
                }
                for (String strPSSysAppId : psSysAppIdList) {
                    this.getPSApplication(iPSSystem, strPSSysAppId);
                }
            }
            catch (Exception ex) {
                psCodePreviewActionService = (PSCodePreviewActionService)ServiceGlobal.getService(PSCodePreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                psCodePreviewAction2.reset();
                psCodePreviewAction2.setPSCodePreviewActionId(this.getTaskParam());
                psCodePreviewAction2.setActionState(Integer.valueOf(40));
                psCodePreviewAction2.setActionResult(StringHelper.Format((String)"\u52a0\u8f7d\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                psCodePreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
                psCodePreviewActionService.update(psCodePreviewAction2, false);
                throw ex;
            }
        } else {
            psCodePreviewActionService = (PSCodePreviewActionService)ServiceGlobal.getService(PSCodePreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            psCodePreviewAction2.reset();
            psCodePreviewAction2.setPSCodePreviewActionId(this.getTaskParam());
            psCodePreviewAction2.setActionState(Integer.valueOf(40));
            psCodePreviewAction2.setActionResult("\u4f5c\u4e1a\u88ab\u53d6\u6d88");
            psCodePreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
            psCodePreviewActionService.update(psCodePreviewAction2, false);
            return null;
        }
        String strServerRoot = PSTaskServerEnvImpl.getCurrent().getTempFileServerUrl();
        String strServerHost = PSTaskServerEnvImpl.getCurrent().getTempFileServerAddr();
        int nServerPort = PSTaskServerEnvImpl.getCurrent().getTempFileServerPort();
        String strPubFolder = null;
        String strIndexFile = "";
        if (!this.isCancel()) {
            ArrayList<PSModelSFCode> psModelSFCodeList = new ArrayList<PSModelSFCode>();
            try {
                String strActionType = psCodePreviewAction.getActionParam4();
                if (!StringHelper.IsNullOrEmpty((String)strActionType)) {
                    Iterator<PSAppViewCode> psAppViewCodes;
                    PSModelSFCode psModelSFCode2;
                    Iterator<PSSysSFCode> psSysSFCodes;
                    IPSSystemUtil iPSSystemUtil = (IPSSystemUtil)((Object)iPSSystem);
                    if (StringHelper.Compare((String)strActionType, (String)"ALL", (boolean)true) == 0 && (psSysSFCodes = iPSSystemUtil.getPSModelSFCodes(psCodePreviewAction.getPSObjType(), psCodePreviewAction.getPSObjId())) != null) {
                        while (psSysSFCodes.hasNext()) {
                            IPSSFCodeFolder iPSSFCodeFolder;
                            PSSysSFCode psSysSFCode = psSysSFCodes.next();
                            psModelSFCode2 = new PSModelSFCode();
                            IPSSysSFPub iPSSysSFPub = null;
                            if (StringHelper.IsNullOrEmpty((String)psSysSFCode.getPSSYSSFPUBID())) continue;
                            iPSSysSFPub = iPSSystem.getPSSysSFPub(psSysSFCode.getPSSYSSFPUBID());
                            if (iPSSysSFPub != null && !StringHelper.IsNullOrEmpty((String)psSysSFCode.getPSSFCODEFOLDERID()) && (iPSSFCodeFolder = iPSSysSFPub.getPSSFStyle().getPSSFCodeFolder(psSysSFCode.getPSSFCODEFOLDERID())).getPSSFStylePrj() != null) {
                                psModelSFCode2.setPRJNAME(iPSSFCodeFolder.getPSSFStylePrj().getPrjType());
                                psModelSFCode2.setPRJFOLDER(iPSSFCodeFolder.getPrjFolder());
                            }
                            psModelSFCode2.setPSMODELSFCODENAME(psSysSFCode.getPSSYSSFCODENAME());
                            psModelSFCode2.setCODEPATH(String.valueOf(psModelSFCode2.getPRJFOLDER()) + psSysSFCode.getCODEPATH());
                            psModelSFCode2.setPSSYSSFPUBID(psSysSFCode.getPSSYSSFPUBID());
                            psModelSFCode2.setPSSYSSFPUBNAME(psSysSFCode.getPSSYSSFPUBNAME());
                            psModelSFCode2.setPSMODELSFCODEID(KeyValueHelper.genUniqueId((String)psModelSFCode2.getPSSYSSFPUBID(), (String)psModelSFCode2.getPRJNAME(), (String)psModelSFCode2.getPSMODELSFCODENAME(), (String)psModelSFCode2.getCODEPATH()));
                            psModelSFCode2.setUSERCODE(psSysSFCode.getPUBCODE());
                            psModelSFCode2.set("CODETEMPL", psSysSFCode.get("CODETEMPL"));
                            psModelSFCode2.setCODEPKGNAME(StringHelper.TrimLeft((String)psSysSFCode.getCODEPATH(), (char)'/').replace("/", "."));
                            psModelSFCode2.setPSSFCODETYPEID(psSysSFCode.getPSSFCODETYPEID());
                            psModelSFCode2.setPSSFCODETYPENAME(psSysSFCode.getPSSFCODETYPENAME());
                            psModelSFCodeList.add(psModelSFCode2);
                        }
                    }
                    if (StringHelper.Compare((String)strActionType, (String)"ALL", (boolean)true) == 0 && (psAppViewCodes = iPSSystemUtil.getPSModelPFCodes(psCodePreviewAction.getPSObjType(), psCodePreviewAction.getPSObjId())) != null) {
                        while (psAppViewCodes.hasNext()) {
                            PSAppViewCode psAppViewCode = psAppViewCodes.next();
                            psModelSFCode2 = new PSModelSFCode();
                            IPSApplication iPSApplication = iPSSystem.getPSApplication(psAppViewCode.getPSSYSAPPID());
                            psAppViewCode.setCODEPATH("app_" + iPSApplication.getWorkshopName() + psAppViewCode.getCODEPATH());
                            psModelSFCode2.setPSMODELSFCODENAME(psAppViewCode.getPSAPPVIEWCODENAME());
                            psModelSFCode2.setCODEPKGNAME(StringHelper.TrimLeft((String)psAppViewCode.getCODEPATH(), (char)'/').replace("/", "."));
                            psModelSFCode2.setCODEPATH(String.valueOf(StringHelper.Format((String)psModelSFCode2.getPRJFOLDER(), (Object)iPSApplication.getWorkshopName().toLowerCase())) + psAppViewCode.getCODEPATH().replace("/" + psAppViewCode.getPSAPPVIEWCODENAME(), ""));
                            psModelSFCode2.setUSERCODE(psAppViewCode.getPUBCODE());
                            psModelSFCode2.set("CODETEMPL", psAppViewCode.get("TEMPLCODE"));
                            psModelSFCodeList.add(psModelSFCode2);
                        }
                    }
                } else {
                    ArrayList<IPSObject> psObjects = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(psCodePreviewAction.getPSObjType(), psCodePreviewAction.getPSObjId());
                    if (psObjects == null || psObjects.size() != 1) {
                        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\u5bf9\u8c61[%1$s][%2$s]", (Object)psCodePreviewAction.getPSObjType(), (Object)psCodePreviewAction.getPSObjId()));
                    }
                    PSDCCodeSnippet psDCCodeSnippet = new PSDCCodeSnippet();
                    psDCCodeSnippet.setTEMPLCODE(psCodePreviewAction.getTemplCode());
                    PSModelSFCode psModelSFCode = new PSModelSFCode();
                    if (!StringHelper.IsNullOrEmpty((String)psDCCodeSnippet.getTEMPLCODE())) {
                        DefaultPSCodeSnippetPublisherImpl2 defaultPSCodeSnippetPublisherImpl2 = new DefaultPSCodeSnippetPublisherImpl2();
                        defaultPSCodeSnippetPublisherImpl2.init(this.getDAGlobalHelper(), psDCCodeSnippet);
                        PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), null);
                        psPublishContextImpl.setPSSysModelInstId(iPSSystem.getPSSysModelInstId());
                        IPSGenerateCodeResult iPSGenerateCodeResult = defaultPSCodeSnippetPublisherImpl2.generateCode(psPublishContextImpl, psObjects.get(0));
                        psModelSFCode.setUSERCODE(iPSGenerateCodeResult.getCode());
                    }
                    psModelSFCode.setPSMODELSFCODENAME(StringHelper.Format((String)"result.code"));
                    psModelSFCode.setMEMO("");
                    psModelSFCodeList.add(psModelSFCode);
                }
            }
            catch (Exception ex) {
                psCodePreviewActionService = (PSCodePreviewActionService)ServiceGlobal.getService(PSCodePreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                psCodePreviewAction2.reset();
                psCodePreviewAction2.setPSCodePreviewActionId(this.getTaskParam());
                psCodePreviewAction2.setActionState(Integer.valueOf(40));
                psCodePreviewAction2.setActionResult(StringHelper.Format((String)"\u83b7\u53d6\u6267\u884c\u7ed3\u679c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                psCodePreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
                psCodePreviewActionService.update(psCodePreviewAction2, false);
                throw ex;
            }
            HashMap<String, String> templFileMap = new HashMap<String, String>();
            try {
                String strTempPath2;
                strPubFolder = PSTaskServerEnvImpl.getCurrent().createTempFolder();
                String strTempPath = strTempPath2 = KeyValueHelper.genGuidEx();
                JSONObject indexJO = new JSONObject();
                indexJO.put("root", (Object)strServerRoot);
                ArrayList<JSONObject> fileList = new ArrayList<JSONObject>();
                for (PSModelSFCode psModelSFCode : psModelSFCodeList) {
                    File folder;
                    int nPos;
                    String strCodeFolder = String.valueOf(strPubFolder) + strTempPath + File.separator;
                    String strCodePath = psModelSFCode.getCODEPATH();
                    if (!StringHelper.IsNullOrEmpty((String)strCodePath) && (nPos = strCodePath.lastIndexOf(File.separator)) != -1) {
                        strCodeFolder = String.valueOf(strCodeFolder) + strCodePath.substring(0, nPos);
                    }
                    if (!(folder = new File(strCodeFolder)).exists()) {
                        folder.mkdirs();
                    }
                    String strFullPath = String.valueOf(strPubFolder) + strTempPath + File.separator;
                    if (!StringHelper.IsNullOrEmpty((String)strCodePath)) {
                        File fileFolder = new File(strFullPath = String.valueOf(strFullPath) + strCodePath);
                        if (!fileFolder.exists()) {
                            fileFolder.mkdirs();
                        }
                        strFullPath = String.valueOf(strFullPath) + File.separator;
                    }
                    strFullPath = String.valueOf(strFullPath) + psModelSFCode.getPSMODELSFCODENAME();
                    String strCode = psModelSFCode.getUSERCODE();
                    strCode = strCode.replace("\\", "\\\\");
                    strCode = strCode.replace("\"", "\\\"");
                    strCode = strCode.replace("\n", "\\n");
                    strCode = strCode.replace("\r", "\\r");
                    strCode = StringHelper.Format((String)"code(\"%1$s\")", (Object)strCode);
                    FileWriterHelper.write(strFullPath, strCode);
                    String strTemplCode = psModelSFCode.getParamStringValue("CODETEMPL", "");
                    strTemplCode = strTemplCode.replace("\\", "\\\\");
                    strTemplCode = strTemplCode.replace("\"", "\\\"");
                    strTemplCode = strTemplCode.replace("\n", "\\n");
                    strTemplCode = strTemplCode.replace("\r", "\\r");
                    strTemplCode = StringHelper.Format((String)"code(\"%1$s\")", (Object)strTemplCode);
                    FileWriterHelper.write(String.valueOf(strFullPath) + ".ftl", strTemplCode);
                    templFileMap.put(new File(String.valueOf(strFullPath) + ".ftl").getCanonicalPath(), "");
                    JSONObject jo = new JSONObject();
                    jo.put("text", (Object)psModelSFCode.getPSMODELSFCODENAME());
                    String strFileUrl = strTempPath;
                    if (!StringHelper.IsNullOrEmpty((String)strCodePath)) {
                        strFileUrl = String.valueOf(strFileUrl) + "/" + strCodePath.replace("\\", "/");
                    }
                    if (strFileUrl.lastIndexOf("/") != strFileUrl.length() - 1) {
                        strFileUrl = String.valueOf(strFileUrl) + "/";
                    }
                    strFileUrl = String.valueOf(strFileUrl) + psModelSFCode.getPSMODELSFCODENAME();
                    strFileUrl = strFileUrl.replace("//", "/");
                    jo.put("url", (Object)strFileUrl);
                    fileList.add(jo);
                }
                ArrayList<JSONObject> paths = this.parsePath(strTempPath2, new File(String.valueOf(strPubFolder) + File.separator + strTempPath2), templFileMap);
                indexJO.put("paths", (Object)JSONArray.fromArray((Object[])paths.toArray(new Object[paths.size()])));
                String strIndexFileName = String.format("jsonp%1$s", KeyValueHelper.genUniqueId((String)KeyValueHelper.genGuidEx()));
                strIndexFile = String.format("%1$s%2$s%3$s%2$s%4$s.js", strPubFolder, File.separator, strTempPath2, strIndexFileName);
                File indexFile = new File(strIndexFile);
                if (!indexFile.getParentFile().exists()) {
                    indexFile.getParentFile().mkdirs();
                }
                FileWriterHelper.write(strIndexFile, StringHelper.Format((String)"%1$s(%2$s)", (Object)"code", (Object)indexJO.toString()));
                strIndexFile = String.valueOf(strTempPath2) + "/" + strIndexFileName + ".js";
            }
            catch (Exception ex) {
                psCodePreviewActionService = (PSCodePreviewActionService)ServiceGlobal.getService(PSCodePreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                psCodePreviewAction2.reset();
                psCodePreviewAction2.setPSCodePreviewActionId(this.getTaskParam());
                psCodePreviewAction2.setActionState(Integer.valueOf(40));
                psCodePreviewAction2.setActionResult(StringHelper.Format((String)"\u751f\u6210\u7ed3\u679c\u6587\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                psCodePreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
                psCodePreviewActionService.update(psCodePreviewAction2, false);
                throw ex;
            }
        }
        if (this.isCancel()) {
            psCodePreviewActionService = (PSCodePreviewActionService)ServiceGlobal.getService(PSCodePreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            psCodePreviewAction2.reset();
            psCodePreviewAction2.setPSCodePreviewActionId(this.getTaskParam());
            psCodePreviewAction2.setActionState(Integer.valueOf(40));
            psCodePreviewAction2.setActionResult("\u4f5c\u4e1a\u88ab\u53d6\u6d88");
            psCodePreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
            psCodePreviewActionService.update(psCodePreviewAction2, false);
            return null;
        }
        psCodePreviewActionService = (PSCodePreviewActionService)ServiceGlobal.getService(PSCodePreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psCodePreviewAction2.reset();
        psCodePreviewAction2.setPSCodePreviewActionId(this.getTaskParam());
        psCodePreviewAction2.setActionState(Integer.valueOf(20));
        psCodePreviewAction2.setPreviewStep("\u6b63\u5728\u90e8\u7f72\u4e0a\u4f20\u7ed3\u679c\u6587\u4ef6");
        psCodePreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
        psCodePreviewActionService.update(psCodePreviewAction2, false);
        if (!this.isCancel()) {
            strPubFolder = strPubFolder.replace("\\\\", File.separator);
            strPubFolder = strPubFolder.replace("//", File.separator);
            strPubFolder = strPubFolder.substring(0, strPubFolder.length() - 1);
            String strCmd = "";
            strCmd = PSTaskServerEnvImpl.getCurrent().isLinux() ? StringHelper.Format((String)"python %1$s%2$spyutils%2$stempfilehelp.py %3$s %4$s %5$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strPubFolder, (Object)strServerHost, (Object)nServerPort) : StringHelper.Format((String)"cmd.exe /c python %1$s%2$spyutils%2$stempfilehelp.py %3$s %4$s %5$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strPubFolder, (Object)strServerHost, (Object)nServerPort);
            String strResult = this.runBat(strCmd, true);
            Thread.sleep(2000L);
            psCodePreviewActionService = (PSCodePreviewActionService)ServiceGlobal.getService(PSCodePreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            psCodePreviewAction2.reset();
            psCodePreviewAction2.setPSCodePreviewActionId(this.getTaskParam());
            psCodePreviewAction2.setActionState(Integer.valueOf(30));
            psCodePreviewAction2.setPreviewStep("");
            psCodePreviewAction2.setActionResult("");
            psCodePreviewAction2.setCodeUrl(StringHelper.Format((String)"%1$s%2$s", (Object)strServerRoot, (Object)strIndexFile));
            psCodePreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
            psCodePreviewActionService.update(psCodePreviewAction2, false);
            return null;
        }
        psCodePreviewActionService = (PSCodePreviewActionService)ServiceGlobal.getService(PSCodePreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psCodePreviewAction2.reset();
        psCodePreviewAction2.setPSCodePreviewActionId(this.getTaskParam());
        psCodePreviewAction2.setActionState(Integer.valueOf(40));
        psCodePreviewAction2.setActionResult("\u4f5c\u4e1a\u88ab\u53d6\u6d88");
        psCodePreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
        psCodePreviewActionService.update(psCodePreviewAction2, false);
        return null;
    }

    protected IPSSystem getPSSystem(String strPSDevSlnSysId, String strPSSystemId) throws Exception {
        return this.getPSSystem(strPSDevSlnSysId, strPSSystemId, IPSSystem.LOADLEVEL_CODE);
    }

    protected IPSSystem getPSSystem(String strPSDevSlnSysId, String strPSSystemId, int nLoadLevel) throws Exception {
        IPSSystem iPSSystem = null;
        if (!StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId)) {
            IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
            iPSSystem = iPSDevSlnSys.getPSSystem(false);
            if (iPSSystem.getLoadedLevel() < nLoadLevel) {
                iPSDevSlnSys.reloadPSSystem(nLoadLevel);
            }
            iPSSystem = iPSDevSlnSys.getPSSystem(true);
        } else {
            iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
            if (iPSSystem.getLoadedLevel() < nLoadLevel) {
                this.getPSModelStorage().resetPSSystem(strPSSystemId);
                this.getPSModelHelper().startLoadPSSystem(strPSSystemId, nLoadLevel);
                try {
                    IPSSystem ipsSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
                    ipsSystem.load(nLoadLevel);
                    this.getPSModelHelper().stopLoadPSSystem();
                }
                catch (Exception ex) {
                    this.getPSModelHelper().stopLoadPSSystem();
                    throw ex;
                }
            }
            iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
        }
        return iPSSystem;
    }

    protected IPSApplication getPSApplication(IPSSystem iPSSystem, String strPSSysAppId) throws Exception {
        return this.getPSApplication(iPSSystem, strPSSysAppId, IPSSystem.LOADLEVEL_CODE);
    }

    protected IPSApplication getPSApplication(IPSSystem iPSSystem, String strPSSysAppId, int nLoadLevel) throws Exception {
        IPSApplication iPSApplication = iPSSystem.getPSApplication(strPSSysAppId);
        if (iPSApplication.getLoadedLevel() >= nLoadLevel) {
            return iPSApplication;
        }
        return PSSystemUtil.loadPSApplication(iPSSystem, strPSSysAppId, nLoadLevel);
    }

    protected ArrayList<JSONObject> parsePath(String strRootTag, File path, Map<String, String> templFileMap) throws Exception {
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        File[] files = path.listFiles();
        if (files == null) {
            return list;
        }
        int i = 0;
        while (i < files.length) {
            JSONObject jo;
            File file = files[i];
            if (!file.isDirectory()) {
                if (!templFileMap.containsKey(file.getCanonicalPath())) {
                    jo = new JSONObject();
                    jo.put("text", (Object)file.getName());
                    String strUrl = String.valueOf(strRootTag) + "/" + file.getName();
                    jo.put("url", (Object)strUrl);
                    jo.put("type", (Object)"file");
                    list.add(jo);
                }
            } else {
                jo = new JSONObject();
                jo.put("text", (Object)file.getName());
                jo.put("type", (Object)"folder");
                ArrayList<JSONObject> childs = this.parsePath(String.valueOf(strRootTag) + "/" + file.getName(), file, templFileMap);
                jo.put("children", (Object)JSONArray.fromArray((Object[])childs.toArray(new JSONObject[childs.size()])));
                list.add(jo);
            }
            ++i;
        }
        return list;
    }
}
