/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.list.IListDataItem
 */
package SA.SRFDA.PS.Core.Control.List;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Data.IPSDataItem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import net.ibizsys.paas.control.list.IListDataItem;

@PSModelInterfaceMeta(title="\u5217\u8868\u90e8\u4ef6\u6570\u636e\u9879\u6a21\u578b\u5bf9\u8c61\u57fa\u7840\u63a5\u53e3")
public interface IPSListDataItem
extends IPSDataItem,
IListDataItem {
    public IPSCodeList getFrontPSCodeList();

    public String getGroupItem();

    public boolean isCustomCode();

    public String getScriptCode();
}

