/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataRange
 */
package SA.SRFDA.PS.Core.Control.Ajax;

import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxControlHandler;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExport;
import SA.SRFDA.PS.Core.DataEntity.DataImport.IPSDEDataImport;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFDA.PS.Core.Security.IPSSysUserDR;
import net.ibizsys.paas.core.IDEDataRange;

@PSModelInterfaceMeta(title="\u5f02\u6b65\u5904\u7406\u591a\u9879\u6570\u636e\u754c\u9762\u90e8\u4ef6\u5904\u7406\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSMDAjaxControlHandler
extends IPSAjaxControlHandler,
IDEDataRange {
    public static final String ACTION_ADDBATCH = "addbatch";
    public static final String ACTION_UIACTION = "uiaction";
    public static final String ACTION_EXPORTMODEL = "exportmodel";
    public static final String ACTION_EXPORTIMPTEMPL = "exportimptempl";
    public static final String ACTION_EXPORTDATA = "exportdata";
    public static final String ACTION_MOVE = "move";
    public static final String ACTION_GROUPMOVE = "groupmove";
    public static final String ACTION_FETCH = "fetch";

    public String getPSDEDataSetId();

    public String getCustomCond();

    public IPSDEDataSet getPSDEDataSet() throws Exception;

    public String getPSDEDataExportId();

    public IPSDEDataExport getPSDEDataExport() throws Exception;

    public IPSSysUserDR getPSSysUserDR();

    public IPSSysUserDR getPSSysUserDR2();

    public int getFetchTimeout();

    public String getActiveDataPSDELogicId();

    public IPSDELogic getActiveDataPSDELogic() throws Exception;

    public String getPSDEDataImportId();

    public IPSDEDataImport getPSDEDataImport() throws Exception;
}

