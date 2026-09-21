/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import java.util.ArrayList;
import java.util.TreeMap;

public class PSDEDQAlias {
    private IPSDataEntity iPSDataEntity = null;
    private ArrayList<String> derList = null;
    private TreeMap<String, Integer> derAliasMap = null;
    private String strParentDER = "";
    private int nAliasIndex = -1;

    public IPSDataEntity getIPSDataEntity() {
        return this.iPSDataEntity;
    }

    public ArrayList<String> getDERList() {
        return this.derList;
    }

    public TreeMap<String, Integer> getDERAliasMap() {
        return this.derAliasMap;
    }

    public String getParentDER() {
        return this.strParentDER;
    }

    public void setPSDataEntity(IPSDataEntity helper) {
        this.iPSDataEntity = helper;
    }

    public void setDERList(ArrayList<String> derList) {
        this.derList = derList;
    }

    public void setDERAliasMap(TreeMap<String, Integer> derAliasMap) {
        this.derAliasMap = derAliasMap;
    }

    public void setParentDER(String strParentDER) {
        this.strParentDER = strParentDER;
    }

    public int getAliasIndex() {
        return this.nAliasIndex;
    }

    public void setAliasIndex(int nAliasIndex) {
        this.nAliasIndex = nAliasIndex;
    }
}

