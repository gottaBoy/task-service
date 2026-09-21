/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.BaseDBCallerHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.CodeList;

import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.CodeList.CodeListMgr;
import SA.SRFramework.CodeList.IUserCodeListContext;
import SA.SRFramework.CodeList.IUserCodeListFiller;
import SA.SRFramework.CodeList.IUserCodeListQuery;
import SA.SRFramework.Data.BaseDBCallerHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.Utility.ContextHelper;
import java.io.Serializable;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UserCodeListMgr
extends CodeListMgr
implements IUserCodeListContext,
Serializable {
    private CodeListMgr globalCodeListMgr = null;
    protected Hashtable<String, Object> userTagMap = new Hashtable();
    protected ContextHelper contextHelper = null;
    protected BaseDBCallerHelper dbCallerHelper = null;
    private static final Log log = LogFactory.getLog(UserCodeListMgr.class);

    public CodeListMgr getGlobalCodeListMgr() {
        return this.globalCodeListMgr;
    }

    public void setGlobalCodeListMgr(CodeListMgr globalCodeListMgr) {
        this.globalCodeListMgr = globalCodeListMgr;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public CodeListConfig GetCodeListConfig(String strCodeListId) {
        CodeListConfig tempCodeListConfig;
        String strLookupCodeListId = strCodeListId;
        strCodeListId = strCodeListId.toUpperCase();
        Hashtable hashtable = this.fileList;
        synchronized (hashtable) {
            if (this.fileList.containsKey(strCodeListId)) {
                return (CodeListConfig)((Object)this.fileList.get(strCodeListId));
            }
        }
        if (this.globalCodeListMgr == null) {
            return null;
        }
        String[] codeListIds = strLookupCodeListId.split("[?]");
        String strCodeListParam = "";
        if (codeListIds.length >= 2) {
            strLookupCodeListId = codeListIds[0];
            strCodeListParam = codeListIds[1];
        }
        if ((tempCodeListConfig = this.globalCodeListMgr.GetCodeListConfig(strLookupCodeListId)) == null) {
            return tempCodeListConfig;
        }
        if (!tempCodeListConfig.isUserScope()) {
            return tempCodeListConfig;
        }
        CodeListConfig codeListConfig = tempCodeListConfig.clone();
        if (StringHelper.Length((String)codeListConfig.getFiller()) > 0) {
            codeListConfig.SetExtValue("CODELISTPARAM", strCodeListParam);
            Object obj = ObjectHelper.Create(codeListConfig.getFiller());
            if (obj == null) {
                log.error((Object)StringHelper.Format((String)"\u4ee3\u7801\u8868\u914d\u7f6e[%1$s]\u586b\u5145\u5668[%2$s]\u65e0\u6548\uff0c\u65e0\u6cd5\u5efa\u7acb\u5bf9\u8c61", (Object)strCodeListId, (Object)codeListConfig.getFiller()));
                return null;
            }
            if (!(obj instanceof IUserCodeListFiller)) {
                log.error((Object)StringHelper.Format((String)"\u4ee3\u7801\u8868\u914d\u7f6e[%1$s]\u586b\u5145\u5668[%2$s]\u65e0\u6548\uff0c\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[IUserCodeListFiller]", (Object)strCodeListId, (Object)codeListConfig.getFiller()));
                return null;
            }
            IUserCodeListFiller iUserCodeListFiller = (IUserCodeListFiller)obj;
            iUserCodeListFiller.Fill(this, codeListConfig);
            if (obj instanceof IUserCodeListQuery) {
                IUserCodeListQuery iUserCodeListQuery = (IUserCodeListQuery)obj;
                iUserCodeListQuery.Init(this);
                codeListConfig.SetUserCodeListQuery(iUserCodeListQuery);
            }
        }
        Hashtable hashtable2 = this.fileList;
        synchronized (hashtable2) {
            this.fileList.put(strCodeListId, codeListConfig);
        }
        return codeListConfig;
    }

    @Override
    public Object GetUserTag(String strTag) {
        strTag = strTag.toUpperCase();
        return this.userTagMap.get(strTag);
    }

    public void SetUserTag(String strTag, Object objValue) {
        strTag = strTag.toUpperCase();
        if (objValue == null) {
            this.userTagMap.remove(strTag);
        } else {
            this.userTagMap.put(strTag, objValue);
        }
    }

    @Override
    public ContextHelper GetContextHelper() {
        return this.contextHelper;
    }

    @Override
    public BaseDBCallerHelper GetDBCallerHelper() {
        return this.dbCallerHelper;
    }

    public void SetContextHelper(ContextHelper contextHelper) {
        this.contextHelper = contextHelper;
    }

    public void SetDBCallerHelper(BaseDBCallerHelper dbCallerHelper) {
        this.dbCallerHelper = dbCallerHelper;
    }
}

