/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.titlebar.ITitleBar
 */
package SA.SRFDA.PS.Core.Control.TitleBar;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import java.util.Iterator;
import net.ibizsys.paas.control.titlebar.ITitleBar;

@PSModelInterfaceMeta(title="\u6807\u9898\u680f\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u57fa\u7840\u63a5\u53e3")
public interface IPSTitleBar
extends IPSControl,
ITitleBar {
    public static final String TITLEBARTYPE_SYS = "SYSTITLEBAR";
    public static final String TITLEBARTYPE_APP = "APPTITLEBAR";
    public static final String TITLEBARSTYLE_USER = "USER";
    public static final String TITLEBARTYPE_USER2 = "USER2";

    public String getCaption();

    public IPSLanguageRes getCapPSLanguageRes();

    public Iterator<IPSControl> getLeftPSControls();

    public Iterator<IPSControl> getRightPSControls();

    public String getTitleBarStyle();

    public String getTitleBarType();

    public IPSSysImage getPSSysImage();
}

