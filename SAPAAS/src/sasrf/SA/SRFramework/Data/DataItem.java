/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

public class DataItem {
    private String X = "";
    private String value = "";
    private String Z = "";
    private String T = "";

    public DataItem() {
    }

    public DataItem(String X, String value) {
        this.X = X;
        this.value = value;
    }

    public void setX(String X) {
        this.X = X;
    }

    public void setY(String value) {
        this.value = value;
    }

    public void setZ(String value) {
        this.Z = value;
    }

    public void setT(String value) {
        this.T = value;
    }

    public String getX() {
        if (this.X == null) {
            return "";
        }
        return this.X;
    }

    public String getY() {
        if (this.value == null) {
            return "";
        }
        return this.value;
    }

    public String getZ() {
        if (this.Z == null) {
            return "";
        }
        return this.Z;
    }

    public String getT() {
        if (this.T == null) {
            return "";
        }
        return this.T;
    }
}

