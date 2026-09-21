/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.view.IPSViewType
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.app.view;

import java.util.Vector;
import net.ibizsys.model.app.PSApplicationGlobalModelBase;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSAppView;
import net.ibizsys.model.view.IPSViewType;
import net.ibizsys.model.view.IPSViewTypeRuntime;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppViewGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppView, IPSAppView> {
    private static final Log log = LogFactory.getLog(PSAppViewGlobalModel.class);

    @Override
    protected PSAppView getObject(String strPSApplicationViewId) {
        PSAppView psApplicationView = new PSAppView();
        CallResult callResult = this.getPSModelQueryHelper().getPSApplicationView(strPSApplicationViewId, psApplicationView);
        if (callResult.isError()) {
            String strInfo = StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u89c6\u56fe[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSApplicationViewId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSApplicationRuntime().log(1, (IPSModelObject)this.getPSApplication(), strInfo);
            return null;
        }
        String strPSDynaInstId = psApplicationView.getParamStringValue("PSDYNAINSTID", null);
        if (!StringHelper.isNullOrEmpty((String)this.getPSDynaInstId())) {
            if (StringHelper.compare((String)strPSDynaInstId, (String)this.getPSDynaInstId(), (boolean)false) != 0) {
                String strInfo = StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u89c6\u56fe[%1$s]\u53d1\u751f\u9519\u8bef\uff0c\u9519\u8bef\u7684\u52a8\u6001\u5b9e\u4f8b[%2$s]\uff0c\u5f53\u524d\u5b9e\u4f8b[%3$s]", (Object)strPSApplicationViewId, (Object)strPSDynaInstId, (Object)this.getPSDynaInstId());
                log.warn((Object)strInfo);
                return null;
            }
        } else if (!StringHelper.isNullOrEmpty((String)strPSDynaInstId)) {
            String strInfo = StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u89c6\u56fe[%1$s]\u53d1\u751f\u9519\u8bef\uff0c\u9519\u8bef\u7684\u52a8\u6001\u5b9e\u4f8b[%2$s]\uff0c\u5f53\u524d\u5b9e\u4f8b[%3$s]", (Object)strPSApplicationViewId, (Object)strPSDynaInstId, (Object)this.getPSDynaInstId());
            log.warn((Object)strInfo);
            return null;
        }
        return psApplicationView;
    }

    @Override
    protected IPSAppView onCreateModelHelper(PSAppView vt) throws Exception {
        long nTime = System.currentTimeMillis();
        if (StringHelper.isNullOrEmpty((String)vt.getPSDEVIEWBASEID()) && StringHelper.isNullOrEmpty((String)vt.getPSDYNADEVIEWTEMPLID()) && StringHelper.isNullOrEmpty((String)vt.getPSAPPUTILVIEWTYPE())) {
            if (StringHelper.isNullOrEmpty((String)vt.getPSAPPVIEWTYPE())) {
                throw new Exception(StringHelper.format((String)"\u5e94\u7528\u89c6\u56fe[%1$s][%2$s]\u6ca1\u6709\u6307\u5b9a\u89c6\u56fe\u7c7b\u578b", (Object)vt.getPSAPPVIEWNAME(), (Object)vt.getPSAPPVIEWID()));
            }
            IPSViewType iPSAppViewType = this.getPSModelStorageContext().getPSViewType(vt.getPSAPPVIEWTYPE());
            IPSAppView iPSApplicationView = ((IPSViewTypeRuntime)iPSAppViewType).createPSAppView(vt);
            long nValue = System.currentTimeMillis() - nTime;
            if (nValue >= 5L) {
                log.debug((Object)StringHelper.format((String)"\u6784\u5efa\u5e94\u7528\u89c6\u56fe[%1$s]\u8017\u65f6[%2$s]ms", (Object)iPSApplicationView.getName(), (Object)nValue));
            }
            return iPSApplicationView;
        }
        if (!StringHelper.isNullOrEmpty((String)vt.getPSDEVIEWTYPE())) {
            IPSViewType iPSAppViewType = this.getPSModelStorageContext().getPSViewType(vt.getPSDEVIEWTYPE());
            IPSAppView iPSApplicationView = ((IPSViewTypeRuntime)iPSAppViewType).createPSAppView(vt);
            long nValue = System.currentTimeMillis() - nTime;
            if (nValue >= 5L) {
                log.debug((Object)StringHelper.format((String)"\u6784\u5efa\u5e94\u7528\u89c6\u56fe[%1$s]\u8017\u65f6[%2$s]ms", (Object)iPSApplicationView.getName(), (Object)nValue));
            }
            return iPSApplicationView;
        }
        if (!StringHelper.isNullOrEmpty((String)vt.getPSDYNADEVIEWTYPE())) {
            IPSViewType iPSAppViewType = this.getPSModelStorageContext().getPSViewType(vt.getPSDYNADEVIEWTYPE());
            IPSAppView iPSApplicationView = ((IPSViewTypeRuntime)iPSAppViewType).createPSAppView(vt);
            long nValue = System.currentTimeMillis() - nTime;
            if (nValue >= 5L) {
                log.debug((Object)StringHelper.format((String)"\u6784\u5efa\u5e94\u7528\u89c6\u56fe[%1$s]\u8017\u65f6[%2$s]ms", (Object)iPSApplicationView.getName(), (Object)nValue));
            }
            return iPSApplicationView;
        }
        if (!StringHelper.isNullOrEmpty((String)vt.getPSAPPUTILVIEWTYPE())) {
            IPSViewType iPSAppViewType = this.getPSModelStorageContext().getPSViewType(vt.getPSAPPUTILVIEWTYPE());
            IPSAppView iPSApplicationView = ((IPSViewTypeRuntime)iPSAppViewType).createPSAppView(vt);
            long nValue = System.currentTimeMillis() - nTime;
            if (nValue >= 5L) {
                log.debug((Object)StringHelper.format((String)"\u6784\u5efa\u5e94\u7528\u89c6\u56fe[%1$s]\u8017\u65f6[%2$s]ms", (Object)iPSApplicationView.getName(), (Object)nValue));
            }
            return iPSApplicationView;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u521b\u5efa\u5e94\u7528\u89c6\u56fe[%1$s][%2$s]\u5bf9\u8c61\uff0c\u65e0\u6cd5\u8bc6\u522b\u7684\u89c6\u56fe\u7c7b\u578b", (Object)vt.getPSAPPVIEWNAME(), (Object)vt.getPSAPPVIEWID()));
    }

    @Override
    protected Boolean testObjectRenew(PSAppView obj) {
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSAppView findModelHelper(String objObjectId, boolean bTryMode) throws Exception {
        IPSAppView iPSAppView = (IPSAppView)super.findModelHelper(objObjectId, bTryMode);
        if (iPSAppView == null) {
            return iPSAppView;
        }
        IPSAppView iPSAppView2 = iPSAppView;
        synchronized (iPSAppView2) {
            if (!((IPSAppViewRuntime)iPSAppView).isInited()) {
                PSAppView psAppView = this.getObject(objObjectId);
                long nTime = System.currentTimeMillis();
                try {
                    ((IPSAppViewRuntime)iPSAppView).init(this.getPSModelStorageContext(), this.getPSApplication(), psAppView);
                    long nValue = System.currentTimeMillis() - nTime;
                    if (nValue >= 5L) {
                        log.debug((Object)StringHelper.format((String)"\u6784\u5efa\u5e94\u7528\u89c6\u56fe[%1$s]\u8017\u65f6[%2$s]ms", (Object)iPSAppView.getName(), (Object)nValue));
                    }
                }
                catch (Exception ex) {
                    String strInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u5e94\u7528\u89c6\u56fe[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)psAppView.getPSAPPVIEWNAME(), (Object)ex.getMessage());
                    log.error((Object)strInfo, (Throwable)ex);
                    this.getPSApplicationRuntime().log(1, (IPSModelObject)this.getPSApplication(), strInfo);
                    throw new Exception(strInfo, ex);
                }
            }
        }
        return iPSAppView;
    }

    @Override
    protected IPSAppView registerModel(PSAppView vt) throws Exception {
        IPSAppView iPSAppView = (IPSAppView)this.internalGetModelHelper(vt.getPSAPPVIEWID());
        if (iPSAppView != null) {
            return iPSAppView;
        }
        this.setModel(vt.getPSAPPVIEWID(), vt, null);
        return (IPSAppView)this.findModelHelper(vt.getPSAPPVIEWID());
    }

    @Override
    protected Vector<PSAppView> getAllModels() throws Exception {
        Vector<PSAppView> list = new Vector<PSAppView>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSApplicationViews(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u89c6\u56fe\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSAppView psAppView : list) {
            this.setModel(psAppView.getPSAPPVIEWID(), psAppView, null);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSAppView vt) {
        return vt.getPSAPPVIEWID();
    }
}

