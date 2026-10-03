/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.core.IDEDataQueryCodeCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSFPreviewAction
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSFPreviewActionService
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQEngine;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataQueryImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Core.Util.FileWriterHelper;
import SA.SRFDA.PS.Core.Util.OpenAPI3SchemaHelper;
import SA.SRFDA.PS.Data.PSDEDataQuery;
import SA.SRFDA.PS.Data.PSModelSFCode;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSFPreviewAction;
import net.ibizsys.pscore.srv.sysdesign.service.PSSFPreviewActionService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSFPreviewPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(PSSFPreviewPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        String strPSDSConsoleId;
        PSSFPreviewActionService psSFPreviewActionService = (PSSFPreviewActionService)ServiceGlobal.getService(PSSFPreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSSFPreviewAction psSFPreviewAction = new PSSFPreviewAction();
        PSSFPreviewAction psSFPreviewAction2 = new PSSFPreviewAction();
        psSFPreviewAction.setPSSFPreviewActionId(this.getTaskParam());
        psSFPreviewActionService.get(psSFPreviewAction);
        String strPSDevSlnSysId = psSFPreviewAction.getPSDevSlnSysId();
        String strPSSysAppId = psSFPreviewAction.getActionParam();
        String strStudioType = psSFPreviewAction.getActionParam4();
        boolean bRawCode = false;
        if (!(StringHelper.IsNullOrEmpty((String)strStudioType) || StringHelper.Compare((String)strStudioType, (String)"DYNAMIC", (boolean)false) != 0 && StringHelper.Compare((String)strStudioType, (String)"MOSDYNAMIC", (boolean)false) != 0)) {
            bRawCode = true;
        }
        if (StringHelper.IsNullOrEmpty((String)(strPSDSConsoleId = psSFPreviewAction.getPSDSConsoleId()))) {
            strPSDSConsoleId = strPSDevSlnSysId;
        }
        psSFPreviewAction2.reset();
        psSFPreviewAction2.setPSSFPreviewActionId(this.getTaskParam());
        psSFPreviewAction2.setActionState(Integer.valueOf(20));
        psSFPreviewAction2.setPreviewStep("\u6b63\u5728\u751f\u6210\u9884\u89c8\u6587\u4ef6");
        psSFPreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
        psSFPreviewActionService.update(psSFPreviewAction2, false);
        IPSSystem iPSSystem = null;
        if (!this.isCancel()) {
            try {
                iPSSystem = this.getPSSystem(strPSDevSlnSysId, null);
            }
            catch (Exception ex) {
                psSFPreviewActionService = (PSSFPreviewActionService)ServiceGlobal.getService(PSSFPreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                psSFPreviewAction2.reset();
                psSFPreviewAction2.setPSSFPreviewActionId(this.getTaskParam());
                psSFPreviewAction2.setActionState(Integer.valueOf(40));
                psSFPreviewAction2.setActionResult(StringHelper.Format((String)"\u52a0\u8f7d\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                psSFPreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
                psSFPreviewActionService.update(psSFPreviewAction2, false);
                throw ex;
            }
        } else {
            psSFPreviewActionService = (PSSFPreviewActionService)ServiceGlobal.getService(PSSFPreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            psSFPreviewAction2.reset();
            psSFPreviewAction2.setPSSFPreviewActionId(this.getTaskParam());
            psSFPreviewAction2.setActionState(Integer.valueOf(40));
            psSFPreviewAction2.setActionResult("\u4f5c\u4e1a\u88ab\u53d6\u6d88");
            psSFPreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
            psSFPreviewActionService.update(psSFPreviewAction2, false);
            return null;
        }
        String strServerRoot = PSTaskServerEnvImpl.getCurrent().getTempFileServerUrl();
        String strServerHost = PSTaskServerEnvImpl.getCurrent().getTempFileServerAddr();
        int nServerPort = PSTaskServerEnvImpl.getCurrent().getTempFileServerPort();
        String strPubFolder = null;
        String strIndexFile = "";
        if (!this.isCancel()) {
            ArrayList<PSModelSFCode> psModelSFCodeList;
            block32: {
                psModelSFCodeList = new ArrayList<PSModelSFCode>();
                try {
                    if (StringHelper.Compare((String)psSFPreviewAction.getPSObjType(), (String)"PSDEDATAQUERY", (boolean)true) == 0) {
                        PSDEDataQuery psDEDataQuery = new PSDEDataQuery();
                        CallResult callResult = this.getPSModelHelper(iPSSystem.getPSSysModelInstId()).getPSDEDataQuery(psSFPreviewAction.getPSObjId(), psDEDataQuery);
                        if (callResult.isError()) {
                            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u67e5\u8be2"));
                        }
                        IPSDataEntity iPSDataEntity = iPSSystem.getPSDataEntity(psDEDataQuery.getPSDEID(), false);
                        if (iPSDataEntity == null) {
                            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]", (Object)psDEDataQuery.getPSDEID()));
                        }
                        PSDEDataQueryImpl iPSDEDataQuery = new PSDEDataQueryImpl();
                        iPSDEDataQuery.init(this.getDAGlobalHelper(), iPSDataEntity, psDEDataQuery);
                        Iterator<IPSSystemDBConfig> psSystemDBConfigs = iPSSystem.getAllPSSystemDBConfigs();
                        while (psSystemDBConfigs.hasNext()) {
                            IPSSystemDBConfig iPSSystemDBConfig = psSystemDBConfigs.next();
                            IPSDEDBConfig iPSDEDBConfig = iPSDataEntity.getPSDEDBConfig(iPSSystemDBConfig.getDBType(), true);
                            if (iPSDEDBConfig == null || !iPSDEDBConfig.isValid()) continue;
                            IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(iPSSystemDBConfig.getName());
                            IPSDEDQEngine iPSDEDQEngine = iPSDEDataQuery.getPSDEDQEngine(iPSDBType.getId());
                            StringBuilderEx sb = new StringBuilderEx();
                            sb.append("//\u6570\u636e\u5e93\u7c7b\u578b[%1$s]\r\n", (Object)iPSDBType.getName());
                            if (iPSDEDataQuery.isCustomCode()) {
                                sb.append("//\u6ce8\u610f\uff1a\u67e5\u8be2\u5df2\u8bbe\u7f6e\u4e3a\u81ea\u5b9a\u4e49\u4ee3\u7801\uff0c\u4e0b\u9762\u4ee3\u7801\u4e3a\u673a\u5668\u7f16\u8bd1\u7684\u9ed8\u8ba4\u4ee3\u7801\uff0c\u4ec5\u4f9b\u53c2\u8003\uff01\r\n");
                            }
                            sb.append("\r\n");
                            sb.append(iPSDEDQEngine.getQueryScript());
                            int nOrder = 0;
                            Iterator<IDEDataQueryCodeCond> deDataQueryConds = iPSDEDQEngine.getDEDataQueryCodeConds();
                            if (deDataQueryConds != null) {
                                while (deDataQueryConds.hasNext()) {
                                    IDEDataQueryCodeCond iDEDataQueryCodeCond = deDataQueryConds.next();
                                    if (nOrder == 0) {
                                        sb.append("\r\nWHERE ");
                                    } else {
                                        sb.append("\r\nAND");
                                    }
                                    ++nOrder;
                                    sb.append("\r\n%1$s ", (Object)iDEDataQueryCodeCond.getCustomCond());
                                }
                            }
                            PSModelSFCode psModelSFCode = new PSModelSFCode();
                            psModelSFCode.setUSERCODE(sb.toString());
                            psModelSFCode.setPSMODELSFCODENAME(StringHelper.Format((String)"%1$s.sql", (Object)iPSSystemDBConfig.getDBType()));
                            psModelSFCode.setMEMO("");
                            psModelSFCodeList.add(psModelSFCode);
                        }
                        break block32;
                    }
                    if (StringHelper.Compare((String)psSFPreviewAction.getPSObjType(), (String)"PSSYSSERVICEAPI", (boolean)true) == 0) {
                        IPSSysServiceAPI iPSSysServiceAPI = iPSSystem.getPSSysServiceAPI(psSFPreviewAction.getPSObjId());
                        OpenAPI3SchemaHelper openAPI3SchemaHelper = new OpenAPI3SchemaHelper(iPSSysServiceAPI);
                        ObjectNode objectNode = openAPI3SchemaHelper.export();
                        PSModelSFCode psModelSFCode = new PSModelSFCode();
                        psModelSFCode.setUSERCODE(objectNode.toString());
                        psModelSFCode.setPSMODELSFCODENAME(StringHelper.Format((String)"%1$s.json", (Object)psSFPreviewAction.getPSObjType()));
                        psModelSFCode.setMEMO("");
                        psModelSFCodeList.add(psModelSFCode);
                        break block32;
                    }
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u9884\u89c8\u5bf9\u8c61\u7c7b\u578b[%1$s]", (Object)psSFPreviewAction.getPSObjType()));
                }
                catch (Exception ex) {
                    psSFPreviewActionService = (PSSFPreviewActionService)ServiceGlobal.getService(PSSFPreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                    psSFPreviewAction2.reset();
                    psSFPreviewAction2.setPSSFPreviewActionId(this.getTaskParam());
                    psSFPreviewAction2.setActionState(Integer.valueOf(40));
                    psSFPreviewAction2.setActionResult(StringHelper.Format((String)"\u52a0\u8f7d\u9884\u89c8\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                    psSFPreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
                    psSFPreviewActionService.update(psSFPreviewAction2, false);
                    throw ex;
                }
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
                        File fileFolder = new File(strFullPath = String.valueOf(strFullPath) + strCodePath);
                        if (!fileFolder.exists()) {
                            fileFolder.mkdirs();
                        }
                        strFullPath = String.valueOf(strFullPath) + File.separator;
                    }
                    strFullPath = String.valueOf(strFullPath) + psModelSFCode.getPSMODELSFCODENAME();
                    String strCode = psModelSFCode.getUSERCODE();
                    if (!bRawCode) {
                        strCode = strCode.replace("\\", "\\\\");
                        strCode = strCode.replace("\"", "\\\"");
                        strCode = strCode.replace("\n", "\\n");
                        strCode = strCode.replace("\r", "\\r");
                        strCode = StringHelper.Format((String)"code(\"%1$s\")", (Object)strCode);
                    }
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
                    jo.put("url", (Object)strFileUrl);
                    fileList.add(jo);
                }
                indexJO.put("paths", (Object)JSONArray.fromArray((Object[])fileList.toArray(new Object[fileList.size()])));
                String strIndexFileName = String.format("jsonp%1$s", KeyValueHelper.genUniqueId((String)KeyValueHelper.genGuidEx()));
                strIndexFile = String.format("%1$s%2$s%3$s%2$s%4$s.js", strPubFolder, File.separator, strTempPath2, strIndexFileName);
                if (!bRawCode) {
                    FileWriterHelper.write(strIndexFile, StringHelper.Format((String)"%1$s(%2$s)", (Object)"code", (Object)indexJO.toString()));
                } else {
                    FileWriterHelper.write(strIndexFile, indexJO.toString());
                }
                strIndexFile = String.valueOf(strTempPath2) + "/" + strIndexFileName + ".js";
            }
            catch (Exception ex) {
                psSFPreviewActionService = (PSSFPreviewActionService)ServiceGlobal.getService(PSSFPreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                psSFPreviewAction2.reset();
                psSFPreviewAction2.setPSSFPreviewActionId(this.getTaskParam());
                psSFPreviewAction2.setActionState(Integer.valueOf(40));
                psSFPreviewAction2.setActionResult(StringHelper.Format((String)"\u751f\u6210\u9884\u89c8\u6587\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                psSFPreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
                psSFPreviewActionService.update(psSFPreviewAction2, false);
                throw ex;
            }
        }
        if (this.isCancel()) {
            psSFPreviewActionService = (PSSFPreviewActionService)ServiceGlobal.getService(PSSFPreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            psSFPreviewAction2.reset();
            psSFPreviewAction2.setPSSFPreviewActionId(this.getTaskParam());
            psSFPreviewAction2.setActionState(Integer.valueOf(40));
            psSFPreviewAction2.setActionResult("\u4f5c\u4e1a\u88ab\u53d6\u6d88");
            psSFPreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
            psSFPreviewActionService.update(psSFPreviewAction2, false);
            return null;
        }
        psSFPreviewActionService = (PSSFPreviewActionService)ServiceGlobal.getService(PSSFPreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psSFPreviewAction2.reset();
        psSFPreviewAction2.setPSSFPreviewActionId(this.getTaskParam());
        psSFPreviewAction2.setActionState(Integer.valueOf(20));
        psSFPreviewAction2.setPreviewStep("\u6b63\u5728\u90e8\u7f72\u4e0a\u4f20\u9884\u89c8\u6587\u4ef6");
        psSFPreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
        psSFPreviewActionService.update(psSFPreviewAction2, false);
        if (!this.isCancel()) {
            strPubFolder = strPubFolder.replace("\\\\", File.separator);
            strPubFolder = strPubFolder.replace("//", File.separator);
            strPubFolder = strPubFolder.substring(0, strPubFolder.length() - 1);
            String strCmd = "";
            strCmd = PSTaskServerEnvImpl.getCurrent().isLinux() ? StringHelper.Format((String)"python %1$s%2$spyutils%2$stempfilehelp.py %3$s %4$s %5$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strPubFolder, (Object)strServerHost, (Object)nServerPort) : StringHelper.Format((String)"cmd.exe /c python %1$s%2$spyutils%2$stempfilehelp.py %3$s %4$s %5$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strPubFolder, (Object)strServerHost, (Object)nServerPort);
            String strResult = this.runBat(strCmd, true);
            Thread.sleep(2000L);
            psSFPreviewActionService = (PSSFPreviewActionService)ServiceGlobal.getService(PSSFPreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            psSFPreviewAction2.reset();
            psSFPreviewAction2.setPSSFPreviewActionId(this.getTaskParam());
            psSFPreviewAction2.setActionState(Integer.valueOf(30));
            psSFPreviewAction2.setPreviewStep("");
            psSFPreviewAction2.setActionResult("");
            psSFPreviewAction2.setCodeUrl(StringHelper.Format((String)"%1$s%2$s", (Object)strServerRoot, (Object)strIndexFile));
            psSFPreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
            psSFPreviewActionService.update(psSFPreviewAction2, false);
            return null;
        }
        psSFPreviewActionService = (PSSFPreviewActionService)ServiceGlobal.getService(PSSFPreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psSFPreviewAction2.reset();
        psSFPreviewAction2.setPSSFPreviewActionId(this.getTaskParam());
        psSFPreviewAction2.setActionState(Integer.valueOf(40));
        psSFPreviewAction2.setActionResult("\u4f5c\u4e1a\u88ab\u53d6\u6d88");
        psSFPreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
        psSFPreviewActionService.update(psSFPreviewAction2, false);
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
}
