/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIAction
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroupDetail
 *  net.ibizsys.model.view.IPSUIAction
 *  net.ibizsys.model.view.IPSUIActionGroupDetail
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.ISystem
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.uiaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.PSDataEntityObjectImpl;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroupDetail;
import net.ibizsys.model.dataentity.uiaction.PSDEUIActionGroupDetailImpl;
import net.ibizsys.model.entity.PSDEUIActionGroup;
import net.ibizsys.model.entity.PSDEUIActionGroupDetail;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.model.view.IPSUIActionGroupDetail;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUIActionGroupImpl
extends PSDataEntityObjectImpl
implements IPSDEUIActionGroup {
    private static final Log log = LogFactory.getLog(PSDEUIActionGroupImpl.class);
    protected PSDEUIActionGroup psDEUIActionGroup = null;
    protected ArrayList<IPSDEUIAction> psDEUIActionList = new ArrayList();
    protected ArrayList<IPSUIAction> psUIActionList = new ArrayList();
    protected ArrayList<IPSDEUIActionGroupDetail> psDEUIActionGroupDetailList = new ArrayList();
    protected ArrayList<IPSUIActionGroupDetail> psUIActionGroupDetailList = new ArrayList();
    private IPSSystem iPSSystem = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, IPSDataEntity iPSDataEntity, PSDEUIActionGroup psDEUIActionGroup) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSDataEntity(iPSDataEntity);
            this.iPSSystem = iPSSystem;
            if (this.iPSDataEntity != null) {
                this.iPSSystem = this.iPSDataEntity.getPSSystem();
            }
            this.psDEUIActionGroup = psDEUIActionGroup;
            this.setId(this.psDEUIActionGroup.getPSDEUAGROUPID());
            this.setName(this.psDEUIActionGroup.getPSDEUAGROUPNAME());
            this.setPSObjectData(this.psDEUIActionGroup);
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
        this.onPreparePSDEUIActions();
    }

    protected void onPreparePSDEUIActions() throws Exception {
        this.psDEUIActionList.clear();
        this.psUIActionList.clear();
        this.psDEUIActionGroupDetailList.clear();
        this.psUIActionGroupDetailList.clear();
        Vector<PSDEUIActionGroupDetail> psDEUIActionGroupDetailList = new Vector<PSDEUIActionGroupDetail>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEUIActionGroupDetails(this.getId(), psDEUIActionGroupDetailList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEUIActionGroupDetail psDEUIActionGroupDetail : psDEUIActionGroupDetailList) {
            if (!psDEUIActionGroupDetail.isVALIDFLAGNull() && !psDEUIActionGroupDetail.getVALIDFLAG()) continue;
            PSDEUIActionGroupDetailImpl iPSDEUIActionGroupDetail = new PSDEUIActionGroupDetailImpl();
            iPSDEUIActionGroupDetail.init(this.getPSModelStorageContext(), this, psDEUIActionGroupDetail);
            this.psDEUIActionGroupDetailList.add(iPSDEUIActionGroupDetail);
            if (iPSDEUIActionGroupDetail.getPSDEUIAction() == null) continue;
            this.psDEUIActionList.add(iPSDEUIActionGroupDetail.getPSDEUIAction());
        }
        this.psUIActionGroupDetailList.addAll(this.psDEUIActionGroupDetailList);
        this.psUIActionList.addAll(this.psDEUIActionList);
    }

    public Iterator<IPSDEUIAction> getPSDEUIActions() {
        if (this.psDEUIActionList == null || this.psDEUIActionList.size() == 0) {
            return null;
        }
        return this.psDEUIActionList.iterator();
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u5bf9\u8c61\u96c6\u5408")
    public Iterator<IPSUIAction> getPSUIActions() {
        if (this.psUIActionList == null || this.psUIActionList.size() == 0) {
            return null;
        }
        return this.psUIActionList.iterator();
    }

    @Override
    public IPSSystem getPSSystem() {
        return this.iPSSystem;
    }

    public ISystem getSystem() {
        return this.getPSSystem();
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.iPSSystem != null) {
            return ((IPSModelObjectRuntime)this.iPSSystem).getPSSysModelInstId();
        }
        return super.getPSSysModelInstId();
    }

    public Iterator<IPSDEUIActionGroupDetail> getPSDEUIActionGroupDetails() {
        if (this.psDEUIActionGroupDetailList == null || this.psDEUIActionGroupDetailList.size() == 0) {
            return null;
        }
        return this.psDEUIActionGroupDetailList.iterator();
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458\u5bf9\u8c61\u96c6\u5408")
    public Iterator<IPSUIActionGroupDetail> getPSUIActionGroupDetails() {
        if (this.psUIActionGroupDetailList == null || this.psUIActionGroupDetailList.size() == 0) {
            return null;
        }
        return this.psUIActionGroupDetailList.iterator();
    }
}

