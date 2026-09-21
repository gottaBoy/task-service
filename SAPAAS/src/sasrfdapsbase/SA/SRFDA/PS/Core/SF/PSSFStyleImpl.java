/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.service.ActionSession
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSSFSysCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFCodeFolder;
import SA.SRFDA.PS.Core.SF.IPSSFCodeType;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStyleParam;
import SA.SRFDA.PS.Core.SF.IPSSFStylePkg;
import SA.SRFDA.PS.Core.SF.IPSSFStylePrj;
import SA.SRFDA.PS.Core.SF.IPSSFStyleUtil;
import SA.SRFDA.PS.Core.SF.IPSSFStyleVer;
import SA.SRFDA.PS.Core.SF.IPSSFVerCode;
import SA.SRFDA.PS.Core.SF.PSSFCodeFolderImpl;
import SA.SRFDA.PS.Core.SF.PSSFObjectImpl;
import SA.SRFDA.PS.Core.SF.PSSFStyleParamImpl;
import SA.SRFDA.PS.Core.SF.PSSFStylePkgGlobalModel;
import SA.SRFDA.PS.Core.SF.PSSFStylePrjGlobalModel;
import SA.SRFDA.PS.Core.SF.PSSFStyleVerGlobalModel;
import SA.SRFDA.PS.Data.PSSFCodeFolder;
import SA.SRFDA.PS.Data.PSSFStyle;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFStyleImpl
extends PSSFObjectImpl
implements IPSSFStyle,
IPSSFStyleUtil {
    protected PSSFStyle psSFStyle = null;
    private static final Log log = LogFactory.getLog(PSSFStyleImpl.class);
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

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSF iPSSF, PSSFStyle psSFStyle) throws Exception {
        this.psSFStyle = psSFStyle;
        this.setPSSF(iPSSF);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psSFStyle.getPSSFSTYLEID());
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
        this.classPkgParamsMap = PropertiesHelper.Load((String)psSFStyle.getCLSPKGPARAMS());
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
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
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

    protected void onPreparePSSFCodeFolders() throws Exception {
        this.psSFCodeFolderList.clear();
        this.psSFCodeFolderMap.clear();
        this.psSFCodeFolderList2.clear();
        HashMap<String, IPSSFCodeFolder> psSFCodeFolderMap2 = null;
        if (this.getTemplPSSFStyle() != null) {
            psSFCodeFolderMap2 = new HashMap<String, IPSSFCodeFolder>();
            Iterator<IPSSFCodeFolder> psSFCodeFolders = this.getTemplPSSFStyle().getPSSFCodeFolders();
            while (psSFCodeFolders.hasNext()) {
                IPSSFCodeFolder iPSSFCodeFolder = psSFCodeFolders.next();
                this.psSFCodeFolderList.add(iPSSFCodeFolder);
                this.psSFCodeFolderMap.put(iPSSFCodeFolder.getId(), iPSSFCodeFolder);
                psSFCodeFolderMap2.put(iPSSFCodeFolder.getFolderCode(), iPSSFCodeFolder);
            }
        }
        Vector<PSSFCodeFolder> psSFCodeFolderList = new Vector<PSSFCodeFolder>();
        CallResult callResult = this.getPSModelHelper().getPSSFCodeFolders(this.getId(), psSFCodeFolderList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u670d\u52a1\u6846\u67b6\u4ee3\u7801\u76ee\u5f55\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSFCodeFolder psSFCodeFolder : psSFCodeFolderList) {
            IPSSFCodeFolder templPSSFCodeFolder;
            PSSFCodeFolderImpl iPSSFCodeFolder = new PSSFCodeFolderImpl();
            if (psSFCodeFolderMap2 != null && (templPSSFCodeFolder = (IPSSFCodeFolder)psSFCodeFolderMap2.get(psSFCodeFolder.getFOLDERNAME())) != null && StringHelper.isNullOrEmpty((String)psSFCodeFolder.getPSSFSTYLEPRJID()) && templPSSFCodeFolder.getPSSFStylePrj() != null) {
                psSFCodeFolder.setPSSFSTYLEPRJID(templPSSFCodeFolder.getPSSFStylePrj().getId());
                psSFCodeFolder.setPRJFOLDER(templPSSFCodeFolder.getPrjFolder());
            }
            iPSSFCodeFolder.init(this.getDAGlobalHelper(), this, psSFCodeFolder);
            this.psSFCodeFolderList.add(iPSSFCodeFolder);
            this.psSFCodeFolderList2.add(iPSSFCodeFolder);
            this.psSFCodeFolderMap.put(iPSSFCodeFolder.getId(), iPSSFCodeFolder);
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
        String strClassOrPkgName = PropertiesHelper.GetProperty((Properties)this.classPkgParamsMap, (String)strCodeType);
        if (!StringHelper.isNullOrEmpty((String)strClassOrPkgName)) {
            strClassOrPkgName = strClassOrPkgName.trim();
        }
        if (StringHelper.isNullOrEmpty((String)strClassOrPkgName) && this.getTemplPSSFStyle() != null) {
            return this.getTemplPSSFStyle().getClassOrPkgName(strCodeType);
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
                return nRet;
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
        if (this.templPSSFStyle != null) {
            strDefault = this.templPSSFStyle.getStyleParam(strParamName, strDefault);
        }
        return PropertiesHelper.GetProperty((Properties)this.classPkgParamsMap, (String)strParamName, (String)strDefault);
    }

    @Override
    public int getStyleParam(String strParamName, int nDefault) {
        IPSSFStyleParam iPSSFStyleParam = PSSFStyleParamImpl.getCurrent();
        if (iPSSFStyleParam != null && iPSSFStyleParam.containsStyleParam(strParamName)) {
            return iPSSFStyleParam.getStyleParam(strParamName, nDefault);
        }
        if (this.templPSSFStyle != null) {
            nDefault = this.templPSSFStyle.getStyleParam(strParamName, nDefault);
        }
        return PropertiesHelper.GetProperty((Properties)this.classPkgParamsMap, (String)strParamName, (int)nDefault);
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

    @Override
    public String getResLocalPath() {
        return null;
    }
}

