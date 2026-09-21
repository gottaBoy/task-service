/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DBUtility;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.IDBModelHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Connection;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DER1NDataCtrl
extends BaseDEDataCtrl {
    private static final Log log = LogFactory.getLog(DER1NDataCtrl.class);
    public static final String TAG_CREATEVIEW = "CREATEVIEW";
    public static final String CUSTOMCALL_PHYSICALPICKUPTEXT = "PHYSICALPICKUPTEXT";
    protected IDBModelHelper iDBModelHelper = null;

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        if (bInsert) {
            String strMinorDEId = dataEntity.GetParamStringValue("MINORDEID", "");
            IDEHelper minorDEHelper = this.getGlobalHelper().getDAModelStorage().FindDEHelper(strMinorDEId);
            String strMajorDEId = dataEntity.GetParamStringValue("MAJORDEID", "");
            IDEHelper majorDEHelper = this.getGlobalHelper().getDAModelStorage().FindDEHelper(strMajorDEId);
            String strFieldName = dataEntity.GetParamStringValue("MAJORKEYDEFNAME", "");
            String strDefaultDERId = StringHelper.Format((String)"DER1N_%1$s_%2$s", (Object)minorDEHelper.getName(), (Object)strFieldName).toUpperCase();
            String strDefaultDERNAME = StringHelper.Format((String)"%1$s_%2$s_%3$s", (Object)minorDEHelper.getName(), (Object)majorDEHelper.getName(), (Object)strFieldName).toUpperCase();
            if (dataEntity.IsParamNull("DERID")) {
                dataEntity.SetParamValue("DERID", (Object)strDefaultDERId);
            }
            if (dataEntity.IsParamNull("DERNAME")) {
                dataEntity.SetParamValue("DERNAME", (Object)strDefaultDERNAME);
            }
        }
        return callResult;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected CallResult OnAfterSaveOK(boolean insert, String strActionType, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        DER1N der1n;
        CallResult callResult = super.OnAfterSaveOK(insert, strActionType, dataEntity, lastDataEntity);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        if (insert) {
            der1n = new DER1N();
            dataEntity.CopyTo((BaseDataEntity)der1n, true);
            DataEntity de = new DataEntity();
            CallResult result = this.globalHelperEx.getDAModelHelper().GetDataEntity(der1n.getMINORDEID(), de);
            if (result.getRetCode() != 0) {
                callResult.From(result);
                return callResult;
            }
            IDBModelHelper iDBModelHelper = DBUtility.GetDBModelHelper(de, this.globalHelperEx);
            callResult = iDBModelHelper.AddDER1N(der1n);
            if (callResult.getRetCode() != 0) {
                this.Remove(der1n);
                return callResult;
            }
        } else {
            String strLastRelatedTextDEFId;
            String strCurRelatedTextDEFId = dataEntity.GetParamStringValue("RELATEDTEXTDEFID", "");
            if (StringHelper.Compare((String)strCurRelatedTextDEFId, (String)(strLastRelatedTextDEFId = lastDataEntity.GetParamStringValue("RELATEDTEXTDEFID", "")), (boolean)false) != 0) {
                DER1N der1N = new DER1N();
                der1N.Proxy(dataEntity);
                callResult = this.RefreshPickupTextField(der1N);
                if (callResult.IsError()) {
                    return callResult;
                }
            }
            boolean bCurPhysicalMode = dataEntity.GetParamIntValue("PHYSICALMODE", 0) == 1;
            boolean bLastPhysicalMode = lastDataEntity.GetParamIntValue("PHYSICALMODE", 0) == 1;
            if (bCurPhysicalMode == bLastPhysicalMode) return callResult;
            if (!bCurPhysicalMode) return callResult;
            return this.PhysicalPickupText2(dataEntity);
        }
        der1n.CopyTo(dataEntity, true);
        return callResult;
    }

    @Override
    protected Connection getConnection(String strAction, String strActionMode) {
        return null;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_PHYSICALPICKUPTEXT, (boolean)false) == 0) {
            return this.PhysicalPickupText(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    protected CallResult RefreshPickupTextField(DER1N der1N) {
        CallResult callresult = new CallResult();
        try {
            String strCurDEFieldId = der1N.getRELATEDTEXTDEFID();
            if (StringHelper.IsNullOrEmpty((String)strCurDEFieldId)) {
                IDEHelper majorDEHelper = this.getGlobalHelper().getDAModelStorage().FindDEHelper(der1N.getMAJORDEID());
                strCurDEFieldId = majorDEHelper.GetMajorDEFHelper().getId();
            }
            DEField pickupTextField = new DEField();
            pickupTextField.setDERID(der1N.getDERID());
            pickupTextField.setDEID(der1N.getMINORDEID());
            pickupTextField.setDATATYPE("PICKUPTEXT");
            IDEDataCtrl minorDEDataCtrl = this.GetRelatedDataCtrl("DE0002");
            Vector<BaseDataEntity> fields = new Vector<BaseDataEntity>();
            CallResult callResult = minorDEDataCtrl.Select(pickupTextField, fields);
            if (callResult.getRetCode() != 0) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5173\u7cfb[%1$s]\u6587\u672c\u5b57\u6bb5\u5931\u8d25\uff0c%2$s", (Object)der1N.getDERID()));
            }
            for (BaseDataEntity field : fields) {
                String strRDEFId = field.GetParamStringValue("DATATYPEPARAM", "");
                if (StringHelper.Compare((String)strRDEFId, (String)strCurDEFieldId, (boolean)true) == 0) continue;
                field.SetParamValue("DATATYPEPARAM", (Object)strCurDEFieldId);
                callResult = minorDEDataCtrl.Save(false, field);
                if (callResult.getRetCode() == 0) continue;
                log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u5c5e\u6027[%1$s]\u5173\u7cfb\u5c5e\u6027\u5931\u8d25\uff0c%2$s", (Object)field.GetParamStringValue("DEFID", "")));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            callresult.setRetCode(1);
            callresult.setErrorInfo(StringHelper.Format((String)"\u5237\u65b0\u5916\u952e\u6587\u672c\u5c5e\u6027\u51fa\u9519\uff0c%1$s", (Object)e.getMessage()));
            log.error((Object)e.getMessage());
        }
        return callresult;
    }

    protected CallResult PhysicalPickupText(BaseDataEntity dataEntity) {
        CallResult callresult = new CallResult();
        try {
            DER1N der1n = new DER1N();
            dataEntity.CopyTo((BaseDataEntity)der1n, true);
            callresult = this.Get(der1n);
            if (callresult.getRetCode() != 0) {
                return callresult;
            }
            Vector<BaseDataEntity> relatedDEFieldList = new Vector<BaseDataEntity>();
            IDEDataCtrl deFieldDataCtrl = this.GetRelatedDataCtrl("DE0002");
            BaseDataEntity cond = new BaseDataEntity();
            cond.SetParamValue("DATATYPEPARAM4", (Object)der1n.getDERID());
            cond.SetParamValue("DATATYPE", (Object)"PICKUP");
            callresult = deFieldDataCtrl.Select(cond, relatedDEFieldList);
            if (callresult.getRetCode() != 0) {
                return callresult;
            }
            cond.SetParamValue("DATATYPE", (Object)"PICKUPTEXT");
            callresult = deFieldDataCtrl.Select(cond, relatedDEFieldList);
            if (callresult.getRetCode() != 0) {
                return callresult;
            }
            cond.SetParamValue("DATATYPE", (Object)"PICKUPDATA");
            callresult = deFieldDataCtrl.Select(cond, relatedDEFieldList);
            if (callresult.getRetCode() != 0) {
                return callresult;
            }
            cond.SetParamValue("DATATYPE", (Object)"INHERIT");
            callresult = deFieldDataCtrl.Select(cond, relatedDEFieldList);
            if (callresult.getRetCode() != 0) {
                return callresult;
            }
            callresult = this.Remove(dataEntity);
            if (callresult.getRetCode() != 0) {
                return callresult;
            }
            der1n.setPHYSICALMODE(true);
            der1n.setPHYSICALUPDATEMODE("UPDATEWHENMODIFY");
            callresult = this.Save(true, der1n);
            if (callresult.getRetCode() != 0) {
                return callresult;
            }
            for (BaseDataEntity pickupDataField : relatedDEFieldList) {
                String strDataType = pickupDataField.GetParamStringValue("DATATYPE", "");
                if (StringHelper.Compare((String)strDataType, (String)"PICKUP", (boolean)true) == 0 || StringHelper.Compare((String)strDataType, (String)"PICKUPTEXT", (boolean)true) == 0) {
                    pickupDataField.RemoveParam("DATATYPEPARAM");
                    pickupDataField.RemoveParam("DEFTYPE");
                    callresult = deFieldDataCtrl.Save(false, pickupDataField);
                } else {
                    callresult = deFieldDataCtrl.Save(true, pickupDataField);
                }
                if (callresult.getRetCode() == 0) continue;
                return callresult;
            }
            IDEHelper idehelperDE = this.globalHelperEx.getDAModelStorage().FindDEHelper(der1n.getMAJORDEID(), false);
            IDEHelper idehelperMAJORDE = this.globalHelperEx.getDAModelStorage().FindDEHelper(der1n.getMINORDEID(), false);
            String strMajorColumn = idehelperDE.GetMajorDEFHelper().getName();
            if (!StringHelper.IsNullOrEmpty((String)der1n.getRELATEDTEXTDEFID())) {
                IDEFHelper realTextDEField = idehelperDE.GetDEFHelper(der1n.getRELATEDTEXTDEFID());
                strMajorColumn = realTextDEField.GetDTColumn().GetColumnName();
            }
            String strSQL = "UPDATE %1$s SET %2$s = (SELECT %3$s FROM %4$s A WHERE A.%5$s = %1$s.%6$s)";
            strSQL = StringHelper.Format((String)strSQL, (Object)idehelperMAJORDE.GetMainTable(), (Object)der1n.getMAJORTEXTDEFNAME(), (Object)strMajorColumn, (Object)idehelperDE.GetDEViewName(), (Object)idehelperDE.GetKeyDEFHelper().getName(), (Object)der1n.getMAJORKEYDEFNAME());
            this.globalHelperEx.getDBCaller().CallRaw2(strSQL);
        }
        catch (Exception e) {
            e.printStackTrace();
            callresult.setRetCode(1);
            callresult.setErrorInfo(StringHelper.Format((String)"\u5237\u65b0\u7269\u7406\u5316\u5b57\u6bb5\u6570\u636e\u51fa\u9519\uff0c%1$s", (Object)e.getMessage()));
            log.error((Object)e.getMessage());
        }
        return callresult;
    }

    protected CallResult PhysicalPickupText2(BaseDataEntity dataEntity) {
        CallResult callresult = new CallResult();
        DER1N der1n = new DER1N();
        try {
            dataEntity.CopyTo((BaseDataEntity)der1n, true);
            Vector<BaseDataEntity> relatedDEFieldList = new Vector<BaseDataEntity>();
            IDEDataCtrl deFieldDataCtrl = this.GetRelatedDataCtrl("DE0002");
            BaseDataEntity cond = new BaseDataEntity();
            cond.SetParamValue("DATATYPEPARAM4", (Object)der1n.getDERID());
            cond.SetParamValue("DATATYPE", (Object)"PICKUP");
            callresult = deFieldDataCtrl.Select(cond, relatedDEFieldList);
            if (callresult.getRetCode() != 0) {
                return callresult;
            }
            cond.SetParamValue("DATATYPE", (Object)"PICKUPTEXT");
            callresult = deFieldDataCtrl.Select(cond, relatedDEFieldList);
            if (callresult.getRetCode() != 0) {
                return callresult;
            }
            cond.SetParamValue("DATATYPE", (Object)"PICKUPDATA");
            callresult = deFieldDataCtrl.Select(cond, relatedDEFieldList);
            if (callresult.getRetCode() != 0) {
                return callresult;
            }
            cond.SetParamValue("DATATYPE", (Object)"INHERIT");
            callresult = deFieldDataCtrl.Select(cond, relatedDEFieldList);
            if (callresult.getRetCode() != 0) {
                return callresult;
            }
            callresult = this.Remove(dataEntity);
            if (callresult.getRetCode() != 0) {
                return callresult;
            }
            callresult = this.Save(true, der1n);
            if (callresult.getRetCode() != 0) {
                return callresult;
            }
            for (BaseDataEntity pickupDataField : relatedDEFieldList) {
                String strDataType = pickupDataField.GetParamStringValue("DATATYPE", "");
                if (StringHelper.Compare((String)strDataType, (String)"PICKUP", (boolean)true) == 0 || StringHelper.Compare((String)strDataType, (String)"PICKUPTEXT", (boolean)true) == 0) {
                    pickupDataField.RemoveParam("DATATYPEPARAM");
                    pickupDataField.RemoveParam("DEFTYPE");
                    callresult = deFieldDataCtrl.Save(false, pickupDataField);
                } else {
                    callresult = deFieldDataCtrl.Save(true, pickupDataField);
                }
                if (callresult.getRetCode() == 0) continue;
                return callresult;
            }
            IDEHelper idehelperDE = this.globalHelperEx.getDAModelStorage().FindDEHelper(der1n.getMAJORDEID(), false);
            IDEHelper idehelperMAJORDE = this.globalHelperEx.getDAModelStorage().FindDEHelper(der1n.getMINORDEID(), false);
            String strSQL = "UPDATE %1$s SET %2$s = (SELECT %3$s FROM %4$s A WHERE A.%5$s = %1$s.%6$s)";
            String strMajorColumn = idehelperDE.GetMajorDEFHelper().getName();
            if (!StringHelper.IsNullOrEmpty((String)der1n.getRELATEDTEXTDEFID())) {
                IDEFHelper realTextDEField = idehelperDE.GetDEFHelper(der1n.getRELATEDTEXTDEFID());
                strMajorColumn = realTextDEField.GetDTColumn().GetColumnName();
            }
            strSQL = StringHelper.Format((String)strSQL, (Object)idehelperMAJORDE.GetMainTable(), (Object)der1n.getMAJORTEXTDEFNAME(), (Object)strMajorColumn, (Object)idehelperDE.GetDEViewName(), (Object)idehelperDE.GetKeyDEFHelper().getName(), (Object)der1n.getMAJORKEYDEFNAME());
            this.globalHelperEx.getDBCaller().CallRaw2(strSQL);
        }
        catch (Exception e) {
            e.printStackTrace();
            callresult.setRetCode(1);
            callresult.setErrorInfo(StringHelper.Format((String)"\u5237\u65b0\u7269\u7406\u5316\u5b57\u6bb5\u6570\u636e\u51fa\u9519\uff0c%1$s", (Object)e.getMessage()));
            log.error((Object)e.getMessage());
        }
        der1n.CopyTo(dataEntity, true);
        return callresult;
    }

    @Override
    protected boolean OnTestImport(boolean bInsert, BaseDataEntity baseDataEntity) {
        if (bInsert) {
            return true;
        }
        return DER1NDataCtrl.TestImport(this, baseDataEntity, BaseDEDataCtrl.ignoreChangeFieldMap);
    }
}

