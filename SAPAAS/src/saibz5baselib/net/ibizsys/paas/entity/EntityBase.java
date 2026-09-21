/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.entity;

import java.sql.Timestamp;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.entity.IEntityActionSupporter;
import net.ibizsys.paas.util.StringHelper;
import org.hibernate.SessionFactory;

public abstract class EntityBase
extends DataObject
implements IEntity,
IEntityActionSupporter {
    public static final String ORIGINKEY = "srforikey";
    public static final String CALLRESULT = "srfret";
    public static final String LASTENTITY = "SRFLASTENTITY";
    public static final int BOOLEAN_TRUE = 1;
    public static final int BOOLEAN_FALSE = 0;
    private SessionFactory sessionFactory = null;
    private boolean bMarkFullInfo = false;
    private HashMap<String, Object> entityPropertyMap = null;
    private IEntity proxyEntity = null;
    private IEntityActionHelper iEntityActionHelper = null;

    @Override
    protected void onReset() {
        this.markFullEntity(false);
        this.setSessionFactory(null);
        this.entityPropertyMap = null;
        this.setActionHelper(null);
        super.onReset();
    }

    @Override
    public void fillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (this.proxyEntity != null) {
            this.proxyEntity.fillMap(params, bDirtyOnly);
        } else {
            this.fillMap(params);
            this.onFillMap(params, bDirtyOnly);
        }
    }

    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
    }

    @Override
    public void markFullEntity(boolean bMarkFullInfo) {
        if (this.proxyEntity != null) {
            this.proxyEntity.markFullEntity(bMarkFullInfo);
        } else {
            this.bMarkFullInfo = bMarkFullInfo;
        }
    }

    @Override
    public boolean isFullEntity() {
        if (this.proxyEntity != null) {
            return this.proxyEntity.isFullEntity();
        }
        return this.bMarkFullInfo;
    }

    @Override
    public void copyTo(IDataObject dataEntity, boolean bReset, boolean bIncludeEmpty) throws Exception {
        if (this.proxyEntity != null) {
            this.proxyEntity.copyTo(dataEntity, bReset, bIncludeEmpty);
        } else {
            super.copyTo(dataEntity, bReset, bIncludeEmpty);
            this.onCopyTo(dataEntity, bIncludeEmpty);
        }
    }

    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        if (dataEntity instanceof IEntity) {
            ((IEntity)dataEntity).setSessionFactory(this.getSessionFactory());
            if (bIncludeEmtpy && this.isFullEntity()) {
                ((IEntity)dataEntity).markFullEntity(true);
            } else {
                ((IEntity)dataEntity).markFullEntity(false);
            }
        }
        if (dataEntity instanceof IEntityActionSupporter) {
            ((IEntityActionSupporter)((Object)dataEntity)).setActionHelper(this.getActionHelper(false));
        }
    }

    public static boolean hasDraftFlag(IEntity iEntity) throws Exception {
        Object objValue = iEntity.get("SRFDRAFTFLAG");
        return objValue != null;
    }

    public static boolean isDraft(IEntity iEntity) throws Exception {
        Object objValue = iEntity.get("SRFDRAFTFLAG");
        if (objValue == null) {
            return false;
        }
        return StringHelper.compare(objValue.toString(), "1", true) == 0;
    }

    public static void setDraft(IEntity iEntity, boolean bDraftFlag) throws Exception {
        iEntity.set("SRFDRAFTFLAG", bDraftFlag ? 1 : 0);
    }

    public static void setLastUpdateDate(IEntity iEntity, Timestamp timestamp) throws Exception {
        String strLastDateStr = StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", timestamp);
        iEntity.set("SRFUPDATEDATE", strLastDateStr);
    }

    public static void setIgnoreCheck(IEntity iEntity, boolean bIgnoreCheck) throws Exception {
        iEntity.set("SRFIGNORECHECK", bIgnoreCheck ? 1 : 0);
    }

    public static boolean isIgnoreCheck(IEntity iEntity) throws Exception {
        return DataObject.getIntegerValue(iEntity.get("SRFIGNORECHECK"), 0) == 1;
    }

    public static void setIgnoreCheckKey(IEntity iEntity, boolean bIgnoreCheckKey) throws Exception {
        iEntity.set("SRFIGNORECHECKKEY", bIgnoreCheckKey ? 1 : 0);
    }

    public static boolean isIgnoreCheckKey(IEntity iEntity) throws Exception {
        return DataObject.getIntegerValue(iEntity.get("SRFIGNORECHECKKEY"), 0) == 1;
    }

    public static Object getOriginKey(IEntity iEntity) throws Exception {
        return iEntity.get(ORIGINKEY);
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        if (this.proxyEntity != null) {
            this.proxyEntity.setSessionFactory(sessionFactory);
        } else {
            this.sessionFactory = sessionFactory;
        }
    }

    @Override
    public SessionFactory getSessionFactory() {
        if (this.proxyEntity != null) {
            return this.proxyEntity.getSessionFactory();
        }
        return this.sessionFactory;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyEntity = proxyDataObject == null ? null : (proxyDataObject instanceof IEntity ? (IEntity)proxyDataObject : null);
        super.onProxy(proxyDataObject);
    }

    @Override
    public synchronized void setEntityProperty(String strName, Object objValue) {
        if (this.proxyEntity != null) {
            this.proxyEntity.setEntityProperty(strName, objValue);
        } else if (objValue == null) {
            if (this.entityPropertyMap != null) {
                this.entityPropertyMap.remove(strName);
            }
        } else {
            if (this.entityPropertyMap == null) {
                this.entityPropertyMap = new HashMap();
            }
            this.entityPropertyMap.put(strName, objValue);
        }
    }

    @Override
    public synchronized Object getEntityProperty(String strName) {
        if (this.proxyEntity != null) {
            return this.proxyEntity.getEntityProperty(strName);
        }
        if (this.entityPropertyMap != null) {
            return this.entityPropertyMap.get(strName);
        }
        return null;
    }

    @Override
    public void setActionHelper(IEntityActionHelper iEntityActionHelper) {
        this.iEntityActionHelper = iEntityActionHelper;
    }

    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        if (this.iEntityActionHelper == null && bMust) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u64cd\u4f5c\u8f85\u52a9\u5bf9\u8c61");
        }
        return this.iEntityActionHelper;
    }

    @Override
    public void create() throws Exception {
        if (this.proxyEntity != null && this.proxyEntity instanceof IEntityActionSupporter) {
            ((IEntityActionSupporter)((Object)this.proxyEntity)).create();
            return;
        }
        this.getActionHelper(true).create(this);
    }

    @Override
    public void update() throws Exception {
        if (this.proxyEntity != null && this.proxyEntity instanceof IEntityActionSupporter) {
            ((IEntityActionSupporter)((Object)this.proxyEntity)).update();
            return;
        }
        this.getActionHelper(true).update(this);
    }

    @Override
    public void remove() throws Exception {
        if (this.proxyEntity != null && this.proxyEntity instanceof IEntityActionSupporter) {
            ((IEntityActionSupporter)((Object)this.proxyEntity)).remove();
            return;
        }
        this.getActionHelper(true).remove(this);
    }

    @Override
    public void save() throws Exception {
        if (this.proxyEntity != null && this.proxyEntity instanceof IEntityActionSupporter) {
            ((IEntityActionSupporter)((Object)this.proxyEntity)).save();
            return;
        }
        this.getActionHelper(true).save(this);
    }

    @Override
    public boolean get(boolean bTryMode) throws Exception {
        if (this.proxyEntity != null && this.proxyEntity instanceof IEntityActionSupporter) {
            return ((IEntityActionSupporter)((Object)this.proxyEntity)).get(bTryMode);
        }
        return this.getActionHelper(true).get(this, bTryMode);
    }

    @Override
    public void get() throws Exception {
        if (this.proxyEntity != null && this.proxyEntity instanceof IEntityActionSupporter) {
            ((IEntityActionSupporter)((Object)this.proxyEntity)).get();
            return;
        }
        this.getActionHelper(true).get(this, false);
    }

    @Override
    public boolean select(boolean bTryMode) throws Exception {
        if (this.proxyEntity != null && this.proxyEntity instanceof IEntityActionSupporter) {
            return ((IEntityActionSupporter)((Object)this.proxyEntity)).select(bTryMode);
        }
        return this.getActionHelper(true).select(this, bTryMode);
    }

    @Override
    public void select() throws Exception {
        if (this.proxyEntity != null && this.proxyEntity instanceof IEntityActionSupporter) {
            ((IEntityActionSupporter)((Object)this.proxyEntity)).select();
            return;
        }
        this.getActionHelper(true).select(this, false);
    }

    @Override
    public IEntityActionHelper getActionHelper() {
        return this.iEntityActionHelper;
    }

    public static IEntity getLast(IEntity iEntity) throws Exception {
        Object objValue = iEntity.get(LASTENTITY);
        if (objValue == null) {
            return null;
        }
        if (objValue instanceof IEntity) {
            return (IEntity)objValue;
        }
        return null;
    }

    public static void setLast(IEntity iEntity, IEntity lastEntity) throws Exception {
        if (lastEntity == null) {
            iEntity.remove(LASTENTITY);
        } else {
            iEntity.set(LASTENTITY, lastEntity);
        }
    }
}

