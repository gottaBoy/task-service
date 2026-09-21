/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.sysmodel;

import java.util.HashMap;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.sysmodel.IUserCodeListModel;
import net.ibizsys.paas.util.StringHelper;
import org.hibernate.SessionFactory;

public class UserCodeListGlobal {
    private HashMap<String, ICodeList> codeListMap = new HashMap();
    private String strPersonId = "";

    public UserCodeListGlobal(String strPersonId) throws Exception {
        this.strPersonId = strPersonId;
        if (StringHelper.isNullOrEmpty(this.strPersonId)) {
            throw new Exception(StringHelper.format("\u5f53\u524d\u7528\u6237\u6807\u8bc6\u65e0\u6548"));
        }
    }

    public String getCurUserId() {
        return this.strPersonId;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized ICodeList getUserCodeList(ICodeList iCodeList) throws Exception {
        SessionFactory sessionFactory = null;
        ICodeListModel iCodeListModel = null;
        if (iCodeList instanceof ICodeListModel) {
            iCodeListModel = (ICodeListModel)iCodeList;
        }
        if (iCodeListModel != null) {
            sessionFactory = iCodeListModel.getSessionFactory();
        }
        String strFullKeyId = "";
        strFullKeyId = sessionFactory == null ? iCodeList.getId() : StringHelper.format("%1$s|%2$s", iCodeList.getId(), sessionFactory.toString());
        HashMap<String, ICodeList> hashMap = this.codeListMap;
        synchronized (hashMap) {
            ICodeList newCodeListModel;
            ICodeList iUserCodeList = this.codeListMap.get(strFullKeyId);
            if (iUserCodeList != null) {
                return iUserCodeList;
            }
            ICodeList newCodeList = (ICodeList)iCodeList.getClass().newInstance();
            if (newCodeList instanceof ICodeListModel) {
                newCodeListModel = (ICodeListModel)newCodeList;
                newCodeListModel.from((ICodeListModel)iCodeList);
                newCodeListModel.setSessionFactory(sessionFactory);
            }
            if (newCodeList instanceof IUserCodeListModel) {
                newCodeListModel = (IUserCodeListModel)newCodeList;
                newCodeListModel.setCurUserId(this.getCurUserId());
            }
            this.codeListMap.put(strFullKeyId, newCodeList);
            return newCodeList;
        }
    }
}

