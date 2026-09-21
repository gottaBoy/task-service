/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

public class PluginActionResult {
    public static final int RESULT_REPLACE = 1;
    public static final int RESULT_CONTINUE = 2;
    public static final PluginActionResult Replace = new PluginActionResult(1);
    public static final PluginActionResult Continue = new PluginActionResult(2);
    private int nResult = 1;
    private Object objUserObject = null;

    public PluginActionResult(int nResult) {
        this.nResult = nResult;
    }

    public PluginActionResult(int nResult, Object objUserObject) {
        this.nResult = nResult;
        this.objUserObject = objUserObject;
    }

    public int getResult() {
        return this.nResult;
    }

    public Object getUserObject() {
        return this.objUserObject;
    }
}

