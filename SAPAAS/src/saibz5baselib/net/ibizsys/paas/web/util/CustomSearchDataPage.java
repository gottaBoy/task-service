/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web.util;

import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.Page;
import net.sf.json.JSONObject;

public class CustomSearchDataPage
extends Page {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
        long startTime = System.currentTimeMillis();
        try {
            JSONObject jo = new JSONObject();
            String strDEName = this.getWebContext().getPostValue("dename");
            IDataEntityModel iDEModel = DEModelGlobal.getDEModel(strDEName);
            JSONObject fieldArray = new JSONObject();
            JSONObject codeListArray = new JSONObject();
            Iterator<IDEField> iDEFields = iDEModel.getDEFields();
            while (iDEFields.hasNext()) {
                IDEField iDEFieldModel = iDEFields.next();
                String strDEFName = iDEFieldModel.getName();
                if (!this.isAccessDEField(strDEName, strDEFName)) continue;
                String strDataType = this.getDEFDataType(iDEModel, iDEFieldModel);
                String strCodeListId = iDEFieldModel.getCodeListId();
                if (!StringHelper.isNullOrEmpty(strCodeListId)) {
                    ICodeList iCodeList = CodeListGlobal.getCodeList(strCodeListId);
                    Iterator<ICodeItem> codeItems = iCodeList.getCodeItems();
                    while (codeItems.hasNext()) {
                        JSONObject codeItemArray = new JSONObject();
                        ICodeItem codeItem = codeItems.next();
                        codeItemArray.put("value", JSONObjectHelper.stripQuotes(codeItem.getValue(), true));
                        codeItemArray.put("text", JSONObjectHelper.stripQuotes(codeItem.getText(), true));
                        codeItemArray.put("realtext", JSONObjectHelper.stripQuotes(codeItem.getText(), true));
                        codeListArray.put(strDEFName, (Object)codeItemArray);
                    }
                }
                JSONObject joDEField = new JSONObject();
                joDEField.put("defid", JSONObjectHelper.stripQuotes(strDEFName, true));
                joDEField.put("defname", JSONObjectHelper.stripQuotes(iDEFieldModel.getLogicName(), true));
                joDEField.put("stddatatype", JSONObjectHelper.stripQuotes(strDataType, true));
                joDEField.put("condtype", (Object)"DEFIELD");
                fieldArray.put(strDEFName, (Object)joDEField);
                JSONObject codeListFieldArr = new JSONObject();
                codeListFieldArr.put("value", JSONObjectHelper.stripQuotes(strDEFName, true));
                codeListFieldArr.put("text", JSONObjectHelper.stripQuotes(iDEFieldModel.getLogicName(), true));
                codeListFieldArr.put("realtext", JSONObjectHelper.stripQuotes(iDEFieldModel.getLogicName(), true));
                codeListArray.put(strDEName, (Object)codeListFieldArr);
            }
            jo.put("defieldArr", (Object)fieldArray);
            jo.put("codeListArr", (Object)codeListArray);
            this.getResponse().getWriter().write(jo.toString());
        }
        catch (Exception jo) {
            // empty catch block
        }
        long endTime = System.currentTimeMillis();
        float seconds = (float)(endTime - startTime) / 1000.0f;
    }

    public String getDEFDataType(IDataEntityModel iDEModel, IDEField iDEField) {
        String strDadaType = iDEField.getDataType();
        try {
            if (StringHelper.compare(strDadaType, "PICKUPDATA", true) == 0) {
                String strDERName = iDEField.getDERName();
                String strLinkDEFName = iDEField.getLinkDEFName();
                Iterator<IDERBase> iDERs = iDEModel.getDERs(false);
                while (iDERs.hasNext()) {
                    String strMajorDEId;
                    IDataEntityModel majorDEModel;
                    IDERBase iDER = iDERs.next();
                    String strMajorDERName = iDER.getName();
                    if (StringHelper.compare(strDERName, strMajorDERName, true) != 0 || (majorDEModel = DEModelGlobal.getDEModel(strMajorDEId = iDER.getMajorDEId())) == null) continue;
                    Iterator<IDEField> majorDEFields = majorDEModel.getDEFields();
                    while (majorDEFields.hasNext()) {
                        IDEField majorDEField = majorDEFields.next();
                        if (StringHelper.compare(majorDEField.getName(), strLinkDEFName, true) != 0) continue;
                        strDadaType = this.getDEFDataType(majorDEModel, majorDEField);
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return strDadaType;
    }

    protected boolean isAccessDEField(String strDEName, String strDEFName) throws Exception {
        boolean bAccess = true;
        if (StringHelper.compare(strDEFName, "ENABLE", true) == 0) {
            bAccess = false;
        }
        return bAccess;
    }
}

