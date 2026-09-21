/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.ValueError
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.BaseDEFHelper;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ValueError;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FormulaDEFHelper
extends BaseDEFHelper {
    private static final Log log = LogFactory.getLog(FormulaDEFHelper.class);

    @Override
    protected String OnGetStdDataType() {
        if (!StringHelper.IsNullOrEmpty((String)this.defHelperConfig.getStdDataType())) {
            return this.defHelperConfig.getStdDataType();
        }
        if (DataTypeHelper.IsContainsDataType((String)this.GetDataType())) {
            return this.GetDataType();
        }
        log.error((Object)StringHelper.Format((String)"Formula\u5c5e\u6027\u6570\u636e\u7c7b\u578b[%1$s]\u6709\u8bef\uff0c\u5fc5\u987b\u4e3a\u57fa\u672c\u6570\u636e\u7c7b\u578b", (Object)this.GetDataType()));
        return "";
    }

    @Override
    public boolean IsFormulaDEField() {
        return true;
    }

    @Override
    public boolean IsPhisicalDEField() {
        return false;
    }

    @Override
    protected CallResult OnPrepareCreateDEField(Vector<ValueError> errs) {
        ValueError err;
        CallResult callResult = new CallResult();
        if (this.field.getDEFTYPE() != 2) {
            ValueError err2 = new ValueError();
            err2.setErrorCode(3);
            err2.setErrorInfo("\u5c5e\u6027\u8f85\u52a9\u5bf9\u8c61\u4e0d\u652f\u6301\u6b64\u5c5e\u6027\u7c7b\u578b!");
            err2.setValue("DERTYPE");
            errs.add(err2);
            callResult.setRetCode(5);
            return callResult;
        }
        String strFormulaFormat = this.field.getFORMULAFORMAT();
        String strFormulaField = this.field.getFORMULAFIELD();
        if (StringHelper.IsNullOrEmpty((String)strFormulaFormat)) {
            err = new ValueError();
            err.setErrorCode(1);
            err.setErrorInfo("\u903b\u8f91\u5c5e\u6027\u683c\u5f0f\u4e0d\u80fd\u4e3a\u7a7a!");
            err.setValue("FORMULAFORMAT");
            errs.add(err);
        }
        if (StringHelper.IsNullOrEmpty((String)strFormulaField)) {
            err = new ValueError();
            err.setErrorCode(1);
            err.setErrorInfo("\u903b\u8f91\u5c5e\u6027\u5b57\u6bb5\u4e0d\u80fd\u4e3a\u7a7a!");
            err.setValue("FORMULAFIELD");
            errs.add(err);
        }
        if (!DataTypeHelper.IsContainsDataType((String)this.field.getDATATYPE())) {
            err = new ValueError();
            err.setErrorCode(2);
            err.setErrorInfo("\u6570\u636e\u7c7b\u578b\u6709\u8bef\uff0c\u5fc5\u987b\u4e3a\u57fa\u7840\u6570\u636e\u7c7b\u578b!");
            err.setValue("DATATYPE");
            errs.add(err);
        }
        if (errs.size() == 0) {
            callResult.setRetCode(0);
        } else {
            callResult.setRetCode(5);
        }
        return callResult;
    }

    @Override
    public String GetStdDataType() {
        return super.GetStdDataType();
    }
}

