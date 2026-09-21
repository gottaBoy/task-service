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

import SA.SRFDA.PS.Core.BI.IPSBIHierarchy;
import SA.SRFDA.PS.Core.BI.IPSBILevel;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeLevel;
import SA.SRFDA.PS.Core.BI.IPSSysBIHierarchy;
import SA.SRFDA.PS.Core.BI.IPSSysBILevel;
import SA.SRFDA.PS.Core.BI.PSSysBICubeDimensionObjectImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysBICubeLevel;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBICubeLevelImpl
extends PSSysBICubeDimensionObjectImpl
implements IPSSysBICubeLevel {
    private static final Log log = LogFactory.getLog(PSSysBICubeLevelImpl.class);
    protected PSSysBICubeLevel psSysBICubeLevel = null;
    private IPSSysBIHierarchy iPSSysBIHierarchy = null;
    private IPSDEField iPSDEField = null;
    private IPSSysBILevel iPSSysBILevel = null;
    private boolean bAllLevel = false;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysBICubeDimension iPSSysBICubeDimension, PSSysBICubeLevel psSysBICubeLevel) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysBICubeDimension(iPSSysBICubeDimension);
            this.psSysBICubeLevel = psSysBICubeLevel;
            this.setId(this.psSysBICubeLevel.getPSSYSBICUBELEVELID());
            this.setName(this.psSysBICubeLevel.getPSSYSBICUBELEVELNAME());
            this.setPSObjectData(this.psSysBICubeLevel);
            if (this.getPSSysBIHierarchy() == null && !StringHelper.isNullOrEmpty((String)this.psSysBICubeLevel.getPSSYSBIHIERARCHYID())) {
                this.iPSSysBIHierarchy = this.getPSSysBICubeDimension().getPSSysBIDimension().getPSSysBIHierarchy(this.psSysBICubeLevel.getPSSYSBIHIERARCHYID());
            }
            if (this.getPSSysBIHierarchy() == null) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6\u67b6\u6784");
            }
            if (this.getPSSysBILevel() == null && !StringHelper.isNullOrEmpty((String)this.psSysBICubeLevel.getPSSYSBILEVELID())) {
                this.iPSSysBILevel = this.getPSSysBIHierarchy().getPSSysBILevel(this.psSysBICubeLevel.getPSSYSBILEVELID());
            }
            if (this.getPSSysBILevel() == null && !this.psSysBICubeLevel.isALLLEVELFLAGNull()) {
                this.bAllLevel = this.psSysBICubeLevel.getALLLEVELFLAG();
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
        return "PSSYSBICUBELEVEL";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysBICubeLevel.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u5c42\u7ea7\u6807\u8bb0", hideempty2=true)
    public String getLevelTag() {
        return this.psSysBICubeLevel.getBICUBELEVELTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5c42\u7ea7\u6807\u8bb02", hideempty2=true)
    public String getLevelTag2() {
        return this.psSysBICubeLevel.getBICUBELEVELTAG2();
    }

    @Override
    public IPSBIHierarchy getPSBIHierarchy() {
        return this.getPSSysBIHierarchy();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6\u67b6\u6784", hideempty=true, dumpref=true, from="IPSSysBICubeDimension", from_method="getPSSysBIDimensionMust().getPSSysBIHierarchy")
    public IPSSysBIHierarchy getPSSysBIHierarchy() {
        return this.iPSSysBIHierarchy;
    }

    @Override
    public IPSBILevel getPSBILevel() {
        return this.getPSSysBILevel();
    }

    @Override
    @PSModelRTMeta(description="\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6\u5c42\u7ea7", hideempty=true, dumpref=true, from="IPSSysBIHierarchy")
    public IPSSysBILevel getPSSysBILevel() {
        return this.iPSSysBILevel;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u5c42\u7ea7", ignoredumpvalues="false", fields={"ALLLEVELFLAG"})
    public boolean isAllLevel() {
        return this.bAllLevel;
    }
}

