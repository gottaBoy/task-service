/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataView;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSExpBar;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5361\u7247\u89c6\u56fe\u5bfc\u822a\u680f\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDataViewExpBar
extends IPSExpBar {
    public IPSDEDataView getPSDEDataView();
}

