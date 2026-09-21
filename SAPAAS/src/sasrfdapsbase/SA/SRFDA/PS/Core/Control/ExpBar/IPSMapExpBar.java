/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSExpBar;
import SA.SRFDA.PS.Core.Control.Map.IPSSysMap;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5730\u56fe\u5bfc\u822a\u680f\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSMapExpBar
extends IPSExpBar {
    public IPSSysMap getPSSysMap();
}

