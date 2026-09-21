/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Custom;

import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelInterfaceMeta(title="\u81ea\u5b9a\u4e49\u90e8\u4ef6\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSCustomControlParam
extends IPSAjaxControlParam {
    @Override
    public String getPSDEId();

    @Override
    public String getPSSysPFPluginId();

    public String getPSDEDataSetId();

    public String getPSDEActionId();
}

