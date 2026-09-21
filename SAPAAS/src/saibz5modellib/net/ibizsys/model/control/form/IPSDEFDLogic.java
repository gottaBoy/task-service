/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSDEFDLogic
extends IPSModelObject {
    public static final String LOGICCAT_PANELVISIBLE = "PANELVISIBLE";
    public static final String LOGICCAT_ITEMENABLE = "ITEMENABLE";
    public static final String LOGICCAT_ITEMBLANK = "ITEMBLANK";
    public static final String LOGICTYPE_GROUP = "GROUP";
    public static final String LOGICTYPE_SINGLE = "SINGLE";
    public static final String LOGICTYPE_CUSTOM = "CUSTOM";

    public IPSDEFormDetail getPSDEFormDetail();

    public String getLogicCat();

    public String getLogicType();
}

