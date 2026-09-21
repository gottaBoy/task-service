/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Print;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Data.PSDEPrint;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6253\u5370\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEPrint")
public interface IPSDEPrint
extends IPSDataEntityObject {
    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEPrint var3) throws Exception;

    public IPSDEDataSet getPSDEDataSet();

    @Deprecated
    public String getPSDEDataSetId();

    @Override
    public String getCodeName();

    public boolean isEnableColPriv();

    public boolean isEnableLog();

    public boolean isEnableMulitPrint();

    public IPSDEAction getGetDataPSDEAction();

    public String getGetDataPSDEActionId();

    public String getReportType();

    public String getReportFile();

    public IPSDEOPPriv getGetDataPSDEOPPriv();

    public String getDetailPSDEId();

    public IPSDataEntity getDetailPSDE();

    public IPSDEDataSet getDetailPSDEDataSet();

    public String getDetailActiveDataPSDELogicId();

    public IPSDELogic getDetailActiveDataPSDELogic();

    @Override
    public int getExtendMode();

    public boolean isDefaultMode();

    public String getReportModel();

    public String getDataAccessAction();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public int getPOTime();

    public String getContentType();

    public String getPrintTag();

    public String getPrintTag2();

    public Properties getPrintParams();

    public String getReportUIModel();

    public IPSSysPFPlugin getPSSysPFPlugin();
}

