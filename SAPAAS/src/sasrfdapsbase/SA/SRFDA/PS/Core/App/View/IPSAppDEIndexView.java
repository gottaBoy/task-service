/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppDataRelationView;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5e94\u7528\u5b9e\u4f53\u9996\u9875\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DEINDEXVIEW"})
public interface IPSAppDEIndexView
extends IPSAppDEView,
IPSAppDataRelationView {
    public static final String VIEWPARAM_UI_SHOWDATAINFOBAR = "UI.SHOWDATAINFOBAR";

    public boolean isShowDataInfoBar();

    public String getMarkOpenDataMode();
}

