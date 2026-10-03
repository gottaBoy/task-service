package net.ibizsys.psop.zookeeper;

import java.util.ArrayList;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;

/**
 * 数据对象管理类，用于通用目的
 * 
 * @author Administrator
 *
 */
public class PSEntityKeeper extends PSObjectKeeperBase {

	private static final Log log = LogFactory.getLog(PSEntityKeeper.class);
	private PSEntityStruct psEntityStruct = null;
	private Object[] values = null;
	private String[] fields = null;
	private String strEntityKey = null;
	private String strFullPath = null;
	private int nLastVersion = 0;
	private long nLastActiveTime = 0l;
	private String[] folders = null;

	/**
	 * @param iPSZooKeeper
	 * @param psEntityStruct
	 * @throws Exception
	 */
	public PSEntityKeeper(IPSZooKeeper iPSZooKeeper, PSEntityStruct psEntityStruct, IEntity iEntity) throws Exception {
		super(iPSZooKeeper);

		this.strEntityKey = DataObject.getStringValue(iEntity, psEntityStruct.getKeyName(), "");
		if (StringHelper.isNullOrEmpty(this.strEntityKey)) {
			throw new Exception("数据对象主键无效");
		}
		this.psEntityStruct = psEntityStruct;
		
		ArrayList<String> folderList = new ArrayList<String>();
		exists(iPSZooKeeper.getDomain() + psEntityStruct.getPath(), "".getBytes(), true, false);
		folderList.add(iPSZooKeeper.getDomain() + psEntityStruct.getPath());
		
		String strPath = psEntityStruct.getPath();
		if (psEntityStruct.getFolders() != null) {
			for (int i = 0; i < psEntityStruct.getFolders().length; i++) {
				String strFolderValue = DataObject.getStringValue(iEntity, psEntityStruct.getFolders()[i], "");
				if (StringHelper.isNullOrEmpty(strFolderValue)) {
					throw new Exception(StringHelper.format("目录[%1$s]值无效", psEntityStruct.getFolders()[i]));
				}
				strPath += StringHelper.format("/%1$s", strFolderValue);
				exists(iPSZooKeeper.getDomain() + strPath, "".getBytes(), true, false);
				folderList.add(iPSZooKeeper.getDomain() + strPath);
			}
		}
		// 建立目录
		this.strFullPath = StringHelper.format("%1$s%2$s/%3$s", iPSZooKeeper.getDomain(), strPath, this.strEntityKey);
		Stat stat = exists(this.strFullPath, "".getBytes(), true);
		folderList.add(this.strFullPath);

		this.folders = folderList.toArray(new String[folderList.size()]);
		
		this.nLastVersion = stat.getVersion();

		fields = psEntityStruct.getFields();
		if (fields != null) {
			values = new Object[fields.length];
		}

		updatePSEntity(iEntity);
	}

	/**
	 * @param iPSZooKeeper
	 * @throws Exception
	 */
	public PSEntityKeeper(IPSZooKeeper iPSZooKeeper) throws Exception {
		super(iPSZooKeeper);

	}

	protected boolean updateValues(IEntity iEntity) throws Exception {
		boolean bUpdate = false;
		if (fields != null) {
			for (int i = 0; i < fields.length; i++) {
				if (iEntity.contains(fields[i])) {
					values[i] = iEntity.get(fields[i]);
					bUpdate = true;
				}
			}
		}
		return bUpdate;
	}

	protected void getPSEntity() throws Exception {
		Stat stat = new Stat();
		byte[] bytes = getData(this.strFullPath, stat);
		JSONObject jo = null;
		if ((bytes != null) && (bytes.length != 0))
			jo = JSONObject.fromString(new String(bytes, "UTF-8"));

		this.nLastActiveTime = System.currentTimeMillis();
		this.nLastVersion = stat.getVersion();
		if (jo == null) {
			return;
		} else {
			if (fields != null) {
				for (int i = 0; i < fields.length; i++) {
					if (jo.has(fields[i])) {
						values[i] = fromJSONValue(jo.opt(fields[i]));
					}
				}
			}
		}
		log.debug(StringHelper.format("平台对象[%1$s][%2$s]变化", this.psEntityStruct.getEntityName(), this.strEntityKey));
	}

	protected void onProcessEvent(WatchedEvent event) throws Exception {
		super.onProcessEvent(event);
		this.nLastActiveTime = System.currentTimeMillis();
		if (StringHelper.isNullOrEmpty(event.getType())) {
			return;
		}

		if (event.getType() == Watcher.Event.EventType.NodeCreated) {
			return;
		}

		if (event.getType() == Watcher.Event.EventType.NodeDataChanged) {
			if (StringHelper.compare(event.getPath(), this.strFullPath, true) == 0) {
				getPSEntity();
				return;
			}
			return;
		}

		if (event.getType() == Watcher.Event.EventType.NodeDeleted)
			return;
	}

	protected byte[] getPSEntityData() throws Exception {
		JSONObject jo = new JSONObject();
		if (fields != null) {
			for (int i = 0; i < fields.length; i++) {
				jo.put(fields[i], getJSONValue(values[i]));
			}
		}
		return jo.toString().getBytes("UTF-8");
	}

