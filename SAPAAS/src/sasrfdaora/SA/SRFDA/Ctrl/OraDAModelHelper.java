/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAModelHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAModelHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;

public class OraDAModelHelper
extends BaseDAModelHelper {
    protected CallResult SelectSingle(String arg0, BaseDataEntity arg1, String arg2) {
        return super.SelectSingle(arg0.replace(";", ""), arg1, arg2);
    }

    protected CallResult SelectMulti(String arg0, Vector arg1, String arg2, String arg3) {
        return super.SelectMulti(arg0.replace(";", ""), arg1, arg2, arg3);
    }

    protected String GetSQL_GetDefaultDEDataGrid(String strDataEntityId) {
        return StringHelper.Format((String)"select * from t_SRFDATAGrid where  ISMAJOR = 1 and  UPPER(DEID)='%1$s' and rownum=1;", (Object)strDataEntityId.toUpperCase());
    }

    protected String GetSQL_GetChart(String arg0) {
        return super.GetSQL_GetChart(arg0);
    }

    protected String GetSQL_GetDEWFDetail(String strDEId, String strWFMode) {
        return StringHelper.Format((String)"select * from T_SRFDEWFDETAIL where UPPER(DEID)='%1$s' AND (UPPER(WFMODE) ='%2$s') and rownum=1;", (Object)strDEId.toUpperCase(), (Object)strWFMode.toUpperCase());
    }

    protected String GetSQL_GetCodeList(String arg0) {
        return super.GetSQL_GetCodeList(arg0);
    }

    protected String GetSQL_GetDERType(String strDERTypeId) {
        return StringHelper.Format((String)"select * from T_SRFDERTYPE  where UPPER(DERTYPEID)='%1$s' and rownum=1;", (Object)strDERTypeId.toUpperCase());
    }

    protected String GetSQL_GetDataEntity(String arg0) {
        return super.GetSQL_GetDataEntity(arg0);
    }

    protected String GetSQL_GetDefaultDEMainForm(String arg0) {
        return StringHelper.Format((String)"select * from t_SRFFORM where UPPER(DEID)='%1$s' AND ISMAJOR=1 and rownum=1;", (Object)arg0.toUpperCase());
    }

    protected String GetSQL_GetDefaultPickupDEDataGrid(String arg0, String strDGMode) {
        return StringHelper.Format((String)"select * from (select * from t_SRFDATAGrid where (OWNERID IS NULL OR OWNERID='SYSTEM' OR OWNERID='') AND (ISMAJOR = 1 OR ISPICKUP = 1 ) and  UPPER(DEID)='%1$s' ORDER BY (CASE WHEN ISPICKUP IS NULL THEN 0 ELSE ISPICKUP END) DESC,ISMAJOR DESC ) temp where rownum=1;", (Object)arg0.toUpperCase());
    }

    protected String GetSQL_GetDEField(String arg0) {
        return super.GetSQL_GetDEField(arg0);
    }

    protected String GetSQL_GetDEFields(String arg0) {
        return super.GetSQL_GetDEFields(arg0);
    }

    protected String GetSQL_GetDER1Ns(String arg0) {
        return super.GetSQL_GetDER1Ns(arg0);
    }

    protected String GetSQL_GetDEWFForm(String arg0, String arg1) {
        return StringHelper.Format((String)"select * from (select * from t_SRFFORM where UPPER(DEID)='%1$s' AND (ISWFFORM IS NOT NULL AND ISWFFORM=1) AND (WFFORMNAME IS NOT NULL AND UPPER(WFFORMNAME)='%2$s') ) where rownum=1", (Object)arg0.toUpperCase(), (Object)arg1.toUpperCase());
    }

    protected String GetSQL_GetDEWFPrintForm(String arg0, String arg1) {
        return StringHelper.Format((String)"select * from (select * from t_SRFPRINTFORM where UPPER(DEID)='%1$s' AND (ISWFFORM IS NOT NULL AND ISWFFORM=1) AND (WFFORMNAME IS NOT NULL AND UPPER(WFFORMNAME)='%2$s')) where  rownum=1", (Object)arg0.toUpperCase(), (Object)arg1.toUpperCase());
    }

    protected String GetSQL_GetFunc(String arg0) {
        return StringHelper.Format((String)"select * from t_SRFFUNC  where UPPER(FUNC_ID)='%1$s' and rownum=1", (Object)arg0.toUpperCase());
    }

    protected String GetSQL_GetMainMenu(String arg0) {
        return StringHelper.Format((String)"select * from t_SRFMainMenu  where UPPER(USERMODE)='%1$s' and rownum=1", (Object)arg0.toUpperCase());
    }

    protected String GetSQL_GetUserDEDataGrids(String strOwner, String strDataEntityId) {
        return StringHelper.Format((String)"select * from t_SRFDataGrid where ISMAJOR=1 AND UPPER(DEID)='%1$s' AND (OWNERID IS NULL OR OWNERID = 'SYSTEM' OR OWNERID ='%2$s') order by ORDERVALUE ASC, DataGridName ASC;", (Object)strDataEntityId.toUpperCase(), (Object)strOwner);
    }

    protected String GetSQL_GetUserDEForm(String arg0, String arg1) {
        return StringHelper.Format((String)"select * from (select * from t_SRFFORM where UPPER(FORMID)='%1$s' AND (OWNERID IS NULL OR OWNERID = '' OR UPPER(OWNERID)='SYSTEM' OR UPPER(OWNERID)='%1$s')) temp where rownum=1", (Object)arg0.toUpperCase(), (Object)arg1.toUpperCase());
    }

    protected String GetSQL_GetUserPPModel(String strPPName, String strCurPersonId) {
        if (this.iDAGlobalHelper.getDAModelVersion() >= 12020100) {
            return StringHelper.Format((String)"select t1.*,t2.PORTALPAGEID,t2.PORTALPAGENAME,t2.ENABLECTX from T_SRFPPMODEL t1 INNER JOIN T_SRFPORTALPAGE t2 ON t1.PORTALPAGEID = t2.PORTALPAGEID where UPPER(t2.PORTALPAGENAME)='%1$s' AND (t1.OWNERID='SYSTEM' OR t1.OWNERID='%2$s') ORDER BY (CASE WHEN t1.OWNERID ='SYSTEM' THEN 0 ELSE  1 END) DESC ", (Object)strPPName.toUpperCase(), (Object)strCurPersonId);
        }
        return StringHelper.Format((String)"select t1.*,t2.PORTALPAGEID,t2.PORTALPAGENAME from T_SRFPPMODEL t1 INNER JOIN T_SRFPORTALPAGE t2 ON t1.PORTALPAGEID = t2.PORTALPAGEID where UPPER(t2.PORTALPAGENAME)='%1$s' AND (t1.OWNERID='SYSTEM' OR t1.OWNERID='%2$s') ORDER BY (CASE WHEN t1.OWNERID ='SYSTEM' THEN 0 ELSE  1 END) DESC ", (Object)strPPName.toUpperCase(), (Object)strCurPersonId);
    }

    protected String GetSQL_GetUserWFDataGrid(String strDEId, String strWFState, String strWFStep, String strCurPersonId) {
        if (StringHelper.IsNullOrEmpty((String)strWFStep)) {
            return StringHelper.Format((String)"select * from (select * from t_SRFDATAGrid where UPPER(DEID)='%1$s' AND (OWNERID IS NULL OR UPPER(OWNERID)='' OR    UPPER(OWNERID) ='%2$s') AND UPPER(WFSTATE) = '%3$s' AND (WFSTEP IS NULL OR WFSTEP = '') ) temp where rownum=1", (Object)strDEId.toUpperCase(), (Object)strCurPersonId.toUpperCase(), (Object)strWFState.toUpperCase());
        }
        return StringHelper.Format((String)"select * from (select * from t_SRFDATAGrid where UPPER(DEID)='%1$s' AND (OWNERID IS NULL OR UPPER(OWNERID)='' OR     UPPER(OWNERID) ='%2$s') AND UPPER(WFSTATE) = '%3$s' AND (WFSTEP IS NOT NULL AND UPPER(WFSTEP) = '%4$s')) temp where rownum=1", (Object)strDEId.toUpperCase(), (Object)strCurPersonId.toUpperCase(), (Object)strWFState.toUpperCase(), (Object)strWFStep.toUpperCase());
    }

    protected String GetSQL_GetDEPrintForm(String strDEId, String strFormName) {
        return StringHelper.Format((String)"select * from t_SRFPRINTFORM where UPPER(DEID)='%1$s'  AND (WFFORMNAME IS NOT NULL AND UPPER(WFFORMNAME)='%2$s') and rownum=1;", (Object)strDEId.toUpperCase(), (Object)strFormName.toUpperCase());
    }

    protected String GetSQL_GetSelectQueryModels(String strDEId) {
        return StringHelper.Format((String)"select * from T_SRFQUERYMODEL where  DEID='%1$s' AND (SELECTMODE IS NOT NULL)", (Object)strDEId);
    }
}

