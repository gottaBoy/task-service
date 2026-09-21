/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.LinkDEFHelper;

public class InheritDEFHelper
extends LinkDEFHelper
implements IInheritDEFHelper {
    @Override
    public String GetDERId() {
        return this.iDEHelper.GetInheritDERId();
    }

    @Override
    protected String OnGetDefaultFormItemStyle() {
        return this.relatedDEFHelper.GetFormItemStyle();
    }

    @Override
    public boolean IsInheritDEField() {
        return true;
    }

    @Override
    public boolean IsPhisicalDEField() {
        return false;
    }
}

