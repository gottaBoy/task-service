/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDataItemParam
 */
package SA.SRFDA.PS.Core.Data;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import net.ibizsys.paas.data.IDataItemParam;

@PSModelInterfaceMeta(title="\u6570\u636e\u9879\u53c2\u6570\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDataItemParam
extends IDataItemParam,
IPSModelObject {
    public String getFormat();

    public IPSCodeList getPSCodeList();

    public IPSDEField getPSDEField();

    public IPSAppDEField getPSAppDEField();
}

