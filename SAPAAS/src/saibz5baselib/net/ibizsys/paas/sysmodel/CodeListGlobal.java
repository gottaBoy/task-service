/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.sysmodel;

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

public class CodeListGlobal {
    private static final Log log = LogFactory.getLog(CodeListGlobal.class);
    private static HashMap<String, ICodeList> codeListMap = new HashMap();
    private static ICodeListGlobalPlugin iCodeListGlobalPlugin = null;

    public static void registerCodeList(String strCodeListClsType, ICodeListModel iCodeList) {
        ICodeListGlobalPlugin iCodeListGlobalPlugin = CodeListGlobal.getPlugin();
        if (iCodeListGlobalPlugin != null) {
            iCodeListGlobalPlugin.registerCodeList(strCodeListClsType, iCodeList);
        } else {
            codeListMap.put(strCodeListClsType, iCodeList);
            codeListMap.put(iCodeList.getId(), iCodeList);
        }
    }

    public static ICodeList getCodeList(Class cls) throws Exception {
        ICodeListGlobalPlugin iCodeListGlobalPlugin = CodeListGlobal.getPlugin();
        if (iCodeListGlobalPlugin != null) {
            return iCodeListGlobalPlugin.getCodeList(cls);
        }
        return CodeListGlobal.getCodeList(cls.getCanonicalName());
    }

    public static ICodeList getCodeList(Class cls, boolean bTryMode) throws Exception {
        ICodeListGlobalPlugin iCodeListGlobalPlugin = CodeListGlobal.getPlugin();
        if (iCodeListGlobalPlugin != null) {
            return iCodeListGlobalPlugin.getCodeList(cls, bTryMode);
        }
        return CodeListGlobal.getCodeList(cls.getCanonicalName(), bTryMode);
    }

    public static ICodeList getCodeList(String strCodeListClsType) throws Exception {
        ICodeListGlobalPlugin iCodeListGlobalPlugin = CodeListGlobal.getPlugin();
        if (iCodeListGlobalPlugin != null) {
            return iCodeListGlobalPlugin.getCodeList(strCodeListClsType);
        }
        return CodeListGlobal.internalGetCodeList(strCodeListClsType);
    }

    public static ICodeList getCodeList(String strCodeListClsType, boolean bTryMode) throws Exception {
        ICodeListGlobalPlugin iCodeListGlobalPlugin = CodeListGlobal.getPlugin();
        if (iCodeListGlobalPlugin != null) {
            return iCodeListGlobalPlugin.getCodeList(strCodeListClsType, bTryMode);
        }
        return CodeListGlobal.internalGetCodeList(strCodeListClsType, bTryMode);
    }

    public static ICodeList getCodeList(Class cls, SessionFactory sessionFactory) throws Exception {
        ICodeListGlobalPlugin iCodeListGlobalPlugin = CodeListGlobal.getPlugin();
        if (iCodeListGlobalPlugin != null) {
            return iCodeListGlobalPlugin.getCodeList(cls.getCanonicalName(), sessionFactory);
        }
        return CodeListGlobal.getCodeList(cls.getCanonicalName(), sessionFactory);
    }

    public static ICodeList getCodeList(Class cls, SessionFactory sessionFactory, boolean bTryMode) throws Exception {
        ICodeListGlobalPlugin iCodeListGlobalPlugin = CodeListGlobal.getPlugin();
        if (iCodeListGlobalPlugin != null) {
            return iCodeListGlobalPlugin.getCodeList(cls.getCanonicalName(), sessionFactory, bTryMode);
        }
        return CodeListGlobal.getCodeList(cls.getCanonicalName(), sessionFactory, bTryMode);
    }

    public static ICodeList getCodeList(String strCodeListClsType, SessionFactory sessionFactory) throws Exception {
        ICodeListGlobalPlugin iCodeListGlobalPlugin = CodeListGlobal.getPlugin();
        if (iCodeListGlobalPlugin != null) {
            return iCodeListGlobalPlugin.getCodeList(strCodeListClsType, sessionFactory);
        }
        ICodeList iCodeList = CodeListGlobal.internalGetCodeList(strCodeListClsType, sessionFactory);
        if (iCodeList.isUserScope() && WebContext.getCurrent() != null) {
            return WebContext.getCurrent().getUserCodeList(iCodeList);
        }
        return iCodeList;
    }

