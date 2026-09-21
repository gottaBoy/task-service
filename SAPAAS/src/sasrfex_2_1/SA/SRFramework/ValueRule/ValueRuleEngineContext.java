/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.BaseDBCallerHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.ValueRule;

import SA.SRFramework.Data.BaseDBCallerHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.ValueRule.ValueRuleMgr;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ValueRuleEngineContext {
    private static final Log log = LogFactory.getLog(ValueRuleEngineContext.class);
    protected Object objValue = null;
    protected int nDataType = 25;
    protected BaseDBCallerHelper dbCallerHelper = null;
    protected BaseDataEntity dataEntity = null;
    protected ValueRuleMgr valueRuleMgr = null;
    protected String strErrorMessage = "";

    public Object getValue() {
        return this.objValue;
    }

    public void setValue(Object objValue) {
        this.objValue = objValue;
    }

    public int getDataType() {
        return this.nDataType;
    }

    public void setDataType(int nDataType) {
        this.nDataType = nDataType;
    }

    public BaseDBCallerHelper getDBCallerHelper() {
        return this.dbCallerHelper;
    }

    public void setDBCallerHelper(BaseDBCallerHelper dbCallerHelper) {
        this.dbCallerHelper = dbCallerHelper;
    }

    public BaseDataEntity getDataEntity() {
        return this.dataEntity;
    }

    public void setDataEntity(BaseDataEntity dataEntity) {
        this.dataEntity = dataEntity;
    }

    public ValueRuleMgr getValueRuleMgr() {
        return this.valueRuleMgr;
    }

    public void setValueRuleMgr(ValueRuleMgr valueRuleMgr) {
        this.valueRuleMgr = valueRuleMgr;
    }

    public String getErrorMessage() {
        return this.strErrorMessage;
    }

    public void setErrorMessage(String strErrorMessage) {
        this.strErrorMessage = strErrorMessage;
    }

    public String GetDataEntityParamInfo(String strParamName) {
        log.warn((Object)StringHelper.Format((String)"\u672a\u77e5\u7684\u53c2\u6570\u4fe1\u606f[%1$s]", (Object)strParamName));
        return StringHelper.Format((String)"\u672a\u77e5\u53c2\u6570[%1$s]", (Object)strParamName);
    }
}

