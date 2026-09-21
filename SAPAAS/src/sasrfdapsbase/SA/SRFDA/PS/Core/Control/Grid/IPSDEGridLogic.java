/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u8868\u683c\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEGridLogic")
public interface IPSDEGridLogic
extends IPSDEUILogicGroupDetail,
IPSControlObject {
    public IPSDEGrid getPSDEGrid();

    public String getPSDEGridColumnName();
}

