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

public class PSDBUpdateProcCodePublisherImpl
extends PSDBSysProcCodePublisherImpl {
    public static final String CODETEMPL_UPDATETABLE = "UPDATETABLE";

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
            IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(CODETEMPL_UPDATETABLE, curPSDataEntity, params2);
            inserttablecodes.add(0, iPSGenerateCodeResult);
            lastPSDataEntity = curPSDataEntity;
            curPSDataEntity = lastPSDataEntity.getInheritPSDataEntity();
        }
        params.put("updatetables", inserttablecodes);
        this.savePSDESysProcCode((Object)this.psDESysProc, null, params);
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
        if (StringHelper.Compare((String)strType, (String)CODETEMPL_UPDATETABLE, (boolean)true) == 0) {
            IPSDataEntity iPSDataEntity = (IPSDataEntity)obj;
            HashMap<String, String> fields = new HashMap<String, String>();
            this.fillTableUpdateFields(fields, iPSDataEntity);
            if (iPSDataEntity == this.getPSDataEntity()) {
                fields.remove(this.getPSDataEntity().getKeyPSDEField().getPSDTColumn(this.getDBType()).getColumnName().toUpperCase());
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
            params.put("updatefields", fieldList);
        }
    }

    protected void fillTableUpdateFields(HashMap<String, String> fields, IPSDataEntity iPSDataEntity) throws Exception {
        String strTableName = iPSDataEntity.getTableName();
        Iterator<IPSDEField> it = iPSDataEntity.getPSDEFields();
        while (it.hasNext()) {
            IPSDEFDTColumn iPSDEFDTColumn;
            IPSDEField iPSDEField = it.next();
            if (!this.defieldParamMap.containsKey(iPSDEField.getName().toUpperCase()) || StringHelper.Compare((String)(iPSDEFDTColumn = iPSDEField.getPSDTColumn(this.getDBType())).getTableScope(), (String)strTableName, (boolean)true) != 0) continue;
            this.fillTableUpdateField(fields, iPSDataEntity, strTableName, iPSDEField);
        }
        IPSDEField iPSDEField = null;
        iPSDEField = iPSDataEntity.getPSDEFieldByPDT("UPDATEMAN", true);
        if (iPSDEField != null) {
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

    protected void fillTableUpdateField(HashMap<String, String> fields, IPSDataEntity iPSDataEntity, String strTableName, IPSDEField iPSDEField) throws Exception {
        String strParamName = (String)this.defieldParamMap.get(iPSDEField.getName().toUpperCase());
        if (StringHelper.IsNullOrEmpty((String)strParamName)) {
            return;
        }
        IPSDEFDTColumn iPSDEFDTColumn = iPSDEField.getPSDTColumn(this.getDBType());
        if (this.defieldParamMap2.containsKey(iPSDEField.getName().toUpperCase())) {
            strParamName = StringHelper.Format((String)"CASE VF_%1$s WHEN 1 THEN %2$s  ELSE %3$s END", (Object)iPSDEField.getName().toUpperCase(), (Object)strParamName, (Object)iPSDEFDTColumn.getColumnName());
        }
        fields.put(iPSDEField.getPSDTColumn(this.getDBType()).getColumnName().toUpperCase(), strParamName);
    }
}

