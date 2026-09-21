/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Menu;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelInterfaceMeta(title="\u4e0a\u4e0b\u6587\u83dc\u5355\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSContextMenuParam
extends IPSControlParam {
    public Object getOwner();
}

