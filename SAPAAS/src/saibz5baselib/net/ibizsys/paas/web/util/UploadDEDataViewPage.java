/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.web.util;

import java.util.Date;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.DEDataImportTemplateHelper;
import net.ibizsys.paas.util.FileHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.Page;
import net.ibizsys.paas.web.WebContext;

public class UploadDEDataViewPage
extends Page {
    protected String strUpdateDataActionPath = "uploaddedata.jsp";
    protected String strTemplDownloadPath = "exportexcel.jsp";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        String strDEId = WebContext.getDEId(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strDEId)) {
            throw new Exception(StringHelper.format("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u7f16\u53f7"));
        }
        IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(strDEId);
        this.setDEModel(iDataEntityModel);
        String strDEDataImport = WebContext.getDEDataImport(this.getWebContext());
        StringHelper.isNullOrEmpty(strDEDataImport);
        String strTempFileName = StringHelper.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", new Date());
        String strTempFilePath = FileHelper.getTmpFileName(this.getWebContext(), strTempFileName, ".xls");
        DEDataImportTemplateHelper.output(this.getDEModel(), strTempFilePath);
        this.strTemplDownloadPath = WebUtility.appendURLSeperator(this.strTemplDownloadPath);
        this.strTemplDownloadPath = StringHelper.format("%1$sFILEID=%2$s", this.strTemplDownloadPath, WebUtility.encodeURLParamValue(strTempFileName));
        this.strUpdateDataActionPath = WebUtility.appendURLSeperator(this.strUpdateDataActionPath);
        this.strUpdateDataActionPath = String.valueOf(this.strUpdateDataActionPath) + this.getWebContext().getQueryString();
    }

    public String outputDELogicName() {
        return this.getDEModel().getLogicName(this.getLocalization());
    }

    public String outputDataActionPath() {
        return this.strUpdateDataActionPath;
    }

    public String outputTemplPath() {
        return this.strTemplDownloadPath;
    }
}

