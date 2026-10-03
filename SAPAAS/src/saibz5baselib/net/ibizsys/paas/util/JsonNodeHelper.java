package net.ibizsys.paas.util;

import java.math.BigInteger;
import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Jackson Json 对象辅助对象
 * @author Administrator
 *
 */
public class JsonNodeHelper {

	/**
	 * 设置对象属性
	 * 
	 * @param jsonObject
	 * @param strPropertyName
	 * @param objValue
	 * @throws Exception
	 */
	public static void put(ObjectNode jsonObject, String strPropertyName, Object objValue) throws Exception {
		put(jsonObject, strPropertyName, objValue, true);
	}

	/**
	 * 设置对象属性
	 * 
	 * @param jsonObject
	 * @param strPropertyName
	 * @param objValue
	 * @param bRemoveIfExists 如存在属性，是否移除，不移除则忽略
	 * @throws Exception
	 */
	public static void put(ObjectNode jsonObject, String strPropertyName, Object objValue, boolean bRemoveIfExists) throws Exception {
		if (jsonObject.has(strPropertyName)) {
			if (bRemoveIfExists)
				jsonObject.remove(strPropertyName);
			else
				return;
		}
		
		if(objValue == null){
			jsonObject.putNull(strPropertyName);
			return;
		}

		if(objValue instanceof JsonNode){
			jsonObject.put(strPropertyName, (JsonNode)objValue);
			return;
		}

		if (objValue instanceof String)  {
			jsonObject.put(strPropertyName, (String)objValue);
			return;
		}
		
		if (objValue instanceof Character)  {
			jsonObject.put(strPropertyName, (Character)objValue);
			return;
		}
		
//		if (objValue instanceof BigInteger)  {
//			jsonObject.put(strPropertyName, (Long)objValue);
//			return;
//		}
		
		if (objValue instanceof BigInteger)  {
			jsonObject.put(strPropertyName, ((BigInteger)objValue).longValue());
			return;
		}
		
		if (objValue instanceof Long)  {
			jsonObject.put(strPropertyName, (Long)objValue);
			return;
		}
		
		if (objValue instanceof Integer)  {
			jsonObject.put(strPropertyName, (Integer)objValue);
			return;
		}
		
		if (objValue instanceof Float)  {
			jsonObject.put(strPropertyName, (Float)objValue);
			return;
		}
		
		if (objValue instanceof Double)  {
			jsonObject.put(strPropertyName, (Double)objValue);
			return;
		}
		
		if (objValue instanceof Boolean)  {
			jsonObject.put(strPropertyName, (Boolean)objValue);
			return;
		}
		
		if (objValue instanceof java.math.BigDecimal)  {
			jsonObject.put(strPropertyName, ((java.math.BigDecimal)objValue).doubleValue());
			return;
		}
		
//		if (objValue instanceof java.sql.Timestamp)  {
//			jsonObject.put(strPropertyName, ((java.sql.Timestamp)objValue));
//			return;
//		}
		
		if(objValue instanceof java.util.List){
			ArrayNode arrayNode = jsonObject.putArray(strPropertyName);
			for(Object obj:(java.util.List)objValue){
				add(arrayNode,obj);
			}
			return;
		}
		
		throw new Exception(StringHelper.format("不支持的对象类型[%1$s]",objValue.getClass().getCanonicalName()));
	}

	
	/**
	 * 设置对象属性
	 * 
	 * @param jsonObject
	 * @param strPropertyName
	 * @param objValue
	 * @param bRemoveIfExists 如存在属性，是否移除，不移除则忽略
	 * @throws Exception
	 */
	public static void add(ArrayNode arrayNode, Object objValue) throws Exception {
		if(objValue == null){
			arrayNode.addNull();
			return;
		}

		if(objValue instanceof JsonNode){
			arrayNode.add((JsonNode)objValue);
			return;
		}

		if (objValue instanceof String)  {
			arrayNode.add((String)objValue);
			return;
		}
		
		if (objValue instanceof Character)  {
			arrayNode.add((Character)objValue);
			return;
		}
		
		if (objValue instanceof BigInteger)  {
			arrayNode.add((Long)objValue);
			return;
		}
		
		if (objValue instanceof BigInteger)  {
			arrayNode.add(((BigInteger)objValue).longValue());
			return;
		}
		
		if (objValue instanceof Long)  {
			arrayNode.add((Long)objValue);
			return;
		}
		
		if (objValue instanceof Integer)  {
			arrayNode.add((Integer)objValue);
			return;
		}
		
		if (objValue instanceof Float)  {
			arrayNode.add((Float)objValue);
			return;
		}
		
		if (objValue instanceof Double)  {
			arrayNode.add((Double)objValue);
			return;
		}
		
		if (objValue instanceof java.math.BigDecimal)  {
			arrayNode.add(((java.math.BigDecimal)objValue).doubleValue());
			return;
		}
		
		throw new Exception(StringHelper.format("不支持的对象类型[%1$s]",objValue.getClass().getCanonicalName()));
	}
	
	
	/**
	 * 删除对象属性
	 * 
	 * @param jsonObject
	 * @param strPropertyName
	 * @throws Exception
	 */
	public static void remove(ObjectNode jsonObject, String strPropertyName) throws Exception {
		if (jsonObject.has(strPropertyName)) {
			jsonObject.remove(strPropertyName);
		}
	}
	
	
	/**
	 * 建立对象节点
	 * @return
	 */
	public static ObjectNode createObjectNode(){
		ObjectMapper objMapper = new ObjectMapper();
		return objMapper.createObjectNode();
	}
	
