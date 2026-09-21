/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.Form;

import SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEFieldFormActionHelper
extends BaseDAFormActionHelper {
    private static final Log log = LogFactory.getLog(DEFieldFormActionHelper.class);

    @Override
    protected void OnSaveActionFillForm(BaseDataEntity dataEntity) {
        super.OnSaveActionFillForm(dataEntity);
        int nDEFType = dataEntity.GetParamIntValue("DEFTYPE", -1);
        if (nDEFType == 2) {
            this.form1.EnableFormItem("DATATYPE", true);
        } else {
            this.form1.EnableFormItem("DATATYPE", false);
        }
    }

    @Override
    protected void OnLoadActionFillForm(BaseDataEntity dataEntity) {
        super.OnLoadActionFillForm(dataEntity);
        int nDEFType = dataEntity.GetParamIntValue("DEFTYPE", -1);
        if (nDEFType == 2) {
            this.form1.EnableFormItem("DATATYPE", true);
        } else {
            this.form1.EnableFormItem("DATATYPE", false);
        }
    }
}

