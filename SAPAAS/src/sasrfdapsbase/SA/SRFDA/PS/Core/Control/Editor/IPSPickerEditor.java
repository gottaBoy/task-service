/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import net.sf.json.JSONObject;

@PSModelInterfaceMeta(title="\u6570\u636e\u9009\u62e9\u7f16\u8f91\u5668\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSPickerEditor
extends IPSEditor,
IPSNavigateParamContainer {
    public static final String PARAM_AC = "AC";

    public IPSAppView getPickupPSAppView() throws Exception;

    public JSONObject getItemParamJO() throws Exception;

    public boolean isEnablePickupView();

    public String getParamJOString();

    public String getContextJOString();
}