    public static ICodeList getCodeList(String strCodeListClsType, SessionFactory sessionFactory, boolean bTryMode) throws Exception {
        ICodeListGlobalPlugin iCodeListGlobalPlugin = CodeListGlobal.getPlugin();
        if (iCodeListGlobalPlugin != null) {
            return iCodeListGlobalPlugin.getCodeList(strCodeListClsType, sessionFactory, bTryMode);
        }
        ICodeList iCodeList = CodeListGlobal.internalGetCodeList(strCodeListClsType, sessionFactory, bTryMode);
        if (iCodeList == null) {
            return iCodeList;
        }
        if (iCodeList.isUserScope() && WebContext.getCurrent() != null) {
            return WebContext.getCurrent().getUserCodeList(iCodeList);
        }
        return iCodeList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static ICodeList internalGetCodeList(String strCodeListClsType, SessionFactory sessionFactory) throws Exception {
        if (sessionFactory == null) {
            return CodeListGlobal.getCodeList(strCodeListClsType);
        }
        String strFullKeyId = StringHelper.format("%1$s|%2$s", strCodeListClsType, sessionFactory.toString());
        HashMap<String, ICodeList> hashMap = codeListMap;
        synchronized (hashMap) {
            ICodeList iCodeList = codeListMap.get(strFullKeyId);
            if (iCodeList != null) {
                return iCodeList;
            }
            iCodeList = codeListMap.get(strCodeListClsType);
            if (iCodeList == null) {
                throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u8868[%1$s]", strCodeListClsType));
            }
            ICodeList newCodeList = (ICodeList)iCodeList.getClass().newInstance();
            if (newCodeList instanceof ICodeListModel) {
                ((ICodeListModel)newCodeList).from((ICodeListModel)iCodeList);
                ((ICodeListModel)newCodeList).setSessionFactory(sessionFactory);
            }
            codeListMap.put(strFullKeyId, newCodeList);
            return newCodeList;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static ICodeList internalGetCodeList(String strCodeListClsType, SessionFactory sessionFactory, boolean bTryMode) throws Exception {
        if (sessionFactory == null) {
            return CodeListGlobal.getCodeList(strCodeListClsType, bTryMode);
        }
        String strFullKeyId = StringHelper.format("%1$s|%2$s", strCodeListClsType, sessionFactory.toString());
        HashMap<String, ICodeList> hashMap = codeListMap;
        synchronized (hashMap) {
            ICodeList iCodeList = codeListMap.get(strFullKeyId);
            if (iCodeList != null) {
                return iCodeList;
            }
            iCodeList = codeListMap.get(strCodeListClsType);
            if (iCodeList == null) {
                if (bTryMode) {
                    return iCodeList;
                }
                throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u8868[%1$s]", strCodeListClsType));
            }
            ICodeList newCodeList = (ICodeList)iCodeList.getClass().newInstance();
            if (newCodeList instanceof ICodeListModel) {
                ((ICodeListModel)newCodeList).from((ICodeListModel)iCodeList);
                ((ICodeListModel)newCodeList).setSessionFactory(sessionFactory);
            }
            codeListMap.put(strFullKeyId, newCodeList);
            return newCodeList;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static ICodeList internalGetCodeList(String strCodeListClsType, boolean bTryMode) throws Exception {
        HashMap<String, ICodeList> hashMap = codeListMap;
        synchronized (hashMap) {
            ICodeList iCodeList = codeListMap.get(strCodeListClsType);
            if (iCodeList == null) {
                if (bTryMode) {
                    return null;
                }
                throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u8868[%1$s]", strCodeListClsType));
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
    private static ICodeList internalGetCodeList(String strCodeListClsType) throws Exception {
        HashMap<String, ICodeList> hashMap = codeListMap;
        synchronized (hashMap) {
            ICodeList iCodeList = codeListMap.get(strCodeListClsType);
            if (iCodeList == null) {
                throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u8868[%1$s]", strCodeListClsType));
            }
            if (iCodeList.isUserScope() && WebContext.getCurrent() != null) {
                return WebContext.getCurrent().getUserCodeList(iCodeList);
            }
            return iCodeList;
        }
    }

    public static Iterator<ICodeList> getAllCodelists() {
        ICodeListGlobalPlugin iCodeListGlobalPlugin = CodeListGlobal.getPlugin();
        if (iCodeListGlobalPlugin != null) {
            return iCodeListGlobalPlugin.getAllCodelists();
        }
        return codeListMap.values().iterator();
    }

    public static void setPlugin(ICodeListGlobalPlugin iCodeListGlobalPlugin) {
        CodeListGlobal.iCodeListGlobalPlugin = iCodeListGlobalPlugin;
    }

    public static ICodeListGlobalPlugin getPlugin() {
        return iCodeListGlobalPlugin;
    }
}

