/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.entity;

import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterTS;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterTSService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import org.hibernate.SessionFactory;

public class PSSystem
extends PSSystemBase {
    private PSSystemBase proxyPSSystemBase = null;
    private Object objPSDevCenterTSLock = new Object();
    private PSDevCenterTS psdevcenterts = null;

    private PSSystemBase getProxyEntity() {
        return this.proxyPSSystemBase;
    }

    @Override
    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSystemBase = null;
        if (iDataObject != null && iDataObject instanceof PSSystemBase) {
            this.proxyPSSystemBase = (PSSystemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public PSDevCenterTS getPSDevCenterTS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterTS();
        }
        if (this.getPSDevCenterTSId() == null) {
            return null;
        }
        Object object = this.objPSDevCenterTSLock;
        synchronized (object) {
            if (this.psdevcenterts != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterTSId(), (Object)this.psdevcenterts.getPSDevCenterTSId()) != 0L) {
                this.psdevcenterts = null;
            }
            if (this.psdevcenterts == null) {
                PSDevCenterTS pSDevCenterTS = new PSDevCenterTS();
                pSDevCenterTS.setPSDevCenterTSId(this.getPSDevCenterTSId());
                PSDevCenterTSService pSDevCenterTSService = (PSDevCenterTSService)ServiceGlobal.getService(PSDevCenterTSService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                pSDevCenterTSService.autoGet(pSDevCenterTS);
                this.psdevcenterts = pSDevCenterTS;
            }
            return this.psdevcenterts;
        }
    }
}

