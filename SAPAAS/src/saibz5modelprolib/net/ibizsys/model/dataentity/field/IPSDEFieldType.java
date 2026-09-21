/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFFormItem
 *  net.ibizsys.model.control.form.IPSDEFSearchFormItem
 *  net.ibizsys.model.control.grid.IPSDEFGridColumn
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.field.IPSDEFSearchMode
 *  net.ibizsys.model.dataentity.field.IPSDEFUIMode
 *  net.ibizsys.model.dataentity.field.IPSDEField
 */
package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.form.IPSDEFFormItem;
import net.ibizsys.model.control.form.IPSDEFSearchFormItem;
import net.ibizsys.model.control.grid.IPSDEFGridColumn;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.field.IPSDEFSearchMode;
import net.ibizsys.model.dataentity.field.IPSDEFUIMode;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.entity.PSDEFSearchMode;
import net.ibizsys.model.entity.PSDEFUIMode;
import net.ibizsys.model.entity.PSDEField;
import net.ibizsys.model.entity.PSDEFieldType;

public interface IPSDEFieldType
extends IPSModelObject {
    public void init(IPSModelStorageContext var1, PSDEFieldType var2) throws Exception;

    public boolean isSupportPSDEField(String var1);

    public IPSDEField createPSDEField(PSDEField var1) throws Exception;

    public String getPSCodeListTemplId();

    public int getStdDataType();

    public int getPrecision();

    public IPSDEFGridColumn createPSDEFGridColumn(PSDEFUIMode var1) throws Exception;

    public IPSDEFFormItem createPSDEFFormItem(PSDEFUIMode var1) throws Exception;

    public IPSDEFUIMode createPSDEFUIMode(PSDEFUIMode var1) throws Exception;

    public IPSDEFSearchMode createPSDEFSearchMode(PSDEFSearchMode var1) throws Exception;

    public IPSDEFSearchFormItem createPSDEFSearchFormItem(PSDEFSearchMode var1) throws Exception;

    public String getEditorType();

    public Integer getEditorWidth();

    public Integer getEditorHeight();

    public String getValueFormat(String var1);

    public int getStringLength();

    public int getLength();

    public String getMBEditorType();

    public Integer getMBEditorWidth();

    public Integer getMBEditorHeight();

    public String getPSValueRuleId();

    public boolean isAutoIncrement();

    public boolean isUnsigned();

    public String getSearchEditorType();

    public Integer getSearchEditorWidth();

    public Integer getSearchEditorHeight();

    public String getSearchMBEditorType();

    public Integer getSearchMBEditorWidth();

    public Integer getSearchMBEditorHeight();
}

