/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u884c\u4e3a\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DELOGIC"})
public interface IPSDELogicAction
extends IPSDEAction {
    public IPSDELogic getPSDELogic() throws Exception;

    @Override
    public int getActionHolder();
}

