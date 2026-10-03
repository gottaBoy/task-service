package net.ibizsys.paas.entity;

import java.util.HashMap;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.service.ServiceBase;
import net.ibizsys.paas.util.StringHelper;

/**
 * 基础数据对象
 * 
 * @author lionlau
 *
 */
public abstract class EntityBase extends DataObject implements IEntity, IEntityActionSupporter {
	/**
	 * 原来的键值
	 */
	public final static String ORIGINKEY = "srforikey";

	/**
	 * 调用结果
	 */
	public final static String CALLRESULT = "srfret";

	/**
	 * 上一次的数据对象
	 */
	public final static String LASTENTITY = "SRFLASTENTITY";

	/**
	 * Boolean 值，True
	 */
	public final static int BOOLEAN_TRUE = 1;

	/**
	 * Boolean 值，False
	 */
	public final static int BOOLEAN_FALSE = 0;

	private SessionFactory sessionFactory = null;

	private boolean bMarkFullInfo = false;

	private HashMap<String, Object> entityPropertyMap = null;

	private IEntity proxyEntity = null;

	private IEntityActionHelper iEntityActionHelper = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.DataObject#onReset()
	 */
	protected void onReset() {

		/**
		 * 20171124 修改，重置相关变量
		 */
		this.markFullEntity(false);
		this.setSessionFactory(null);
		this.entityPropertyMap = null;
		this.setActionHelper(null);
		/**
		 * 20171124 修改结束
		 */

		super.onReset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.entity.IEntity#fillMap(java.util.HashMap, boolean)
	 */
	@Override
	public void fillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
		if (this.proxyEntity != null) {
			this.proxyEntity.fillMap(params, bDirtyOnly);
		} else {
			this.fillMap(params);
			onFillMap(params, bDirtyOnly);
		}
	}

