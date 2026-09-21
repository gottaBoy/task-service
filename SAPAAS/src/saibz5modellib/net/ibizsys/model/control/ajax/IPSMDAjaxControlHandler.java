/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataRange
 */
package net.ibizsys.model.control.ajax;

import net.ibizsys.model.control.ajax.IPSAjaxControlHandler;
import net.ibizsys.model.dataentity.dataexport.IPSDEDataExport;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.paas.core.IDEDataRange;

public interface IPSMDAjaxControlHandler
extends IPSAjaxControlHandler,
IDEDataRange {
    public static final String ACTION_ADDBATCH = "addbatch";
    public static final String ACTION_UIACTION = "uiaction";
    public static final String ACTION_EXPORTMODEL = "exportmodel";
    public static final String ACTION_EXPORTIMPTEMPL = "exportimptempl";
    public static final String ACTION_EXPORTDATA = "exportdata";

    public String getPSDEDataSetId();

    public IPSDEDataSet getPSDEDataSet() throws Exception;

    public String getPSDEDataExportId();

    public IPSDEDataExport getPSDEDataExport() throws Exception;

    public int getFetchTimeout();

    public String getActiveDataPSDELogicId();

    public IPSDELogic getActiveDataPSDELogic() throws Exception;
}

