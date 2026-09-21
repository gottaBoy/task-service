/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTypeHelper
 */
package SA.SRFDA.Model.ValueFunc;

import SA.SRFDA.Model.IDAValueFunc;
import SA.SRFDA.Model.ValueFuncConfig;
import SA.SRFramework.Data.DataTypeHelper;

public abstract class BaseDateValueFunc
implements IDAValueFunc {
    protected ValueFuncConfig valueFuncConfig = null;

    @Override
    public boolean Init(ValueFuncConfig valueFuncConfig) {
        this.valueFuncConfig = valueFuncConfig;
        return true;
    }

    @Override
    public ValueFuncConfig getValueFuncConfig() {
        return this.valueFuncConfig;
    }

    @Override
    public boolean IsSupportDataType(String strDataType) {
        int nDataType = DataTypeHelper.FromString((String)strDataType);
        return DataTypeHelper.IsDateTimeType((int)nDataType);
    }
}

