/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlow;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowLink;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowNode;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDELogicLink;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataFlowLinkImpl
extends PSObjectImpl
implements IPSDEDataFlowLink {
    private static final Log log = LogFactory.getLog(PSDEDataFlowLinkImpl.class);
    protected IPSDEDataFlow iPSDEDataFlow;
    protected PSDELogicLink psDELogicLink;
    protected int nLinkMode = 11;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataFlow iPSDEDataFlow, PSDELogicLink psDELogicLink) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEDataFlow = iPSDEDataFlow;
            this.psDELogicLink = psDELogicLink;
            this.setId(this.psDELogicLink.getPSDELOGICLINKID());
            this.setName(this.psDELogicLink.getPSDELOGICLINKNAME());
            this.setPSObjectData(this.psDELogicLink);
            if (!psDELogicLink.isDEFAULTLINKNull()) {
                this.nLinkMode = psDELogicLink.GetParamIntValue("DEFAULTLINK", this.nLinkMode);
                if (this.nLinkMode == 0) {
                    this.nLinkMode = 11;
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
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u6570\u636e\u6d41\u8282\u70b9\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEDataFlow", fields={"DSTPSDELOGICNODEID"})
    public IPSDEDataFlowNode getDstPSDEDataFlowNode() throws Exception {
        return this.iPSDEDataFlow.getPSDEDataFlowNode(this.psDELogicLink.getDSTPSDELOGICNODEID());
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u6570\u636e\u6d41\u8282\u70b9\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEDataFlow", fields={"SRCPSDELOGICNODEID"})
    public IPSDEDataFlowNode getSrcPSDEDataFlowNode() throws Exception {
        return this.iPSDEDataFlow.getPSDEDataFlowNode(this.psDELogicLink.getSRCPSDELOGICNODEID());
    }

    @Override
    public IPSDEDataFlow getPSDEDataFlow() {
        return this.iPSDEDataFlow;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEDataFlow().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEDATAFLOWLINK";
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDataFlow().getPSDataEntity().getPSSystem());
    }

    public int getLinkMode() {
        return this.nLinkMode;
    }

    @Override
    @PSModelRTMeta(description="\u8fde\u63a5\u7c7b\u578b", codelist="DEDataFlowLinkType", fields={"DEFAULTLINK"})
    public String getLinkType() {
        switch (this.getLinkMode()) {
            case 11: {
                return "DATASTREAM";
            }
            case 12: {
                return "DATASTREAM2";
            }
        }
        return "DATASTREAM";
    }

    @Override
    public String getModelRefId() {
        return null;
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        try {
            return this.getSrcPSDEDataFlowNode();
        }
        catch (Exception e) {
            log.error((Object)e.getMessage());
            return this.getPSDEDataFlow();
        }
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSDEDataFlow();
    }

    @Override
    protected String onGetRTMOSFilePath() {
        return null;
    }
}

