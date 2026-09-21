/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonSimpleSchema;
import SA.SRFDA.PS.Core.DynaModel.PSJsonNodeSchemaImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;

public abstract class PSJsonSimpleSchemaImpl
extends PSJsonNodeSchemaImplBase
implements IPSJsonSimpleSchema {
    @Override
    @PSModelRTMeta(description="\u683c\u5f0f")
    public String getFormat() {
        if (this.getObjectNode().has("format")) {
            return this.getObjectNode().get("format").textValue();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u503c\u7c7b\u578b", ignoredumpvalues="0")
    public int getStdDataType() {
        return this.onGetStdDataType();
    }

    protected abstract int onGetStdDataType();
}

