/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psba.core.BAModelBase;
import net.ibizsys.psba.core.IBASchemeModel;
import net.ibizsys.psba.core.IBASchemeRuntime;
import net.ibizsys.psba.core.IBATable;
import net.ibizsys.psba.dao.BADAOGlobal;
import net.ibizsys.psba.dao.IBADAO;
import net.ibizsys.psba.entity.BAEntity;
import net.ibizsys.psba.entity.IBAEntity;

public abstract class BASchemeModelBase
extends BAModelBase
implements IBASchemeModel,
IBASchemeRuntime {
    private HashMap<String, IBATable> baTableMap = new HashMap();
    private ArrayList<IBATable> baTableList = new ArrayList();
    private String strNamespace = null;

    @Override
    public void registerBATable(IBATable iBATable) {
        String strId = iBATable.getId();
        String strName = iBATable.getName();
        this.baTableMap.put(strId, iBATable);
        this.baTableMap.put(strName, iBATable);
        this.baTableList.add(iBATable);
    }

    @Override
    public IBATable getBATable(String strName, boolean bTry) throws Exception {
        IBATable iBATable = this.baTableMap.get(strName);
        if (iBATable == null && !bTry) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5927\u6570\u636e\u8868[%1$s]", strName));
        }
        return iBATable;
    }

    protected IBATable createBATable(String strBATableName) throws Exception {
        return null;
    }

    @Override
    public Iterator<IBATable> getBATables() {
        if (this.baTableList.size() == 0) {
            return null;
        }
        return this.baTableList.iterator();
    }

    @Override
    public ISystem getSystem() {
        return this.getSystemModel();
    }

    @Override
    public void install() throws Exception {
        block2: {
            Object conn = null;
            try {
                conn = this.getBADataSource().getConnection();
                this.getBADialect().install(conn, this);
            }
            catch (Exception ex) {
                if (conn == null) break block2;
                this.getBADataSource().closeConnection(conn);
            }
        }
    }

    @Override
    public IBADAO getBADAO(IBATable iBATable) throws Exception {
        return BADAOGlobal.getBADAO(iBATable.getId());
    }

    @Override
    public String getNamespace() {
        if (StringHelper.isNullOrEmpty(this.strNamespace)) {
            return this.getBADataSource().getNamespace();
        }
        return this.strNamespace;
    }

    public void setNamespace(String strNamespace) {
        this.strNamespace = strNamespace;
    }

    @Override
    public IBAEntity createBAEntity(IBATable iBATable) throws Exception {
        IBAEntity iBAEntity = this.onCreateBAEntity(iBATable);
        iBAEntity.setActionHelper(this.getBADAO(iBATable).getBAEntityActionHelper());
        return iBAEntity;
    }

    protected IBAEntity onCreateBAEntity(IBATable iBATable) throws Exception {
        return new BAEntity();
    }

    @Override
    public int getMaxVersions() {
        return this.getBADataSource().getMaxVersions();
    }
}

