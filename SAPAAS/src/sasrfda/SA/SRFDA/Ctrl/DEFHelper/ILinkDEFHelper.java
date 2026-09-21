/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;

public interface ILinkDEFHelper
extends IDEFHelper {
    public IDEFHelper GetRelatedDEFHelper();

    public IDEFHelper GetRealDEFHelper();

    public String GetDERId();

    public boolean IsCustomJoin();
}

