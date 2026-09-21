/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.PrintForm
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Report;

import SA.SRFDA.Ctrl.Data.PrintForm;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Report.IPrintFormEngine;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BasePrintFormEngine
implements IPrintFormEngine {
    private static final Log log = LogFactory.getLog(BasePrintFormEngine.class);

    @Override
    public String Output(SRFDAWebContext webContext, PrintForm printForm, IDEHelper iDEHelper, BaseDataEntity dataEntity) {
        return this.OnOutput(webContext, printForm, iDEHelper, dataEntity);
    }

    protected String OnOutput(SRFDAWebContext webContext, PrintForm printForm, IDEHelper iDEHelper, BaseDataEntity dataEntity) {
        return "";
    }
}

