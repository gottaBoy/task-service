/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5de5\u5177\u680f\u90e8\u4ef6\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSDEToolbarParam
extends IPSControlParam {
    public Object getOwner();

    public String getPSDEToolbarId();

    public String getPSDEUIActionGroupId();

    public String getNo2PSDEUIActionGroupId();

    public String getNo3PSDEUIActionGroupId();

    public String getNo4PSDEUIActionGroupId();

    public String getNo5PSDEUIActionGroupId();

    public String getNo6PSDEUIActionGroupId();

    public String getToolbarStyle();
}

