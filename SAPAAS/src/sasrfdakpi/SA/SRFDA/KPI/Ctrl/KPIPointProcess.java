/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  groovy.lang.Binding
 *  groovy.lang.Script
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.KPI.Ctrl;

import SA.SRFDA.KPI.Ctrl.Data.KPIPoint;
import SA.SRFDA.KPI.Ctrl.ISRFKPIContext;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import groovy.lang.Binding;
import groovy.lang.Script;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class KPIPointProcess
extends Script {
    private static Log log = LogFactory.getLog(KPIPointProcess.class);

    public CallResult Process(KPIPoint kpiPoint, ISRFKPIContext context) {
        CallResult callResult = new CallResult();
        String strExpression = "";
        try {
            Binding binding = new Binding();
            binding.setProperty("kpi", (Object)context);
            Double fValue = 0.0;
            binding.setVariable("ret", (Object)fValue);
            this.setBinding(binding);
            strExpression = "ret=" + kpiPoint.getCALCFORMULA() + ";";
            Object objValue = this.evaluate(strExpression);
            fValue = Double.parseDouble(objValue.toString());
            if (kpiPoint.GetParamValue("MAXSCORE") != null) {
                double fMaxValue = kpiPoint.getMAXSCORE();
                if (fValue > fMaxValue) {
                    fValue = fMaxValue;
                }
            }
            if (kpiPoint.GetParamValue("MINSCORE") != null) {
                double fMinValue = kpiPoint.getMINSCORE();
                if (fValue < fMinValue) {
                    fValue = fMinValue;
                }
            }
            callResult.setUserObject((Object)fValue);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u6267\u884c\u8bed\u53e5[%1$s]\u5931\u8d25", (Object)strExpression), (Throwable)ex);
            callResult.setRetCode(1);
            return callResult;
        }
    }

    public Object run() {
        return "";
    }
}