	/**
	 * 更新数据对象值
	 * 
	 * @param iEntity
	 * @param bGet
	 * @throws Exception
	 */
	public void getPSEntity(IEntity iEntity, boolean bGet) throws Exception {
		if (iEntity instanceof IPSZooKeeperEntity) {
			getPSEntityEx((IPSZooKeeperEntity) iEntity, bGet);
			return;
		}
		if (bGet) {
			getPSEntity();
		}
		if (fields != null) {
			for (int i = 0; i < fields.length; i++) {
				iEntity.set(fields[i], values[i]);
			}
		}
	}

	/**
	 * 更新数据对象值
	 * 
	 * @param iEntity
	 * @param bGet
	 * @throws Exception
	 */
	public void getPSEntityEx(IPSZooKeeperEntity iEntity, boolean bGet) throws Exception {
		if (bGet) {
			getPSEntity();
		}
		if (iEntity.getZKDataVersion() == this.nLastVersion)
			return;

		if (fields != null) {
			for (int i = 0; i < fields.length; i++) {
				iEntity.set(fields[i], values[i]);
			}
		}
	}

	/**
	 * 更新数据对象值
	 * 
	 * @param iEntity
	 * @param bGet
	 * @throws Exception
	 */
	public void updatePSEntity(IEntity iEntity) throws Exception {

		if (iEntity instanceof IPSZooKeeperEntity) {
			updatePSEntityEx((IPSZooKeeperEntity) iEntity);
			return;
		}

		updateValues(iEntity);
		try {
			Stat stat = setData(this.strFullPath, getPSEntityData(), this.nLastVersion);
			this.nLastVersion = stat.getVersion();
			this.nLastActiveTime = System.currentTimeMillis();
			return;
		} catch (Exception ex) {
			log.error(StringHelper.format("更新平台对象发生错误, %1$s", ex.getMessage()), ex);
			// 可能版本有无，重新获取
			this.getPSEntity();
			updateValues(iEntity);
			setData(this.strFullPath, getPSEntityData(), this.nLastVersion);
			this.nLastActiveTime = System.currentTimeMillis();
		}
	}

	/**
	 * 更新数据对象值
	 * 
	 * @param iEntity
	 * @param bGet
	 * @throws Exception
	 */
	public void updatePSEntityEx(IPSZooKeeperEntity iEntity) throws Exception {
		updateValues(iEntity);
		try {
			Stat stat = setData(this.strFullPath, getPSEntityData(), this.nLastVersion);
			this.nLastVersion = stat.getVersion();
			this.nLastActiveTime = System.currentTimeMillis();
			iEntity.setZKDataVersion(this.nLastVersion);
			return;
		} catch (Exception ex) {
			log.error(StringHelper.format("更新平台对象发生错误, %1$s", ex.getMessage()), ex);
			// 可能版本有无，重新获取
			this.getPSEntity();
			updateValues(iEntity);
			Stat stat = setData(this.strFullPath, getPSEntityData(), this.nLastVersion);
			this.nLastVersion = stat.getVersion();
			this.nLastActiveTime = System.currentTimeMillis();
			iEntity.setZKDataVersion(this.nLastVersion);
		}
	}

	/**
	 * 获取json的值
	 * 
	 * @param objValue
	 * @return
	 * @throws Exception
	 */
	protected static Object getJSONValue(Object objValue) throws Exception {
		if (objValue == null) return JSONNull.getInstance();
		
		Long nValue  = null;
		if (objValue instanceof java.sql.Timestamp) {
			nValue = ((java.sql.Timestamp) objValue).getTime();
		}
		else if (objValue instanceof java.sql.Date) {
			nValue = ((java.sql.Date) objValue).getTime();
		} else 
		if (objValue instanceof java.util.Date) {
			nValue = ((java.util.Date) objValue).getTime();
		} else
			return objValue;
		
		JSONObject dt = new JSONObject();
		if(nValue <0 ){
			/**
			 * JSON组件包有BUG
			 */
			dt.put("timestr",Long.toString(nValue));
		}
		else
			dt.put("time", nValue);
		return dt;
	}

	/**
	 * 对Json值进行转换
	 * 
	 * @param objValue
	 * @return
	 * @throws Exception
	 */
	protected static Object fromJSONValue(Object objValue) throws Exception {
		if (objValue == null)
			return null;
		if (objValue instanceof JSONNull) {
			return null;
		} else if (objValue instanceof JSONArray) {
			// baseDataEntity.set(objKey.toString(),
			// DataObjectList.fromJSONArray((JSONArray) objValue));
			return null;
		} else if (objValue instanceof JSONObject) {
			JSONObject jo = (JSONObject) objValue;
			if (jo.has("time")||jo.has("timestr")) {
				long lTime = 0l;
				if(jo.has("timestr")){
					lTime = Long.parseLong(jo.getString("timestr"));
				}
				else{
					lTime = jo.getLong("time");
				}
				java.sql.Timestamp date = new java.sql.Timestamp(lTime);
				return date;
			} else {
				return jo.toString();
			}
		} else {
			return objValue;
		}
	}

	public long getLastActiveTime() {
		return this.nLastActiveTime;
	}

}
