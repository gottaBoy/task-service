/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;

@PSModelExtendMeta(title="\u6570\u503c\u7f16\u8f91\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"NUMBER", "MOBNUMBER"})
public interface IPSNumberEditor
extends IPSEditor {
    public static final String EDITORPARAM_MAXVALUE = "MAXVALUE";
    public static final String EDITORPARAM_MINVALUE = "MINVALUE";
    public static final String EDITORPARAM_PRECISION = "PRECISION";
    public static final String EDITORPARAM_DEFAULTMAXVALUE = "DEFAULTMAXVALUE";
    public static final String EDITORPARAM_DEFAULTMINVALUE = "DEFAULTMINVALUE";
    public static final String EDITORPARAM_DEFAULTPRECISION = "DEFAULTPRECISION";

    public Double getMaxValue();

    public Double getMinValue();

    public Integer getPrecision();

    public IPSSysValueRule getPSSysValueRule() throws Exception;
}

