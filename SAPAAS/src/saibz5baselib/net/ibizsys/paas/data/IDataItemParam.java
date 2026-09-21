/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.data;

import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.web.IWebContext;

public interface IDataItemParam
extends IModelBase {
    public String getFormat();

    public Object getDefaultValue();

    public String getCodeListId();

    public Object getValue(IWebContext var1, Object var2) throws Exception;
}

