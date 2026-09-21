/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;

@PSModelInterfaceMeta(title="\u6309\u94ae\u90e8\u4ef6\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSButtonBase
extends IPSModelObject {
    public static final String BUTTONTYPE_PANELBUTTON = "PANELBUTTON";
    public static final String BUTTONTYPE_FORMBUTTON = "FORMBUTTON";
    public static final String BUTTONTYPE_TOOLBARITEM = "TOOLBARITEM";
    public static final String BUTTONTYPE_APPMENUITEM = "APPMENUITEM";
    public static final String RENDERMODE_BUTTON = "BUTTON";
    public static final String RENDERMODE_LINK = "LINK";
    public static final String ACTIONTYPE_NONE = "NONE";
    public static final String ACTIONTYPE_UIACTION = "UIACTION";
    public static final String ACTIONTYPE_CUSTOM = "CUSTOM";
    public static final String ACTIONTYPE_FIUPDATE = "FIUPDATE";
    public static final String ACTIONTYPE_APPFUNC = "APPFUNC";
    public static final String ACTIONTYPE_UILOGIC = "UILOGIC";
    public static final String ACTIONTYPE_OPENVIEW = "OPENVIEW";
    public static final String ACTIONTYPE_OPENHTMLPAGE = "OPENHTMLPAGE";
    public static final String ACTIONTYPE_CREATEOBJECT = "CREATEOBJECT";
    public static final String ACTIONTYPE_SAVECHANGES = "SAVECHANGES";
    public static final String ACTIONTYPE_CANCELCHANGES = "CANCELCHANGES";
    public static final String ACTIONTYPE_REMOVE = "REMOVE";
    public static final String ACTIONTYPE_SYNCHRONIZE = "SYNCHRONIZE";
    public static final String ACTIONTYPE_LOGIN = "LOGIN";
    public static final String ACTIONTYPE_LOGOUT = "LOGOUT";

    public String getButtonType();

    public IPSSysImage getPSSysImage();

    public String getCaption();

    public String getTooltip();

    public String getIconAlign();

    public String getBorderStyle();

    public String getButtonStyle();

    public String getRenderMode();

    public double getButtonWidth();

    public double getButtonHeight();

    public String getButtonCssStyle();

    public IPSLanguageRes getTooltipPSLanguageRes();
}

