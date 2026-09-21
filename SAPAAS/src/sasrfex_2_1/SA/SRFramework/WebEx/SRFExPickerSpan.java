/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.WebEx.SRFExMultiPicker;
import SA.SRFramework.WebEx.SRFExSpan;

public class SRFExPickerSpan
extends SRFExSpan {
    public SRFExMultiPicker picker = null;

    public SRFExPickerSpan(SRFExMultiPicker picker) {
        this.picker = picker;
    }

    @Override
    public void setValue(String strValue) {
        super.setValue(strValue);
    }
}

