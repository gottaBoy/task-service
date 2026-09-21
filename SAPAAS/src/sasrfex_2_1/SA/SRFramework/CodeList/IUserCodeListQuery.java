/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.CodeList;

import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.IUserCodeListContext;

public interface IUserCodeListQuery {
    public void Init(IUserCodeListContext var1);

    public CodeItemConfig Query(String var1);
}

