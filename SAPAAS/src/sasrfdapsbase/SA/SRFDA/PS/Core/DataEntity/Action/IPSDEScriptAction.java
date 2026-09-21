/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(typevalue={"SCRIPT"}, title="\u5b9e\u4f53\u81ea\u5b9a\u4e49\u811a\u672c\u884c\u4e3a\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEScriptAction
extends IPSDEAction {
    public String getScriptCode();
}

