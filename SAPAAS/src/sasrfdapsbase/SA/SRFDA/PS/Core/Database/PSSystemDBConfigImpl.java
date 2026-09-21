/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Data.PSDevCenterDBInst;
import SA.SRFDA.PS.Data.PSSystemDBConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSSystemDBConfigImpl
extends PSSystemObjectImpl
implements IPSSystemDBConfig {
    private static final Log log = LogFactory.getLog(PSSystemDBConfigImpl.class);
    protected PSSystemDBConfig psSystemDBConfig = null;
    private boolean bDefault = false;
    private boolean bNoDBInstMode = false;
    private boolean bPubModelComment = true;
    private boolean bPubView = true;
    private boolean bPubFKey = true;
    private boolean bPubIndex = true;
    private boolean bPubModel = true;
    private String strObjNameCase = "DEFAULT";
    private String strNullValueOrderMode = null;
    private PSDevCenterDBInst psDevCenterDBInst = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSystemDBConfig psSystemDBConfig) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSystemDBConfig = psSystemDBConfig;
            this.setId(this.psSystemDBConfig.getPSSYSTEMDBCFGID());
            this.setName(this.psSystemDBConfig.getPSSYSTEMDBCFGNAME());
            this.setPSObjectData(this.psSystemDBConfig);
            if (!this.psSystemDBConfig.isDEFAULTFLAGNull()) {
                this.bDefault = this.psSystemDBConfig.getDEFAULTFLAG();
            }
            if (!this.psSystemDBConfig.isNODBINSTMODENull()) {
                this.bNoDBInstMode = this.psSystemDBConfig.getNODBINSTMODE();
            }
            this.bNoDBInstMode = StringHelper.IsNullOrEmpty((String)this.psSystemDBConfig.getPSDBDEVINSTID());
            this.bPubModel = !psSystemDBConfig.isPUBDBMODELFLAGNull() ? this.psSystemDBConfig.getPUBDBMODELFLAG() : this.getPSSystemSetting().isPubDBModel();
            if (!psSystemDBConfig.isPUBCOMMENTFLAGNull()) {
                this.bPubModelComment = psSystemDBConfig.getPUBCOMMENTFLAG();
            }
            if (!psSystemDBConfig.isPUBVIEWFLAGNull()) {
                this.bPubView = psSystemDBConfig.getPUBVIEWFLAG();
            }
            if (!psSystemDBConfig.isPUBFKEYFLAGNull()) {
                this.bPubFKey = psSystemDBConfig.getPUBFKEYFLAG();
            }
            if (!psSystemDBConfig.isPUBINDEXFLAGNull()) {
                this.bPubIndex = psSystemDBConfig.isPUBINDEXFLAGNull();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psSystemDBConfig.getOBJNAMECASE())) {
                this.strObjNameCase = this.psSystemDBConfig.getOBJNAMECASE();
            }
            this.strNullValueOrderMode = this.psSystemDBConfig.getNULLVALORDER();
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    public String getPSDBDevInstId() {
        return this.psSystemDBConfig.getPSDBDEVINSTID();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6570\u636e\u5e93\u652f\u6301")
    public boolean isDefaultMode() {
        return this.bDefault;
    }

    @Override
    public String getTableSpace(String strTableSpaceId) {
        if (StringHelper.IsNullOrEmpty((String)strTableSpaceId) || StringHelper.Compare((String)strTableSpaceId, (String)"TABLESPACE", (boolean)true) == 0) {
            return this.psSystemDBConfig.getTABSPACE();
        }
        if (StringHelper.Compare((String)strTableSpaceId, (String)"TABLESPACE2", (boolean)true) == 0) {
            return this.psSystemDBConfig.getTABSPACE2();
        }
        if (StringHelper.Compare((String)strTableSpaceId, (String)"TABLESPACE3", (boolean)true) == 0) {
            return this.psSystemDBConfig.getTABSPACE3();
        }
        if (StringHelper.Compare((String)strTableSpaceId, (String)"TABLESPACE4", (boolean)true) == 0) {
            return this.psSystemDBConfig.getTABSPACE4();
        }
        return this.psSystemDBConfig.getTABSPACE();
    }

    @Override
    public String getModelType() {
        return "PSSYSTEMDBCFG";
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u7c7b\u578b", codelist="DBType3", group="\u57fa\u672c", order=101)
    public String getDBType() {
        if (!StringHelper.IsNullOrEmpty((String)this.getName())) {
            return this.getName().toUpperCase();
        }
        return this.getName();
    }

    @Override
    public boolean isNoDBInstMode() {
        return this.bNoDBInstMode;
    }

    @Override
    public String getPSDCDBDevInstId() {
        return this.psSystemDBConfig.getPSDEVCENTERDBINSTID();
    }

    @Override
    public String getPSDCDBDevInstName() {
        String strDefaultName = this.psSystemDBConfig.getPSDEVCENTERDBINSTNAME();
        if (this.psDevCenterDBInst != null) {
            strDefaultName = this.psDevCenterDBInst.getPSDEVCENTERDBINSTNAME();
        } else {
            String strPSDevCenterDBInstId = this.getPSDCDBDevInstId();
            if (!StringHelper.IsNullOrEmpty((String)strPSDevCenterDBInstId)) {
                PSDevCenterDBInst psDevCenterDBInst = new PSDevCenterDBInst();
                try {
                    CallResult callResult = this.getPSModelHelper(null).getPSDCDBInst(strPSDevCenterDBInstId, psDevCenterDBInst);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5e93\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    strDefaultName = psDevCenterDBInst.getPSDEVCENTERDBINSTNAME();
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                    psDevCenterDBInst.setPSDEVCENTERDBINSTNAME(strDefaultName);
                }
                this.psDevCenterDBInst = psDevCenterDBInst;
            }
        }
        return strDefaultName;
    }

    @Override
    @PSModelRTMeta(description="\u53d1\u5e03\u6ce8\u91ca")
    public boolean isPubModelComment() {
        return this.bPubModelComment && this.isPubModel();
    }

    @Override
    @PSModelRTMeta(description="\u53d1\u5e03\u89c6\u56fe")
    public boolean isPubView() {
        return this.bPubView && this.isPubModel();
    }

    @Override
    @PSModelRTMeta(description="\u53d1\u5e03\u5916\u952e")
    public boolean isPubFKey() {
        return this.bPubFKey && this.isPubModel();
    }

    @Override
    @PSModelRTMeta(description="\u53d1\u5e03\u7d22\u5f15")
    public boolean isPubIndex() {
        return this.bPubIndex && this.isPubModel();
    }

    @Override
    @PSModelRTMeta(description="\u53d1\u5e03\u6570\u636e\u5e93\u6a21\u578b")
    public boolean isPubModel() {
        return this.bPubModel;
    }

    @Override
    @PSModelRTMeta(description="\u5bf9\u8c61\u540d\u79f0\u8f6c\u5316", codelist="DBObjNameCaseMode")
    public String getObjNameCase() {
        return this.strObjNameCase;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7a7a\u503c\u6392\u5e8f\u6a21\u5f0f", codelist="DBNullValueOrderMode")
    public String getNullValueOrderMode() {
        return this.strNullValueOrderMode;
    }

    @Override
    public String getCodeName() {
        return this.getName();
    }
}

