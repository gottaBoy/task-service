/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.ICtrlHandler;

public class CtrlHandler {
    private static ThreadLocal<ICtrlHandler> ctrlHandler = new ThreadLocal();

    public static ICtrlHandler getCurrent() {
        return ctrlHandler.get();
    }

    public static void setCurrent(ICtrlHandler value) {
        ctrlHandler.set(value);
    }
}

