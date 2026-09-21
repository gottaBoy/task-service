/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.ParameterDirectionHelper
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Data.ParameterDirectionHelper;
import SA.SRFramework.DataEx.BaseDataEntity;

public class ProcParam
extends BaseDataEntity {
    public static final String TAG_PARAMNAME = "PARAMNAME";
    public static final String TAG_DIRECTION = "DIRECTION";

    public String getParamName() {
        return this.GetParamStringValue(TAG_PARAMNAME, "");
    }

    public int getDirection() {
        return ParameterDirectionHelper.FromString((String)this.GetParamStringValue(TAG_DIRECTION, "INPUT"));
    }
}

