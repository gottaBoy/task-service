/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Editor.IPSTextEditor;
import SA.SRFDA.PS.Core.Control.PSEditorImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import net.ibizsys.paas.util.StringHelper;

public class PSTextEditorImpl
extends PSEditorImpl
implements IPSTextEditor {
    private IPSAppCodeList iPSAppCodeList = null;

    @Override
    @PSModelRTMeta(description="\u7ed1\u5b9a\u9608\u503c\u4ee3\u7801\u8868")
    public IPSCodeList getPSCodeList() {
        if (this.getPSEditorContainer().getPSCodeList() != null && this.getPSEditorContainer().getPSCodeList().isThresholdGroup()) {
            return this.getPSEditorContainer().getPSCodeList();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9608\u503c\u5e94\u7528\u4ee3\u7801\u8868\u5bf9\u8c61", dumpref=true, modelreftype="IGNOREDESIGN")
    public IPSAppCodeList getPSAppCodeList() {
        try {
            if (this.iPSAppCodeList == null && this.getPSCodeList() != null) {
                this.iPSAppCodeList = this.getPSEditorContainer().getPSControlContainer().getPSAppView().getPSApplication().getPSAppCodeList(this.getPSCodeList(), !this.isEnableUIModelEx());
            }
            return this.iPSAppCodeList;
        }
        catch (Exception ex) {
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u957f\u5ea6[MAXLENGTH]")
    public Integer getMaxLength() {
        return this.getEditorParam("MAXLENGTH", this.getDefaultMaxLength());
    }

    protected Integer getDefaultMaxLength() {
        String strValue = this.getEditorParam("DEFAULTMAXLENGTH", "");
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return null;
        }
        try {
            return Integer.valueOf(strValue);
        }
        catch (Exception ex) {
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u957f\u5ea6[MINLENGTH]", ignoredumpvalues="0")
    public Integer getMinLength() {
        return this.getEditorParam("MINLENGTH", this.getDefaultMinLength());
    }

    protected Integer getDefaultMinLength() {
        String strValue = this.getEditorParam("DEFAULTMINLENGTH", "");
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return null;
        }
        try {
            return Integer.valueOf(strValue);
        }
        catch (Exception ex) {
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u503c\u89c4\u5219", child=true)
    public IPSSysValueRule getPSSysValueRule() throws Exception {
        return this.getPSEditorContainer().getPSSysValueRule();
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6700\u5927\u957f\u5ea6[SHOWMAXLENGTH]", ignoredumpvalues="false")
    public boolean isShowMaxLength() {
        return this.getEditorParam("SHOWMAXLENGTH", this.getDefaultShowMaxLength());
    }

    protected boolean getDefaultShowMaxLength() {
        return false;
    }
}

