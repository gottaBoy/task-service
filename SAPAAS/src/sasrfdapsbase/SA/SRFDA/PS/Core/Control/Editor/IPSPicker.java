/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Editor.IPSAutoComplete;
import SA.SRFDA.PS.Core.Control.Editor.IPSPickerEditor;
import SA.SRFDA.PS.Core.Control.Editor.IPSValueItemEditor;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u6570\u636e\u9009\u62e9\u7f16\u8f91\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"PICKER", "MOBPICKER", "PICKEREX_LINK", "PICKEREX_NOAC", "PICKEREX_TRIGGER", "PICKEREX_LINKONLY", "PICKEREX_NOBUTTON", "PICKEREX_NOAC_LINK", "PICKEREX_DROPDOWNVIEW", "PICKEREX_TRIGGER_LINK", "MOBPICKER_DROPDOWNVIEW", "PICKEREX_DROPDOWNVIEW_LINK"})
public interface IPSPicker
extends IPSPickerEditor,
IPSValueItemEditor,
IPSAutoComplete {
    public static final String PARAM_PICKUPVIEW = "PICKUPVIEW";
    public static final String PARAM_LINKVIEW = "LINKVIEW";
    public static final String PARAM_DROPDOWNVIEW = "DROPDOWNVIEW";
    public static final String PARAM_DROPDOWNVIEWHEIGHT = "DROPDOWNVIEWHEIGHT";
    public static final String PARAM_DROPDOWNVIEWWIDTH = "DROPDOWNVIEWWIDTH";

    public boolean isEnableLinkView();

    @Override
    public boolean isEnablePickupView();

    public IPSAppView getLinkPSAppView() throws Exception;

    public boolean isSingleSelect();

    public boolean isDropDownView();

    public Integer getDropDownViewWidth();

    public Integer getDropDownViewHeight();
}

