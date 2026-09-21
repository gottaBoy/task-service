/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.DataView;

import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataView;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u770b\u677f\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDataView")
public interface IPSDEKanban
extends IPSDEDataView {
    public IPSControlAction getUpdateGroupPSControlAction();
}

