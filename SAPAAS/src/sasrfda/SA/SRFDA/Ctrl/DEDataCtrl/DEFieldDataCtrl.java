/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.SASRFDataException
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.ValueError
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DBUtility;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.Data.DER11;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.IDBModelHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.Data.SASRFDataException;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ValueError;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.sql.Connection;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEFieldDataCtrl
extends BaseDEDataCtrl {
    private static final Log log = LogFactory.getLog(DEFieldDataCtrl.class);
    public static final String CUSTOMCALL_SYNCINHERITDEFIELD = "SYNCINHERITDEFIELD";
    public static final String ACTIONMODE_UPDATETABLENAME = "UPDATETABLENAME";

    @Override
    protected CallResult OnTestSave(boolean insert, String strActionType, BaseDataEntity dataEntity, Vector<ValueError> errors) {
        CallResult callResult = super.OnTestSave(insert, strActionType, dataEntity, errors);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        if (insert) {
            DEField deField = new DEField();
            dataEntity.CopyTo((BaseDataEntity)deField, true);
            IDEHelper iDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(deField.getDEID());
            if (iDEHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)deField.getDEID()));
                return callResult;
            }
            IDEFHelper iDEFHelper = iDEHelper.CreateDEFHelper(deField);
            if (iDEFHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027\u8f85\u52a9\u5bf9\u8c61"));
                return callResult;
            }
            callResult = iDEFHelper.PrepareCreateDEField(errors);
            if (callResult.getRetCode() != 0) {
                return callResult;
            }
            deField.CopyTo(dataEntity, true);
        }
        callResult.setRetCode(0);
        return callResult;
    }

    @Override
    protected CallResult OnAfterSaveOK(boolean insert, String strActionType, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(insert, strActionType, dataEntity, lastDataEntity);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        DEField deField = new DEField();
        dataEntity.CopyTo((BaseDataEntity)deField, true);
        if (insert) {
            DataEntity de = new DataEntity();
            CallResult result = this.globalHelperEx.getDAModelHelper().GetDataEntity(deField.getDEID(), de);
            if (result.getRetCode() != 0) {
                callResult.From(result);
                return callResult;
            }
            IDBModelHelper iDBModelHelper = DBUtility.GetDBModelHelper(de, this.globalHelperEx);
            callResult = iDBModelHelper.AddColumn(deField);
            if (callResult.getRetCode() != 0) {
                this.Remove(dataEntity);
                return callResult;
            }
            deField.CopyTo(dataEntity, true);
            if (deField.getDEFTYPE() == 2 && deField.getFORMULAPHY()) {
                boolean bCurFormalPhy;
                boolean bl = bCurFormalPhy = dataEntity.GetParamIntValue("FORMULAPHY", 0) == 1;
                if (bCurFormalPhy) {
                    callResult = this.PhysicalFormalField(dataEntity);
                }
            }
        } else if (StringHelper.Compare((String)strActionType, (String)ACTIONMODE_UPDATETABLENAME, (boolean)false) != 0 && deField.getDEFTYPE() == 2 && deField.getFORMULAPHY()) {
            boolean bCurFormalPhy;
            boolean bLastFormalPhy = lastDataEntity.GetParamIntValue("FORMULAPHY", 0) == 1;
            boolean bl = bCurFormalPhy = dataEntity.GetParamIntValue("FORMULAPHY", 0) == 1;
            if (bCurFormalPhy != bLastFormalPhy) {
                callResult = this.PhysicalFormalField(dataEntity);
            }
        }
        if (deField.isMAJOR()) {
            Vector<DER1N> der1nlist = new Vector<DER1N>();
            callResult = this.globalHelperEx.getDAModelHelper().GetDER1Ns(deField.getDEID(), der1nlist);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53[%1$s]\u6240\u6709 1:N \u5173\u7cfb\u5931\u8d25\uff0c%2$s", (Object)deField.getDEID(), (Object)callResult.getErrorInfo()));
            } else {
                for (DER1N der1N : der1nlist) {
                    if (!StringHelper.IsNullOrEmpty((String)der1N.getRELATEDTEXTDEFID())) continue;
                    DEField pickupTextField = new DEField();
                    pickupTextField.setDERID(der1N.getDERID());
                    pickupTextField.setDEID(der1N.getMINORDEID());
                    pickupTextField.setDATATYPE("PICKUPTEXT");
                    IDEHelper defDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper("DE0002");
                    if (defDEHelper == null) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[\u5b9e\u4f53\u5c5e\u6027]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25"));
                        continue;
                    }
                    IDEDataCtrl minorDEDataCtrl = defDEHelper.GetDEDataCtrl(this.strCurOpPersonId, this.getWebContext());
                    if (minorDEDataCtrl == null) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[\u5b9e\u4f53\u5c5e\u6027]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61\u5931\u8d25", (Object)defDEHelper.GetFullName()));
                        continue;
                    }
                    Vector<BaseDataEntity> fields = new Vector<BaseDataEntity>();
                    callResult = minorDEDataCtrl.Select(pickupTextField, fields);
                    if (callResult.getRetCode() != 0) {
                        log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5173\u7cfb[%1$s]\u6587\u672c\u5b57\u6bb5\u5931\u8d25\uff0c%2$s", (Object)der1N.getDERID()));
                        continue;
                    }
                    for (BaseDataEntity field : fields) {
                        String strRDEFId = field.GetParamStringValue("DATATYPEPARAM", "");
                        if (StringHelper.Compare((String)strRDEFId, (String)deField.getDEFID(), (boolean)true) == 0) continue;
                        field.SetParamValue("DATATYPEPARAM", (Object)deField.getDEFID());
                        callResult = minorDEDataCtrl.Save(false, field);
                        if (callResult.getRetCode() == 0) continue;
                        log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u5c5e\u6027[%1$s]\u5173\u7cfb\u5c5e\u6027\u5931\u8d25\uff0c%2$s", (Object)field.GetParamStringValue("DEFID", "")));
                    }
                }
            }
            Vector<DER11> der11list = new Vector<DER11>();
            callResult = this.globalHelperEx.getDAModelHelper().GetDER11s(true, deField.getDEID(), der11list);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53[%1$s]\u6240\u6709 1:1 \u5173\u7cfb\u5931\u8d25\uff0c%2$s", (Object)deField.getDEID(), (Object)callResult.getErrorInfo()));
            } else {
                for (DER11 der11 : der11list) {
                    DEField pickupTextField = new DEField();
                    pickupTextField.setDERID(der11.getDERID());
                    pickupTextField.setDEID(der11.getMINORDEID());
                    pickupTextField.setDATATYPE("PICKUPTEXT");
                    IDEHelper defDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper("DE0002");
                    if (defDEHelper == null) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[\u5b9e\u4f53\u5c5e\u6027]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25"));
                        continue;
                    }
                    IDEDataCtrl minorDEDataCtrl = defDEHelper.GetDEDataCtrl(this.strCurOpPersonId, this.getWebContext());
                    if (minorDEDataCtrl == null) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61\u5931\u8d25", (Object)defDEHelper.GetFullName()));
                        continue;
                    }
                    Vector<BaseDataEntity> fields = new Vector<BaseDataEntity>();
                    callResult = minorDEDataCtrl.Select(pickupTextField, fields);
                    if (callResult.getRetCode() != 0) {
                        log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5173\u7cfb[%1$s]\u6587\u672c\u5b57\u6bb5\u5931\u8d25\uff0c%2$s", (Object)der11.getDERID()));
                        continue;
                    }
                    for (BaseDataEntity field : fields) {
                        String strRDEFId = field.GetParamStringValue("DATATYPEPARAM", "");
                        if (StringHelper.Compare((String)strRDEFId, (String)deField.getDEFID(), (boolean)true) == 0) continue;
                        field.SetParamValue("DATATYPEPARAM", (Object)deField.getDEFID());
                        callResult = minorDEDataCtrl.Save(false, field);
                        if (callResult.getRetCode() == 0) continue;
                        log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u5c5e\u6027[%1$s]\u5173\u7cfb\u5c5e\u6027\u5931\u8d25\uff0c%2$s", (Object)field.GetParamStringValue("DEFID", "")));
                    }
                }
            }
        }
        if (!this.bImportMode) {
            int nDEFType = dataEntity.GetParamIntValue("DEFTYPE", -1);
            String strDataType = dataEntity.GetParamStringValue("DATATYPE", "");
            if (nDEFType == 2 || nDEFType == 3 && !insert || StringHelper.Compare((String)strDataType, (String)"PICKUPDATA", (boolean)true) == 0) {
                DataEntity de = new DataEntity();
                CallResult result = this.globalHelperEx.getDAModelHelper().GetDataEntity(dataEntity.GetParamStringValue("DEID", ""), de);
                if (result.getRetCode() != 0) {
                    callResult.From(result);
                    return callResult;
                }
                IDBModelHelper iDBModelHelper = DBUtility.GetDBModelHelper(de, this.globalHelperEx);
                callResult = iDBModelHelper.CreateView();
            }
        }
        return callResult;
    }

    protected CallResult PhysicalFormalField(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        DEField deField = new DEField();
        dataEntity.CopyTo((BaseDataEntity)deField, true);
        IDEHelper iDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(deField.getDEID());
        String strViewName = iDEHelper.GetDEViewName();
        String strKeyFieldName = iDEHelper.GetKeyDEFHelper().getName();
        DataEntity de = new DataEntity();
        CallResult result = this.globalHelperEx.getDAModelHelper().GetDataEntity(deField.getDEID(), de);
        if (result.getRetCode() != 0) {
            callResult.From(result);
            return callResult;
        }
        IDBModelHelper iDBModelHelper = DBUtility.GetDBModelHelper(de, this.globalHelperEx);
        callResult = iDBModelHelper.AddColumn(deField);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        deField.CopyTo(dataEntity, true);
        String strSQL = "UPDATE %1$s SET %2$s = (SELECT A.%3$s FROM %4$s A WHERE A.%5$s = %1$s.%5$s)";
        strSQL = StringHelper.Format((String)strSQL, (Object)deField.getTABLENAME(), (Object)deField.getDEFNAME(), (Object)deField.getDEFNAME(), (Object)strViewName, (Object)strKeyFieldName);
        try {
            this.globalHelperEx.getDBCaller().CallRaw2(strSQL);
        }
        catch (SASRFDataException e) {
            e.printStackTrace();
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5237\u65b0\u7269\u7406\u5316\u5b57\u6bb5\u6570\u636e\u51fa\u9519\uff0c%1$s", (Object)e.getMessage()));
            log.error((Object)e.getMessage());
        }
        return callResult;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_SYNCINHERITDEFIELD, (boolean)true) == 0) {
            return this.SyncInheritDEField(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    protected CallResult SyncInheritDEField(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        String strDEId = dataEntity.GetParamStringValue("DEID", "");
        if (StringHelper.IsNullOrEmpty((String)strDEId)) {
            callResult.setRetCode(3);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u6709\u6548\u5b9e\u4f53");
            return callResult;
        }
        IDEHelper iCurDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strDEId, false);
        if (iCurDEHelper == null) {
            callResult.setRetCode(3);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId));
            return callResult;
        }
        if (!iCurDEHelper.IsInheritMode()) {
            callResult.setRetCode(3);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u662f\u7ee7\u627f\u5b9e\u4f53", (Object)strDEId));
            return callResult;
        }
        IDEHelper parentDEHelper = iCurDEHelper.GetInheritDEHelper();
        if (parentDEHelper == null) {
            callResult.setRetCode(3);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u7236\u5bf9\u8c61\u65e0\u6548", (Object)strDEId));
            return callResult;
        }
        Vector<IDEFHelper> defHelpers = parentDEHelper.GetDEFHelpers();
        for (IDEFHelper iDEFHelper : defHelpers) {
            if (iDEFHelper.IsIgnoreInherit() || !iCurDEHelper.IsInheritDEField(iDEFHelper)) continue;
            DEField defield = new DEField();
            iDEFHelper.getDEField().CopyTo(defield, true);
            defield.RemoveParam("FORMULAFIELD");
            defield.RemoveParam("FORMULAFORMAT");
            defield.RemoveParam("DEFID");
            defield.setDEFNAME(iDEFHelper.getName());
            defield.setRELATEDDEFIELD(iDEFHelper.getId());
            defield.setDEID(strDEId);
            defield.setDEFLOGICNAME(iDEFHelper.getLogicName(""));
            defield.setDEFTYPE(3);
            defield.setISNULLABLE(iDEFHelper.getDEField().isNULLABLE());
            defield.setDATATYPE("INHERIT");
            defield.setISMAJOR(false);
            defield.setISPKEY(false);
            defield.setISFKEY(false);
            defield.setISSEARCHABLE(true);
            defield.setISENABLECREATE(true);
            defield.setISENABLEMODIFY(true);
            defield.setISSYSTEM(false);
            callResult = this.Save(true, defield);
            if (callResult.IsOk()) continue;
            if (callResult.getRetCode() == 6 || callResult.getRetCode() == 1006) {
                callResult.Reset();
                continue;
            }
            if (callResult.getRetCode() == 7 || callResult.getRetCode() == 1007) {
                callResult.Reset();
                continue;
            }
            return callResult;
        }
        return callResult;
    }

    @Override
    protected Connection getConnection(String strAction, String strActionMode) {
        return null;
    }

    @Override
    protected CallResult OnExport(BaseDataEntity baseDataEntity, Vector<XMLNode> list, boolean bFrameOnly) {
        if (bFrameOnly) {
            baseDataEntity.RemoveParam("DEFUSERPARAM");
        }
        return super.OnExport(baseDataEntity, list, bFrameOnly);
    }

    @Override
    protected boolean OnTestImport(boolean bInsert, BaseDataEntity baseDataEntity) {
        if (bInsert) {
            return true;
        }
        return DEFieldDataCtrl.TestImport(this, baseDataEntity, BaseDEDataCtrl.ignoreChangeFieldMap);
    }
}

