/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psba.core.IBATableModel;
import net.ibizsys.psba.dao.BASelectContext;
import net.ibizsys.psba.entity.BAColumnHistory;
import net.ibizsys.psba.entity.IBAColumnHistory;
import net.ibizsys.psba.entity.IBAEntity;
import net.ibizsys.psba.entity.IBAEntityActionHelper;

public class BAEntity
extends EntityBase
implements IBAEntity {
    private String strRowKey = null;
    private Timestamp createDate = null;
    private Timestamp updateDate = null;
    private HashMap<String, ISimpleDataObject> familyMap = null;
    private Object familyMapLock = new Object();
    private static final String BAHPREFIX = "BAH$";

    @Override
    public String getRowKey() {
        return this.strRowKey;
    }

    @Override
    public void setRowKey(String strRowKey) {
        this.strRowKey = strRowKey;
    }

    @Override
    public Timestamp getCreateDate() {
        return this.createDate;
    }

    @Override
    public Timestamp getUpdateDate() {
        return this.updateDate;
    }

    @Override
    public ISimpleDataObject getFamily(String strFamily) throws Exception {
        return this.getFamily(strFamily, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public ISimpleDataObject getFamily(String strFamily, boolean bCreateIfNotExists) throws Exception {
        Object object = this.familyMapLock;
        synchronized (object) {
            block6: {
                if (this.familyMap != null) break block6;
                if (bCreateIfNotExists) {
                    this.familyMap = new HashMap();
                    break block6;
                }
                return null;
            }
            ISimpleDataObject iEntity = this.familyMap.get(strFamily);
            if (iEntity == null && bCreateIfNotExists) {
                iEntity = this.createFamily(strFamily);
                this.familyMap.put(strFamily, iEntity);
            }
            return iEntity;
        }
    }

    @Override
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setFamily(String strFamily, ISimpleDataObject iEntity) {
        Object object = this.familyMapLock;
        synchronized (object) {
            if (this.familyMap == null) {
                if (iEntity == null) {
                    return;
                }
                this.familyMap = new HashMap();
            }
            if (iEntity == null) {
                this.familyMap.remove(strFamily);
            } else {
                this.familyMap.put(strFamily, iEntity);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Iterator<String> getFamilyNames() {
        Object object = this.familyMapLock;
        synchronized (object) {
            block4: {
                if (this.familyMap != null) break block4;
                return null;
            }
            return this.familyMap.keySet().iterator();
        }
    }

    @Override
    public ArrayList<IBAEntity> children(String strChildName) throws Exception {
        BASelectContext baSelectContext = new BASelectContext();
        return this.children(strChildName, baSelectContext);
    }

    @Override
    public ArrayList<IBAEntity> children(String strChildName, BASelectContext iBASelectContext) throws Exception {
        IBAEntityActionHelper iBAEntityActionHelper = this.getBAActionHelper(true);
        if (StringHelper.isNullOrEmpty(this.getRowKey())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u884c\u952e\u503c");
        }
        iBASelectContext.setRowKeyPrefix(this.getRowKey());
        IBATableModel iBATableModel = (IBATableModel)iBAEntityActionHelper.getBASchemeModel().getBATable(strChildName, false);
        return iBAEntityActionHelper.getBASchemeModel().getBADAO(iBATableModel).executeSelectCmd(iBASelectContext);
    }

    protected IEntity createFamily(String strFamily) throws Exception {
        return new SimpleEntity();
    }

    @Override
    public void set(String strFamily, String strParamName, Object objValue) throws Exception {
        this.set(strFamily, strParamName, objValue, -1L);
    }

    @Override
    public void set(String strFamily, String strParamName, Object objValue, long nTimeStamp) throws Exception {
        IDataObject iDataObject;
        ISimpleDataObject iEntity = this.getFamily(strFamily, true);
        if (iEntity instanceof IDataObject) {
            iDataObject = (IDataObject)iEntity;
            if (nTimeStamp != -1L) {
                String strHistoryKey = BAHPREFIX + strParamName;
                Object objBAHistory = iDataObject.get(strHistoryKey);
                BAColumnHistory baColumnHistory = null;
                if (objBAHistory == null) {
                    baColumnHistory = new BAColumnHistory();
                    iDataObject.set(strHistoryKey, baColumnHistory);
                } else {
                    if (!(objBAHistory instanceof BAColumnHistory)) {
                        throw new Exception("\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e");
                    }
                    baColumnHistory = (BAColumnHistory)objBAHistory;
                }
                baColumnHistory.setValue(nTimeStamp, objValue);
                objValue = baColumnHistory.getLastValue();
            }
        } else {
            throw new Exception("\u6570\u636e\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        iDataObject.set(strParamName, objValue);
    }

    @Override
    public IBAColumnHistory getBAColumnHistory(String strFamily, String strParamName) throws Exception {
        ISimpleDataObject iEntity = this.getFamily(strFamily, false);
        if (iEntity == null) {
            return null;
        }
        String strHistoryKey = BAHPREFIX + strParamName;
        Object objBAHistory = iEntity.get(strHistoryKey);
        if (objBAHistory == null) {
            return null;
        }
        if (!(objBAHistory instanceof BAColumnHistory)) {
            throw new Exception("\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        return (IBAColumnHistory)objBAHistory;
    }

    @Override
    public Object get(String strFamily, String strParamName) throws Exception {
        ISimpleDataObject iEntity = this.getFamily(strFamily);
        if (iEntity == null) {
            return null;
        }
        return iEntity.get(strParamName);
    }

    @Override
    public boolean isNull(String strFamily, String strParamName) throws Exception {
        ISimpleDataObject iEntity = this.getFamily(strFamily);
        if (iEntity == null) {
            return true;
        }
        return iEntity.isNull(strParamName);
    }

    @Override
    public boolean contains(String strFamily, String strParamName) throws Exception {
        ISimpleDataObject iEntity = this.getFamily(strFamily);
        if (iEntity == null) {
            return false;
        }
        return iEntity.contains(strParamName);
    }

    protected IBAEntityActionHelper getBAActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = this.getActionHelper(bMust);
        if (iEntityActionHelper != null) {
            if (iEntityActionHelper instanceof IBAEntityActionHelper) {
                return (IBAEntityActionHelper)iEntityActionHelper;
            }
            throw new Exception("\u64cd\u4f5c\u8f85\u52a9\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        return null;
    }

    @Override
    public void create(String[] families) throws Exception {
        this.getBAActionHelper(true).create(this, families);
    }

    @Override
    public void update(String[] families) throws Exception {
        this.getBAActionHelper(true).create(this, families);
    }

    @Override
    public void save(String[] families) throws Exception {
        this.getBAActionHelper(true).create(this, families);
    }

    @Override
    public boolean get(String[] families, boolean bTryMode) throws Exception {
        return this.getBAActionHelper(true).get(this, families, bTryMode);
    }

    @Override
    public void get(String[] families) throws Exception {
        this.getBAActionHelper(true).get(this, families, false);
    }
}

