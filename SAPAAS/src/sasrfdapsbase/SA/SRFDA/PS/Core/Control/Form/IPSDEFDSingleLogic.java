/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFDLogic;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5b9e\u4f53\u8868\u5355\u6210\u5458\u5355\u9879\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"SINGLE"}, model="PSDEFDLogic")
public interface IPSDEFDSingleLogic
extends IPSDEFDLogic {
    public String getDEFDName();

    public String getPSDBValueOPId();

    public String getValue();

    public String getCondOP();
}

