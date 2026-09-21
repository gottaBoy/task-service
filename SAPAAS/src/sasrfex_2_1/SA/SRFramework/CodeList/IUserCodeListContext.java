/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.BaseDBCallerHelper
 */
package SA.SRFramework.CodeList;

import SA.SRFramework.Data.BaseDBCallerHelper;
import SA.SRFramework.WebEx.Utility.ContextHelper;

public interface IUserCodeListContext {
    public Object GetUserTag(String var1);

    public ContextHelper GetContextHelper();

    public BaseDBCallerHelper GetDBCallerHelper();
}

