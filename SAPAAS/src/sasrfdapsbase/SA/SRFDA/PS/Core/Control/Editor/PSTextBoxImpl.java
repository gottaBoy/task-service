/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSTextBox;
import SA.SRFDA.PS.Core.Control.Editor.PSTextEditorImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSEditor", typevalues={"MOBTEXT", "TEXTBOX"})
public class PSTextBoxImpl
extends PSTextEditorImpl
implements IPSTextBox {
    @Override
    @PSModelRTMeta(description="\u6700\u5927\u503c[MAXVALUE]")
    public Double getMaxValue() {
        return this.getEditorParam("MAXVALUE", this.getDefaultMaxValue());
    }

    protected Double getDefaultMaxValue() {
        String strValue = this.getEditorParam("DEFAULTMAXVALUE", "");
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return null;
        }
        try {
            return Double.valueOf(strValue);
        }
        catch (Exception ex) {
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u503c[MINVALUE]")
    public Double getMinValue() {
        return this.getEditorParam("MINVALUE", this.getDefaultMinValue());
    }

    protected Double getDefaultMinValue() {
        String strValue = this.getEditorParam("DEFAULTMINVALUE", "");
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return null;
        }
        try {
            return Double.valueOf(strValue);
        }
        catch (Exception ex) {
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u6d6e\u70b9\u7cbe\u5ea6[Precision]")
    public Integer getPrecision() {
        return this.getEditorParam("PRECISION", this.getDefaultPrecision());
    }

    protected Integer getDefaultPrecision() {
        String strValue = this.getEditorParam("DEFAULTPRECISION", "");
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
}

