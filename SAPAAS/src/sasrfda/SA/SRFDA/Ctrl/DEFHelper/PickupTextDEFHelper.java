/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.LinkDEFHelper;

public class PickupTextDEFHelper
extends LinkDEFHelper {
    @Override
    public boolean IsPhisicalDEField() {
        if (this.field.getDEFTYPE() == 1) {
            return true;
        }
        return super.IsPhisicalDEField();
    }
}

