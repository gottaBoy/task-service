/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.BR.Ctrl;

import SA.SRFDA.BR.Ctrl.Data.BRInstParam;
import SA.SRFDA.BR.Ctrl.Data.BRInstance;
import SA.SRFDA.BR.Ctrl.ISRFBREngineContext;
import SA.SRFDA.BR.Ctrl.ISRFBRInstance;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Enumeration;
import java.util.Properties;

public class DefaultBRInstance
implements ISRFBRInstance {
    protected ISRFBREngineContext iEngineContext = null;
    protected BRInstance brInstance = null;
    protected BaseDataEntity brInstParams = new BaseDataEntity();
    protected BaseDataEntity brTempParams = new BaseDataEntity();

    @Override
    public CallResult Init(ISRFBREngineContext iEngineContext, BRInstance brInstance) {
        this.iEngineContext = iEngineContext;
        this.brInstance = brInstance;
        DefaultBRInstance.InitBRInstance(this, iEngineContext, brInstance);
        return this.OnInit();
    }

    protected CallResult OnInit() {
        return new CallResult();
    }

    @Override
    public void UpdateInstParam(BaseDataEntity updateParams) {
        for (BRInstParam instParam : this.iEngineContext.getInstParams()) {
            double fValue1;
            String strParamName = instParam.getBRINSTPARAMNAME();
            String strRefParamName = instParam.getRefParamName();
            if (!updateParams.ContainesParam(strRefParamName)) continue;
            Object objValue = updateParams.GetParamValue(strRefParamName);
            if (StringHelper.Compare((String)instParam.getUPDATEMODE(), (String)"1", (boolean)true) == 0) {
                this.brInstParams.SetParamValue(strParamName, objValue);
                continue;
            }
            if (StringHelper.Compare((String)instParam.getUPDATEMODE(), (String)"2", (boolean)true) == 0) {
                fValue1 = this.brInstParams.GetParamDoubleValue(strParamName, 0.0);
                double fValue2 = updateParams.GetParamDoubleValue(strRefParamName, 0.0);
                this.brInstParams.SetParamValue(strParamName, (Object)(fValue1 += fValue2));
                continue;
            }
            if (StringHelper.Compare((String)instParam.getUPDATEMODE(), (String)"3", (boolean)true) == 0) {
                fValue1 = this.brInstParams.GetParamDoubleValue(strParamName, 0.0);
                double fValue2 = updateParams.GetParamDoubleValue(strRefParamName, 0.0);
                this.brInstParams.SetParamValue(strParamName, (Object)(fValue1 -= fValue2));
                continue;
            }
            if (StringHelper.Compare((String)instParam.getUPDATEMODE(), (String)"4", (boolean)true) != 0) continue;
            fValue1 = updateParams.GetParamDoubleValue(strRefParamName, 0.0);
            String strParamTotal = StringHelper.Format((String)"#%1$s#SUM", (Object)strParamName);
            String strParamCnt = StringHelper.Format((String)"#%1$s#CNT", (Object)strParamName);
            double fTotal = this.brTempParams.GetParamDoubleValue(strParamTotal, 0.0);
            int nCnt = this.brTempParams.GetParamIntValue(strParamCnt, 0);
            fTotal += fValue1;
            fValue1 = fTotal / (double)(++nCnt);
            this.brInstParams.SetParamValue(strParamName, (Object)fValue1);
            this.brTempParams.SetParamValue(strParamTotal, (Object)fTotal);
            this.brTempParams.SetParamValue(strParamCnt, (Object)nCnt);
        }
    }

    @Override
    public void ResetParam(String strParamName, double fValue) {
        this.brInstParams.SetParamValue(strParamName, (Object)fValue);
        String strParamTotal = StringHelper.Format((String)"#%1$s#SUM", (Object)strParamName);
        String strParamCnt = StringHelper.Format((String)"#%1$s#CNT", (Object)strParamName);
        this.brTempParams.RemoveParam(strParamTotal);
        this.brTempParams.RemoveParam(strParamCnt);
    }

    @Override
    public BaseDataEntity GetInstParam() {
        return this.brInstParams;
    }

    @Override
    public void Quit() {
    }

    private static void InitBRInstance(ISRFBRInstance iBRInstance, ISRFBREngineContext iEngineContext, BRInstance brInstance) {
        BaseDataEntity instParams = iBRInstance.GetInstParam();
        Properties properties = brInstance.getInstParam();
        if (properties == null) {
            return;
        }
        Enumeration<Object> en = properties.keys();
        en.hasMoreElements();
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
            if (StringHelper.Compare((String)"%%SRFREMOVE()%%", (String)strValue, (boolean)true) == 0 || StringHelper.Compare((String)"%%SRFREMOVE%%", (String)strValue, (boolean)true) == 0) {
                instParams.RemoveParam(strKey);
                continue;
            }
            CallResult callResult = MacroHelper.GetValue((String)strValue, null, (ISRFDAGlobalHelper)iEngineContext.getDAGlobalHelper(), (String)"", null);
            if (callResult.getRetCode() != 0) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6307\u5b9a\u503c[%1$s],%2$s", (Object)strValue, (Object)callResult.getErrorInfo()));
                callResult.setRetCode(1);
                return;
            }
            Object obj = callResult.getUserObject();
            if (obj == null) {
                instParams.SetParamValue(strKey, obj);
                continue;
            }
            if (obj instanceof String) {
                strValue = obj.toString();
                if (StringHelper.IsNullOrEmpty((String)strValue)) {
                    instParams.SetParamValue(strKey, null);
                    continue;
                }
                instParams.SetParamValue(strKey, obj);
                continue;
            }
            instParams.SetParamValue(strKey, obj);
        }
    }

    @Override
    public BRInstance getBRInstance() {
        return this.brInstance;
    }
}

