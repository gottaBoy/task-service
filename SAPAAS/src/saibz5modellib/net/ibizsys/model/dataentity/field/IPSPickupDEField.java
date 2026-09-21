/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.dataentity.field.IPSLinkDEField;
import net.ibizsys.model.der.IPSDER1N;

public interface IPSPickupDEField
extends IPSLinkDEField {
    public IPSLinkDEField getPSPickupTextDEField() throws Exception;

    public String getPickupDataRange();

    public IPSDER1N getPSDER1N() throws Exception;
}

