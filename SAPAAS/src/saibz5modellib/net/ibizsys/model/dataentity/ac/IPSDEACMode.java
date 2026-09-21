/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEACMode
 */
package net.ibizsys.model.dataentity.ac;

import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.paas.core.IDEACMode;

public interface IPSDEACMode
extends IPSDataEntityObject,
IDEACMode {
    public boolean isDefaultMode();

    public String getCodeName();

    public boolean isEnablePagingBar();

    public int getPagingSize();

    public IPSDEField getMinorSortPSDEF();

    public String getMinorSortDir();

    public IPSDEField getValuePSDEF();

    public IPSDEField getTextPSDEF();

    public String getLogicName();

    public IPSLanguageRes getEmptyTextPSLanguageRes();

    public String getEmptyText();
}

