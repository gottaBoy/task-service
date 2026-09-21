/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.grid.IGridHandlerParam
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.Control.IPSMDAjaxControlParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import net.ibizsys.paas.control.grid.IGridHandlerParam;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u8868\u683c\u90e8\u4ef6\u5904\u7406\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSDEGridParam
extends IPSMDAjaxControlParam,
IGridHandlerParam {
    public String getPSDEGridId();

    public Boolean isSingleSelect();

    public Boolean isEnableRowEdit();

    public Boolean isEnableColFilter();

    public Boolean isEnableCustomized();
}

