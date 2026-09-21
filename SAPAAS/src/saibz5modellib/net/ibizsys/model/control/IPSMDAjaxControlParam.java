/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control;

import net.ibizsys.model.control.IPSAjaxControlParam;
import net.ibizsys.model.dataentity.dataexport.IPSDEDataExport;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.logic.IPSDELogic;

public interface IPSMDAjaxControlParam
extends IPSAjaxControlParam {
    public String getPSDEDataSetId();

    public IPSDEDataSet getPSDEDataSet() throws Exception;

    public String getPSDEDataExportId();

    public IPSDEDataExport getPSDEDataExport() throws Exception;

    public String getActiveDataPSDELogicId();

    public IPSDELogic getActiveDataPSDELogic() throws Exception;
}

