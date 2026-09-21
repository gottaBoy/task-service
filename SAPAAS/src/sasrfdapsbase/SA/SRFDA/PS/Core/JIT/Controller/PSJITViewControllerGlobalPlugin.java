/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.controller.IViewControllerGlobalPlugin
 *  net.ibizsys.paas.controller.IViewControllerPlugin
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.Controller;

import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.controller.IViewControllerGlobalPlugin;
import net.ibizsys.paas.controller.IViewControllerPlugin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITViewControllerGlobalPlugin
implements IViewControllerGlobalPlugin {
    private final Log log = LogFactory.getLog(PSJITViewControllerGlobalPlugin.class);
    private HashMap<String, IViewController> viewControllerMap = new HashMap();
    private HashMap<String, ArrayList<IViewControllerPlugin>> viewControllerPluginMap = new HashMap();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerViewController(String strViewControllerClsType, IViewController iViewController) throws Exception {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.getInstance().getAppModel().registerViewController2(strViewControllerClsType, iViewController);
            return;
        }
        HashMap<String, IViewController> hashMap = this.viewControllerMap;
        synchronized (hashMap) {
            this.viewControllerMap.put(strViewControllerClsType, iViewController);
        }
    }

    public IViewController getViewController(Class cls) throws Exception {
        return this.getViewController(cls.getCanonicalName());
    }

    public IViewController getViewController(String strViewControllerClsType) throws Exception {
        if (PSJITWebContext.getInstance() != null) {
            return PSJITWebContext.getInstance().getAppModel().getViewController2(strViewControllerClsType);
        }
        return this.internalGetViewController(strViewControllerClsType);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private IViewController internalGetViewController(String strViewControllerClsType) throws Exception {
        HashMap<String, IViewController> hashMap = this.viewControllerMap;
        synchronized (hashMap) {
            IViewController iViewController = this.viewControllerMap.get(strViewControllerClsType);
            return iViewController;
        }
    }

    public void registerViewControllerPlugin(String strViewControllerClsType, IViewControllerPlugin iViewControllerPlugin) throws Exception {
    }
}

