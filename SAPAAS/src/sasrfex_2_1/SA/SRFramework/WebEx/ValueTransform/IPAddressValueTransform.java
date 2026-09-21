/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.ValueTransform;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.NetHelper;
import SA.SRFramework.WebEx.ISRFExFormItem;
import SA.SRFramework.WebEx.ISRFExFormItemValueTransform;
import SA.SRFramework.WebEx.SRFExWebContext;

public class IPAddressValueTransform
implements ISRFExFormItemValueTransform {
    @Override
    public void Transform(SRFExWebContext webContext, ISRFExFormItem formItem) {
        String strValue = formItem.getValue();
        if (!StringHelper.IsNullOrEmpty((String)strValue)) {
            long l = NetHelper.IpToLong(strValue);
        }
    }
}

