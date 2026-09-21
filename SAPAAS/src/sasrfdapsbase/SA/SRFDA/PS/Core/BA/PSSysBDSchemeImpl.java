/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psba.core.IBATable
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSBDTable;
import SA.SRFDA.PS.Core.BA.IPSSysBDModule;
import SA.SRFDA.PS.Core.BA.IPSSysBDPart;
import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.BA.IPSSysBDTableRS;
import SA.SRFDA.PS.Core.BA.PSSysBDModuleGlobalModel;
import SA.SRFDA.PS.Core.BA.PSSysBDPartGlobalModel;
import SA.SRFDA.PS.Core.BA.PSSysBDTableGlobalModel;
import SA.SRFDA.PS.Core.BA.PSSysBDTableRSGlobalModel;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.System.IPSSysModelGroup;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysBDScheme;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psba.core.IBATable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBDSchemeImpl
extends PSSystemObjectImpl
implements IPSSysBDScheme {
    private static final Log log = LogFactory.getLog(PSSysBDSchemeImpl.class);
    protected PSSysBDScheme psSysBDScheme = null;
    private String strBDType = "";
    private String strCodeName = "";
    private PSSysBDModuleGlobalModel psSysBDModuleGlobalModel = new PSSysBDModuleGlobalModel();
    private PSSysBDPartGlobalModel psSysBDPartGlobalModel = new PSSysBDPartGlobalModel();
    private PSSysBDTableGlobalModel psSysBDTableGlobalModel = new PSSysBDTableGlobalModel();
    private PSSysBDTableRSGlobalModel psSysBDTableRSGlobalModel = new PSSysBDTableRSGlobalModel();
    private ArrayList<String> bdTypeList = new ArrayList();
    private boolean bDefaultMode = false;
    private String strRowKeySeparator = "||";
    private int nLoadedLevel = IPSSystem.LOADLEVEL_NONE;
    private int nLoadingLevel = IPSSystem.LOADLEVEL_NONE;
    private IPSSystemModule iPSSystemModule = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private IPSSysModelGroup iPSSysModelGroup = null;
    private String strServicePath = null;
    private String strServiceParam = null;
    private String strServiceParam2 = null;
    private String strAuthMode = "NONE";
    private String strAuthClientId = null;
    private String strAuthClientSecret = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysBDScheme psSysBDScheme) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysBDScheme = psSysBDScheme;
            this.setId(this.psSysBDScheme.getPSSYSBDSCHEMEID());
            this.setName(this.psSysBDScheme.getPSSYSBDSCHEMENAME());
            this.setPSObjectData(this.psSysBDScheme);
            this.strBDType = this.psSysBDScheme.getBDTYPE();
            this.strCodeName = this.psSysBDScheme.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = iPSSystem.getCodeName();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysBDScheme.getPSSYSMODELGROUPID())) {
                this.iPSSysModelGroup = this.getPSSystem().getPSSysModelGroup(this.psSysBDScheme.getPSSYSMODELGROUPID());
            } else if (!StringHelper.isNullOrEmpty((String)this.psSysBDScheme.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysBDScheme.getPSMODULEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysBDScheme.getBDTYPES())) {
                String[] bdTypes;
                String[] stringArray = bdTypes = this.psSysBDScheme.getBDTYPES().split("[;]");
                int n = bdTypes.length;
                int n2 = 0;
                while (n2 < n) {
                    String strType = stringArray[n2];
                    if (!StringHelper.isNullOrEmpty((String)strType) && !StringHelper.isNullOrEmpty((String)(strType = strType.trim()))) {
                        this.bdTypeList.add(strType);
                    }
                    ++n2;
                }
                if (StringHelper.isNullOrEmpty((String)this.strBDType) && this.bdTypeList.size() == 0) {
                    this.strBDType = this.bdTypeList.get(0);
                }
            } else if (!StringHelper.isNullOrEmpty((String)this.strBDType)) {
                this.bdTypeList.add(this.strBDType);
            }
            if (!this.psSysBDScheme.isDEFAULTFLAGNull()) {
                this.bDefaultMode = this.psSysBDScheme.getDEFAULTFLAG();
            } else if (StringHelper.compare((String)this.psSysBDScheme.getPSSYSBDSCHEMEID(), (String)iPSSystem.getId(), (boolean)false) == 0) {
                this.bDefaultMode = true;
            }
            this.strAuthMode = this.psSysBDScheme.getAUTHMODE();
            this.strAuthClientId = this.psSysBDScheme.getAUTHCLIENTID();
            this.strAuthClientSecret = this.psSysBDScheme.getAUTHCLIENTSECRET();
            this.strServicePath = this.psSysBDScheme.getSERVICEPATH();
            this.strServiceParam = this.psSysBDScheme.getSERVICEPARAM();
            this.strServiceParam2 = this.psSysBDScheme.getSERVICEPARAM2();
            this.psSysBDModuleGlobalModel.Init(this.getDAGlobalHelper(), this);
            this.psSysBDPartGlobalModel.Init(this.getDAGlobalHelper(), this);
            this.psSysBDTableGlobalModel.Init(this.getDAGlobalHelper(), this);
            this.psSysBDTableRSGlobalModel.Init(this.getDAGlobalHelper(), this);
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
        String strPSSysSFPluginId = this.psSysBDScheme.getPSSYSSFPLUGINID();
        if (!StringHelper.isNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        super.onInit();
        this.psSysBDModuleGlobalModel.getAllModelHelpers();
        this.psSysBDPartGlobalModel.getAllModelHelpers();
        this.psSysBDTableGlobalModel.getAllModelHelpers();
        this.psSysBDTableRSGlobalModel.getAllModelHelpers();
    }

    @Override
    public String getModelType() {
        return "PSSYSBDSCHEME";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u5927\u6570\u636e\u5e93\u7c7b\u578b", codelist="BDType")
    public String getBDType() {
        return this.strBDType;
    }

    @Override
    @PSModelRTMeta(description="\u5927\u6570\u636e\u4f53\u7cfb\u5206\u533a\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysBDPart> getAllPSSysBDParts() throws Exception {
        return this.psSysBDPartGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysBDPart getPSSysBDPart(String strSysBDPartId) throws Exception {
        return (IPSSysBDPart)this.psSysBDPartGlobalModel.FindModelHelper(strSysBDPartId);
    }

    @Override
    public void resetPSSysBDPart(String strSysBDPartId) throws Exception {
        this.psSysBDPartGlobalModel.ResetModel(strSysBDPartId);
    }

    @Override
    public void resetAllPSSysBDParts() {
        this.psSysBDPartGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u5927\u6570\u636e\u4f53\u7cfb\u6a21\u5757\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysBDModule> getAllPSSysBDModules() throws Exception {
        return this.psSysBDModuleGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysBDModule getPSSysBDModule(String strSysBDModuleId) throws Exception {
        return (IPSSysBDModule)this.psSysBDModuleGlobalModel.FindModelHelper(strSysBDModuleId);
    }

    @Override
    public void resetPSSysBDModule(String strSysBDModuleId) throws Exception {
        this.psSysBDModuleGlobalModel.ResetModel(strSysBDModuleId);
    }

    @Override
    public void resetAllPSSysBDModules() {
        this.psSysBDModuleGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u5927\u6570\u636e\u8868\u96c6\u5408", child=true, dynamodelmode=4, group="\u57fa\u672c", order=140)
    public Iterator<? extends IPSSysBDTable> getAllPSSysBDTables() throws Exception {
        return this.psSysBDTableGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysBDTable getPSSysBDTable(String strSysBDTableId) throws Exception {
        return (IPSSysBDTable)this.psSysBDTableGlobalModel.FindModelHelper(strSysBDTableId);
    }

    @Override
    public void resetPSSysBDTable(String strSysBDTableId) throws Exception {
        this.psSysBDTableGlobalModel.ResetModel(strSysBDTableId);
    }

    @Override
    public void resetAllPSSysBDTables() {
        this.psSysBDTableGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u5927\u6570\u636e\u8868\u5173\u7cfb\u96c6\u5408", child=true, ignorert=3)
    public Iterator<? extends IPSSysBDTableRS> getAllPSSysBDTableRSs() throws Exception {
        return this.psSysBDTableRSGlobalModel.getAllModelHelpers();
    }

    @Override
    public Iterator<IPSSysBDTableRS> getAllPSSysBDTableRSes() throws Exception {
        return this.psSysBDTableRSGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysBDTableRS getPSSysBDTableRS(String strSysBDTableRSId) throws Exception {
        return (IPSSysBDTableRS)this.psSysBDTableRSGlobalModel.FindModelHelper(strSysBDTableRSId);
    }

    @Override
    public void resetPSSysBDTableRS(String strSysBDTableRSId) throws Exception {
        this.psSysBDTableRSGlobalModel.ResetModel(strSysBDTableRSId);
    }

    @Override
    public void resetAllPSSysBDTableRSs() {
        this.psSysBDTableRSGlobalModel.ResetAll();
    }

    @Override
    public void resetAllPSSysBDTableRSes() {
        this.psSysBDTableRSGlobalModel.ResetAll();
    }

    public Iterator<IBATable> getBATables() {
        return null;
    }

    public IBATable getBATable(String strName, boolean bTryMode) throws Exception {
        return null;
    }

    @Override
    public String getShortCodeName() {
        return this.getCodeName();
    }

    @Override
    public Iterator<String> getBDTypes() {
        return this.bdTypeList.iterator();
    }

    @Override
    public boolean isDefault() {
        return this.isDefaultMode();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5927\u6570\u636e\u4f53\u7cfb", ignoredumpvalues="false")
    public boolean isDefaultMode() {
        return this.bDefaultMode;
    }

    @Override
    public IPSSysBDTable getPSSysBDTable(String strSysBDTableId, boolean bTryMode) throws Exception {
        return (IPSSysBDTable)this.psSysBDTableGlobalModel.FindModelHelper(strSysBDTableId, bTryMode);
    }

    @Override
    public String getRowKeySeparator() {
        return this.strRowKeySeparator;
    }

    @Override
    public void load(int nLoadLevel) throws Exception {
        try {
            this.nLoadingLevel = nLoadLevel;
            this.getAllPSSysBDModules();
            this.getAllPSSysBDParts();
            Iterator<? extends IPSSysBDTable> psSysBDTables = this.getAllPSSysBDTables();
            while (psSysBDTables.hasNext()) {
                IPSSysBDTable iPSSysBDTable = psSysBDTables.next();
                iPSSysBDTable.load(nLoadLevel);
            }
            this.getAllPSSysBDTableRSes();
            this.nLoadedLevel = nLoadLevel;
        }
        catch (Exception ex) {
            this.getPSSystemUtil().log(1, this, ex.getMessage());
            throw ex;
        }
    }

    @Override
    public int getLoadedLevel() {
        return this.nLoadedLevel;
    }

    @Override
    public int getLoadingLevel() {
        return this.nLoadingLevel;
    }

    @Override
    public IPSSysBDTableRS getPSSysBDTableRS(String strSysBDTableRSId, boolean bTryMode) throws Exception {
        return (IPSSysBDTableRS)this.psSysBDTableRSGlobalModel.FindModelHelper(strSysBDTableRSId, bTryMode);
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4)
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }

    @Override
    public Iterator<? extends IPSBDTable> getAllPSBDTables() throws Exception {
        return this.getAllPSSysBDTables();
    }

    @Override
    public IPSBDTable getPSBDTable(String strBDTableId) throws Exception {
        return (IPSBDTable)this.psSysBDTableGlobalModel.FindModelHelper(strBDTableId);
    }

    @Override
    public IPSBDTable getPSBDTable(String strBDTableId, boolean bTryMode) throws Exception {
        return (IPSBDTable)this.psSysBDTableGlobalModel.FindModelHelper(strBDTableId, bTryMode);
    }

    @Override
    @PSModelRTMeta(description="\u4f53\u7cfb\u6807\u8bb0", hideempty2=true)
    public String getSchemeTag() {
        return this.psSysBDScheme.getSCHEMETAG();
    }

    @Override
    @PSModelRTMeta(description="\u4f53\u7cfb\u6807\u8bb02", hideempty2=true)
    public String getSchemeTag2() {
        return this.psSysBDScheme.getSCHEMETAG2();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u8def\u5f84", fields={"SERVICEPATH"})
    public String getServicePath() {
        return this.strServicePath;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u53c2\u6570", fields={"SERVICEPARAM"})
    public String getServiceParam() {
        return this.strServiceParam;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u53c2\u65702", fields={"SERVICEPARAM2"})
    public String getServiceParam2() {
        return this.strServiceParam2;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u6a21\u5f0f", codelist="APIAuthMode", fields={"AUTHMODE"})
    public String getAuthMode() {
        return this.strAuthMode;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u5ba2\u6237\u7aef\u6807\u8bc6", fields={"AUTHCLIENTID"})
    public String getAuthClientId() {
        return this.strAuthClientId;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u5ba2\u6237\u7aef\u5bc6\u7801", fields={"AUTHCLIENTSECRET"})
    public String getAuthClientSecret() {
        return this.strAuthClientSecret;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u6570", fields={"AUTHPARAM"})
    public String getAuthParam() {
        return this.psSysBDScheme.getAUTHPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u65702", fields={"AUTHPARAM2"})
    public String getAuthParam2() {
        return this.psSysBDScheme.getAUTHPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u578b\u7ec4", dumpref=true, dynamodelmode=4)
    public IPSSysModelGroup getPSSysModelGroup() {
        return this.iPSSysModelGroup;
    }

    @Override
    @PSModelRTMeta(description="\u5bf9\u8c61\u540d\u79f0\u8f6c\u5316", codelist="DBObjNameCaseMode", fields={"OBJNAMECASE"})
    public String getDBObjNameCase() {
        return this.psSysBDScheme.getOBJNAMECASE();
    }

    @Override
    public String getAuthAccessTokenUrl() {
        return null;
    }

    @Override
    public int getAuthTimeout() {
        return 0;
    }
}

