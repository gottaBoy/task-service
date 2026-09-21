/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ajax;

import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.util.IGlobalContext;
import net.ibizsys.paas.view.IView;

public interface IAjaxHandler {
    public void init(IGlobalContext var1, IApplication var2, String var3) throws Exception;

    public String getHandlerType();

    public IView getView();

    public void close();
}

