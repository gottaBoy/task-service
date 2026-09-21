/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.map.IMap
 */
package SA.SRFDA.PS.Core.Control.Map;

import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlNavigatable;
import SA.SRFDA.PS.Core.Control.IPSMDAjaxControl;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import net.ibizsys.paas.control.map.IMap;

@PSModelInterfaceMeta(title="\u5730\u56fe\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u57fa\u7840\u63a5\u53e3", model="PSSysMap")
public interface IPSMap
extends IPSMDAjaxControl,
IMap,
IPSControlContainer,
IPSControlNavigatable {
    public String getMapStyle();

    public IPSLanguageRes getEmptyTextPSLanguageRes();

    public String getEmptyText();

    @Override
    public boolean isBufferRenderer();
}

