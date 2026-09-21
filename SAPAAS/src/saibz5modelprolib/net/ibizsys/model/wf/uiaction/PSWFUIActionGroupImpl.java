/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.view.IPSUIAction
 *  net.ibizsys.model.view.IPSUIActionGroupDetail
 *  net.ibizsys.model.wf.IPSWFVersion
 *  net.ibizsys.model.wf.IPSWorkflow
 *  net.ibizsys.model.wf.uiaction.IPSWFUIAction
 *  net.ibizsys.model.wf.uiaction.IPSWFUIActionGroupDetail
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.wf.uiaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSDEUIActionGroup;
import net.ibizsys.model.entity.PSDEUIActionGroupDetail;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.model.view.IPSUIActionGroupDetail;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.model.wf.uiaction.IPSWFUIAction;
import net.ibizsys.model.wf.uiaction.IPSWFUIActionGroupDetail;
import net.ibizsys.model.wf.uiaction.IPSWFUIActionGroupRuntime;
import net.ibizsys.model.wf.uiaction.PSWFUIActionGroupDetailImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFUIActionGroupImpl
extends PSObjectImpl
implements IPSWFUIActionGroupRuntime {
    private static final Log log = LogFactory.getLog(PSWFUIActionGroupImpl.class);
    protected IPSWFVersion iPSWFVersion = null;
    protected PSDEUIActionGroup psDEUIActionGroup = null;
    protected ArrayList<IPSWFUIAction> psDEUIActionList = new ArrayList();
    protected ArrayList<IPSUIAction> psUIActionList = new ArrayList();
    protected ArrayList<IPSWFUIActionGroupDetail> psWFUIActionGroupDetailList = new ArrayList();
    protected ArrayList<IPSUIActionGroupDetail> psUIActionGroupDetailList = new ArrayList();

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSWFVersion iPSWFVersion, PSDEUIActionGroup psDEUIActionGroup) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.psDEUIActionGroup = psDEUIActionGroup;
            this.iPSWFVersion = iPSWFVersion;
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
        this.onPreparePSWFUIActions();
    }

    protected void onPreparePSWFUIActions() throws Exception {
        this.psDEUIActionList.clear();
        this.psUIActionList.clear();
        this.psWFUIActionGroupDetailList.clear();
        this.psUIActionGroupDetailList.clear();
        Vector<PSDEUIActionGroupDetail> psDEUIActionGroupDetailList = new Vector<PSDEUIActionGroupDetail>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEUIActionGroupDetails(this.getId(), psDEUIActionGroupDetailList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6d41\u7a0b\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEUIActionGroupDetail psDEUIActionGroupDetail : psDEUIActionGroupDetailList) {
            PSWFUIActionGroupDetailImpl iPSWFUIActionGroupDetail = new PSWFUIActionGroupDetailImpl();
            iPSWFUIActionGroupDetail.init(this.getPSModelStorageContext(), this, psDEUIActionGroupDetail);
            this.psWFUIActionGroupDetailList.add(iPSWFUIActionGroupDetail);
            if (iPSWFUIActionGroupDetail.getPSWFUIAction() == null) continue;
            this.psDEUIActionList.add(iPSWFUIActionGroupDetail.getPSWFUIAction());
        }
        this.psUIActionList.addAll(this.psDEUIActionList);
        this.psUIActionGroupDetailList.addAll(this.psWFUIActionGroupDetailList);
    }

    public Iterator<IPSWFUIAction> getPSWFUIActions() {
        if (this.psDEUIActionList == null || this.psDEUIActionList.size() == 0) {
            return null;
        }
        return this.psDEUIActionList.iterator();
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u96c6\u5408")
    public Iterator<IPSUIAction> getPSUIActions() {
        if (this.psUIActionList == null || this.psUIActionList.size() == 0) {
            return null;
        }
        return this.psUIActionList.iterator();
    }

    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u5bf9\u8c61")
    public IPSWorkflow getPSWorkflow() {
        return this.iPSWFVersion.getPSWorkflow();
    }

    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u7248\u672c\u5bf9\u8c61")
    public IPSWFVersion getPSWFVersion() {
        return this.iPSWFVersion;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.iPSWFVersion);
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458\u96c6\u5408")
    public Iterator<IPSUIActionGroupDetail> getPSUIActionGroupDetails() {
        if (this.psUIActionGroupDetailList == null || this.psUIActionGroupDetailList.size() == 0) {
            return null;
        }
        return this.psUIActionGroupDetailList.iterator();
    }

    public Iterator<IPSWFUIActionGroupDetail> getPSWFUIActionGroupDetails() {
        if (this.psWFUIActionGroupDetailList == null || this.psWFUIActionGroupDetailList.size() == 0) {
            return null;
        }
        return this.psWFUIActionGroupDetailList.iterator();
    }
}

