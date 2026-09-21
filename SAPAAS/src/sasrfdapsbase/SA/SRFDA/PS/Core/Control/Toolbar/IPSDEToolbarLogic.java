/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbar;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5de5\u5177\u680f\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEToolbarLogic")
public interface IPSDEToolbarLogic
extends IPSDEUILogicGroupDetail,
IPSControlObject {
    public IPSDEToolbar getPSDEToolbar();

    public String getPSDEToolbarItemName();
}

