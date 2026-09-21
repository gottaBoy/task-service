/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.IPSPickupTextDEField
 */
package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.field.IPSPickupTextDEField;
import net.ibizsys.model.dataentity.field.PSPickupDataDEFieldImpl;

public class PSPickupTextDEFieldImpl
extends PSPickupDataDEFieldImpl
implements IPSPickupTextDEField {
    @Override
    @PSModelRTMeta(description="\u7269\u7406\u5c5e\u6027")
    public boolean isPhisicalDEField() {
        if (this.getPSDEFieldData().getDEFTYPE() == 1) {
            return true;
        }
        return super.isPhisicalDEField();
    }
}

