package net.ibizsys.paas.util;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * 单元格函数上下文辅助对象
 * 
 * @author LionLau
 *
 */
public class ExcelCellFuncHelper {
	protected TreeMap<String, Integer> cellMap = new TreeMap<String, Integer>();
	protected TreeMap<Integer, Integer> groupMap = new TreeMap<Integer, Integer>();
	protected int nCurRow = 0;
	protected int nCurColumn = 0;
	protected boolean bIsGroup = false;
	protected int nStartGroupRow = 0;
	protected int nEndGroupRow = 0;
	protected int nStartRow = 0;
	protected int nStartColumn = 0;
	protected int nDataRowIndex = 1;

	/**
	 * 一组单元格，应用在分组统计区域中，可以包含多个分组
	 */
	public final static String TAG_FUNC_SRFGCELL = "#SRFGCELL";

	/**
	 * 一个单元格，当前行加列编号
	 */
	public final static String TAG_FUNC_SRFCELL = "#SRFCELL";

	/**
	 * 一个单元格，当前单元格的偏移位置（列偏移位置，行偏移位置）
	 */
	public final static String TAG_FUNC_SRFOCELL = "#SRFOCELL";

	public final static String TAG_FUNC_SRF = "#SRF";

	/**
	 * 当前数据行序号
	 */
	public final static String TAG_FUNC_SRFDATAROWINDEX = "#SRFDATAROWINDEX";

	public ExcelCellFuncHelper() {

	}

	/**
	 * 分析函数
	 * 
	 * @param strFunc
	 * @return
	 */
	public String parse(String strFunc) {
		String strRet = "";
		String strParseFunc = strFunc;

		int nIndex = strParseFunc.indexOf(TAG_FUNC_SRF);
		while (nIndex != -1) {
			String strPart = strParseFunc.substring(0, nIndex);
			strRet += strPart;

			// 获取对应的块
			strPart = strParseFunc.substring(nIndex);
			// 获取函数

			ArrayList arrs = getFunction(strPart);
			if (arrs.size() >= 1) strParseFunc = (String) arrs.get(0);
			if (arrs.size() >= 2) strRet += (String) arrs.get(1);
			nIndex = strParseFunc.indexOf(TAG_FUNC_SRF);
		}
		strRet += strParseFunc;

		return strRet;
	}

