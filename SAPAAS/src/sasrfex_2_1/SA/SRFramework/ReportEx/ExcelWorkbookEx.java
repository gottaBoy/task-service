/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.poi.hssf.usermodel.HSSFRow
 *  org.apache.poi.hssf.usermodel.HSSFSheet
 *  org.apache.poi.hssf.usermodel.HSSFWorkbook
 */
package SA.SRFramework.ReportEx;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelWorkbookEx {
    protected HSSFWorkbook workbook = null;
    protected OutputStream outputstream = null;
    protected Hashtable<String, HSSFRow> templateRowContainer = new Hashtable();

    public ExcelWorkbookEx(OutputStream outputStream) {
        try {
            this.outputstream = outputStream;
        }
        catch (Exception ex) {
            this.workbook = null;
        }
    }

    public ExcelWorkbookEx(OutputStream outputStream, String strTemplatePath) {
        try {
            FileInputStream inputStream = new FileInputStream(strTemplatePath);
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook((InputStream)inputStream);
            if (this.workbook == null) {
                this.workbook = hssfWorkbook;
                this.CopyExcelTemplateRow(hssfWorkbook);
            }
            this.outputstream = outputStream;
        }
        catch (Exception ex) {
            this.workbook = null;
        }
    }

    protected boolean CopyExcelTemplateRow(HSSFWorkbook hssfWorkbook) {
        if (hssfWorkbook == null || hssfWorkbook.getNumberOfSheets() <= 0) {
            return false;
        }
        this.templateRowContainer.clear();
        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
        Iterator iterator = hssfSheet.rowIterator();
        while (iterator.hasNext()) {
            HSSFRow hssfRow = (HSSFRow)iterator.next();
            if (hssfRow == null) continue;
            this.templateRowContainer.put(String.valueOf(hssfRow.getRowNum()), hssfRow);
        }
        return true;
    }

    @Deprecated
    public HSSFWorkbook getWritableWorkbook() {
        return this.workbook;
    }

    public void setHSSFWorkbook(HSSFWorkbook hssfWorkbook) {
        boolean bCopySuccess = this.CopyExcelTemplateRow(hssfWorkbook);
        if (!bCopySuccess) {
            System.out.println("\u590d\u5236\u6a21\u677f\u884c\u5931\u8d25\uff01");
        }
        this.workbook = hssfWorkbook;
    }

    public HSSFWorkbook getHSSFWorkbook() {
        return this.workbook;
    }

    @Deprecated
    public void Close() {
        try {
            if (this.workbook != null) {
                this.workbook.write(this.outputstream);
                this.outputstream.close();
            }
            this.workbook = null;
        }
        catch (Exception ex) {
            this.workbook = null;
        }
    }

    public boolean Export(OutputStream os) {
        if (this.workbook == null) {
            System.out.println("ExcelWorkBook \u4e3a\u7a7a\u5bf9\u8c61,\u505c\u6b62\u8f93\u51fa\uff01");
            return false;
        }
        try {
            this.workbook.write(os);
            os.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.workbook = null;
        return true;
    }

    @Deprecated
    public HSSFSheet getWritableSheet(String strSheetName) {
        if (this.workbook == null) {
            return null;
        }
        HSSFSheet sheet = this.workbook.getSheet(strSheetName);
        if (sheet == null) {
            return sheet;
        }
        sheet = this.workbook.createSheet(strSheetName);
        return sheet;
    }

    public HSSFSheet getHSSfSheetByName(String strSheetName) {
        if (this.workbook == null) {
            return null;
        }
        HSSFSheet sheet = this.workbook.getSheet(strSheetName);
        if (sheet == null) {
            return sheet;
        }
        sheet = this.workbook.createSheet(strSheetName);
        return sheet;
    }
}

