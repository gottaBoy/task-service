/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEDataSyncIn
 *  net.ibizsys.paas.core.IDEDataSyncOut
 */
package SA.SRFDA.PS.Core.DataEntity.DataSync;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysDataSyncAgent;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginSupportable;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Data.PSDEDataSync;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEDataSyncIn;
import net.ibizsys.paas.core.IDEDataSyncOut;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDataSync")
public interface IPSDEDataSync
extends IPSDataEntityObject,
IDEDataSyncIn,
IDEDataSyncOut,
IPSSysSFPluginSupportable {
    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEDataSync var3) throws Exception;

    public String getSyncDir();

    public boolean isExportFull();

    public int getEventType();

    public IPSDEAction getOutTestPSDEAction();

    public IPSDEAction getInTestPSDEAction();

    public IPSDEAction getImportPSDEAction();

    @Override
    public String getCodeName();

    public IPSSysDataSyncAgent getInPSSysDataSyncAgent();

    public IPSSysDataSyncAgent getOutPSSysDataSyncAgent();

    public boolean isValid();

    public String getInScriptCode();

    public String getOutScriptCode();

    public IPSDEDataSet getOutPSDEDataSet();

    public IPSDEDataSet getInPSDEDataSet();

    public IPSSFXCodeObject getRender();

    public boolean isInCustomCode();

    public boolean isOutCustomCode();

    public int getOutputMode();
}