	/**
	 * 填充Map
	 * 
	 * @param params
	 * @param bDirtyOnly
	 */
	protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.entity.IEntity#markFullEntity(boolean)
	 */
	@Override
	public void markFullEntity(boolean bMarkFullInfo) {
		if (this.proxyEntity != null) {
			this.proxyEntity.markFullEntity(bMarkFullInfo);
		} else {
			this.bMarkFullInfo = bMarkFullInfo;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.entity.IEntity#isFullEntity()
	 */
	@Override
	public boolean isFullEntity() {
		if (this.proxyEntity != null) {
			return this.proxyEntity.isFullEntity();
		} else {
			return this.bMarkFullInfo;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.DataObject#copyTo(net.ibizsys.paas.data.IDataObject, boolean, boolean)
	 */
	@Override
	public void copyTo(IDataObject dataEntity, boolean bReset, boolean bIncludeEmpty) throws Exception {
		if (this.proxyEntity != null) {
			this.proxyEntity.copyTo(dataEntity, bReset, bIncludeEmpty);
		} else {
			super.copyTo(dataEntity, bReset, bIncludeEmpty);
			onCopyTo(dataEntity, bIncludeEmpty);
		}
	}

	/**
	 * 拷贝数据对目标对象
	 * 
	 * @param dataEntity
	 * @param bIncludeEmtpy
	 * @throws Exception
	 */
	protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
		if (dataEntity instanceof IEntity) {
			((IEntity) dataEntity).setSessionFactory(this.getSessionFactory());
			/**
			 * 20170911 修改，设置目标数据对象为完整信息
			 */
			if (bIncludeEmtpy && this.isFullEntity()) {
				((IEntity) dataEntity).markFullEntity(true);
			} else {
				((IEntity) dataEntity).markFullEntity(false);
			}
		}
		if (dataEntity instanceof IEntityActionSupporter) {
			((IEntityActionSupporter) dataEntity).setActionHelper(this.getActionHelper(false));
		}
	}

	/**
	 * 是否有草稿标志
	 * 
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	public static boolean hasDraftFlag(IEntity iEntity) throws Exception {
		Object objValue = iEntity.get(ServiceBase.DRAFTFLAG);
		if (objValue == null) return false;
		return true;
	}

	/**
	 * 是否为草稿
	 * 
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	public static boolean isDraft(IEntity iEntity) throws Exception {
		Object objValue = iEntity.get(ServiceBase.DRAFTFLAG);
		if (objValue == null) return false;
		if (StringHelper.compare(objValue.toString(), "1", true) == 0) return true;
		return false;
	}

	/**
	 * 设置草稿状态
	 * 
	 * @param iEntity
	 * @param bDraftFlag
	 * @throws Exception
	 */
	public static void setDraft(IEntity iEntity, boolean bDraftFlag) throws Exception {
		iEntity.set(ServiceBase.DRAFTFLAG, bDraftFlag ? 1 : 0);

	}

	/**
	 * 设置最后更新时间
	 * 
	 * @param iEntity
	 * @param timestamp
	 * @throws Exception
	 */
	public static void setLastUpdateDate(IEntity iEntity, java.sql.Timestamp timestamp) throws Exception {
		String strLastDateStr = StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", timestamp);
		iEntity.set(ServiceBase.LASTUPDATEDATE, strLastDateStr);
	}

	/**
	 * 设置是否忽略检查
	 * 
	 * @param iEntity
	 * @param bIgnoreCheck
	 * @throws Exception
	 */
	public static void setIgnoreCheck(IEntity iEntity, boolean bIgnoreCheck) throws Exception {
		iEntity.set(ServiceBase.IGNORECHECK, bIgnoreCheck ? 1 : 0);
	}

	/**
	 * 获取是否忽略检查
	 * 
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	public static boolean isIgnoreCheck(IEntity iEntity) throws Exception {
		return DataObject.getIntegerValue(iEntity.get(ServiceBase.IGNORECHECK), 0) == 1;
	}

	/**
	 * 设置是否忽略检查主键
	 * 
	 * @param iEntity
	 * @param bIgnoreCheckKey
	 * @throws Exception
	 */
	public static void setIgnoreCheckKey(IEntity iEntity, boolean bIgnoreCheckKey) throws Exception {
		iEntity.set(ServiceBase.IGNORECHECKKEY, bIgnoreCheckKey ? 1 : 0);
	}

	/**
	 * 获取是否忽略检查主键
	 * 
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	public static boolean isIgnoreCheckKey(IEntity iEntity) throws Exception {
		return DataObject.getIntegerValue(iEntity.get(ServiceBase.IGNORECHECKKEY), 0) == 1;
	}

	/**
	 * 获取原来的数据主键
	 * 
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	public static Object getOriginKey(IEntity iEntity) throws Exception {
		return iEntity.get(ORIGINKEY);
	}

	/**
	 * 设置会话工厂
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		if (this.proxyEntity != null) {
			this.proxyEntity.setSessionFactory(sessionFactory);
		} else {
			this.sessionFactory = sessionFactory;
		}
	}

	/**
	 * 设置会话工厂
	 * 
	 * @param sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		if (this.proxyEntity != null) {
			return this.proxyEntity.getSessionFactory();
		} else {
			return this.sessionFactory;
		}
	}

	/**
	 * 代理数据对象
	 * 
	 * @param proxyDataObject
	 */
	@Override
	protected void onProxy(IDataObject proxyDataObject) {
		if (proxyDataObject == null) {
			this.proxyEntity = null;
		} else {
			if (proxyDataObject instanceof IEntity) {
				this.proxyEntity = (IEntity) proxyDataObject;
			} else {
				this.proxyEntity = null;
			}
		}
		super.onProxy(proxyDataObject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.entity.IEntity#setEntityProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public synchronized void setEntityProperty(String strName, Object objValue) {
		if (this.proxyEntity != null) {
			this.proxyEntity.setEntityProperty(strName, objValue);
		} else {
			if (objValue == null) {
				if (this.entityPropertyMap != null) {
					this.entityPropertyMap.remove(strName);
				}
			} else {
				if (this.entityPropertyMap == null) {
					this.entityPropertyMap = new HashMap<String, Object>();
				}
				this.entityPropertyMap.put(strName, objValue);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.entity.IEntity#getEntityProperty(java.lang.String)
	 */
	@Override
	public synchronized Object getEntityProperty(String strName) {
		if (this.proxyEntity != null) {
			return this.proxyEntity.getEntityProperty(strName);
		} else {
			if (this.entityPropertyMap != null) {
				return this.entityPropertyMap.get(strName);
			}
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.entity.IEntityActionSupporter#setActionHelper(net.ibizsys.paas.entity.IEntityActionHelper)
	 */
	@Override
	public void setActionHelper(IEntityActionHelper iEntityActionHelper) {
		this.iEntityActionHelper = iEntityActionHelper;
	}

	/**
	 * 获取操作辅助对象
	 * 
	 * @param bMust 是否必须存在
	 * @return
	 */
	protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
		if (this.iEntityActionHelper == null && bMust) {
			throw new Exception("没有指定操作辅助对象");
		}
		return this.iEntityActionHelper;
	}

	@Override
	public void create() throws Exception {
		if (this.proxyEntity != null && (this.proxyEntity instanceof IEntityActionSupporter)) {
			((IEntityActionSupporter) this.proxyEntity).create();
			return;
		}
		getActionHelper(true).create(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.entity.IEntityActionSupporter#update()
	 */
	@Override
	public void update() throws Exception {
		if (this.proxyEntity != null && (this.proxyEntity instanceof IEntityActionSupporter)) {
			((IEntityActionSupporter) this.proxyEntity).update();
			return;
		}
		getActionHelper(true).update(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.entity.IEntityActionSupporter#remove()
	 */
	@Override
	public void remove() throws Exception {
		if (this.proxyEntity != null && (this.proxyEntity instanceof IEntityActionSupporter)) {
			((IEntityActionSupporter) this.proxyEntity).remove();
			return;
		}
		getActionHelper(true).remove(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.entity.IEntityActionSupporter#save()
	 */
	@Override
	public void save() throws Exception {
		if (this.proxyEntity != null && (this.proxyEntity instanceof IEntityActionSupporter)) {
			((IEntityActionSupporter) this.proxyEntity).save();
			return;
		}
		getActionHelper(true).save(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.entity.IEntityActionSupporter#get(boolean)
	 */
	@Override
	public boolean get(boolean bTryMode) throws Exception {
		if (this.proxyEntity != null && (this.proxyEntity instanceof IEntityActionSupporter)) {
			return ((IEntityActionSupporter) this.proxyEntity).get(bTryMode);
		}
		return getActionHelper(true).get(this, bTryMode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.entity.IEntityActionSupporter#get()
	 */
	@Override
	public void get() throws Exception {
		if (this.proxyEntity != null && (this.proxyEntity instanceof IEntityActionSupporter)) {
			((IEntityActionSupporter) this.proxyEntity).get();
			return;
		}
		getActionHelper(true).get(this, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.entity.IEntityActionSupporter#select(boolean)
	 */
	@Override
	public boolean select(boolean bTryMode) throws Exception {
		if (this.proxyEntity != null && (this.proxyEntity instanceof IEntityActionSupporter)) {
			return ((IEntityActionSupporter) this.proxyEntity).select(bTryMode);
		}
		return getActionHelper(true).select(this, bTryMode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.entity.IEntityActionSupporter#select()
	 */
	@Override
	public void select() throws Exception {
		if (this.proxyEntity != null && (this.proxyEntity instanceof IEntityActionSupporter)) {
			((IEntityActionSupporter) this.proxyEntity).select();
			return;
		}
		getActionHelper(true).select(this, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.entity.IEntityActionSupporter#getActionHelper()
	 */
	@Override
	public IEntityActionHelper getActionHelper() {
		return this.iEntityActionHelper;
	}

	/**
	 * 获取上一次的数据对象
	 * 
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	public static IEntity getLast(IEntity iEntity) throws Exception {
		Object objValue = iEntity.get(LASTENTITY);
		if (objValue == null) return null;
		if (objValue instanceof IEntity) return (IEntity) objValue;
		return null;
	}

	/**
	 * 设置上一次的数据对象
	 * 
	 * @param iEntity
	 * @param lastEntity
	 * @throws Exception
	 */
	public static void setLast(IEntity iEntity, IEntity lastEntity) throws Exception {
		if (lastEntity == null) {
			iEntity.remove(LASTENTITY);
		} else {
			iEntity.set(LASTENTITY, lastEntity);
		}
	}

}
