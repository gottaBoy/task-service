/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Deploy.IPSDeployCenter;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnSysWSGit;
import SA.SRFDA.PS.Core.Deploy.IPSWorkshopServer;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubPkg;
import SA.SRFDA.PS.Core.Pub.IPSSysSFUserCode;
import SA.SRFDA.PS.Core.Pub.PSSysSFPubPkgImpl;
import SA.SRFDA.PS.Core.Pub.PSSysSFUserCodeImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFPkgVer;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStyleParam;
import SA.SRFDA.PS.Core.SF.IPSSFStylePkg;
import SA.SRFDA.PS.Core.SF.IPSSFStyleVer;
import SA.SRFDA.PS.Core.SF.PSSFStylePkgImpl;
import SA.SRFDA.PS.Data.PSDevSlnTempl;
import SA.SRFDA.PS.Data.PSSFStyleParam;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFDA.PS.Data.PSSysSFPub;
import SA.SRFDA.PS.Data.PSSysSFPubPkg;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysSFPubImpl
extends PSSystemObjectImpl
implements IPSSysSFPub,
IPSSFStyleParam {
    private static final Log log = LogFactory.getLog(PSSysSFPubImpl.class);
    public static final String STYLEPARAM_PUBMODEL = "PUBMODEL";
    public static final String STYLEPARAM_MODELFOLDER = "MODELFOLDER";
    public static final String STYLEPARAM_GROOVYFOLDER = "GROOVYFOLDER";
    public static final String STYLEPARAM_PUBCODELEVEL = "PUBCODELEVEL";
    public static final String STYLEPARAM_SCRIPTENGINE = "SCRIPTENGINE";
    public static final String STYLEPARAM_CODENAMEMODE = "CODENAMEMODE";
    public static final String STYLEPARAM_MODELMEMO = "MODELMEMO";
    public static final String STYLEPARAM_SFPLUGINCODEFILE = "SFPLUGINCODEFILE";
    protected PSSysSFPub psSysSFPub = null;
    private String strBaseClassPKGCodeName = "";
    private String strPKGCodeName = "";
    private String strDestFile = null;
    private String strCodeName = null;
    private IPSSFStyle iPSSFStyle = null;
    private IPSSF iPSSF = null;
    private IPSSFStyleVer iPSSFStyleVer = null;
    private ArrayList<IPSSysSFUserCode> psSysSFUserCodeList = new ArrayList();
    private HashMap<String, IPSSysSFUserCode> psSysSFUserCodeMap = new HashMap();
    private ArrayList<IPSSysSFPubPkg> psSysSFPubPkgList = new ArrayList();
    private ArrayList<IPSSFPkgVer> psSFPkgVerList = new ArrayList();
    private String strSrvFolder = null;
    private IPSSFStyleParam iPSSFStyleParam = null;
    private Properties styleParamsMap = null;
    private boolean bDefaultFlag = false;
    private boolean bSubSysPackage = false;
    private String strVerStr = "1.0.0.0";
    private IPSSysSFPub mainPSSysSFPub = null;
    private ArrayList<IPSSysSFPub> partPSSysSFPubList = null;
    private boolean bDocPubMode = false;
    private String strContentType = "CODE";
    private boolean bCodePubMode = true;
    private boolean bTestCodePubMode = false;
    private boolean bCalcEnableGlobalTransaction = false;
    private boolean bEnableGlobalTransaction = false;
    private int nPubCodeLevel = 20;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysSFPub psSysSFPub) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysSFPub = psSysSFPub;
            this.setId(this.psSysSFPub.getPSSYSSFPUBID());
            this.setName(this.psSysSFPub.getPSSYSSFPUBNAME());
            ArrayList<PSDevSlnTempl> psDevSlnTemplList = ((IPSSystemRuntime)((Object)iPSSystem)).getPSDevSlnTemplList();
            if (psDevSlnTemplList != null && psDevSlnTemplList.size() > 0) {
                log.info((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u5b58\u5728\u5f00\u653e\u65b9\u6848\u6a21\u677f\u5b9a\u4e49"));
                String strPSDevSlnSysSrvId = KeyValueHelper.genUniqueId((String)iPSSystem.getPSDevSlnSysId(), (String)this.psSysSFPub.getPSSYSSFPUBID());
                for (PSDevSlnTempl psDevSlnTempl : psDevSlnTemplList) {
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDevSlnTempl.getPSDEVSLNSYSSRVID()) || SA.SRFramework.Utility.StringHelper.Compare((String)psDevSlnTempl.getPSDEVSLNSYSSRVID(), (String)strPSDevSlnSysSrvId, (boolean)true) != 0) continue;
                    log.info((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u66ff\u6362\u5f00\u653e\u65b9\u6848\u6a21\u677f\u5b9a\u4e49[%1$s]", (Object)psDevSlnTempl.getPSSFSTYLEID()));
                    psSysSFPub.setPSSFSTYLEID(psDevSlnTempl.getPSSFSTYLEID());
                    psSysSFPub.setPSSFSTYLENAME(psDevSlnTempl.getPSDEVSLNTEMPLNAME());
                }
            }
            this.setPSObjectData(this.psSysSFPub);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysSFPub.getPPSSYSSFPUBID())) {
                this.mainPSSysSFPub = this.getPSSystem().getPSSysSFPub(this.psSysSFPub.getPPSSYSSFPUBID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysSFPub.getCONTENTTYPE())) {
                this.strContentType = this.psSysSFPub.getCONTENTTYPE();
            }
            if ("DOC".equals(this.getContentType())) {
                this.bDocPubMode = true;
                this.bCodePubMode = false;
                this.bTestCodePubMode = false;
            } else if ("CODE".equals(this.getContentType())) {
                this.bCodePubMode = true;
                this.bDocPubMode = false;
                this.bTestCodePubMode = false;
            } else if ("TESTCODE".equals(this.getContentType())) {
                this.bTestCodePubMode = true;
                this.bCodePubMode = false;
                this.bDocPubMode = false;
            }
            if (this.getMainPSSysSFPub() == null) {
                if (!this.psSysSFPub.isSUBSYSPKGFLAGNull()) {
                    this.bSubSysPackage = this.psSysSFPub.getSUBSYSPKGFLAG();
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysSFPub.getVERSTR())) {
                    this.strVerStr = this.psSysSFPub.getVERSTR();
                }
                this.strPKGCodeName = this.psSysSFPub.getPKGCODENAME();
                this.strBaseClassPKGCodeName = this.psSysSFPub.getBASECLSPKGCODENAME();
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strBaseClassPKGCodeName)) {
                    if (iPSSystem.getPSSFId().indexOf("J2EE") == 0) {
                        this.strBaseClassPKGCodeName = "net.ibizsys";
                    } else if (iPSSystem.getPSSFId().indexOf("DOTNET") == 0) {
                        this.strBaseClassPKGCodeName = "IBizSys";
                    }
                }
                this.strCodeName = this.psSysSFPub.getCODENAME();
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                    this.strCodeName = this.strPKGCodeName;
                }
                if (this.isCodeMode()) {
                    this.iPSSF = this.getPSModelStorage().getPSSF(iPSSystem.getPSSFId());
                    this.strDestFile = iPSSystem.getPSSFId().indexOf("J2EE") == 0 ? String.valueOf(iPSSystem.getCodeName()) + "lib.jar" : (iPSSystem.getPSSFId().indexOf("DOTNET") == 0 ? String.valueOf(iPSSystem.getCodeName()) + "lib.dll" : "");
                } else {
                    this.iPSSF = this.getPSModelStorage().getPSSF("DOC");
                    this.strDestFile = "";
                }
                this.styleParamsMap = PropertiesHelper.Load((String)this.psSysSFPub.getSTYLEPARAMS());
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysSFPub.getPSSFSTYLEPARAMID())) {
                    this.iPSSFStyleParam = this.iPSSF.getPSSFStyleParam(this.psSysSFPub.getPSSFSTYLEPARAMID());
                }
                if (!this.psSysSFPub.isDEFAULTPUBNull()) {
                    this.bDefaultFlag = this.psSysSFPub.getDEFAULTPUB();
                }
                this.iPSSFStyle = this.getPSSystemUtil().getPSSFStyle(this.iPSSF.getId(), this.getSFStyle(), this.getCodeName());
                if (this.iPSSFStyle != null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysSFPub.getPSSFSTYLEVERID())) {
                    this.iPSSFStyleVer = this.iPSSFStyle.getPSSFStyleVer(this.psSysSFPub.getPSSFSTYLEVERID());
                }
                if (this.iPSSFStyle.getEnableWorkshopServer() == 3 && ((IPSSystemRuntime)((Object)this.getPSSystem())).getPSWorkshopServer() == null) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u7cfb\u7edf\u6307\u5b9a\u5de5\u7a0b\u670d\u52a1\u5668"));
                }
                if (this.iPSSFStyle.getEnableDeployCenter() == 3 && ((IPSSystemRuntime)((Object)this.getPSSystem())).getPSDeployCenter() == null) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u7cfb\u7edf\u6307\u5b9a\u90e8\u7f72\u4e2d\u5fc3"));
                }
            } else {
                if (!this.psSysSFPub.isSUBSYSPKGFLAGNull()) {
                    this.bSubSysPackage = this.psSysSFPub.getSUBSYSPKGFLAG();
                }
                this.strVerStr = this.getMainPSSysSFPub().getVersionString();
                this.strPKGCodeName = this.getMainPSSysSFPub().getPKGCodeName();
                this.strBaseClassPKGCodeName = this.getMainPSSysSFPub().getBaseClassPKGCodeName();
                this.strCodeName = this.psSysSFPub.getCODENAME();
                this.strDestFile = this.getMainPSSysSFPub().isCodeMode() ? (iPSSystem.getPSSFId().indexOf("J2EE") == 0 ? String.valueOf(iPSSystem.getCodeName()) + "-" + this.strCodeName + "lib.jar" : (iPSSystem.getPSSFId().indexOf("DOTNET") == 0 ? String.valueOf(iPSSystem.getCodeName()) + "-" + this.strCodeName + "lib.dll" : "")) : "";
                this.iPSSF = this.getMainPSSysSFPub().getPSSFStyle().getPSSF();
                this.styleParamsMap = PropertiesHelper.Load((String)this.psSysSFPub.getSTYLEPARAMS());
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysSFPub.getPSSFSTYLEPARAMID())) {
                    this.iPSSFStyleParam = this.iPSSF.getPSSFStyleParam(this.psSysSFPub.getPSSFSTYLEPARAMID());
                }
                this.iPSSFStyle = this.getMainPSSysSFPub().getPSSFStyle();
                this.iPSSFStyleVer = this.getMainPSSysSFPub().getPSSFStyleVer();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strDestFile)) {
                this.strDestFile = this.strDestFile.toLowerCase();
            }
            this.strSrvFolder = this.psSysSFPub.getPUBFOLDER();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strSrvFolder)) {
                this.strSrvFolder = this.strCodeName;
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        this.nPubCodeLevel = this.getStyleParam(STYLEPARAM_PUBCODELEVEL, 20);
        this.onPreparePSSysSFUserCodes();
        this.onPreparePSSysSFPubPkgs();
        super.onInit();
    }

    protected void onPreparePSSysSFUserCodes() throws Exception {
        this.psSysSFUserCodeList.clear();
        Vector<PSSysSFCode> psSysSFCodeList = new Vector<PSSysSFCode>();
        CallResult callResult = this.getPSModelHelper().getPSSysSFCodes(this.getId(), psSysSFCodeList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u81ea\u5b9a\u4e49\u4ee3\u7801\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysSFCode psSysSFCode : psSysSFCodeList) {
            PSSysSFUserCodeImpl iPSSysSFUserCode = new PSSysSFUserCodeImpl();
            iPSSysSFUserCode.init(this.getDAGlobalHelper(), this, psSysSFCode);
            this.psSysSFUserCodeList.add(iPSSysSFUserCode);
            this.psSysSFUserCodeMap.put(iPSSysSFUserCode.getId(), iPSSysSFUserCode);
        }
    }

    protected void onPreparePSSysSFPubPkgs() throws Exception {
        IPSSysSFPubPkg iPSSysSFPubPkg;
        this.psSysSFPubPkgList.clear();
        this.psSFPkgVerList.clear();
        Vector<PSSysSFPubPkg> psSysSFPubPkgList = new Vector<PSSysSFPubPkg>();
        CallResult callResult = this.getPSModelHelper().getPSSysSFPubPkgs(this.getId(), psSysSFPubPkgList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u670d\u52a1\u53d1\u5e03\u7ec4\u4ef6\u5305\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, IPSSysSFPubPkg> psSysSFPubPkgMap = new HashMap<String, IPSSysSFPubPkg>();
        final HashMap<String, Integer> psSysSFPubPkgOrderMap = new HashMap<String, Integer>();
        for (PSSysSFPubPkg psSysSFPubPkg : psSysSFPubPkgList) {
            iPSSysSFPubPkg = new PSSysSFPubPkgImpl();
            iPSSysSFPubPkg.init(this.getDAGlobalHelper(), this, psSysSFPubPkg);
            this.psSysSFPubPkgList.add(iPSSysSFPubPkg);
            if (iPSSysSFPubPkg.getPSSFPkg() == null) continue;
            psSysSFPubPkgMap.put(iPSSysSFPubPkg.getPSSFPkg().getId(), iPSSysSFPubPkg);
        }
        Iterator<IPSSFStylePkg> psSFStylePkgs = this.getPSSFStyle().getPSSFStylePkgs();
        if (psSFStylePkgs != null) {
            while (psSFStylePkgs.hasNext()) {
                IPSSFStylePkg iPSSFStylePkg = psSFStylePkgs.next();
                iPSSysSFPubPkg = (IPSSysSFPubPkg)psSysSFPubPkgMap.remove(iPSSFStylePkg.getPSSFPkgVer().getPSSFPkg().getId());
                if (iPSSysSFPubPkg != null) {
                    this.psSFPkgVerList.add(iPSSysSFPubPkg);
                    psSysSFPubPkgOrderMap.put(iPSSysSFPubPkg.getId(), iPSSysSFPubPkg.getOrderValue());
                    continue;
                }
                this.psSFPkgVerList.add(iPSSFStylePkg.getPSSFPkgVer());
                psSysSFPubPkgOrderMap.put(iPSSFStylePkg.getPSSFPkgVer().getId(), iPSSFStylePkg.getOrderValue());
            }
        }
        for (IPSSysSFPubPkg iPSSysSFPubPkg2 : this.psSysSFPubPkgList) {
            if (iPSSysSFPubPkg2.getPSSFPkg() != null) {
                IPSSysSFPubPkg iPSSysSFPubPkg22 = (IPSSysSFPubPkg)psSysSFPubPkgMap.remove(iPSSysSFPubPkg2.getPSSFPkg().getId());
                if (iPSSysSFPubPkg22 == null) continue;
                this.psSFPkgVerList.add(iPSSysSFPubPkg22);
                psSysSFPubPkgOrderMap.put(iPSSysSFPubPkg22.getId(), iPSSysSFPubPkg22.getOrderValue());
                continue;
            }
            this.psSFPkgVerList.add(iPSSysSFPubPkg2);
            psSysSFPubPkgOrderMap.put(iPSSysSFPubPkg2.getId(), iPSSysSFPubPkg2.getOrderValue());
        }
        Collections.sort(this.psSFPkgVerList, new Comparator<IPSSFPkgVer>(){

            @Override
            public int compare(IPSSFPkgVer o1, IPSSFPkgVer o2) {
                int nRet;
                Integer order1 = (Integer)psSysSFPubPkgOrderMap.get(o1.getId());
                Integer order2 = (Integer)psSysSFPubPkgOrderMap.get(o2.getId());
                if (order1 == null) {
                    order1 = PSSFStylePkgImpl.DEFAULTORDERVALUE;
                }
                if (order2 == null) {
                    order2 = PSSFStylePkgImpl.DEFAULTORDERVALUE;
                }
                if ((nRet = order1 - order2) == 0) {
                    return 0;
                }
                if (nRet > 0) {
                    return 1;
                }
                return -1;
            }
        });
    }

    @Override
    public String getSFStyle() {
        if (this.iPSSFStyle != null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.iPSSFStyle.getId())) {
            return this.iPSSFStyle.getId();
        }
        return this.psSysSFPub.getPSSFSTYLEID();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u5305\u540d")
    public String getPKGCodeName() {
        return this.strPKGCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u57fa\u7c7b\u4ee3\u7801\u5305\u540d", dump=false)
    public String getBaseClassPKGCodeName() {
        return this.strBaseClassPKGCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u751f\u4ea7\u76ee\u6807\u6587\u4ef6", debugmode=true, dump=false)
    public String getDestFile() {
        return this.strDestFile;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public IPSSFStyle getPSSFStyle() {
        return this.iPSSFStyle;
    }

    @Override
    public IPSSFStyleVer getPSSFStyleVer() {
        return this.iPSSFStyleVer;
    }

    @Override
    public String getModelType() {
        return "PSSYSSFPUB";
    }

    @Override
    public String getSFPubVersion() {
        return this.getVersionString();
    }

    @Override
    public Iterator<IPSSysSFUserCode> getPSSysSFUserCodes() {
        if (this.psSysSFUserCodeList.size() == 0) {
            return null;
        }
        return this.psSysSFUserCodeList.iterator();
    }

    @Override
    public String getSrvFolder() {
        return this.strSrvFolder;
    }

    @Override
    public IPSSysSFUserCode getPSSysSFUserCode(String strPSSysSFUserCodeId, boolean bTryMode) throws Exception {
        IPSSysSFUserCode iPSSysSFUserCode = this.psSysSFUserCodeMap.get(strPSSysSFUserCodeId);
        if (iPSSysSFUserCode == null) {
            if (bTryMode) {
                return null;
            }
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u540e\u53f0\u670d\u52a1\u7528\u6237\u81ea\u5b9a\u4e49\u4ee3\u7801\uff0c\u6807\u8bc6\u4e3a[%1$s]", (Object)strPSSysSFUserCodeId));
        }
        return iPSSysSFUserCode;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u53d1\u5e03\u7ec4\u4ef6\u5305\u96c6\u5408", child=true)
    public Iterator<IPSSysSFPubPkg> getPSSysSFPubPkgs() {
        if (this.psSysSFPubPkgList.size() == 0) {
            return null;
        }
        return this.psSysSFPubPkgList.iterator();
    }

    @Override
    public Iterator<IPSSFPkgVer> getPSSFPkgVers() {
        return this.psSFPkgVerList.iterator();
    }

    @Override
    public boolean isUseWorkshopServer() {
        if (this.getPSSFStyle().getEnableWorkshopServer() == 0) {
            return false;
        }
        return ((IPSSystemRuntime)((Object)this.getPSSystem())).getPSWorkshopServer() != null;
    }

    @Override
    public boolean isRemotePack() {
        if (this.getPSSFStyle().getEnableDeployCenter() == 0) {
            return false;
        }
        return ((IPSSystemRuntime)((Object)this.getPSSystem())).getPSDeployCenter() != null;
    }

    @Override
    public boolean isRemoteDeploy() {
        if (this.getPSSFStyle().getEnableDeployCenter() == 0) {
            return false;
        }
        return ((IPSSystemRuntime)((Object)this.getPSSystem())).getPSDeployCenter() != null;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u4e2d\u5fc3", debugmode=true)
    public IPSDeployCenter getPSDeployCenter() {
        return ((IPSSystemRuntime)((Object)this.getPSSystem())).getPSDeployCenter();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u7a0b\u670d\u52a1\u5668", debugmode=true)
    public IPSWorkshopServer getPSWorkshopServer() {
        return ((IPSSystemRuntime)((Object)this.getPSSystem())).getPSWorkshopServer();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u7a0b\u670d\u52a1\u5668Git\u914d\u7f6e", debugmode=true)
    public IPSDevSlnSysWSGit getPSDevSlnSysWSGit() {
        return ((IPSSystemRuntime)((Object)this.getPSSystem())).getPSDevSlnSysWSGit();
    }

    @Override
    public IPSSF getPSSF() {
        return this.iPSSF;
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSF iPSSF, PSSFStyleParam psSFStyleParam) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSSFStyleParam getPSSFStyleParam() {
        return this;
    }

    @Override
    public String getStyleParam(String strParamName, String strDefault) {
        if (this.styleParamsMap.containsKey(strParamName)) {
            return PropertiesHelper.GetProperty((Properties)this.styleParamsMap, (String)strParamName, (String)strDefault);
        }
        if (this.iPSSFStyleParam != null) {
            return this.iPSSFStyleParam.getStyleParam(strParamName, strDefault);
        }
        return strDefault;
    }

    @Override
    public int getStyleParam(String strParamName, int nDefault) {
        if (this.styleParamsMap.containsKey(strParamName)) {
            return PropertiesHelper.GetProperty((Properties)this.styleParamsMap, (String)strParamName, (int)nDefault);
        }
        if (this.iPSSFStyleParam != null) {
            return this.iPSSFStyleParam.getStyleParam(strParamName, nDefault);
        }
        return nDefault;
    }

    @Override
    public boolean containsStyleParam(String strParamName) {
        if (this.styleParamsMap.containsKey(strParamName)) {
            return true;
        }
        if (this.iPSSFStyleParam != null) {
            return this.iPSSFStyleParam.containsStyleParam(strParamName);
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u53d1\u5e03", group="\u57fa\u672c", order=123)
    public boolean getDefaultFlag() {
        return this.bDefaultFlag;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u5b50\u7cfb\u7edf\u7ec4\u4ef6\u5305", ignoredumpvalues="false")
    public boolean isSubSysPackage() {
        return this.bSubSysPackage;
    }

    @Override
    @PSModelRTMeta(description="\u7ec4\u4ef6\u7248\u672c")
    public String getVersionString() {
        return this.strVerStr;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u7cfb\u7edf\u540e\u53f0\u4f53\u7cfb", hideempty=true)
    public IPSSysSFPub getMainPSSysSFPub() {
        return this.mainPSSysSFPub;
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u540e\u53f0\u53d1\u5e03", hideempty=true)
    public Iterator<IPSSysSFPub> getPartPSSysSFPubs() throws Exception {
        if (this.getMainPSSysSFPub() != null) {
            return null;
        }
        if (this.partPSSysSFPubList == null) {
            ArrayList<IPSSysSFPub> partPSSysSFPubList = new ArrayList<IPSSysSFPub>();
            Iterator<IPSSysSFPub> psSysSFPubs = this.getPSSystem().getAllPSSysSFPubs();
            while (psSysSFPubs.hasNext()) {
                IPSSysSFPub iPSSysSFPub = psSysSFPubs.next();
                if (iPSSysSFPub.getMainPSSysSFPub() == null || SA.SRFramework.Utility.StringHelper.Compare((String)this.getId(), (String)iPSSysSFPub.getMainPSSysSFPub().getId(), (boolean)false) != 0) continue;
                partPSSysSFPubList.add(iPSSysSFPub);
            }
            if (this.partPSSysSFPubList == null) {
                this.partPSSysSFPubList = partPSSysSFPubList;
            }
        }
        return this.partPSSysSFPubList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u540e\u53f0\u4f53\u7cfb", ignoredumpvalues="false")
    public boolean isMainPSSysSFPub() {
        return this.mainPSSysSFPub == null;
    }

    @Override
    @PSModelRTMeta(description="\u53d1\u5e03\u6587\u6863\u6a21\u5f0f", ignoredumpvalues="false")
    public boolean isDocMode() {
        return this.bDocPubMode;
    }

    @Override
    @PSModelRTMeta(description="\u53d1\u5e03\u5185\u5bb9\u6a21\u5f0f", codelist="SysSFPubContentType", group="\u57fa\u672c", order=125)
    public String getContentType() {
        return this.strContentType;
    }

    @Override
    @PSModelRTMeta(description="\u53d1\u5e03\u4ee3\u7801\u6a21\u5f0f", ignoredumpvalues="false")
    public boolean isCodeMode() {
        return this.bCodePubMode;
    }

    @Override
    @PSModelRTMeta(description="\u53d1\u5e03\u6d4b\u8bd5\u4ee3\u7801\u6a21\u5f0f", ignoredumpvalues="false")
    public boolean isTestCodeMode() {
        return this.bTestCodePubMode;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5168\u5c40\u4e8b\u52a1", dump=false)
    public boolean isEnableGlobalTransaction() {
        if (!this.isCodeMode()) {
            return false;
        }
        return this.calcEnableGlobalTransaction();
    }

    protected boolean calcEnableGlobalTransaction() {
        if (!this.bCalcEnableGlobalTransaction) {
            block7: {
                try {
                    Iterator<IPSDataEntity> psDataEntities = this.getPSSystem().getAllPSDataEntities();
                    if (psDataEntities == null) break block7;
                    while (psDataEntities.hasNext()) {
                        IPSDataEntity iPSDataEntity = psDataEntities.next();
                        if (iPSDataEntity.getPSSysSFPub() != null && SA.SRFramework.Utility.StringHelper.Compare((String)iPSDataEntity.getPSSysSFPub().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                        Iterator<IPSDEAction> psDEActions = iPSDataEntity.getAllPSDEActions();
                        if (psDEActions != null) {
                            while (psDEActions.hasNext()) {
                                IPSDEAction iPSDEAction = psDEActions.next();
                                if (!iPSDEAction.isValid() || SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEAction.getTransactionMode(), (String)"GLOBAL", (boolean)false) != 0) continue;
                                this.bEnableGlobalTransaction = true;
                                break;
                            }
                        }
                        if (!this.bEnableGlobalTransaction) {
                            continue;
                        }
                        break;
                    }
                }
                catch (Exception e) {
                    log.error((Object)e);
                }
            }
            this.bCalcEnableGlobalTransaction = true;
        }
        return this.bEnableGlobalTransaction;
    }

    @Override
    @PSModelRTMeta(description="\u53d1\u5e03\u6a21\u578b", ignoredumpvalues="false")
    public boolean isPubModel() {
        if (!this.isCodeMode() || !this.getDefaultFlag()) {
            return false;
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysSFPub.getDYNAMODELMODE())) {
            return SA.SRFramework.Utility.StringHelper.Compare((String)this.psSysSFPub.getDYNAMODELMODE(), (String)"NONE", (boolean)false) != 0;
        }
        String strRet = this.getStyleParam(STYLEPARAM_PUBMODEL, "");
        return strRet.compareToIgnoreCase("TRUE") == 0;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6a21\u578b\u8fd0\u884c\u65f6", ignoredumpvalues="false")
    public boolean isEnableModelRT() {
        String strRet;
        if (!this.isPubModel()) {
            return false;
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysSFPub.getDYNAMODELMODE())) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.psSysSFPub.getDYNAMODELMODE(), (String)"RUNTIME", (boolean)false) == 0) {
                return true;
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.psSysSFPub.getDYNAMODELMODE(), (String)"GENCODE", (boolean)false) == 0) {
                return true;
            }
        }
        return (strRet = this.getStyleParam(STYLEPARAM_PUBMODEL, "")).compareToIgnoreCase("TRUE") == 0;
    }

    @Override
    @PSModelRTMeta(description="\u53d1\u5e03\u751f\u6210\u4ee3\u7801\u6a21\u578b", dump=false)
    public boolean isPubGenCodeModel() {
        if (!this.isPubModel()) {
            return false;
        }
        return !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysSFPub.getDYNAMODELMODE()) && SA.SRFramework.Utility.StringHelper.Compare((String)this.psSysSFPub.getDYNAMODELMODE(), (String)"GENCODE", (boolean)false) == 0;
    }

    @Override
    @PSModelRTMeta(description="\u53d1\u5e03\u6a21\u578b\u5907\u6ce8", dump=false)
    public boolean isPubModelMemo() {
        String strRet = this.getStyleParam(STYLEPARAM_MODELMEMO, "");
        return strRet.compareToIgnoreCase("TRUE") == 0;
    }

    @Override
    @PSModelRTMeta(description="\u53d1\u5e03\u540e\u53f0\u63d2\u4ef6\u4ee3\u7801\u6587\u4ef6", dump=false)
    public boolean isPubSFPluginCodeFile() {
        String strRet = this.getStyleParam(STYLEPARAM_SFPLUGINCODEFILE, "");
        return strRet.compareToIgnoreCase("TRUE") == 0;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u76ee\u5f55")
    public String getModelFolder() {
        String strModelFolder;
        String strDefaultFolder = "model";
        if (this.getPSSFStyle() != null) {
            strDefaultFolder = this.getPSSFStyle().getStyleParam("%MODELFOLDER%", strDefaultFolder);
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strModelFolder = this.getStyleParam(STYLEPARAM_MODELFOLDER, strDefaultFolder))) && strModelFolder.indexOf("${") != -1) {
            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("item", this);
            params.put("sys", this.getPSSystem());
            params.put("pub", this);
            BaseDataEntity modelDataEntity = new BaseDataEntity();
            modelDataEntity.set("CODE", (Object)strModelFolder);
            try {
                return PSTemplHelper.generateCode(modelDataEntity, "CODE", params);
            }
            catch (Exception e) {
                log.error((Object)e);
                return "model";
            }
        }
        return strModelFolder;
    }

    @Override
    @PSModelRTMeta(description="Groovy\u6e90\u4ee3\u7801\u76ee\u5f55")
    public String getGroovySourceFolder() {
        String strGroovyFolder;
        String strDefaultFolder = "";
        if (this.getPSSFStyle() != null) {
            strDefaultFolder = this.getPSSFStyle().getStyleParam("%GROOVYFOLDER%", strDefaultFolder);
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strGroovyFolder = this.getStyleParam(STYLEPARAM_GROOVYFOLDER, strDefaultFolder))) && strGroovyFolder.indexOf("${") != -1) {
            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("item", this);
            params.put("sys", this.getPSSystem());
            params.put("pub", this);
            BaseDataEntity modelDataEntity = new BaseDataEntity();
            modelDataEntity.set("CODE", (Object)strGroovyFolder);
            try {
                return PSTemplHelper.generateCode(modelDataEntity, "CODE", params);
            }
            catch (Exception e) {
                log.error((Object)e);
                return "";
            }
        }
        return strGroovyFolder;
    }

    @Override
    @PSModelRTMeta(description="\u53d1\u5e03\u4ee3\u7801\u7ea7\u522b", dump=false)
    public int getPubCodeLevel() {
        return this.nPubCodeLevel;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u811a\u672c\u5f15\u64ce", dump=false)
    public String getScriptEngine() {
        return this.getStyleParam(STYLEPARAM_SCRIPTENGINE, null);
    }

    @Override
    @PSModelRTMeta(description="API\u4ee3\u7801\u6807\u8bc6\u6a21\u5f0f", dump=false)
    public String getAPICodeNameMode() {
        return this.getStyleParam(STYLEPARAM_CODENAMEMODE, null);
    }
}

