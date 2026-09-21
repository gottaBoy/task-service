/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.controller;

import net.ibizsys.paas.controller.IViewController;

public class ViewController {
    private static ThreadLocal<IViewController> viewController = new ThreadLocal();

    public static IViewController getCurrent() {
        return viewController.get();
    }

    public static void setCurrent(IViewController value) {
        viewController.set(value);
    }
}

