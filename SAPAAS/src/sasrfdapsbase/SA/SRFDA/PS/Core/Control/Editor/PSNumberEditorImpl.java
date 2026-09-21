/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSNumberEditor;
import SA.SRFDA.PS.Core.Control.PSEditorImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSEditor", typevalues={"NUMBER", "MOBNUMBER"})
public class PSNumberEditorImpl
extends PSEditorImpl
implements IPSNumberEditor {
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
    @PSModelRTMeta(description="\u6d6e\u70b9\u7cbe\u5ea6[PRECISION]")
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

    @Override
    @PSModelRTMeta(description="\u503c\u89c4\u5219", child=true)
    public IPSSysValueRule getPSSysValueRule() throws Exception {
        return this.getPSEditorContainer().getPSSysValueRule();
    }
}

