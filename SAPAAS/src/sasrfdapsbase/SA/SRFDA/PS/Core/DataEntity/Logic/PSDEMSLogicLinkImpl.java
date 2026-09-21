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

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicLinkGroupCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEMSLogicLinkGroupCondImpl;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
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

@PSModelPFIgnoreMeta
public class PSDEMSLogicLinkImpl
extends PSObjectImpl
implements IPSDEMSLogicLink {
    private static final Log log = LogFactory.getLog(PSDEMSLogicLinkImpl.class);
    protected IPSDEMSLogic iPSDEMSLogic;
    protected PSDELogicLink psDELogicLink;
    protected ArrayList<IPSDEMSLogicLinkCond> psDEMSLogicLinkCondList = new ArrayList();
    protected PSDEMSLogicLinkGroupCondImpl psDEMSLogicLinkGroupCondImpl = null;
    private boolean bDefaultLink = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEMSLogic iPSDEMSLogic, PSDELogicLink psDELogicLink) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEMSLogic = iPSDEMSLogic;
            this.psDELogicLink = psDELogicLink;
            this.setId(this.psDELogicLink.getPSDELOGICLINKID());
            this.setName(this.psDELogicLink.getPSDELOGICLINKNAME());
            this.setPSObjectData(this.psDELogicLink);
            if (!psDELogicLink.isDEFAULTLINKNull()) {
                this.bDefaultLink = psDELogicLink.getDEFAULTLINK();
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
        this.preparePSDEMSLogicLinkConds();
    }

    protected void preparePSDEMSLogicLinkConds() throws Exception {
        this.psDEMSLogicLinkGroupCondImpl = null;
        this.psDEMSLogicLinkCondList.clear();
        ArrayList<PSDELogicLinkCond> psDEMSLogicLinkCondList = this.psDELogicLink.getPSDELogicLinkConds(false);
        if (psDEMSLogicLinkCondList == null) {
            return;
        }
        PSDELogicLinkCond groupPSDELogicLinkCond = new PSDELogicLinkCond();
        groupPSDELogicLinkCond.setPSDELLCONDID(this.getId());
        groupPSDELogicLinkCond.setLOGICTYPE("GROUP");
        groupPSDELogicLinkCond.setGROUPNOTFLAG(false);
        groupPSDELogicLinkCond.setGROUPOP("AND");
        for (PSDELogicLinkCond psDELogicLinkCond : psDEMSLogicLinkCondList) {
            groupPSDELogicLinkCond.getChildPSDELogicLinkConds(true).add(psDELogicLinkCond);
        }
        this.psDEMSLogicLinkGroupCondImpl = new PSDEMSLogicLinkGroupCondImpl();
        this.psDEMSLogicLinkGroupCondImpl.init(this.getDAGlobalHelper(), this, null, groupPSDELogicLinkCond);
        this.addToPSDELogicLinkCondList(this.psDEMSLogicLinkGroupCondImpl);
    }

    /*
     * Unable to fully structure code
     */
    protected void addToPSDELogicLinkCondList(IPSDEMSLogicLinkCond iPSDEMSLogicLinkCond) throws Exception {
        block1: {
            this.psDEMSLogicLinkCondList.add(iPSDEMSLogicLinkCond);
            if (!(iPSDEMSLogicLinkCond instanceof IPSDEMSLogicLinkGroupCond)) break block1;
            iPSDEMSLogicLinkGroupCond = (IPSDEMSLogicLinkGroupCond)iPSDEMSLogicLinkCond;
            psDELogicLinkConds = iPSDEMSLogicLinkGroupCond.getPSDEMSLogicLinkConds();
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
    public IPSDEMSLogicLinkGroupCond getPSDEMSLogicLinkGroupCond() {
        if (this.psDEMSLogicLinkGroupCondImpl == null || this.psDEMSLogicLinkGroupCondImpl.getPSDEMSLogicLinkConds() == null) {
            return null;
        }
        return this.psDEMSLogicLinkGroupCondImpl;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u4e3b\u72b6\u6001\u8282\u70b9\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEMSLogic", fields={"DSTPSDELOGICNODEID"})
    public IPSDEMSLogicNode getDstPSDEMSLogicNode() throws Exception {
        return this.iPSDEMSLogic.getPSDEMSLogicNode(this.psDELogicLink.getDSTPSDELOGICNODEID());
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u4e3b\u72b6\u6001\u8282\u70b9\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEMSLogic", ignorert=3, fields={"SRCPSDELOGICNODEID"})
    public IPSDEMSLogicNode getSrcPSDEMSLogicNode() throws Exception {
        return this.iPSDEMSLogic.getPSDEMSLogicNode(this.psDELogicLink.getSRCPSDELOGICNODEID());
    }

    @Override
    public IPSDEMSLogic getPSDEMSLogic() {
        return this.iPSDEMSLogic;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEMSLogic().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEMSLOGICLINK";
    }

    @Override
    public Class<?> getModelClass(String strModelType) {
        return super.getModelClass(strModelType);
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEMSLogic().getModelId(), (Object)super.getModelId());
    }

    public Iterator<IPSDEMSLogicLinkCond> getAllPSDEMSLogicLinkConds() {
        if (this.psDEMSLogicLinkCondList.size() == 0) {
            return null;
        }
        return this.psDEMSLogicLinkCondList.iterator();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEMSLogic().getPSDataEntity().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u8fde\u63a5", ignoredumpvalues="false", fields={"DEFAULTLINK"})
    public boolean isDefaultLink() {
        return false;
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

