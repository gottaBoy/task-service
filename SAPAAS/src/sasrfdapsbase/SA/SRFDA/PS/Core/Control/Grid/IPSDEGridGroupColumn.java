/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import java.util.Iterator;

@PSModelExtendMeta(title="\u5b9e\u4f53\u8868\u683c\u5206\u7ec4\u5217\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"GROUPGRIDCOLUMN"})
public interface IPSDEGridGroupColumn
extends IPSDEGridColumn {
    public Iterator<IPSDEGridColumn> getPSDEGridColumns();
}

