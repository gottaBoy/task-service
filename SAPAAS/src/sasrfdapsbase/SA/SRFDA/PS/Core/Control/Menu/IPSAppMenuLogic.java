/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Menu;

import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenu;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5e94\u7528\u83dc\u5355\u90e8\u4ef6\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSAppMenuLogic")
public interface IPSAppMenuLogic
extends IPSDEUILogicGroupDetail,
IPSControlObject {
    public IPSAppMenu getPSAppMenu();

    public String getPSAppMenuItemName();
}

