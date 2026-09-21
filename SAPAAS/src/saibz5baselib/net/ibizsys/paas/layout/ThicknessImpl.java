/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.layout;

import net.ibizsys.paas.layout.IThickness;
import net.ibizsys.paas.util.StringHelper;

public class ThicknessImpl
implements IThickness {
    protected int nLeft = 0;
    protected int nRight = 0;
    protected int nTop = 0;
    protected int nBottom = 0;
    private static ThicknessImpl emptyThicknessImpl = new ThicknessImpl();

    protected ThicknessImpl() {
    }

    public ThicknessImpl(int nThickness) {
        this.setLeft(nThickness);
        this.setRight(nThickness);
        this.setTop(nThickness);
        this.setBottom(nThickness);
    }

    public ThicknessImpl(String strThickness) throws Exception {
        strThickness = strThickness.trim();
        if (StringHelper.isNullOrEmpty(strThickness)) {
            return;
        }
        String[] items = strThickness.split("[,]");
        if (items.length == 1 && strThickness.indexOf(" ") != -1) {
            items = strThickness.split("[ ]");
        }
        if (items.length == 1) {
            int nValue = Integer.parseInt(items[0]);
            this.setLeft(nValue);
            this.setRight(nValue);
            this.setTop(nValue);
            this.setBottom(nValue);
        } else if (items.length == 2) {
            int nValue = Integer.parseInt(items[0]);
            int nValue2 = Integer.parseInt(items[1]);
            this.setTop(nValue);
            this.setBottom(nValue);
            this.setLeft(nValue2);
            this.setRight(nValue2);
        } else if (items.length == 4) {
            int nValue = Integer.parseInt(items[0]);
            int nValue2 = Integer.parseInt(items[1]);
            int nValue3 = Integer.parseInt(items[2]);
            int nValue4 = Integer.parseInt(items[3]);
            this.setTop(nValue);
            this.setRight(nValue2);
            this.setBottom(nValue3);
            this.setLeft(nValue4);
        } else {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u8fb9\u6846\u5b9a\u4e49[%1$s]", strThickness));
        }
    }

    public static IThickness getEmpty() {
        return emptyThicknessImpl;
    }

    @Override
    public int getLeft() {
        return this.nLeft;
    }

    @Override
    public int getRight() {
        return this.nRight;
    }

    @Override
    public int getTop() {
        return this.nTop;
    }

    @Override
    public int getBottom() {
        return this.nBottom;
    }

    public void setLeft(int nLeft) {
        this.nLeft = nLeft;
    }

    public void setRight(int nRight) {
        this.nRight = nRight;
    }

    public void setTop(int nTop) {
        this.nTop = nTop;
    }

    public void setBottom(int nBottom) {
        this.nBottom = nBottom;
    }

    public String toString() {
        return StringHelper.format("%1$d,%2$d,%3$d,%4$d", this.getTop(), this.getRight(), this.getBottom(), this.getLeft());
    }

    public String toString(String strSeparator) {
        String strUnitName = "px";
        return StringHelper.format("%1$d%6$s%5$s%2$d%6$s%5$s%3$d%6$s%5$s%4$d%6$s", this.getTop(), this.getRight(), this.getBottom(), this.getLeft(), strSeparator, strUnitName);
    }
}

