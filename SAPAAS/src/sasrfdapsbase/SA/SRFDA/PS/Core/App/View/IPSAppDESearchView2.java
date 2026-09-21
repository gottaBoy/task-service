/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Form.IPSDESearchForm;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u641c\u7d22\u89c6\u56fe\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e32", description="\u652f\u6301\u641c\u7d22\u89c6\u56fe\u914d\u7f6e\u5feb\u901f\u5206\u7ec4\u641c\u7d22\u529f\u80fd", model="PSDEViewBase")
public interface IPSAppDESearchView2 {
    public static final String CONTROL_QUICKSEARCHFORM = "quicksearchform";

    public boolean isEnableQuickGroup();

    public IPSCodeList getQuickGroupPSCodeList();

    public IPSDESearchForm getQuickPSDESearchForm();
}

