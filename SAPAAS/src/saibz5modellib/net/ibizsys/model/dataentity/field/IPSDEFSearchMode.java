/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEFSearchMode
 */
package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.control.form.IPSDEFFormItem;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.field.IPSDEFieldObject;
import net.ibizsys.model.res.IPSSysDBValueFunc;
import net.ibizsys.paas.core.IDEFSearchMode;

public interface IPSDEFSearchMode
extends IPSDEFieldObject,
IDEFSearchMode,
IPSModelObject {
    public String getPSDEFId();

    public String getPSSysDBVFId();

    public String getPSDBValueOPId();

    public IPSDEFFormItem getPSDEFFormItem(String var1);

    public IPSSysDBValueFunc getPSSysDBValueFunc();

    public String getPSCodeListId();
}

