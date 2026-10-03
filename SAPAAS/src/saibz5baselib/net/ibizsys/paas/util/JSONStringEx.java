package net.ibizsys.paas.util;

import java.io.IOException;
import java.io.Writer;

import net.sf.json.JSON;
import net.sf.json.JSONException;

/**
 * 扩展字符串，解决 '、"、[、{ 问题
 * @author Administrator
 *
 */
public class JSONStringEx implements JSON {

	private String strValue = null;

	public JSONStringEx(String strValue) {
		this.strValue = strValue;
	}

	public boolean equals(Object object) {
		return this.strValue.equals(object);
	}

	public int hashCode() {
		return this.strValue.hashCode();
	}

	public boolean isArray() {
		return false;
	}

	public int length() {
		return this.strValue.length();
	}

	public String toString() {
		return this.strValue;
	}

	public String toString(int indentFactor) {
		return toString();
	}

	public String toString(int indentFactor, int indent) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < indent; ++i)
			sb.append(' ');

		sb.append(toString());
		return sb.toString();
	}

	public Writer write(Writer writer) {
		try {
			writer.write(toString());
			return writer;
		} catch (IOException e) {
			throw new JSONException(e);
		}
	}
}
