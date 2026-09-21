/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.pub;

import java.util.HashMap;
import net.ibizsys.model.pub.IPSGenerateCodeResult;

public class PSGenerateCodeResultImpl
implements IPSGenerateCodeResult {
    Object object = null;
    String strCode = "";
    String strCode2 = "";
    String strCode3 = "";
    String strCode4 = "";
    HashMap<String, Object> paramMap = new HashMap();

    @Override
    public Object getObj() {
        return this.object;
    }

    @Override
    public String getCode() {
        return this.strCode;
    }

    @Override
    public String getCode2() {
        return this.strCode2;
    }

    @Override
    public String getCode3() {
        return this.strCode3;
    }

    @Override
    public String getCode4() {
        return this.strCode4;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public void setCode(String strCode) {
        this.strCode = strCode;
    }

    public void setCode2(String strCode2) {
        this.strCode2 = strCode2;
    }

    public void setCode3(String strCode3) {
        this.strCode3 = strCode3;
    }

    public void setCode4(String strCode4) {
        this.strCode4 = strCode4;
    }

    @Override
    public Object getParam(String strKey) {
        if (this.paramMap == null) {
            return null;
        }
        return this.paramMap.get(strKey);
    }

    public void setParams(HashMap<String, Object> paramMap) {
        this.paramMap = paramMap;
    }
}

