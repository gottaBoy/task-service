/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.util;

import java.util.ArrayList;
import java.util.TreeMap;
import net.ibizsys.paas.util.StringHelper;

public class ExcelCellFuncHelper {
    protected TreeMap<String, Integer> cellMap = new TreeMap();
    protected TreeMap<Integer, Integer> groupMap = new TreeMap();
    protected int nCurRow = 0;
    protected int nCurColumn = 0;
    protected boolean bIsGroup = false;
    protected int nStartGroupRow = 0;
    protected int nEndGroupRow = 0;
    protected int nStartRow = 0;
    protected int nStartColumn = 0;
    protected int nDataRowIndex = 1;
    public static final String TAG_FUNC_SRFGCELL = "#SRFGCELL";
    public static final String TAG_FUNC_SRFCELL = "#SRFCELL";
    public static final String TAG_FUNC_SRFOCELL = "#SRFOCELL";
    public static final String TAG_FUNC_SRF = "#SRF";
    public static final String TAG_FUNC_SRFDATAROWINDEX = "#SRFDATAROWINDEX";

    public String parse(String strFunc) {
        String strRet = "";
        String strParseFunc = strFunc;
        int nIndex = strParseFunc.indexOf(TAG_FUNC_SRF);
        while (nIndex != -1) {
            String strPart = strParseFunc.substring(0, nIndex);
            strRet = String.valueOf(strRet) + strPart;
            strPart = strParseFunc.substring(nIndex);
            ArrayList arrs = this.getFunction(strPart);
            if (arrs.size() >= 1) {
                strParseFunc = (String)arrs.get(0);
            }
            if (arrs.size() >= 2) {
                strRet = String.valueOf(strRet) + (String)arrs.get(1);
            }
            nIndex = strParseFunc.indexOf(TAG_FUNC_SRF);
        }
        strRet = String.valueOf(strRet) + strParseFunc;
        return strRet;
    }

    protected ArrayList getFunction(String strPart) {
        int nCellIndex;
        ArrayList<String> arrs = new ArrayList<String>();
        int nIndex = strPart.indexOf("(");
        if (nIndex == strPart.length()) {
            return arrs;
        }
        String strFuncName = strPart.substring(0, nIndex);
        String strPart2 = strPart.substring(nIndex + 1);
        String strParams = "";
        int nCount = 0;
        int i = 0;
        while (i < strPart2.length()) {
            char ch = strPart2.charAt(i);
            if (ch == ')') {
                if (nCount == 0) break;
                --nCount;
                strParams = String.valueOf(strParams) + ch;
            } else {
                if (ch == '(') {
                    ++nCount;
                }
                strParams = String.valueOf(strParams) + ch;
            }
            ++i;
        }
        strPart2 = strPart2.substring(strParams.length() + 1);
        arrs.add(strPart2);
        String[] params = StringHelper.split(strParams, ',');
        if (StringHelper.compare(strFuncName, TAG_FUNC_SRFCELL, true) == 0 && params.length != 0 && (nCellIndex = this.getCellIndex(params[0])) != -1) {
            String strCellIndex = ExcelCellFuncHelper.getCellSN(nCellIndex += this.nStartColumn, this.nCurRow);
            arrs.add(strCellIndex);
            return arrs;
        }
        if (StringHelper.compare(strFuncName, TAG_FUNC_SRFGCELL, true) == 0) {
            if (!this.bIsGroup) {
                return arrs;
            }
            if (params.length != 0 && (nCellIndex = this.getCellIndex(params[0])) != -1) {
                nCellIndex += this.nStartColumn;
                String strCellIndexs = "";
                Integer nGroupIndex = this.groupMap.firstKey();
                while (nGroupIndex != null) {
                    if (nGroupIndex >= this.nStartGroupRow && nGroupIndex <= this.nEndGroupRow) {
                        String strCellIndex = ExcelCellFuncHelper.getCellSN(nCellIndex, nGroupIndex);
                        strCellIndex = String.valueOf(strCellIndex) + ":";
                        strCellIndex = String.valueOf(strCellIndex) + ExcelCellFuncHelper.getCellSN(nCellIndex, this.groupMap.get(nGroupIndex));
                        if (strCellIndexs.length() > 0) {
                            strCellIndexs = String.valueOf(strCellIndexs) + ",";
                        }
                        strCellIndexs = String.valueOf(strCellIndexs) + strCellIndex;
                        nGroupIndex = ExcelCellFuncHelper.higherKey(this.groupMap, nGroupIndex);
                        continue;
                    }
                    if (nGroupIndex > this.nEndGroupRow) break;
                    nGroupIndex = ExcelCellFuncHelper.higherKey(this.groupMap, nGroupIndex);
                }
                arrs.add(strCellIndexs);
                return arrs;
            }
        }
        if (StringHelper.compare(strFuncName, TAG_FUNC_SRFOCELL, true) == 0 && params.length != 0) {
            int nColumnOffset = Integer.parseInt(params[0]);
            int nRowOffset = 0;
            if (params.length >= 2) {
                nRowOffset = Integer.parseInt(params[1]);
            }
            int nColumn = this.nCurColumn + nColumnOffset;
            int nRow = this.nCurRow + nRowOffset;
            String strCellIndex = ExcelCellFuncHelper.getCellSN(nColumn, nRow);
            arrs.add(strCellIndex);
            return arrs;
        }
        if (StringHelper.compare(strFuncName, TAG_FUNC_SRFDATAROWINDEX, true) == 0) {
            arrs.add(StringHelper.format("%1$s", this.nDataRowIndex));
        }
        return arrs;
    }

