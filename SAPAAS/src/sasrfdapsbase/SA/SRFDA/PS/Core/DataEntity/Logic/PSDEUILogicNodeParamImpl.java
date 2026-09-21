/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicNode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicNodeParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicNodeParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDELogicNodeParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUILogicNodeParamImpl
extends PSObjectImpl
implements IPSDEUILogicNodeParam,
IPSAppDEUILogicNodeParam {
    private static final Log log = LogFactory.getLog(PSDEUILogicNodeParamImpl.class);
    private IPSDEUILogicNode iPSDEUILogicNode;
    private PSDELogicNodeParam psDELogicNodeParam;
    private String strDstFieldName = "";
    private String strSrcFieldName = "";
    private IPSAppDEUILogicNode iPSAppDEUILogicNode = null;
    private int nSrcIndex = -1;
    private int nSrcSize = -1;
    private int nDstIndex = -1;
    private String strAggMode = "";
    private String strDstSortDir = "";
    private int nSrcValueStdDataType = 0;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEUILogicNode iPSDEUILogicNode, PSDELogicNodeParam psDELogicNodeParam) throws Exception {
        try {
            IPSAppDEUILogicNode iPSAppDEUILogicNode;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEUILogicNode = iPSDEUILogicNode;
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
            if (iPSDEUILogicNode instanceof IPSAppDEUILogicNode && (iPSAppDEUILogicNode = (IPSAppDEUILogicNode)iPSDEUILogicNode).getPSAppDEUILogic() != null) {
                this.iPSAppDEUILogicNode = iPSAppDEUILogicNode;
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
    public IPSDEUILogicNode getPSDEUILogicNode() {
        return this.iPSDEUILogicNode;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u5904\u7406\u53c2\u6570\u64cd\u4f5c", codelist="DELogicParamType", fields={"PARAMTYPE"})
    public String getParamAction() {
        return this.psDELogicNodeParam.getPARAMTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570", hideempty=true, dumpref=true, from="IPSDEUILogic", fields={"DSTPSDLPARAMID"})
    public IPSDEUILogicParam getDstPSDEUILogicParam() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDELogicNodeParam.getDSTPSDLPARAMID())) {
            return null;
        }
        return this.iPSDEUILogicNode.getPSDEUILogic().getPSDEUILogicParam(this.psDELogicNodeParam.getDSTPSDLPARAMID());
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5c5e\u6027\u540d\u79f0", hideempty2=true, fields={"CUSTOMDSTPARAM", "DSTPSDEFNAME"})
    public String getDstFieldName() throws Exception {
        return this.strDstFieldName;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u903b\u8f91\u53c2\u6570", hideempty=true, dumpref=true, from="IPSDEUILogic", fields={"SRCPSDLPARAMID"})
    public IPSDEUILogicParam getSrcPSDEUILogicParam() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDELogicNodeParam.getSRCPSDLPARAMID())) {
            return null;
        }
        return this.iPSDEUILogicNode.getPSDEUILogic().getPSDEUILogicParam(this.psDELogicNodeParam.getSRCPSDLPARAMID());
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u5c5e\u6027\u540d\u79f0", hideempty2=true, fields={"CUSTOMSRCPARAM", "SRCPSDEFNAME"})
    public String getSrcFieldName() throws Exception {
        return this.strSrcFieldName;
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u503c", hideempty=true, fields={"SRCVALUE"})
    public String getSrcValue() {
        return this.psDELogicNodeParam.getSRCVALUE();
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u503c\u7c7b\u578b", codelist="DELogicParamValueType", fields={"SRCVALUETYPE"})
    public String getSrcValueType() {
        return this.psDELogicNodeParam.getSRCVALUETYPE();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEUILogicNode.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDEUILogicNode() != null) {
            return "PSAPPDEUILNPARAM";
        }
        return "PSDEUILNPARAM";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDEUILogicNode() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppDEUILogicNode().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
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
    @PSModelRTMeta(description="\u805a\u5408\u64cd\u4f5c\u6a21\u5f0f", hideempty2=true, codelist="AggMode", fields={"AGGMODE"})
    public String getAggMode() {
        return this.strAggMode;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5217\u8868\u6392\u5e8f\u6a21\u5f0f", codelist="SortDir", fields={"DSTSORTDIR"})
    public String getDstSortDir() {
        return this.strDstSortDir;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEUILogicNode().getPSDEUILogic().getPSDataEntity().getPSSystem());
    }

    @Override
    public IPSAppDEUILogicNode getPSAppDEUILogicNode() {
        return this.iPSAppDEUILogicNode;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u8fbe\u5f0f", hideempty2=true)
    public String getExpression() {
        return this.psDELogicNodeParam.getDIRECTCODE();
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u503c\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", ignoredumpvalues="0")
    public int getSrcValueStdDataType() {
        return this.nSrcValueStdDataType;
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

