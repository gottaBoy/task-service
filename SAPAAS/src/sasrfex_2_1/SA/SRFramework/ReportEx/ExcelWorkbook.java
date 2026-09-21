/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  jxl.Workbook
 *  jxl.write.WritableSheet
 *  jxl.write.WritableWorkbook
 */
package SA.SRFramework.ReportEx;

import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.io.OutputStream;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelWorkbook {
    protected WritableWorkbook workbook = null;

    public ExcelWorkbook(OutputStream outputStream) {
        try {
            this.workbook = Workbook.createWorkbook((OutputStream)outputStream);
        }
        catch (Exception ex) {
            this.workbook = null;
        }
    }

    public ExcelWorkbook(OutputStream outputStream, String strTemplatePath) {
        try {
            File file = new File(strTemplatePath);
            Workbook srcWorkbook = Workbook.getWorkbook((File)file);
            this.workbook = Workbook.createWorkbook((OutputStream)outputStream, (Workbook)srcWorkbook);
            srcWorkbook.close();
        }
        catch (Exception ex) {
            this.workbook = null;
        }
    }

    public WritableWorkbook getWritableWorkbook() {
        return this.workbook;
    }

    public void Close() {
        try {
            if (this.workbook != null) {
                this.workbook.write();
                this.workbook.close();
            }
            this.workbook = null;
        }
        catch (Exception ex) {
            this.workbook = null;
        }
    }

    public WritableSheet getWritableSheet(String strSheetName) {
        if (this.workbook == null) {
            return null;
        }
        String[] strNames = this.workbook.getSheetNames();
        int i = 0;
        while (i < strNames.length) {
            if (StringHelper.Compare((String)strNames[i], (String)strSheetName, (boolean)false) == 0) {
                return this.workbook.getSheet(strSheetName);
            }
            ++i;
        }
        WritableSheet sheet = this.workbook.createSheet(strSheetName, strNames.length);
        return sheet;
    }
}

