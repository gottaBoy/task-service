/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.IPSAjaxEditor;
import SA.SRFDA.PS.Core.Control.PSEditorImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.sf.json.JSONObject;

public abstract class PSAjaxEditorImpl
extends PSEditorImpl
implements IPSAjaxEditor {
    @Override
    public IPSAjaxHandler getPSAjaxHandler() {
        return this.getPSEditorContainer().getItemPSAjaxHandler();
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u5668\u7c7b\u578b")
    public String getHandlerType() {
        return this.getPSEditorContainer().getItemHandlerType();
    }

    @Override
    public JSONObject getHandlerParam() throws Exception {
        return this.getPSEditorContainer().getItemParam();
    }
}

