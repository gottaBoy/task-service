/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Report;

public class ChartImage {
    public static final int IMG_TYPE_CHART = 0;
    public static final int IMG_TYPE_LEGEND = 1;
    private int height;
    private int width;
    private int type;
    private String mimeType = "";
    private byte[] imageBuffer = null;

    public ChartImage() {
        this.width = 400;
        this.height = 400;
        this.type = 0;
    }

    public ChartImage(byte[] buffer, String strMineType, int nWidth, int nHeight) {
        this.imageBuffer = buffer;
        this.mimeType = strMineType;
        this.width = nWidth;
        this.height = nHeight;
        this.type = 0;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int value) {
        this.width = value;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int value) {
        this.height = value;
    }

    public int getType() {
        return this.type;
    }

    public void setTypet(int value) {
        this.type = value;
    }

    public byte[] getBytes() {
        return this.imageBuffer;
    }

    public void setBytes(byte[] value) {
        this.imageBuffer = value;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(String value) {
        this.mimeType = value;
    }

    public int getSize() {
        if (this.imageBuffer == null) {
            return 0;
        }
        return this.imageBuffer.length;
    }
}

