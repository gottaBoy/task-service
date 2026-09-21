/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Print.IPSDEPrint;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u754c\u9762\u90e8\u4ef6\u6570\u636e\u5bb9\u5668\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSControlXDataContainer {
    public boolean isLoadDefault();

    public boolean isReadOnly();

    public boolean isEnableNewData();

    public boolean isEnableEditData();

    public boolean isEnableRemoveData();

    public boolean isEnablePrint();

    public boolean isEnableCopy();

    public boolean isEnableStartWF();

    public IPSDEPrint getPSDEPrint();

    public IPSAppDataEntity getPSAppDataEntity();
}

