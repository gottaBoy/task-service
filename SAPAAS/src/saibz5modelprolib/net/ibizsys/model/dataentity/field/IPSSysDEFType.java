/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystemObject
 */
package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.dataentity.field.IPSDEFieldType;

public interface IPSSysDEFType
extends IPSDEFieldType,
IPSSystemObject {
    public IPSDEFieldType getPSDEFieldType();

    public String getPSCodeListId();

    public String getPSSysValueRuleId();
}

