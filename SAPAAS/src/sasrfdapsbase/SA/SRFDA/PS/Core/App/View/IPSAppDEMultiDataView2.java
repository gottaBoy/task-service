/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEMultiDataView;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u591a\u9879\u6570\u636e\u89c6\u56fe\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e32", description="\u652f\u6301\u914d\u7f6e\u591a\u6570\u636e\u89c6\u56fe\u7684\u6570\u636e\u6fc0\u6d3b\u6a21\u5f0f", model="PSDEViewBase")
public interface IPSAppDEMultiDataView2
extends IPSAppDEMultiDataView {
    public boolean isDbClickEditData();

    public int getMDCtrlActiveMode();
}

