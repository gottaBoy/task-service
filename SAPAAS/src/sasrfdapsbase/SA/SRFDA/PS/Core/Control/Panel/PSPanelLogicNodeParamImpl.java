/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNode;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNodeParam;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicParam;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSPanelLogicNodeParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSPanelLogicNodeParamImpl
extends PSObjectImpl
implements IPSPanelLogicNodeParam {
    private static final Log log = LogFactory.getLog(PSPanelLogicNodeParamImpl.class);
    protected IPSPanelLogicNode iPSPanelLogicNode;
    protected PSPanelLogicNodeParam psPanelLogicNodeParam;
    protected String strDstFieldName = "";
    protected String strSrcFieldName = "";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPanelLogicNode iPSPanelLogicNode, PSPanelLogicNodeParam psPanelLogicNodeParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSPanelLogicNode = iPSPanelLogicNode;
            this.psPanelLogicNodeParam = psPanelLogicNodeParam;
            this.setId(this.psPanelLogicNodeParam.getPSPANELLNPARAMID());
            this.setName(this.psPanelLogicNodeParam.getPSPANELLNPARAMNAME());
            this.setPSObjectData(this.psPanelLogicNodeParam);
            this.strDstFieldName = this.psPanelLogicNodeParam.getDSTFIELDNAME();
            this.strSrcFieldName = this.psPanelLogicNodeParam.getSRCFIELDNAME();
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
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
    public IPSPanelLogicNode getPSPanelLogicNode() {
        return this.iPSPanelLogicNode;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u5904\u7406\u53c2\u6570\u7c7b\u578b", codelist="PanelLogicParamType")
    public String getLogicNodeParamType() {
        return this.psPanelLogicNodeParam.getPARAMTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570", hideempty=true)
    public IPSPanelLogicParam getDstPSPanelLogicParam() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psPanelLogicNodeParam.getDSTPSPANELLPID())) {
            return null;
        }
        return this.iPSPanelLogicNode.getPSPanelLogic().getPSPanelLogicParam(this.psPanelLogicNodeParam.getDSTPSPANELLPID());
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5c5e\u6027\u540d\u79f0", hideempty2=true)
    public String getDstFieldName() throws Exception {
        return this.strDstFieldName;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u903b\u8f91\u53c2\u6570", hideempty=true)
    public IPSPanelLogicParam getSrcPSPanelLogicParam() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psPanelLogicNodeParam.getSRCPSPANELLPID())) {
            return null;
        }
        return this.iPSPanelLogicNode.getPSPanelLogic().getPSPanelLogicParam(this.psPanelLogicNodeParam.getSRCPSPANELLPID());
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u5c5e\u6027\u540d\u79f0", hideempty2=true)
    public String getSrcFieldName() throws Exception {
        return this.strSrcFieldName;
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u503c", hideempty=true)
    public String getSrcValue() {
        return this.psPanelLogicNodeParam.getSRCVALUE();
    }

    @Override
    public String getDirectCode() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u503c\u7c7b\u578b", codelist="PanelLogicParamValueType")
    public String getSrcValueType() {
        return this.psPanelLogicNodeParam.getSRCVALUETYPE();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSPanelLogicNode.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSPANELLNPARAM";
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSPanelLogicNode().getPSPanelLogic().getPSPanel().getPSAppView().getPSSystem());
    }
}

