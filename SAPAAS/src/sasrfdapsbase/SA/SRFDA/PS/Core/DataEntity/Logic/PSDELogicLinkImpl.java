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

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkGroupCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicLinkGroupCondImpl;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDELogicLink;
import SA.SRFDA.PS.Data.PSDELogicLinkCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicLinkImpl
extends PSObjectImpl
implements IPSDELogicLink,
IPSAppDELogicLink {
    private static final Log log = LogFactory.getLog(PSDELogicLinkImpl.class);
    protected IPSDELogic iPSDELogic;
    protected PSDELogicLink psDELogicLink;
    protected ArrayList<IPSDELogicLinkCond> psDELogicLinkCondList = new ArrayList();
    protected PSDELogicLinkGroupCondImpl psDELogicLinkGroupCondImpl = null;
    protected IPSAppDELogic iPSAppDELogic;
    protected int nLinkMode = 0;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDELogic iPSDELogic, PSDELogicLink psDELogicLink) throws Exception {
        try {
            IPSAppDELogic iPSAppDELogic;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDELogic = iPSDELogic;
            this.psDELogicLink = psDELogicLink;
            this.setId(this.psDELogicLink.getPSDELOGICLINKID());
            this.setName(this.psDELogicLink.getPSDELOGICLINKNAME());
            this.setPSObjectData(this.psDELogicLink);
            if (iPSDELogic instanceof IPSAppDELogic && (iPSAppDELogic = (IPSAppDELogic)iPSDELogic).getPSAppDataEntity() != null) {
                this.iPSAppDELogic = iPSAppDELogic;
            }
            if (!psDELogicLink.isDEFAULTLINKNull()) {
                this.nLinkMode = psDELogicLink.GetParamIntValue("DEFAULTLINK", this.nLinkMode);
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
        this.preparePSDELogicLinkConds();
    }

    protected void preparePSDELogicLinkConds() throws Exception {
        this.psDELogicLinkGroupCondImpl = null;
        this.psDELogicLinkCondList.clear();
        ArrayList<PSDELogicLinkCond> psDELogicLinkCondList = this.psDELogicLink.getPSDELogicLinkConds(false);
        if (psDELogicLinkCondList == null) {
            return;
        }
        PSDELogicLinkCond groupPSDELogicLinkCond = new PSDELogicLinkCond();
        groupPSDELogicLinkCond.setPSDELLCONDNAME(String.format("\u8fde\u63a5\u6761\u4ef6\u7ec4", new Object[0]));
        groupPSDELogicLinkCond.setPSDELLCONDID(this.getId());
        groupPSDELogicLinkCond.setLOGICTYPE("GROUP");
        groupPSDELogicLinkCond.setGROUPNOTFLAG(false);
        groupPSDELogicLinkCond.setGROUPOP("AND");
        for (PSDELogicLinkCond psDELogicLinkCond : psDELogicLinkCondList) {
            groupPSDELogicLinkCond.getChildPSDELogicLinkConds(true).add(psDELogicLinkCond);
        }
        this.psDELogicLinkGroupCondImpl = new PSDELogicLinkGroupCondImpl();
        this.psDELogicLinkGroupCondImpl.init(this.getDAGlobalHelper(), this, null, groupPSDELogicLinkCond);
        this.addToPSDELogicLinkCondList(this.psDELogicLinkGroupCondImpl);
    }

    /*
     * Unable to fully structure code
     */
    protected void addToPSDELogicLinkCondList(IPSDELogicLinkCond iPSDELogicLinkCond) throws Exception {
        block1: {
            this.psDELogicLinkCondList.add(iPSDELogicLinkCond);
            if (!(iPSDELogicLinkCond instanceof IPSDELogicLinkGroupCond)) break block1;
            iPSDELogicLinkGroupCond = (IPSDELogicLinkGroupCond)iPSDELogicLinkCond;
            psDELogicLinkConds = iPSDELogicLinkGroupCond.getPSDELogicLinkConds();
            if (psDELogicLinkConds != null) ** GOTO lbl9
            return;
lbl-1000:
            // 1 sources

            {
                this.addToPSDELogicLinkCondList(psDELogicLinkConds.next());
lbl9:
                // 2 sources

                ** while (psDELogicLinkConds.hasNext())
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u8fde\u63a5\u6761\u4ef6\u5bf9\u8c61", hideempty=true, child=true)
    public IPSDELogicLinkGroupCond getPSDELogicLinkGroupCond() {
        if (this.psDELogicLinkGroupCondImpl == null || this.psDELogicLinkGroupCondImpl.getPSDELogicLinkConds() == null) {
            return null;
        }
        return this.psDELogicLinkGroupCondImpl;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u8282\u70b9\u5bf9\u8c61", hideempty=true, dumpref=true, rtname="getThen", from="IPSDELogic", fields={"DSTPSDELOGICNODEID"})
    public IPSDELogicNode getDstPSDELogicNode() throws Exception {
        return this.iPSDELogic.getPSDELogicNode(this.psDELogicLink.getDSTPSDELOGICNODEID());
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u903b\u8f91\u8282\u70b9\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", ignorert=3, fields={"SRCPSDELOGICNODEID"})
    public IPSDELogicNode getSrcPSDELogicNode() throws Exception {
        return this.iPSDELogic.getPSDELogicNode(this.psDELogicLink.getSRCPSDELOGICNODEID());
    }

    @Override
    public IPSDELogic getPSDELogic() {
        return this.iPSDELogic;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDELogic().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDELogic() != null) {
            return "PSAPPDELOGICLINK";
        }
        return "PSDELOGICLINK";
    }

    @Override
    public Class<?> getModelClass(String strModelType) {
        return super.getModelClass(strModelType);
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDELogic() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppDELogic().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    public Iterator<IPSDELogicLinkCond> getAllPSDELogicLinkConds() {
        if (this.psDELogicLinkCondList.size() == 0) {
            return null;
        }
        return this.psDELogicLinkCondList.iterator();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDELogic().getPSDataEntity().getPSSystem());
    }

    @Override
    public IPSAppDELogic getPSAppDELogic() {
        return this.iPSAppDELogic;
    }

    public int getLinkMode() {
        return this.nLinkMode;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u8fde\u63a5", ignoredumpvalues="false", fields={"DEFAULTLINK"})
    public boolean isDefaultLink() {
        return this.getLinkMode() == 1;
    }

    @Override
    @PSModelRTMeta(description="\u5f02\u5e38\u5904\u7406\u8fde\u63a5", ignoredumpvalues="false", fields={"DEFAULTLINK"})
    public boolean isCatchLink() {
        return this.getLinkMode() == 9;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u8c03\u7528\u8fde\u63a5", ignoredumpvalues="false", fields={"DEFAULTLINK"})
    public boolean isSubCallLink() {
        return this.getLinkMode() == 10;
    }

    @Override
    public String getModelRefId() {
        return null;
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        try {
            return this.getSrcPSDELogicNode();
        }
        catch (Exception e) {
            log.error((Object)e.getMessage());
            return this.getPSDELogic();
        }
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSDELogic();
    }

    @Override
    protected String onGetRTMOSFilePath() {
        return null;
    }
}

