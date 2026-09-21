/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeColumn;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5b9e\u4f53\u8868\u683c\u754c\u9762\u884c\u4e3a\u64cd\u4f5c\u5217\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"UAGRIDCOLUMN"})
public interface IPSDETreeNodeUAColumn
extends IPSDETreeNodeColumn {
    public IPSDEUIActionGroup getPSDEUIActionGroup();
}

