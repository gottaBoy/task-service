/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.IExceptionHandler;
import net.ibizsys.paas.sysmodel.ISystemModel;

public abstract class ExceptionHandlerBase
implements IExceptionHandler {
    @Override
    public void log(ISystemModel iSystemModel, Object logger, Throwable throwable, String strMessage, Object objUserData) {
        if (logger instanceof ICtrlHandler) {
            this.onCtrlHandlerException(iSystemModel, (ICtrlHandler)logger, throwable, strMessage, objUserData);
            return;
        }
        if (logger instanceof IViewController) {
            this.onViewControllerException(iSystemModel, (IViewController)logger, throwable, strMessage, objUserData);
            return;
        }
        if (logger instanceof IService) {
            this.onServiceException(iSystemModel, (IService)logger, throwable, strMessage, objUserData);
            return;
        }
    }

    protected void onCtrlHandlerException(ISystemModel iSystemModel, ICtrlHandler iCtrlHandler, Throwable throwable, String strMessage, Object objUserData) {
    }

    protected void onViewControllerException(ISystemModel iSystemModel, IViewController iViewController, Throwable throwable, String strMessage, Object objUserData) {
    }

    protected void onServiceException(ISystemModel iSystemModel, IService iService, Throwable throwable, String strMessage, Object objUserData) {
    }
}

