/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFDGroupLogic;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u8868\u5355\u6210\u5458\u5206\u7c7b\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDEFDCatGroupLogicImpl", model="PSDEFDLogic")
public interface IPSDEFDCatGroupLogic
extends IPSDEFDGroupLogic {
    @Override
    public String getLogicCat();

    public Iterator<String> getRelatedDetailNames();

    public String getScriptCode();
}

