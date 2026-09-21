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
import SA.TM.Ctrl.Data.TMResCD;
import SA.TM.Ctrl.Data.TMResCatalog;
import SA.TM.Ctrl.ITMResCatalogHelper;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TMResCatalogHelper
extends BaseTMObject
implements ITMResCatalogHelper {
    protected TMResCatalog tmResCatalog = null;
    protected Vector<TMResCD> tmResCDs = new Vector();
    protected String strDefaultTaskResAEId = "";

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, TMResCatalog tmResCatalog) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.tmResCatalog = tmResCatalog;
        if (!StringHelper.IsNullOrEmpty((String)this.tmResCatalog.getTMTASKRESAEID())) {
            this.strDefaultTaskResAEId = this.tmResCatalog.getTMTASKRESAEID();
        }
        this.OnPrepareTMResCDs();
        this.OnInit();
    }

    protected void OnPrepareTMResCDs() throws Exception {
        CallResult callResult = this.getTMModelHelper().GetTMResCDs(this.getId(), this.tmResCDs);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5206\u7c7b\u8d44\u6e90\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    @Override
    protected void OnInit() throws Exception {
    }

    @Override
    public String getId() {
        return this.tmResCatalog.getTMRESCATALOGID();
    }

    @Override
    public String getName() {
        return this.tmResCatalog.getTMRESCATALOGNAME();
    }

    @Override
    public int getVersion() {
        return this.tmResCatalog.getVERSION();
    }

    @Override
    public Vector<TMResCD> getResCatalogDetails() {
        return this.tmResCDs;
    }

    @Override
    public String getTMTaskResAEId() {
        return this.strDefaultTaskResAEId;
    }
}

