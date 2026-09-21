/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db;

import java.util.Iterator;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.web.IWebContext;

public interface ISelectContext
extends ISelectCond {
    public String getDEDataQueryName();

    public Iterator<ISelectField> getSelectFields();

    public IWebContext getWebContext();

    public int getViewLevel();

    public String getSort();

    public String getSortDir();
}

