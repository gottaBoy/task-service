/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionParam;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEActionParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEActionParamImpl
extends PSObjectImpl
implements IPSDEActionParam {
    private static final Log log = LogFactory.getLog(PSDEActionParamImpl.class);
    protected IPSDEAction iPSDEAction;
    protected PSDEActionParam psDEActionParam;
    private String strValueType = "INPUTVALUE";
    private String strValue = "";
    private IPSDEField iPSDEField = null;
    private int nStdDataType = 0;
    private int nOrderValue = 99999;
    private String strCodeName = "";
    private boolean bArray = false;
    private boolean bAllowEmpty = true;
    private String strJsonFormat = "";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEAction iPSDEAction, PSDEActionParam psDEActionParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEAction = iPSDEAction;
            this.psDEActionParam = psDEActionParam;
            this.setId(this.psDEActionParam.getPSDEACTIONPARAMID());
            this.setName(this.psDEActionParam.getPSDEACTIONPARAMNAME());
            this.setPSObjectData(this.psDEActionParam);
            if (!StringHelper.isNullOrEmpty((String)this.psDEActionParam.getVALUETYPE())) {
                this.strValueType = this.psDEActionParam.getVALUETYPE();
                this.strValue = this.psDEActionParam.getVALUE();
            }
            if (!this.psDEActionParam.isORDERVALUENull() && this.psDEActionParam.getORDERVALUE() >= 0) {
                this.nOrderValue = this.psDEActionParam.getORDERVALUE();
            }
            if (!this.psDEActionParam.isSTDDATATYPENull()) {
                this.nStdDataType = this.psDEActionParam.getSTDDATATYPE();
            }
            this.strCodeName = this.psDEActionParam.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!this.psDEActionParam.isARRAYFLAGNull()) {
                this.bArray = this.psDEActionParam.getARRAYFLAG();
            }
            if (!this.psDEActionParam.isALLOWEMPTYNull()) {
                this.bAllowEmpty = this.psDEActionParam.getALLOWEMPTY();
            }
            this.strJsonFormat = this.psDEActionParam.getJSONFORMAT();
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
        this.iPSDEField = this.getPSDEAction().getPSDataEntity().getPSDEField(this.getName(), true);
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u540d\u79f0")
    public String getName() {
        return super.getName();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u5bf9\u8c61")
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
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
    public String getPSSysModelInstId() {
        return this.iPSDEAction.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity", doc="\u4f7f\u7528\u53c2\u6570\u540d\u79f0\u5c1d\u8bd5\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    public String getModelType() {
        return "PSDEACTIONPARAM";
    }

    @Override
    public String getModelId() {
        if (this.getPSDEAction() != null) {
            return String.format("%1$s#%2$s", this.getPSDEAction().getModelId(), this.getName());
        }
        return super.getModelId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEAction().getPSDataEntity().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", fields={"STDDATATYPE"})
    public int getStdDataType() {
        if (this.nStdDataType == 0 && this.getPSDEField() != null) {
            return this.getPSDEField().getStdDataType();
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
        return this.psDEActionParam.getPARAMTAG();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u6807\u8bb02", fields={"PARAMTAG2"})
    public String getParamTag2() {
        return this.psDEActionParam.getPARAMTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u63cf\u8ff0", fields={"PARAMDESC"})
    public String getParamDesc() {
        return this.psDEActionParam.getPARAMDESC();
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u8f93\u5165", ignoredumpvalues="true", fields={"ALLOWEMPTY"})
    public boolean isAllowEmpty() {
        return this.bAllowEmpty;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316", fields={"JSONFORMAT"}, dump=false)
    public String getJsonFormat() {
        if (StringHelper.isNullOrEmpty((String)this.strJsonFormat) && !this.isArray() && this.getPSDEField() != null) {
            return this.getPSDEField().getJsonFormat();
        }
        return this.strJsonFormat;
    }
}

