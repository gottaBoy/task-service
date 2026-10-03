package net.ibizsys.paas.report.util;

import java.io.FileOutputStream;
import java.util.ArrayList;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

import net.ibizsys.paas.util.StringHelper;

/**
 * PDF打印辅助对象
 * 
 * @author Administrator
 *
 */
public class PDFPrintHelper {
	protected String strDestPdfURL = "";
	protected ArrayList<String> arrMergePdfURL = null;
	protected String strPrintMode = PrintDialogModes.NONE;
	protected Document mergedPdfDocument = null;
	protected PdfCopy pdfCopy = null;

	/**
	 * @param strDestPdfURL
	 * @param arrMergePdfURL
	 */
	public PDFPrintHelper(String strDestPdfURL, ArrayList<String> arrMergePdfURL) {
		this.strDestPdfURL = strDestPdfURL;
		this.arrMergePdfURL = arrMergePdfURL;
		this.mergedPdfDocument = new Document();
	}

	/**
	 * @param strDestPdfURL
	 * @param arrMergePdfURL
	 * @param strPrintMode
	 */
	public PDFPrintHelper(String strDestPdfURL, ArrayList<String> arrMergePdfURL, String strPrintMode) {
		this.strDestPdfURL = strDestPdfURL;
		this.arrMergePdfURL = arrMergePdfURL;
		this.strPrintMode = strPrintMode;
		this.mergedPdfDocument = new Document();
	}

	/**
	 * 附加打印并关闭操作，取保pdf设置已启用javascript菜单执行权限
	 * 
	 * @param strPrintMode -1 no print action; 0 print with dialog prompt 3 print silent;
	 */
	public void setPrintMode(String strPrintMode) //
	{
		if (pdfCopy == null) {
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
		pdfCopy.addJavaScript(StringHelper.format("this.print(%1$s);", String.valueOf(!bPrintSilent)));
		if (bClose) {
			pdfCopy.addJavaScript("app.execMenuItem('Close');");
		}
	}

	/**
	 * 执行合并操作
	 * 
	 * @throws Exception
	 */
	public void doMerge() throws Exception {
		pdfCopy = new PdfCopy(mergedPdfDocument, new FileOutputStream(strDestPdfURL));
		pdfCopy.setViewerPreferences(PdfWriter.PageModeUseOutlines);
		mergedPdfDocument.open();
		for (String strMergePdfURL : arrMergePdfURL) {
			PdfReader pdfReader = new PdfReader(strMergePdfURL);
			int nPageNum = pdfReader.getNumberOfPages();
			for (int i = 1; i <= nPageNum; i++) {
				PdfImportedPage pdfImportedPage = pdfCopy.getImportedPage(pdfReader, i);
				pdfCopy.addPage(pdfImportedPage);
			}
			pdfReader.close();
		}
		setPrintMode(strPrintMode);
		mergedPdfDocument.close();
	}

	/**
	 * 关闭释放资源
	 */
	public void close() {
		if (pdfCopy != null) {
			pdfCopy.close();
		}
		if (mergedPdfDocument != null) {
			mergedPdfDocument.close();
		}
	}
}
