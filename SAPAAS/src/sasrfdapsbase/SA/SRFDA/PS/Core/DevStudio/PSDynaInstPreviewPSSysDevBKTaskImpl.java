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
import SA.SRFDA.PS.Core.DevStudio.PubDynaInstModelPSSysDevBKTaskImpl;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Util.FileWriterHelper;
import SA.SRFDA.PS.Data.PSModelSFCode;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.ArrayList;
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

public class PSDynaInstPreviewPSSysDevBKTaskImpl
extends PubDynaInstModelPSSysDevBKTaskImpl {
    private static final Log log = LogFactory.getLog(PSDynaInstPreviewPSSysDevBKTaskImpl.class);

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
        if (!this.isCancel()) {
            try {
                super.onRun();
            }
            catch (Exception ex) {
                psCodePreviewActionService = (PSCodePreviewActionService)ServiceGlobal.getService(PSCodePreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                psCodePreviewAction2.reset();
                psCodePreviewAction2.setPSCodePreviewActionId(this.getTaskParam());
                psCodePreviewAction2.setActionState(Integer.valueOf(40));
                psCodePreviewAction2.setActionResult(StringHelper.Format((String)"\u53d1\u5e03\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
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
                String strFilePath = String.valueOf(this.getCfgPath()) + File.separator + psCodePreviewAction.getPSObjId();
                File file = new File(strFilePath);
                if (file.exists()) {
                    String strCode = FileWriterHelper.readFile(strFilePath);
                    PSModelSFCode psModelSFCode2 = new PSModelSFCode();
                    psModelSFCode2.setPSMODELSFCODENAME(file.getName());
                    psModelSFCode2.setUSERCODE(strCode);
                    psModelSFCodeList.add(psModelSFCode2);
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
                        strFullPath = String.valueOf(strFullPath) + strCodePath;
                        File fileFolder = new File(strFullPath);
                        if (!(fileFolder = fileFolder.getParentFile()).exists()) {
                            fileFolder.mkdirs();
                        }
                        strFullPath = String.valueOf(fileFolder.getAbsolutePath()) + File.separator;
                    } else {
                        folder = new File(strFullPath);
                        if (!folder.exists()) {
                            folder.mkdirs();
                        }
                    }
                    strFullPath = String.valueOf(strFullPath) + psModelSFCode.getPSMODELSFCODENAME();
                    String strCode = psModelSFCode.getUSERCODE();
                    FileWriterHelper.write(strFullPath, strCode);
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
                indexJO.put("paths", (Object)JSONArray.fromArray((Object[])fileList.toArray(new Object[fileList.size()])));
                String strIndexFileName = String.format("jsonp%1$s", KeyValueHelper.genUniqueId((String)KeyValueHelper.genGuidEx()));
                strIndexFile = String.format("%1$s%2$s%3$s%2$s%4$s.js", strPubFolder, File.separator, strTempPath2, strIndexFileName);
                FileWriterHelper.write(strIndexFile, indexJO.toString());
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

    @Override
    protected void pubPSAppStoreBoardModel(IPSApplication iPSApplication) throws Exception {
    }
}
