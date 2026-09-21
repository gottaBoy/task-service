/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEWFHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;

public class DEWFHelper
extends BaseDAObjectHelper
implements IDEWFHelper {
    protected DEWF deWF = null;
    protected Hashtable<String, String> editableWFStepMap = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IDEHelper iDEHelper, DEWF deWF) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setDEHelper(iDEHelper);
        this.deWF = deWF;
        String strEditableWFStep = deWF.getEDITABLEWFSTEP();
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
        this.setParams(deWF.getWFParams());
        this.OnInit();
    }

    @Override
    public final DEWF getData() {
        return this.deWF;
    }

    @Override
    public IDEFHelper getWFStateField() throws Exception {
        String strWFStateDEFId = this.deWF.getWFSTATEDEFID();
        if (StringHelper.IsNullOrEmpty((String)strWFStateDEFId)) {
            return null;
        }
        IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper(strWFStateDEFId);
        if (iDEFHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strWFStateDEFId));
        }
        return iDEFHelper;
    }

    @Override
    public IDEFHelper getWFStepField() throws Exception {
        String strWFStepDEFId = this.deWF.getWFSTEPDEFID();
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
    public IDEFHelper getStateField() throws Exception {
        String strStateDEFId = this.deWF.getSTATEDEFID();
        if (StringHelper.IsNullOrEmpty((String)strStateDEFId)) {
            return null;
        }
        IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper(strStateDEFId);
        if (iDEFHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strStateDEFId));
        }
        return iDEFHelper;
    }

    @Override
    public boolean isWFStepEditable(String strWFStep) {
        if (this.editableWFStepMap == null) {
            return false;
        }
        return this.editableWFStepMap.containsKey(strWFStep.toUpperCase());
    }

    @Override
    public String getWFMSCodeListId() {
        return this.getData().getMSCLID();
    }

    @Override
    public String getWFId() {
        return this.getData().getWFID();
    }

    @Override
    public String getStartActionFormId() {
        return this.getData().getSTARTACTIONFORMID();
    }

    @Override
    public String getStartActionPageId() {
        return this.getData().getSTARTACTIONPAGEID();
    }
}

