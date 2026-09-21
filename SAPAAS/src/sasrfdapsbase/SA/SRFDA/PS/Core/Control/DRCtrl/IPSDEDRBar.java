/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.DRCtrl;

import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRBarGroup;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrl;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDRBar;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u8fb9\u680f\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEDRBar
extends IPSDRBar,
IPSDEDRCtrl {
    public Iterator<IPSDEDRBarGroup> getPSDEDRBarGroups() throws Exception;
}

