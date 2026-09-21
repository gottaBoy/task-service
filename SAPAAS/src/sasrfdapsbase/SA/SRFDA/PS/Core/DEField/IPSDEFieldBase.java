/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;

@PSModelInterfaceMeta(util=true, title="\u5b9e\u4f53\u5c5e\u6027\u6a21\u578b\u57fa\u5bf9\u8c61\u63a5\u53e3", description="\u5b9e\u4f53\u5c5e\u6027\u3001\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u7b49\u6a21\u578b\u5bf9\u8c61\u90fd\u7ee7\u627f\u8be5\u63a5\u53e3")
public interface IPSDEFieldBase {
    public int getPrecision();

    public int getStringLength();

    public int getMinStringLength();

    public String getMaxValueString();

    public String getMinValueString();

    public IPSSysValueRule getPSSysValueRule() throws Exception;
}

