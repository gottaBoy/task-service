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
import SA.TM.Ctrl.Data.TMRBRule;
import SA.TM.Ctrl.Data.TMRBRuleType;
import SA.TM.Ctrl.ITMRBRuleHelper;
import SA.TM.Ctrl.ITMRBRuleTypeHelper;

public class TMRBRuleTypeHelper
extends BaseTMObject
implements ITMRBRuleTypeHelper {
    protected TMRBRuleType tmRBRuleType = null;

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, TMRBRuleType tmRBRuleType) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.tmRBRuleType = tmRBRuleType;
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    public ITMRBRuleHelper CreateRBRule(TMRBRule tmRBRule) throws Exception {
        String strRuleObject = tmRBRule.getRULEOBJECT();
        if (StringHelper.IsNullOrEmpty((String)strRuleObject)) {
            strRuleObject = this.tmRBRuleType.getRULEOBJECT();
        }
        if (!StringHelper.IsNullOrEmpty((String)strRuleObject)) {
            Object objRBRuleHelper = ObjectHelper.Create((String)strRuleObject);
            if (objRBRuleHelper == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u9884\u7ea6\u89c4\u5219\u5bf9\u8c61[%1$s]", (Object)strRuleObject));
            }
            if (!(objRBRuleHelper instanceof ITMRBRuleHelper)) {
                throw new Exception(StringHelper.Format((String)"\u9884\u7ea6\u89c4\u5219\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strRuleObject));
            }
            return (ITMRBRuleHelper)objRBRuleHelper;
        }
        throw new Exception("\u6ca1\u6709\u5b9a\u4e49\u9884\u7ea6\u89c4\u5219\u5bf9\u8c61");
    }
}

