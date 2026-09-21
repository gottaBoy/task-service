/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppRedirectView;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5e94\u7528\u5b9e\u4f53\u91cd\u5b9a\u5411\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DEREDIRECTVIEW"})
public interface IPSAppDERedirectView
extends IPSAppRedirectView,
IPSAppDEView {
    public boolean isEnableWorkflow();

    public boolean isEnableCustomGetDataAction();

    public IPSDEAction getGetDataPSDEAction();

    public IPSDEField getTypePSDEField();

    public IPSAppDEAction getGetDataPSAppDEAction();

    public IPSAppDEField getTypePSAppDEField();
}

