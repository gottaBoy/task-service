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
import SA.TM.Ctrl.Data.TMResType;
import SA.TM.Ctrl.ITMResBaseHelper;
import SA.TM.Ctrl.ITMResTypeHelper;
import SA.TM.Ctrl.TMComplexResHelper;
import SA.TM.Ctrl.TMResourceHelper;

public class TMResTypeHelper
extends BaseTMObject
implements ITMResTypeHelper {
    protected TMResType tmResType = null;

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, TMResType tmResType) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.tmResType = tmResType;
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    public ITMResBaseHelper CreateResource() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.tmResType.getRESOBJECT())) {
            Object objResHelper = ObjectHelper.Create((String)this.tmResType.getRESOBJECT());
            if (objResHelper == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u8d44\u6e90\u5bf9\u8c61[%1$s]", (Object)this.tmResType.getRESOBJECT()));
            }
            if (!(objResHelper instanceof ITMResBaseHelper)) {
                throw new Exception(StringHelper.Format((String)"\u8d44\u6e90\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)this.tmResType.getRESOBJECT()));
            }
            return (ITMResBaseHelper)objResHelper;
        }
        if (StringHelper.Compare((String)this.tmResType.getRESCATALOG(), (String)"STANDARD", (boolean)true) == 0) {
            return new TMResourceHelper();
        }
        if (StringHelper.Compare((String)this.tmResType.getRESCATALOG(), (String)"COMPLEX", (boolean)true) == 0) {
            return new TMComplexResHelper();
        }
        throw new Exception("\u6ca1\u6709\u5b9a\u4e49\u8d44\u6e90\u5bf9\u8c61");
    }

    public String getTimeRuleId() {
        return this.tmResType.getTMTIMERULEID();
    }
}

