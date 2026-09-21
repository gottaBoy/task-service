/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodInput;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5\u8f93\u5165\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppDEMethodInput
extends IPSDEMethodInput {
    public IPSAppDEMethod getPSAppDEMethod();

    @Override
    public String getType();

    public IPSDEMethodInput getPSDEMethodInput();

    public IPSAppDEMethodDTO getPSAppDEMethodDTO() throws Exception;

    public boolean isOutput();

    public IPSAppDEField getKeyPSAppDEField();
}

