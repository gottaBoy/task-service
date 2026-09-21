/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Editor.IPSArray;
import SA.SRFDA.PS.Core.Control.PSEditorImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;

@PSModelImplementMeta(implement="IPSEditor", typevalues={"MOBARRAY", "ARRAY"})
public class PSArrayImpl
extends PSEditorImpl
implements IPSArray {
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
    @PSModelRTMeta(description="\u6570\u636e\u7c7b\u578b[DATATYPE]{STRING|NUMBER|INTEGER|URL|IMAGE|MAIL}", ignoredumpvalues="STRING")
    public String getDataType() {
        return this.getEditorParam("DATATYPE", this.getDefaultDataType());
    }

    protected String getDefaultDataType() {
        return this.getEditorParam("DEFAULTARRAYDATATYPE", "");
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u503c[MAXVALUE]")
    public Double getMaxValue() {
        return this.getEditorParam("MAXVALUE", this.getDefaultMaxValue());
    }

    protected Double getDefaultMaxValue() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u503c[MINVALUE]")
    public Double getMinValue() {
        return this.getEditorParam("MINVALUE", this.getDefaultMinValue());
    }

    protected Double getDefaultMinValue() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6d6e\u70b9\u7cbe\u5ea6[PRECISION]")
    public Integer getPrecision() {
        return this.getEditorParam("PRECISION", this.getDefaultPrecision());
    }

    protected Integer getDefaultPrecision() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u957f\u5ea6[MAXLENGTH]")
    public Integer getMaxLength() {
        return this.getEditorParam("MAXLENGTH", this.getDefaultMaxLength());
    }

    protected Integer getDefaultMaxLength() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u957f\u5ea6[MINLENGTH]", ignoredumpvalues="0")
    public Integer getMinLength() {
        return this.getEditorParam("MINLENGTH", this.getDefaultMinLength());
    }

    protected Integer getDefaultMinLength() {
        return null;
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

