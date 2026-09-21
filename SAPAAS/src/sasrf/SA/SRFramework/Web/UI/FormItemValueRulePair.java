/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

public class FormItemValueRulePair {
    public static final int GREATERTHAN = 1;
    public static final int LESSTHAN = 2;
    public static final int EQUALTO = 4;
    public static final int NOTEQUALTO = 8;
    private int nOpMode = 4;
    private String strOperator = "";
    private String strArg = "";
    private int nIndex = 0;

    public void setOperator(String value) {
        if (value.compareToIgnoreCase(">") == 0) {
            this.nOpMode = 1;
            return;
        }
        if (value.compareToIgnoreCase(">=") == 0) {
            this.nOpMode = 5;
            return;
        }
        if (value.compareToIgnoreCase("<=") == 0) {
            this.nOpMode = 6;
            return;
        }
        if (value.compareToIgnoreCase("<") == 0) {
            this.nOpMode = 2;
            return;
        }
        if (value.compareToIgnoreCase("<>") == 0 || value.compareToIgnoreCase("!=") == 0) {
            this.nOpMode = 8;
            return;
        }
        this.nOpMode = 4;
    }

    public int getOpMode() {
        return this.nOpMode;
    }

    public void setArg(String value) {
        this.strArg = value;
    }

    public String getArg() {
        return this.strArg;
    }

    public void setIndex(int value) {
        this.nIndex = value;
    }

    public int getIndex() {
        return this.nIndex;
    }

    public static boolean Test(long nCompareValue, int nOpMode) {
        if ((nOpMode & 4) > 0 && nCompareValue == 0L) {
            return true;
        }
        if ((nOpMode & 8) > 0 && nCompareValue != 0L) {
            return true;
        }
        if ((nOpMode & 1) > 0 && nCompareValue > 0L) {
            return true;
        }
        return (nOpMode & 2) > 0 && nCompareValue < 0L;
    }
}

