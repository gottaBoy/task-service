/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.controller;

import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.controller.IViewControllerGlobalPlugin;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ViewControllerGlobal {
    private static final Log log = LogFactory.getLog(ViewControllerGlobal.class);
    private static HashMap<String, IViewController> viewControllerMap = new HashMap();
    private static IViewControllerGlobalPlugin iViewControllerGlobalPlugin = null;

    public static void registerViewController(String strViewControllerClsType, IViewController iViewController) throws Exception {
        if (ViewControllerGlobal.getPlugin() != null) {
            ViewControllerGlobal.getPlugin().registerViewController(strViewControllerClsType, iViewController);
            return;
        }
        if (!viewControllerMap.containsKey(strViewControllerClsType)) {
            viewControllerMap.put(strViewControllerClsType, iViewController);
        }
    }

    public static IViewController getViewController(Class cls) throws Exception {
        if (ViewControllerGlobal.getPlugin() != null) {
            return ViewControllerGlobal.getPlugin().getViewController(cls);
        }
        return ViewControllerGlobal.getViewController(cls.getCanonicalName());
    }

    public static IViewController getViewController(String strViewControllerClsType) throws Exception {
        if (ViewControllerGlobal.getPlugin() != null) {
            return ViewControllerGlobal.getPlugin().getViewController(strViewControllerClsType);
        }
        IViewController iViewController = viewControllerMap.get(strViewControllerClsType);
        if (iViewController == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u63a7\u5236\u5668[%1$s]", strViewControllerClsType));
        }
        return iViewController;
    }

    public static void resetAllDynaViewControllerInsts() throws Exception {
        for (Map.Entry<String, IViewController> entry : viewControllerMap.entrySet()) {
            IViewController iViewController = entry.getValue();
            if (!(iViewController instanceof IDynaViewController)) continue;
            IDynaViewController iDynaViewController = (IDynaViewController)iViewController;
            iDynaViewController.resetDynaViewControllerInsts();
        }
    }

    public static void setPlugin(IViewControllerGlobalPlugin iViewControllerGlobalPlugin) {
        ViewControllerGlobal.iViewControllerGlobalPlugin = iViewControllerGlobalPlugin;
    }

    public static IViewControllerGlobalPlugin getPlugin() {
        return iViewControllerGlobalPlugin;
    }
}

