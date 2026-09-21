/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule;

public interface IPSDEFormItemVR
extends IPSModelObject {
    public static final int CHECKMODE_FRONT = 1;
    public static final int CHECKMODE_BACKEND = 2;
    public static final int CHECKMODE_ALL = 3;

    public String getPSDEFormItemName();

    public IPSDEForm getPSDEForm();

    public IPSDEFValueRule getPSDEFValueRule();

    public IPSDEFormItem getPSDEFormItem();

    public int getCheckMode();
}

