/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import java.util.Hashtable;

public class DBResult {
    protected int curDBType = 1;
    protected int nRetCode = 0;
    protected String strErrorInfo = "";
    protected Hashtable returnValues = null;
    protected int nUpdateCount = 0;

    public int getRetCode() {
        return this.nRetCode;
    }

    public void setRetCode(int value) {
        this.nRetCode = value;
    }

    public String getErrorInfo() {
        return this.strErrorInfo;
    }

    public void setErrorInfo(String value) {
        this.strErrorInfo = value;
    }

    public int getDatabase() {
        return this.curDBType;
    }

    public void setDatabase(int value) {
        this.curDBType = value;
    }

    public Hashtable getOutValues() {
        if (this.returnValues == null) {
            this.returnValues = new Hashtable();
        }
        return this.returnValues;
    }

    public int getUpdateCount() {
        return this.nUpdateCount;
    }

    public void setUpdateCount(int nUpdateCount) {
        this.nUpdateCount = nUpdateCount;
    }
}

