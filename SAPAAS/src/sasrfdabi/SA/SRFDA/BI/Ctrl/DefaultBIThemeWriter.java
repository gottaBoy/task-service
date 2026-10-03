/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BIAggColumn;
import SA.SRFDA.BI.Ctrl.Data.BIAggTabDetail;
import SA.SRFDA.BI.Ctrl.Data.BIAggTable;
import SA.SRFDA.BI.Ctrl.Data.BICalculatedMeasure;
import SA.SRFDA.BI.Ctrl.Data.BICatalog;
import SA.SRFDA.BI.Ctrl.Data.BICatalogRole;
import SA.SRFDA.BI.Ctrl.Data.BICube;
import SA.SRFDA.BI.Ctrl.Data.BICubeDimension;
import SA.SRFDA.BI.Ctrl.Data.BICubeDimensionRole;
import SA.SRFDA.BI.Ctrl.Data.BICubeMeasure;
import SA.SRFDA.BI.Ctrl.Data.BICubeRole;
import SA.SRFDA.BI.Ctrl.Data.BIDimension;
import SA.SRFDA.BI.Ctrl.Data.BIDimensionRef;
import SA.SRFDA.BI.Ctrl.Data.BIHRCMemberRole;
import SA.SRFDA.BI.Ctrl.Data.BIHierarchy;
import SA.SRFDA.BI.Ctrl.Data.BIHierarchyRole;
import SA.SRFDA.BI.Ctrl.Data.BILevel;
import SA.SRFDA.BI.Ctrl.Data.BIMeasure;
import SA.SRFDA.BI.Ctrl.Data.BIUserRoleDetail;
import SA.SRFDA.BI.Ctrl.ISRFDABIThemeWriter;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.SimpleXMLWriter;
import java.util.HashMap;
import java.util.Vector;

