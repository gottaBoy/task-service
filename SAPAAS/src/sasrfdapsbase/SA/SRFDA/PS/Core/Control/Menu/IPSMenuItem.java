/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.menu.IMenuItem
 */
package SA.SRFDA.PS.Core.Control.Menu;

import SA.SRFDA.PS.Core.Control.IPSControlItem;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import net.ibizsys.paas.control.menu.IMenuItem;

@PSModelInterfaceMeta(title="\u83dc\u5355\u90e8\u4ef6\u9879\u6a21\u578b\u5bf9\u8c61\u57fa\u7840\u63a5\u53e3")
public interface IPSMenuItem
extends IPSModelObject,
IMenuItem,
IPSControlItem {
    public static final String MENUITEMTYPE_SEPERATOR = "SEPERATOR";
    public static final String MENUITEMTYPE_MENUITEM = "MENUITEM";
    public static final String MENUITEMTYPE_USERITEM = "USERITEM";

    public String getCaption();

    public IPSLanguageRes getCapPSLanguageRes();

    public IPSLanguageRes getTooltipPSLanguageRes();

    public String getItemType();

    @Override
    public String getId();

    public String getPId();

    public String getText();

    public boolean isExpanded();

    public String getTextCls();

    public String getIconCls();

    public String getIconPath();

    public String getCounterId();

    public void setAttribute(String var1, Object var2);

    public Object getAttribute(String var1);

    public int getAccUserMode();

    public String getAccessKey();

    public String getTextLanResTag();

    public String getTooltip();

    public String getTooltipLanResTag();

    public boolean isHidden();

    public String getFillerObj();
}

