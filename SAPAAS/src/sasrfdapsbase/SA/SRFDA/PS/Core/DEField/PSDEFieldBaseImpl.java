/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSDEFieldBase;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;

@PSModelPFIgnoreMeta
public abstract class PSDEFieldBaseImpl
extends PSObjectImpl
implements IPSDEFieldBase {
    protected abstract IPSDEFieldBase getProxyPSDEFieldBase();

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u5b57\u7b26\u4e32\u957f\u5ea6", ignoredumpvalues="0;-1")
    public int getMinStringLength() {
        if (this.getProxyPSDEFieldBase() == null) {
            return -1;
        }
        return this.getProxyPSDEFieldBase().getMinStringLength();
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u503c\uff08\u5b57\u7b26\u4e32\uff09")
    public String getMaxValueString() {
        if (this.getProxyPSDEFieldBase() == null) {
            return null;
        }
        return this.getProxyPSDEFieldBase().getMaxValueString();
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u503c\uff08\u5b57\u7b26\u4e32\uff09")
    public String getMinValueString() {
        if (this.getProxyPSDEFieldBase() == null) {
            return null;
        }
        return this.getProxyPSDEFieldBase().getMinValueString();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7cbe\u5ea6", ignoredumpvalues="0")
    public int getPrecision() {
        if (this.getProxyPSDEFieldBase() == null) {
            return 0;
        }
        return this.getProxyPSDEFieldBase().getPrecision();
    }

    @Override
    @PSModelRTMeta(description="\u5b57\u7b26\u4e32\u957f\u5ea6", ignoredumpvalues="0;-1")
    public int getStringLength() {
        if (this.getProxyPSDEFieldBase() == null) {
            return -1;
        }
        return this.getProxyPSDEFieldBase().getStringLength();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u503c\u89c4\u5219")
    public IPSSysValueRule getPSSysValueRule() throws Exception {
        if (this.getProxyPSDEFieldBase() == null) {
            return null;
        }
        return this.getProxyPSDEFieldBase().getPSSysValueRule();
    }
}

