/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u754c\u9762\u884c\u4e3a\u7ec4\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", implement="PSDEUIActionGroupImpl")
public interface IPSUIActionGroup
extends IPSModelObject {
    public Iterator<IPSUIAction> getPSUIActions();

    public Iterator<IPSUIActionGroupDetail> getPSUIActionGroupDetails();

    public String getGroupTag();

    public String getGroupTag2();

    public String getGroupTag3();

    public String getGroupTag4();
}

