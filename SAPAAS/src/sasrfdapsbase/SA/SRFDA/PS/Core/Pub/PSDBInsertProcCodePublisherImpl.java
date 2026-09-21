/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.PSDBSysProcCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSDBInsertProcCodePublisherImpl
extends PSDBSysProcCodePublisherImpl {
    public static final String CODETEMPL_INSERTTABLE = "INSERTTABLE";

    @Override
    protected void onGenerateCode() throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();
        ArrayList<IPSGenerateCodeResult> inserttablecodes = new ArrayList<IPSGenerateCodeResult>();
        IPSDataEntity curPSDataEntity = this.getPSDataEntity();
        IPSDataEntity lastPSDataEntity = null;
        while (curPSDataEntity != null) {
            HashMap<String, Object> params2 = new HashMap<String, Object>();
            if (lastPSDataEntity != null && lastPSDataEntity.getPSDERInherit() != null) {
                params2.put("inherittype", lastPSDataEntity.getPSDERInherit().getTypeValue());
            }
            IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(CODETEMPL_INSERTTABLE, curPSDataEntity, params2);
            inserttablecodes.add(0, iPSGenerateCodeResult);
            lastPSDataEntity = curPSDataEntity;
            curPSDataEntity = lastPSDataEntity.getInheritPSDataEntity();
        }
        params.put("inserttables", inserttablecodes);
        this.savePSDESysProcCode((Object)this.psDESysProc, null, params);
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
        if (StringHelper.Compare((String)strType, (String)CODETEMPL_INSERTTABLE, (boolean)true) == 0) {
            IPSDataEntity iPSDataEntity = (IPSDataEntity)obj;
            HashMap<String, String> fields = new HashMap<String, String>();
            this.fillTableInsertFields(fields, iPSDataEntity);
            if (iPSDataEntity != this.getPSDataEntity()) {
                String strParamName = (String)this.defieldParamMap.get(this.getPSDataEntity().getKeyPSDEField().getName().toUpperCase());
                fields.put(iPSDataEntity.getKeyPSDEField().getPSDTColumn(this.getDBType()).getColumnName().toUpperCase(), strParamName);
                String strInherittype = (String)params.get("inherittype");
                fields.put(iPSDataEntity.getIndexTypePSDEField().getPSDTColumn(this.getDBType()).getColumnName().toUpperCase(), "'" + strInherittype + "'");
            }
            if (fields.size() == 0) {
                return;
            }
            ArrayList<PSGenerateCodeResultImpl> fieldList = new ArrayList<PSGenerateCodeResultImpl>();
            for (String strField : fields.keySet()) {
                String strValue = fields.get(strField);
                PSGenerateCodeResultImpl psGenerateCodeResultImpl = new PSGenerateCodeResultImpl();
                psGenerateCodeResultImpl.setCode(strField);
                psGenerateCodeResultImpl.setCode2(strValue);
                fieldList.add(psGenerateCodeResultImpl);
            }
            params.put("curde", iPSDataEntity);
            params.put("curkeycol", iPSDataEntity.getKeyPSDEField().getPSDTColumn(this.getDBType()));
            params.put("tablename", iPSDataEntity.getTableName());
            params.put("insertfields", fieldList);
        }
    }

    protected void fillTableInsertFields(HashMap<String, String> fields, IPSDataEntity iPSDataEntity) throws Exception {
        String strTableName = iPSDataEntity.getTableName();
        Iterator<IPSDEField> it = iPSDataEntity.getPSDEFields();
        while (it.hasNext()) {
            IPSDEField iPSDEField = it.next();
            if (!this.defieldParamMap.containsKey(iPSDEField.getName().toUpperCase())) continue;
            this.fillTableInsertField(fields, iPSDataEntity, strTableName, iPSDEField);
        }
        IPSDEField iPSDEField = iPSDataEntity.getPSDEFieldByPDT("CREATEMAN", true);
        if (iPSDEField != null) {
            fields.put(iPSDEField.getPSDTColumn(this.getDBType()).getColumnName(), "SRF_PERSONID");
        }
        if ((iPSDEField = iPSDataEntity.getPSDEFieldByPDT("CREATEMANNAME", true)) != null) {
            fields.put(iPSDEField.getPSDTColumn(this.getDBType()).getColumnName(), "SRF_PERSONNAME");
        }
        if ((iPSDEField = iPSDataEntity.getPSDEFieldByPDT("CREATEDATE", true)) != null) {
            fields.put(iPSDEField.getPSDTColumn(this.getDBType()).getColumnName(), "SRF_CURTIME");
        }
        if ((iPSDEField = iPSDataEntity.getPSDEFieldByPDT("UPDATEMAN", true)) != null) {
            fields.put(iPSDEField.getPSDTColumn(this.getDBType()).getColumnName(), "SRF_PERSONID");
        }
        if ((iPSDEField = iPSDataEntity.getPSDEFieldByPDT("UPDATEMANNAME", true)) != null) {
            fields.put(iPSDEField.getPSDTColumn(this.getDBType()).getColumnName(), "SRF_PERSONNAME");
        }
        if ((iPSDEField = iPSDataEntity.getPSDEFieldByPDT("UPDATEDATE", true)) != null) {
            fields.put(iPSDEField.getPSDTColumn(this.getDBType()).getColumnName(), "SRF_CURTIME");
        }
        if ((iPSDEField = iPSDataEntity.getPSDEFieldByPDT("ORGID", true)) != null && StringHelper.Compare((String)strTableName, (String)iPSDEField.getPSDTColumn(this.getDBType()).getTableScope(), (boolean)true) == 0) {
            fields.put(iPSDEField.getPSDTColumn(this.getDBType()).getColumnName(), "SRF_ORGUNITID");
        }
    }

    protected void fillTableInsertField(HashMap<String, String> fields, IPSDataEntity iPSDataEntity, String strTableName, IPSDEField iPSDEField) throws Exception {
        String strParamName = (String)this.defieldParamMap.get(iPSDEField.getName().toUpperCase());
        if (StringHelper.IsNullOrEmpty((String)strParamName)) {
            return;
        }
        IPSDEFDTColumn iPSDEFDTColumn = iPSDEField.getPSDTColumn(this.getDBType());
        fields.put(iPSDEField.getPSDTColumn(this.getDBType()).getColumnName().toUpperCase(), strParamName);
    }
}

