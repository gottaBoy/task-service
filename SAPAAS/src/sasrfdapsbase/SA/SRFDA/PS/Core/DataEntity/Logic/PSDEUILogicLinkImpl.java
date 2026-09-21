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

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicLinkGroupCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicLinkGroupCondImpl;
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

public class PSDEUILogicLinkImpl
extends PSObjectImpl
implements IPSDEUILogicLink,
IPSAppDEUILogicLink {
    private static final Log log = LogFactory.getLog(PSDEUILogicLinkImpl.class);
    protected IPSDEUILogic iPSDEUILogic;
    protected PSDELogicLink psDELogicLink;
    protected ArrayList<IPSDEUILogicLinkCond> psDEUILogicLinkCondList = new ArrayList();
    protected PSDEUILogicLinkGroupCondImpl psDEUILogicLinkGroupCondImpl = null;
    protected IPSAppDEUILogic iPSAppDEUILogic;
    protected int nLinkMode = 0;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEUILogic iPSDEUILogic, PSDELogicLink psDELogicLink) throws Exception {
        try {
            IPSAppDEUILogic iPSAppDEUILogic;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEUILogic = iPSDEUILogic;
            this.psDELogicLink = psDELogicLink;
            this.setId(this.psDELogicLink.getPSDELOGICLINKID());
            this.setName(this.psDELogicLink.getPSDELOGICLINKNAME());
            this.setPSObjectData(this.psDELogicLink);
            if (iPSDEUILogic instanceof IPSAppDEUILogic && (iPSAppDEUILogic = (IPSAppDEUILogic)iPSDEUILogic).getPSAppDataEntity() != null) {
                this.iPSAppDEUILogic = iPSAppDEUILogic;
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
        this.preparePSDEUILogicLinkConds();
    }

    protected void preparePSDEUILogicLinkConds() throws Exception {
        this.psDEUILogicLinkGroupCondImpl = null;
        this.psDEUILogicLinkCondList.clear();
        ArrayList<PSDELogicLinkCond> psDEUILogicLinkCondList = this.psDELogicLink.getPSDELogicLinkConds(false);
        if (psDEUILogicLinkCondList == null) {
            return;
        }
        PSDELogicLinkCond groupPSDELogicLinkCond = new PSDELogicLinkCond();
        groupPSDELogicLinkCond.setPSDELLCONDID(this.getId());
        groupPSDELogicLinkCond.setLOGICTYPE("GROUP");
        groupPSDELogicLinkCond.setGROUPNOTFLAG(false);
        groupPSDELogicLinkCond.setGROUPOP("AND");
        for (PSDELogicLinkCond psDELogicLinkCond : psDEUILogicLinkCondList) {
            groupPSDELogicLinkCond.getChildPSDELogicLinkConds(true).add(psDELogicLinkCond);
        }
        this.psDEUILogicLinkGroupCondImpl = new PSDEUILogicLinkGroupCondImpl();
        this.psDEUILogicLinkGroupCondImpl.init(this.getDAGlobalHelper(), this, null, groupPSDELogicLinkCond);
        this.addToPSDELogicLinkCondList(this.psDEUILogicLinkGroupCondImpl);
    }

    /*
     * Unable to fully structure code
     */
    protected void addToPSDELogicLinkCondList(IPSDEUILogicLinkCond iPSDEUILogicLinkCond) throws Exception {
        block1: {
            this.psDEUILogicLinkCondList.add(iPSDEUILogicLinkCond);
            if (!(iPSDEUILogicLinkCond instanceof IPSDEUILogicLinkGroupCond)) break block1;
            iPSDEUILogicLinkGroupCond = (IPSDEUILogicLinkGroupCond)iPSDEUILogicLinkCond;
            psDELogicLinkConds = iPSDEUILogicLinkGroupCond.getPSDEUILogicLinkConds();
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
    public IPSDEUILogicLinkGroupCond getPSDEUILogicLinkGroupCond() {
        if (this.psDEUILogicLinkGroupCondImpl == null || this.psDEUILogicLinkGroupCondImpl.getPSDEUILogicLinkConds() == null) {
            return null;
        }
        return this.psDEUILogicLinkGroupCondImpl;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u8282\u70b9\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEUILogic", fields={"DSTPSDELOGICNODEID"})
    public IPSDEUILogicNode getDstPSDEUILogicNode() throws Exception {
        return this.iPSDEUILogic.getPSDEUILogicNode(this.psDELogicLink.getDSTPSDELOGICNODEID());
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u903b\u8f91\u8282\u70b9\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEUILogic", fields={"SRCPSDELOGICNODEID"})
    public IPSDEUILogicNode getSrcPSDEUILogicNode() throws Exception {
        return this.iPSDEUILogic.getPSDEUILogicNode(this.psDELogicLink.getSRCPSDELOGICNODEID());
    }

    @Override
    public IPSDEUILogic getPSDEUILogic() {
        return this.iPSDEUILogic;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEUILogic().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDEUILogic() != null) {
            return "PSAPPDEUILOGICLINK";
        }
        return "PSDEUILOGICLINK";
    }

    @Override
    public Class<?> getModelClass(String strModelType) {
        return super.getModelClass(strModelType);
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDEUILogic() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppDEUILogic().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    public Iterator<IPSDEUILogicLinkCond> getAllPSDEUILogicLinkConds() {
        if (this.psDEUILogicLinkCondList.size() == 0) {
            return null;
        }
        return this.psDEUILogicLinkCondList.iterator();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEUILogic().getPSDataEntity().getPSSystem());
    }

    @Override
    public IPSAppDEUILogic getPSAppDEUILogic() {
        return this.iPSAppDEUILogic;
    }

    @Override
    @PSModelRTMeta(description="\u8fde\u63a5\u6a21\u5f0f", codelist="DEUILogicLinkMode", fields={"DEFAULTLINK"})
    public int getLinkMode() {
        return this.nLinkMode;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u8fde\u63a5", ignoredumpvalues="false", fields={"DEFAULTLINK"}, doc="{@link #getLinkMode}\u7b49\u4e8e\u9ed8\u8ba4\u8fde\u63a5(1)")
    public boolean isDefaultLink() {
        return this.getLinkMode() == 1;
    }

    @Override
    @PSModelRTMeta(description="\u5f02\u6b65\u5b8c\u6210\u8fde\u63a5", ignoredumpvalues="false", fields={"DEFAULTLINK"}, doc="{@link #getLinkMode}\u7b49\u4e8e\u5f02\u6b65\u7ed3\u675f(2)")
    public boolean isFulfilledLink() {
        return this.getLinkMode() == 2;
    }

    @Override
    @PSModelRTMeta(description="\u5f02\u6b65\u62d2\u7edd\u8fde\u63a5", ignoredumpvalues="false", fields={"DEFAULTLINK"}, doc="{@link #getLinkMode}\u7b49\u4e8e\u5f02\u6b65\u62d2\u7edd(3)")
    public boolean isRejectedLink() {
        return this.getLinkMode() == 3;
    }

    @Override
    @PSModelRTMeta(description="\u5f02\u5e38\u5904\u7406\u8fde\u63a5", ignoredumpvalues="false", fields={"DEFAULTLINK"}, doc="{@link #getLinkMode}\u7b49\u4e8e\u5f02\u5e38\u5904\u7406(9)")
    public boolean isCatchLink() {
        return this.getLinkMode() == 9;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u8c03\u7528\u8fde\u63a5", ignoredumpvalues="false", fields={"DEFAULTLINK"}, doc="{@link #getLinkMode}\u7b49\u4e8e\u5f02\u5e38\u5904\u7406(10)")
    public boolean isSubCallLink() {
        return this.getLinkMode() == 10;
    }

    @Override
    @PSModelRTMeta(description="\u8fde\u63a5\u6761\u4ef6", hideempty2=true, fields={"LINKCOND"})
    public String getLinkCond() {
        return this.psDELogicLink.getLINKCOND();
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

