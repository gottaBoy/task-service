/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.uiaction;

import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;
import net.ibizsys.model.view.IPSUIActionGroupDetail;

public interface IPSDEUIActionGroupDetail
extends IPSUIActionGroupDetail {
    public static final String DETAILTYPE_DEUIACTION = "DEUIACTION";
    public static final String DETAILTYPE_SEPERATOR = "SEPERATOR";

    public IPSDEUIActionGroup getPSDEUIActionGroup();

    public IPSDEUIAction getPSDEUIAction();

    public String getDetailType();
}

