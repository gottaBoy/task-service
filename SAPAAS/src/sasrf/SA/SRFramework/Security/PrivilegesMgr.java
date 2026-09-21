/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Security;

import SA.SRFramework.Data.BaseXYZDataHelper;
import SA.SRFramework.Data.DataItem;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;

public class PrivilegesMgr
extends BaseXYZDataHelper {
    protected Hashtable privList = new Hashtable();
    protected boolean bFullPrivMode = false;

    public synchronized void Reset() {
        this.privList.clear();
    }

    public boolean getFullPrivMode() {
        return this.bFullPrivMode;
    }

    public void setFullPrivMode(boolean value) {
        this.bFullPrivMode = value;
    }

    public synchronized void AddPriv(String strPrivResId, int nPrivAction) {
        if (StringHelper.Length(strPrivResId) == 0) {
            return;
        }
        if (this.privList.containsKey(strPrivResId)) {
            int nLastPrivAction = (Integer)this.privList.get(strPrivResId);
            nPrivAction |= nLastPrivAction;
        }
        this.privList.put(strPrivResId, nPrivAction);
    }

    public synchronized int GetResPriv(String strPrivResourceId) {
        if (this.bFullPrivMode) {
            return 3;
        }
        if (this.privList.containsKey(strPrivResourceId)) {
            int nLastPrivAction = (Integer)this.privList.get(strPrivResourceId);
            return nLastPrivAction;
        }
        return 0;
    }

    @Override
    public synchronized void DataBind() throws Exception {
        super.DataBind();
        this.Reset();
        for (Object objItem : this.itemList) {
            DataItem dataItem = (DataItem)objItem;
            int nPrivAction = Integer.parseInt(dataItem.getZ());
            this.AddPrivs(dataItem.getX(), nPrivAction);
            this.AddPrivs(dataItem.getY(), nPrivAction);
        }
    }

    private void AddPrivs(String strPrivIds, int nPrivAction) {
        if (StringHelper.Length(strPrivIds) == 0) {
            return;
        }
        strPrivIds = strPrivIds.replace("\n", ";");
        strPrivIds = strPrivIds.replace("\r", ";");
        strPrivIds = strPrivIds.trim();
        while (StringHelper.Length(strPrivIds) != 0) {
            String strTemp = "";
            int nPos = strPrivIds.indexOf(";");
            if (nPos != -1) {
                strTemp = strPrivIds.substring(0, nPos);
                strPrivIds = strPrivIds.substring(nPos + 1);
            } else {
                strTemp = strPrivIds;
                strPrivIds = "";
            }
            strTemp = strTemp.trim();
            if (StringHelper.Length(strTemp) != 0) {
                this.AddPriv(strTemp, nPrivAction);
            }
            strPrivIds = strPrivIds.trim();
        }
    }

    public boolean TestPriv(String strPrivId, int nReqPrivAction) {
        int nPrivAction = this.GetResPriv(strPrivId);
        return (nPrivAction & nReqPrivAction) > 0;
    }
}

