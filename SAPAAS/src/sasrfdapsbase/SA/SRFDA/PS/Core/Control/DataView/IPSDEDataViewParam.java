/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.grid.IGridHandlerParam
 */
package SA.SRFDA.PS.Core.Control.DataView;

import SA.SRFDA.PS.Core.Control.IPSMDAjaxControlParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import net.ibizsys.paas.control.grid.IGridHandlerParam;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5361\u7247\u89c6\u56fe\u90e8\u4ef6\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSDEDataViewParam
extends IPSMDAjaxControlParam,
IGridHandlerParam {
    public String getPSDEDataViewId();

    public Boolean isSingleSelect();
}

