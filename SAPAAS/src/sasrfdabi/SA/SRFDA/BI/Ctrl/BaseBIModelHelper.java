/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BICatalog;
import SA.SRFDA.BI.Ctrl.Data.BICube;
import SA.SRFDA.BI.Ctrl.Data.BICubeDimension;
import SA.SRFDA.BI.Ctrl.Data.BICubeMeasure;
import SA.SRFDA.BI.Ctrl.Data.BIDimension;
import SA.SRFDA.BI.Ctrl.Data.BIHierarchy;
import SA.SRFDA.BI.Ctrl.Data.BILevel;
import SA.SRFDA.BI.Ctrl.Data.BIRepChart;
import SA.SRFDA.BI.Ctrl.Data.BIRepChartDS;
import SA.SRFDA.BI.Ctrl.Data.BIRepDM;
import SA.SRFDA.BI.Ctrl.Data.BIRepFI;
import SA.SRFDA.BI.Ctrl.Data.BIRepFIType;
import SA.SRFDA.BI.Ctrl.Data.BIRepFilter;
import SA.SRFDA.BI.Ctrl.Data.BIRepMS;
import SA.SRFDA.BI.Ctrl.Data.BIRepPDS;
import SA.SRFDA.BI.Ctrl.Data.BIRepPDSQ;
import SA.SRFDA.BI.Ctrl.Data.BIRepPI;
import SA.SRFDA.BI.Ctrl.Data.BIRepPL;
import SA.SRFDA.BI.Ctrl.Data.BIRepPQ;
import SA.SRFDA.BI.Ctrl.Data.BIRepPT;
import SA.SRFDA.BI.Ctrl.Data.BIRepPanel;
import SA.SRFDA.BI.Ctrl.Data.BIRepPart;
import SA.SRFDA.BI.Ctrl.Data.BIRepRP;
import SA.SRFDA.BI.Ctrl.Data.BIReportEx;
import SA.SRFDA.BI.Ctrl.IBIModelHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Vector;

