/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEUIAction
 */
package net.ibizsys.model.dataentity.uiaction;

import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.paas.core.IDEUIAction;

public interface IPSDEUIAction
extends IPSDataEntityObject,
IPSUIAction,
IDEUIAction {
    public static final String UIACTIONTYPE_DEUIACTION = "DEUIACTION";

    public String getPSSysDEUIActionId(Object var1) throws Exception;

    public IPSDEAction getPSDEAction();

    public String getFrontPSDEViewId();

    public int getExtendMode();
}

