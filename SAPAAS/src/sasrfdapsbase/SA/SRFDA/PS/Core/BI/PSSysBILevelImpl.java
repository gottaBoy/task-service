/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSSysBIHierarchy;
import SA.SRFDA.PS.Core.BI.IPSSysBILevel;
import SA.SRFDA.PS.Core.BI.PSSysBIHierarchyObjectImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysBILevel;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBILevelImpl
extends PSSysBIHierarchyObjectImpl
implements IPSSysBILevel {
    private static final Log log = LogFactory.getLog(PSSysBILevelImpl.class);
    protected PSSysBILevel psSysBILevel = null;
    private String strLevelType = "COMMON";
    private IPSDEField textPSDEField = null;
    private IPSDEField valuePSDEField = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysBIHierarchy iPSSysBIHierarchy, PSSysBILevel psSysBILevel) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysBIHierarchy(iPSSysBIHierarchy);
            this.psSysBILevel = psSysBILevel;
            this.setId(this.psSysBILevel.getPSSYSBILEVELID());
            this.setName(this.psSysBILevel.getPSSYSBILEVELNAME());
            this.setPSObjectData(this.psSysBILevel);
            if (!StringHelper.isNullOrEmpty((String)this.psSysBILevel.getBILEVELTYPE())) {
                this.strLevelType = this.psSysBILevel.getBILEVELTYPE();
            }
            if (this.getPSSysBIHierarchy().getPSDataEntity() != null) {
                if (this.getValuePSDEField() == null && !StringHelper.isNullOrEmpty((String)this.psSysBILevel.getVALUEPSDEFID())) {
                    this.valuePSDEField = this.getPSSysBIHierarchy().getPSDataEntity().getPSDEField(this.psSysBILevel.getVALUEPSDEFID());
                }
                if (this.getTextPSDEField() == null && !StringHelper.isNullOrEmpty((String)this.psSysBILevel.getTEXTPSDEFID())) {
                    this.textPSDEField = this.getPSSysBIHierarchy().getPSDataEntity().getPSDEField(this.psSysBILevel.getTEXTPSDEFID());
                }
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
    public String getModelType() {
        return "PSSYSBILEVEL";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysBILevel.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u5c42\u7ea7\u6807\u8bb0", hideempty2=true)
    public String getLevelTag() {
        return this.psSysBILevel.getBILEVELTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5c42\u7ea7\u6807\u8bb02", hideempty2=true)
    public String getLevelTag2() {
        return this.psSysBILevel.getBILEVELTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u5c42\u7ea7\u7c7b\u578b", codelist="BILevelType", ignoredumpvalues="COMMON")
    public String getLevelType() {
        return this.strLevelType;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6587\u672c\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSSysBIHierarchy", from_method="getPSDataEntityMust().getPSDEField")
    public IPSDEField getTextPSDEField() {
        return this.textPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSSysBIHierarchy", from_method="getPSDataEntityMust().getPSDEField")
    public IPSDEField getValuePSDEField() {
        return this.valuePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u552f\u4e00\u6807\u8bb0\u6210\u5458", ignoredumpvalues="false", fields={"UNIQUEMEMBERS"})
    public boolean isUniqueMembers() {
        return this.psSysBILevel.getUNIQUEMEMBERS();
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u6807\u9898", fields={"AGGCAPTION"})
    public String getAggCaption() {
        return this.psSysBILevel.getAGGCAPTION();
    }
}

