/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.Control.Form.IPSDESearchForm;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u641c\u7d22\u89c6\u56fe\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", description="\u5b9a\u4e49\u641c\u7d22\u89c6\u56fe\u7684\u57fa\u672c\u80fd\u529b", model="PSDEViewBase")
public interface IPSAppDESearchView {
    public static final String CONTROL_SEARCHFORM = "searchform";

    public boolean isEnableQuickSearch();

    public boolean isEnableSearch();

    public boolean isLoadDefault();

    public boolean isExpandSearchForm();

    public IPSDESearchForm getPSDESearchForm();
}

