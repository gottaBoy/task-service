/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsgGroupDetail;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroup;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5e94\u7528\u89c6\u56fe\u6d88\u606f\u7ec4\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", model="PSViewMsgGroup")
public interface IPSAppViewMsgGroup
extends IPSViewMsgGroup,
IPSApplicationObject,
IPSModelSortable {
    @Override
    public String getCodeName();

    public IPSViewMsgGroup getPSViewMsgGroup();

    public Iterator<? extends IPSAppViewMsgGroupDetail> getPSAppViewMsgGroupDetails();

    @Override
    public String getTopStyle();

    @Override
    public String getBottomStyle();

    @Override
    public String getBodyStyle();
}

