/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;

public class UserCtrlMgr {
    private Hashtable userListColumnList = new Hashtable();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object Get(String strUserColumn) {
        if (StringHelper.Length(strUserColumn) == 0) {
            return null;
        }
        Hashtable hashtable = this.userListColumnList;
        synchronized (hashtable) {
            if (this.userListColumnList.containsKey(strUserColumn)) {
                return this.userListColumnList.get(strUserColumn);
            }
        }
        Object objUserColumn = this.InternalCreateObject(strUserColumn);
        if (objUserColumn == null) {
            return null;
        }
        Hashtable hashtable2 = this.userListColumnList;
        synchronized (hashtable2) {
            this.userListColumnList.put(strUserColumn, objUserColumn);
        }
        return objUserColumn;
    }

    private Object InternalCreateObject(String strType) {
        try {
            return Class.forName(strType).newInstance();
        }
        catch (Exception ex) {
            ex.printStackTrace(System.err);
            return null;
        }
    }
}