	/**
	 * 从字符串导出
	 * @param strJsonString
	 * @return
	 * @throws Exception
	 */
	public static JsonNode fromString(String strJsonString) throws Exception{
		JsonNode editorNode = new ObjectMapper().readTree(strJsonString);
		return editorNode;
	}
	
	

	/**
	 * 获取属性字符串值
	 * @param jsonObject
	 * @param strPropertyName
	 * @param strDefault
	 * @return
	 * @throws Exception
	 */
	public static String getString(ObjectNode jsonObject, String strPropertyName, String strDefault)throws Exception{
		JsonNode valueNode = jsonObject.get(strPropertyName);
		if(valueNode == null)
			return strDefault;
		return valueNode.asText();
	}
	
	/**
	 * 获取属性布尔值
	 * @param jsonObject
	 * @param strPropertyName
	 * @param bDefault
	 * @return
	 * @throws Exception
	 */
	public static boolean getBoolean(ObjectNode jsonObject, String strPropertyName, boolean bDefault)throws Exception{
		JsonNode valueNode = jsonObject.get(strPropertyName);
		if(valueNode == null)
			return bDefault;
		return valueNode.asBoolean();
	}
	
	
	/**
	 * 获取属性整数值
	 * @param jsonObject
	 * @param strPropertyName
	 * @param strDefault
	 * @return
	 * @throws Exception
	 */
	public static int getInt(ObjectNode jsonObject, String strPropertyName, int nDefault)throws Exception{
		JsonNode valueNode = jsonObject.get(strPropertyName);
		if(valueNode == null)
			return nDefault;
		return valueNode.asInt();
	}
	
	
	/**
	 * 获取属性Long值
	 * @param jsonObject
	 * @param strPropertyName
	 * @param strDefault
	 * @return
	 * @throws Exception
	 */
	public static long getLong(ObjectNode jsonObject, String strPropertyName, long nDefault)throws Exception{
		JsonNode valueNode = jsonObject.get(strPropertyName);
		if(valueNode == null)
			return nDefault;
		return valueNode.asLong();
	}
	
	
	/**
	 * 获取属性Double值
	 * @param jsonObject
	 * @param strPropertyName
	 * @param strDefault
	 * @return
	 * @throws Exception
	 */
	public static double getDouble(ObjectNode jsonObject, String strPropertyName, double fDefault)throws Exception{
		JsonNode valueNode = jsonObject.get(strPropertyName);
		if(valueNode == null)
			return fDefault;
		return valueNode.asDouble();
	}
	
	
	

	
	/**
	 * 获取属性Json数组值
	 * @param jsonObject
	 * @param strPropertyName
	 * @return
	 * @throws Exception
	 */
	public static ArrayNode getArray(ObjectNode jsonObject, String strPropertyName)throws Exception{
		JsonNode valueNode = jsonObject.get(strPropertyName);
		if(valueNode == null)
			return null;
		if(!(valueNode instanceof ArrayNode)){
			throw new Exception(StringHelper.format("无法讲值[%1$s]转换为节Json数组",valueNode.getClass().getCanonicalName()));
		}
		return (ArrayNode)valueNode;
	}
	
	
	/**
	 * 获取属性Json对象
	 * @param jsonObject
	 * @param strPropertyName
	 * @return
	 * @throws Exception
	 */
	public static ObjectNode getObject(ObjectNode jsonObject, String strPropertyName)throws Exception{
		JsonNode valueNode = jsonObject.get(strPropertyName);
		if(valueNode == null)
			return null;
		if(!(valueNode instanceof ObjectNode)){
			throw new Exception(StringHelper.format("无法讲值[%1$s]转换为节Json对象",valueNode.getClass().getCanonicalName()));
		}
		return (ObjectNode)valueNode;
	}
	
	/**
	 * 拷贝节点
	 * @param dstObjectNode
	 * @param srcObjectNode
	 * @param bIgnoreExits 忽略存在
	 * @return
	 * @throws Exception
	 */
	public static ObjectNode copy(ObjectNode dstObjectNode,ObjectNode srcObjectNode,boolean bIgnoreExits)throws Exception{
		return copy(dstObjectNode,srcObjectNode,bIgnoreExits,null);
	}
	
	
	/**
	 * 
	 * @param dstObjectNode
	 * @param srcObjectNode
	 * @param ignoreFields
	 * @param bIgnoreExits 忽略存在
	 * @return
	 * @throws Exception
	 */
	public static ObjectNode copy(ObjectNode dstObjectNode,ObjectNode srcObjectNode,boolean bIgnoreExits,String[] ignoreFields)throws Exception{
		if(dstObjectNode == null){
			dstObjectNode = createObjectNode();
		}
		
		HashMap<String,String> ignoreFieldMap = null;
		if(ignoreFields != null &&ignoreFields.length>0){
			ignoreFieldMap = new HashMap<String,String>();
			for(String strField:ignoreFields){
				ignoreFieldMap.put(strField, "");
			}
		}
		
		ObjectNode cloneObjectNode = srcObjectNode.deepCopy();
		java.util.Iterator<String> fieldNames = srcObjectNode.fieldNames();
		if(fieldNames!=null){
			while(fieldNames.hasNext()){
				String strFieldName = fieldNames.next();
				if(ignoreFieldMap!=null && ignoreFieldMap.containsKey(strFieldName))
					continue;
				if(bIgnoreExits && dstObjectNode.has(strFieldName))
					continue;
				dstObjectNode.put(strFieldName, cloneObjectNode.get(strFieldName));
			}
		}
		
		return srcObjectNode;
	}
	
}
