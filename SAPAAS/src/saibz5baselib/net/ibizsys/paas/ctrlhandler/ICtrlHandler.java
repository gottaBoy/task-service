/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import org.hibernate.SessionFactory;

public interface ICtrlHandler {
    public static final int TEMPMODE_NONE = 0;
    public static final int TEMPMODE_MAJOR = 1;
    public static final int TEMPMODE_MINOR = 2;

    public void init(IViewController var1) throws Exception;

    public ICtrlModel getCtrlModel();

    public IViewController getViewController();

    public IWebContext getWebContext();

    public AjaxActionResult processAction(String var1, IWebContext var2) throws Exception;

    public int getTempMode();

    public boolean convertEntityFieldError(EntityFieldError var1) throws Exception;

    public String getName();

    public SessionFactory getSessionFactory();
}

