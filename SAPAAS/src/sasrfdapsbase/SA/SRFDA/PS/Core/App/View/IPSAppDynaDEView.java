/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.DynaSys.IPSDynaDETempl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSAppDynaDEView
extends IPSAppView {
    public String getPSDynaDEViewTemplId();

    public String getPSDynaDEViewTemplName();

    public IPSDynaDETempl getPSDynaDETempl();
}

