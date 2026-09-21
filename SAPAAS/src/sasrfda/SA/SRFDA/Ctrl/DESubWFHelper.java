/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DESubWF;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDESubWFHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;

public class DESubWFHelper
extends BaseDAObjectHelper
implements IDESubWFHelper {
    protected DESubWF deSubWF = null;
    protected Hashtable<String, String> editableWFStepMap = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IDEHelper iDEHelper, DESubWF deSubWF) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setDEHelper(iDEHelper);
        this.deSubWF = deSubWF;
        this.setId(this.deSubWF.getDESUBWFID());
        this.setName(this.deSubWF.getDESUBWFNAME());
        String strEditableWFStep = deSubWF.getEDITABLEWFSTEP();
        if (!StringHelper.IsNullOrEmpty((String)strEditableWFStep)) {
            strEditableWFStep = strEditableWFStep.toUpperCase();
            this.editableWFStepMap = new Hashtable();
            String[] editableWFSteps = StringHelper.SplitEx((String)strEditableWFStep);
            int i = 0;
            while (i < editableWFSteps.length) {
                this.editableWFStepMap.put(editableWFSteps[i], "");
                ++i;
            }
        }
        this.setParams(deSubWF.getWFParams());
        this.OnInit();
    }

    @Override
    public final DESubWF getData() {
        return this.deSubWF;
    }

    @Override
    public boolean isWFStepEditable(String strWFStep) {
        if (this.editableWFStepMap == null) {
            return false;
        }
        return this.editableWFStepMap.containsKey(strWFStep.toUpperCase());
    }

    @Override
    public IDEFHelper getWFStepField() throws Exception {
        String strWFStepDEFId = this.deSubWF.getWFSTEPDEFID();
        if (StringHelper.IsNullOrEmpty((String)strWFStepDEFId)) {
            return null;
        }
        IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper(strWFStepDEFId);
        if (iDEFHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strWFStepDEFId));
        }
        return iDEFHelper;
    }

    @Override
    public String getDESubWFSN() {
        return this.getData().getDESUBWFSN();
    }

    @Override
    public String getWFId() {
        return this.getData().getWFID();
    }

    @Override
    public String getWFFormName(String strWFMode, String strWFStep, String strSubWFStep) throws Exception {
        return this.OnGetWFFormName(strWFMode, strWFStep, strSubWFStep);
    }

    protected String OnGetWFFormName(String strWFMode, String strWFStep, String strSubWFStep) throws Exception {
        String strWFFormName = StringHelper.Format((String)"WFFORM_STEP_%1$s", (Object)strWFStep);
        strWFFormName = String.valueOf(strWFFormName) + StringHelper.Format((String)"_%1$s_%2$s", (Object)this.getDESubWFSN(), (Object)strSubWFStep);
        return strWFFormName;
    }
}

