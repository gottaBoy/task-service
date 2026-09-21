/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BaseBIAggTableBuilder;
import SA.SRFDA.BI.Ctrl.Data.BIAggColumn;
import SA.SRFDA.BI.Ctrl.Data.BIAggTabDetail;
import SA.SRFDA.BI.Ctrl.Data.BIAggTable;
import SA.SRFDA.BI.Ctrl.Data.BICube;
import SA.SRFDA.BI.Ctrl.Data.BIHierarchy;
import SA.SRFDA.BI.Ctrl.Data.BILevel;
import SA.SRFDA.BI.Ctrl.Data.BIMeasure;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.Vector;

public class DB2BIAggTableBuilder
extends BaseBIAggTableBuilder {
    @Override
    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, BIAggTable aggTable) {
        return super.Init(iDAGlobalHelper, aggTable);
    }

    @Override
    public CallResult Generate(Date date) {
        CallResult callResult = new CallResult();
        try {
            callResult = this.OnExportSignAggTable(this.aggTable);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u751f\u6210DB2\u805a\u5408\u5b58\u50a8\u8fc7\u7a0b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()));
        }
        return callResult;
    }

    protected String OnGetSQL_AggTableDetailIsEmptyQuery(String strAggtableId) {
        return StringHelper.Format((String)("select * from V_SRFBIAGGTABDETAIL where BIAGGTABLEID='" + strAggtableId + "'"));
    }

    protected String OnGetSQL_AggTableDetailQuery(String strAggtableId) {
        return StringHelper.Format((String)("select * from V_SRFBIAGGTABDETAIL where BIAGGTABLEID='" + strAggtableId + "'" + "  order by createdate desc fetch first 1 rows only"));
    }

    protected String OnGetSQL_AggTableColumnQuery(String strAggtableId) {
        return StringHelper.Format((String)("select * from V_SRFBIAGGCOLUMN where BIAGGTABLEID='" + strAggtableId + "'"));
    }

    protected String OnGetSQL_CubeQuery(String strCubeId) {
        return StringHelper.Format((String)("select * from V_SRFBICUBE where BICUBEID='" + strCubeId + "'"));
    }

    protected String OnGetSQL_BIlevelNQuery(String strBILevelId) {
        return StringHelper.Format((String)("select * from V_SRFBILEVEL where BILEVELID='" + strBILevelId + "'"));
    }

    protected String OnGetSQL_BIHierarchyQuery(String strBIHierarchyid) {
        return StringHelper.Format((String)("select * from V_SRFBIHIERARCHY where BIHIERARCHYID='" + strBIHierarchyid + "'"));
    }

    protected String OnGetSQL_SRFDER1NQuery(String strMajorDeId, String strMinorDeId) {
        return StringHelper.Format((String)("select * from V_SRFDER1N where MAJORDEID='" + strMajorDeId + "'" + " AND MINORDEID='" + strMinorDeId + "'"));
    }

    protected String OnGetSQL_SRFBIMeasureQuery(String StrBIMeasureId) {
        return StringHelper.Format((String)("select * from V_SRFBIMEASURE where BIMEASUREID='" + StrBIMeasureId + "'"));
    }

    protected String OnGetSQL_sysprocQuery(String Strprocname) {
        return StringHelper.Format((String)("select * from T_SYSROUTINES where ROUTINENAME='" + Strprocname + "'"));
    }

    protected int OnGetNumDay(int year, int month) {
        int intNumDay = 0;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            intNumDay = 31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            intNumDay = 30;
        }
        if (month == 2) {
            intNumDay = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 29 : 28;
        }
        return intNumDay;
    }

    protected String OnGetSeasonStartDay(String year, int month) {
        String startDay = "";
        if (month <= 3) {
            startDay = String.valueOf(year) + "-01-01 00:00:00";
            return startDay;
        }
        if (month > 3 && month <= 6) {
            startDay = String.valueOf(year) + "-04-01 00:00:00";
            return startDay;
        }
        if (month > 6 && month <= 9) {
            startDay = String.valueOf(year) + "-07-01 00:00:00";
            return startDay;
        }
        if (month > 9 && month <= 12) {
            startDay = String.valueOf(year) + "-10-01 00:00:00";
            return startDay;
        }
        return startDay;
    }

    protected String OnGetSeasonEndDay(String year, int month) {
        String endDay = "";
        if (month <= 3) {
            endDay = String.valueOf(year) + "-03-31 23:59:59";
            return endDay;
        }
        if (month > 3 && month <= 6) {
            endDay = String.valueOf(year) + "-06-30 23:59:59";
            return endDay;
        }
        if (month > 6 && month <= 9) {
            endDay = String.valueOf(year) + "-09-30 23:59:59";
            return endDay;
        }
        if (month > 9 && month <= 12) {
            endDay = String.valueOf(year) + "-12-31 23:59:59";
            return endDay;
        }
        return endDay;
    }

    protected String OnGetHalfYearStartDay(String year, int month) {
        String startDay = "";
        if (month <= 6) {
            startDay = String.valueOf(year) + "-01-01 00:00:00";
            return startDay;
        }
        if (month > 6 && month <= 12) {
            startDay = String.valueOf(year) + "-07-01 00:00:00";
            return startDay;
        }
        return startDay;
    }

    protected String OnGetHalfYearEndDay(String year, int month) {
        String endDay = "";
        if (month <= 6) {
            endDay = String.valueOf(year) + "-06-30 23:59:59";
            return endDay;
        }
        if (month > 6 && month <= 12) {
            endDay = String.valueOf(year) + "-12-31 23:59:59";
            return endDay;
        }
        return endDay;
    }

    protected String OnGetYearStartDay(String year, int month) {
        return String.valueOf(year) + "-01-01 00:00:00";
    }

    protected String OnGetYearEndDay(String year, int month) {
        return String.valueOf(year) + "-12-31 23:59:59";
    }

    protected CallResult OnExportSignAggTable(BIAggTable aggtable) throws Exception {
        IDEHelper aggtableDEHelper;
        String strNewAggpProceNamefmt;
        String strMonth;
        String strYear;
        Calendar cal2;
        String strAggSqLevel = "";
        String strAggSqMeasure = "";
        String strAggSqForeignKey = "";
        String strAggLeftJoinTable = "";
        String strAggGroupBy = "";
        String strInsertTableDataLevel = "";
        String strInsertTableDataMeasure = "";
        String strInsertTableDataFk = "";
        String strSqld = "";
        String strSqls = "";
        String strcallproc = "";
        String strStartDay = "";
        String strEndDay = "";
        String sqlIndex = "";
        String sqldeclareIndex = "";
        String sqlexecuteIndex = "";
        int i = 0;
        ArrayList<String> Listdimtable = new ArrayList<String>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (StringHelper.Compare((String)aggtable.getSEPARATETYPE(), (String)"MONTH", (boolean)true) == 0) {
            cal2 = Calendar.getInstance();
            Calendar cal3 = Calendar.getInstance();
            cal2.set(5, 1);
            String strYear2 = String.format("%1$tY", cal2.getTime());
            String strMonth2 = String.format("%1$tm", cal2.getTime());
            cal3.set(5, this.OnGetNumDay(Integer.parseInt(strYear2), Integer.parseInt(strMonth2)));
            strStartDay = String.format("%1$tY-%1$tm-%1$td 00:00:00", cal2.getTime());
            strEndDay = String.format("%1$tY-%1$tm-%1$td 23:59:59", cal3.getTime());
        }
        if (StringHelper.Compare((String)aggtable.getSEPARATETYPE(), (String)"SEASON", (boolean)true) == 0) {
            cal2 = Calendar.getInstance();
            strYear = String.format("%1$tY", cal2.getTime());
            strMonth = String.format("%1$tm", cal2.getTime());
            strStartDay = this.OnGetSeasonStartDay(strYear, Integer.parseInt(strMonth));
            strEndDay = this.OnGetSeasonStartDay(strYear, Integer.parseInt(strMonth));
        }
        if (StringHelper.Compare((String)aggtable.getSEPARATETYPE(), (String)"HALFYEAR", (boolean)true) == 0) {
            cal2 = Calendar.getInstance();
            strYear = String.format("%1$tY", cal2.getTime());
            strMonth = String.format("%1$tm", cal2.getTime());
            strStartDay = this.OnGetHalfYearStartDay(strYear, Integer.parseInt(strMonth));
            strEndDay = this.OnGetHalfYearEndDay(strYear, Integer.parseInt(strMonth));
        }
        if (StringHelper.Compare((String)aggtable.getSEPARATETYPE(), (String)"YEAR", (boolean)true) == 0) {
            cal2 = Calendar.getInstance();
            strYear = String.format("%1$tY", cal2.getTime());
            strMonth = String.format("%1$tm", cal2.getTime());
            strStartDay = this.OnGetYearStartDay(strYear, Integer.parseInt(strMonth));
            strEndDay = this.OnGetYearEndDay(strYear, Integer.parseInt(strMonth));
        }
        String straggtablename = aggtable.getAGGTABLENAME();
        int intstrtablename = straggtablename.indexOf("%");
        String strtablename0 = straggtablename.substring(0, intstrtablename);
        String strtablename1 = straggtablename.substring(intstrtablename);
        String strtablenamedyna = String.format(strtablename1, new Date());
        String strNewAggTable = String.valueOf(strtablename0) + strtablenamedyna;
        String straggprocnamefmt = aggtable.getAGGPROCNAMEFMT();
        int intaggprocnamefmt = straggprocnamefmt.indexOf("%");
        String strprocnamefmt0 = straggprocnamefmt.substring(0, intaggprocnamefmt);
        String strprocnamefmt1 = straggprocnamefmt.substring(intaggprocnamefmt);
        String strprocedyna = String.format(strprocnamefmt1, new Date());
        strcallproc = strNewAggpProceNamefmt = String.valueOf(strprocnamefmt0) + strprocedyna;
        if (aggtable.getAGGPROCDELAYDAY() > 0) {
            String strNewAggpProceNamefmtfact;
            Calendar cal = Calendar.getInstance();
            cal.add(5, -aggtable.getAGGPROCDELAYDAY());
            Date layday = cal.getTime();
            String strprocedynafact = String.format(strprocnamefmt1, layday);
            strcallproc = strNewAggpProceNamefmtfact = String.valueOf(strprocnamefmt0) + strprocedynafact;
        }
        if ((aggtableDEHelper = this.iDAGlobalHelper.getDAModelStorage().FindDEHelper(aggtable.getDEID())) == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6BIAggtable[%1$s]\u5bf9\u5e94\u7684\u5b9e\u4f53[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)aggtable.getBIAGGTABLEID(), (Object)aggtable.getDEID()));
        }
        BICube bicube = new BICube();
        CallResult callResultlistCube = BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_CubeQuery(aggtable.getBICUBEID()), (BaseDataEntity)bicube);
        if (callResultlistCube.IsError()) {
            return callResultlistCube;
        }
        IDEHelper bicubeDEHelper = this.iDAGlobalHelper.getDAModelStorage().FindDEHelper(bicube.getDEID());
        if (bicubeDEHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6BICube[%1$s]\u5bf9\u5e94\u7684\u5b9e\u4f53[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)bicube.getBICUBEID(), (Object)bicube.getDEID()));
        }
        Vector list = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_AggTableColumnQuery(aggtable.getBIAGGTABLEID()), list, (String)BIAggColumn.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        for (BIAggColumn aggcolumn : list) {
            if (StringHelper.Compare((String)aggcolumn.getAGGCOLUMNTYPE(), (String)"Level", (boolean)true) == 0) {
                BILevel bilevel = new BILevel();
                CallResult callResultlevel = BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_BIlevelNQuery(aggcolumn.getBIDMLEVELID()), (BaseDataEntity)bilevel);
                if (callResultlevel.IsError()) {
                    return callResultlevel;
                }
                BIHierarchy bihierarchy = new BIHierarchy();
                CallResult callResultbiierarchy = BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_BIHierarchyQuery(bilevel.getBIHIERARCHYID()), (BaseDataEntity)bihierarchy);
                if (callResultbiierarchy.IsError()) {
                    return callResultbiierarchy;
                }
                IDEHelper bidimDEHelper = this.iDAGlobalHelper.getDAModelStorage().FindDEHelper(bihierarchy.getDEID());
                if (bidimDEHelper == null) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6BIDim[%1$s]\u5bf9\u5e94\u7684\u5b9e\u4f53[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)bihierarchy.getBIHIERARCHYID(), (Object)bihierarchy.getDEID()));
                }
                if (!Listdimtable.contains(bidimDEHelper.GetMainTable())) {
                    Listdimtable.add(bidimDEHelper.GetMainTable());
                    DER1N der1n = new DER1N();
                    CallResult callResultder1n = BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_SRFDER1NQuery(bihierarchy.getDEID(), bicube.getDEID()), (BaseDataEntity)der1n);
                    if (callResultder1n.IsError()) {
                        return callResultder1n;
                    }
                    strAggLeftJoinTable = String.valueOf(strAggLeftJoinTable) + StringHelper.Format((String)("LEFT OUTER JOIN " + bidimDEHelper.GetMainTable() + " ON " + bicubeDEHelper.GetDEViewName() + '.' + der1n.getMAJORKEYDEFNAME() + "=" + bidimDEHelper.GetMainTable() + '.' + bidimDEHelper.GetKeyDEFHelper().getName() + "\n"));
                }
                strAggSqLevel = StringHelper.IsNullOrEmpty((String)bilevel.getCAPDEFNAME()) ? String.valueOf(strAggSqLevel) + StringHelper.Format((String)(String.valueOf(bidimDEHelper.GetMainTable()) + '.' + bilevel.getDEFNAME() + ",\n")) : String.valueOf(strAggSqLevel) + StringHelper.Format((String)(String.valueOf(bidimDEHelper.GetMainTable()) + '.' + bilevel.getCAPDEFNAME() + ",\n"));
                strInsertTableDataLevel = String.valueOf(strInsertTableDataLevel) + StringHelper.Format((String)(String.valueOf(aggcolumn.getAGGFIELDNAME()) + ",\n"));
                String sqlIndexDim = "";
                sqlIndexDim = String.valueOf(sqlIndexDim) + StringHelper.Format((String)("CREATE INDEX IDX_" + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 14).toUpperCase() + " ON " + strNewAggTable + "(" + aggcolumn.getAGGFIELDNAME() + ")"));
                sqldeclareIndex = String.valueOf(sqldeclareIndex) + StringHelper.Format((String)("DECLARE INDEXTEMP" + i + "  VARCHAR(1000);\n"));
                sqlIndex = String.valueOf(sqlIndex) + StringHelper.Format((String)("SET INDEXTEMP" + i + "='" + sqlIndexDim + "';\n"));
                sqlexecuteIndex = String.valueOf(sqlexecuteIndex) + StringHelper.Format((String)("EXECUTE IMMEDIATE INDEXTEMP" + i + ";\n"));
                ++i;
                continue;
            }
            if (StringHelper.Compare((String)aggcolumn.getAGGCOLUMNTYPE(), (String)"Measure", (boolean)true) == 0) {
                BIMeasure bimeasure = new BIMeasure();
                CallResult callResultlistbimeasure = BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_SRFBIMeasureQuery(aggcolumn.getBICUBEMEASUREID()), (BaseDataEntity)bimeasure);
                if (callResultlistbimeasure.IsError()) {
                    return callResultlistbimeasure;
                }
                strAggSqMeasure = String.valueOf(strAggSqMeasure) + StringHelper.Format((String)(String.valueOf(bimeasure.getAGGREGATOR()) + "(" + bicubeDEHelper.GetDEViewName() + '.' + aggcolumn.getAGGFIELDNAME() + ")" + ",\n"));
                strInsertTableDataMeasure = String.valueOf(strInsertTableDataMeasure) + StringHelper.Format((String)(String.valueOf(aggcolumn.getAGGFIELDNAME()) + ",\n"));
                continue;
            }
            if (StringHelper.Compare((String)aggcolumn.getAGGCOLUMNTYPE(), (String)"ForeignKey", (boolean)true) == 0) {
                strAggSqForeignKey = String.valueOf(strAggSqForeignKey) + StringHelper.Format((String)(String.valueOf(bicubeDEHelper.GetDEViewName()) + '.' + aggcolumn.getFKFIELDNAME() + ",\n"));
                strInsertTableDataFk = String.valueOf(strInsertTableDataFk) + StringHelper.Format((String)(String.valueOf(aggcolumn.getAGGFIELDNAME()) + ",\n"));
                String sqlIndexFk = "";
                sqlIndexFk = String.valueOf(sqlIndexFk) + StringHelper.Format((String)("CREATE INDEX IDX_" + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 14).toUpperCase() + " ON " + strNewAggTable + "(" + aggcolumn.getAGGFIELDNAME() + ")"));
                sqldeclareIndex = String.valueOf(sqldeclareIndex) + StringHelper.Format((String)("DECLARE INDEXTEMP" + i + "  VARCHAR(1000);\n"));
                sqlIndex = String.valueOf(sqlIndex) + StringHelper.Format((String)("SET INDEXTEMP" + i + "='" + sqlIndexFk + "';\n"));
                sqlexecuteIndex = String.valueOf(sqlexecuteIndex) + StringHelper.Format((String)("EXECUTE IMMEDIATE INDEXTEMP" + i + ";\n"));
                ++i;
                continue;
            }
            if (StringHelper.Compare((String)aggcolumn.getAGGCOLUMNTYPE(), (String)"IgnoreColumn", (boolean)true) != 0) continue;
        }
        String s = String.valueOf(strAggSqLevel) + strAggSqForeignKey;
        strAggGroupBy = s.substring(0, s.length() - 2);
        String procname0 = String.valueOf(this.aggTableDEHelper.GetDBSchema()) + '.' + aggtable.getAGGPROCNAME();
        String procname1 = String.valueOf(this.aggTableDEHelper.GetDBSchema()) + '.' + strNewAggpProceNamefmt;
        this.DropDBProc(aggtable.getAGGPROCNAME());
        this.DropDBProc(strNewAggpProceNamefmt);
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)("CREATE PROCEDURE " + procname1 + "()" + "\n\n"));
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)"LANGUAGE SQL\n");
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)"NOT DETERMINISTIC\n");
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)"NO EXTERNAL ACTION\n");
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)"MODIFIES SQL DATA\n");
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)"CALLED ON NULL INPUT\n");
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)"INHERIT SPECIAL REGISTERS\n");
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)"BEGIN\n\n");
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)"DECLARE ASTRTEMP VARCHAR(4000);\n");
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)"DECLARE BSTRTEMP VARCHAR(4000);\n");
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)(String.valueOf(sqldeclareIndex) + "\n"));
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)("IF EXISTS(SELECT * FROM SYSIBM.SYSTABLES WHERE (NAME='" + strNewAggTable + "')) THEN \n"));
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)("DROP TABLE " + strNewAggTable + ";" + "\nEND IF;\n\n"));
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)"SET ASTRTEMP='\n");
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)("CREATE TABLE " + strNewAggTable + " AS (\n" + "SELECT " + strInsertTableDataLevel + strInsertTableDataFk + strInsertTableDataMeasure + aggtable.getFACTCOUNTFIELDNAME() + "\n" + "FROM " + aggtableDEHelper.GetMainTable() + ") DEFINITION ONLY';\n\n"));
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)(String.valueOf(sqlIndex) + "\n"));
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)"SET BSTRTEMP='\n");
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)("INSERT INTO " + strNewAggTable + "\n" + "SELECT " + strAggSqLevel + strAggSqForeignKey + strAggSqMeasure + "COUNT(*)" + " \n" + "FROM " + bicubeDEHelper.GetDEViewName() + "\n" + strAggLeftJoinTable));
        if (StringHelper.Compare((String)aggtable.getSEPARATETYPE(), (String)"NO", (boolean)true) != 0) {
            strSqld = String.valueOf(strSqld) + StringHelper.Format((String)("WHERE " + bicubeDEHelper.GetDEViewName() + "." + aggtable.getTIMEDEFNAME() + ">='||'''" + strStartDay + "'''||'" + " AND " + bicubeDEHelper.GetDEViewName() + "." + aggtable.getTIMEDEFNAME() + "<='||'''" + strEndDay + "'''\n||'"));
        }
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)("GROUP BY " + strAggGroupBy + "';\n\n"));
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)"EXECUTE IMMEDIATE ASTRTEMP;\n");
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)sqlexecuteIndex);
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)"EXECUTE IMMEDIATE BSTRTEMP;\n\n");
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)("IF NOT EXISTS(SELECT * FROM T_SRFBIAGGTABDETAIL WHERE (BIAGGTABDETAILID='" + strNewAggTable + "')) THEN \n"));
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)"INSERT INTO T_SRFBIAGGTABDETAIL(\nBIAGGTABDETAILID,BIAGGTABDETAILNAME,AGGPROCNAME,BIAGGTABLEID,LASTAGGTIME,CREATEMAN,CREATEDATE,UPDATEMAN,UPDATEDATE)\n");
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)("VALUES(\n'" + strNewAggTable + "','" + strNewAggTable + "','" + strNewAggpProceNamefmt + "','" + aggtable.getBIAGGTABLEID() + "',"));
        Vector listbiaggtabdetail = new Vector();
        CallResult callResultbiaggtabdetailcount = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_AggTableDetailIsEmptyQuery(aggtable.getBIAGGTABLEID()), listbiaggtabdetail, (String)BIAggTabDetail.class.getName());
        if (callResultbiaggtabdetailcount.IsError()) {
            return callResultbiaggtabdetailcount;
        }
        if (listbiaggtabdetail.isEmpty()) {
            strSqld = String.valueOf(strSqld) + StringHelper.Format((String)"NULL,\n");
        } else {
            BIAggTabDetail biaggtabledetail = new BIAggTabDetail();
            CallResult callResultbiaggtabdetail = BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.OnGetSQL_AggTableDetailQuery(aggtable.getBIAGGTABLEID()), (BaseDataEntity)biaggtabledetail);
            if (callResultbiaggtabdetail.IsError()) {
                return callResultbiaggtabdetail;
            }
            strSqld = String.valueOf(strSqld) + StringHelper.Format((String)("'" + formatter.format(biaggtabledetail.getCREATEDATE()) + "',\n"));
        }
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)("'SYSTEM','" + formatter.format(new Date()) + "'" + ",'SYSTEM'," + "'" + formatter.format(new Date()) + "');\nEND IF;\n\n"));
        strSqld = String.valueOf(strSqld) + StringHelper.Format((String)"END\n\n");
        callResult = this.CompileDBProc(procname1, strSqld);
        strSqls = String.valueOf(strSqls) + StringHelper.Format((String)("CREATE PROCEDURE " + procname0 + "()" + "\n\n"));
        strSqls = String.valueOf(strSqls) + StringHelper.Format((String)"LANGUAGE SQL\n");
        strSqls = String.valueOf(strSqls) + StringHelper.Format((String)"NOT DETERMINISTIC\n");
        strSqls = String.valueOf(strSqls) + StringHelper.Format((String)"NO EXTERNAL ACTION\n");
        strSqls = String.valueOf(strSqls) + StringHelper.Format((String)"MODIFIES SQL DATA\n");
        strSqls = String.valueOf(strSqls) + StringHelper.Format((String)"CALLED ON NULL INPUT\n");
        strSqls = String.valueOf(strSqls) + StringHelper.Format((String)"INHERIT SPECIAL REGISTERS\n");
        strSqls = String.valueOf(strSqls) + StringHelper.Format((String)"BEGIN\n\n");
        strSqls = String.valueOf(strSqls) + StringHelper.Format((String)("CALL " + strcallproc + "();" + "\n\n"));
        strSqls = String.valueOf(strSqls) + StringHelper.Format((String)"END\n\n");
        this.CompileDBProc(procname0, strSqls);
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }
}

