/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  jxl.CellType
 */
package SA.SRFramework.ReportEx.Model;

import SA.SRFramework.Utility.StringHelper;
import jxl.CellType;

public class ExcelCellType {
    public static final String TAG_UNKNOWN = "UNKNOWN";
    public static final String TAG_LABEL = "LABEL";
    public static final String TAG_NUMBER = "NUMBER";
    public static final String TAG_HYPERLINK = "HYPERLINK";
    public static final String TAG_FORMULA = "FORMULA";
    public static final String TAG_EMPTY = "EMPTY";
    public static final int UNKNOWN = 0;
    public static final int LABEL = 1;
    public static final int NUMBER = 2;
    public static final int HYPERLINK = 3;
    public static final int FORMULA = 4;
    public static final int EMPTY = 5;

    public static int Parse(String strValue) {
        if (StringHelper.Compare((String)strValue, (String)TAG_UNKNOWN, (boolean)true) == 0) {
            return 0;
        }
        if (StringHelper.Compare((String)strValue, (String)TAG_LABEL, (boolean)true) == 0) {
            return 1;
        }
        if (StringHelper.Compare((String)strValue, (String)TAG_NUMBER, (boolean)true) == 0) {
            return 2;
        }
        if (StringHelper.Compare((String)strValue, (String)TAG_HYPERLINK, (boolean)true) == 0) {
            return 3;
        }
        if (StringHelper.Compare((String)strValue, (String)TAG_FORMULA, (boolean)true) == 0) {
            return 4;
        }
        if (StringHelper.Compare((String)strValue, (String)TAG_EMPTY, (boolean)true) == 0) {
            return 5;
        }
        return 0;
    }

    public static int Parse(CellType cellType) {
        if (cellType == CellType.STRING_FORMULA) {
            return 1;
        }
        if (cellType == CellType.NUMBER_FORMULA) {
            return 1;
        }
        if (cellType == CellType.NUMBER) {
            return 2;
        }
        if (cellType == CellType.LABEL) {
            return 1;
        }
        if (cellType == CellType.FORMULA_ERROR) {
            return 1;
        }
        if (cellType == CellType.BOOLEAN) {
            return 1;
        }
        if (cellType == CellType.BOOLEAN_FORMULA) {
            return 1;
        }
        if (cellType == CellType.DATE) {
            return 1;
        }
        if (cellType == CellType.DATE_FORMULA) {
            return 1;
        }
        if (cellType == CellType.EMPTY) {
            return 5;
        }
        if (cellType == CellType.ERROR) {
            return 1;
        }
        return 1;
    }

    public static String ToString(int nValue) {
        switch (nValue) {
            case 0: {
                return TAG_UNKNOWN;
            }
            case 1: {
                return TAG_LABEL;
            }
            case 2: {
                return TAG_NUMBER;
            }
            case 3: {
                return TAG_HYPERLINK;
            }
            case 4: {
                return TAG_FORMULA;
            }
            case 5: {
                return TAG_EMPTY;
            }
        }
        return TAG_UNKNOWN;
    }
}

