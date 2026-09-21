/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.entity;

import java.sql.Timestamp;
import java.util.Date;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseDataEntity
extends EntityBase {
    private static final Log log = LogFactory.getLog(BaseDataEntity.class);

    public boolean isParamNull(String strParamName) {
        try {
            return super.isNull(strParamName);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return true;
        }
    }

    public String getParamStringValue(String strParamName, String strDefault) {
        try {
            return EntityBase.getStringValue((IDataObject)this, (String)strParamName, (String)strDefault);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return strDefault;
        }
    }

    public int getParamIntValue(String strParamName, int nDefault) {
        try {
            return EntityBase.getIntegerValue((IDataObject)this, (String)strParamName, (int)nDefault);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return nDefault;
        }
    }

    public Date getParamDateValue(String strParamName, Timestamp dtDefault) {
        try {
            return EntityBase.getTimestampValue((IDataObject)this, (String)strParamName, (Timestamp)dtDefault);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return dtDefault;
        }
    }

    public void setParamValue(String strParamName, Object objParamValue) {
        try {
            super.set(strParamName, objParamValue);
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    public boolean getParamBoolValue(String strParamName, boolean bDefault) {
        try {
            return EntityBase.getBoolValue((IDataObject)this, (String)strParamName, (Boolean)bDefault);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return bDefault;
        }
    }

    public float getParamFloatValue(String strParamName, float fDefault) {
        try {
            return EntityBase.getFloatValue((IDataObject)this, (String)strParamName, (float)fDefault).floatValue();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return fDefault;
        }
    }

    public double getParamDoubleValue(String strParamName, double fDefault) {
        try {
            return EntityBase.getDoubleValue((IDataObject)this, (String)strParamName, (double)fDefault);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return fDefault;
        }
    }
}

