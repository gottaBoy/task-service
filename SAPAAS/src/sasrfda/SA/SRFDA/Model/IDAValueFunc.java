/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Model;

import SA.SRFDA.Model.ValueFuncConfig;

public interface IDAValueFunc {
    public boolean Init(ValueFuncConfig var1);

    public ValueFuncConfig getValueFuncConfig();

    public boolean IsSupportDataType(String var1);

    public String GetDataType();

    public String GetFuncFormat();
}

