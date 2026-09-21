/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.list.IList
 */
package SA.SRFDA.PS.Core.Control.List;

import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlNavigatable;
import SA.SRFDA.PS.Core.Control.IPSMDAjaxControl;
import SA.SRFDA.PS.Core.Control.List.IPSListDataItem;
import SA.SRFDA.PS.Core.Control.List.IPSListItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import java.util.Iterator;
import net.ibizsys.paas.control.list.IList;

@PSModelInterfaceMeta(title="\u5217\u8868\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u57fa\u7840\u63a5\u53e3")
public interface IPSList
extends IPSMDAjaxControl,
IList,
IPSControlContainer,
IPSControlNavigatable {
    public Iterator<IPSListItem> getPSListItems();

    public Iterator<IPSListDataItem> getPSListDataItems();

    public IPSLanguageRes getEmptyTextPSLanguageRes();

    public String getEmptyText();

    public IPSListDataItem getPSListDataItem(String var1, boolean var2) throws Exception;

    public IPSLayoutPanel getItemPSLayoutPanel();
}

