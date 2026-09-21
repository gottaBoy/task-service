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
package SA.SRFDA.PS.Core.DataEntity.BA;

import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.DataEntity.BA.IPSDEBDTable;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.SF.PSSFCodeObjectHelper;
import SA.SRFDA.PS.Data.PSSysBDTableDE;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEBDTableImpl
extends PSDataEntityObjectImpl
implements IPSDEBDTable {
    private static final Log log = LogFactory.getLog(PSDEBDTableImpl.class);
    protected PSSysBDTableDE psSysBDTableDE;
    protected String strCodeName = "";
    private IPSSysBDScheme iPSSysBDScheme = null;
    private IPSSysBDTable iPSSysBDTable = null;
    private int nBATableDEType = 1;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSSysBDTableDE psSysBDTableDE) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psSysBDTableDE = psSysBDTableDE;
            this.setId(psSysBDTableDE.getPSSYSBDTABLEDEID());
            this.setName(psSysBDTableDE.getPSSYSBDTABLEDENAME());
            this.setPSObjectData(this.psSysBDTableDE);
            if (!this.psSysBDTableDE.isDEFAULTFLAGNull()) {
                this.nBATableDEType = this.psSysBDTableDE.GetParamIntValue("DEFAULTFLAG", 0);
            }
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
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getModelType() {
        return "PSDEBDTABLE";
    }

    @Override
    @PSModelRTMeta(description="\u5927\u6570\u636e\u4f53\u7cfb", dumpref=true, fields={"PSSYSBDSCHEMEID"})
    public IPSSysBDScheme getPSSysBDScheme() throws Exception {
        if (this.iPSSysBDScheme == null) {
            this.iPSSysBDScheme = this.getPSDataEntity().getPSSystem().getPSSysBDScheme(this.psSysBDTableDE.getPSSYSBDSCHEMEID());
        }
        return this.iPSSysBDScheme;
    }

    @Override
    @PSModelRTMeta(description="\u5927\u6570\u636e\u8868", dumpref=true, from="IPSSysBDScheme", fields={"PSSYSBDTABLEID"})
    public IPSSysBDTable getPSSysBDTable() throws Exception {
        if (this.iPSSysBDTable == null) {
            this.iPSSysBDTable = this.getPSSysBDScheme().getPSSysBDTable(this.psSysBDTableDE.getPSSYSBDTABLEID());
        }
        return this.iPSSysBDTable;
    }

    @Override
    public String getClassOrPkgName(String strCodeType, IPSSysSFPub iPSSysSFPub) throws Exception {
        String strNameFormat2;
        String strPKGName = PSSFCodeObjectHelper.getClassOrPkgName(this, this.getPSDataEntity().getPSSystemModule(), null, "PKG", iPSSysSFPub);
        String strNameFormat = PSSFCodeObjectHelper.getClassOrPkgName(this, this.getPSDataEntity().getPSSystemModule(), null, strCodeType, iPSSysSFPub);
        if (StringHelper.IsNullOrEmpty((String)strNameFormat)) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5927\u6570\u636e\u8868[%1$s]\u4ee3\u7801\u7c7b\u578b[%2$s]\u4ee3\u7801\u540d\u79f0"));
        }
        String strModuleName = "";
        if (this.getPSDataEntity().getPSSystemModule() != null) {
            strModuleName = this.getPSDataEntity().getPSSystemModule().getCodeName();
        }
        if (this.getPSDataEntity().getDynamicMode() == 2 && strCodeType.indexOf("SUBSYS_") != 0 && !StringHelper.IsNullOrEmpty((String)(strNameFormat2 = PSSFCodeObjectHelper.getClassOrPkgName(this, null, null, "SUBSYS_" + strCodeType, iPSSysSFPub)))) {
            strModuleName = "SubSys";
            strPKGName = "";
        }
        if (StringHelper.IsNullOrEmpty((String)strPKGName)) {
            strPKGName = iPSSysSFPub.getPKGCodeName();
        }
        if (iPSSysSFPub.getPSSFStyle().getPSSF().isPkgLowercase()) {
            strModuleName = strModuleName.toLowerCase();
        }
        return StringHelper.Format((String)strNameFormat, (Object)strPKGName, (Object)strModuleName, (Object)this.getPSSysBDScheme().getCodeName(), (Object)this.getCodeName());
    }

    public int getBATableDEType() {
        return this.nBATableDEType;
    }

    public String getBAThemeId() {
        return this.psSysBDTableDE.getPSSYSBDSCHEMEID();
    }

    public String getBATableName() {
        return this.psSysBDTableDE.getPSSYSBDTABLENAME();
    }

    public String getBAColSetName() {
        return this.psSysBDTableDE.getPSSYSBDCOLSETNAME();
    }

    @Override
    @PSModelRTMeta(description="\u5927\u6570\u636e\u8868\u5b9e\u4f53\u7c7b\u578b", codelist="BDTableDEType", fields={"DEFAULTFLAG"})
    public int getBDTableDEType() {
        return this.nBATableDEType;
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)super.getModelId());
    }
}

