/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUIRawCodeLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;

public class PSDEUIRawCodeLogicImpl
extends PSDEUILogicNodeImpl
implements IPSDEUIRawCodeLogic {
    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u4ee3\u7801", fields={"PARAM4"})
    public String getCode() {
        return this.psDELogicNode.getPARAM4();
    }
}

