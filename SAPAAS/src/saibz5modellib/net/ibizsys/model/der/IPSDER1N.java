/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDER1N
 */
package net.ibizsys.model.der;

import net.ibizsys.model.dataentity.field.IPSPickupDEField;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.paas.core.IDER1N;

public interface IPSDER1N
extends IPSDERBase,
IDER1N {
    public boolean isCloneRS();

    public int getMasterRS();

    public int getRemoveOrder();

    public int getRemoveActionType();

    public int getCloneOrder();

    public IPSPickupDEField getPSPickupDEField() throws Exception;
}

