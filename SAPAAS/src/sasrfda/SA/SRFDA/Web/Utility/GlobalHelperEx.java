/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.WebEx.Utility.ContextHelper
 *  javax.servlet.ServletContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web.Utility;

import SA.SRFDA.CodeList.DACodeListMgr;
import SA.SRFDA.Common.DAConfigMgr;
import SA.SRFDA.Ctrl.DEDCProcessStorage;
import SA.SRFDA.Ctrl.Data.Registry;
import SA.SRFDA.Ctrl.DataNotify.IDataNotifyHelper;
import SA.SRFDA.Ctrl.IDAConfigHelper;
import SA.SRFDA.Ctrl.IDAMBConfigHelper;
import SA.SRFDA.Ctrl.IDAModelHelper;
import SA.SRFDA.Ctrl.IDAModelStorage;
import SA.SRFDA.Ctrl.IDEDataCtrlHelper;
import SA.SRFDA.Ctrl.RegisterMgr;
import SA.SRFDA.Ctrl.ServiceMgr;
import SA.SRFDA.Model.IDAFormItemHelper;
import SA.SRFDA.Security.IPasswordStorage;
import SA.SRFDA.Security.PasswordStorageFactory;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFDA.Web.Utility.ISRFDAPOLogger;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.Utility.ContextHelper;
import java.util.TreeMap;
import javax.servlet.ServletContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GlobalHelperEx
extends ContextHelper
implements ISRFDAGlobalHelper {
    protected RegisterMgr registerMgr = new RegisterMgr(this);
    protected int nDAModelVersion = -1;
    protected TreeMap<String, IDAConfigHelper> daConfigHelperMap = new TreeMap();
    protected TreeMap<String, IDAMBConfigHelper> daMBConfigHelperMap = new TreeMap();
    private static final Log log = LogFactory.getLog(GlobalHelperEx.class);
    private IDataNotifyHelper iDataNotifyHelper = null;
    private static ISRFDAGlobalHelper inst = null;
    private IDAModelStorage iDAModelStorage = null;
    private String strAppMode = null;
    private DAConfigMgr daConfigMgr = null;
    private IDAModelHelper iDAModelHelper = null;
    private IDAFormItemHelper iDAFormItemHelper = null;
    private DACodeListMgr daCodeListMgr = null;
    private DEDCProcessStorage deDCProcessStorage = null;
    private ISRFDAPOLogger iSRFDAPOLogger = null;

    public static GlobalHelperEx From(ContextHelper contextHelper) {
        if (contextHelper instanceof GlobalHelperEx) {
            return (GlobalHelperEx)contextHelper;
        }
        return (GlobalHelperEx)contextHelper.getServletContext().getAttribute("SRFDACONTEXTHELPER");
    }

    public GlobalHelperEx(ServletContext servletContext) {
        super(servletContext);
    }

    @Override
    public final DAConfigMgr getDAConfigMgr() {
        if (this.daConfigMgr == null) {
            this.daConfigMgr = (DAConfigMgr)((Object)this.getServletContext().getAttribute("SRFDACONFIGMGR"));
        }
        return this.daConfigMgr;
    }

    @Override
    public final IDAModelStorage getDAModelStorage() {
        if (this.iDAModelStorage != null) {
            return this.iDAModelStorage;
        }
        this.iDAModelStorage = (IDAModelStorage)this.getServletContext().getAttribute("SRFDAMODELSTORAGE");
        return this.iDAModelStorage;
    }

    @Override
    public final IDEDataCtrlHelper getDEDataCtrlHelper() {
        return (IDEDataCtrlHelper)this.getServletContext().getAttribute("SRFDADEDATACTRLHELPER");
    }

    @Override
    public IDEDataCtrlHelper getDEDataCtrlHelper(String strDBStorage) {
        String strKey = "";
        strKey = StringHelper.IsNullOrEmpty((String)strDBStorage) ? "SRFDADEDATACTRLHELPER" : StringHelper.Format((String)"%1$s:%2$s", (Object)"SRFDADEDATACTRLHELPER", (Object)strDBStorage);
        return (IDEDataCtrlHelper)this.getServletContext().getAttribute(strKey);
    }

    @Override
    public final IDAModelHelper getDAModelHelper() {
        if (this.iDAModelHelper == null) {
            this.iDAModelHelper = (IDAModelHelper)this.getServletContext().getAttribute("SRFDAMODELHELPER");
        }
        return this.iDAModelHelper;
    }

    @Override
    public final IDAFormItemHelper getDAFormItemHelper() {
        if (this.iDAFormItemHelper == null) {
            this.iDAFormItemHelper = (IDAFormItemHelper)this.getServletContext().getAttribute("SRFDAFORMITEMHELPER");
        }
        return this.iDAFormItemHelper;
    }

    @Override
    public final DACodeListMgr getCodeListMgr() {
        if (this.daCodeListMgr == null) {
            this.daCodeListMgr = (DACodeListMgr)((Object)this.servletContext.getAttribute("CODELIST"));
        }
        return this.daCodeListMgr;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final IDAConfigHelper getDAConfigHelper(String strLanguage, String strPageModel) {
        String strKey = StringHelper.Format((String)"%1$s|%2$s", (Object)strLanguage, (Object)strPageModel);
        TreeMap<String, IDAConfigHelper> treeMap = this.daConfigHelperMap;
        synchronized (treeMap) {
            if (this.daConfigHelperMap.containsKey(strKey)) {
                return this.daConfigHelperMap.get(strKey);
            }
        }
        String strDAConfigHelperObject = this.getWebExConfig().GetValue("SRFDA", "DACONFIGHELPER", "SA.SRFDA.Ctrl.DAConfigHelper");
        Object objDAConfigHelper = ObjectHelper.Create((String)strDAConfigHelperObject);
        if (objDAConfigHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5b9e\u4f53\u914d\u7f6e\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)strDAConfigHelperObject));
            return null;
        }
        if (!(objDAConfigHelper instanceof IDAConfigHelper)) {
            log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53\u914d\u7f6e\u8f85\u52a9\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strDAConfigHelperObject));
            return null;
        }
        IDAConfigHelper iDAConfigHelper = (IDAConfigHelper)objDAConfigHelper;
        iDAConfigHelper.Init(this, strLanguage, strPageModel);
        TreeMap<String, IDAConfigHelper> treeMap2 = this.daConfigHelperMap;
        synchronized (treeMap2) {
            this.daConfigHelperMap.put(strKey, iDAConfigHelper);
        }
        return iDAConfigHelper;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final IDAMBConfigHelper getDAMBConfigHelper(String strLanguage, String strPageModel) throws Exception {
        String strKey = StringHelper.Format((String)"%1$s|%2$s", (Object)strLanguage, (Object)strPageModel);
        TreeMap<String, IDAMBConfigHelper> treeMap = this.daMBConfigHelperMap;
        synchronized (treeMap) {
            if (this.daMBConfigHelperMap.containsKey(strKey)) {
                return this.daMBConfigHelperMap.get(strKey);
            }
        }
        String strDAMBConfigHelperObject = this.getWebExConfig().GetValue("SRFDA", "DAMBCONFIGHELPER", "SA.SRFDA.Mobile.Ctrl.DAMBConfigHelper");
        Object objDAMBConfigHelper = ObjectHelper.Create((String)strDAMBConfigHelperObject);
        if (objDAMBConfigHelper == null) {
            String strErrorInfo = StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5b9e\u4f53\u79fb\u52a8\u5e94\u7528\u914d\u7f6e\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)strDAMBConfigHelperObject);
            log.error((Object)strErrorInfo);
            throw new Exception(strErrorInfo);
        }
        if (!(objDAMBConfigHelper instanceof IDAMBConfigHelper)) {
            String strErrorInfo = StringHelper.Format((String)"\u5b9e\u4f53\u79fb\u52a8\u5e94\u7528\u914d\u7f6e\u8f85\u52a9\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strDAMBConfigHelperObject);
            log.error((Object)strErrorInfo);
            throw new Exception(strErrorInfo);
        }
        IDAMBConfigHelper iDAMBConfigHelper = (IDAMBConfigHelper)objDAMBConfigHelper;
        iDAMBConfigHelper.Init(this, strLanguage, strPageModel);
        TreeMap<String, IDAMBConfigHelper> treeMap2 = this.daMBConfigHelperMap;
        synchronized (treeMap2) {
            this.daMBConfigHelperMap.put(strKey, iDAMBConfigHelper);
        }
        return iDAMBConfigHelper;
    }

    @Override
    public final int getDAModelVersion() {
        String strValue;
        if (this.nDAModelVersion != -1) {
            return this.nDAModelVersion;
        }
        Registry register = this.getRegisterMgr().GetRegistry("SRFDA", "DAMODEL");
        if (register != null && !StringHelper.IsNullOrEmpty((String)(strValue = register.GetParam("VERSION", "")))) {
            this.nDAModelVersion = Integer.parseInt(strValue);
        }
        if (this.nDAModelVersion == -1) {
            this.nDAModelVersion = this.getWebExConfig().GetValue("SRFDA", "DAMODEL", 99999999);
        }
        return this.nDAModelVersion;
    }

    @Override
    public String getDAModelDB() {
        return this.getWebExConfig().GetValue("SRFDA", "DAMODELDB", "DB2");
    }

    @Override
    public DEDCProcessStorage getDEDCProcessStorage() {
        if (this.deDCProcessStorage != null) {
            return this.deDCProcessStorage;
        }
        this.deDCProcessStorage = (DEDCProcessStorage)this.servletContext.getAttribute("SRFDADEDCPROCESSSTORAGE");
        return this.deDCProcessStorage;
    }

    @Override
    public final RegisterMgr getRegisterMgr() {
        return this.registerMgr;
    }

    @Override
    public final ServiceMgr getServiceMgr() {
        return (ServiceMgr)this.servletContext.getAttribute("SRFDASERVICEMGR");
    }

    @Override
    public final ISRFDAPOLogger getPOLoggerEx() {
        if (this.iSRFDAPOLogger == null) {
            Object objLogger = this.GetGlobalValue("POLOGGER");
            if (objLogger == null) {
                return null;
            }
            if (objLogger instanceof ISRFDAPOLogger) {
                this.iSRFDAPOLogger = (ISRFDAPOLogger)objLogger;
            }
        }
        return this.iSRFDAPOLogger;
    }

    @Override
    public final IDataNotifyHelper getDataNotifyHelper() {
        if (this.iDataNotifyHelper != null) {
            return this.iDataNotifyHelper;
        }
        this.iDataNotifyHelper = (IDataNotifyHelper)this.servletContext.getAttribute("SRFDADATANOTIFYHELPER");
        return this.iDataNotifyHelper;
    }

    @Override
    public final IPasswordStorage getPasswordStorage() throws Exception {
        return PasswordStorageFactory.Create(this);
    }

    public static void setInstance(ISRFDAGlobalHelper globalHelper) {
        inst = globalHelper;
    }

    public static ISRFDAGlobalHelper getInstance() {
        return inst;
    }

    @Override
    public String getAppMode() {
        if (this.strAppMode == null) {
            Object objAppMode = this.servletContext.getAttribute("SRFDAAPPMODE");
            this.strAppMode = objAppMode == null ? "" : (String)objAppMode;
        }
        return this.strAppMode;
    }
}

