/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.grid.IPSDEFGridColumn
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.field.IPSDEFSearchMode
 *  net.ibizsys.model.dataentity.field.IPSDEFUIMode
 *  net.ibizsys.model.dataentity.field.IPSDEField
 */
package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.grid.IPSDEFGridColumn;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.field.IPSDEFSearchMode;
import net.ibizsys.model.dataentity.field.IPSDEFUIMode;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.IPSDEFieldType;
import net.ibizsys.model.entity.PSDEFSearchMode;
import net.ibizsys.model.entity.PSDEFUIMode;
import net.ibizsys.model.entity.PSDEField;

public interface IPSDEFieldRuntime
extends IPSDEField,
IPSModelObjectRuntime {
    public void setInitParam(IPSModelStorageContext var1, IPSDataEntity var2, IPSDEFieldType var3, PSDEField var4);

    public void init() throws Exception;

    public boolean isInit();

    public IPSDEFieldType getPSDEFieldType();

    public void setPreDefinedType(String var1);

    public PSDEField getPSDEFieldData();

    public IPSDEFUIMode createPSDEFUIMode(PSDEFUIMode var1) throws Exception;

    @Override
    public int check() throws Exception;

    public IPSDEFGridColumn createPSDEFGridColumn(PSDEFUIMode var1) throws Exception;

    public IPSDEFSearchMode createPSDEFSearchMode(PSDEFSearchMode var1) throws Exception;

    public Object getDEFValue(String var1);
}

