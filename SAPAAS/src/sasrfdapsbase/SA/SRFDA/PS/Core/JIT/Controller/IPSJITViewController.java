/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  net.ibizsys.paas.controller.IViewController
 */
package SA.SRFDA.PS.Core.JIT.Controller;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.JIT.App.IPSJITAppModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.controller.IViewController;

public interface IPSJITViewController
extends IViewController {
    public IPSJITAppModel getPSJITAppModel();

    public IPSAppView getPSAppView();

    public void process(HttpServletRequest var1, HttpServletResponse var2) throws Exception;
}

