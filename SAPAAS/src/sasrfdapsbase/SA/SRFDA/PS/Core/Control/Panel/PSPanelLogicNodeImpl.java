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
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLink;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNode;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNodeParam;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicParam;
import SA.SRFDA.PS.Core.Control.Panel.PSPanelLogicLinkImpl;
import SA.SRFDA.PS.Core.Control.Panel.PSPanelLogicNodeParamImpl;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSPanelLogicLink;
import SA.SRFDA.PS.Data.PSPanelLogicNode;
import SA.SRFDA.PS.Data.PSPanelLogicNodeParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSPanelLogicNodeImpl
extends PSObjectImpl
implements IPSPanelLogicNode {
    private static final Log log = LogFactory.getLog(PSPanelLogicNodeImpl.class);
    protected IPSPanelLogic iPSPanelLogic;
    protected PSPanelLogicNode psPanelLogicNode;
    protected ArrayList<IPSPanelLogicLink> psPanelLogicLinkList = new ArrayList();
    protected ArrayList<IPSPanelLogicNodeParam> psPanelLogicNodeParamList = new ArrayList();
    protected IPSPanelLogicParam iPSPanelLogicParam = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPanelLogic iPSPanelLogic, PSPanelLogicNode psPanelLogicNode) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSPanelLogic = iPSPanelLogic;
            this.psPanelLogicNode = psPanelLogicNode;
            this.setId(this.psPanelLogicNode.getPSPANELLOGICNODEID());
            this.setName(this.psPanelLogicNode.getPSPANELLOGICNODENAME());
            this.setPSObjectData(this.psPanelLogicNode);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psPanelLogicNode.getPSPANELLOGICPARAMID())) {
                this.iPSPanelLogicParam = this.iPSPanelLogic.getPSPanelLogicParam(this.psPanelLogicNode.getPSPANELLOGICPARAMID());
            }
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
        this.preparePSPanelLogicLinks();
        this.preparePSPanelLogicNodeParams();
    }

    protected void preparePSPanelLogicLinks() throws Exception {
        this.psPanelLogicLinkList.clear();
        ArrayList<PSPanelLogicLink> psPanelLogicLinkList = this.psPanelLogicNode.getPSPanelLogicLinks(false);
        if (psPanelLogicLinkList == null) {
            return;
        }
        for (PSPanelLogicLink psPanelLogicLink : psPanelLogicLinkList) {
            PSPanelLogicLinkImpl iPSPanelLogicLink = new PSPanelLogicLinkImpl();
            iPSPanelLogicLink.init(this.getDAGlobalHelper(), this.iPSPanelLogic, psPanelLogicLink);
            this.psPanelLogicLinkList.add(iPSPanelLogicLink);
        }
    }

    protected void preparePSPanelLogicNodeParams() throws Exception {
        this.psPanelLogicNodeParamList.clear();
        ArrayList<PSPanelLogicNodeParam> psPanelLogicNodeParamList = this.psPanelLogicNode.getPSPanelLogicNodeParams(false);
        if (psPanelLogicNodeParamList == null) {
            return;
        }
        for (PSPanelLogicNodeParam psPanelLogicNodeParam : psPanelLogicNodeParamList) {
            PSPanelLogicNodeParamImpl iPSPanelLogicNodeParam = new PSPanelLogicNodeParamImpl();
            iPSPanelLogicNodeParam.init(this.getDAGlobalHelper(), this, psPanelLogicNodeParam);
            this.psPanelLogicNodeParamList.add(iPSPanelLogicNodeParam);
        }
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u8282\u70b9\u8fde\u51fa\u8fde\u63a5\u96c6\u5408")
    public Iterator<IPSPanelLogicLink> getPSPanelLogicLinks() {
        if (this.psPanelLogicLinkList == null || this.psPanelLogicLinkList.size() == 0) {
            return null;
        }
        return this.psPanelLogicLinkList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u8282\u70b9\u7c7b\u578b", codelist="PanelLogicNodeType")
    public String getLogicNodeType() {
        return this.psPanelLogicNode.getLOGICNODETYPE();
    }

    @Override
    public IPSPanelLogic getPSPanelLogic() {
        return this.iPSPanelLogic;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psPanelLogicNode.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u5e73\u884c\u8f93\u51fa")
    public boolean isParallelOutput() {
        return this.psPanelLogicNode.getPARALLELOUTPUT();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u8282\u70b9\u53c2\u6570\u96c6\u5408")
    public Iterator<IPSPanelLogicNodeParam> getPSPanelLogicNodeParams() {
        if (this.psPanelLogicNodeParamList == null || this.psPanelLogicNodeParamList.size() == 0) {
            return null;
        }
        return this.psPanelLogicNodeParamList.iterator();
    }

    @PSModelRTMeta(description="\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true)
    public IPSPanelLogicParam getPSPanelLogicParam() throws Exception {
        return this.iPSPanelLogicParam;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSPanelLogic().getPSSysModelInstId();
    }

    @Override
    public Object getParam(String strParamName, Object objDefault) {
        Object objValue = this.psPanelLogicNode.getParamValue(strParamName);
        if (objValue == null) {
            return objDefault;
        }
        return objValue;
    }

    @Override
    public String getModelType() {
        return "PSPANELLOGICNODE";
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSPanelLogic().getPSPanel().getPSAppView().getPSSystem());
    }
}

