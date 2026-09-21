/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DAActionContext
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.Ctrl.DAActionContext;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.IPSActionContext;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.hibernate.SessionFactory;

public class PSActionContextImpl
extends DAActionContext
implements IPSActionContext {
    private String strLanguage = null;
    private String strPSSysModelInstId = null;

    public PSActionContextImpl(IDEDataCtrl iDEDataCtrl) {
        super(iDEDataCtrl);
    }

    public PSActionContextImpl(ISRFDAGlobalHelper iDAGlobalHelper, ISRFDAWebContext daWebContext) {
        super(iDAGlobalHelper, daWebContext, null);
    }

    @Override
    public String getLanguage() {
        return this.strLanguage;
    }

    public void setLanguage(String strLanguage) {
        this.strLanguage = strLanguage;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.strPSSysModelInstId;
    }

    @Override
    public IService getService(Class cls) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getPSSysModelInstId())) {
            return ServiceGlobal.getService((Class)cls);
        }
        return ServiceGlobal.getService((Class)cls, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
    }

    public void setPSSysModelInstId(String strPSSysModelInstId) {
        this.strPSSysModelInstId = strPSSysModelInstId;
    }
}

