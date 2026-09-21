/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.sysmodel.ICodeListGlobalPlugin
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.JIT.SysModel;

import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.ICodeListGlobalPlugin;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSJITCodeListGlobalPlugin
implements ICodeListGlobalPlugin {
    private final Log log = LogFactory.getLog(PSJITCodeListGlobalPlugin.class);
    private HashMap<String, ICodeList> codeListMap = new HashMap();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerCodeList(String strCodeListClsType, ICodeListModel iCodeList) {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.getInstance().getSystemModel().registerCodeListModel(iCodeList);
            return;
        }
        HashMap<String, ICodeList> hashMap = this.codeListMap;
        synchronized (hashMap) {
            this.codeListMap.put(strCodeListClsType, (ICodeList)iCodeList);
            this.codeListMap.put(iCodeList.getId(), (ICodeList)iCodeList);
        }
    }

    public ICodeList getCodeList(Class cls) throws Exception {
        return this.getCodeList(cls.getCanonicalName());
    }

    public ICodeList getCodeList(String strCodeListClsType) throws Exception {
        if (PSJITWebContext.getInstance() != null) {
            return PSJITWebContext.getInstance().getSystemModel().getCodeListModel(strCodeListClsType);
        }
        return this.internalGetCodeList(strCodeListClsType);
    }

    public ICodeList getCodeList(Class cls, SessionFactory sessionFactory) throws Exception {
        return this.getCodeList(cls.getCanonicalName(), sessionFactory);
    }

    public ICodeList getCodeList(String strCodeListClsType, SessionFactory sessionFactory) throws Exception {
        if (PSJITWebContext.getInstance() != null) {
            ICodeListModel iCodeList = PSJITWebContext.getInstance().getSystemModel().getCodeListModel(strCodeListClsType);
            if (iCodeList.isUserScope() && WebContext.getCurrent() != null) {
                return WebContext.getCurrent().getUserCodeList((ICodeList)iCodeList);
            }
            return iCodeList;
        }
        ICodeList iCodeList = this.internalGetCodeList(strCodeListClsType, sessionFactory);
        if (iCodeList.isUserScope() && WebContext.getCurrent() != null) {
            return WebContext.getCurrent().getUserCodeList(iCodeList);
        }
        return iCodeList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ICodeList internalGetCodeList(String strCodeListClsType, SessionFactory sessionFactory) throws Exception {
        if (sessionFactory == null) {
            return this.getCodeList(strCodeListClsType);
        }
        String strFullKeyId = StringHelper.format((String)"%1$s|%2$s", (Object)strCodeListClsType, (Object)sessionFactory.toString());
        HashMap<String, ICodeList> hashMap = this.codeListMap;
        synchronized (hashMap) {
            ICodeList iCodeList = this.codeListMap.get(strFullKeyId);
            if (iCodeList != null) {
                return iCodeList;
            }
            iCodeList = this.codeListMap.get(strCodeListClsType);
            if (iCodeList == null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u8868[%1$s]", (Object)strCodeListClsType));
            }
            ICodeList newCodeList = (ICodeList)iCodeList.getClass().newInstance();
            if (newCodeList instanceof ICodeListModel) {
                ((ICodeListModel)newCodeList).from((ICodeListModel)iCodeList);
                ((ICodeListModel)newCodeList).setSessionFactory(sessionFactory);
            }
            this.codeListMap.put(strFullKeyId, newCodeList);
            return newCodeList;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ICodeList internalGetCodeList(String strCodeListClsType) throws Exception {
        HashMap<String, ICodeList> hashMap = this.codeListMap;
        synchronized (hashMap) {
            ICodeList iCodeList = this.codeListMap.get(strCodeListClsType);
            if (iCodeList == null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u8868[%1$s]", (Object)strCodeListClsType));
            }
            if (iCodeList.isUserScope() && WebContext.getCurrent() != null) {
                return WebContext.getCurrent().getUserCodeList(iCodeList);
            }
            return iCodeList;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Iterator<ICodeList> getAllCodelists() {
        ArrayList<ICodeList> allList = new ArrayList<ICodeList>();
        HashMap<String, ICodeList> hashMap = this.codeListMap;
        synchronized (hashMap) {
            allList.addAll(this.codeListMap.values());
        }
        return allList.iterator();
    }

    public ICodeList getCodeList(Class cls, boolean bTryMode) throws Exception {
        return this.getCodeList(cls);
    }

    public ICodeList getCodeList(String strCodeListClsType, boolean bTryMode) throws Exception {
        return this.getCodeList(strCodeListClsType);
    }

    public ICodeList getCodeList(Class cls, SessionFactory sessionFactory, boolean bTryMode) throws Exception {
        return this.getCodeList(cls, sessionFactory);
    }

    public ICodeList getCodeList(String strCodeListClsType, SessionFactory sessionFactory, boolean bTryMode) throws Exception {
        return this.getCodeList(strCodeListClsType, sessionFactory);
    }
}

