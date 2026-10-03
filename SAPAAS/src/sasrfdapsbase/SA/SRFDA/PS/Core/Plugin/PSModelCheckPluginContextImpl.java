/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysIssue
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysIssueService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Plugin;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.Plugin.IPSModelCheckPlugin;
import SA.SRFDA.PS.Core.Plugin.IPSModelCheckPluginContext;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysIssue;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysIssueService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.hibernate.SessionFactory;

public class PSModelCheckPluginContextImpl
implements IPSModelCheckPluginContext {
    private IPSModelCheckPlugin iPSModelCheckEngine = null;
    private ThreadLocal<IPSSystem> psSystem = new ThreadLocal();
    private ThreadLocal<IPSDataEntity> psDataEntity = new ThreadLocal();
    private ThreadLocal<IPSApplication> psApplication = new ThreadLocal();
    private ThreadLocal<IPSModelObject> psModelObject = new ThreadLocal();
    private ThreadLocal<Integer> issueCount = new ThreadLocal();

    public void init(IPSModelCheckPlugin iPSModelCheckEngine) throws Exception {
        this.iPSModelCheckEngine = iPSModelCheckEngine;
    }

    public void setPSSystem(IPSSystem iPSSystem) {
        this.psSystem.set(iPSSystem);
    }

    public void setPSDataEntity(IPSDataEntity iPSDataEntity) {
        this.psDataEntity.set(iPSDataEntity);
    }

    public void setPSApplication(IPSApplication iPSApplication) {
        this.psApplication.set(iPSApplication);
    }

    public void setPSModelObject(IPSModelObject iPSModelObject) {
        this.psModelObject.set(iPSModelObject);
    }

    @Override
    public IPSSystem getPSSystem() {
        return this.psSystem.get();
    }

    @Override
    public IPSDataEntity getPSDataEntity() {
        return this.psDataEntity.get();
    }

    @Override
    public IPSApplication getPSApplication() {
        return this.psApplication.get();
    }

    @Override
    public IPSModelObject getPSModelObject() {
        return this.psModelObject.get();
    }

    public void reset() {
        this.issueCount.set(0);
        this.setPSSystem(null);
        this.setPSDataEntity(null);
        this.setPSApplication(null);
        this.setPSModelObject(null);
    }

    @Override
    public int getIssueCount() {
        return this.issueCount.get();
    }

    @Override
    public void logIssue(String strIssueSN, String strIssueInfo) throws Exception {
        this.issueCount.set(this.getIssueCount() + 1);
        PSSysIssue psSysIssue = new PSSysIssue();
        psSysIssue.setPSSystemId(this.getPSSystem().getId());
        psSysIssue.setPSSystemName(this.getPSSystem().getName());
        if (this.getPSDataEntity() != null) {
            psSysIssue.setPSDEId(this.getPSDataEntity().getId());
            psSysIssue.setPSDEName(this.getPSDataEntity().getName());
        }
        if (this.getPSApplication() != null) {
            psSysIssue.setPSSysAppId(this.getPSApplication().getId());
            psSysIssue.setPSSysAppName(this.getPSApplication().getName());
        }
        String strIssueTypeName = strIssueInfo;
        psSysIssue.setPSSysIssueId(strIssueSN);
        psSysIssue.setPSSysIssueName(strIssueTypeName);
        psSysIssue.setPSObjId(this.getPSModelObject().getId());
        psSysIssue.setPSObjName(this.getPSModelObject().getName());
        psSysIssue.setObjType(this.getPSModelObject().getModelType());
        PSSysIssueService psSysIssueService = (PSSysIssueService)ServiceGlobal.getService(PSSysIssueService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSystem().getPSSysModelInstId()));
        psSysIssueService.create(psSysIssue, false);
    }
}
