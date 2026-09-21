/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.IPSRawItem;
import SA.SRFDA.PS.Core.Control.IPSRawItemContainer;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5b9e\u4f53\u8868\u5355\u76f4\u63a5\u5185\u5bb9\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"RAWITEM"})
public interface IPSDEFormRawItem
extends IPSDEFormDetail,
IPSRawItem,
IPSRawItemContainer {
    public double getRawContentHeight();

    public double getRawContentWidth();
}

