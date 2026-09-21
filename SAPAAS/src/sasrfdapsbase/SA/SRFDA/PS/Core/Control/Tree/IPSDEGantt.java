/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeGridEx;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u7518\u7279\u56fe\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDETreeView")
public interface IPSDEGantt
extends IPSDETreeGridEx {
    public static final String DATAITEM_BEGIN = "begin";
    public static final String DATAITEM_END = "end";
    public static final String DATAITEM_SN = "sn";
    public static final String DATAITEM_PREV = "prev";
    public static final String DATAITEM_TOTAL = "total";
    public static final String DATAITEM_FINISH = "finish";

    public String getBeginDataItemName();

    public String getEndDataItemName();

    public String getSNDataItemName();

    public String getPrevDataItemName();

    public String getTotalDataItemName();

    public String getFinishDataItemName();
}

