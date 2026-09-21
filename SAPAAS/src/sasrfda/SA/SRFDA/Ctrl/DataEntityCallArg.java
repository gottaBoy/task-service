/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.HashMap;

public class DataEntityCallArg
extends BaseDataEntity {
    private HashMap<String, Object> extCallArgMap = new HashMap();

    public void setExtCallArg(String strArg, Object objValue) {
        strArg = strArg.toUpperCase();
        if (objValue == null) {
            this.extCallArgMap.remove(strArg);
        } else {
            this.extCallArgMap.put(strArg, objValue);
        }
    }

    public Object getExtCallArg(String strArg, Object objDefault) {
        Object objValue = this.extCallArgMap.get(strArg = strArg.toUpperCase());
        if (objValue == null) {
            return objDefault;
        }
        return objValue;
    }

    public Boolean getExtCallArg(String strArg, Boolean bDefault) {
        Object objValue = this.extCallArgMap.get(strArg = strArg.toUpperCase());
        if (objValue == null) {
            return bDefault;
        }
        return (Boolean)objValue;
    }

    public String getExtCallArg(String strArg, String strDefault) {
        Object objValue = this.extCallArgMap.get(strArg = strArg.toUpperCase());
        if (objValue == null) {
            return strDefault;
        }
        return (String)objValue;
    }

    public Integer getExtCallArg(String strArg, Integer nDefault) {
        Object objValue = this.extCallArgMap.get(strArg = strArg.toUpperCase());
        if (objValue == null) {
            return nDefault;
        }
        return (Integer)objValue;
    }

    public Long getExtCallArg(String strArg, Long nDefault) {
        Object objValue = this.extCallArgMap.get(strArg = strArg.toUpperCase());
        if (objValue == null) {
            return nDefault;
        }
        return (Long)objValue;
    }

    public Double getExtCallArg(String strArg, Double fDefault) {
        Object objValue = this.extCallArgMap.get(strArg = strArg.toUpperCase());
        if (objValue == null) {
            return fDefault;
        }
        return (Double)objValue;
    }
}

