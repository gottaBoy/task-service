/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u641c\u7d22\u8868\u5355\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDESearchFormItem
extends IPSDEFormItem {
    public IPSDEFSearchMode getPSDEFSearchMode();
}

