/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.IDEHelper;
import java.util.TreeMap;
import java.util.Vector;

public class DAQueryModelAlias {
    private IDEHelper iDEHelper = null;
    private Vector<String> derList = null;
    private TreeMap<String, Integer> derAliasMap = null;
    private String strParentDER = "";

    public IDEHelper getIDEHelper() {
        return this.iDEHelper;
    }

    public Vector<String> getDERList() {
        return this.derList;
    }

    public TreeMap<String, Integer> getDERAliasMap() {
        return this.derAliasMap;
    }

    public String getParentDER() {
        return this.strParentDER;
    }

    public void setIDEHelper(IDEHelper helper) {
        this.iDEHelper = helper;
    }

    public void setDERList(Vector<String> derList) {
        this.derList = derList;
    }

    public void setDERAliasMap(TreeMap<String, Integer> derAliasMap) {
        this.derAliasMap = derAliasMap;
    }

    public void setParentDER(String strParentDER) {
        this.strParentDER = strParentDER;
    }
}

