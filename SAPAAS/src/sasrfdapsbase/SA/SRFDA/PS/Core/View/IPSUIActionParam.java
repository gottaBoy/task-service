/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.IPSModelObject;

public interface IPSUIActionParam
extends IPSModelObject {
    public String getKey();

    public String getValue();

    public String getDesc();

    public boolean isRawValue();
}

