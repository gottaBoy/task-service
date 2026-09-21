/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import net.sf.json.JSONObject;

@PSModelInterfaceMeta(title="\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", implement="PSDEUIActionGroupDetailImpl")
public interface IPSUIActionGroupDetail
extends IPSModelObject {
    public IPSUIActionGroup getPSUIActionGroup();

    public IPSUIAction getPSUIAction();

    public JSONObject getUIActionParamJO();

    public String getUIActionParam();

    public boolean isAddSeparator();

    public boolean isShowCaption();

    public boolean isShowIcon();

    public String getDetailTag();

    public String getDetailTag2();

    @Override
    public String getCodeName();

    public int getActionLevel();

    public String getPSSysImageId();

    public String getPSSysCssId();

    public String getCaption();

    public String getTooltip();

    public String getEnableScriptCode();

    public String getVisibleScriptCode();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public String getButtonStyle();
}

