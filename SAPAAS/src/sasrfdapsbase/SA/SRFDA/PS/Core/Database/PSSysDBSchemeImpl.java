/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.Database.IPSSysDBSchemeRuntime;
import SA.SRFDA.PS.Core.Database.IPSSysDBTable;
import SA.SRFDA.PS.Core.Database.IPSSysDBTableRuntime;
import SA.SRFDA.PS.Core.Database.PSSysDBTableGlobalModel;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
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
import SA.SRFDA.PS.Data.PSSysDBScheme;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSSysDBSchemeImpl
extends PSSystemObjectImpl
implements IPSSysDBScheme,
IPSSysDBSchemeRuntime {
    private static final Log log = LogFactory.getLog(PSSysDBSchemeImpl.class);
    protected PSSysDBScheme psSysDBScheme = null;
    private String strCodeName = "";
    private String strCodeName2 = "";
    private PSSysDBTableGlobalModel psSysDBTableGlobalModel = new PSSysDBTableGlobalModel();
    private int nLoadedLevel = IPSSystem.LOADLEVEL_NONE;
    private int nLoadingLevel = IPSSystem.LOADLEVEL_NONE;
    private IPSSystemModule iPSSystemModule = null;
    private boolean bExistingModel = false;
    private boolean bAutoExtendModel = true;
    private IPSSysModelGroup iPSSysModelGroup = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private Properties schemeParams = null;
    private String strServicePath = null;
    private String strServiceParam = null;
    private String strServiceParam2 = null;
    private String strAuthMode = "NONE";
    private String strAuthClientId = null;
    private String strAuthClientSecret = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysDBScheme psSysDBScheme) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysDBScheme = psSysDBScheme;
            this.setId(this.psSysDBScheme.getPSSYSDBSCHEMEID());
            this.setName(this.psSysDBScheme.getPSSYSDBSCHEMENAME());
            this.setPSObjectData(this.psSysDBScheme);
            this.strCodeName = this.psSysDBScheme.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.psSysDBScheme.getDSLINK();
            }
            this.strCodeName2 = this.psSysDBScheme.getCODENAME2();
            if (!StringHelper.isNullOrEmpty((String)this.psSysDBScheme.getPSSYSMODELGROUPID())) {
                this.iPSSysModelGroup = this.getPSSystem().getPSSysModelGroup(this.psSysDBScheme.getPSSYSMODELGROUPID());
            } else if (!StringHelper.isNullOrEmpty((String)this.psSysDBScheme.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysDBScheme.getPSMODULEID());
            }
            if (!this.psSysDBScheme.isEXISTINGMODELNull()) {
                this.bExistingModel = this.psSysDBScheme.getEXISTINGMODEL();
            }
            if (!this.psSysDBScheme.isAUTOEXTENDMODELNull()) {
                this.bAutoExtendModel = this.psSysDBScheme.getAUTOEXTENDMODEL();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysDBScheme.getSCHEMEPARAMS())) {
                this.schemeParams = PropertiesHelper.load((String)this.psSysDBScheme.getSCHEMEPARAMS());
            }
            this.strAuthMode = this.psSysDBScheme.getAUTHMODE();
            this.strAuthClientId = this.psSysDBScheme.getAUTHCLIENTID();
            this.strAuthClientSecret = this.psSysDBScheme.getAUTHCLIENTSECRET();
            this.strServicePath = this.psSysDBScheme.getSERVICEPATH();
            this.strServiceParam = this.psSysDBScheme.getSERVICEPARAM();
            this.strServiceParam2 = this.psSysDBScheme.getSERVICEPARAM2();
            this.psSysDBTableGlobalModel.Init(this.getDAGlobalHelper(), this);
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
        String strPSSysSFPluginId = this.psSysDBScheme.getPSSYSSFPLUGINID();
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
        this.psSysDBTableGlobalModel.getAllModelHelpers();
    }

    @Override
    protected int onCheck() throws Exception {
        this.psSysDBTableGlobalModel.checkAll();
        return super.onCheck();
    }

    @Override
    public String getModelType() {
        return "PSSYSDBSCHEME";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty=true, fields={"CODENAME2"})
    public String getCodeName2() {
        return this.strCodeName2;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8868\u96c6\u5408", child=true, rtname="getTables", dynamodelmode=4, group="\u57fa\u672c", order=140)
    public Iterator<IPSSysDBTable> getAllPSSysDBTables() throws Exception {
        return this.psSysDBTableGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysDBTable getPSSysDBTable(String strSysDBTableId) throws Exception {
        return (IPSSysDBTable)this.psSysDBTableGlobalModel.FindModelHelper(strSysDBTableId);
    }

    @Override
    public void resetPSSysDBTable(String strSysDBTableId) throws Exception {
        this.psSysDBTableGlobalModel.ResetModel(strSysDBTableId);
    }

    @Override
    public void resetAllPSSysDBTables() {
        this.psSysDBTableGlobalModel.ResetAll();
    }

    @Override
    public IPSSysDBTable getPSSysDBTable(String strSysDBTableId, boolean bTryMode) throws Exception {
        return (IPSSysDBTable)this.psSysDBTableGlobalModel.FindModelHelper(strSysDBTableId, bTryMode);
    }

    @Override
    public void load(int nLoadLevel) throws Exception {
        try {
            this.nLoadingLevel = nLoadLevel;
            Iterator<IPSSysDBTable> psSysDBTables = this.getAllPSSysDBTables();
            while (psSysDBTables.hasNext()) {
                IPSSysDBTable iPSSysDBTable = psSysDBTables.next();
                iPSSysDBTable.load(nLoadLevel);
            }
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
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4, outputdoc="false", fields={"PSMODULEID"})
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
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6570\u636e\u6e90", codelist="SysDeployDBMode", group="\u57fa\u672c", order=105, fields={"DSLINK"})
    public String getDSLink() {
        return this.psSysDBScheme.getDSLINK();
    }

    @Override
    @PSModelRTMeta(description="\u4f53\u7cfb\u6807\u8bb0", hideempty2=true, fields={"SCHEMETAG"})
    public String getSchemeTag() {
        return this.psSysDBScheme.getSCHEMETAG();
    }

    @Override
    @PSModelRTMeta(description="\u4f53\u7cfb\u6807\u8bb02", hideempty2=true, fields={"SCHEMETAG2"})
    public String getSchemeTag2() {
        return this.psSysDBScheme.getSCHEMETAG2();
    }

    @Override
    @PSModelRTMeta(description="\u73b0\u6709\u6570\u636e\u7ed3\u6784", ignoredumpvalues="false", fields={"EXISTINGMODEL"})
    public boolean isExistingModel() {
        return this.bExistingModel;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u52a8\u6269\u5c55\u7ed3\u6784", ignoredumpvalues="false", fields={"AUTOEXTENDMODEL"})
    public boolean isAutoExtendModel() {
        return this.bAutoExtendModel;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u578b\u7ec4", dumpref=true, dynamodelmode=4, fields={"PSSYSMODELGROUPID"})
    public IPSSysModelGroup getPSSysModelGroup() {
        return this.iPSSysModelGroup;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true, fields={"PSSYSSFPLUGINID"})
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }

    @Override
    protected String onGetDynaModelTag() {
        return this.getDSLink();
    }

    @Override
    @PSModelRTMeta(description="SaaS\u6570\u636e\u4e3b\u952e\u5217", dynamodelmode=4)
    public String getSaaSDataIdColumnName() {
        return PropertiesHelper.getProperty((Properties)this.getSchemeParams(), (String)"SAAS.IDCOLUMN", null);
    }

    @Override
    @PSModelRTMeta(description="SaaS\u6570\u636e\u79df\u6237\u5217", dynamodelmode=4)
    public String getSaaSDCIdColumnName() {
        return PropertiesHelper.getProperty((Properties)this.getSchemeParams(), (String)"SAAS.DCCOLUMN", null);
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u5b9e\u4f8b\u6807\u8bb0", dynamodelmode=4)
    public String getDBInstTag() {
        String strDefaultName = null;
        if (this.getPSSystem().getDefaultPSSystemDBConfig() != null) {
            strDefaultName = this.getPSSystem().getDefaultPSSystemDBConfig().getPSDCDBDevInstName();
        }
        return PropertiesHelper.getProperty((Properties)this.getSchemeParams(), (String)"DBINST.TAG", (String)strDefaultName);
    }

    public Properties getSchemeParams() {
        return this.schemeParams;
    }

    @Override
    public void registerPSDataEntity(IPSDataEntity iPSDataEntity) throws Exception {
        if (this.isExistingModel() || !iPSDataEntity.isEnableSQLStorage()) {
            return;
        }
        String strTableName = iPSDataEntity.getTableName();
        if (StringHelper.isNullOrEmpty((String)strTableName)) {
            return;
        }
        IPSSysDBTable iPSSysDBTable = this.getPSSysDBTable(strTableName, true);
        if (iPSSysDBTable == null) {
            return;
        }
        if (iPSSysDBTable instanceof IPSSysDBTableRuntime) {
            ((IPSSysDBTableRuntime)((Object)iPSSysDBTable)).registerPSDataEntity(iPSDataEntity);
        }
    }

    @Override
    @PSModelRTMeta(description="\u53d1\u5e03\u7d22\u5f15", ignoredumpvalues="false")
    public boolean isPubIndex() {
        boolean bPubIndex = true;
        if (this.getPSSystem().getDefaultPSSystemDBConfig() != null) {
            bPubIndex = this.getPSSystem().getDefaultPSSystemDBConfig().isPubIndex();
        }
        return PropertiesHelper.getProperty((Properties)this.getSchemeParams(), (String)"PUBINDEX", (boolean)bPubIndex);
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5916\u952e\u7d22\u5f15", ignoredumpvalues="false", dump=false)
    public boolean isEnableFKeyIndex() {
        return PropertiesHelper.getProperty((Properties)this.getSchemeParams(), (String)"INDEX.FKEY", (boolean)true);
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u79df\u6237\u5217\u7d22\u5f15", ignoredumpvalues="false", dump=false)
    public boolean isEnableSaaSDCIdIndex() {
        return PropertiesHelper.getProperty((Properties)this.getSchemeParams(), (String)"INDEX.SAASDCID", (boolean)true);
    }

    @Override
    @PSModelRTMeta(description="\u5bf9\u8c61\u540d\u79f0\u8f6c\u5316", codelist="DBObjNameCaseMode", fields={"OBJNAMECASE"})
    public String getDBObjNameCase() {
        return this.psSysDBScheme.getOBJNAMECASE();
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
        return this.psSysDBScheme.getAUTHPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u65702", fields={"AUTHPARAM2"})
    public String getAuthParam2() {
        return this.psSysDBScheme.getAUTHPARAM2();
    }

    @Override
    public int getAuthTimeout() {
        return 0;
    }

    @Override
    public String getAuthAccessTokenUrl() {
        return null;
    }
}

