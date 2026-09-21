/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  jxl.biff.FontRecord
 *  jxl.write.WritableCellFormat
 *  jxl.write.WritableFont
 */
package SA.SRFramework.ReportEx;

import SA.SRFramework.Utility.StringHelper;
import java.util.TreeMap;
import jxl.biff.FontRecord;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;

public class ExcelCellFormatHelper {
    public static final String TAG_BACKGROUND = "BACKGROUND";
    public static final String TAG_FONT_SIZE = "font-size";
    public static final String TAG_FONT_NAME = "font-name";
    public static final String TAG_FONT_WEIGHT = "font-weight";
    public static final String TAG_FONT_STYLE = "font-style";

    public static WritableCellFormat FillCellFormat(WritableCellFormat writableCellFormat, String strCellFormat) {
        if (writableCellFormat == null) {
            writableCellFormat = new WritableCellFormat();
        }
        String[] parts = StringHelper.Split((String)strCellFormat, (char)';');
        TreeMap<String, String> properties = new TreeMap<String, String>();
        int i = 0;
        while (i < parts.length) {
            String strPart = parts[i];
            String[] params = StringHelper.Split((String)strPart, (char)':');
            if (params.length == 2) {
                properties.put(params[0].toLowerCase(), params[1]);
            }
            ++i;
        }
        ExcelCellFormatHelper.SetFont(writableCellFormat, properties);
        return writableCellFormat;
    }

    protected static void SetFont(WritableCellFormat writableCellFormat, TreeMap<String, String> properties) {
        try {
            String strFontName = ExcelCellFormatHelper.GetProperty(properties, TAG_FONT_NAME, "Arial");
            int strFontSize = ExcelCellFormatHelper.GetProperty(properties, TAG_FONT_SIZE, 10);
            String strBold = ExcelCellFormatHelper.GetProperty(properties, TAG_FONT_WEIGHT, "normal");
            WritableFont writableFont = new WritableFont(WritableFont.createFont((String)strFontName), strFontSize);
            writableFont.setPointSize(strFontSize);
            if (StringHelper.Compare((String)strBold, (String)"BOLD", (boolean)true) == 0) {
                writableFont.setBoldStyle(WritableFont.BOLD);
            } else {
                writableFont.setBoldStyle(WritableFont.NO_BOLD);
            }
            writableCellFormat.setFont((FontRecord)writableFont);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void SetBackground(WritableCellFormat writableCellFormat, String strValue) {
    }

    protected static String GetProperty(TreeMap<String, String> properties, String strKey, String strDefault) {
        if (properties.containsKey(strKey)) {
            return properties.get(strKey);
        }
        return strDefault;
    }

    protected static int GetProperty(TreeMap<String, String> properties, String strKey, int nDefault) {
        if (properties.containsKey(strKey)) {
            String strDefault = properties.get(strKey);
            try {
                return Integer.parseInt(strDefault);
            }
            catch (Exception ex) {
                return nDefault;
            }
        }
        return nDefault;
    }

    protected static double GetProperty(TreeMap<String, String> properties, String strKey, double fDefault) {
        if (properties.containsKey(strKey)) {
            String strDefault = properties.get(strKey);
            try {
                return Double.parseDouble(strDefault);
            }
            catch (Exception ex) {
                return fDefault;
            }
        }
        return fDefault;
    }

    protected static boolean GetProperty(TreeMap<String, String> properties, String strKey, boolean bDefault) {
        if (properties.containsKey(strKey)) {
            String strDefault = properties.get(strKey);
            try {
                return Boolean.parseBoolean(strDefault);
            }
            catch (Exception ex) {
                return bDefault;
            }
        }
        return bDefault;
    }
}

