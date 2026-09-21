/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormParam;
import SA.SRFDA.PS.Core.Control.IPSSDAjaxControlParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u7f16\u8f91\u8868\u5355\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSDEEditFormParam
extends IPSDEFormParam,
IPSSDAjaxControlParam {
    public Boolean isEnableAutoSave();

    public Boolean isActiveDataMode();

    public String getActiveDataField();

    public String getPSSysCounterId();
}

