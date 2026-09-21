/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lowagie.text.Document
 *  com.lowagie.text.pdf.PdfCopy
 *  com.lowagie.text.pdf.PdfImportedPage
 *  com.lowagie.text.pdf.PdfReader
 */
package net.ibizsys.paas.report.util;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import net.ibizsys.paas.report.util.PrintDialogModes;
import net.ibizsys.paas.util.StringHelper;

public class PDFPrintHelper {
    protected String strDestPdfURL = "";
    protected ArrayList<String> arrMergePdfURL = null;
    protected String strPrintMode = PrintDialogModes.NONE;
    protected Document mergedPdfDocument = null;
    protected PdfCopy pdfCopy = null;

    public PDFPrintHelper(String strDestPdfURL, ArrayList<String> arrMergePdfURL) {
        this.strDestPdfURL = strDestPdfURL;
        this.arrMergePdfURL = arrMergePdfURL;
        this.mergedPdfDocument = new Document();
    }

    public PDFPrintHelper(String strDestPdfURL, ArrayList<String> arrMergePdfURL, String strPrintMode) {
        this.strDestPdfURL = strDestPdfURL;
        this.arrMergePdfURL = arrMergePdfURL;
        this.strPrintMode = strPrintMode;
        this.mergedPdfDocument = new Document();
    }

    public void setPrintMode(String strPrintMode) {
        if (this.pdfCopy == null) {
            System.err.println("PdfCopy is null!");
            return;
        }
        boolean bClose = false;
        boolean bPrintSilent = false;
        if (StringHelper.isNullOrEmpty(strPrintMode) || strPrintMode.equalsIgnoreCase(PrintDialogModes.NONE)) {
            return;
        }
        if (strPrintMode.equalsIgnoreCase(PrintDialogModes.PROMPTANDCLOSE) || strPrintMode.equalsIgnoreCase(PrintDialogModes.SILENTANDCLOSE)) {
            bClose = true;
        }
        if (strPrintMode.equalsIgnoreCase(PrintDialogModes.SILENT) || strPrintMode.equalsIgnoreCase(PrintDialogModes.SILENTANDCLOSE)) {
            bPrintSilent = true;
        }
        this.pdfCopy.addJavaScript(StringHelper.format("this.print(%1$s);", String.valueOf(!bPrintSilent)));
        if (bClose) {
            this.pdfCopy.addJavaScript("app.execMenuItem('Close');");
        }
    }

    public void doMerge() throws Exception {
        this.pdfCopy = new PdfCopy(this.mergedPdfDocument, (OutputStream)new FileOutputStream(this.strDestPdfURL));
        this.pdfCopy.setViewerPreferences(128);
        this.mergedPdfDocument.open();
        for (String strMergePdfURL : this.arrMergePdfURL) {
            PdfReader pdfReader = new PdfReader(strMergePdfURL);
            int nPageNum = pdfReader.getNumberOfPages();
            int i = 1;
            while (i <= nPageNum) {
                PdfImportedPage pdfImportedPage = this.pdfCopy.getImportedPage(pdfReader, i);
                this.pdfCopy.addPage(pdfImportedPage);
                ++i;
            }
            pdfReader.close();
        }
        this.setPrintMode(this.strPrintMode);
        this.mergedPdfDocument.close();
    }

    public void close() {
        if (this.pdfCopy != null) {
            this.pdfCopy.close();
        }
        if (this.mergedPdfDocument != null) {
            this.mergedPdfDocument.close();
        }
    }
}

