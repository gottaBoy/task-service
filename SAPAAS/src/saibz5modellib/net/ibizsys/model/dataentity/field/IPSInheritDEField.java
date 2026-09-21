/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.IPSLinkDEField;

public interface IPSInheritDEField
extends IPSLinkDEField {
    public IPSDEField getRealInheritPSDEField() throws Exception;
}

