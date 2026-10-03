/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.logic.IPSDELogic
 *  net.ibizsys.model.dataentity.logic.IPSDELogicLink
 *  net.ibizsys.model.dataentity.logic.IPSDELogicLinkCond
 *  net.ibizsys.model.dataentity.logic.IPSDELogicLinkGroupCond
 *  net.ibizsys.model.dataentity.logic.IPSDELogicNode
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.logic;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.dataentity.logic.IPSDELogicLink;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkCond;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkGroupCond;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkRuntime;
import net.ibizsys.model.dataentity.logic.IPSDELogicNode;
import net.ibizsys.model.dataentity.logic.PSDELogicLinkGroupCondImpl;
import net.ibizsys.model.entity.PSDELogicLink;
import net.ibizsys.model.entity.PSDELogicLinkCond;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicLinkImpl
extends PSObjectImpl
implements IPSDELogicLink,
IPSDELogicLinkRuntime {
    private static final Log log = LogFactory.getLog(PSDELogicLinkImpl.class);
    protected IPSDELogic iPSDELogic;
    protected PSDELogicLink psDELogicLink;
    protected ArrayList<IPSDELogicLinkCond> psDELogicLinkCondList = new ArrayList();
    protected PSDELogicLinkGroupCondImpl psDELogicLinkGroupCondImpl = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDELogic iPSDELogic, PSDELogicLink psDELogicLink) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSDELogic = iPSDELogic;
            this.psDELogicLink = psDELogicLink;
            this.setId(this.psDELogicLink.getPSDELOGICLINKID());
            this.setName(this.psDELogicLink.getPSDELOGICLINKNAME());
            this.setPSObjectData(this.psDELogicLink);
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
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
        groupPSDELogicLinkCond.setPSDELLCONDID(this.getId());
        groupPSDELogicLinkCond.setLOGICTYPE("GROUP");
        groupPSDELogicLinkCond.setGROUPNOTFLAG(false);
        groupPSDELogicLinkCond.setGROUPOP("AND");
        for (PSDELogicLinkCond psDELogicLinkCond : psDELogicLinkCondList) {
            groupPSDELogicLinkCond.getChildPSDELogicLinkConds(true).add(psDELogicLinkCond);
        }
        this.psDELogicLinkGroupCondImpl = new PSDELogicLinkGroupCondImpl();
        this.psDELogicLinkGroupCondImpl.init(this.getPSModelStorageContext(), this, null, groupPSDELogicLinkCond);
        this.addToPSDELogicLinkCondList(this.psDELogicLinkGroupCondImpl);
    }

    protected void addToPSDELogicLinkCondList(IPSDELogicLinkCond iPSDELogicLinkCond) throws Exception {
        this.psDELogicLinkCondList.add(iPSDELogicLinkCond);
        if (!(iPSDELogicLinkCond instanceof IPSDELogicLinkGroupCond)) {
            return;
        }
        IPSDELogicLinkGroupCond iPSDELogicLinkGroupCond = (IPSDELogicLinkGroupCond)iPSDELogicLinkCond;
        Iterator<IPSDELogicLinkCond> psDELogicLinkConds = iPSDELogicLinkGroupCond.getPSDELogicLinkConds();
        if (psDELogicLinkConds == null) {
            return;
        }
        while (psDELogicLinkConds.hasNext()) {
            this.addToPSDELogicLinkCondList(psDELogicLinkConds.next());
        }
    }

    @PSModelRTMeta(description="\u8fde\u63a5\u6761\u4ef6\u5bf9\u8c61", hideempty=true)
    public IPSDELogicLinkGroupCond getPSDELogicLinkGroupCond() {
        if (this.psDELogicLinkGroupCondImpl == null || this.psDELogicLinkGroupCondImpl.getPSDELogicLinkConds() == null) {
            return null;
        }
        return this.psDELogicLinkGroupCondImpl;
    }

    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u8282\u70b9\u5bf9\u8c61", hideempty=true)
    public IPSDELogicNode getDstPSDELogicNode() throws Exception {
        return this.iPSDELogic.getPSDELogicNode(this.psDELogicLink.getDSTPSDELOGICNODEID());
    }

    @PSModelRTMeta(description="\u6e90\u903b\u8f91\u8282\u70b9\u5bf9\u8c61", hideempty=true)
    public IPSDELogicNode getSrcPSDELogicNode() throws Exception {
        return this.iPSDELogic.getPSDELogicNode(this.psDELogicLink.getSRCPSDELOGICNODEID());
    }

    public IPSDELogic getPSDELogic() {
        return this.iPSDELogic;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.getPSDELogic());
    }

    public Iterator<IPSDELogicLinkCond> getAllPSDELogicLinkConds() {
        if (this.psDELogicLinkCondList.size() == 0) {
            return null;
        }
        return this.psDELogicLinkCondList.iterator();
    }
}
