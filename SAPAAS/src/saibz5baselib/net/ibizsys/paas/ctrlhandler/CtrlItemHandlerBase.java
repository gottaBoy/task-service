/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletContext
 *  org.springframework.web.context.WebApplicationContext
 *  org.springframework.web.context.support.WebApplicationContextUtils
 */
package net.ibizsys.paas.ctrlhandler;

import javax.servlet.ServletContext;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlItemHandler;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class CtrlItemHandlerBase
implements ICtrlItemHandler {
    private ICtrlHandler iCtrlHandler = null;

    public void init(ICtrlHandler iCtrlHandler) throws Exception {
        this.setCtrlHandler(iCtrlHandler);
        this.onInit();
    }

    protected void onInit() throws Exception {
    }

    public ICtrlHandler getCtrlHandler() {
        return this.iCtrlHandler;
    }

    public void setCtrlHandler(ICtrlHandler iCtrlHandler) {
        this.iCtrlHandler = iCtrlHandler;
    }

    public IWebContext getWebContext() {
        return this.getCtrlHandler().getWebContext();
    }

    public IViewController getViewController() {
        return this.getCtrlHandler().getViewController();
    }

    @Override
    public AjaxActionResult processAction(String strAction) throws Exception {
        AjaxActionResult ajaxActionResult = this.onProcessAction(strAction);
        return ajaxActionResult;
    }

    protected AjaxActionResult onProcessAction(String strAction) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected Object getBean(String strName) {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext((ServletContext)this.getWebContext().getRequest().getSession().getServletContext());
        return ctx.getBean(strName);
    }
}

