/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jxl.Workbook
 *  jxl.write.Label
 *  jxl.write.WritableCell
 *  jxl.write.WritableSheet
 *  jxl.write.WritableWorkbook
 */
package net.ibizsys.paas.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;

public class DEDataImportTemplateHelper {
    public static void output(IDataEntityModel iDEModel, String strFile) throws Exception {
        WritableWorkbook workbook = Workbook.createWorkbook((File)new File(strFile));
        WritableSheet s1 = workbook.createSheet(StringHelper.format("[%1$s]\u5bfc\u5165\u683c\u5f0f", iDEModel.getLogicName()), 0);
        WritableSheet s2 = workbook.createSheet("\u5c5e\u6027\u8bf4\u660e", 1);
        ArrayList<IDEField> list = new ArrayList<IDEField>();
        int nRowIndex = 0;
        int nCellIndex = 0;
        Iterator<IDEField> deFields = iDEModel.getDEFields();
        while (deFields.hasNext()) {
            IDEField iDEField = deFields.next();
            if (iDEField.getImportOrder() == -1) continue;
            list.add(iDEField);
        }
        Collections.sort(list, new Comparator<IDEField>(){

            @Override
            public int compare(IDEField o1, IDEField o2) {
                return o1.getImportOrder() - o2.getImportOrder();
            }
        });
        for (IDEField iDEField : list) {
            Label l = new Label(nCellIndex, nRowIndex, StringHelper.format("%1$s", iDEField.getImportTag()));
            s1.addCell((WritableCell)l);
            s1.setColumnView(nCellIndex, 20);
            ++nCellIndex;
        }
        nRowIndex = 0;
        Label l = new Label(0, nRowIndex, "\u5bfc\u5165\u540d\u79f0");
        s2.addCell((WritableCell)l);
        s2.setColumnView(0, 20);
        Label l2 = new Label(1, nRowIndex, "\u6570\u636e\u7c7b\u578b");
        s2.addCell((WritableCell)l2);
        s2.setColumnView(2, 40);
        Label l3 = new Label(2, nRowIndex, "\u8bf4\u660e");
        s2.addCell((WritableCell)l3);
        s2.setColumnView(3, 40);
        nRowIndex = 1;
        for (IDEField iDEField : list) {
            Label l4 = new Label(0, nRowIndex, iDEField.getImportTag());
            s2.addCell((WritableCell)l4);
            String strDataType = DataTypeHelper.getTypeName(iDEField.getStdDataType());
            Label l22 = new Label(1, nRowIndex, strDataType);
            s2.addCell((WritableCell)l22);
            String strDescription = iDEField.getMemo();
            if (StringHelper.isNullOrEmpty(strDescription)) {
                strDescription = iDEField.getLogicName();
            }
            Label l32 = new Label(2, nRowIndex, strDescription);
            s2.addCell((WritableCell)l32);
            ++nRowIndex;
        }
        workbook.write();
        workbook.close();
    }
}