    protected static Integer higherKey(TreeMap<Integer, Integer> groupMap, Integer curValue) {
        Integer nHigherValue = null;
        Object[] list = groupMap.keySet().toArray();
        int i = 0;
        while (i < list.length) {
            if ((Integer)list[i] > curValue) {
                if (nHigherValue == null) {
                    nHigherValue = (Integer)list[i];
                } else if ((Integer)list[i] < nHigherValue) {
                    nHigherValue = (Integer)list[i];
                }
            }
            ++i;
        }
        return nHigherValue;
    }

    public void setGroup(int nGroupStartRow, int nGroupEndRow) {
        this.groupMap.put(nGroupStartRow, nGroupEndRow);
    }

    public int getStartRow() {
        return this.nStartRow;
    }

    public void setStartRow(int nStartRow) {
        this.nStartRow = nStartRow;
    }

    public int getStartColumn() {
        return this.nStartColumn;
    }

    public void setStartColumn(int nStartColumn) {
        this.nStartColumn = nStartColumn;
    }

    public int getStartGroupRow() {
        return this.nStartGroupRow;
    }

    public void setStartGroupRow(int nStartGroupRow) {
        this.nStartGroupRow = nStartGroupRow;
    }

    public int getEndGroupRow() {
        return this.nEndGroupRow;
    }

    public void setEndGroupRow(int nEndGroupRow) {
        this.nEndGroupRow = nEndGroupRow;
    }

    public boolean getIsGroup() {
        return this.bIsGroup;
    }

    public void setIsGroup(boolean bIsGroup) {
        this.bIsGroup = bIsGroup;
    }

    public int getCurRow() {
        return this.nCurRow;
    }

    public void setCurRow(int nCurRow) {
        this.nCurRow = nCurRow;
    }

    public int getCurColumn() {
        return this.nCurColumn;
    }

    public void setCurColumn(int nCurColumn) {
        this.nCurColumn = nCurColumn;
    }

    public void setCellIndex(String strCellName, int nIndex) {
        strCellName = strCellName.toUpperCase();
        this.cellMap.put(strCellName, nIndex);
    }

    public int getCellIndex(String strCellName) {
        if (this.cellMap.containsKey(strCellName = strCellName.toUpperCase())) {
            return this.cellMap.get(strCellName);
        }
        return -1;
    }

    public static String getColumnSN(int nColumnId) {
        String strRet = "";
        while (true) {
            int nTemp1 = nColumnId % 26;
            int nTemp2 = nColumnId / 26;
            strRet = String.valueOf(ExcelCellFuncHelper.GetColumnChar(nTemp1)) + strRet;
            if (nTemp2 == 0) break;
            nColumnId = nTemp2 - 1;
        }
        return strRet;
    }

    public static String getCellSN(int nColumnId, int nRowId) {
        Integer rowId = nRowId + 1;
        return String.valueOf(ExcelCellFuncHelper.getColumnSN(nColumnId)) + rowId.toString();
    }

    public void setDataRowIndex(int nDataRowIndex) {
        this.nDataRowIndex = nDataRowIndex;
    }

    public int getDataRowIndex() {
        return this.nDataRowIndex;
    }

    public static String GetColumnChar(int nCharNumber) {
        if (nCharNumber >= 26) {
            return StringHelper.format("A%1$s", ExcelCellFuncHelper.GetColumnChar(nCharNumber % 26));
        }
        switch (nCharNumber) {
            case 0: {
                return "A";
            }
            case 1: {
                return "B";
            }
            case 2: {
                return "C";
            }
            case 3: {
                return "D";
            }
            case 4: {
                return "E";
            }
            case 5: {
                return "F";
            }
            case 6: {
                return "G";
            }
            case 7: {
                return "H";
            }
            case 8: {
                return "I";
            }
            case 9: {
                return "J";
            }
            case 10: {
                return "K";
            }
            case 11: {
                return "L";
            }
            case 12: {
                return "M";
            }
            case 13: {
                return "N";
            }
            case 14: {
                return "O";
            }
            case 15: {
                return "P";
            }
            case 16: {
                return "Q";
            }
            case 17: {
                return "R";
            }
            case 18: {
                return "S";
            }
            case 19: {
                return "T";
            }
            case 20: {
                return "U";
            }
            case 21: {
                return "V";
            }
            case 22: {
                return "W";
            }
            case 23: {
                return "X";
            }
            case 24: {
                return "Y";
            }
            case 25: {
                return "Z";
            }
        }
        return "A";
    }
}

