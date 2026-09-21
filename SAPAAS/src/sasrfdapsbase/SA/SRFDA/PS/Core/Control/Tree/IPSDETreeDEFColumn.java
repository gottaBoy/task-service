/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeColumn;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6811\u8868\u683c\u5c5e\u6027\u5217\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDETreeCol")
public interface IPSDETreeDEFColumn
extends IPSDETreeColumn {
    public String getDefaultValue();

    public IPSCodeList getPSCodeList();
}