public class DefaultBIThemeWriter
implements ISRFDABIThemeWriter {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected IDEDataCtrl dimensionDataCtrl = null;
    protected IDEDataCtrl dimensionrefDataCtrl = null;
    protected IDEDataCtrl hierarchyDataCtrl = null;
    protected BICatalog biCatalog = null;
    protected HashMap<String, IDEHelper> deHelperMap = new HashMap();

    @Override
    public CallResult Export(ISRFDAGlobalHelper iDAGlobalHelper, BICatalog biCatalog, SimpleXMLWriter xmlWriter) {
        CallResult callResult = new CallResult();
        try {
            this.iDAGlobalHelper = iDAGlobalHelper;
            this.biCatalog = biCatalog;
            this.dimensionDataCtrl = iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("BI0003", "SYSTEM", null);
            this.dimensionrefDataCtrl = iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("BI0004", "SYSTEM", null);
            this.hierarchyDataCtrl = iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("BI0005", "SYSTEM", null);
            xmlWriter.WriteStartElement("Schema");
            xmlWriter.WriteAttributeString("name", biCatalog.getBICATALOGNAME());
            callResult = this.OnExportGlobalDimension(xmlWriter);
            if (callResult.IsError()) {
                return callResult;
            }
            callResult = this.OnExportCube(xmlWriter);
            if (callResult.IsError()) {
                return callResult;
            }
            callResult = this.OnExportUserRoles(xmlWriter);
            if (callResult.IsError()) {
                return callResult;
            }
            xmlWriter.WriteEndElement();
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5bfc\u51fa\u5206\u6790\u6a21\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()));
        }
        return callResult;
    }

    protected String OnGetSQL_GlobalDimension() {
        return StringHelper.Format((String)"select * from V_SRFBIDIMENSION where BICUBEID IS NULL AND BICATALOGID = '%1$s'", (Object)this.biCatalog.getBICATALOGID());
    }

    protected CallResult OnExportGlobalDimension(SimpleXMLWriter xmlWriter) throws Exception {
        Vector<BIDimension> list = new Vector<BIDimension>();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_GlobalDimension(), list, (String)BIDimension.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        for (BIDimension dimension : list) {
            callResult = this.OnExportDimension(xmlWriter, null, dimension, true);
            if (!callResult.IsError()) continue;
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnExportDimension(SimpleXMLWriter xmlWriter, BICube cube, BIDimension dimension, Boolean GlobalFlag) throws Exception {
        try {
            xmlWriter.WriteStartElement("Dimension");
            xmlWriter.WriteAttributeString("name", dimension.getBIDIMENSIONNAME());
            if (!GlobalFlag.booleanValue()) {
                xmlWriter.WriteAttributeString("foreignKey", this.OnGetDimensionFK(cube, dimension.getBIDIMENSIONID(), null));
            }
            if (!StringHelper.IsNullOrEmpty((String)dimension.getDIMENSIONTYPE())) {
                xmlWriter.WriteAttributeString("type", dimension.getDIMENSIONTYPE());
            }
            if (!StringHelper.IsNullOrEmpty((String)dimension.getCAPTION())) {
                xmlWriter.WriteAttributeString("caption", dimension.getCAPTION());
            }
            Vector<BIHierarchy> list = new Vector<BIHierarchy>();
            CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_Hierarchy(dimension.getBIDIMENSIONID()), list, (String)BIHierarchy.class.getName());
            if (callResult.IsError()) {
                return callResult;
            }
            if (list.size() == 0) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u5206\u6790\u7ef4\u5ea6[%1$s]\u5b9a\u4e49\u4e00\u4e2a\u6216\u591a\u4e2a\u7ef4\u5ea6\u4f53\u7cfb", (Object)dimension.getBIDIMENSIONNAME()));
                return callResult;
            }
            for (BIHierarchy hierarchy : list) {
                callResult = this.OnExportHierarchy(xmlWriter, hierarchy, GlobalFlag);
                if (!callResult.IsError()) continue;
                return callResult;
            }
            xmlWriter.WriteEndElement();
            return callResult;
        }
        catch (Exception e) {
            throw new Exception("\u5bfc\u51faBIDimension \u53d1\u751f\u5f02\u5e38", e);
        }
    }

    protected String OnGetSQL_Hierarchy(String strDimensionId) {
        return "select * from V_SRFBIHIERARCHY t where BIDIMENSIONID='" + strDimensionId + "'";
    }

    protected CallResult OnExportHierarchy(SimpleXMLWriter xmlWriter, BIHierarchy hierarchy, Boolean GlobalFlag) {
        IDEHelper hierachyDEHelper = this.iDAGlobalHelper.getDAModelStorage().FindDEHelper(hierarchy.getDEID());
        xmlWriter.WriteStartElement("Hierarchy");
        xmlWriter.WriteAttributeString("name", hierarchy.getBIHIERARCHYNAME());
        xmlWriter.WriteAttributeString("hasAll", String.valueOf(hierarchy.getHASALL()));
        xmlWriter.WriteAttributeString("primaryKey", hierachyDEHelper.GetKeyDEFHelper().GetDTColumn().GetColumnName());
        if (!StringHelper.IsNullOrEmpty((String)hierarchy.getCAPTION())) {
            xmlWriter.WriteAttributeString("caption", hierarchy.getCAPTION());
        }
        if (!StringHelper.IsNullOrEmpty((String)hierarchy.getALLCAPTION())) {
            xmlWriter.WriteAttributeString("allMemberCaption", hierarchy.getALLCAPTION());
        }
        GlobalFlag.booleanValue();
        xmlWriter.WriteStartElement("Table");
        xmlWriter.WriteAttributeString("name", hierachyDEHelper.GetMainTable().toUpperCase());
        xmlWriter.WriteEndElement();
        Vector<BILevel> list = new Vector<BILevel>();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_Level(hierarchy.getBIHIERARCHYID()), list, (String)BILevel.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        if (list.size() == 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u5206\u6790\u7ef4\u5ea6\u4f53\u7cfb[%1$s]\u5b9a\u4e49\u4e00\u4e2a\u6216\u591a\u4e2a\u4f53\u7cfb\u7ea7\u522b", (Object)hierarchy.getBIHIERARCHYNAME()));
            return callResult;
        }
        for (BILevel level : list) {
            callResult = this.OnExportLevel(xmlWriter, level, hierachyDEHelper);
            if (!callResult.IsError()) continue;
            return callResult;
        }
        xmlWriter.WriteEndElement();
        return callResult;
    }

    protected String OnGetSQL_Level(String strHierarchy) {
        return "select * from V_SRFBILEVEL where BIHIERARCHYID='" + strHierarchy + "' order by orderflag";
    }

    protected CallResult OnExportLevel(SimpleXMLWriter xmlWriter, BILevel level, IDEHelper hierachyDEHelper) {
        int nDataType;
        CallResult callResult = new CallResult();
        IDEFHelper levelDEFHelper = hierachyDEHelper.GetDEFHelper(level.getDEFID());
        if (levelDEFHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)level.getDEFID()));
            return callResult;
        }
        xmlWriter.WriteStartElement("Level");
        xmlWriter.WriteAttributeString("name", level.getBILEVELNAME());
        xmlWriter.WriteAttributeString("column", levelDEFHelper.GetDTColumn().GetColumnName());
        if (!StringHelper.IsNullOrEmpty((String)level.getCAPDEFID())) {
            IDEFHelper capDEFHelper = hierachyDEHelper.GetDEFHelper(level.getCAPDEFID());
            if (capDEFHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)level.getCAPDEFID()));
                return callResult;
            }
            xmlWriter.WriteAttributeString("nameColumn", capDEFHelper.GetDTColumn().GetColumnName());
        }
        xmlWriter.WriteAttributeString("levelType", level.getLEVELTYPE());
        if (!StringHelper.IsNullOrEmpty((String)level.getCAPTION())) {
            xmlWriter.WriteAttributeString("caption", level.getCAPTION());
        }
        if (DataTypeHelper.IsDateTimeType((int)(nDataType = DataTypeHelper.FromString((String)levelDEFHelper.GetDataType())))) {
            xmlWriter.WriteAttributeString("type", "Timestamp");
        } else if (DataTypeHelper.IsDoubleType((int)nDataType)) {
            xmlWriter.WriteAttributeString("type", "Numeric");
        } else if (DataTypeHelper.IsIntType((int)nDataType)) {
            xmlWriter.WriteAttributeString("type", "Integer");
        } else {
            xmlWriter.WriteAttributeString("type", "String");
        }
        xmlWriter.WriteAttributeString("uniqueMembers", String.valueOf(level.getUNIQUEMEMBERS()));
        xmlWriter.WriteEndElement();
        return callResult;
    }

    protected String OnGetSQL_Cube() {
        return StringHelper.Format((String)"select * from V_SRFBICUBE where enable=1 AND BICATALOGID = '%1$s'", (Object)this.biCatalog.getBICATALOGID());
    }

    protected CallResult OnExportCube(SimpleXMLWriter xmlWriter) throws Exception {
        Vector<BICube> list = new Vector<BICube>();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_Cube(), list, (String)BICube.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        for (BICube cube : list) {
            IDEHelper cubeDEHelper = this.GetCubeDEHelper(cube);
            xmlWriter.WriteStartElement("Cube");
            xmlWriter.WriteAttributeString("name", cube.getBICUBENAME());
            if (!StringHelper.IsNullOrEmpty((String)cube.getCAPTION())) {
                xmlWriter.WriteAttributeString("caption", cube.getCAPTION());
            }
            if (!StringHelper.IsNullOrEmpty((String)cube.getDESCRIPTION())) {
                xmlWriter.WriteAttributeString("description", cube.getDESCRIPTION());
            }
            xmlWriter.WriteStartElement("Table");
            xmlWriter.WriteAttributeString("name", cubeDEHelper.GetMainTable().toUpperCase());
            this.OnExportCubeAggTable(xmlWriter, cube, cubeDEHelper);
            xmlWriter.WriteEndElement();
            this.OnExportCubeDimension(xmlWriter, cube);
            this.OnExportCubeMeasure(xmlWriter, cube);
            xmlWriter.WriteEndElement();
        }
        return callResult;
    }

    protected IDEHelper GetCubeDEHelper(BICube cube) {
        String strKey = StringHelper.Format((String)"CUBEDEHELPER----%1$s", (Object)cube.getDEID());
        if (this.deHelperMap.containsKey(strKey)) {
            return this.deHelperMap.get(strKey);
        }
        IDEHelper iDEHelper = this.iDAGlobalHelper.getDAModelStorage().FindDEHelper(cube.getDEID());
        if (iDEHelper == null) {
            return null;
        }
        this.deHelperMap.put(strKey, iDEHelper);
        return iDEHelper;
    }

    protected String OnGetSQL_CubeAggTable(String strCubeId) {
        return "select * from V_SRFBIAGGTABLE where BICUBEID='" + strCubeId + "' ";
    }

    protected String OnGetSQL_AggColumn(String strAggTableId) {
        return "select * from V_SRFBIAGGCOLUMN where BIAGGTABLEID='" + strAggTableId + "' ";
    }

    protected String OnGetSQL_AggTabDetail(String strAggTableId) {
        return "select * from V_SRFBIAGGTABDETAIL where BIAGGTABLEID='" + strAggTableId + "' ";
    }

    protected CallResult OnExportCubeAggTable(SimpleXMLWriter xmlWriter, BICube cube, IDEHelper cubeDEHelper) {
        Vector<BIAggTable> list = new Vector<BIAggTable>();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_CubeAggTable(cube.getBICUBEID()), list, (String)BIAggTable.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        for (BIAggTable aggTable : list) {
            Vector<BIAggTabDetail> list2 = new Vector<BIAggTabDetail>();
            if (aggTable.getENABLEAUTOAGG() && (callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_AggTabDetail(aggTable.getBIAGGTABLEID()), list2, (String)BIAggTabDetail.class.getName())).IsError()) {
                return callResult;
            }
            Vector<String> tableList = new Vector<String>();
            IDEHelper aggTableDEHelper = this.iDAGlobalHelper.getDAModelStorage().FindDEHelper(aggTable.getDEID());
            if (aggTableDEHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)aggTable.getDEID()));
                return callResult;
            }
            if (!aggTable.getEXCLUDEFALG()) {
                tableList.add(aggTableDEHelper.GetMainTable().toUpperCase());
            }
            for (BIAggTabDetail aggTableDetail : list2) {
                tableList.add(aggTableDetail.getBIAGGTABDETAILNAME());
            }
            if (tableList.size() == 0) continue;
            Vector<BIAggColumn> list3 = new Vector<BIAggColumn>();
            callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_AggColumn(aggTable.getBIAGGTABLEID()), list3, (String)BIAggColumn.class.getName());
            if (callResult.IsError()) {
                return callResult;
            }
            for (String strTableName : tableList) {
                xmlWriter.WriteStartElement("AggName");
                xmlWriter.WriteAttributeString("name", strTableName);
                xmlWriter.WriteStartElement("AggFactCount");
                xmlWriter.WriteAttributeString("column", aggTableDEHelper.GetDEFHelper(aggTable.getFACTCOUNTFIELDID()).GetDTColumn().GetColumnName());
                xmlWriter.WriteEndElement();
                for (BIAggColumn aggColumn : list3) {
                    if (StringHelper.Compare((String)aggColumn.getAGGCOLUMNTYPE(), (String)"ForeignKey", (boolean)true) != 0) continue;
                    xmlWriter.WriteStartElement("AggForeignKey");
                    xmlWriter.WriteAttributeString("factColumn", cubeDEHelper.GetDEFHelper(aggColumn.getFKFIELDID()).GetDTColumn().GetColumnName());
                    xmlWriter.WriteAttributeString("aggColumn", aggTableDEHelper.GetDEFHelper(aggColumn.getAGGFIELDID()).GetDTColumn().GetColumnName());
                    xmlWriter.WriteEndElement();
                }
                for (BIAggColumn aggColumn : list3) {
                    if (StringHelper.Compare((String)aggColumn.getAGGCOLUMNTYPE(), (String)"Measure", (boolean)true) != 0) continue;
                    xmlWriter.WriteStartElement("AggMeasure");
                    xmlWriter.WriteAttributeString("name", StringHelper.Format((String)"[Measures].[%1$s]", (Object)aggColumn.getBICUBEMEASURENAME()));
                    xmlWriter.WriteAttributeString("column", aggTableDEHelper.GetDEFHelper(aggColumn.getAGGFIELDID()).GetDTColumn().GetColumnName());
                    xmlWriter.WriteEndElement();
                }
                for (BIAggColumn aggColumn : list3) {
                    if (StringHelper.Compare((String)aggColumn.getAGGCOLUMNTYPE(), (String)"Level", (boolean)true) != 0) continue;
                    BIHierarchy dataEntity = new BIHierarchy();
                    callResult = BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_HierarchyByLevel(aggColumn.getBIDMLEVELID()), (BaseDataEntity)dataEntity);
                    if (callResult.IsError()) {
                        return callResult;
                    }
                    xmlWriter.WriteStartElement("AggLevel");
                    xmlWriter.WriteAttributeString("name", StringHelper.Format((String)"[%1$s.%2$s].[%3$s]", (Object)dataEntity.getBIDIMENSIONNAME(), (Object)dataEntity.getBIHIERARCHYNAME(), (Object)aggColumn.getBIDMLEVELNAME()));
                    xmlWriter.WriteAttributeString("column", aggTableDEHelper.GetDEFHelper(aggColumn.getAGGFIELDID()).GetDTColumn().GetColumnName());
                    xmlWriter.WriteEndElement();
                }
                xmlWriter.WriteEndElement();
            }
        }
        return callResult;
    }

    protected String OnGetSQL_HierarchyByLevel(String strBILevelId) {
        return StringHelper.Format((String)"select t1.* from V_SRFBIHIERARCHY t1 where exists (select * from t_SRFBILEVEL t2 where t1.BIHIERARCHYID=t2.BIHIERARCHYID AND t2.BILEVELID='%1$s')", (Object)strBILevelId);
    }

    protected String OnGetSQL_CubeDimension(String strCubeId) {
        return "select * from V_SRFBICUBEDIMENSION where BICUBEID='" + strCubeId + "' order by BICUBEDIMENSIONTYPE desc";
    }

    protected CallResult OnExportCubeDimension(SimpleXMLWriter xmlWriter, BICube cube) throws Exception {
        Vector<BICubeDimension> list = new Vector<BICubeDimension>();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_CubeDimension(cube.getBICUBEID()), list, (String)BICubeDimension.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        for (BICubeDimension cubeDimension : list) {
            if (StringHelper.Compare((String)cubeDimension.getBICUBEDIMENSIONTYPE(), (String)"NORMAL", (boolean)true) == 0) {
                BIDimension dimension = new BIDimension();
                dimension.setBIDIMENSIONID(cubeDimension.getBICUBEDIMENSIONID());
                callResult = this.dimensionDataCtrl.Get((BaseDataEntity)dimension);
                if (callResult.IsError()) {
                    return callResult;
                }
                callResult = this.OnExportDimension(xmlWriter, cube, dimension, false);
                if (!callResult.IsError()) continue;
                return callResult;
            }
            BIDimensionRef dimensionref = new BIDimensionRef();
            dimensionref.setBIDIMENSIONREFID(cubeDimension.getBICUBEDIMENSIONID());
            callResult = this.dimensionrefDataCtrl.Get((BaseDataEntity)dimensionref);
            if (callResult.IsError()) {
                return callResult;
            }
            BIDimension dimension = new BIDimension();
            dimension.setBIDIMENSIONID(dimensionref.getBIDIMENSIONID());
            callResult = this.dimensionDataCtrl.Get((BaseDataEntity)dimension);
            if (callResult.IsError()) {
                return callResult;
            }
            xmlWriter.WriteStartElement("DimensionUsage");
            xmlWriter.WriteAttributeString("name", dimension.getBIDIMENSIONNAME());
            xmlWriter.WriteAttributeString("source", dimension.getBIDIMENSIONNAME());
            xmlWriter.WriteAttributeString("foreignKey", this.OnGetDimensionFK(cube, dimensionref.getBIDIMENSIONID(), null));
            xmlWriter.WriteEndElement();
        }
        return callResult;
    }

    protected String OnGetDimensionFK(BICube cube, String strDimensionID, BIHierarchy hierarchy) throws Exception {
        IDEHelper hierachyDEHelper;
        IDEHelper cubeDEHelper = this.GetCubeDEHelper(cube);
        CallResult callResult = new CallResult();
        if (hierarchy == null) {
            hierarchy = new BIHierarchy();
            hierarchy.setBIDIMENSIONID(strDimensionID);
            Vector list2 = new Vector();
            callResult = this.hierarchyDataCtrl.Select((BaseDataEntity)hierarchy, list2);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6BIDimension[%1$s]\u5305\u542bBIHierarchy\u5931\u8d25\uff0c%2$s", (Object)strDimensionID, (Object)callResult.getErrorInfo()));
            }
            if (list2.size() == 0) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230BIDimension[%1$s]\u5305\u542bBIHierarchy", (Object)strDimensionID));
            }
            ((BaseDataEntity)list2.get(0)).CopyTo((BaseDataEntity)hierarchy, true);
        }
        if ((hierachyDEHelper = this.iDAGlobalHelper.getDAModelStorage().FindDEHelper(hierarchy.getDEID())) == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6BIHierarchy[%1$s]\u5bf9\u5e94\u7684\u5b9e\u4f53[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)hierarchy.getBIHIERARCHYID(), (Object)hierarchy.getDEID()));
        }
        for (IDEFHelper iDEFHelper : cubeDEHelper.GetDEFHelpers()) {
            IPickupDEFHelper iPickupDEFHelper;
            if (!(iDEFHelper instanceof IPickupDEFHelper) || StringHelper.Compare((String)(iPickupDEFHelper = (IPickupDEFHelper)iDEFHelper).GetRealDEFHelper().getId(), (String)hierachyDEHelper.GetKeyDEFHelper().getId(), (boolean)true) != 0) continue;
            return iPickupDEFHelper.GetDTColumn().GetColumnName();
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6BIDimension[%1$s]\u4f7f\u7528\u7684\u5916\u952e", (Object)strDimensionID));
    }

    protected String OnGetSQL_CubeAllMeasure(String strCubeId) {
        return "select * from T_SRFBICUBEMEASURE where BICUBEID='" + strCubeId + "' ORDER BY BICUBEMEASURETYPE DESC,ORDERFLAG ASC";
    }

    protected String OnGetSQL_CubeMeasure(String strCubeId) {
        return "select * from V_SRFBIMEASURE where BICUBEID='" + strCubeId + "'";
    }

    protected String OnGetSQL_CubeCalculatedMeasure(String strCubeId) {
        return "select * from V_SRFBICALCULATEDMEASURE where BICUBEID='" + strCubeId + "'";
    }

    protected CallResult OnExportCubeMeasure(SimpleXMLWriter xmlWriter, BICube cube) {
        Vector<BICubeMeasure> list3 = new Vector<BICubeMeasure>();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_CubeAllMeasure(cube.getBICUBEID()), list3, (String)BICubeMeasure.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        Vector<BIMeasure> list = new Vector<BIMeasure>();
        callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_CubeMeasure(cube.getBICUBEID()), list, (String)BIMeasure.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        Vector<BICalculatedMeasure> list2 = new Vector<BICalculatedMeasure>();
        callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_CubeCalculatedMeasure(cube.getBICUBEID()), list2, (String)BICalculatedMeasure.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        HashMap<String, BaseDataEntity> cubeMeasureMap = new HashMap<String, BaseDataEntity>();
        for (BIMeasure measure : list) {
            cubeMeasureMap.put(measure.getBIMEASUREID(), measure);
        }
        for (BICalculatedMeasure measure : list2) {
            cubeMeasureMap.put(measure.getBICALCULATEDMEASUREID(), measure);
        }
        for (BICubeMeasure cubeMeasure : list3) {
            if (StringHelper.Compare((String)cubeMeasure.getBICUBEMEASURETYPE(), (String)"NORMAL", (boolean)true) == 0) {
                BIMeasure measure = (BIMeasure)cubeMeasureMap.get(cubeMeasure.getBICUBEMEASUREID());
                xmlWriter.WriteStartElement("Measure");
                xmlWriter.WriteAttributeString("name", measure.getBIMEASURENAME());
                xmlWriter.WriteAttributeString("column", measure.getMEASUREFIELNAME());
                xmlWriter.WriteAttributeString("aggregator", measure.getAGGREGATOR());
                if (!StringHelper.IsNullOrEmpty((String)measure.getCAPTION())) {
                    xmlWriter.WriteAttributeString("caption", measure.getCAPTION());
                }
                if (StringHelper.Compare((String)measure.getFMTTYPE(), (String)"CUSTOM", (boolean)true) == 0) {
                    xmlWriter.WriteAttributeString("formatString", measure.getCUSTOMFMT());
                } else {
                    xmlWriter.WriteAttributeString("formatString", measure.getFMTTYPE());
                }
                if (measure.getHIDDENFLAG()) {
                    xmlWriter.WriteAttributeString("visible", "false");
                } else {
                    xmlWriter.WriteAttributeString("visible", "true");
                }
                xmlWriter.WriteEndElement();
                continue;
            }
            BICalculatedMeasure measure = (BICalculatedMeasure)cubeMeasureMap.get(cubeMeasure.getBICUBEMEASUREID());
            xmlWriter.WriteStartElement("CalculatedMember");
            xmlWriter.WriteAttributeString("name", measure.getBICALCULATEDMEASURENAME());
            xmlWriter.WriteAttributeString("dimension", "Measures");
            if (!StringHelper.IsNullOrEmpty((String)measure.getCAPTION())) {
                xmlWriter.WriteAttributeString("caption", measure.getCAPTION());
            }
            if (StringHelper.Compare((String)measure.getFMTTYPE(), (String)"CUSTOM", (boolean)true) == 0) {
                xmlWriter.WriteAttributeString("formatString", measure.getCUSTOMFMT());
            } else {
                xmlWriter.WriteAttributeString("formatString", measure.getFMTTYPE());
            }
            xmlWriter.WriteAttributeString("formula", measure.getMEASUREFORMULA());
            if (measure.getHIDDENFLAG()) {
                xmlWriter.WriteAttributeString("visible", "false");
            } else {
                xmlWriter.WriteAttributeString("visible", "true");
            }
            xmlWriter.WriteEndElement();
        }
        return callResult;
    }

    protected String OnGetSQL_UserRoles() {
        return StringHelper.Format((String)"select t1.* from V_SRFBICATALOGROLE t1 where t1.BICATALOGID =  '%1$s'", (Object)this.biCatalog.getBICATALOGID());
    }

    protected String OnGetSQL_UserRoleDetails() {
        return StringHelper.Format((String)"select t1.* from T_SRFBIUSERROLEDETAIL t1 INNER JOIN T_SRFBICATALOGROLE t2 on t1.BIUSERROLEID = t2.BIUSERROLEID  where t2.BICATALOGID =  '%1$s'", (Object)this.biCatalog.getBICATALOGID());
    }

    protected CallResult OnExportUserRoles(SimpleXMLWriter xmlWriter) throws Exception {
        Vector<BICatalogRole> list = new Vector<BICatalogRole>();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_UserRoles(), list, (String)BICatalogRole.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        for (BICatalogRole cataLogRole : list) {
            xmlWriter.WriteStartElement("Role");
            xmlWriter.WriteAttributeString("name", "ROLE_" + cataLogRole.getBIUSERROLEID());
            xmlWriter.WriteStartElement("SchemaGrant");
            xmlWriter.WriteAttributeString("access", cataLogRole.getDEFAULTACCESS());
            callResult = this.OnExportCubeRoles(xmlWriter, cataLogRole);
            if (callResult.IsError()) {
                return callResult;
            }
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
        }
        Vector<BIUserRoleDetail> list2 = new Vector<BIUserRoleDetail>();
        callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_UserRoleDetails(), list2, (String)BIUserRoleDetail.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        HashMap<String, Vector<String>> userRoleMap = new HashMap<String, Vector<String>>();
        for (BIUserRoleDetail userRoleDetail : list2) {
            Vector<String> roleList = userRoleMap.get(userRoleDetail.getUSERID());
            if (roleList == null) {
                roleList = new Vector<String>();
                userRoleMap.put(userRoleDetail.getUSERID(), roleList);
            }
            roleList.add(userRoleDetail.getBIUSERROLEID());
        }
        for (String strUserId : userRoleMap.keySet()) {
            xmlWriter.WriteStartElement("Role");
            xmlWriter.WriteAttributeString("name", "USER_" + strUserId);
            xmlWriter.WriteStartElement("Union");
            for (String strUserRoleId : userRoleMap.get(strUserId)) {
                xmlWriter.WriteStartElement("RoleUsage");
                xmlWriter.WriteAttributeString("roleName", "ROLE_" + strUserRoleId);
                xmlWriter.WriteEndElement();
            }
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
        }
        xmlWriter.WriteStartElement("Role");
        xmlWriter.WriteAttributeString("name", "ROLE_UNKNOWN");
        xmlWriter.WriteStartElement("SchemaGrant");
        xmlWriter.WriteAttributeString("access", "none");
        xmlWriter.WriteEndElement();
        xmlWriter.WriteEndElement();
        return callResult;
    }

    protected String OnGetSQL_CubeRoles(BICatalogRole cataLogRole) {
        return StringHelper.Format((String)"select t1.* from V_SRFBICUBEROLE t1 INNER JOIN T_SRFBICUBE t2 on t1.BICUBEID = t2.BICUBEID   where t1.BICATALOGROLEID  =  '%1$s' AND t2.ENABLE=1", (Object)cataLogRole.getBICATALOGROLEID());
    }

    protected CallResult OnExportCubeRoles(SimpleXMLWriter xmlWriter, BICatalogRole cataLogRole) throws Exception {
        Vector<BICubeRole> list = new Vector<BICubeRole>();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_CubeRoles(cataLogRole), list, (String)BICubeRole.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        for (BICubeRole cubeRole : list) {
            xmlWriter.WriteStartElement("CubeGrant");
            xmlWriter.WriteAttributeString("cube", cubeRole.getBICUBENAME());
            xmlWriter.WriteAttributeString("access", cubeRole.getACCESSTYPE());
            callResult = this.OnExportHRCRoles(xmlWriter, cubeRole);
            if (callResult.IsError()) {
                return callResult;
            }
            callResult = this.OnExportCubeDimensionRoles(xmlWriter, cubeRole);
            if (callResult.IsError()) {
                return callResult;
            }
            xmlWriter.WriteEndElement();
        }
        return callResult;
    }

    protected String OnGetSQL_HierarchyRoles(BICubeRole cubeRole) {
        return StringHelper.Format((String)"select * from V_SRFBIHierarchyRole  where BICUBEROLEID  =  '%1$s'", (Object)cubeRole.getBICUBEROLEID());
    }

    protected CallResult OnExportHRCRoles(SimpleXMLWriter xmlWriter, BICubeRole cubeRole) throws Exception {
        Vector<BIHierarchyRole> list = new Vector<BIHierarchyRole>();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_HierarchyRoles(cubeRole), list, (String)BIHierarchyRole.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        for (BIHierarchyRole hierarchyRole : list) {
            xmlWriter.WriteStartElement("HierarchyGrant");
            xmlWriter.WriteAttributeString("hierarchy", StringHelper.Format((String)"[%1$s.%2$s]", (Object)hierarchyRole.getBIDIMENSIONNAME(), (Object)hierarchyRole.getBIHIERARCHYNAME()));
            xmlWriter.WriteAttributeString("access", hierarchyRole.getACCESSTYPE());
            callResult = this.OnExportHRCMemberRoles(xmlWriter, hierarchyRole);
            if (callResult.IsError()) {
                return callResult;
            }
            xmlWriter.WriteEndElement();
        }
        return callResult;
    }

    protected String OnGetSQL_HRCMemberRoles(BIHierarchyRole bierarchyRole) {
        return StringHelper.Format((String)"select * from V_SRFBIHRCMemberRole where BIHIERARCHYROLEID  =  '%1$s'", (Object)bierarchyRole.getBIHIERARCHYROLEID());
    }

    protected CallResult OnExportHRCMemberRoles(SimpleXMLWriter xmlWriter, BIHierarchyRole bierarchyRole) throws Exception {
        Vector<BIHRCMemberRole> list = new Vector<BIHRCMemberRole>();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_HRCMemberRoles(bierarchyRole), list, (String)BIHRCMemberRole.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        for (BIHRCMemberRole hrcMemberRole : list) {
            xmlWriter.WriteStartElement("MemberGrant");
            xmlWriter.WriteAttributeString("member", StringHelper.Format((String)"[%1$s.%2$s].%3$s", (Object)bierarchyRole.getBIDIMENSIONNAME(), (Object)bierarchyRole.getBIHIERARCHYNAME(), (Object)hrcMemberRole.getMEMBER()));
            xmlWriter.WriteAttributeString("access", hrcMemberRole.getACCESSTYPE());
            xmlWriter.WriteEndElement();
        }
        return callResult;
    }

    protected String OnGetSQL_CubeDimensionRoles(BICubeRole cubeRole) {
        return StringHelper.Format((String)"select * from V_SRFBICUBEDIMENSIONROLE  where BICUBEROLEID  =  '%1$s'", (Object)cubeRole.getBICUBEROLEID());
    }

    protected CallResult OnExportCubeDimensionRoles(SimpleXMLWriter xmlWriter, BICubeRole cubeRole) throws Exception {
        Vector<BICubeDimensionRole> list = new Vector<BICubeDimensionRole>();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_CubeDimensionRoles(cubeRole), list, (String)BICubeDimensionRole.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        for (BICubeDimensionRole cubeDimensionRule : list) {
            xmlWriter.WriteStartElement("DimensionGrant");
            xmlWriter.WriteAttributeString("dimension", cubeDimensionRule.getBICUBEDIMENSIONNAME());
            xmlWriter.WriteAttributeString("access", cubeDimensionRule.getACCESSTYPE());
            xmlWriter.WriteEndElement();
        }
        return callResult;
    }
}
