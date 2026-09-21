/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormItemUpdate;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.model.wf.uiaction.IPSWFUIAction;

public interface IPSDEFormButton
extends IPSDEFormDetail {
    public static final String ACTIONTYPE_UIACTION = "UIACTION";
    public static final String ACTIONTYPE_FIUPDATE = "FIUPDATE";

    public String getActionType();

    public String getPSUIActionId();

    public IPSUIAction getPSUIAction();

    public IPSDEUIAction getPSDEUIAction();

    public IPSWFUIAction getPSWFUIAction();

    public String getPSDEFIUpdateId();

    public IPSDEFormItemUpdate getPSDEFormItemUpdate();

    public String getTooltip();

    public IPSAppView getParamPickupPSAppView() throws Exception;
}

