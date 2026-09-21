/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package net.ibizsys.paas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.view.IDynaViewSetting;
import net.ibizsys.paas.web.IWebContext;

public interface IDynaViewControllerInst
extends IViewController {
    public static final String ATTR_CTRLS = "ctrls";
    public static final String ATTR_UIACTIONS = "uiactions";

    public void init(IDynaViewController var1, IEntity var2, IDynaViewSetting var3) throws Exception;

    public boolean process(HttpServletRequest var1, HttpServletResponse var2, IWebContext var3) throws Exception;

    public IDynaViewController getDynaViewController();

    public IDynaViewSetting getDynaViewSetting();

    public String getDynaViewMode();
}

