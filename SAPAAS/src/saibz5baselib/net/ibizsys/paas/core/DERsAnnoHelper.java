package net.ibizsys.paas.core;

import java.util.HashMap;

/**
 * 关系注解辅助对象
 * 
 * @author lionlau
 *
 */
public class DERsAnnoHelper {

	private HashMap<String, DER> derMap = new HashMap<String, DER>();
	private DERs ders = null;

	public DERsAnnoHelper(DERs ders) {
		this.ders = ders;

		for (DER der : this.ders.value()) {
			derMap.put(der.id(), der);
			derMap.put(der.name(), der);
		}
	}

	public DER getDER1N(String strName) throws Exception {
		DER der = derMap.get(strName);
		return der;
	}

}
