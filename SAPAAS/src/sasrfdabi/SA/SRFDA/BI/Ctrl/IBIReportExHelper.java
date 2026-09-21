/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BICubeCacheCondition;
import SA.SRFDA.BI.Ctrl.Data.BIReportEx;
import SA.SRFDA.BI.Ctrl.IBICubeCache;
import SA.SRFDA.BI.Ctrl.IBICubeHelper;
import SA.SRFDA.BI.Ctrl.IBIRepDMHelper;
import SA.SRFDA.BI.Ctrl.IBIRepMSHelper;
import SA.SRFDA.BI.Ctrl.IBIRepRPHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Vector;
import net.sf.json.JSONObject;

public interface IBIReportExHelper {
    public void Init(ISRFDAGlobalHelper var1, IBICubeHelper var2, BIReportEx var3) throws Exception;

    public BIReportEx getBIReportEx();

    public IBICubeHelper getBICube();

    public String getId();

    public int getVersion();

    public String getLogicName(String var1);

    public String getDescription(String var1);

    public Vector<IBIRepDMHelper> getDimensions();

    public Vector<IBIRepDMHelper> getLeftDimensions();

    public Vector<IBIRepDMHelper> getTopDimensions();

    public Vector<IBIRepMSHelper> getMeasures();

    public JSONObject getBIReportExModel() throws Exception;

    public void GetPovitTableRowDimensionDataInfo(IBICubeCache var1, Vector<BaseDataEntity> var2) throws Exception;

    public void GetChartRowDimensionDataInfo(IBICubeCache var1, Vector<BaseDataEntity> var2, BICubeCacheCondition var3) throws Exception;

    public int getPageSize(int var1);

    public boolean isShowMeasureGroup();

    public Vector<IBIRepRPHelper> getRelatedPanels();
}

