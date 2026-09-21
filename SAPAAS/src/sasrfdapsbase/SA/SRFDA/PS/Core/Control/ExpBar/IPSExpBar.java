/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.expbar.ExpBarRootItem
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbar;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import net.ibizsys.paas.control.expbar.ExpBarRootItem;

@PSModelInterfaceMeta(title="\u5bfc\u822a\u680f\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSExpBar
extends IPSAjaxControl,
IPSControlContainer {
    public ExpBarRootItem getRootItem();

    public IPSSysCounterRef getPSSysCounterRef();

    public IPSAppCounterRef getPSAppCounterRef();

    public String getTitle();

    public IPSLanguageRes getTitlePSLanguageRes();

    public boolean isEnableCounter();

    public boolean isEnableSearch();

    public boolean isShowTitleBar();

    public IPSDEToolbar getPSDEToolbar();

    public IPSControl getXDataPSControl();

    public String getXDataControlName();

    public IPSSysImage getPSSysImage();
}

