/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import net.sf.json.JSONObject;

@PSModelInterfaceMeta(title="\u5f02\u6b65\u5904\u7406\u7f16\u8f91\u5668\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAjaxEditor
extends IPSEditor {
    public IPSAjaxHandler getPSAjaxHandler();

    public String getHandlerType();

    public JSONObject getHandlerParam() throws Exception;
}

