/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.Data.DefaultValueRuleConfig;
import SA.SRFramework.Data.RefObject;
import SA.SRFramework.SASRFException;
import java.util.Hashtable;

public class ValueLTAndEQRuleConfig
extends DefaultValueRuleConfig {
    @Override
    public boolean Check(int type, Object objValue, Hashtable paramList) throws Exception {
        RefObject newDataType = new RefObject();
        newDataType.setObject(type);
        Object objSrc = this.GetSrcValue(objValue, type, newDataType);
        if (objSrc == null) {
            throw new SASRFException("\u6e90\u503c\u4e0d\u80fd\u4e3a\u7a7a");
        }
        Object objTarget = this.GetTargetValue((Integer)newDataType.getObject(), paramList);
        if (objTarget == null) {
            return true;
        }
        return DataTypeParse.Compare((Integer)newDataType.getObject(), objSrc, objTarget) <= 0L;
    }
}

