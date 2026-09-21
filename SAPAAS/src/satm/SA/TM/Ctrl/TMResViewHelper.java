/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.BaseTMObject;
import SA.TM.Ctrl.Data.TMResView;
import SA.TM.Ctrl.Data.TMResViewDetail;
import SA.TM.Ctrl.ITMResViewHelper;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TMResViewHelper
extends BaseTMObject
implements ITMResViewHelper {
    protected TMResView tmResView = null;
    protected Vector<TMResViewDetail> tmResViewDetails = new Vector();

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, TMResView tmResView) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.tmResView = tmResView;
        this.OnPrepareTMResViewDetails();
        this.OnInit();
    }

    protected void OnPrepareTMResViewDetails() throws Exception {
        CallResult callResult = this.getTMModelHelper().GetTMResViewDetails(this.getId(), this.tmResViewDetails);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8d44\u6e90\u89c6\u56fe\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    @Override
    protected void OnInit() throws Exception {
    }

    @Override
    public int getVersion() {
        return this.tmResView.getVERSION();
    }

    @Override
    public String getId() {
        return this.tmResView.getTMRESVIEWID();
    }

    @Override
    public String getName() {
        return this.tmResView.getTMRESVIEWNAME();
    }

    @Override
    public String getUserId() {
        return this.tmResView.getTMUSERID();
    }

    @Override
    public Vector<TMResViewDetail> getResViewDetails() {
        return this.tmResViewDetails;
    }
}

