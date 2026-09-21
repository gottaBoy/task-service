/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u591a\u9879\u6570\u636e\u754c\u9762\u90e8\u4ef6\u76f8\u5173\u5bf9\u8c61\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSControlMDObject
extends IPSControlObject {
    public IPSAppDataEntity getPSAppDataEntity();

    public Iterator<IPSAppDEField> getPSAppDEFields() throws Exception;
}

