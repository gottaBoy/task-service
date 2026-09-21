/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Ajax.PSAjaxControlHandlerActionImpl;
import SA.SRFDA.PS.Core.Control.Ajax.PSAjaxControlHandlerImpl;
import SA.SRFDA.PS.Core.Control.Form.IPSDESearchForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDESearchFormHandler;
import SA.SRFDA.PS.Data.PSACHandlerAction;
import SA.SRFramework.Utility.StringHelper;
import java.util.LinkedHashMap;
import java.util.Map;

public class PSDESearchFormHandlerImpl
extends PSAjaxControlHandlerImpl
implements IPSDESearchFormHandler {
    private static final Map<String, String> _ACTIONS = new LinkedHashMap<String, String>();
    private static final Map<String, String> _ACTIONS2 = new LinkedHashMap<String, String>();

    static {
        _ACTIONS.put("load", "FILTERGET");
        _ACTIONS.put("loaddraft", "FILTERGETDRAFT");
        _ACTIONS.put("search", "FILTERSEARCH");
        _ACTIONS2.put("create", "FILTERCREATE");
        _ACTIONS2.put("update", "FILTERUPDATE");
        _ACTIONS2.put("remove", "FILTERREMOVE");
        _ACTIONS2.put("fetch", "FILTERFETCH");
    }

    @Override
    protected void onPreparePSAjaxHandlerActions() throws Exception {
        IPSDESearchForm iPSDESearchForm;
        super.onPreparePSAjaxHandlerActions();
        for (Map.Entry<String, String> entry : _ACTIONS.entrySet()) {
            PSACHandlerAction psACHandlerAction = new PSACHandlerAction();
            psACHandlerAction.setPSACHANDLERACTIONID(StringHelper.Format((String)"%1$s_%2$s", (Object)this.getId(), (Object)entry.getKey()));
            psACHandlerAction.setPSACHANDLERACTIONNAME(entry.getKey());
            psACHandlerAction.setACTIONTYPE("FILTERACTION");
            psACHandlerAction.setVALIDFLAG(true);
            psACHandlerAction.setPSDEACTIONID(entry.getValue());
            PSAjaxControlHandlerActionImpl psAjaxControlHandlerActionImpl = new PSAjaxControlHandlerActionImpl();
            psAjaxControlHandlerActionImpl.init(this.getDAGlobalHelper(), this, psACHandlerAction);
            this.registerPSAjaxHandlerAction(psAjaxControlHandlerActionImpl);
        }
        if (this.getPSControl() instanceof IPSDESearchForm && (iPSDESearchForm = (IPSDESearchForm)this.getPSControl()).isEnableFilterSave()) {
            for (Map.Entry<String, String> entry : _ACTIONS2.entrySet()) {
                PSACHandlerAction psACHandlerAction = new PSACHandlerAction();
                psACHandlerAction.setPSACHANDLERACTIONID(StringHelper.Format((String)"%1$s_%2$s", (Object)this.getId(), (Object)entry.getKey()));
                psACHandlerAction.setPSACHANDLERACTIONNAME(entry.getKey());
                psACHandlerAction.setACTIONTYPE("FILTERACTION");
                psACHandlerAction.setVALIDFLAG(true);
                psACHandlerAction.setPSDEACTIONID(entry.getValue());
                PSAjaxControlHandlerActionImpl psAjaxControlHandlerActionImpl = new PSAjaxControlHandlerActionImpl();
                psAjaxControlHandlerActionImpl.init(this.getDAGlobalHelper(), this, psACHandlerAction);
                this.registerPSAjaxHandlerAction(psAjaxControlHandlerActionImpl);
            }
        }
    }
}

