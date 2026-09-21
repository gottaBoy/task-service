/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemLogic;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSPanelItemLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSPanelItemLogicImpl
extends PSObjectImpl
implements IPSPanelItemLogic {
    private static final Log log = LogFactory.getLog(PSPanelItemLogicImpl.class);
    protected IPSPanelItem iPSPanelItem = null;
    protected PSPanelItemLogic psPanelItemLogic = null;
    protected IPSPanelItemLogic parentPSPanelItemLogic = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPanelItem iPSPanelItem, IPSPanelItemLogic parentPSPanelItemLogic, PSPanelItemLogic psPanelItemLogic) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSPanelItem = iPSPanelItem;
            this.psPanelItemLogic = psPanelItemLogic;
            this.parentPSPanelItemLogic = parentPSPanelItemLogic;
            this.setId(this.psPanelItemLogic.getPSPANELITEMLOGICID());
            this.setName(this.psPanelItemLogic.getPSPANELITEMLOGICNAME());
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    public String getLogicCat() {
        return this.psPanelItemLogic.getLOGICCAT();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u7c7b\u578b", fields={"LOGICTYPE"})
    public String getLogicType() {
        return this.psPanelItemLogic.getLOGICTYPE();
    }

    @Override
    public IPSPanelItem getPSPanelItem() {
        return this.iPSPanelItem;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSPanelItem.getPSSysModelInstId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSPanelItem().getPSPanel().getPSAppView().getPSSystem());
    }

    @Override
    public String getModelId() {
        if (this.getPSPanelItem() != null) {
            return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSPanelItem().getModelId(), (Object)this.getId());
        }
        return super.getModelId();
    }

    @Override
    public String getModelType() {
        return "PSPANELITEMLOGIC";
    }

    @Override
    public String getModelRefId() {
        return null;
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
    }
}

