/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 */
package net.ibizsys.model.codelist;

import java.util.Iterator;
import net.ibizsys.model.IPSModelJsonExporter;
import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.codelist.IPSCodeItem;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.paas.codelist.ICodeList;

public interface IPSCodeList
extends IPSSystemObject,
ICodeList,
IPSModelJsonExporter {
    public Iterator<IPSCodeItem> getPSCodeItems() throws Exception;

    public IPSDataEntity getPSDataEntity() throws Exception;

    public IPSDEDataSet getPSDEDataSet() throws Exception;

    public String getPredefinedType();

    public IPSDEField getTextPSDEField() throws Exception;

    public IPSDEField getValuePSDEField() throws Exception;

    public IPSDEField getMinorSortPSDEField() throws Exception;

    public String getMinorSortDir();

    public IPSDEField getIconClsPSDEField() throws Exception;

    public IPSDEField getIconClsXPSDEField() throws Exception;

    public IPSDEField getIconPathPSDEField() throws Exception;

    public IPSDEField getIconPathXPSDEField() throws Exception;

    public String getFetchCondition();

    public IPSDEField getPValuePSDEField() throws Exception;

    public IPSLanguageRes getEmptyTextPSLanguageRes();

    public boolean isEnableDynaSys();

    public IPSDEField getDisablePSDEField() throws Exception;
}

