/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.NavigateItem;
import java.util.ArrayList;

public class NavigateMgr {
    protected int nMaxCount = 10;
    protected ArrayList itemList = null;

    public int getMaxCount() {
        return this.nMaxCount;
    }

    public void setMaxCount(int nMaxCount) {
        this.nMaxCount = nMaxCount;
    }

    public void AddItem(NavigateItem item) {
        if (this.itemList == null) {
            this.itemList = new ArrayList();
        }
        int nCount = this.itemList.size();
        int i = 0;
        while (i < nCount) {
            NavigateItem temp = (NavigateItem)this.itemList.get(i);
            if (StringHelper.Compare((String)temp.getCaption(), (String)item.getCaption(), (boolean)false) == 0 && StringHelper.Compare((String)temp.getTarget(), (String)item.getTarget(), (boolean)true) == 0) {
                this.itemList.remove(i);
                break;
            }
            ++i;
        }
        if (this.itemList.size() > 0 && this.itemList.size() > this.nMaxCount) {
            this.itemList.remove(0);
        }
        this.itemList.add(item);
    }

    public void AddItem(String strCaption, String strURL, String strTarget, String strTips) {
        NavigateItem item = new NavigateItem();
        item.setCaption(strCaption);
        item.setURL(strURL);
        item.setTarget(strTarget);
        item.setTips(strTips);
        this.AddItem(item);
    }

    public void Reset() {
        this.itemList = null;
    }

    public ArrayList GetList() {
        return this.itemList;
    }
}

