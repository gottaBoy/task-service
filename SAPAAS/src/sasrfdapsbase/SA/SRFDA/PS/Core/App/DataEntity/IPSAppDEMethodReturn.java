/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodReturn;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5\u65b9\u6cd5\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppDEMethodReturn
extends IPSDEMethodReturn {
    public IPSAppDEMethod getPSAppDEMethod();

    public int getStdDataType();

    @Override
    public String getType();

    public IPSDEMethodReturn getPSDEMethodReturn();

    public IPSAppDEMethodDTO getPSAppDEMethodDTO() throws Exception;
}

