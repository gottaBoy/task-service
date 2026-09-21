/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.TM.Ctrl.BaseTMObject;
import SA.TM.Ctrl.Data.TMTaskResAEType;
import SA.TM.Ctrl.ITMTaskResAETypeHelper;
import SA.TM.Ctrl.ITMTaskResArrangeEngine;

public class TMTaskResAETypeHelper
extends BaseTMObject
implements ITMTaskResAETypeHelper {
    protected TMTaskResAEType tmTaskResAEType = null;

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, TMTaskResAEType tmTaskResAEType) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.tmTaskResAEType = tmTaskResAEType;
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    public ITMTaskResArrangeEngine CreateEngine() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.tmTaskResAEType.getENGINEOBJECT())) {
            throw new Exception("\u6ca1\u6709\u5b9a\u4e49\u5f15\u64ce\u5bf9\u8c61");
        }
        Object objEngine = ObjectHelper.Create((String)this.tmTaskResAEType.getENGINEOBJECT());
        if (objEngine == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5f15\u64ce\u5bf9\u8c61[%1$s]", (Object)this.tmTaskResAEType.getENGINEOBJECT()));
        }
        if (!(objEngine instanceof ITMTaskResArrangeEngine)) {
            throw new Exception(StringHelper.Format((String)"\u5f15\u64ce\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)this.tmTaskResAEType.getENGINEOBJECT()));
        }
        return (ITMTaskResArrangeEngine)objEngine;
    }

    public String getId() {
        return this.tmTaskResAEType.getTMTASKRESAETYPEID();
    }

    public String getName() {
        return this.tmTaskResAEType.getTMTASKRESAETYPENAME();
    }

    public int getVersion() {
        return 0;
    }
}

