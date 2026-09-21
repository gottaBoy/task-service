/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSThickness;
import SA.SRFramework.Utility.StringHelper;

public class PSThicknessImpl
implements IPSThickness {
    protected int nLeft = 0;
    protected int nRight = 0;
    protected int nTop = 0;
    protected int nBottom = 0;
    private static PSThicknessImpl emptyThicknessImpl = new PSThicknessImpl();

    protected PSThicknessImpl() {
    }

    public PSThicknessImpl(int nThickness) {
        this.setLeft(nThickness);
        this.setRight(nThickness);
        this.setTop(nThickness);
        this.setBottom(nThickness);
    }

    public PSThicknessImpl(String strThickness) throws Exception {
        strThickness = strThickness.trim();
        if (StringHelper.IsNullOrEmpty((String)strThickness)) {
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
            this.setLeft(nValue);
            this.setRight(nValue);
            this.setTop(nValue2);
            this.setBottom(nValue2);
        } else if (items.length == 4) {
            int nValue = Integer.parseInt(items[0]);
            int nValue2 = Integer.parseInt(items[1]);
            int nValue3 = Integer.parseInt(items[2]);
            int nValue4 = Integer.parseInt(items[3]);
            this.setLeft(nValue);
            this.setTop(nValue2);
            this.setRight(nValue3);
            this.setBottom(nValue4);
        } else {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8fb9\u6846\u5b9a\u4e49[%1$s]", (Object)strThickness));
        }
    }

    public static IPSThickness getEmpty() {
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
        return StringHelper.Format((String)"%1$d,%2$d,%3$d,%4$d", (Object)this.getLeft(), (Object)this.getTop(), (Object)this.getRight(), (Object)this.getBottom());
    }
}

