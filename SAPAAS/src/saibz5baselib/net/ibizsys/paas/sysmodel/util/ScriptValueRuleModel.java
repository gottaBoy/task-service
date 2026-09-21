/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel.util;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import net.ibizsys.paas.core.IScriptValueRule;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.SystemValueRuleModelBase;

public class ScriptValueRuleModel
extends SystemValueRuleModelBase
implements IScriptValueRule {
    private String strCode = null;
    private ScriptValueRuleContext scriptValueRuleContext = new ScriptValueRuleContext();
    private Invocable invocable = null;

    @Override
    protected void onInit() throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        String strJSCode = "function main(value,ctx){";
        strJSCode = String.valueOf(strJSCode) + this.getCode();
        strJSCode = String.valueOf(strJSCode) + "}";
        engine.eval(strJSCode);
        this.invocable = (Invocable)((Object)engine);
        super.onInit();
    }

    @Override
    public String getRuleType() {
        return "SCRIPT";
    }

    @Override
    public String getCode() {
        return this.strCode;
    }

    public void setCode(String strCode) {
        this.strCode = strCode;
    }

    @Override
    public boolean check(IEntity et, String strFieldName, boolean bTempMode, Object objParam, String strRuleInfo, boolean bTryMode) throws Exception {
        block6: {
            block7: {
                if (!et.contains(strFieldName)) {
                    return true;
                }
                Object objValue = et.get(strFieldName);
                if (objValue == null) {
                    return true;
                }
                try {
                    this.scriptValueRuleContext.reset();
                    this.scriptValueRuleContext.setEntity(et);
                    this.scriptValueRuleContext.setField(strFieldName);
                    this.scriptValueRuleContext.setTempMode(bTempMode);
                    this.scriptValueRuleContext.setValue(objValue);
                    Object objRet = this.invocable.invokeFunction("main", objValue, this.scriptValueRuleContext);
                    boolean bRet = false;
                    if (objRet != null && objRet instanceof Boolean) {
                        bRet = (Boolean)objRet;
                    }
                    this.scriptValueRuleContext.reset();
                    if (bRet) break block6;
                    if (!bTryMode) break block7;
                    return false;
                }
                catch (Exception ex) {
                    this.scriptValueRuleContext.reset();
                    throw ex;
                }
            }
            throw new Exception(strRuleInfo);
        }
        return true;
    }

    private class ScriptValueRuleContext {
        private ThreadLocal<IEntity> et = new ThreadLocal();
        private ThreadLocal<String> strFieldName = new ThreadLocal();
        private ThreadLocal<Boolean> bTempMode = new ThreadLocal();
        private ThreadLocal<Object> value = new ThreadLocal();

        private ScriptValueRuleContext() {
        }

        public void setEntity(IEntity et) {
            this.et.set(et);
        }

        public IEntity getEntity() {
            return this.et.get();
        }

        public void setField(String strFieldName) {
            this.strFieldName.set(strFieldName);
        }

        public String getField() {
            return this.strFieldName.get();
        }

        public void setTempMode(boolean bTempMode) {
            this.bTempMode.set(bTempMode);
        }

        public boolean isTempMode() {
            if (this.bTempMode.get() == null) {
                return false;
            }
            return this.bTempMode.get();
        }

        public Object getValue() {
            return this.value.get();
        }

        public void setValue(Object objValue) {
            this.value.set(objValue);
        }

        public void reset() {
            this.et.set(null);
            this.strFieldName.set(null);
            this.bTempMode.set(null);
            this.value.set(null);
        }
    }
}

