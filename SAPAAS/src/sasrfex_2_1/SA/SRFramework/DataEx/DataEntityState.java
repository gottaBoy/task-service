/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.DataEx;

public class DataEntityState {
    protected boolean bWritable = true;
    protected boolean bRemovable = true;

    public boolean getWritable() {
        return this.bWritable;
    }

    public void setWritable(boolean bWritable) {
        this.bWritable = bWritable;
    }

    public boolean getRemovable() {
        return this.bRemovable;
    }

    public void setRemovable(boolean bRemovable) {
        this.bRemovable = bRemovable;
    }
}

