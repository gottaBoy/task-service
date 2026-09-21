/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.report;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IDataEntityObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.web.IWebContext;
import org.hibernate.SessionFactory;

public interface IPrintService
extends IDataEntityObject {
    public static final String CONTENTTYPE_PDF = "PDF";
    public static final String CONTENTTYPE_HTML = "HTML";
    public static final String CONTENTTYPE_EXCEL = "EXCEL";

    public void init(IDataEntity var1) throws Exception;

    public IDataEntityModel getDEModel();

    public String getDEDataSetName();

    public String getDetailDEDataSetName();

    public String getDetailDEName();

    public boolean isEnableColPriv();

    public boolean isEnableLog();

    public boolean isEnableMulitPrint();

    public String getGetDataDEActionName();

    public String getGetDataDataAccessAction();

    public String getReportFilePath();

    public String getPrintFile(String var1, IWebContext var2, SessionFactory var3, String var4, String var5) throws Exception;

    public String getCodeListText(String var1, String var2) throws Exception;
}