public class BaseBIModelHelper
implements IBIModelHelper {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public CallResult GetBICatalog(String strBICatalogId, BICatalog biCatalog) {
        return this.SelectSingle(this.GetSQL_GetBICatalog(strBICatalogId), biCatalog, "SYSTEM");
    }

    protected String GetSQL_GetBICatalog(String strBICatalogId) {
        return StringHelper.Format((String)"select t1.* from T_SRFBICATALOG t1 where t1.BICATALOGID='%1$s'", (Object)strBICatalogId);
    }

    @Override
    public CallResult GetBICube(String strBICubeId, BICube biCube) {
        return this.SelectSingle(this.GetSQL_GetBICube(strBICubeId), biCube, "SYSTEM");
    }

    protected String GetSQL_GetBICube(String strBICubeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFBICUBE t1 where t1.BICUBEID='%1$s'", (Object)strBICubeId);
    }

    @Override
    public CallResult GetBIReportEx(String strBIReportExId, BIReportEx biReportEx) {
        return this.SelectSingle(this.GetSQL_GetBIReportEx(strBIReportExId), biReportEx, "SYSTEM");
    }

    protected String GetSQL_GetBIReportEx(String strBIReportExId) {
        return StringHelper.Format((String)"select t1.* from T_SRFBIREPORTEX t1 where t1.BIREPORTEXID='%1$s'", (Object)strBIReportExId);
    }

    @Override
    public CallResult GetBICubeDimensions(String strBICubeId, Vector<BICubeDimension> biCubeDimensions) {
        return this.SelectMulti(this.GetSQL_GetBICubeDimensions(strBICubeId), biCubeDimensions, BICubeDimension.class, "SYSTEM");
    }

    protected String GetSQL_GetBICubeDimensions(String strBICubeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFBICUBEDIMENSION t1 where t1.BICUBEID='%1$s'", (Object)strBICubeId);
    }

    @Override
    public CallResult GetBICubeMeasures(String strBICubeId, Vector<BICubeMeasure> biCubeMeasures) {
        return this.SelectMulti(this.GetSQL_GetBICubeMeasures(strBICubeId), biCubeMeasures, BICubeMeasure.class, "SYSTEM");
    }

    protected String GetSQL_GetBICubeMeasures(String strBICubeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFBICUBEMEASURE t1 where t1.BICUBEID='%1$s'", (Object)strBICubeId);
    }

    @Override
    public CallResult GetBIRepDMs(String strBIReportExId, Vector<BIRepDM> biRepDMs) {
        return this.SelectMulti(this.GetSQL_GetBIRepDMs(strBIReportExId), biRepDMs, BIRepDM.class, "SYSTEM");
    }

    protected String GetSQL_GetBIRepDMs(String strBIReportExId) {
        return StringHelper.Format((String)"select t1.* from T_SRFBIREPDM t1 where t1.BIREPORTEXID='%1$s' ORDER BY t1.PLACEPOS", (Object)strBIReportExId);
    }

    @Override
    public CallResult GetBIRepMSs(String strBIReportExId, Vector<BIRepMS> biRepMSs) {
        return this.SelectMulti(this.GetSQL_GetBIRepMSs(strBIReportExId), biRepMSs, BIRepMS.class, "SYSTEM");
    }

    protected String GetSQL_GetBIRepMSs(String strBIReportExId) {
        return StringHelper.Format((String)"select t1.* from T_SRFBIREPMS t1 where t1.BIREPORTEXID='%1$s' ORDER BY t1.PLACEPOS", (Object)strBIReportExId);
    }

    @Override
    public CallResult GetBIHierarchies(String strBIDimensionId, Vector<BIHierarchy> biHierarchies) {
        return this.SelectMulti(this.GetSQL_GetBIHierarchies(strBIDimensionId), biHierarchies, BIHierarchy.class, "SYSTEM");
    }

    protected String GetSQL_GetBIHierarchies(String strBIDimensionId) {
        return StringHelper.Format((String)"select t1.* from T_SRFBIHIERARCHY t1 where t1.BIDIMENSIONID='%1$s'", (Object)strBIDimensionId);
    }

    @Override
    public CallResult GetBIDimensions(String strBICatalogId, Vector<BIDimension> biDimensions) {
        return this.SelectMulti(this.GetSQL_GetBIDimensions(strBICatalogId), biDimensions, BIDimension.class, "SYSTEM");
    }

    protected String GetSQL_GetBIDimensions(String strBICatalogId) {
        return StringHelper.Format((String)"select t1.* from V_SRFBIDIMENSION t1 where t1.BICUBEID IS NULL AND t1.BICATALOGID='%1$s'", (Object)strBICatalogId);
    }

    @Override
    public CallResult GetBILevels(String strBIHierarchyId, Vector<BILevel> biLevels) {
        return this.SelectMulti(this.GetSQL_GetBILevels(strBIHierarchyId), biLevels, BILevel.class, "SYSTEM");
    }

    protected String GetSQL_GetBILevels(String strBIHierarchyId) {
        return StringHelper.Format((String)"select t1.* from V_SRFBILEVEL t1 where t1.BIHIERARCHYID = '%1$s' ORDER BY ORDERFLAG", (Object)strBIHierarchyId);
    }

    @Override
    public CallResult GetBIRepRPs(String strBIReportExId, Vector<BIRepRP> biRepRPs) {
        if (this.iDAGlobalHelper.getDAModelHelper().GetDEModelVersion("BI0090") == -1) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetBIRepRPs(strBIReportExId), biRepRPs, BIRepRP.class, "SYSTEM");
    }

    protected String GetSQL_GetBIRepRPs(String strBIReportExId) {
        return StringHelper.Format((String)"select t1.* from T_SRFBIREPRP t1 where t1.BIREPORTEXID = '%1$s' ORDER BY ORDERFLAG", (Object)strBIReportExId);
    }

    @Override
    public CallResult GetBIRepPanel(String strBIRepPanelId, BIRepPanel biRepPanel) {
        return this.SelectSingle(this.GetSQL_GetBIRepPanel(strBIRepPanelId), biRepPanel, "SYSTEM");
    }

    protected String GetSQL_GetBIRepPanel(String strBIRepPanelId) {
        return StringHelper.Format((String)"select t1.* from V_SRFBIREPPANEL t1 where t1.BIREPPANELID='%1$s'", (Object)strBIRepPanelId);
    }

    @Override
    public CallResult GetBIRepChart(String strBIRepChartId, BIRepChart biRepChart) {
        return this.SelectSingle(this.GetSQL_GetBIRepChart(strBIRepChartId), biRepChart, "SYSTEM");
    }

    protected String GetSQL_GetBIRepChart(String strBIRepChartId) {
        return StringHelper.Format((String)"select t1.* from V_SRFBIREPCHART t1 where t1.BIREPCHARTID='%1$s'", (Object)strBIRepChartId);
    }

    @Override
    public CallResult GetBIRepFilter(String strBIRepFilterId, BIRepFilter biRepFilter) {
        return this.SelectSingle(this.GetSQL_GetBIRepFilter(strBIRepFilterId), biRepFilter, "SYSTEM");
    }

    protected String GetSQL_GetBIRepFilter(String strBIRepFilterId) {
        return StringHelper.Format((String)"select t1.* from V_SRFBIREPFILTER t1 where t1.BIREPFILTERID='%1$s'", (Object)strBIRepFilterId);
    }

    @Override
    public CallResult GetBIRepFIType(String strBIRepFITypeId, BIRepFIType biRepFIType) {
        return this.SelectSingle(this.GetSQL_GetBIRepFIType(strBIRepFITypeId), biRepFIType, "SYSTEM");
    }

    protected String GetSQL_GetBIRepFIType(String strBIRepFITypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFBIREPFITYPE t1 where t1.BIREPFITYPEID='%1$s'", (Object)strBIRepFITypeId);
    }

    @Override
    public CallResult GetBIRepPart(String strBIRepPartId, BIRepPart biRepPart) {
        return this.SelectSingle(this.GetSQL_GetBIRepPart(strBIRepPartId), biRepPart, "SYSTEM");
    }

    protected String GetSQL_GetBIRepPart(String strBIRepPartId) {
        return StringHelper.Format((String)"select t1.* from T_SRFBIREPPART t1 where t1.BIREPPARTID='%1$s'", (Object)strBIRepPartId);
    }

    @Override
    public CallResult GetBIRepPT(String strBIRepPTId, BIRepPT biCube) {
        return this.SelectSingle(this.GetSQL_GetBIRepPT(strBIRepPTId), biCube, "SYSTEM");
    }

    protected String GetSQL_GetBIRepPT(String strBIRepPTId) {
        return StringHelper.Format((String)"select t1.* from T_SRFBIREPPT t1 where t1.BIREPPTID='%1$s'", (Object)strBIRepPTId);
    }

    @Override
    public CallResult GetBIRepPL(String strBIRepPLId, BIRepPL biRepPL) {
        return this.SelectSingle(this.GetSQL_GetBIRepPL(strBIRepPLId), biRepPL, "SYSTEM");
    }

    protected String GetSQL_GetBIRepPL(String strBIRepPLId) {
        return StringHelper.Format((String)"select t1.* from T_SRFBIREPPL t1 where t1.BIREPPLID='%1$s'", (Object)strBIRepPLId);
    }

    @Override
    public CallResult GetBIRepPIs(String strBIRepPanelId, Vector<BIRepPI> biRepPIs) {
        if (this.iDAGlobalHelper.getDAModelHelper().GetDEModelVersion("BI0086") == -1) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetBIRepPIs(strBIRepPanelId), biRepPIs, BIRepPI.class, "SYSTEM");
    }

    protected String GetSQL_GetBIRepPIs(String strBIRepPanelId) {
        return StringHelper.Format((String)"select t1.* from T_SRFBIREPPI t1 where t1.BIREPPANELID = '%1$s' ", (Object)strBIRepPanelId);
    }

    @Override
    public CallResult GetBIRepPQs(String strBIRepPanelId, Vector<BIRepPQ> biRepPQs) {
        if (this.iDAGlobalHelper.getDAModelHelper().GetDEModelVersion("BI0087") == -1) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetBIRepPQs(strBIRepPanelId), biRepPQs, BIRepPQ.class, "SYSTEM");
    }

    protected String GetSQL_GetBIRepPQs(String strBIRepPanelId) {
        return StringHelper.Format((String)"select t1.* from T_SRFBIREPPQ t1 where t1.BIREPPANELID = '%1$s' ", (Object)strBIRepPanelId);
    }

    @Override
    public CallResult GetBIRepPDSs(String strBIRepPanelId, Vector<BIRepPDS> biRepPDSs) {
        if (this.iDAGlobalHelper.getDAModelHelper().GetDEModelVersion("BI0088") == -1) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetBIRepPDSs(strBIRepPanelId), biRepPDSs, BIRepPDS.class, "SYSTEM");
    }

    protected String GetSQL_GetBIRepPDSs(String strBIRepPanelId) {
        return StringHelper.Format((String)"select t1.* from T_SRFBIREPPDS t1 where t1.BIREPPANELID = '%1$s' ", (Object)strBIRepPanelId);
    }

    @Override
    public CallResult GetBIRepPDSQs(String strBIRepPDSId, Vector<BIRepPDSQ> biRepPDSQs) {
        if (this.iDAGlobalHelper.getDAModelHelper().GetDEModelVersion("BI0089") == -1) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetBIRepPDSQs(strBIRepPDSId), biRepPDSQs, BIRepPDSQ.class, "SYSTEM");
    }

    protected String GetSQL_GetBIRepPDSQs(String strBIRepPDSId) {
        return StringHelper.Format((String)"select t1.* from T_SRFBIREPPDSQ t1 where t1.BIREPPDSID = '%1$s' ", (Object)strBIRepPDSId);
    }

    @Override
    public CallResult GetBIRepChartDSs(String strBIRepChartId, Vector<BIRepChartDS> biRepChartDSs) {
        if (this.iDAGlobalHelper.getDAModelHelper().GetDEModelVersion("BI0100") == -1) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetBIRepChartDSs(strBIRepChartId), biRepChartDSs, BIRepChartDS.class, "SYSTEM");
    }

    protected String GetSQL_GetBIRepChartDSs(String strBIRepChartId) {
        return StringHelper.Format((String)"select t1.* from T_SRFBIREPCHARTDS t1 where t1.BIREPCHARTID = '%1$s' ", (Object)strBIRepChartId);
    }

    @Override
    public CallResult GetBIRepFIs(String strBIRepFilterId, Vector<BIRepFI> biRepFIs) {
        return this.SelectMulti(this.GetSQL_GetBIRepFIs(strBIRepFilterId), biRepFIs, BIRepFI.class, "SYSTEM");
    }

    protected String GetSQL_GetBIRepFIs(String strBIRepFilterId) {
        return StringHelper.Format((String)"select t1.* from T_SRFBIREPFI t1 where t1.BIREPFILTERID = '%1$s' ORDER BY t1.ORDERFLAG ", (Object)strBIRepFilterId);
    }

    protected CallResult SelectSingle(String strSQL, BaseDataEntity dataEntity, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.iDAGlobalHelper.getDBCaller().CallRaw2(strSQL);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            if (selectResult.getMainTable().GetRowCount() == 0) {
                callResult.setRetCode(3);
                return callResult;
            }
            dataEntity.FromDataRow(selectResult.getMainTable().GetRow(0));
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult SelectMulti(String strSQL, Vector list, Class classType, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.iDAGlobalHelper.getDBCaller().CallRaw2(strSQL);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            int nRowCount = selectResult.getMainTable().GetRowCount();
            int i = 0;
            while (i < nRowCount) {
                Object obj;
                BaseDataEntity dataEntity = null;
                if (classType != null && (obj = ObjectHelper.Create((Class)classType)) != null && obj instanceof BaseDataEntity) {
                    dataEntity = (BaseDataEntity)obj;
                }
                if (dataEntity == null) {
                    dataEntity = new BaseDataEntity();
                }
                dataEntity.FromDataRow(selectResult.getMainTable().GetRow(i));
                list.add(dataEntity);
                ++i;
            }
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult SelectMulti(String strSQL, Vector list, String strObjectName, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.iDAGlobalHelper.getDBCaller().CallRaw2(strSQL);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            int nRowCount = selectResult.getMainTable().GetRowCount();
            int i = 0;
            while (i < nRowCount) {
                Object obj;
                BaseDataEntity dataEntity = null;
                if (!StringHelper.IsNullOrEmpty((String)strObjectName) && (obj = ObjectHelper.Create((String)strObjectName)) != null && obj instanceof BaseDataEntity) {
                    dataEntity = (BaseDataEntity)obj;
                }
                if (dataEntity == null) {
                    dataEntity = new BaseDataEntity();
                }
                dataEntity.FromDataRow(selectResult.getMainTable().GetRow(i));
                list.add(dataEntity);
                ++i;
            }
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }
}

