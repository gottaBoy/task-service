/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.controller;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.controller.IViewControllerPlugin;

public interface IViewControllerGlobalPlugin {
    public void registerViewController(String var1, IViewController var2) throws Exception;

    public void registerViewControllerPlugin(String var1, IViewControllerPlugin var2) throws Exception;

    public IViewController getViewController(Class var1) throws Exception;

    public IViewController getViewController(String var1) throws Exception;
}

