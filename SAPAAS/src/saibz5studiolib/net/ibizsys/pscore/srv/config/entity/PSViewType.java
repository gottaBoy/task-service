/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.service.ServiceGlobal
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.config.entity;

import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.config.entity.PSVTCtrl;
import net.ibizsys.pscore.srv.config.entity.PSVTRV;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeBase;
import net.ibizsys.pscore.srv.config.service.PSVTCtrlService;
import net.ibizsys.pscore.srv.config.service.PSVTRVService;
import org.hibernate.SessionFactory;

public class PSViewType
extends PSViewTypeBase {
    private Object objPSVTCtrlsLock = new Object();
    private ArrayList<PSVTCtrl> psvtctrls = null;
    private Object objPSVTRVsLock = new Object();
    private ArrayList<PSVTRV> psvtrvs = null;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSVTCtrl> getValidPSVTCtrls() throws Exception {
        if (this.getPSViewTypeId() == null) {
            return null;
        }
        PSVTCtrlService pSVTCtrlService = (PSVTCtrlService)ServiceGlobal.getService(PSVTCtrlService.class, (SessionFactory)this.getSessionFactory());
        Object object = this.objPSVTCtrlsLock;
        synchronized (object) {
            if (this.psvtctrls == null) {
                this.psvtctrls = new ArrayList();
                ArrayList<PSVTCtrl> arrayList = pSVTCtrlService.selectByPSViewType(this);
                for (PSVTCtrl pSVTCtrl : arrayList) {
                    if (!DataObject.getBoolValue((Integer)pSVTCtrl.getValidFlag(), (boolean)true)) continue;
                    this.psvtctrls.add(pSVTCtrl);
                }
            }
            return this.psvtctrls;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSVTRV> getValidPSVTRVs() throws Exception {
        if (this.getPSViewTypeId() == null) {
            return null;
        }
        PSVTRVService pSVTRVService = (PSVTRVService)ServiceGlobal.getService(PSVTRVService.class, (SessionFactory)this.getSessionFactory());
        Object object = this.objPSVTRVsLock;
        synchronized (object) {
            if (this.psvtrvs == null) {
                this.psvtrvs = new ArrayList();
                ArrayList<PSVTRV> arrayList = pSVTRVService.selectByPSViewType(this);
                for (PSVTRV pSVTRV : arrayList) {
                    if (!DataObject.getBoolValue((Integer)pSVTRV.getValidFlag(), (boolean)true)) continue;
                    this.psvtrvs.add(pSVTRV);
                }
            }
            return this.psvtrvs;
        }
    }
}

