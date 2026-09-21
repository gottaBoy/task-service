/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DEAppCustom;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Enumeration;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEAppCustomDataCtrl
extends BaseDEDataCtrl {
    private static final Log log = LogFactory.getLog(DEAppCustomDataCtrl.class);
    public static final String CUSTOMCALL_PATCH = "PATCH";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_PATCH, (boolean)false) == 0) {
            return this.Patch(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult Patch(BaseDataEntity dataEntity) {
        DEAppCustom deAppCustom = new DEAppCustom();
        dataEntity.CopyTo((BaseDataEntity)deAppCustom, false);
        try {
            CallResult callResult = this.Get(deAppCustom);
            if (callResult.IsError()) {
                return callResult;
            }
            if (!deAppCustom.getVALIDFLAG()) {
                throw new Exception(StringHelper.Format((String)"\u5e94\u7528\u81ea\u5b9a\u4e49\u6ca1\u6709\u542f\u7528"));
            }
            IDEDataCtrl deDataCtrl = this.GetRelatedDataCtrl(deAppCustom.getDEID());
            IDEHelper iDEHelper = deDataCtrl.GetDEHelper();
            if (StringHelper.Compare((String)deAppCustom.getCUSTOMACTION(), (String)"REMOVE", (boolean)true) == 0) {
                Object objKeyValue = iDEHelper.GetKeyDEFHelper().GetDEFValue(deAppCustom.getDATAID());
                BaseDataEntity dstDataEntity = deDataCtrl.GetDEHelper().CreateDEObject();
                dstDataEntity.SetParamValue(iDEHelper.GetKeyDEFHelper().GetDTColumn().GetColumnName(), objKeyValue);
                callResult = deDataCtrl.Remove(dstDataEntity);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u6267\u884c\u5e94\u7528\u5b9a\u5236[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)deAppCustom.getDEAPPCUSTOMID(), (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                return callResult;
            }
            if (StringHelper.Compare((String)deAppCustom.getCUSTOMACTION(), (String)"REPLACE", (boolean)true) == 0) {
                Object objKeyValue = iDEHelper.GetKeyDEFHelper().GetDEFValue(deAppCustom.getDATAID());
                Object objSrcKeyValue = iDEHelper.GetKeyDEFHelper().GetDEFValue(deAppCustom.getSRCDATAID());
                BaseDataEntity srcDataEntity = deDataCtrl.GetDEHelper().CreateDEObject();
                srcDataEntity.SetParamValue(iDEHelper.GetKeyDEFHelper().GetDTColumn().GetColumnName(), objSrcKeyValue);
                callResult = deDataCtrl.Get(srcDataEntity);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6e90\u6570\u636e[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)iDEHelper.getId(), (Object)objSrcKeyValue, (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                BaseDataEntity dstDataEntity = deDataCtrl.GetDEHelper().CreateDEObject();
                String strOldName = "";
                if (deAppCustom.getUSEOLDNAME()) {
                    dstDataEntity.SetParamValue(iDEHelper.GetKeyDEFHelper().GetDTColumn().GetColumnName(), objKeyValue);
                    deDataCtrl.Get(dstDataEntity);
                    if (callResult.IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u76ee\u6807\u6570\u636e[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)iDEHelper.getId(), (Object)objKeyValue, (Object)callResult.getErrorInfo()));
                        return callResult;
                    }
                    strOldName = dstDataEntity.GetParamStringValue(iDEHelper.GetMajorDEFHelper().getName(), "");
                    dstDataEntity.Reset();
                }
                srcDataEntity.CopyTo(dstDataEntity, false);
                dstDataEntity.SetParamValue(iDEHelper.GetKeyDEFHelper().GetDTColumn().GetColumnName(), objKeyValue);
                if (deAppCustom.getUSEOLDNAME()) {
                    dstDataEntity.SetParamValue(iDEHelper.GetMajorDEFHelper().getName(), (Object)strOldName);
                }
                if ((callResult = this.FillDataEntity(iDEHelper, deAppCustom, srcDataEntity, dstDataEntity)).IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u586b\u5145\u6570\u636e\u5bf9\u8c61\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                callResult = deDataCtrl.Save(false, dstDataEntity);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u6267\u884c\u5e94\u7528\u5b9a\u5236[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)deAppCustom.getDEAPPCUSTOMID(), (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                return callResult;
            }
            if (StringHelper.Compare((String)deAppCustom.getCUSTOMACTION(), (String)"UPDATE", (boolean)true) == 0) {
                Object objKeyValue = iDEHelper.GetKeyDEFHelper().GetDEFValue(deAppCustom.getDATAID());
                Object objSrcKeyValue = iDEHelper.GetKeyDEFHelper().GetDEFValue(deAppCustom.getSRCDATAID());
                BaseDataEntity srcDataEntity = deDataCtrl.GetDEHelper().CreateDEObject();
                if (!StringHelper.IsNullOrEmpty((String)deAppCustom.getSRCDATAID())) {
                    srcDataEntity.SetParamValue(iDEHelper.GetKeyDEFHelper().GetDTColumn().GetColumnName(), objSrcKeyValue);
                    callResult = deDataCtrl.Get(srcDataEntity);
                    if (callResult.IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6e90\u6570\u636e[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)iDEHelper.getId(), (Object)objSrcKeyValue, (Object)callResult.getErrorInfo()));
                        return callResult;
                    }
                }
                BaseDataEntity dstDataEntity = deDataCtrl.GetDEHelper().CreateDEObject();
                dstDataEntity.SetParamValue(iDEHelper.GetKeyDEFHelper().GetDTColumn().GetColumnName(), objKeyValue);
                callResult = this.FillDataEntity(iDEHelper, deAppCustom, srcDataEntity, dstDataEntity);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u586b\u5145\u6570\u636e\u5bf9\u8c61\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                callResult = deDataCtrl.Save(false, dstDataEntity);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u6267\u884c\u5e94\u7528\u5b9a\u5236[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)deAppCustom.getDEAPPCUSTOMID(), (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                return callResult;
            }
            if (StringHelper.Compare((String)deAppCustom.getCUSTOMACTION(), (String)"SQL", (boolean)true) == 0) {
                callResult = BaseDEDataCtrl.ExecuteWithoutResultEx(this.globalHelperEx, iDEHelper.GetDBStorage(), deAppCustom.getACTIONPARAM(), null);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u6267\u884c\u5e94\u7528\u5b9a\u5236[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)deAppCustom.getDEAPPCUSTOMID(), (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                return callResult;
            }
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5b9a\u5236\u64cd\u4f5c[%1$s]", (Object)deAppCustom.getCUSTOMACTION()));
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884c\u5e94\u7528\u5b9a\u5236[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)deAppCustom.getDEAPPCUSTOMID(), (Object)ex.getMessage()));
            return callResult;
        }
    }

    protected CallResult FillDataEntity(IDEHelper iDEHelper, DEAppCustom deAppCustom, BaseDataEntity srcDataEntity, BaseDataEntity dstDataEntity) throws Exception {
        CallResult callResult = new CallResult();
        Properties properties = PropertiesHelper.Load(null, (String)deAppCustom.getACTIONPARAM());
        if (properties == null) {
            return callResult;
        }
        Enumeration<Object> en = properties.keys();
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
            if (StringHelper.Compare((String)"%%SRFREMOVE()%%", (String)strValue, (boolean)true) == 0 || StringHelper.Compare((String)"%%SRFREMOVE%%", (String)strValue, (boolean)true) == 0) {
                dstDataEntity.RemoveParam(strKey);
                continue;
            }
            callResult = MacroHelper.GetValue(strValue, this.getWebContext(), this.getGlobalHelper(), this.getOPPersonId(), srcDataEntity);
            if (callResult.getRetCode() != 0) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6307\u5b9a\u503c[%1$s],%2$s", (Object)strValue, (Object)callResult.getErrorInfo()));
                callResult.setRetCode(1);
                return callResult;
            }
            Object obj = callResult.getUserObject();
            if (obj == null) {
                dstDataEntity.SetParamValue(strKey, obj);
                continue;
            }
            if (obj instanceof String) {
                strValue = obj.toString();
                if (StringHelper.IsNullOrEmpty((String)strValue)) {
                    dstDataEntity.SetParamValue(strKey, null);
                    continue;
                }
                IDEFHelper iDEFHelper = null;
                if (iDEHelper != null) {
                    iDEFHelper = iDEHelper.GetDEFHelper(strKey);
                }
                if (iDEFHelper != null && (obj = DataTypeParse.Parse((String)iDEFHelper.GetStdDataType(), (String)strValue)) == null) {
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8f6c\u6362\u6307\u5b9a\u503c[%1$s]\u81f3\u7c7b\u578b[%2$s]", (Object)strValue, (Object)iDEFHelper.GetStdDataType()));
                    callResult.setRetCode(1);
                    return callResult;
                }
                dstDataEntity.SetParamValue(strKey, obj);
                continue;
            }
            dstDataEntity.SetParamValue(strKey, obj);
        }
        return callResult;
    }
}

