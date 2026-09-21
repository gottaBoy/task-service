/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

public interface ITreeNodeFetchContext {
    public String getCatalog();

    public String getNodeFilter();

    public boolean isAutoExpand();

    public String getRealNodeId();

    public boolean isSimpleMode();
}

