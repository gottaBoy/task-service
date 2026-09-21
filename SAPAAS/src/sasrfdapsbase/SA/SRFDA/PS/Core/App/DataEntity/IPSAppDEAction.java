/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppDEAction
extends IPSAppDEMethod {
    public String getActionType();

    public IPSDEAction getPSDEAction();

    public boolean isEnableTestMethod();

    public IPSAppDELogic getPSAppDELogic() throws Exception;

    public IPSDEOPPriv getPSDEOPPriv();

    public boolean isEnableBatchAction();

    public int getBatchActionMode();

    public String getActionMode();

    public boolean isCustomCode();

    public String getScriptCode();

    public String getBeforeCode();

    public String getAfterCode();

    public boolean isAsyncAction();

    public String getActionName();

    public String getActionTag();
}

