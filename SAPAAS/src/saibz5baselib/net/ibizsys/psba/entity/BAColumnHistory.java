package net.ibizsys.psba.entity;

import java.util.TreeMap;

/**
 * 大数据列历史管理对象
 * @author Administrator
 *
 */
public class BAColumnHistory {

	private TreeMap<Long,Object> valueMap = new TreeMap<Long,Object>();
	
	/**
	 * 获取版本集合
	 * @return
	 */
	public java.util.Iterator<Long> getTimestamps(){
		return valueMap.keySet().iterator();
	}
	
	
	/**
	 * 获取版本值
	 * @param nTimestamp
	 * @return
	 */
	public Object getValue(long nTimestamp) throws Exception{
		if(nTimestamp>0){
			if(!this.valueMap.containsKey(nTimestamp)){
				throw new Exception("不存在指定时间变更数据");
			}
			return this.valueMap.get(nTimestamp);
		}
		else{
			long nIndex = nTimestamp;
			Long nLastKey = valueMap.lastEntry().getKey();
			while(nIndex<0){
				nLastKey = valueMap.lowerKey(nLastKey);
				if(nLastKey == null)
					return null;
				nIndex++;
			}
			return valueMap.get(nLastKey);
		}
		
	}
	
	
	
	/**
	 * 设置值
	 * @param nTimestamp
	 * @param objValue
	 */
	public void setValue(long nTimestamp,Object objValue){
		this.valueMap.put(nTimestamp, objValue);
	}
	
	/**
	 * 获取最新的值
	 * @return
	 */
	public Object getLastValue(){
		if(this.valueMap.size() == 0)
			return null;
		return valueMap.lastEntry().getValue();
	}
}
