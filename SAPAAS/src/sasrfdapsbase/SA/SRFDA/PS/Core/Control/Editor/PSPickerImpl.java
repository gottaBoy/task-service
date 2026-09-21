/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Editor.IPSPicker;
import SA.SRFDA.PS.Core.Control.Editor.PSPickerEditorImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSEditor", typevalues={"PICKER", "MOBPICKER", "PICKEREX_LINK", "PICKEREX_NOAC", "PICKEREX_TRIGGER", "PICKEREX_LINKONLY", "PICKEREX_NOBUTTON", "PICKEREX_NOAC_LINK", "PICKEREX_DROPDOWNVIEW", "PICKEREX_TRIGGER_LINK", "MOBPICKER_DROPDOWNVIEW", "PICKEREX_DROPDOWNVIEW_LINK"})
public class PSPickerImpl
extends PSPickerEditorImpl
implements IPSPicker {
    @Override
    @PSModelRTMeta(description="\u652f\u6301\u9009\u62e9\u89c6\u56fe")
    public boolean isEnablePickupView() {
        return this.getEditorParam("PICKUPVIEW", true);
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u62c9\u9009\u62e9\u89c6\u56fe", ignoredumpvalues="false")
    public boolean isDropDownView() {
        return this.getEditorParam("DROPDOWNVIEW", false);
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u94fe\u63a5\u89c6\u56fe", ignoredumpvalues="false")
    public boolean isEnableLinkView() {
        return this.getEditorParam("LINKVIEW", false);
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u94fe\u63a5\u89c6\u56fe", dumpref=true)
    public IPSAppView getLinkPSAppView() throws Exception {
        return this.getPSEditorContainer().getRefLinkPSAppView();
    }

    @Override
    @PSModelRTMeta(description="\u5355\u9879\u9009\u62e9", staticcode="true")
    public boolean isSingleSelect() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u62c9\u89c6\u56fe\u5bbd\u5ea6[DROPDOWNVIEWWIDTH]")
    public Integer getDropDownViewWidth() {
        if (!this.isDropDownView()) {
            return null;
        }
        return this.getEditorParam("DROPDOWNVIEWWIDTH", this.getDefaultDropDownViewWidth());
    }

    protected Integer getDefaultDropDownViewWidth() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u62c9\u89c6\u56fe\u9ad8\u5ea6[DROPDOWNVIEWHEIGHT]")
    public Integer getDropDownViewHeight() {
        if (!this.isDropDownView()) {
            return null;
        }
        return this.getEditorParam("DROPDOWNVIEWHEIGHT", this.getDefaultDropDownViewHeight());
    }

    protected Integer getDefaultDropDownViewHeight() {
        return null;
    }
}

