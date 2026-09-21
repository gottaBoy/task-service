/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psba.core.BASchemeObjectModelBase;
import net.ibizsys.psba.core.IBAColSet;
import net.ibizsys.psba.core.IBAColSetModel;
import net.ibizsys.psba.core.IBAColumn;
import net.ibizsys.psba.core.IBAScheme;
import net.ibizsys.psba.core.IBATableDE;
import net.ibizsys.psba.core.IBATableDER;
import net.ibizsys.psba.core.IBATableModel;
import net.ibizsys.psba.entity.IBAEntity;

public class BATableModel
extends BASchemeObjectModelBase
implements IBATableModel {
    private ArrayList<IBAColumn> baColumnList = new ArrayList();
    private HashMap<String, IBAColumn> baColumnMap = new HashMap();
    private ArrayList<IBAColSet> baColSetList = new ArrayList();
    private HashMap<String, IBAColSet> baColSetMap = new HashMap();
    private ArrayList<IBATableDE> baTableDEList = new ArrayList();
    private HashMap<String, IBATableDE> baTableDEMap = new HashMap();
    private ArrayList<IBATableDER> baTableDERList = new ArrayList();
    private HashMap<String, IBATableDER> baTableDERMap = new HashMap();
    private int nBATableType = 1;

    public void init(IBAScheme iBAScheme) throws Exception {
        this.setBAScheme(iBAScheme);
        this.onInit();
    }

    @Override
    public void registerBAColumn(IBAColumn iBAColumn) throws Exception {
        this.baColumnList.add(iBAColumn);
        this.baColumnMap.put(iBAColumn.getId(), iBAColumn);
        ((IBAColSetModel)this.getBAColSet(iBAColumn.getBAColSetName())).registerBAColumn(iBAColumn);
    }

    @Override
    public void registerBAColSet(IBAColSet iBAColSet) throws Exception {
        this.baColSetList.add(iBAColSet);
        this.baColSetMap.put(iBAColSet.getId(), iBAColSet);
        this.baColSetMap.put(iBAColSet.getName(), iBAColSet);
    }

    @Override
    public void registerBATableDE(IBATableDE iBATableDE) throws Exception {
        this.baTableDEList.add(iBATableDE);
        this.baTableDEMap.put(iBATableDE.getId(), iBATableDE);
    }

    @Override
    public void registerBATableDER(IBATableDER iBATableDER) throws Exception {
        this.baTableDERList.add(iBATableDER);
        this.baTableDERMap.put(iBATableDER.getId(), iBATableDER);
        this.baTableDERMap.put(iBATableDER.getName(), iBATableDER);
    }

    @Override
    public Iterator<IBAColSet> getBAColSets() {
        if (this.baColSetList == null || this.baColSetList.size() == 0) {
            return null;
        }
        return this.baColSetList.iterator();
    }

    @Override
    public Iterator<IBAColumn> getBAColumns() {
        if (this.baColumnList == null || this.baColumnList.size() == 0) {
            return null;
        }
        return this.baColumnList.iterator();
    }

    @Override
    public IBATableDE getBATableDE(String strDEName) throws Exception {
        IBATableDE iBATableDE = this.baTableDEMap.get(strDEName);
        if (iBATableDE == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5927\u6570\u636e\u8868\u5b9e\u4f53[%1$s]", strDEName));
        }
        return iBATableDE;
    }

    @Override
    public IBATableDE getBATableDE(String strDEName, boolean bTryMode) throws Exception {
        IBATableDE iBATableDE = this.baTableDEMap.get(strDEName);
        if (iBATableDE == null && !bTryMode) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5927\u6570\u636e\u8868\u5b9e\u4f53[%1$s]", strDEName));
        }
        return iBATableDE;
    }

    @Override
    public IBATableDER getBATableDER(String strDERName) throws Exception {
        IBATableDER iBATableDER = this.baTableDERMap.get(strDERName);
        if (iBATableDER == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5927\u6570\u636e\u8868\u5b9e\u4f53\u5173\u7cfb[%1$s]", strDERName));
        }
        return iBATableDER;
    }

    @Override
    public IBAColumn getBAColumn(String strBAColumnName) throws Exception {
        IBAColumn iBAColumn = this.baColumnMap.get(strBAColumnName);
        if (iBAColumn == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5927\u6570\u636e\u8868\u5217[%1$s]", strBAColumnName));
        }
        return iBAColumn;
    }

    @Override
    public IBAColumn getBAColumn(String strBAColSetId, String strBAColumnId) throws Exception {
        return this.getBAColSet(strBAColSetId).getBAColumn(strBAColumnId);
    }

    @Override
    public IBAColSet getBAColSet(String strBAColSetName) throws Exception {
        IBAColSet iBAColSet = this.baColSetMap.get(strBAColSetName);
        if (iBAColSet == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5927\u6570\u636e\u8868\u5217\u65cf[%1$s]", strBAColSetName));
        }
        return iBAColSet;
    }

    @Override
    public int getBATableType() {
        return this.nBATableType;
    }

    public void setBATableType(int nBATableType) {
        this.nBATableType = nBATableType;
    }

    @Override
    public int getBATableDERCount() {
        return this.baTableDERList.size();
    }

    @Override
    public IBATableDER getBATableDERAt(int nPos) throws Exception {
        return this.baTableDERList.get(nPos);
    }

    @Override
    public Iterator<IBATableDE> getBATableDEs() {
        return this.baTableDEList.iterator();
    }

    @Override
    public IBAEntity createBAEntity() throws Exception {
        return this.getBASchemeModel().createBAEntity(this);
    }

    @Override
    public IBAEntity getBAEntity(String strRowKey) throws Exception {
        IBAEntity iBAEntity = this.createBAEntity();
        iBAEntity.setRowKey(strRowKey);
        iBAEntity.get();
        return iBAEntity;
    }

    @Override
    public IBAEntity getBAEntity(String strRowKey, String[] families) throws Exception {
        IBAEntity iBAEntity = this.createBAEntity();
        iBAEntity.setRowKey(strRowKey);
        iBAEntity.get(families);
        return iBAEntity;
    }

    @Override
    public IBAEntity getBAEntity(String strRowKey, String[] families, boolean bTryMode) throws Exception {
        IBAEntity iBAEntity = this.createBAEntity();
        iBAEntity.setRowKey(strRowKey);
        if (iBAEntity.get(families, bTryMode)) {
            return iBAEntity;
        }
        return null;
    }
}

