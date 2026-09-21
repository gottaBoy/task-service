/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppUtilView;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5e94\u7528\u9519\u8bef\u5c55\u73b0\u529f\u80fd\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"APPERRORVIEW"})
public interface IPSAppErrorView
extends IPSAppUtilView {
    public String getErrorCode();
}

