/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.ListItem;
import java.util.ArrayList;

public class ListItemCollection {
    private static String SATAB = "##SA_TAB##";
    private static String SARET = "##SA_RET##";
    protected ArrayList arrListItem = new ArrayList();

    public void Add(ListItem listItem) {
        this.arrListItem.add(listItem);
    }

    public void Insert(int nPos, ListItem listItem) {
        this.arrListItem.add(nPos, listItem);
    }

    public int size() {
        return this.arrListItem.size();
    }

    public ListItem Get(int nIndex) {
        return (ListItem)this.arrListItem.get(nIndex);
    }

    public void Clear() {
        this.arrListItem.clear();
    }

    public void Remove(ListItem listItem) {
        this.arrListItem.remove(listItem);
    }

    public void Remove(int nIndex) {
        this.arrListItem.remove(nIndex);
    }

    public ListItem FindByValue(String strValue) {
        int nItemCount = this.arrListItem.size();
        int i = 0;
        while (i < nItemCount) {
            ListItem temp = (ListItem)this.arrListItem.get(i);
            if (strValue.compareTo(temp.getValue()) == 0) {
                return temp;
            }
            ++i;
        }
        return null;
    }

    public void CheckAll(boolean bCheck) {
        int nItemCount = this.arrListItem.size();
        int i = 0;
        while (i < nItemCount) {
            ListItem temp = (ListItem)this.arrListItem.get(i);
            temp.setSelected(bCheck);
            ++i;
        }
    }

    public String toString() {
        String strRet = "";
        int nItemCount = this.arrListItem.size();
        int i = 0;
        while (i < nItemCount) {
            ListItem temp = (ListItem)this.arrListItem.get(i);
            String strText = temp.getText().replace("\t", SATAB).replace("\n", SARET);
            String strValue = temp.getValue().replace("\t", SATAB).replace("\n", SARET);
            strRet = String.valueOf(strRet) + strText;
            strRet = String.valueOf(strRet) + "\t";
            strRet = String.valueOf(strRet) + strValue;
            strRet = String.valueOf(strRet) + "\n";
            ++i;
        }
        return strRet;
    }

    public void fromString(String strSaveString) {
        this.arrListItem.clear();
        if (StringHelper.StringLength(strSaveString) == 0) {
            return;
        }
        String[] strPairs = strSaveString.split("\n");
        int i = 0;
        while (i < strPairs.length) {
            String strPair = strPairs[i];
            if (strPair != "") {
                String strText;
                String[] strValues = strPair.split("\t");
                if (strValues.length == 2) {
                    strText = strValues[0].replace(SATAB, "\t").replace(SARET, "\n");
                    String strValue = strValues[1].replace(SATAB, "\t").replace(SARET, "\n");
                    this.Add(new ListItem(strText, strValue));
                } else {
                    strText = strValues[0].replace(SATAB, "\t").replace(SARET, "\n");
                    this.Add(new ListItem(strText, ""));
                }
            }
            ++i;
        }
    }
}

