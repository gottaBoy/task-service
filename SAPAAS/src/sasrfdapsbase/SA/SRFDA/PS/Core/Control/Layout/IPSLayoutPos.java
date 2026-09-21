/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Layout;

import SA.SRFDA.PS.Core.Control.Layout.IPSLayout;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSLayout;

@PSModelInterfaceMeta(title="\u5e03\u5c40\u5360\u4f4d\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", typefield="layout", model="PSLayout")
public interface IPSLayoutPos
extends IPSModelObject {
    public void init(IPSModelObject var1, IPSLayout var2, PSLayout var3) throws Exception;

    public IPSLayout getParentPSLayout();

    public IPSLayout getPSLayout();

    public String getLayout();

    public Integer getWidth();

    public Integer getHeight();

    public String getSpacingLeft();

    public String getSpacingRight();

    public String getSpacingTop();

    public String getSpacingBottom();

    public String getVAlignSelf();

    public String getHAlignSelf();

    public String getWidthMode();

    public String getHeightMode();
}

