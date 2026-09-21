/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.IPSSubAppRef;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.SubSys.IPSSubAppView;

@PSModelIgnoreMeta
public interface IPSAppSubSysDEView
extends IPSAppView {
    public IPSSubAppRef getPSSubAppRef();

    public IPSSubAppView getPSSubAppView();
}

