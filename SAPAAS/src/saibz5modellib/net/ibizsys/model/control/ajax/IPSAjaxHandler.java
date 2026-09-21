/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.ajax;

import java.util.Iterator;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.ajax.IPSAjaxHandlerAction;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSAjaxHandler
extends IPSModelObject {
    public String getHandlerObj();

    public Iterator<IPSAjaxHandlerAction> getPSAjaxHandlerActions();

    public IPSAjaxHandlerAction getPSAjaxHandlerAction(String var1, boolean var2) throws Exception;

    public IPSAppView getPSAppView();

    public String getUserTag();

    public String getUserTag2();

    public String getUserTag3();

    public String getUserTag4();
}

