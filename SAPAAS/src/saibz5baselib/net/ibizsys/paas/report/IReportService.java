/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.report;

import java.util.Iterator;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IDataEntityObject;
import net.ibizsys.paas.web.IWebContext;
import net.sf.json.JSONArray;
import org.hibernate.SessionFactory;

public interface IReportService
extends IDataEntityObject {
    public static final String CONTENTTYPE_PDF = "PDF";
    public static final String CONTENTTYPE_HTML = "HTML";
    public static final String CONTENTTYPE_EXCEL = "EXCEL";

    public void init(IDataEntity var1) throws Exception;

    public String getAccessKey();

    public String getReportFilePath();

    public String getDEDataSetName();

    public boolean isEnableLog();

    public String getReportFile(IWebContext var1, SessionFactory var2, String var3, String var4) throws Exception;

    public Iterator<String> getSubReportIds();

    public boolean hasSubReport();

    public String getCodeListText(String var1, String var2) throws Exception;

    public String getJSONArrayText(Object var1);

    public String getJSONArrayText(Object var1, String var2, String var3, String var4);

    public String getJSONArrayText(JSONArray var1);

    public String getJSONArrayText(JSONArray var1, String var2, String var3, String var4);
}