	/**
	 * 获取函数
	 * 
	 * @param strPart
	 * @return
	 */
	protected ArrayList getFunction(String strPart) {
		ArrayList arrs = new ArrayList();
		int nIndex = strPart.indexOf("(");
		if (nIndex == strPart.length()) return arrs;

		String strFuncName = strPart.substring(0, nIndex);
		String strPart2 = strPart.substring(nIndex + 1);

		String strParams = "";

		int nCount = 0;
		for (int i = 0; i < strPart2.length(); i++) {
			char ch = strPart2.charAt(i);
			if (ch == ')') {
				if (nCount == 0)
					break;
				else {
					nCount--;
					strParams += ch;
				}
			} else {
				if (ch == '(') nCount++;
				strParams += ch;
			}
		}

		strPart2 = strPart2.substring(strParams.length() + 1);

		arrs.add(strPart2);

		// 判断函数名称
		String[] params = StringHelper.split(strParams, ',');

		if (StringHelper.compare(strFuncName, TAG_FUNC_SRFCELL, true) == 0) {
			// 当前行单元格
			if (params.length != 0) {
				int nCellIndex = getCellIndex(params[0]);
				if (nCellIndex != -1) {
					nCellIndex += nStartColumn;
					String strCellIndex = getCellSN(nCellIndex, nCurRow);
					arrs.add(strCellIndex);
					return arrs;
				}
			}
		}

		if (StringHelper.compare(strFuncName, TAG_FUNC_SRFGCELL, true) == 0) {
			if (!bIsGroup) return arrs;
			// 当前行单元格
			if (params.length != 0) {
				int nCellIndex = getCellIndex(params[0]);
				if (nCellIndex != -1) {
					nCellIndex += nStartColumn;

					String strCellIndexs = "";
					Integer nGroupIndex = groupMap.firstKey();
					while (nGroupIndex != null) {
						if (nGroupIndex >= nStartGroupRow && nGroupIndex <= nEndGroupRow) {
							String strCellIndex = getCellSN(nCellIndex, nGroupIndex);
							strCellIndex += ":";
							strCellIndex += getCellSN(nCellIndex, groupMap.get(nGroupIndex));
							if (strCellIndexs.length() > 0) strCellIndexs += ",";
							strCellIndexs += strCellIndex;
							nGroupIndex = higherKey(groupMap, nGroupIndex);
						} else {
							if (nGroupIndex > nEndGroupRow)
								break;
							else
								nGroupIndex = higherKey(groupMap, nGroupIndex);
						}
					}
					arrs.add(strCellIndexs);
					return arrs;
				}
			}
		}

		if (StringHelper.compare(strFuncName, TAG_FUNC_SRFOCELL, true) == 0) {
			// 当前行单元格
			if (params.length != 0) {
				int nColumnOffset = Integer.parseInt(params[0]);
				int nRowOffset = 0;
				if (params.length >= 2) nRowOffset = Integer.parseInt(params[1]);

				int nColumn = nCurColumn + nColumnOffset;
				int nRow = nCurRow + nRowOffset;
				String strCellIndex = getCellSN(nColumn, nRow);

				arrs.add(strCellIndex);
				return arrs;
			}
		}

		if (StringHelper.compare(strFuncName, TAG_FUNC_SRFDATAROWINDEX, true) == 0) {
			arrs.add(StringHelper.format("%1$s", this.nDataRowIndex));
		}
		return arrs;

	}

	protected static Integer higherKey(TreeMap<Integer, Integer> groupMap, Integer curValue) {
		Integer nHigherValue = null;
		Object[] list = groupMap.keySet().toArray();
		for (int i = 0; i < list.length; i++) {
			if ((Integer) list[i] > curValue) {
				if (nHigherValue == null)
					nHigherValue = (Integer) list[i];
				else {
					if ((Integer) list[i] < nHigherValue) nHigherValue = (Integer) list[i];
				}
			}
		}
		return nHigherValue;
	}

	/**
	 * 设置分组的行位置
	 * 
	 * @param nGroupStartRow
	 * @param nGroupEndRow
	 */
	public void setGroup(int nGroupStartRow, int nGroupEndRow) {
		groupMap.put(nGroupStartRow, nGroupEndRow);
	}

	/**
	 * 获取开始行编号
	 * 
	 * @return
	 */
	public int getStartRow() {
		return this.nStartRow;
	}

	/**
	 * 设置开始行编号
	 * 
	 * @param nStartRow
	 */
	public void setStartRow(int nStartRow) {
		this.nStartRow = nStartRow;
	}

	/**
	 * 获取开始列编号
	 * 
	 * @return
	 */
	public int getStartColumn() {
		return this.nStartColumn;
	}

	/**
	 * 设置开始列编号
	 * 
	 * @param nStartColumn
	 */
	public void setStartColumn(int nStartColumn) {
		this.nStartColumn = nStartColumn;
	}

	/**
	 * 获取开始分组编号
	 * 
	 * @return
	 */
	public int getStartGroupRow() {
		return this.nStartGroupRow;
	}

	/**
	 * 设置开始分组编号
	 * 
	 * @param nStartGroupRow
	 */
	public void setStartGroupRow(int nStartGroupRow) {
		this.nStartGroupRow = nStartGroupRow;
	}

	/**
	 * 获取结束分组编号
	 * 
	 * @return
	 */
	public int getEndGroupRow() {
		return this.nEndGroupRow;
	}

	/**
	 * 设置结束分组编号
	 * 
	 * @param nEndGroupRow
	 */
	public void setEndGroupRow(int nEndGroupRow) {
		this.nEndGroupRow = nEndGroupRow;
	}

