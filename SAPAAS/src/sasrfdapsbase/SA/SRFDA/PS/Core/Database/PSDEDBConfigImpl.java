/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.Database.IPSDatabase;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.Database.PSDEFDTColumnGlobalModel;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Data.PSDEDBConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEDBConfigImpl
extends PSDataEntityObjectImpl
implements IPSDEDBConfig {
    private static final Log log = LogFactory.getLog(PSDEDBConfigImpl.class);
    protected PSDEFDTColumnGlobalModel psDEFDTColumnGlobalModel = new PSDEFDTColumnGlobalModel();
    protected IPSSystemDBConfig iPSSystemDBConfig = null;
    private boolean bValidFlag = true;
    private boolean bPubModel = true;
    private String strTableName = null;
    private String strUserTable = null;
    private String strViewName = null;
    private String strView2Name = null;
    private String strView3Name = null;
    private String strView4Name = null;
    private boolean bCustomTableOrView = false;
    private String strObjNameCase = "DEFAULT";
    private PSDEDBConfig psDEDBConfig = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEDBConfig psDEDBConfig) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.setId(psDEDBConfig.getPSDEDBCFGID());
            this.setName(psDEDBConfig.getPSDEDBCFGNAME());
            this.setPSObjectData(psDEDBConfig, false);
            this.psDEDBConfig = psDEDBConfig;
            if (!psDEDBConfig.isVALIDFLAGNull()) {
                this.bValidFlag = psDEDBConfig.getVALIDFLAG();
            }
            this.iPSSystemDBConfig = this.iPSDataEntity.getPSSystem().getPSSystemDBConfig(this.getDBType());
            this.strObjNameCase = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDBConfig.getOBJNAMECASE()) ? this.psDEDBConfig.getOBJNAMECASE() : this.iPSSystemDBConfig.getObjNameCase();
            this.strTableName = psDEDBConfig.getTABLENAME();
            this.strUserTable = psDEDBConfig.getEXTABLENAME();
            this.strViewName = psDEDBConfig.getVIEWNAME();
            this.strView2Name = psDEDBConfig.getVIEWNAME2();
            this.strView3Name = psDEDBConfig.getVIEWNAME3();
            this.strView4Name = psDEDBConfig.getVIEWNAME4();
            if (!(SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strTableName) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strUserTable) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strViewName) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strView2Name) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strView3Name) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strView4Name))) {
                this.bCustomTableOrView = true;
            }
            this.bPubModel = !this.getPSDataEntity().isEnableSQLStorage() ? false : (!psDEDBConfig.isPUBMODELNull() ? psDEDBConfig.getPUBMODEL() : this.iPSSystemDBConfig.isPubModel());
            this.psDEFDTColumnGlobalModel.Init(iDAGlobalHelper, this);
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strTableName)) {
                this.strTableName = this.getPSDataEntity().getTableName();
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strUserTable)) {
                this.strUserTable = this.getPSDataEntity().getUserTable();
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strViewName)) {
                this.strViewName = this.getPSDataEntity().getViewName();
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strView2Name)) {
                this.strView2Name = this.getPSDataEntity().getView2Name();
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strView3Name)) {
                this.strView3Name = this.getPSDataEntity().getView3Name();
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strView4Name)) {
                this.strView4Name = this.getPSDataEntity().getView4Name();
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getObjNameCase(), (String)"LCASE", (boolean)true) == 0) {
                this.strTableName = this.strTableName.toLowerCase();
                this.strUserTable = this.strUserTable.toLowerCase();
                this.strViewName = this.strViewName.toLowerCase();
                this.strView2Name = this.strView2Name.toLowerCase();
                this.strView3Name = this.strView3Name.toLowerCase();
                this.strView4Name = this.strView4Name.toLowerCase();
                this.bCustomTableOrView = true;
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getObjNameCase(), (String)"UCASE", (boolean)true) == 0) {
                this.strTableName = this.strTableName.toUpperCase();
                this.strUserTable = this.strUserTable.toUpperCase();
                this.strViewName = this.strViewName.toUpperCase();
                this.strView2Name = this.strView2Name.toUpperCase();
                this.strView3Name = this.strView3Name.toUpperCase();
                this.strView4Name = this.strView4Name.toUpperCase();
                this.bCustomTableOrView = true;
            }
            if (this.isAutoModel()) {
                this.psDEFDTColumnGlobalModel.setPreloadModels(false);
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
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u7c7b\u578b", codelist="DBType", group="\u57fa\u672c", order=105)
    public String getDBType() {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getName())) {
            return this.getName().toUpperCase();
        }
        return this.getName();
    }

    @Override
    public String getLogicValidSQLCode(boolean bValid) {
        Object objValue = this.getPSDataEntity().getLogicValidValue(bValid);
        if (objValue instanceof String) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"'%1$s'", (Object)objValue);
        }
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s", (Object)objValue);
    }

    @Override
    public IPSDEFDTColumn getPSDEFDTColumn(String strPSDEFieldName) throws Exception {
        return (IPSDEFDTColumn)this.psDEFDTColumnGlobalModel.FindModelHelper(strPSDEFieldName);
    }

    @Override
    public IPSDEFDTColumn getPSDEFDTColumn(String strPSDEFieldName, boolean bTryMode) throws Exception {
        return this.psDEFDTColumnGlobalModel.FindModelHelper(strPSDEFieldName, bTryMode);
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6570\u636e\u5217\u96c6\u5408", group="\u57fa\u672c", order=140)
    public Iterator<IPSDEFDTColumn> getAllPSDEFDTColumns() throws Exception {
        return this.psDEFDTColumnGlobalModel.getAllModelHelpers();
    }

    @Override
    public void publishDBModel(IPSPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase) throws Exception {
        if (!this.isValidFlag()) {
            return;
        }
        this.getPSModelStorage().getPSDBType(this.getDBType()).publishPSDataEntityDBModel(iPSPublisherContext, iPSDatabase, this);
    }

    @Override
    public void publishDBModel2(IPSPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase) throws Exception {
        if (!this.isValidFlag()) {
            return;
        }
        this.getPSModelStorage().getPSDBType(this.getDBType()).publishPSDataEntityDBModel2(iPSPublisherContext, iPSDatabase, this);
    }

    @Override
    public void loadAll() throws Exception {
        this.psDEFDTColumnGlobalModel.getAllModelHelpers();
    }

    @Override
    public String getTableSpace() {
        return this.iPSSystemDBConfig.getTableSpace(this.getPSDataEntity().getTableSpaceId());
    }

    @Override
    public boolean isUnicodeChar() {
        return false;
    }

    @Override
    public String getModelType() {
        return "PSDEDBCFG";
    }

    @Override
    @Deprecated
    public boolean isValidFlag() {
        return this.bValidFlag;
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u542f\u7528")
    public boolean isValid() {
        return this.bValidFlag;
    }

    @Override
    @PSModelRTMeta(description="\u53d1\u5e03\u6570\u636e\u5e93\u7ed3\u6784", dump=false)
    public boolean isPubModel() {
        return this.isValidFlag() && this.bPubModel;
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)this.getDBType());
    }

    @Override
    @PSModelRTMeta(description="\u8868\u540d\u79f0")
    public String getTableName() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strTableName)) {
            return this.getPSDataEntity().getTableName();
        }
        return this.strTableName;
    }

    @Override
    public String getUserTable() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strUserTable)) {
            return this.getPSDataEntity().getUserTable();
        }
        return this.strUserTable;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u540d\u79f0")
    public String getViewName() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strViewName)) {
            return this.getPSDataEntity().getViewName();
        }
        return this.strViewName;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe2\u540d\u79f0", hideempty2=true)
    public String getView2Name() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strView2Name)) {
            return this.getPSDataEntity().getView2Name();
        }
        return this.strView2Name;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe3\u540d\u79f0", hideempty2=true)
    public String getView3Name() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strView3Name)) {
            return this.getPSDataEntity().getView3Name();
        }
        return this.strView3Name;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe4\u540d\u79f0", hideempty2=true)
    public String getView4Name() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strView4Name)) {
            return this.getPSDataEntity().getView4Name();
        }
        return this.strView4Name;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u8868\u6216\u89c6\u56fe\u540d\u79f0", ignoredumpvalues="false")
    public boolean isCustomTableOrView() {
        return this.bCustomTableOrView;
    }

    @Override
    public String getViewName(int nViewLevel) {
        switch (nViewLevel) {
            case -1: 
            case 0: {
                return this.getViewName();
            }
            case 3: {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getView4Name())) {
                    return this.getView4Name();
                }
            }
            case 2: {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getView3Name())) {
                    return this.getView3Name();
                }
            }
            case 1: {
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getView2Name())) break;
                return this.getView2Name();
            }
        }
        return this.getViewName();
    }

    @Override
    public String getSaaSDataIdColumnName() {
        if (this.getPSDataEntity() != null) {
            return this.getPSDataEntity().getSaaSDataIdColumnName();
        }
        return "SRFID";
    }

    @Override
    public String getSaaSDCIdColumnName() {
        if (this.getPSDataEntity() != null) {
            return this.getPSDataEntity().getSaaSDCIdColumnName();
        }
        return "SRFDCID";
    }

    @Override
    @PSModelRTMeta(description="\u5bf9\u8c61\u540d\u79f0\u8f6c\u5316", codelist="DBObjNameCaseMode", fields={"OBJNAMECASE"})
    public String getObjNameCase() {
        return this.strObjNameCase;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u914d\u7f6e\u5bf9\u8c61")
    public IPSSystemDBConfig getPSSystemDBConfig() {
        return this.iPSSystemDBConfig;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u8868\u540d")
    public String getStandardTableName() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getTableName())) {
            return this.getTableName();
        }
        try {
            IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(this.getDBType(), false);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getObjNameCase())) {
                if (this.getObjNameCase().equals("LCASE")) {
                    return iPSDBType.getDBObjStandardName(this.getTableName().toLowerCase());
                }
                if (this.getObjNameCase().equals("UCASE")) {
                    return iPSDBType.getDBObjStandardName(this.getTableName().toUpperCase());
                }
            }
            return iPSDBType.getDBObjStandardName(this.getTableName());
        }
        catch (Exception ex) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getObjNameCase())) {
                if (this.getObjNameCase().equals("LCASE")) {
                    return this.getTableName().toLowerCase();
                }
                if (this.getObjNameCase().equals("UCASE")) {
                    return this.getTableName().toUpperCase();
                }
            }
            return this.getTableName();
        }
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    public String getCodeName() {
        return this.getName();
    }
}

