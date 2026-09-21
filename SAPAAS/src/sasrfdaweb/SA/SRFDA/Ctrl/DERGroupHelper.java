/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAObjectHelper
 *  SA.SRFDA.Ctrl.Data.DERGroup
 *  SA.SRFDA.Ctrl.Data.DERGroupDetail
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IDERGroupDetailHelper
 *  SA.SRFDA.Ctrl.IDERGroupHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.DERGroupDetailHelper;
import SA.SRFDA.Ctrl.Data.DERGroup;
import SA.SRFDA.Ctrl.Data.DERGroupDetail;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDERGroupDetailHelper;
import SA.SRFDA.Ctrl.IDERGroupHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;

public class DERGroupHelper
extends BaseDAObjectHelper
implements IDERGroupHelper {
    private boolean bIncludeForm = false;
    private String strDescription = "";
    private String strFormId = "";
    private String strFormName = "";
    protected DERGroup derGroup = null;
    private Vector<IDERGroupDetailHelper> derGroupDetailHelpers = new Vector();

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IDEHelper iDEHelper, DERGroup derGroup) throws Exception {
        this.derGroup = derGroup;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setDEHelper(iDEHelper);
        this.setId(this.derGroup.getDERGROUPID());
        this.setName(this.derGroup.getDERGROUPNAME());
        this.setVersion(this.derGroup.getVERSION());
        this.InitModel(derGroup);
        this.OnPrepareDetails();
        this.OnInit();
    }

    protected void OnPrepareDetails() throws Exception {
        Vector list = new Vector();
        CallResult callResult = this.getDAModelHelper().GetDERGroupDetails(this.getId(), list);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5206\u7ec4\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (DERGroupDetail derGroupDetail : list) {
            IDERGroupDetailHelper iDERGroupDetailHelper = this.OnCreateDERGroupDetailHelper(derGroupDetail);
            iDERGroupDetailHelper.Init(this.getDAGlobalHelper(), (IDERGroupHelper)this, derGroupDetail);
            this.derGroupDetailHelpers.add(iDERGroupDetailHelper);
        }
    }

    protected IDERGroupDetailHelper OnCreateDERGroupDetailHelper(DERGroupDetail derGroupDetail) throws Exception {
        return new DERGroupDetailHelper();
    }

    public Vector<IDERGroupDetailHelper> getDetails() {
        return this.derGroupDetailHelpers;
    }

    public boolean isIncludeForm() {
        return this.bIncludeForm;
    }

    protected void setIncludeForm(boolean bValue) {
        this.bIncludeForm = bValue;
    }

    public String getDescription() {
        return this.strDescription;
    }

    protected void setDescription(String strValue) {
        this.strDescription = strValue;
    }

    public String getFormId() {
        return this.strFormId;
    }

    protected void setFormId(String strValue) {
        this.strFormId = strValue;
    }

    public String getFormName() {
        return this.strFormName;
    }

    protected void setFormName(String strValue) {
        this.strFormName = strValue;
    }

    protected void InitModel(DERGroup item) {
        this.setIncludeForm(item.isINCLUDEDF());
        this.setDescription(item.getDESCRIPTION());
        this.setVersion(item.getVERSION());
        this.setFormId(item.getFORMID());
        this.setFormName(item.getFORMNAME());
    }
}

