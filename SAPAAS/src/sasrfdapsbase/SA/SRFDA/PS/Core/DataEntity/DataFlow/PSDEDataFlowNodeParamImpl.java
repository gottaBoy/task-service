/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowNode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowNodeParam;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysSequence;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Data.PSDELogicNodeParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataFlowNodeParamImpl
extends PSObjectImpl
implements IPSDEDataFlowNodeParam {
    private static final Log log = LogFactory.getLog(PSDEDataFlowNodeParamImpl.class);
    private IPSDEDataFlowNode iPSDEDataFlowNode;
    private PSDELogicNodeParam psDELogicNodeParam;
    private String strDstFieldName = "";
    private String strSrcFieldName = "";
    private int nSrcIndex = -1;
    private int nSrcSize = -1;
    private int nDstIndex = -1;
    private String strAggMode = "";
    private String strDstSortDir = "";
    private int nSrcValueStdDataType = 0;
    private IPSSysTranslator iPSSysTranslator = null;
    private IPSSysSequence iPSSysSequence = null;
    private boolean bOutTranslate = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataFlowNode iPSDEDataFlowNode, PSDELogicNodeParam psDELogicNodeParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEDataFlowNode = iPSDEDataFlowNode;
            this.psDELogicNodeParam = psDELogicNodeParam;
            this.setId(this.psDELogicNodeParam.getPSDELNPARAMID());
            this.setName(this.psDELogicNodeParam.getPSDELNPARAMNAME());
            this.setPSObjectData(this.psDELogicNodeParam);
            this.strDstFieldName = this.psDELogicNodeParam.getCUSTOMDSTPARAM();
            if (StringHelper.isNullOrEmpty((String)this.strDstFieldName)) {
                this.strDstFieldName = this.psDELogicNodeParam.getDSTPSDEFNAME();
            }
            this.strSrcFieldName = this.psDELogicNodeParam.getCUSTOMSRCPARAM();
            if (StringHelper.isNullOrEmpty((String)this.strSrcFieldName)) {
                this.strSrcFieldName = this.psDELogicNodeParam.getSRCPSDEFNAME();
            }
            if (!this.psDELogicNodeParam.isSRCVALUESTDDATATYPENull()) {
                this.nSrcValueStdDataType = this.psDELogicNodeParam.getSRCVALUESTDDATATYPE();
            }
            if (!this.psDELogicNodeParam.isSRCINDEXNull()) {
                this.nSrcIndex = this.psDELogicNodeParam.getSRCINDEX();
            }
            if (!this.psDELogicNodeParam.isSRCSIZENull()) {
                this.nSrcSize = this.psDELogicNodeParam.getSRCSIZE();
            }
            if (!this.psDELogicNodeParam.isDSTINDEXNull()) {
                this.nDstIndex = this.psDELogicNodeParam.getDSTINDEX();
            }
            this.strAggMode = this.psDELogicNodeParam.getAGGMODE();
            this.strDstSortDir = this.psDELogicNodeParam.getDSTSORTDIR();
            if (!StringHelper.isNullOrEmpty((String)this.psDELogicNodeParam.getPSSYSTRANSLATORID()) && !this.psDELogicNodeParam.isINOUTFLAGNull()) {
                this.bOutTranslate = !this.psDELogicNodeParam.getINOUTFLAG();
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
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public IPSDEDataFlowNode getPSDEDataFlowNode() {
        return this.iPSDEDataFlowNode;
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u53c2\u6570\u7c7b\u578b", codelist="DEDataFlowNodeParamType", group="\u57fa\u672c", order=125, fields={"PARAMTYPE"})
    public String getNodeParamType() {
        return this.psDELogicNodeParam.getPARAMTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5c5e\u6027\u540d\u79f0", hideempty2=true, fields={"CUSTOMDSTPARAM", "DSTPSDEFNAME"})
    public String getDstField() throws Exception {
        return this.strDstFieldName;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u5c5e\u6027\u540d\u79f0", hideempty2=true, fields={"CUSTOMSRCPARAM", "SRCPSDEFNAME"})
    public String getSrcField() throws Exception {
        return this.strSrcFieldName;
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u503c", hideempty2=true, fields={"SRCVALUE"})
    public String getSrcValue() {
        return this.psDELogicNodeParam.getSRCVALUE();
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u503c\u7c7b\u578b", codelist="DEDataFlowParamValueType", fields={"SRCVALUETYPE"})
    public String getSrcValueType() {
        return this.psDELogicNodeParam.getSRCVALUETYPE();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u503c\u8f6c\u6362\u5668\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSYSTRANSLATORID"})
    public IPSSysTranslator getPSSysTranslator() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDELogicNodeParam.getPSSYSTRANSLATORID())) {
            return null;
        }
        if (this.iPSSysTranslator == null) {
            this.iPSSysTranslator = this.getPSDEDataFlowNode().getPSDEDataFlow().getPSDataEntity().getPSSystem().getPSSysTranslator(this.psDELogicNodeParam.getPSSYSTRANSLATORID());
        }
        return this.iPSSysTranslator;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u8f93\u51fa\u8f6c\u6362", hideempty=true, ignorepf=true, fields={"INOUTFLAG"}, ignoredumpvalues="false")
    public boolean isOutTranslate() {
        return this.bOutTranslate;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u503c\u5e8f\u5217\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSYSSEQUENCEID"})
    public IPSSysSequence getPSSysSequence() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDELogicNodeParam.getPSSYSSEQUENCEID())) {
            return null;
        }
        if (this.iPSSysSequence == null) {
            this.iPSSysSequence = this.getPSDEDataFlowNode().getPSDEDataFlow().getPSDataEntity().getPSSystem().getPSSysSequence(this.psDELogicNodeParam.getPSSYSSEQUENCEID());
        }
        return this.iPSSysSequence;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDataFlowNode.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEDFNODEPARAM";
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDataFlowNode().getPSDEDataFlow().getPSDataEntity().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u8868\u8fbe\u5f0f", hideempty2=true, fields={"DIRECTCODE"})
    public String getExpression() {
        return this.psDELogicNodeParam.getDIRECTCODE();
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u5217\u8868\u53c2\u6570\u8d77\u59cb\u4f4d\u7f6e", ignoredumpvalues="-1", fields={"SRCINDEX"})
    public int getSrcIndex() {
        return this.nSrcIndex;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u5217\u8868\u53c2\u6570\u5927\u5c0f", ignoredumpvalues="-1", fields={"SRCSIZE"})
    public int getSrcSize() {
        return this.nSrcSize;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5217\u8868\u53c2\u6570\u8d77\u59cb\u4f4d\u7f6e", ignoredumpvalues="-1", fields={"DSTINDEX"})
    public int getDstIndex() {
        return this.nDstIndex;
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u64cd\u4f5c\u6a21\u5f0f", codelist="AggMode", hideempty2=true, fields={"AGGMODE"})
    public String getAggMode() {
        return this.strAggMode;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5217\u8868\u6392\u5e8f\u6a21\u5f0f", codelist="SortDir", fields={"DSTSORTDIR"})
    public String getDstSortDir() {
        return this.strDstSortDir;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u503c\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", ignoredumpvalues="0", fields={"SRCVALUESTDDATATYPE"})
    public int getSrcValueStdDataType() {
        return this.nSrcValueStdDataType;
    }

    @Override
    public String getModelRefId() {
        return null;
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSDEDataFlowNode() != null) {
            return this.getPSDEDataFlowNode();
        }
        return super.onGetParentModel();
    }

    @Override
    protected String onGetMOSFolder() {
        if (this.getPSDEDataFlowNode() != null) {
            return String.format("%1$s/%2$s", this.getPSDEDataFlowNode().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSDEDataFlowNode() != null) {
            return String.format("%1$s/%2$s", this.getPSDEDataFlowNode().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }
}

