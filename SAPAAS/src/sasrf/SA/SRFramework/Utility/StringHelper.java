/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Utility;

import java.util.ArrayList;

public final class StringHelper {
    public static final String Format(String strFormat) {
        return strFormat;
    }

    public static final String Format(String strFormat, Object obj1) {
        return String.format(strFormat, obj1);
    }

    public static final String Format(String strFormat, Object obj1, Object obj2) {
        return String.format(strFormat, obj1, obj2);
    }

    public static final String Format(String strFormat, Object obj1, Object obj2, Object obj3) {
        return String.format(strFormat, obj1, obj2, obj3);
    }

    public static final String Format(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4) {
        return String.format(strFormat, obj1, obj2, obj3, obj4);
    }

    public static final String Format(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5) {
        return String.format(strFormat, obj1, obj2, obj3, obj4, obj5);
    }

    public static final String Format(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6);
    }

    public static final String Format(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    public static final String Format(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    public static final String Format(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    public static final String Format(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        return String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    public static final String Format(String strFormat, Object[] arrList) {
        int nArrCount = arrList.length;
        switch (nArrCount) {
            case 0: {
                return strFormat;
            }
            case 1: {
                return String.format(strFormat, arrList[0]);
            }
            case 2: {
                return String.format(strFormat, arrList[0], arrList[1]);
            }
            case 3: {
                return String.format(strFormat, arrList[0], arrList[1], arrList[2]);
            }
            case 4: {
                return String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3]);
            }
            case 5: {
                return String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4]);
            }
            case 6: {
                return String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4], arrList[5]);
            }
            case 7: {
                return String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4], arrList[5], arrList[6]);
            }
            case 8: {
                return String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4], arrList[5], arrList[6], arrList[7]);
            }
            case 9: {
                return String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4], arrList[5], arrList[6], arrList[7], arrList[8]);
            }
            case 10: {
                return String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4], arrList[5], arrList[6], arrList[7], arrList[8], arrList[9]);
            }
        }
        return strFormat;
    }

    public static final int StringLength(String strValue) {
        if (strValue == null) {
            return 0;
        }
        return strValue.length();
    }

    public static final int Length(String strValue) {
        if (strValue == null) {
            return 0;
        }
        return strValue.length();
    }

    public static final boolean IsNullOrEmpty(String strValue) {
        return StringHelper.Length(strValue) == 0;
    }

    public static final int Compare(String strValue1, String strValue2, boolean bIgnoreCase) {
        if (strValue1 == null && strValue2 == null) {
            return 0;
        }
        if (strValue1 == null || strValue2 == null) {
            return -1;
        }
        if (bIgnoreCase) {
            return strValue1.compareToIgnoreCase(strValue2);
        }
        return strValue1.compareTo(strValue2);
    }

    public static final String[] Split(String strValue, char chSeperator) {
        int nPos;
        if (StringHelper.Length(strValue) == 0) {
            return null;
        }
        ArrayList<String> arrList = new ArrayList<String>();
        while ((nPos = strValue.indexOf(chSeperator)) != -1) {
            String strPartA = strValue.substring(0, nPos);
            arrList.add(strPartA);
            strValue = strValue.substring(nPos + 1);
        }
        arrList.add(strValue);
        String[] strList = new String[arrList.size()];
        arrList.toArray(strList);
        return strList;
    }

    public static final String[] Split(String strValue, String chSeperator) {
        int nPos;
        if (StringHelper.Length(strValue) == 0) {
            return null;
        }
        ArrayList<String> arrList = new ArrayList<String>();
        while ((nPos = strValue.indexOf(chSeperator)) != -1) {
            String strPartA = strValue.substring(0, nPos);
            arrList.add(strPartA);
            strValue = strValue.substring(nPos + chSeperator.length());
        }
        arrList.add(strValue);
        String[] strList = new String[arrList.size()];
        arrList.toArray(strList);
        return strList;
    }

    public static final String TrimLeft(String strValue) {
        return StringHelper.TrimLeft(strValue, ' ');
    }

    public static final String TrimLeft(String strValue, char ch) {
        while (strValue.length() > 0) {
            if (strValue.charAt(0) != ch) break;
            strValue = strValue.substring(1);
        }
        return strValue;
    }

    public static final String[] SplitEx(String strValue) {
        if (StringHelper.Length(strValue) == 0) {
            return null;
        }
        strValue = strValue.replace("|", ";");
        return strValue.split("[;]");
    }
}

