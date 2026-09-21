/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.cache.TemplateLoader
 *  freemarker.template.Configuration
 *  freemarker.template.Template
 *  freemarker.template.TemplateException
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.util.freemarker;

import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.core.IDEDataQueryCode;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.util.freemarker.DEFieldExpMethod;
import net.ibizsys.paas.util.freemarker.DataContextMethod;
import net.ibizsys.paas.util.freemarker.SessionContextMethod;
import net.ibizsys.paas.util.freemarker.SimpleTemplateLoader;
import net.ibizsys.paas.util.freemarker.SystemContextMethod;
import net.ibizsys.paas.util.freemarker.WebContextMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class SqlCodeHelper {
    private static final Log log = LogFactory.getLog(SqlCodeHelper.class);
    private static ThreadLocal<SqlParamList> sqlParamListParam = new ThreadLocal();
    private static ThreadLocal<SessionFactory> sessionFactoryParam = new ThreadLocal();
    private static DataContextMethod dataContextMethod = new DataContextMethod();
    private static SessionContextMethod sessionContextMethod = new SessionContextMethod();
    private static SystemContextMethod systemContextMethod = new SystemContextMethod();
    private static WebContextMethod webContextMethod = new WebContextMethod();
    private Map<String, Object> params = new HashMap<String, Object>();
    private Configuration config = new Configuration();
    private Template template = null;

    public void init(IDEDataQueryCode iDEDataQueryCode, String strCode) throws Exception {
        SimpleTemplateLoader deTemplateLoader = new SimpleTemplateLoader(strCode);
        this.config.setTemplateLoader((TemplateLoader)deTemplateLoader);
        this.params.put("srfdatacontext", dataContextMethod);
        this.params.put("srfsessioncontext", sessionContextMethod);
        this.params.put("srfsessionvalue", sessionContextMethod);
        this.params.put("srfsystemcontext", systemContextMethod);
        this.params.put("srfwebcontext", webContextMethod);
        if (iDEDataQueryCode != null) {
            this.params.put("srfdefieldexp", new DEFieldExpMethod(iDEDataQueryCode));
        }
        this.template = this.config.getTemplate("");
    }

    public String generateCode(SqlParamList sqlParamList, SessionFactory sessionFactory) throws Exception {
        sqlParamListParam.set(sqlParamList);
        sessionFactoryParam.set(sessionFactory);
        try {
            StringWriter sw = new StringWriter();
            this.template.process(this.params, (Writer)sw);
            sqlParamListParam.set(null);
            sessionFactoryParam.set(null);
            return sw.toString();
        }
        catch (IOException e) {
            sqlParamListParam.set(null);
            sessionFactoryParam.set(null);
            throw new Exception(e);
        }
        catch (TemplateException e) {
            sqlParamListParam.set(null);
            sessionFactoryParam.set(null);
            throw new Exception(e);
        }
    }

    public static SqlParamList getCurrentSqlParamList() {
        return sqlParamListParam.get();
    }

    public static SessionFactory getCurrentSessionFactory() {
        return sessionFactoryParam.get();
    }
}

