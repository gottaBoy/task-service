/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.dataentity.field.IPSLinkDEField;
import net.ibizsys.model.dataentity.field.IPSPickupDEField;
import net.ibizsys.model.der.IPSDER1N;

public interface IPSPickupDataDEField
extends IPSLinkDEField {
    public IPSPickupDEField getPSPickupDEField() throws Exception;

    public IPSDER1N getPSDER1N() throws Exception;

    public boolean isEnableWriteBack();
}

