/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.Data.IPSDataItem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u8868\u5355\u6570\u636e\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEFormDataItem
extends IPSDataItem {
    public IPSDEForm getPSDEForm();

    public IPSDEFormDetail getPSDEFormDetail();

    public IPSDEField getPSDEField();

    public IPSAppDEField getPSAppDEField();
}

