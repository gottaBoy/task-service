/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.Helper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ActionSession
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSSFSysCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFCodeFolder;
import SA.SRFDA.PS.Core.SF.IPSSFCodeType;
import SA.SRFDA.PS.Core.SF.IPSSFDBTempl2;
import SA.SRFDA.PS.Core.SF.IPSSFHelpCodeObject;
import SA.SRFDA.PS.Core.SF.IPSSFHelpTempl;
import SA.SRFDA.PS.Core.SF.IPSSFHelpTempl2;
import SA.SRFDA.PS.Core.SF.IPSSFLogicCodeObject;
import SA.SRFDA.PS.Core.SF.IPSSFLogicTempl;
import SA.SRFDA.PS.Core.SF.IPSSFLogicTempl2;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode2;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStyle2;
import SA.SRFDA.PS.Core.SF.IPSSFStyleParam;
import SA.SRFDA.PS.Core.SF.IPSSFStylePkg;
import SA.SRFDA.PS.Core.SF.IPSSFStylePrj;
import SA.SRFDA.PS.Core.SF.IPSSFStyleUtil;
import SA.SRFDA.PS.Core.SF.IPSSFStyleVer;
import SA.SRFDA.PS.Core.SF.IPSSFVerCode;
import SA.SRFDA.PS.Core.SF.PSSFCodeFolder2Impl;
import SA.SRFDA.PS.Core.SF.PSSFDBTempl2Impl;
import SA.SRFDA.PS.Core.SF.PSSFHelpTempl2Impl;
import SA.SRFDA.PS.Core.SF.PSSFLogicTempl2Impl;
import SA.SRFDA.PS.Core.SF.PSSFObjectImpl;
import SA.SRFDA.PS.Core.SF.PSSFPubCode2Impl;
import SA.SRFDA.PS.Core.SF.PSSFStyleParamImpl;
import SA.SRFDA.PS.Core.SF.PSSFStylePkgGlobalModel;
import SA.SRFDA.PS.Core.SF.PSSFStylePrjGlobalModel;
import SA.SRFDA.PS.Core.SF.PSSFStyleVerGlobalModel;
import SA.SRFDA.PS.Core.Util.CmdHelper;
import SA.SRFDA.PS.Core.Util.TemplFileHelper;
import SA.SRFDA.PS.Data.PSSFCodeFolder;
import SA.SRFDA.PS.Data.PSSFDBTempl;
import SA.SRFDA.PS.Data.PSSFHelpTempl;
import SA.SRFDA.PS.Data.PSSFLogicTempl;
import SA.SRFDA.PS.Data.PSSFPubCode;
import SA.SRFDA.PS.Data.PSSFStyle;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.Helper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSFStyle2Impl
extends PSSFObjectImpl
implements IPSSFStyle2,
IPSSFStyleUtil {
    private static final Log log = LogFactory.getLog(PSSFStyle2Impl.class);
    protected PSSFStyle psSFStyle = null;
    protected ArrayList<IPSSFCodeFolder> psSFCodeFolderList = new ArrayList();
    protected ArrayList<IPSSFCodeFolder> psSFCodeFolderList2 = new ArrayList();
    protected HashMap<String, IPSSFCodeFolder> psSFCodeFolderMap = new HashMap();
    private PSSFStyleVerGlobalModel psSFStyleVerGlobalModel = new PSSFStyleVerGlobalModel();
    private Properties classPkgParamsMap = null;
    protected PSSFStylePrjGlobalModel psSFStylePrjGlobalModel = new PSSFStylePrjGlobalModel();
    protected PSSFStylePkgGlobalModel psSFStylePkgGlobalModel = new PSSFStylePkgGlobalModel();
    private String strWorkshopFolder = "workshop";
    private String strVersionString = "";
    private String strTemplDocRootUrl = null;
    private int nEnableWorkshopServer = 0;
    private int nEnableDeployCenter = 0;
    private String strTemplPSSFStyleId = null;
    private IPSSFStyle templPSSFStyle = null;
    private HashMap<String, IPSSFStylePkg> psSFStylePkgMap = null;
    private String strResourceUrl = null;
    private int nPkgInheritMode = 1;
    private ArrayList<IPSSFStylePkg> sortedPSSFStylePkgList = null;
    private File rootFolder = null;
    private int nRefreshVersion = 0;
    private Properties styleTemplateProperties = null;
    protected HashMap<String, IPSSFLogicTempl2> psSFLogicTemplMap2 = new HashMap();
    protected HashMap<String, IPSSFPubCode> psPFPubCodeMap = new HashMap();
    protected HashMap<String, IPSSFDBTempl2> psSFDBTemplMap2 = new HashMap();
    protected HashMap<String, IPSSFHelpTempl2> psSFHelpTemplMap2 = new HashMap();
    private String strRealLocalPath = null;
    private File resRootFolder = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSF iPSSF, PSSFStyle psSFStyle) throws Exception {
        try {
            this.psSFStyle = psSFStyle;
            this.setPSSF(iPSSF);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setId(this.psSFStyle.getPSSFSTYLEID());
            if (StringHelper.isNullOrEmpty((String)this.psSFStyle.getPSSFSTYLEID())) {
                this.setId(this.psSFStyle.getPPSSFSTYLEID());
            }
            this.setName(this.psSFStyle.getPSSFSTYLENAME());
            if (!this.psSFStyle.isVERSIONNull()) {
                this.setVersion(this.psSFStyle.getVERSION());
            } else {
                this.setVersion(1);
            }
            this.strVersionString = this.psSFStyle.getVERSTR();
            this.setPSObjectData(this.psSFStyle);
            this.strTemplPSSFStyleId = this.psSFStyle.getPPSSFSTYLEID();
            this.psSFStyleVerGlobalModel.Init(iDAGlobalHelper, this);
            this.strResourceUrl = this.psSFStyle.getSTYLERESURL();
            this.classPkgParamsMap = PropertiesHelper.load((String)psSFStyle.getCLSPKGPARAMS());
            if (!this.psSFStyle.isWORKSHOPNAMENull()) {
                this.strWorkshopFolder = this.psSFStyle.getWORKSHOPNAME();
            } else if (this.getTemplPSSFStyle() != null) {
                this.strWorkshopFolder = this.getTemplPSSFStyle().getWorkshopFolder();
            }
            this.strTemplDocRootUrl = this.psSFStyle.getTEMPLROOTURL();
            if (StringHelper.isNullOrEmpty((String)this.strTemplDocRootUrl) && this.getTemplPSSFStyle() != null) {
                this.strTemplDocRootUrl = this.getTemplPSSFStyle().getTemplDocRootUrl();
            }
            if (StringHelper.isNullOrEmpty((String)this.strVersionString) && this.getTemplPSSFStyle() != null) {
                this.strVersionString = this.getTemplPSSFStyle().getVersionString();
            }
            if (StringHelper.isNullOrEmpty((String)this.strResourceUrl) && this.getTemplPSSFStyle() != null) {
                this.strResourceUrl = this.getTemplPSSFStyle().getResourceUrl();
            }
            if (!this.psSFStyle.isENABLEWSSERVERNull()) {
                this.nEnableWorkshopServer = this.psSFStyle.getENABLEWSSERVER();
            } else if (this.getTemplPSSFStyle() != null) {
                this.nEnableWorkshopServer = this.getTemplPSSFStyle().getEnableWorkshopServer();
            }
            if (!this.psSFStyle.isENABLEDEPLOYCENTERNull()) {
                this.nEnableDeployCenter = this.psSFStyle.getENABLEDEPLOYCENTER();
            } else if (this.getTemplPSSFStyle() != null) {
                this.nEnableDeployCenter = this.getTemplPSSFStyle().getEnableDeployCenter();
            }
            if (!this.psSFStyle.isPKGINHERITMODENull()) {
                this.nPkgInheritMode = this.psSFStyle.getPKGINHERITMODE();
            }
            if (!this.psSFStyle.isREFRESHVERNull()) {
                this.nRefreshVersion = this.psSFStyle.getREFRESHVER();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strError = StringHelper.format((String)"\u521d\u59cb\u5316\u540e\u53f0\u6a21\u677f\u6837\u5f0f[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)iPSSF.getName(), (Object)psSFStyle.getPSSFSTYLENAME(), (Object)ex.getMessage());
            log.error((Object)strError, (Throwable)ex);
            throw new Exception(strError, ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        IPSSFStyle2 iPSSFStyle2;
        String strSourceFolder;
        this.rootFolder = new File(this.getLocalPath());
        this.pullToLocal();
        if (this.getTemplPSSFStyle() instanceof IPSSFStyle2 && !StringHelper.isNullOrEmpty((String)(strSourceFolder = (iPSSFStyle2 = (IPSSFStyle2)this.getTemplPSSFStyle()).getRealLocalPath()))) {
            String strTempFolder = PSTaskServerEnvImpl.getCurrent().createTempFolder();
            String strSourceFolder2 = this.getLocalPath();
            String strCmd = "";
            strCmd = PSTaskServerEnvImpl.getCurrent().isLinux() ? StringHelper.format((String)"python %1$s%2$spyutils%2$smergehelp.py %3$s %4$s %5$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strTempFolder, (Object)strSourceFolder, (Object)strSourceFolder2) : StringHelper.format((String)"cmd.exe /c python %1$s%2$spyutils%2$smergehelp.py %3$s %4$s %5$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strTempFolder, (Object)strSourceFolder, (Object)strSourceFolder2);
            CmdHelper.Result result = CmdHelper.getInstance().executeBat(strCmd);
            this.strRealLocalPath = strTempFolder;
            this.rootFolder = new File(this.getRealLocalPath());
        }
        if (!this.rootFolder.exists()) {
            throw new Exception("\u672c\u5730\u7f13\u5b58\u4e0d\u5b58\u5728\uff0c\u672a\u80fd\u4ece\u6307\u5b9a\u4ed3\u5e93\u83b7\u53d6\u6a21\u677f");
        }
        File propertiesFile = new File(String.valueOf(this.rootFolder.getCanonicalPath()) + File.separator + "template.properties");
        if (propertiesFile.exists()) {
            this.styleTemplateProperties = PropertiesHelper.loadFromFile((String)propertiesFile.getCanonicalPath());
        }
        this.psSFStylePkgGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSFStylePrjGlobalModel.Init(this.getDAGlobalHelper(), this);
        super.onInit();
        if (this.getTemplPSSFStyle() != null && this.nPkgInheritMode == 1) {
            IPSSFStylePkg iPSSFStylePkg;
            this.psSFStylePkgMap = new HashMap();
            Iterator<IPSSFStylePkg> psSFStylePkgs = this.getTemplPSSFStyle().getPSSFStylePkgs();
            while (psSFStylePkgs.hasNext()) {
                iPSSFStylePkg = psSFStylePkgs.next();
                this.psSFStylePkgMap.put(iPSSFStylePkg.getPSSFPkgVer().getPSSFPkg().getId(), iPSSFStylePkg);
            }
            psSFStylePkgs = this.psSFStylePkgGlobalModel.getAllModelHelpers();
            while (psSFStylePkgs.hasNext()) {
                iPSSFStylePkg = psSFStylePkgs.next();
                this.psSFStylePkgMap.put(iPSSFStylePkg.getPSSFPkgVer().getPSSFPkg().getId(), iPSSFStylePkg);
            }
        }
        this.onPreparePSSFCodeFolders();
    }

    protected void pullToLocal() throws Exception {
        String strGitUser = "";
        String strGitPassword = "";
        if (!StringHelper.isNullOrEmpty((String)this.getRemotePath())) {
            PSSVNServer psSVNServer = null;
            PSDevSlnTemplService psDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnTempl psDevSlnTempl = new PSDevSlnTempl();
            psDevSlnTempl.setPSSFId(this.getPSSF().getId());
            psDevSlnTempl.setPSSFStyleId(this.getId());
            if (psDevSlnTemplService.selectOne((IEntity)psDevSlnTempl, true) && psDevSlnTempl.getPSDevCenterSVN() != null && psDevSlnTempl.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
                psSVNServer = psDevSlnTempl.getPSDevCenterSVN().getPSSVNInstRepo().getPSSVNServer();
            }
            if (psSVNServer == null) {
                log.warn((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u540e\u53f0\u6a21\u677f[%1$s]\u6837\u5f0f[%2$s]\u7684\u7248\u672c\u670d\u52a1\u5668", (Object)this.getPSSF().getId(), (Object)this.getId()));
            } else {
                if (!StringHelper.isNullOrEmpty((String)psSVNServer.getGITUserName())) {
                    strGitUser = psSVNServer.getGITUserName();
                }
                if (!StringHelper.isNullOrEmpty((String)psSVNServer.getGITPassword())) {
                    strGitPassword = psSVNServer.getGITPassword();
                }
            }
            String strLocalFolder = this.rootFolder.getParent();
            String strCmd = "";
            strCmd = PSTaskServerEnvImpl.getCurrent().isLinux() ? StringHelper.format((String)"python %1$s%2$spyutils%2$sgit_pull.py %3$s %4$s %5$s %6$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)this.getRemotePath(), (Object)strLocalFolder, (Object)strGitUser, (Object)strGitPassword) : StringHelper.format((String)"cmd.exe /c python %1$s%2$spyutils%2$sgit_pull.py %3$s %4$s %5$s %6$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)this.getRemotePath(), (Object)strLocalFolder, (Object)strGitUser, (Object)strGitPassword);
            CmdHelper.Result result = CmdHelper.getInstance().executeBat(strCmd);
            log.info((Object)StringHelper.format((String)"\u83b7\u53d6Git\u4ed3\u5e93\u8fd4\u56de\u4fe1\u606f\r\n[\u6210\u529f\u4fe1\u606f]\r\n%1$s\r\n[\u5931\u8d25\u4fe1\u606f]\r\n%2$s\r\n", (Object)result.getInfo(), (Object)result.getErrorInfo()));
        }
        if (!StringHelper.isNullOrEmpty((String)this.getResourceUrl())) {
            String strLocalFolder = String.valueOf(this.rootFolder.getAbsolutePath()) + "#RES";
            String strCmd = "";
            strCmd = PSTaskServerEnvImpl.getCurrent().isLinux() ? StringHelper.format((String)"python %1$s%2$spyutils%2$sgit_pull.py %3$s %4$s %5$s %6$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)this.getResourceUrl(), (Object)strLocalFolder, (Object)strGitUser, (Object)strGitPassword) : StringHelper.format((String)"cmd.exe /c python %1$s%2$spyutils%2$sgit_pull.py %3$s %4$s %5$s %6$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)this.getResourceUrl(), (Object)strLocalFolder, (Object)strGitUser, (Object)strGitPassword);
            CmdHelper.Result result = CmdHelper.getInstance().executeBat(strCmd);
            log.info((Object)StringHelper.format((String)"\u83b7\u53d6\u8d44\u6e90Git\u4ed3\u5e93\u8fd4\u56de\u4fe1\u606f\r\n[\u6210\u529f\u4fe1\u606f]\r\n%1$s\r\n[\u5931\u8d25\u4fe1\u606f]\r\n%2$s\r\n", (Object)result.getInfo(), (Object)result.getErrorInfo()));
            File resFolder = new File(strLocalFolder);
            File[] files = resFolder.listFiles();
            if (files != null) {
                int i = 0;
                while (i < files.length) {
                    File file = files[i];
                    if (file.isDirectory()) {
                        this.resRootFolder = file;
                        break;
                    }
                    ++i;
                }
            }
        }
    }

    protected void onPreparePSSFCodeFolders() throws Exception {
        String strFolderName;
        Object file;
        this.psSFCodeFolderList.clear();
        this.psSFCodeFolderMap.clear();
        this.psSFCodeFolderList2.clear();
        HashMap psSFCodeFolderMap2 = null;
        Vector<PSSFCodeFolder> psSFCodeFolderList = new Vector<PSSFCodeFolder>();
        File templFolder = new File(this.getRealLocalPath());
        File[] files = templFolder.listFiles();
        int i = 0;
        while (i < files.length) {
            file = files[i];
            if (((File)file).isDirectory() && (strFolderName = ((File)file).getName()).indexOf("@") != 0) {
                PSSFCodeFolder psSFCodeFolder = new PSSFCodeFolder();
                psSFCodeFolder.setFOLDERNAME(strFolderName);
                psSFCodeFolder.setPSSFCODEFOLDERNAME(strFolderName);
                psSFCodeFolder.setPSSFCODEFOLDERID(KeyValueHelper.genUniqueId((String)this.getId(), (String)strFolderName));
                psSFCodeFolderList.add(psSFCodeFolder);
            }
            ++i;
        }
        for (PSSFCodeFolder psSFCodeFolder : psSFCodeFolderList) {
            IPSSFCodeFolder templPSSFCodeFolder;
            PSSFCodeFolder2Impl iPSSFCodeFolder = new PSSFCodeFolder2Impl();
            if (psSFCodeFolderMap2 != null && (templPSSFCodeFolder = (IPSSFCodeFolder)psSFCodeFolderMap2.get(psSFCodeFolder.getFOLDERNAME())) != null && StringHelper.isNullOrEmpty((String)psSFCodeFolder.getPSSFSTYLEPRJID()) && templPSSFCodeFolder.getPSSFStylePrj() != null) {
                psSFCodeFolder.setPSSFSTYLEPRJID(templPSSFCodeFolder.getPSSFStylePrj().getId());
                psSFCodeFolder.setPRJFOLDER(templPSSFCodeFolder.getPrjFolder());
            }
            iPSSFCodeFolder.init(this.getDAGlobalHelper(), this, psSFCodeFolder);
            this.psSFCodeFolderList.add(iPSSFCodeFolder);
            this.psSFCodeFolderList2.add(iPSSFCodeFolder);
            this.psSFCodeFolderMap.put(iPSSFCodeFolder.getId(), iPSSFCodeFolder);
        }
        i = 0;
        while (i < files.length) {
            file = files[i];
            if (((File)file).isDirectory() && (strFolderName = ((File)file).getName()).indexOf("@") == 0) {
                String strFolderName2;
                File ctrl;
                int j;
                File[] ctrls;
                if (StringHelper.compare((String)strFolderName, (String)"@LOGIC", (boolean)true) == 0) {
                    ctrls = ((File)file).listFiles();
                    j = 0;
                    while (j < ctrls.length) {
                        ctrl = ctrls[j];
                        if (ctrl.isDirectory() && (strFolderName2 = ctrl.getName()).indexOf("@") == 0) {
                            this.onPreparePSSFLogicTempls(ctrl);
                        }
                        ++j;
                    }
                } else if (StringHelper.compare((String)strFolderName, (String)"@DB", (boolean)true) == 0) {
                    ctrls = ((File)file).listFiles();
                    j = 0;
                    while (j < ctrls.length) {
                        ctrl = ctrls[j];
                        if (ctrl.isDirectory() && (strFolderName2 = ctrl.getName()).indexOf("@") == 0) {
                            this.onPreparePSSFDBTempls(ctrl);
                        }
                        ++j;
                    }
                } else if (StringHelper.compare((String)strFolderName, (String)"@HELP", (boolean)true) == 0) {
                    ctrls = ((File)file).listFiles();
                    j = 0;
                    while (j < ctrls.length) {
                        ctrl = ctrls[j];
                        if (ctrl.isDirectory() && (strFolderName2 = ctrl.getName()).indexOf("@") == 0) {
                            this.onPreparePSSFHelpTempls(ctrl);
                        }
                        ++j;
                    }
                }
            }
            ++i;
        }
    }

    protected void onPreparePSSFLogicTempls(File logics) throws Exception {
        String strLogicCat = logics.getName().substring(1);
        File[] ctrls = logics.listFiles();
        int j = 0;
        while (j < ctrls.length) {
            String strFolderName2;
            File ctrl = ctrls[j];
            if (ctrl.isDirectory() && (strFolderName2 = ctrl.getName()).indexOf("@") != 0) {
                this.onPreparePSSFLogicTempls(strLogicCat, ctrl);
            }
            ++j;
        }
    }

    protected void onPreparePSSFLogicTempls(String strLogicCat, File logic) throws Exception {
        File[] files;
        strLogicCat = strLogicCat.toUpperCase();
        String strLogicType = logic.getName().toUpperCase();
        Properties templProperties = null;
        File propertiesFile = new File(String.valueOf(logic.getCanonicalPath()) + File.separator + "template.properties");
        if (propertiesFile.exists()) {
            templProperties = PropertiesHelper.loadFromFile((String)propertiesFile.getCanonicalPath());
        }
        if (!StringHelper.isNullOrEmpty((String)(strLogicType = PropertiesHelper.getProperty((Properties)templProperties, (String)"LOGICTYPE", (String)strLogicType)))) {
            strLogicType = strLogicType.trim();
        }
        strLogicType = strLogicType.toUpperCase();
        File[] fileArray = files = logic.listFiles();
        int n = files.length;
        int n2 = 0;
        while (n2 < n) {
            File file = fileArray[n2];
            String strFileName = file.getName();
            if (strFileName.indexOf("@") != 0) {
                String strSuffix;
                int nPos;
                if (file.isDirectory()) {
                    this.onPreparePSSFLogicTempls(strLogicCat, file);
                } else if (strFileName.indexOf("#") == -1 && (nPos = strFileName.lastIndexOf(".")) > 0 && (strSuffix = strFileName.substring(nPos + 1)).compareToIgnoreCase("ftl") == 0) {
                    strFileName = strFileName.substring(0, strFileName.length() - 4);
                    TemplFileHelper templFileHelper = new TemplFileHelper();
                    BaseDataEntity baseDataEntity = templFileHelper.getTemplData(file.getCanonicalFile(), this.rootFolder);
                    String strContent = baseDataEntity.getParamStringValue("CONTENT", "");
                    String strTemplate = baseDataEntity.getParamStringValue("TEMPLATE", "");
                    Properties macroParams = null;
                    if (!StringHelper.isNullOrEmpty((String)strTemplate)) {
                        macroParams = PropertiesHelper.load((String)strTemplate);
                    }
                    boolean bCheckModelOnly = PropertiesHelper.getProperty((Properties)macroParams, (String)"CHECKMODELONLY", (boolean)false);
                    boolean bRemoveEmptyFile = PropertiesHelper.getProperty((Properties)macroParams, (String)"REMOVEEMPTYFILE", (boolean)true);
                    PSSFPubCode psPFPubCode = new PSSFPubCode();
                    psPFPubCode.setPSSFPUBCODEID(KeyValueHelper.genUniqueId((String)this.getPSSF().getId(), (String)"NONE", (String)strFileName.toUpperCase()));
                    IPSSFPubCode iPSSFPubCode = this.psPFPubCodeMap.get(psPFPubCode.getPSSFPUBCODEID());
                    if (iPSSFPubCode == null) {
                        psPFPubCode.setPSSFPUBCODENAME(strFileName);
                        psPFPubCode.setPSSFCODEFOLDERID("");
                        psPFPubCode.setPSSFCODEFOLDERNAME("");
                        psPFPubCode.setTARGETTYPE("NONE");
                        PSSFPubCode2Impl psPFPubCode2Impl = new PSSFPubCode2Impl();
                        psPFPubCode2Impl.init(this.getDAGlobalHelper(), this, null, psPFPubCode);
                        this.psPFPubCodeMap.put(psPFPubCode2Impl.getId(), psPFPubCode2Impl);
                        iPSSFPubCode = psPFPubCode2Impl;
                    }
                    PSSFLogicTempl psSFLogicTempl = new PSSFLogicTempl();
                    psSFLogicTempl.setPSSFLOGICTEMPLID(Helper.GenUniqueId((String)this.getPSSF().getId(), (String)this.getId(), (String)strLogicCat, (String)strLogicType, (String)iPSSFPubCode.getId()));
                    psSFLogicTempl.setPSSFLOGICTEMPLNAME(StringHelper.format((String)"@LOGIC/@%1$s/%2$s", (Object)strLogicCat, (Object)strLogicType));
                    psSFLogicTempl.setPSSFID(this.getPSSF().getId());
                    psSFLogicTempl.setPSSFNAME(this.getPSSF().getName());
                    psSFLogicTempl.setPSSFSTYLEID(this.getId());
                    psSFLogicTempl.setPSSFSTYLENAME(this.getName());
                    psSFLogicTempl.setPSSFPUBCODEID(iPSSFPubCode.getId());
                    psSFLogicTempl.setPSSFPUBCODENAME(iPSSFPubCode.getName());
                    psSFLogicTempl.setCHECKMODELONLY(bCheckModelOnly);
                    psSFLogicTempl.setREMOVEEMPTYFILE(bRemoveEmptyFile);
                    psSFLogicTempl.setTEMPLCODE(strContent);
                    String strTemplFilePath = file.getCanonicalPath();
                    String strRootFilePath = this.rootFolder.getCanonicalPath();
                    if (strTemplFilePath.indexOf(strRootFilePath) == 0) {
                        psSFLogicTempl.setTEMPLFILEPATH(strTemplFilePath.substring(strRootFilePath.length()));
                    }
                    psSFLogicTempl.setTEMPLCODE2(strTemplFilePath);
                    PSSFLogicTempl2Impl psSFLogicTempl2Impl = new PSSFLogicTempl2Impl();
                    psSFLogicTempl2Impl.init(this.getDAGlobalHelper(), (IPSSFPubCode2)iPSSFPubCode, psSFLogicTempl);
                    IPSSFLogicTempl2 lastPSSFLogicTempl2 = this.psSFLogicTemplMap2.get(psSFLogicTempl2Impl.getId());
                    if (lastPSSFLogicTempl2 != null) {
                        throw new Exception(StringHelper.format((String)"\u6a21\u677f[%1$s]\u5b9a\u4e49\u5185\u5bb9\u5df2\u5728\u6a21\u677f[%2$s]\u4e2d\u5b9a\u4e49\uff0c\u4e0d\u80fd\u91cd\u590d\u5b9a\u4e49", (Object)psSFLogicTempl2Impl.getTemplFilePath(), (Object)lastPSSFLogicTempl2.getTemplFilePath()));
                    }
                    this.psSFLogicTemplMap2.put(psSFLogicTempl2Impl.getId(), psSFLogicTempl2Impl);
                }
            }
            ++n2;
        }
    }

    protected void onPreparePSSFDBTempls(File dbs) throws Exception {
        String strDBCat = dbs.getName().substring(1);
        File[] ctrls = dbs.listFiles();
        int j = 0;
        while (j < ctrls.length) {
            String strFolderName2;
            File ctrl = ctrls[j];
            if (ctrl.isDirectory() && (strFolderName2 = ctrl.getName()).indexOf("@") != 0) {
                this.onPreparePSSFDBTempls(strDBCat, ctrl);
            }
            ++j;
        }
    }

    protected void onPreparePSSFDBTempls(String strDBCat, File db) throws Exception {
        File[] files;
        strDBCat = strDBCat.toUpperCase();
        String strDBType = db.getName().toUpperCase();
        Properties templProperties = null;
        File propertiesFile = new File(String.valueOf(db.getCanonicalPath()) + File.separator + "template.properties");
        if (propertiesFile.exists()) {
            templProperties = PropertiesHelper.loadFromFile((String)propertiesFile.getCanonicalPath());
        }
        if (!StringHelper.isNullOrEmpty((String)(strDBType = PropertiesHelper.getProperty((Properties)templProperties, (String)"LOGICTYPE", (String)strDBType)))) {
            strDBType = strDBType.trim();
        }
        strDBType = strDBType.toUpperCase();
        File[] fileArray = files = db.listFiles();
        int n = files.length;
        int n2 = 0;
        while (n2 < n) {
            File file = fileArray[n2];
            String strFileName = file.getName();
            if (strFileName.indexOf("@") != 0) {
                String strSuffix;
                int nPos;
                if (file.isDirectory()) {
                    this.onPreparePSSFDBTempls(strDBCat, file);
                } else if (strFileName.indexOf("#") == -1 && (nPos = strFileName.lastIndexOf(".")) > 0 && (strSuffix = strFileName.substring(nPos + 1)).compareToIgnoreCase("ftl") == 0) {
                    strFileName = strFileName.substring(0, strFileName.length() - 4);
                    TemplFileHelper templFileHelper = new TemplFileHelper();
                    BaseDataEntity baseDataEntity = templFileHelper.getTemplData(file.getCanonicalFile(), this.rootFolder);
                    String strContent = baseDataEntity.getParamStringValue("CONTENT", "");
                    String strTemplate = baseDataEntity.getParamStringValue("TEMPLATE", "");
                    Properties macroParams = null;
                    if (!StringHelper.isNullOrEmpty((String)strTemplate)) {
                        macroParams = PropertiesHelper.load((String)strTemplate);
                    }
                    boolean bCheckModelOnly = PropertiesHelper.getProperty((Properties)macroParams, (String)"CHECKMODELONLY", (boolean)false);
                    boolean bRemoveEmptyFile = PropertiesHelper.getProperty((Properties)macroParams, (String)"REMOVEEMPTYFILE", (boolean)true);
                    PSSFPubCode psPFPubCode = new PSSFPubCode();
                    psPFPubCode.setPSSFPUBCODEID(KeyValueHelper.genUniqueId((String)this.getPSSF().getId(), (String)"NONE", (String)strFileName.toUpperCase()));
                    IPSSFPubCode iPSSFPubCode = this.psPFPubCodeMap.get(psPFPubCode.getPSSFPUBCODEID());
                    if (iPSSFPubCode == null) {
                        psPFPubCode.setPSSFPUBCODENAME(strFileName);
                        psPFPubCode.setPSSFCODEFOLDERID("");
                        psPFPubCode.setPSSFCODEFOLDERNAME("");
                        psPFPubCode.setTARGETTYPE("NONE");
                        PSSFPubCode2Impl psPFPubCode2Impl = new PSSFPubCode2Impl();
                        psPFPubCode2Impl.init(this.getDAGlobalHelper(), this, null, psPFPubCode);
                        this.psPFPubCodeMap.put(psPFPubCode2Impl.getId(), psPFPubCode2Impl);
                        iPSSFPubCode = psPFPubCode2Impl;
                    }
                    PSSFDBTempl psSFDBTempl = new PSSFDBTempl();
                    psSFDBTempl.setPSSFDBTEMPLID(Helper.GenUniqueId((String)this.getPSSF().getId(), (String)this.getId(), (String)strDBCat, (String)strDBType, (String)iPSSFPubCode.getId()));
                    psSFDBTempl.setPSSFDBTEMPLNAME(StringHelper.format((String)"@DB/@%1$s/%2$s", (Object)strDBCat, (Object)strDBType));
                    psSFDBTempl.setPSSFID(this.getPSSF().getId());
                    psSFDBTempl.setPSSFNAME(this.getPSSF().getName());
                    psSFDBTempl.setPSSFSTYLEID(this.getId());
                    psSFDBTempl.setPSSFSTYLENAME(this.getName());
                    psSFDBTempl.setPSSFPUBCODEID(iPSSFPubCode.getId());
                    psSFDBTempl.setPSSFPUBCODENAME(iPSSFPubCode.getName());
                    psSFDBTempl.setTEMPLCODE(strContent);
                    psSFDBTempl.setCHECKMODELONLY(bCheckModelOnly);
                    psSFDBTempl.setREMOVEEMPTYFILE(bRemoveEmptyFile);
                    String strTemplFilePath = file.getCanonicalPath();
                    String strRootFilePath = this.rootFolder.getCanonicalPath();
                    if (strTemplFilePath.indexOf(strRootFilePath) == 0) {
                        psSFDBTempl.setTEMPLFILEPATH(strTemplFilePath.substring(strRootFilePath.length()));
                    }
                    psSFDBTempl.setTEMPLCODE2(strTemplFilePath);
                    PSSFDBTempl2Impl psSFDBTempl2Impl = new PSSFDBTempl2Impl();
                    psSFDBTempl2Impl.init(this.getDAGlobalHelper(), (IPSSFPubCode2)iPSSFPubCode, psSFDBTempl);
                    IPSSFDBTempl2 lastPSSFDBTempl2 = this.psSFDBTemplMap2.get(psSFDBTempl2Impl.getId());
                    if (lastPSSFDBTempl2 != null) {
                        throw new Exception(StringHelper.format((String)"\u6a21\u677f[%1$s]\u5b9a\u4e49\u5185\u5bb9\u5df2\u5728\u6a21\u677f[%2$s]\u4e2d\u5b9a\u4e49\uff0c\u4e0d\u80fd\u91cd\u590d\u5b9a\u4e49", (Object)psSFDBTempl2Impl.getTemplFilePath(), (Object)lastPSSFDBTempl2.getTemplFilePath()));
                    }
                    this.psSFDBTemplMap2.put(psSFDBTempl2Impl.getId(), psSFDBTempl2Impl);
                }
            }
            ++n2;
        }
    }

    protected void onPreparePSSFHelpTempls(File helps) throws Exception {
        String strHelpCat = helps.getName().substring(1);
        File[] ctrls = helps.listFiles();
        int j = 0;
        while (j < ctrls.length) {
            String strFolderName2;
            File ctrl = ctrls[j];
            if (ctrl.isDirectory() && (strFolderName2 = ctrl.getName()).indexOf("@") != 0) {
                this.onPreparePSSFHelpTempls(strHelpCat, ctrl);
            }
            ++j;
        }
    }

    protected void onPreparePSSFHelpTempls(String strHelpCat, File db) throws Exception {
        File[] files;
        strHelpCat = strHelpCat.toUpperCase();
        String strDBType = db.getName().toUpperCase();
        Properties templProperties = null;
        File propertiesFile = new File(String.valueOf(db.getCanonicalPath()) + File.separator + "template.properties");
        if (propertiesFile.exists()) {
            templProperties = PropertiesHelper.loadFromFile((String)propertiesFile.getCanonicalPath());
        }
        if (!StringHelper.isNullOrEmpty((String)(strDBType = PropertiesHelper.getProperty((Properties)templProperties, (String)"HELPTYPE", (String)strDBType)))) {
            strDBType = strDBType.trim();
        }
        strDBType = strDBType.toUpperCase();
        File[] fileArray = files = db.listFiles();
        int n = files.length;
        int n2 = 0;
        while (n2 < n) {
            File file = fileArray[n2];
            String strFileName = file.getName();
            if (strFileName.indexOf("@") != 0) {
                String strSuffix;
                int nPos;
                if (file.isDirectory()) {
                    this.onPreparePSSFHelpTempls(strHelpCat, file);
                } else if (strFileName.indexOf("#") == -1 && (nPos = strFileName.lastIndexOf(".")) > 0 && (strSuffix = strFileName.substring(nPos + 1)).compareToIgnoreCase("ftl") == 0) {
                    strFileName = strFileName.substring(0, strFileName.length() - 4);
                    TemplFileHelper templFileHelper = new TemplFileHelper();
                    BaseDataEntity baseDataEntity = templFileHelper.getTemplData(file.getCanonicalFile(), this.rootFolder);
                    String strContent = baseDataEntity.getParamStringValue("CONTENT", "");
                    String strTemplate = baseDataEntity.getParamStringValue("TEMPLATE", "");
                    Properties macroParams = null;
                    if (!StringHelper.isNullOrEmpty((String)strTemplate)) {
                        macroParams = PropertiesHelper.load((String)strTemplate);
                    }
                    boolean bCheckModelOnly = PropertiesHelper.getProperty((Properties)macroParams, (String)"CHECKMODELONLY", (boolean)false);
                    boolean bRemoveEmptyFile = PropertiesHelper.getProperty((Properties)macroParams, (String)"REMOVEEMPTYFILE", (boolean)true);
                    PSSFPubCode psPFPubCode = new PSSFPubCode();
                    psPFPubCode.setPSSFPUBCODEID(KeyValueHelper.genUniqueId((String)this.getPSSF().getId(), (String)"NONE", (String)strFileName.toUpperCase()));
                    IPSSFPubCode iPSSFPubCode = this.psPFPubCodeMap.get(psPFPubCode.getPSSFPUBCODEID());
                    if (iPSSFPubCode == null) {
                        psPFPubCode.setPSSFPUBCODENAME(strFileName);
                        psPFPubCode.setPSSFCODEFOLDERID("");
                        psPFPubCode.setPSSFCODEFOLDERNAME("");
                        psPFPubCode.setTARGETTYPE("NONE");
                        PSSFPubCode2Impl psPFPubCode2Impl = new PSSFPubCode2Impl();
                        psPFPubCode2Impl.init(this.getDAGlobalHelper(), this, null, psPFPubCode);
                        this.psPFPubCodeMap.put(psPFPubCode2Impl.getId(), psPFPubCode2Impl);
                        iPSSFPubCode = psPFPubCode2Impl;
                    }
                    PSSFHelpTempl psSFHelpTempl = new PSSFHelpTempl();
                    psSFHelpTempl.setPSSFHELPTEMPLID(Helper.GenUniqueId((String)this.getPSSF().getId(), (String)this.getId(), (String)strHelpCat, (String)strDBType, (String)iPSSFPubCode.getId()));
                    psSFHelpTempl.setPSSFHELPTEMPLNAME(StringHelper.format((String)"@HELP/@%1$s/%2$s", (Object)strHelpCat, (Object)strDBType));
                    psSFHelpTempl.setPSSFID(this.getPSSF().getId());
                    psSFHelpTempl.setPSSFNAME(this.getPSSF().getName());
                    psSFHelpTempl.setPSSFSTYLEID(this.getId());
                    psSFHelpTempl.setPSSFSTYLENAME(this.getName());
                    psSFHelpTempl.setPSSFPUBCODEID(iPSSFPubCode.getId());
                    psSFHelpTempl.setPSSFPUBCODENAME(iPSSFPubCode.getName());
                    psSFHelpTempl.setTEMPLCODE(strContent);
                    psSFHelpTempl.setCHECKMODELONLY(bCheckModelOnly);
                    psSFHelpTempl.setREMOVEEMPTYFILE(bRemoveEmptyFile);
                    String strTemplFilePath = file.getCanonicalPath();
                    String strRootFilePath = this.rootFolder.getCanonicalPath();
                    if (strTemplFilePath.indexOf(strRootFilePath) == 0) {
                        psSFHelpTempl.setTEMPLFILEPATH(strTemplFilePath.substring(strRootFilePath.length()));
                    }
                    psSFHelpTempl.setTEMPLCODE2(strTemplFilePath);
                    PSSFHelpTempl2Impl psSFHelpTempl2Impl = new PSSFHelpTempl2Impl();
                    psSFHelpTempl2Impl.init(this.getDAGlobalHelper(), (IPSSFPubCode2)iPSSFPubCode, psSFHelpTempl);
                    IPSSFHelpTempl2 lastPSSFHelpTempl2 = this.psSFHelpTemplMap2.get(psSFHelpTempl2Impl.getId());
                    if (lastPSSFHelpTempl2 != null) {
                        throw new Exception(StringHelper.format((String)"\u6a21\u677f[%1$s]\u5b9a\u4e49\u5185\u5bb9\u5df2\u5728\u6a21\u677f[%2$s]\u4e2d\u5b9a\u4e49\uff0c\u4e0d\u80fd\u91cd\u590d\u5b9a\u4e49", (Object)psSFHelpTempl2Impl.getTemplFilePath(), (Object)lastPSSFHelpTempl2.getTemplFilePath()));
                    }
                    this.psSFHelpTemplMap2.put(psSFHelpTempl2Impl.getId(), psSFHelpTempl2Impl);
                }
            }
            ++n2;
        }
    }

    @Override
    public Iterator<IPSSFCodeFolder> getPSSFCodeFolders() throws Exception {
        return this.getPSSFCodeFolders(true);
    }

    @Override
    public Iterator<IPSSFCodeFolder> getPSSFCodeFolders(boolean bIncludeTempl) throws Exception {
        if (bIncludeTempl) {
            return this.psSFCodeFolderList.iterator();
        }
        return this.psSFCodeFolderList2.iterator();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSF.getPSSysModelInstId();
    }

    @Override
    public String getClassOrPkgName(String strCodeType) throws Exception {
        String strClassOrPkgName = null;
        if (this.styleTemplateProperties != null) {
            strClassOrPkgName = PropertiesHelper.getProperty((Properties)this.styleTemplateProperties, (String)strCodeType);
        }
        if (!StringHelper.isNullOrEmpty(strClassOrPkgName)) {
            strClassOrPkgName = strClassOrPkgName.trim();
        }
        if (StringHelper.isNullOrEmpty((String)strClassOrPkgName)) {
            strClassOrPkgName = PropertiesHelper.getProperty((Properties)this.classPkgParamsMap, (String)strCodeType);
        }
        if (!StringHelper.isNullOrEmpty((String)strClassOrPkgName)) {
            strClassOrPkgName = strClassOrPkgName.trim();
        }
        if (StringHelper.isNullOrEmpty((String)strClassOrPkgName)) {
            if (this.getTemplPSSFStyle() != null) {
                return this.getTemplPSSFStyle().getClassOrPkgName(strCodeType);
            }
            return this.getPSSF().getClassOrPkgName(strCodeType);
        }
        return strClassOrPkgName;
    }

    @Override
    public IPSSFCodeFolder getPSSFCodeFolder(String strSFCodeFolderId) throws Exception {
        IPSSFCodeFolder iPSSFCodeFolder = this.psSFCodeFolderMap.get(strSFCodeFolderId);
        if (iPSSFCodeFolder == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u76ee\u5f55"));
        }
        return iPSSFCodeFolder;
    }

    @Override
    public void resetPSSFCodeFolder(String strSFCodeFolderId) throws Exception {
        this.psSFCodeFolderMap.remove(strSFCodeFolderId);
    }

    @Override
    public IPSSFStyleVer getPSSFStyleVer(String strSFStyleVerId) throws Exception {
        return (IPSSFStyleVer)this.psSFStyleVerGlobalModel.FindModelHelper(strSFStyleVerId);
    }

    @Override
    public void resetPSSFStyleVer(String strSFStyleVerId) throws Exception {
        this.psSFStyleVerGlobalModel.ResetModel(strSFStyleVerId);
    }

    @Override
    public IPSSFStylePrj getPSSFStylePrj(String strPSSFStylePrjId, boolean bTryMode) throws Exception {
        if (this.getTemplPSSFStyle() != null) {
            IPSSFStylePrj iPSSFStylePrj = (IPSSFStylePrj)this.psSFStylePrjGlobalModel.FindModelHelper(strPSSFStylePrjId, true);
            if (iPSSFStylePrj != null) {
                return iPSSFStylePrj;
            }
            return this.getTemplPSSFStyle().getPSSFStylePrj(strPSSFStylePrjId, bTryMode);
        }
        return (IPSSFStylePrj)this.psSFStylePrjGlobalModel.FindModelHelper(strPSSFStylePrjId, bTryMode);
    }

    @Override
    public Iterator<IPSSFStylePrj> getPSSFStylePrjs() throws Exception {
        if (this.getTemplPSSFStyle() != null && this.psSFStylePrjGlobalModel.getAllModelHelperCount() == 0) {
            return this.getTemplPSSFStyle().getPSSFStylePrjs();
        }
        return this.psSFStylePrjGlobalModel.getAllModelHelpers();
    }

    @Override
    public Iterator<IPSSFStylePkg> getPSSFStylePkgs() throws Exception {
        if (this.sortedPSSFStylePkgList != null) {
            return this.sortedPSSFStylePkgList.iterator();
        }
        ArrayList<IPSSFStylePkg> tempList = new ArrayList<IPSSFStylePkg>();
        Iterator<IPSSFStylePkg> psSFStylePkgList = this.getSourcePSSFStylePkgs();
        while (psSFStylePkgList.hasNext()) {
            tempList.add(psSFStylePkgList.next());
        }
        Collections.sort(tempList, new Comparator<IPSSFStylePkg>(){

            @Override
            public int compare(IPSSFStylePkg o1, IPSSFStylePkg o2) {
                int nRet = o1.getOrderValue() - o2.getOrderValue();
                if (nRet == 0) {
                    return StringHelper.compare((String)o1.getName(), (String)o2.getName(), (boolean)false);
                }
                if (nRet > 0) {
                    return 1;
                }
                return -1;
            }
        });
        if (this.sortedPSSFStylePkgList == null) {
            this.sortedPSSFStylePkgList = tempList;
        }
        return this.sortedPSSFStylePkgList.iterator();
    }

    private Iterator<IPSSFStylePkg> getSourcePSSFStylePkgs() throws Exception {
        if (this.psSFStylePkgMap != null) {
            return this.psSFStylePkgMap.values().iterator();
        }
        return this.psSFStylePkgGlobalModel.getAllModelHelpers();
    }

    @Override
    public String getStyleParam(String strParamName, String strDefault) {
        IPSSFStyleParam iPSSFStyleParam = PSSFStyleParamImpl.getCurrent();
        if (iPSSFStyleParam != null && iPSSFStyleParam.containsStyleParam(strParamName)) {
            return iPSSFStyleParam.getStyleParam(strParamName, strDefault);
        }
        if (this.styleTemplateProperties != null && PropertiesHelper.getProperty((Properties)this.styleTemplateProperties, (String)strParamName) != null) {
            return PropertiesHelper.getProperty((Properties)this.styleTemplateProperties, (String)strParamName, (String)strDefault);
        }
        if (this.templPSSFStyle != null) {
            strDefault = this.templPSSFStyle.getStyleParam(strParamName, strDefault);
        }
        return PropertiesHelper.getProperty((Properties)this.classPkgParamsMap, (String)strParamName, (String)strDefault);
    }

    @Override
    public int getStyleParam(String strParamName, int nDefault) {
        IPSSFStyleParam iPSSFStyleParam = PSSFStyleParamImpl.getCurrent();
        if (iPSSFStyleParam != null && iPSSFStyleParam.containsStyleParam(strParamName)) {
            return iPSSFStyleParam.getStyleParam(strParamName, nDefault);
        }
        if (this.styleTemplateProperties != null && PropertiesHelper.getProperty((Properties)this.styleTemplateProperties, (String)strParamName) != null) {
            return PropertiesHelper.getProperty((Properties)this.styleTemplateProperties, (String)strParamName, (int)nDefault);
        }
        if (this.templPSSFStyle != null) {
            nDefault = this.templPSSFStyle.getStyleParam(strParamName, nDefault);
        }
        return PropertiesHelper.getProperty((Properties)this.classPkgParamsMap, (String)strParamName, (int)nDefault);
    }

    @Override
    public ArrayList<PSSysSFCode> generateCode(IPSPublisherContext iPSPublisherContext, IPSSysSFPub iPSSysSFPub, String strPSModelType, IPSObject iPSObject) throws Exception {
        HashMap<String, IPSSFCodeType> psSFCodeTypeMap = new HashMap<String, IPSSFCodeType>();
        Iterator<IPSSFCodeFolder> psSFCodeFolders = this.getPSSFCodeFolders();
        while (psSFCodeFolders.hasNext()) {
            IPSSFCodeFolder iPSSFCodeFolder = psSFCodeFolders.next();
            Iterator<IPSSFCodeType> psSFCodeTypes = iPSSFCodeFolder.getPSSFCodeTypes();
            while (psSFCodeTypes.hasNext()) {
                IPSSFCodeType iPSSFCodeType = psSFCodeTypes.next();
                if (!iPSSFCodeType.testPubPSModelCode(strPSModelType) || iPSSFCodeType.isDebugModeOnly() && (PSTaskServerEnvImpl.getCurrent() == null || !PSTaskServerEnvImpl.getCurrent().isDebugMode())) continue;
                if (iPSSFCodeType.isRemoveMode()) {
                    psSFCodeTypeMap.remove(iPSSFCodeType.getTypeCode());
                    continue;
                }
                psSFCodeTypeMap.put(iPSSFCodeType.getTypeCode(), iPSSFCodeType);
            }
        }
        if (iPSSysSFPub.getPSSFStyleVer() != null) {
            Iterator<IPSSFVerCode> psSFVerCodes = iPSSysSFPub.getPSSFStyleVer().getPSSFVerCodes();
            while (psSFVerCodes.hasNext()) {
                IPSSFVerCode iPSSFVerCode = psSFVerCodes.next();
                if (iPSSFVerCode.isRemoveMode()) {
                    psSFCodeTypeMap.remove(iPSSFVerCode.getTypeCode());
                    continue;
                }
                psSFCodeTypeMap.put(iPSSFVerCode.getTypeCode(), iPSSFVerCode);
            }
        }
        ArrayList<PSSysSFCode> psSysSFCodeList = new ArrayList<PSSysSFCode>();
        for (IPSSFCodeType iPSSFCodeType : psSFCodeTypeMap.values()) {
            IPSSFSysCodePublisher iPSSFSysCodePublisher = null;
            try {
                iPSSFSysCodePublisher = iPSSFCodeType.getPSSFSysCodePublisher();
                ArrayList<PSSysSFCode> psSysSFCodeList2 = iPSSFSysCodePublisher.generateCode(iPSPublisherContext, iPSSysSFPub, iPSObject);
                if (psSysSFCodeList2 != null) {
                    psSysSFCodeList.addAll(psSysSFCodeList2);
                }
                iPSSFSysCodePublisher.close();
            }
            catch (Exception ex) {
                if (iPSSFSysCodePublisher != null) {
                    iPSSFSysCodePublisher.close();
                }
                log.error((Object)ex);
            }
        }
        return psSysSFCodeList;
    }

    @Override
    public String getWorkshopFolder() {
        return this.strWorkshopFolder;
    }

    @Override
    public String getVersionString() {
        return this.strVersionString;
    }

    @Override
    public String getTemplDocRootUrl() {
        return this.strTemplDocRootUrl;
    }

    @Override
    public int getEnableWorkshopServer() {
        return this.nEnableWorkshopServer;
    }

    @Override
    public int getEnableDeployCenter() {
        return this.nEnableDeployCenter;
    }

    @Override
    public String getResourceUrl() {
        return this.strResourceUrl;
    }

    @Override
    @PSModelRTMeta(description="\u7ee7\u627f\u6837\u5f0f", hideempty=true)
    public IPSSFStyle getTemplPSSFStyle() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.strTemplPSSFStyleId)) {
            return null;
        }
        if (this.templPSSFStyle != null) {
            return this.templPSSFStyle;
        }
        boolean bClose = false;
        try {
            ActionSession actionSession = ActionSessionManager.getCurrentSession();
            if (actionSession == null) {
                bClose = true;
                actionSession = ActionSessionManager.openSession((String)"PSSFStyleImpl");
                actionSession.registerRecursion("PSSFSTYLE", (Object)this.getId());
            } else if (!actionSession.registerRecursion("PSSFSTYLE", (Object)this.getId())) {
                throw new Exception(StringHelper.format((String)"\u540e\u53f0\u670d\u52a1\u6846\u67b6[%1$s]\u6837\u5f0f[%2$s]\u6a21\u677f\u6837\u5f0f\u5b58\u5728\u9012\u5f52\u5173\u7cfb", (Object)this.getPSSF().getName(), (Object)this.getName()));
            }
            this.templPSSFStyle = this.getPSSF().getPSSFStyle(this.strTemplPSSFStyleId);
            if (bClose) {
                ActionSessionManager.closeSession();
            }
            return this.templPSSFStyle;
        }
        catch (Exception ex) {
            if (bClose) {
                ActionSessionManager.closeSession();
            }
            throw ex;
        }
    }

    protected String getLocalPath() {
        if (PSTaskServerEnvImpl.getCurrent().isLinux() && !StringHelper.isNullOrEmpty((String)this.psSFStyle.getV2FOLDER2())) {
            return this.psSFStyle.getV2FOLDER2();
        }
        return this.psSFStyle.getV2FOLDER();
    }

    protected String getRemotePath() {
        return this.psSFStyle.getV2GITPATH();
    }

    @Override
    public String getRealLocalPath() {
        if (PSTemplHelper.isBusy()) {
            log.error((Object)StringHelper.format((String)"\u4e0d\u80fd\u5728\u6a21\u677f\u53d1\u5e03\u4e2d\u8c03\u7528[%1$s]\u65b9\u6cd5", (Object)"getRealLocalPath"));
            return null;
        }
        if (!StringHelper.isNullOrEmpty((String)this.strRealLocalPath)) {
            return this.strRealLocalPath;
        }
        return this.getLocalPath();
    }

    @Override
    public IPSSFPubCode getPSSFPubCode(String strTargetType, String strPFPubCodeId, boolean bTryMode) throws Exception {
        String strPFPubCodeId2 = KeyValueHelper.genUniqueId((String)this.getPSSF().getId(), (String)strTargetType, (String)strPFPubCodeId.toUpperCase());
        IPSSFPubCode iPSSFPubCode = this.psPFPubCodeMap.get(strPFPubCodeId2);
        if (iPSSFPubCode != null) {
            return iPSSFPubCode;
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u53d1\u5e03\u4ee3\u7801\u5bf9\u8c61[%1$s][%2$s]", (Object)strTargetType, (Object)strPFPubCodeId));
    }

    public IPSSFLogicTempl getPSSFLogicTempl(String strSFLogicTemplId, boolean bTryMode) throws Exception {
        IPSSFLogicTempl iPSSFLogicTempl = this.psSFLogicTemplMap2.get(strSFLogicTemplId);
        if (iPSSFLogicTempl == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u903b\u8f91\u6a21\u677f[%1$s]", (Object)strSFLogicTemplId));
        }
        return iPSSFLogicTempl;
    }

    public void resetPSSFLogicTempl(String strSFLogicTemplId) throws Exception {
        this.psSFLogicTemplMap2.remove(strSFLogicTemplId);
    }

    @Override
    public IPSSFLogicTempl getPSSFLogicTempl(IPSSFLogicCodeObject iPSSFLogicCodeObject, IPSSFPubCode iPSSFPubCode) throws Exception {
        String strPSSFLogicTemplId = Helper.GenUniqueId((String)this.getPSSF().getId(), (String)this.getId(), (String)iPSSFLogicCodeObject.getSFLogicCodeCat(), (String)iPSSFLogicCodeObject.getSFLogicCodeType(), (String)iPSSFPubCode.getId());
        return this.getPSSFLogicTempl(strPSSFLogicTemplId, true);
    }

    public IPSSFHelpTempl getPSSFHelpTempl(String strSFHelpTemplId, boolean bTryMode) throws Exception {
        IPSSFHelpTempl iPSSFHelpTempl = this.psSFHelpTemplMap2.get(strSFHelpTemplId);
        if (iPSSFHelpTempl == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u903b\u8f91\u6a21\u677f[%1$s]", (Object)strSFHelpTemplId));
        }
        return iPSSFHelpTempl;
    }

    public void resetPSSFHelpTempl(String strSFHelpTemplId) throws Exception {
        this.psSFHelpTemplMap2.remove(strSFHelpTemplId);
    }

    @Override
    public IPSSFHelpTempl getPSSFHelpTempl(IPSSFHelpCodeObject iPSSFHelpCodeObject, IPSSFPubCode iPSSFPubCode) throws Exception {
        String strPSSFHelpTemplId = Helper.GenUniqueId((String)this.getPSSF().getId(), (String)this.getId(), (String)iPSSFHelpCodeObject.getSFHelpCodeCat(), (String)iPSSFHelpCodeObject.getSFHelpCodeType(), (String)iPSSFPubCode.getId());
        return this.getPSSFHelpTempl(strPSSFHelpTemplId, true);
    }

    @Override
    public String getResLocalPath() {
        if (this.resRootFolder != null) {
            return this.resRootFolder.getAbsolutePath();
        }
        return null;
    }

    @Override
    public Iterator<? extends IPSSFLogicTempl> getPSSFLogicTempls() {
        if (this.psSFLogicTemplMap2.size() == 0) {
            return null;
        }
        return this.psSFLogicTemplMap2.values().iterator();
    }
}

