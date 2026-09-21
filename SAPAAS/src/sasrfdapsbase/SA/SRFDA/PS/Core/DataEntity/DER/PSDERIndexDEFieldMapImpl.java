/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndex;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndexDEFieldMap;
import SA.SRFDA.PS.Core.DataEntity.DER.PSDERDEFieldMapImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSDERDEFMap;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDERIndexDEFieldMapImpl
extends PSDERDEFieldMapImpl
implements IPSDERIndexDEFieldMap {
    private static final Log log = LogFactory.getLog(PSDERIndexDEFieldMapImpl.class);
    private IPSDERIndex iPSDERIndex = null;
    private PSDERDEFMap psDERDEFMap = null;
    private IPSDEField majorPSDEField = null;
    private IPSDEField minorPSDEField = null;
    private int nSrcValueStdDataType = 0;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDERIndex iPSDERIndex, PSDERDEFMap psDERDEFMap) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDERIndex = iPSDERIndex;
            this.setPSDERBase(this.iPSDERIndex);
            this.psDERDEFMap = psDERDEFMap;
            this.setPSObjectData(psDERDEFMap);
            this.setId(psDERDEFMap.getPSDERDEFMAPID());
            this.setName(psDERDEFMap.getPSDERDEFMAPNAME());
            if (!this.psDERDEFMap.isSRCVALUESTDDATATYPENull()) {
                this.nSrcValueStdDataType = this.psDERDEFMap.getSRCVALUESTDDATATYPE();
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
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psDERDEFMap.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSDERIndex", from_method="getMajorPSDataEntityMust().getPSDEField", fields={"MAJORPSDEFID"})
    public IPSDEField getMajorPSDEField() throws Exception {
        if (this.majorPSDEField == null) {
            if (!StringHelper.isNullOrEmpty((String)this.psDERDEFMap.getMAJORPSDEFID())) {
                this.majorPSDEField = this.getPSDERIndex().getMajorPSDataEntity().getPSDEField(this.psDERDEFMap.getMAJORPSDEFID());
            } else if (!StringHelper.isNullOrEmpty((String)this.psDERDEFMap.getMAJORPSDEFNAME())) {
                this.majorPSDEField = this.getPSDERIndex().getMajorPSDataEntity().getPSDEField(this.psDERDEFMap.getMAJORPSDEFNAME(), true);
            }
        }
        return this.majorPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u4ece\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSDERIndex", from_method="getMinorPSDataEntityMust().getPSDEField", fields={"MINORPSDEFID"})
    public IPSDEField getMinorPSDEField() throws Exception {
        if (this.minorPSDEField == null) {
            if (!StringHelper.isNullOrEmpty((String)this.psDERDEFMap.getMINORPSDEFID())) {
                this.minorPSDEField = this.getPSDERIndex().getMinorPSDataEntity().getPSDEField(this.psDERDEFMap.getMINORPSDEFID());
            } else if (!StringHelper.isNullOrEmpty((String)this.psDERDEFMap.getMINORPSDEFNAME())) {
                this.minorPSDEField = this.getPSDERIndex().getMinorPSDataEntity().getPSDEField(this.psDERDEFMap.getMINORPSDEFNAME(), true);
            }
        }
        return this.minorPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb")
    public IPSDERIndex getPSDERIndex() {
        return this.iPSDERIndex;
    }

    @Override
    public String getModelType() {
        return "PSDERINDEXDEFMAP";
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u503c\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", ignoredumpvalues="0", fields={"SRCVALUESTDDATATYPE"})
    public int getSrcValueStdDataType() {
        return this.nSrcValueStdDataType;
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u503c", hideempty2=true, fields={"SRCVALUE"})
    public String getSrcValue() {
        return this.psDERDEFMap.getSRCVALUE();
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u503c\u7c7b\u578b", codelist="DELogicParamValueType", fields={"SRCVALUETYPE"})
    public String getSrcValueType() {
        return this.psDERDEFMap.getSRCVALUETYPE();
    }
}

