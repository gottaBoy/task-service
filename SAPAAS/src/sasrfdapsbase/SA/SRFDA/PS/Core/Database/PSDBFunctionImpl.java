/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.PSDBFunctionImplBase;

public class PSDBFunctionImpl
extends PSDBFunctionImplBase {
    private String strName = null;
    private int nDataType = 0;
    private String strFormat = null;
    private int nLength = 0;

    public PSDBFunctionImpl(String strName, int nDataType, String strFormat, int nLength) {
        this.strName = strName;
        this.nDataType = nDataType;
        this.strFormat = strFormat;
        this.nLength = nLength;
    }

    public String getName() {
        return this.strName;
    }

    public int getOutputDataType() {
        return this.nDataType;
    }

    public String getFuncSQL(boolean bInsert, String[] args) throws Exception {
        int nCurLength = 0;
        if (args != null) {
            nCurLength = args.length;
        }
        if (this.nLength != nCurLength) {
            throw new Exception(String.format("\u6570\u636e\u5e93\u51fd\u6570[%1$s]\u9700\u8981\u53c2\u6570[%2$s]", this.getName(), this.nLength));
        }
        if (this.nLength == 0) {
            return this.strFormat;
        }
        switch (nCurLength) {
            case 0: {
                return this.strFormat;
            }
            case 1: {
                return String.format(this.strFormat, args[0]);
            }
            case 2: {
                return String.format(this.strFormat, args[0], args[1]);
            }
            case 3: {
                return String.format(this.strFormat, args[0], args[1], args[2]);
            }
            case 4: {
                return String.format(this.strFormat, args[0], args[1], args[2], args[3]);
            }
            case 5: {
                return String.format(this.strFormat, args[0], args[1], args[2], args[3], args[4]);
            }
            case 6: {
                return String.format(this.strFormat, args[0], args[1], args[2], args[3], args[4], args[5]);
            }
            case 7: {
                return String.format(this.strFormat, args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
            }
            case 8: {
                return String.format(this.strFormat, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7]);
            }
            case 9: {
                return String.format(this.strFormat, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8]);
            }
            case 10: {
                return String.format(this.strFormat, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9]);
            }
        }
        throw new Exception("\u683c\u5f0f\u5316\u53c2\u6570\u6570\u7ec4\u6ea2\u51fa");
    }
}

