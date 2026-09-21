/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDataItem
 *  net.ibizsys.paas.data.IDataItemParam
 */
package SA.SRFDA.PS.Core.Data;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataItemParam;

@PSModelInterfaceMeta(title="\u6570\u636e\u9879\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDataItem
extends IDataItem,
IPSModelObject {
    public int getDataType();

    public String getFormat();

    public IPSCodeList getPSCodeList();

    public IDataItemParam getDataItemParam0();

    public IDataItemParam getDataItemParam1();

    public IDataItemParam getDataItemParam();

    public boolean isConvertToCodeItemText();
}

