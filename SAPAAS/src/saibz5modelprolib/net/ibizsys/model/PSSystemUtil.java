/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.model.app.IPSApplicationObject
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.res.IPSSysPDTView
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model;

import net.ibizsys.model.app.IPSAppPDTView;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.IPSApplicationObject;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlObject;
import net.ibizsys.model.res.IPSSysPDTView;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSystemUtil {
    private static final Log log = LogFactory.getLog(PSSystemUtil.class);

    public static IPSApplication getRefPSApplication(Object objRef, boolean bTryMode) throws Exception {
        if (objRef == null) {
            throw new Exception("\u4f20\u5165\u5bf9\u8c61\u65e0\u6548");
        }
        if (objRef instanceof IPSApplication) {
            return (IPSApplication)objRef;
        }
        if (objRef instanceof IPSApplicationObject) {
            return ((IPSApplicationObject)objRef).getPSApplication();
        }
        IPSAppView iPSAppView = PSSystemUtil.getRefPSAppView(objRef, true);
        if (iPSAppView != null) {
            return iPSAppView.getPSApplication();
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u4ece\u5bf9\u8c61[%1$s]\u83b7\u53d6\u5e94\u7528\u7a0b\u5e8f\u5bf9\u8c61", (Object)objRef));
    }

    public static IPSAppView getRefPSAppView(Object objRef, boolean bTryMode) throws Exception {
        if (objRef == null) {
            throw new Exception("\u4f20\u5165\u5bf9\u8c61\u65e0\u6548");
        }
        if (objRef instanceof IPSAppView) {
            return (IPSAppView)objRef;
        }
        IPSControl iPSControl = PSSystemUtil.getRefPSControl(objRef, true);
        if (iPSControl != null) {
            return iPSControl.getPSAppView();
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u4ece\u5bf9\u8c61[%1$s]\u83b7\u53d6\u5e94\u7528\u89c6\u56fe\u5bf9\u8c61", (Object)objRef));
    }

    public static IPSControl getRefPSControl(Object objRef, boolean bTryMode) throws Exception {
        if (objRef == null) {
            throw new Exception("\u4f20\u5165\u5bf9\u8c61\u65e0\u6548");
        }
        if (objRef instanceof IPSControl) {
            return (IPSControl)objRef;
        }
        if (objRef instanceof IPSControlObject) {
            return ((IPSControlObject)objRef).getOwnedPSControl();
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u4ece\u5bf9\u8c61[%1$s]\u83b7\u53d6\u754c\u9762\u90e8\u4ef6\u5bf9\u8c61", (Object)objRef));
    }

    public static IPSAppView getPSAppView(IPSApplication iPSApplication, IPSSysPDTView iPSSysPDTView, boolean bTryMode) throws Exception {
        String strPSAppPDTViewId = KeyValueHelper.genUniqueId((String)iPSApplication.getId(), (String)iPSSysPDTView.getId());
        IPSAppPDTView iPSAppPDTView = ((IPSApplicationRuntime)iPSApplication).getPSAppPDTView(strPSAppPDTViewId, true);
        if (iPSAppPDTView != null && iPSAppPDTView.getPSAppView() != null) {
            return iPSAppPDTView.getPSAppView();
        }
        String strPSDEViewBaseId = iPSSysPDTView.getPSDEViewBaseId();
        if (!StringHelper.isNullOrEmpty((String)strPSDEViewBaseId)) {
            return ((IPSApplicationRuntime)iPSApplication).getPSAppViewByDEViewId(strPSDEViewBaseId, bTryMode);
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u4ece\u5e94\u7528[%1$s]\u4e2d\u83b7\u53d6\u7cfb\u7edf\u9884\u7f6e\u89c6\u56fe[%2$s]\u76f8\u5173\u8054\u7684\u5e94\u7528\u89c6\u56fe", (Object)iPSApplication.getName(), (Object)iPSSysPDTView.getName()));
    }
}

