package net.ibizsys.model.pub.vue;

import java.util.List;

import SA.SRFramework.Utility.StringHelper;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

/**
 * 转为为js字符串
 * @author Administrator
 *
 */
public class PSVueFileNameMethod implements TemplateMethodModel
{
	public Object exec(List arg0) throws TemplateModelException
	{
		if(arg0.size()==0)
			return StringHelper.Format("");
		
		Object strValue = (Object)arg0.get(0);
		if(strValue == null)
			return "";
		
		String strSQLCode = (String)strValue;
		
		return replaceFullName(strSQLCode);
	}
	
	private String replaceFullName(String strFullName) {
		strFullName = strFullName.replaceAll("_", "-");
		int state = 0;//0代表前一个字母是小写，1代表前一个字母是大写
        String str = strFullName;
        StringBuilder strBuilder = new StringBuilder();
		if(Character.isUpperCase(str.charAt(0))){
			strBuilder.append(str.substring(0,1).toLowerCase());
			state = 1;
		} else {
			strBuilder.append(str.substring(0,1));
			state = 0;
		}
        for(int i = 1; i< str.length(); i++){
        	char chr = str.charAt(i);
            if(Character.isUpperCase(chr)){
            	if(state == 1){
            		strBuilder.append(str.substring(i,(i+1)).toLowerCase());
            	} else {
            		strBuilder.append("-");
            		strBuilder.append(str.substring(i,(i+1)).toLowerCase());
            	}
            	state = 1;
            } else {
            	strBuilder.append(chr);
            	state = 0;
            }
        }
        String resultStr = strBuilder.toString();
        resultStr = resultStr.replaceAll("--", "-");
        resultStr = resultStr.replaceAll("---", "-");
		return resultStr;
	}
}
