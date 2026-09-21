/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.jasperreports.engine.JasperPrint
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.report.jr;

import java.util.List;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.report.IReportService;
import net.ibizsys.paas.web.IWebContext;
import net.sf.jasperreports.engine.JasperPrint;
import org.hibernate.SessionFactory;

public interface IJRReportService
extends IReportService {
    public List<JasperPrint> getReportJasperPrints(IEntity var1, IWebContext var2, SessionFactory var3, String var4, String var5) throws Exception;
}

