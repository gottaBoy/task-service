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

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLink;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkCond;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkGroupCond;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNode;
import SA.SRFDA.PS.Core.Control.Panel.PSPanelLogicLinkGroupCondImpl;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSPanelLogicLink;
import SA.SRFDA.PS.Data.PSPanelLogicLinkCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSPanelLogicLinkImpl
extends PSObjectImpl
implements IPSPanelLogicLink {
    private static final Log log = LogFactory.getLog(PSPanelLogicLinkImpl.class);
    protected IPSPanelLogic iPSPanelLogic;
    protected PSPanelLogicLink psPanelLogicLink;
    protected ArrayList<IPSPanelLogicLinkCond> psPanelLogicLinkCondList = new ArrayList();
    protected PSPanelLogicLinkGroupCondImpl psPanelLogicLinkGroupCondImpl = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPanelLogic iPSPanelLogic, PSPanelLogicLink psPanelLogicLink) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSPanelLogic = iPSPanelLogic;
            this.psPanelLogicLink = psPanelLogicLink;
            this.setId(this.psPanelLogicLink.getPSPANELLOGICLINKID());
            this.setName(this.psPanelLogicLink.getPSPANELLOGICLINKNAME());
            this.setPSObjectData(this.psPanelLogicLink);
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
        this.preparePSPanelLogicLinkConds();
    }

    protected void preparePSPanelLogicLinkConds() throws Exception {
        this.psPanelLogicLinkGroupCondImpl = null;
        this.psPanelLogicLinkCondList.clear();
        ArrayList<PSPanelLogicLinkCond> psPanelLogicLinkCondList = this.psPanelLogicLink.getPSPanelLogicLinkConds(false);
        if (psPanelLogicLinkCondList == null) {
            return;
        }
        PSPanelLogicLinkCond groupPSPanelLogicLinkCond = new PSPanelLogicLinkCond();
        groupPSPanelLogicLinkCond.setPSPANELLLCONDID(this.getId());
        groupPSPanelLogicLinkCond.setLOGICTYPE("GROUP");
        groupPSPanelLogicLinkCond.setGROUPNOTFLAG(false);
        groupPSPanelLogicLinkCond.setGROUPOP("AND");
        for (PSPanelLogicLinkCond psPanelLogicLinkCond : psPanelLogicLinkCondList) {
            groupPSPanelLogicLinkCond.getChildPSPanelLogicLinkConds(true).add(psPanelLogicLinkCond);
        }
        this.psPanelLogicLinkGroupCondImpl = new PSPanelLogicLinkGroupCondImpl();
        this.psPanelLogicLinkGroupCondImpl.init(this.getDAGlobalHelper(), this, null, groupPSPanelLogicLinkCond);
        this.addToPSPanelLogicLinkCondList(this.psPanelLogicLinkGroupCondImpl);
    }

    /*
     * Unable to fully structure code
     */
    protected void addToPSPanelLogicLinkCondList(IPSPanelLogicLinkCond iPSPanelLogicLinkCond) throws Exception {
        block1: {
            this.psPanelLogicLinkCondList.add(iPSPanelLogicLinkCond);
            if (!(iPSPanelLogicLinkCond instanceof IPSPanelLogicLinkGroupCond)) break block1;
            iPSPanelLogicLinkGroupCond = (IPSPanelLogicLinkGroupCond)iPSPanelLogicLinkCond;
            psPanelLogicLinkConds = iPSPanelLogicLinkGroupCond.getPSPanelLogicLinkConds();
            if (psPanelLogicLinkConds != null) ** GOTO lbl9
            return;
lbl-1000:
            // 1 sources

            {
                this.addToPSPanelLogicLinkCondList(psPanelLogicLinkConds.next());
lbl9:
                // 2 sources

                ** while (psPanelLogicLinkConds.hasNext())
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u8fde\u63a5\u6761\u4ef6\u5bf9\u8c61", hideempty=true)
    public IPSPanelLogicLinkGroupCond getPSPanelLogicLinkGroupCond() {
        if (this.psPanelLogicLinkGroupCondImpl == null || this.psPanelLogicLinkGroupCondImpl.getPSPanelLogicLinkConds() == null) {
            return null;
        }
        return this.psPanelLogicLinkGroupCondImpl;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u8282\u70b9\u5bf9\u8c61", hideempty=true)
    public IPSPanelLogicNode getDstPSPanelLogicNode() throws Exception {
        return this.iPSPanelLogic.getPSPanelLogicNode(this.psPanelLogicLink.getDSTPSPANELLOGICNODEID());
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u903b\u8f91\u8282\u70b9\u5bf9\u8c61", hideempty=true)
    public IPSPanelLogicNode getSrcPSPanelLogicNode() throws Exception {
        return this.iPSPanelLogic.getPSPanelLogicNode(this.psPanelLogicLink.getSRCPSPANELLOGICNODEID());
    }

    @Override
    public String getLinkType() {
        return this.psPanelLogicLink.getLINKTYPE();
    }

    @Override
    public IPSPanelLogic getPSPanelLogic() {
        return this.iPSPanelLogic;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSPanelLogic().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSPANELLOGICLINK";
    }

    @Override
    public Iterator<IPSPanelLogicLinkCond> getAllPSPanelLogicLinkConds() {
        if (this.psPanelLogicLinkCondList.size() == 0) {
            return null;
        }
        return this.psPanelLogicLinkCondList.iterator();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSPanelLogic().getPSPanel().getPSAppView().getPSSystem());
    }
}

