/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.sysmodel.SystemValueRuleModelBase
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.pscore.srv.core;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.SystemValueRuleModelBase;
import net.ibizsys.paas.util.StringHelper;

public class PSPathNameValueRuleModel
extends SystemValueRuleModelBase {
    public boolean check(IEntity iEntity, String string, boolean bl, Object object, String string2, boolean bl2) throws Exception {
        if (!iEntity.contains(string)) {
            return true;
        }
        String string3 = "";
        Object object2 = iEntity.get(string);
        if (object2 != null) {
            if (!(object2 instanceof String)) {
                throw new Exception(this.getLocalization("CTRL.SERVICE.CHECKFIELDREGEXRULE_INVALIDVALUE", new Object[]{string}, StringHelper.format((String)"\u5c5e\u6027[%1$s]\u503c\u4e0d\u662f\u5b57\u7b26\u7c7b\u578b", (Object)string)));
            }
            string3 = (String)object2;
        }
        if (StringHelper.isNullOrEmpty((String)string3)) {
            return true;
        }
        if (string3.indexOf("/") != -1 || string3.indexOf("@") != -1 || string3.indexOf(":") != -1 || string3.indexOf(">") != -1 || string3.indexOf("<") != -1 || string3.indexOf("*") != -1 || string3.indexOf("?") != -1 || string3.indexOf("|") != -1 || string3.indexOf("{") != -1 || string3.indexOf("}") != -1 || string3.indexOf("[") != -1 || string3.indexOf("]") != -1 || string3.indexOf("\\") != -1) {
            if (bl2) {
                return false;
            }
            throw new Exception(string2);
        }
        return true;
    }
}

