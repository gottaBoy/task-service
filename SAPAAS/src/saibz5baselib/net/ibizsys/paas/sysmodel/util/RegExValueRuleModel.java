/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.ibizsys.paas.core.IRegExValueRule;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.SystemValueRuleModelBase;
import net.ibizsys.paas.util.StringHelper;

public class RegExValueRuleModel
extends SystemValueRuleModelBase
implements IRegExValueRule {
    private String strExpression = null;
    private Pattern p = null;

    @Override
    protected void onInit() throws Exception {
        this.p = Pattern.compile(this.strExpression);
        super.onInit();
    }

    @Override
    public String getRuleType() {
        return "REGEX";
    }

    @Override
    public String getExpression() {
        return this.strExpression;
    }

    public void setExpression(String strExpression) {
        this.strExpression = strExpression;
    }

    @Override
    public boolean check(IEntity et, String strFieldName, boolean bTempMode, Object objParam, String strRuleInfo, boolean bTryMode) throws Exception {
        if (!et.contains(strFieldName)) {
            return true;
        }
        String strValue = "";
        Object objValue = et.get(strFieldName);
        if (objValue != null) {
            if (!(objValue instanceof String)) {
                throw new Exception(this.getLocalization("CTRL.SERVICE.CHECKFIELDREGEXRULE_INVALIDVALUE", new Object[]{strFieldName}, StringHelper.format("\u5c5e\u6027[%1$s]\u503c\u4e0d\u662f\u5b57\u7b26\u7c7b\u578b", strFieldName)));
            }
            strValue = (String)objValue;
        }
        if (StringHelper.isNullOrEmpty(strValue)) {
            return true;
        }
        Matcher m = this.p.matcher(strValue);
        boolean b = m.matches();
        if (!b) {
            if (bTryMode) {
                return false;
            }
            throw new Exception(strRuleInfo);
        }
        return true;
    }
}

