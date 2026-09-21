/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Custom;

import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;

@PSModelInterfaceMeta(title="\u81ea\u5b9a\u4e49\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSCustomControl
extends IPSAjaxControl {
    @Override
    public IPSSysPFPlugin getPSSysPFPlugin();

    public String getCustomTag();

    public String getCustomTag2();

    public IPSDEDataSet getPSDEDataSet();

    public IPSDEAction getPSDEAction();

    public String getPredefinedType();
}

