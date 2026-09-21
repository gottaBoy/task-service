/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetParam;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEDSParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataSetParamImpl
extends PSObjectImpl
implements IPSDEDataSetParam {
    private static final Log log = LogFactory.getLog(PSDEDataSetParamImpl.class);
    protected IPSDEDataSet iPSDEDataSet;
    protected PSDEDSParam psDEDSParam;
    private String strValueType = "INPUTVALUE";
    private String strValue = "";
    private IPSDEFSearchMode iPSDEFSearchMode = null;
    private int nStdDataType = 0;
    private int nOrderValue = 99999;
    private String strCodeName = "";
    private boolean bArray = false;
    private boolean bAllowEmpty = true;
    private String strJsonFormat = "";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataSet iPSDEDataSet, PSDEDSParam psDEDSParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEDataSet = iPSDEDataSet;
            this.psDEDSParam = psDEDSParam;
            this.setId(this.psDEDSParam.getPSDEDSPARAMID());
            this.setName(this.psDEDSParam.getPSDEDSPARAMNAME());
            this.setPSObjectData(this.psDEDSParam);
            if (!StringHelper.isNullOrEmpty((String)this.psDEDSParam.getVALUETYPE())) {
                this.strValueType = this.psDEDSParam.getVALUETYPE();
                this.strValue = this.psDEDSParam.getVALUE();
            }
            if (!this.psDEDSParam.isORDERVALUENull() && this.psDEDSParam.getORDERVALUE() >= 0) {
                this.nOrderValue = this.psDEDSParam.getORDERVALUE();
            }
            if (!this.psDEDSParam.isSTDDATATYPENull()) {
                this.nStdDataType = this.psDEDSParam.getSTDDATATYPE();
            }
            this.strCodeName = this.psDEDSParam.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!this.psDEDSParam.isARRAYFLAGNull()) {
                this.bArray = this.psDEDSParam.getARRAYFLAG();
            }
            if (!this.psDEDSParam.isALLOWEMPTYNull()) {
                this.bAllowEmpty = this.psDEDSParam.getALLOWEMPTY();
            }
            this.strJsonFormat = this.psDEDSParam.getJSONFORMAT();
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
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSDEFSearchMode();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u7ed3\u679c\u96c6")
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u540d\u79f0")
    public String getName() {
        return super.getName();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDataSet.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEDSPARAM";
    }

    @Override
    public String getModelId() {
        if (this.getPSDEDataSet() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEDataSet().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDataSet().getPSDataEntity().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u503c\u7c7b\u578b", codelist="DEActionParamType", fields={"VALUETYPE"})
    public String getValueType() {
        return this.strValueType;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u6216\u5c5e\u6027", fields={"VALUE"})
    public String getValue() {
        return this.strValue;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", fields={"STDDATATYPE"})
    public int getStdDataType() {
        if (this.nStdDataType == 0) {
            try {
                if (this.getPSDEFSearchMode() != null) {
                    return this.getPSDEFSearchMode().getStdDataType();
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return this.nStdDataType;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", dump=false, ignoredumpvalues="99999", fields={"ORDERVALUE"})
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", dump=false)
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u7ec4", ignoredumpvalues="false", fields={"ARRAYFLAG"})
    public boolean isArray() {
        return this.bArray;
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u6807\u8bb0", fields={"PARAMTAG"})
    public String getParamTag() {
        return this.psDEDSParam.getPARAMTAG();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u6807\u8bb02", fields={"PARAMTAG2"})
    public String getParamTag2() {
        return this.psDEDSParam.getPARAMTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u63cf\u8ff0", fields={"PARAMDESC"})
    public String getParamDesc() {
        return this.psDEDSParam.getPARAMDESC();
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u8f93\u5165", ignoredumpvalues="true", fields={"ALLOWEMPTY"})
    public boolean isAllowEmpty() {
        return this.bAllowEmpty;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316", fields={"JSONFORMAT"}, dump=false)
    public String getJsonFormat() {
        if (StringHelper.isNullOrEmpty((String)this.strJsonFormat)) {
            try {
                if (!this.isArray() && this.getPSDEFSearchMode() != null) {
                    return this.getPSDEFSearchMode().getJsonFormat();
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return this.strJsonFormat;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f", dumpref=true, from="IPSDEField")
    public IPSDEFSearchMode getPSDEFSearchMode() throws Exception {
        Iterator<IPSDEField> psDEFields;
        if (this.iPSDEFSearchMode == null && (psDEFields = this.getPSDEDataSet().getPSDataEntity().getAllPSDEFields()) != null) {
            IPSDEFSearchMode iPSDEFSearchMode = null;
            while (psDEFields.hasNext()) {
                IPSDEField iPSDEField = psDEFields.next();
                iPSDEFSearchMode = !StringHelper.isNullOrEmpty((String)this.psDEDSParam.getPSDEFSFITEMID()) ? iPSDEField.getPSDEFSearchMode(this.psDEDSParam.getPSDEFSFITEMID(), true) : iPSDEField.getPSDEFSearchMode(this.getName(), true);
                if (iPSDEFSearchMode == null) continue;
                this.iPSDEFSearchMode = iPSDEFSearchMode;
                break;
            }
        }
        return this.iPSDEFSearchMode;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getPSDEField() throws Exception {
        if (this.getPSDEFSearchMode() != null) {
            return this.getPSDEFSearchMode().getPSDEField();
        }
        return null;
    }
}