	/**
	 * 当前是否处于分组状态
	 * 
	 * @return
	 */
	public boolean getIsGroup() {
		return this.bIsGroup;
	}

	/**
	 * 设置当前是否处于分组状态
	 * 
	 * @param bIsGroup
	 */
	public void setIsGroup(boolean bIsGroup) {
		this.bIsGroup = bIsGroup;
	}

	/**
	 * 获取当前行
	 * 
	 * @return
	 */
	public int getCurRow() {
		return this.nCurRow;
	}

	/**
	 * 设置当前行
	 * 
	 * @param nCurRow
	 */
	public void setCurRow(int nCurRow) {
		this.nCurRow = nCurRow;
	}

	/**
	 * 获取当前列
	 * 
	 * @return
	 */
	public int getCurColumn() {
		return this.nCurColumn;
	}

	/**
	 * 设置当前列
	 * 
	 * @param nCurColumn
	 */
	public void setCurColumn(int nCurColumn) {
		this.nCurColumn = nCurColumn;
	}

	/**
	 * 设置列编号
	 * 
	 * @param strCellName
	 * @param nIndex
	 */
	public void setCellIndex(String strCellName, int nIndex) {
		strCellName = strCellName.toUpperCase();
		cellMap.put(strCellName, nIndex);
	}

	/**
	 * 获取列编号
	 * 
	 * @param strCellName
	 * @return
	 */
	public int getCellIndex(String strCellName) {
		strCellName = strCellName.toUpperCase();
		if (cellMap.containsKey(strCellName))
			return (Integer) cellMap.get(strCellName);
		else
			return -1;
	}

	/**
	 * 获取列编号
	 * 
	 * @param nColumnId
	 * @return
	 */
	public static String getColumnSN(int nColumnId) {
		String strRet = "";
		while (true) {
			int nTemp1 = nColumnId % 26;
			int nTemp2 = (int) (nColumnId / 26);
			strRet = GetColumnChar(nTemp1) + strRet;
			if (nTemp2 == 0)
				break;
			else
				nColumnId = nTemp2 - 1;
		}
		return strRet;
	}

	/**
	 * 获取单元格编号
	 * 
	 * @param nColumnId
	 * @param nRowId
	 * @return
	 */
	public static String getCellSN(int nColumnId, int nRowId) {
		Integer rowId = nRowId + 1;

		return getColumnSN(nColumnId) + rowId.toString();
	}

	/**
	 * 设置当前数据行索引
	 * 
	 * @param nDataRowIndex
	 */
	public void setDataRowIndex(int nDataRowIndex) {
		this.nDataRowIndex = nDataRowIndex;
	}

	/**
	 * 获取当前数据行索引
	 * 
	 * @return
	 */
	public int getDataRowIndex() {
		return this.nDataRowIndex;
	}

	/**
	 * 获取列字符
	 * 
	 * @param nCharNumber
	 * @return
	 */
	public static String GetColumnChar(int nCharNumber) {
		if (nCharNumber >= 26) {
			return StringHelper.format("A%1$s", GetColumnChar(nCharNumber % 26));
		}
		switch (nCharNumber) {
		case 0:
			return "A";
		case 1:
			return "B";
		case 2:
			return "C";
		case 3:
			return "D";
		case 4:
			return "E";
		case 5:
			return "F";
		case 6:
			return "G";
		case 7:
			return "H";
		case 8:
			return "I";
		case 9:
			return "J";
		case 10:
			return "K";
		case 11:
			return "L";

		case 12:
			return "M";
		case 13:
			return "N";
		case 14:
			return "O";
		case 15:
			return "P";
		case 16:
			return "Q";
		case 17:
			return "R";
		case 18:
			return "S";
		case 19:
			return "T";
		case 20:
			return "U";
		case 21:
			return "V";
		case 22:
			return "W";
		case 23:
			return "X";
		case 24:
			return "Y";
		case 25:
			return "Z";
		default:
			return "A";
		}
	}
}
