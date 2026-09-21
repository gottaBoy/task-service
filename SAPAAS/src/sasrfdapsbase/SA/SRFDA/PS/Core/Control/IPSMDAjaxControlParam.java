/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExport;
import SA.SRFDA.PS.Core.DataEntity.DataImport.IPSDEDataImport;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5f02\u6b65\u5904\u7406\u591a\u9879\u6570\u636e\u754c\u9762\u90e8\u4ef6\u53c2\u6570\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", model="PSDEViewCtrl")
public interface IPSMDAjaxControlParam
extends IPSAjaxControlParam {
    public String getPSDEDataSetId();

    public IPSDEDataSet getPSDEDataSet() throws Exception;

    public String getCustomCond();

    public String getPSDEDataExportId();

    public IPSDEDataExport getPSDEDataExport() throws Exception;

    public String getActiveDataPSDELogicId();

    public IPSDELogic getActiveDataPSDELogic() throws Exception;

    public Integer getEditMode();

    public String getPSDEDataImportId();

    public IPSDEDataImport getPSDEDataImport() throws Exception;

    public Boolean isActiveDataMode();

    public String getActiveDataField();
}

