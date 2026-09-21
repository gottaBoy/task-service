/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Model;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public class QueryGroupItemConfig
extends XMLConfig {
    public static final String TAG_QUERYGROUPITEM = "SRFDAQUERYGROUPITEM";
    public static final String TAG_ALIAS = "ALIAS";
    public static final String TAG_FORMULAR = "FORMULAR";
    public static final String TAG_DEFIELDS = "DEFIELDS";
    public static final String TAG_ISGROUP = "ISGROUP";
    public static final String TAG_ORDER = "ORDER";
    public static final String TAG_ORDERDIRECTION = "ORDERDIRECTION";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_RECALC = "RECALC";
    protected String strAlias = "";
    protected String strFormular = "";
    protected String strDEFields = "";
    protected boolean bIsGroup = false;
    protected int nOrder = 0;
    protected String strOrderDirection = "";
    protected String strUserTag = "";
    protected String strUserTag2 = "";
    protected boolean bReCalc = false;

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_ALIAS, (boolean)true) == 0) {
            this.setAlias(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_FORMULAR, (boolean)true) == 0) {
            this.setFormular(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DEFIELDS, (boolean)true) == 0) {
            this.setDEFields(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ORDERDIRECTION, (boolean)true) == 0) {
            this.setOrderDirection(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_USERTAG, (boolean)true) == 0) {
            this.setUserTag(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_USERTAG2, (boolean)true) == 0) {
            this.setUserTag2(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ISGROUP, (boolean)true) == 0) {
            this.setIsGroup(QueryGroupItemConfig.GetValue((String)strValue, (boolean)this.getIsGroup()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ORDER, (boolean)true) == 0) {
            this.setOrder(QueryGroupItemConfig.GetValue((String)strValue, (int)this.getOrder()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_RECALC, (boolean)true) == 0) {
            this.setReCalc(QueryGroupItemConfig.GetValue((String)strValue, (boolean)this.isReCalc()));
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getAlias() {
        return this.strAlias;
    }

    public String getFormular() {
        return this.strFormular;
    }

    public String getDEFields() {
        return this.strDEFields;
    }

    public boolean getIsGroup() {
        return this.bIsGroup;
    }

    public int getOrder() {
        return this.nOrder;
    }

    public void setAlias(String strAlias) {
        this.strAlias = strAlias;
    }

    public void setFormular(String strFormular) {
        this.strFormular = strFormular;
    }

    public void setDEFields(String strDEFields) {
        this.strDEFields = strDEFields;
    }

    public void setIsGroup(boolean isGroup) {
        this.bIsGroup = isGroup;
    }

    public void setOrder(int order) {
        this.nOrder = order;
        if (this.nOrder < 0) {
            this.nOrder = 0;
        }
    }

    public String getOrderDirection() {
        return this.strOrderDirection;
    }

    public String getUserTag() {
        return this.strUserTag;
    }

    public String getUserTag2() {
        return this.strUserTag2;
    }

    public void setOrderDirection(String strOrderDirection) {
        this.strOrderDirection = strOrderDirection;
    }

    public void setUserTag(String strUserTag) {
        this.strUserTag = strUserTag;
    }

    public void setUserTag2(String strUserTag2) {
        this.strUserTag2 = strUserTag2;
    }

    public boolean isReCalc() {
        return this.bReCalc;
    }

    public void setReCalc(boolean bReCalc) {
        this.bReCalc = bReCalc;
    }
}

