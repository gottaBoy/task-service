/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.IPSDynaInstSupportable;
import SA.SRFDA.PS.Core.IPSModelObject;

public interface IPSApplicationObject
extends IPSModelObject,
IPSDynaInstSupportable {
    public IPSApplication getPSApplication();
}

