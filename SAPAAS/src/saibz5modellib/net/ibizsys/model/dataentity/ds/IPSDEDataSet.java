/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataSet
 */
package net.ibizsys.model.dataentity.ds;

import java.util.Iterator;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.ds.IPSDEDataSetGroupParam;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.paas.core.IDEDataSet;

public interface IPSDEDataSet
extends IPSDataEntityObject,
IDEDataSet {
    public Iterator<IPSDEDataQuery> getPSDEDataQueries();

    public Iterator<IPSDEDataSetGroupParam> getPSDEDataSetGroupParams();

    public boolean isDefaultMode();

    public String getPredefinedType();

    public IPSDEDataSetGroupParam getPSDEDataSetGroupParam(String var1, boolean var2) throws Exception;

    public IPSCodeList getPSCodeList();

    public String getLogicName();

    public IPSDEField getMajorSortPSDEField();

    public IPSDEField getMinorSortPSDEField();

    public IPSDELogic getActiveDataPSDELogic();

    public boolean isEnableTempData();
}

