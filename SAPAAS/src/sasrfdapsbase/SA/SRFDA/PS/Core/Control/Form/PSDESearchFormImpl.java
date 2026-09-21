/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDESearchForm;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormImpl;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormParamImpl;
import SA.SRFDA.PS.Core.Control.Form.PSDESearchFormParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"SEARCHFORM"})
public class PSDESearchFormImpl
extends PSDEFormImpl
implements IPSDESearchForm {
    private static final Log log = LogFactory.getLog(PSDESearchFormImpl.class);
    public static final String PFSTYLEPARAM_SEARCHFORM_LABLEWIDTH = "SEARCHFORM.LABLEWIDTH";
    protected PSDESearchFormParamImpl psDESearchFormParamImpl = null;
    private boolean bEnableAdvanceSearch = false;
    private boolean bEnableAutoSearch = false;
    private boolean bEnableFilterSave = false;
    private String strSearchButtonStyle = "DEFAULT";
    private String strSearchButtonPos = "";

    @Override
    protected void onInit() throws Exception {
        if (!this.isInvalidId() && StringHelper.Compare((String)this.psDEForm.getFORMTYPE(), (String)"SEARCHFORM", (boolean)true) != 0) {
            throw new Exception(String.format("\u8868\u5355\u7c7b\u578b[%1$s]\u4e0d\u6b63\u786e", this.psDEForm.getFORMTYPE()));
        }
        super.onInit();
    }

    @Override
    protected void onPreparePSDEFormLayout() throws Exception {
        this.nLabelWidth = this.getPSAppView().getPSApplication().getPFStyleParam(PFSTYLEPARAM_SEARCHFORM_LABLEWIDTH, this.nLabelWidth);
        if (!this.psDEForm.isENABLEADVSEARCHNull()) {
            this.bEnableAdvanceSearch = this.psDEForm.getENABLEADVSEARCH();
        }
        if (!this.psDEForm.isENABLEFILTERSAVENull()) {
            this.bEnableFilterSave = this.psDEForm.getENABLEFILTERSAVE();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEForm.getSEARCHBTNSTYLE())) {
            this.strSearchButtonStyle = this.psDEForm.getSEARCHBTNSTYLE();
        }
        if (this.psDESearchFormParamImpl.isEnableAdvanceSearch() != null) {
            this.bEnableAdvanceSearch = this.psDESearchFormParamImpl.isEnableAdvanceSearch();
        }
        if (this.psDESearchFormParamImpl.isEnableAutoSearch() != null) {
            this.bEnableAutoSearch = this.psDESearchFormParamImpl.isEnableAutoSearch();
        } else if (this.isEnableUIModelEx()) {
            boolean bl = this.bEnableAutoSearch = StringHelper.Compare((String)this.getSearchButtonStyle(), (String)"NONE", (boolean)true) == 0;
        }
        if (this.psDESearchFormParamImpl.isEnableFilterSave() != null) {
            this.bEnableFilterSave = this.psDESearchFormParamImpl.isEnableFilterSave();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEForm.getSEARCHBTNPOS())) {
            this.strSearchButtonPos = this.psDEForm.getSEARCHBTNPOS();
        }
        super.onPreparePSDEFormLayout();
    }

    @Override
    protected PSDEFormParamImpl createPSDEFormParamImpl() {
        this.psDESearchFormParamImpl = new PSDESearchFormParamImpl();
        return this.psDESearchFormParamImpl;
    }

    @Override
    protected String onGetControlType() {
        return "SEARCHFORM";
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u9ad8\u7ea7\u641c\u7d22", fields={"ENABLEADVSEARCH"}, doc="\u89c6\u56fe\u90e8\u4ef6\u6a21\u578b{@link PSDEViewCtrlDTO#FIELD_CTRLPARAM5}\u4f18\u5148\u5b9a\u4e49")
    public boolean isEnableAdvanceSearch() {
        return this.bEnableAdvanceSearch;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u81ea\u52a8\u641c\u7d22", model="PSDEViewCtrl", fields={"CTRLPARAM6"})
    public boolean isEnableAutoSearch() {
        return this.bEnableAutoSearch;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6761\u4ef6\u4fdd\u5b58", fields={"ENABLEFILTERSAVE"}, doc="\u89c6\u56fe\u90e8\u4ef6\u6a21\u578b{@link PSDEViewCtrlDTO#FIELD_CTRLPARAM7}\u4f18\u5148\u5b9a\u4e49")
    public boolean isEnableFilterSave() {
        return this.bEnableFilterSave;
    }

    @Override
    public String getModelType() {
        return "PSDEFORM_SEARCHFORM";
    }

    @Override
    @PSModelRTMeta(description="\u641c\u7d22\u6309\u94ae\u6837\u5f0f", codelist="SearchFormButtonStyle", fields={"SEARCHBTNSTYLE"})
    public String getSearchButtonStyle() {
        return this.strSearchButtonStyle;
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u8fc7\u6ee4\u5668", hideempty=true)
    public IPSControlAction getCreatePSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("create", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u8fc7\u6ee4\u5668", hideempty=true)
    public IPSControlAction getUpdatePSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("update", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u8fc7\u6ee4\u5668", hideempty=true)
    public IPSControlAction getRemovePSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("remove", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u8fc7\u6ee4\u5668", hideempty=true)
    public IPSControlAction getGetPSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("load", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u8349\u7a3f\u8fc7\u6ee4\u5668", hideempty=true)
    public IPSControlAction getGetDraftPSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("loaddraft", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u641c\u7d22\u8fc7\u6ee4\u5668", hideempty=true)
    public IPSControlAction getSearchPSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("search", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u5217\u51fa\u4fdd\u5b58\u7684\u8fc7\u6ee4\u5668", hideempty=true)
    public IPSControlAction getFetchPSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("fetch", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u641c\u7d22\u6309\u94ae\u4f4d\u7f6e", codelist="SearchFormButtonPos", fields={"SEARCHBTNPOS"})
    public String getSearchButtonPos() {
        return this.strSearchButtonPos;
    }
}

