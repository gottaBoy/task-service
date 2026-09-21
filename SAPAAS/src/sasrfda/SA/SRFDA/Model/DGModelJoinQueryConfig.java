/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Model;

import SA.SRFDA.Model.DGModelBaseQueryConfig;
import SA.SRFramework.Utility.StringHelper;

public class DGModelJoinQueryConfig
extends DGModelBaseQueryConfig {
    public static final String TAG_DGMODELJOINQUERY = "SRFDADGMODELJOINQUERY";
    public static final String TAG_DERTYPE = "DERTYPE";
    public static final String TAG_DERTYPE_1N = "1N";
    public static final String TAG_DERTYPE_1NNOT = "1NNOT";
    public static final String TAG_DERTYPE_1N_LEFTOUT = "1NLEFTOUT";
    public static final String TAG_DERTYPE_N1 = "N1";
    public static final String TAG_DERTYPE_N1RIGHT = "N1RIGHT";
    public static final String TAG_DERTYPE_11 = "11";
    public static final String TAG_DERTYPE_11M = "11M";
    public static final String TAG_DERTYPE_INDEX = "INDEX";
    public static final String TAG_DERTYPE_INDEXM = "INDEXM";
    public static final String TAG_DERTYPE_CUSTOMN1 = "CUSTOMN1";
    public static final String TAG_DERTYPE_CUSTOM1N = "CUSTOM1N";
    public static final String TAG_DERTYPE_CUSTOM1NNOT = "CUSTOM1NNOT";
    public static final String TAG_DERFULLID = "DERFULLID";
    public static final String TAG_DERID = "DERID";
    public static final String TAG_PDEID = "PDEID";
    protected String strDERFullId = "";
    protected String strDERID = "";
    protected String strDERType = "N1";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DERFULLID, (boolean)true) == 0) {
            String[] arr;
            this.strDERFullId = strValue;
            if (!StringHelper.IsNullOrEmpty((String)this.strDERFullId) && (arr = this.strDERFullId.split("[:]")).length == 3) {
                if (StringHelper.Compare((String)arr[0], (String)TAG_DERTYPE_N1, (boolean)true) == 0) {
                    this.setDERType(TAG_DERTYPE_N1);
                }
                if (StringHelper.Compare((String)arr[0], (String)TAG_DERTYPE_N1RIGHT, (boolean)true) == 0) {
                    this.setDERType(TAG_DERTYPE_N1RIGHT);
                }
                if (StringHelper.Compare((String)arr[0], (String)TAG_DERTYPE_CUSTOMN1, (boolean)true) == 0) {
                    this.setDERType(TAG_DERTYPE_CUSTOMN1);
                }
                if (StringHelper.Compare((String)arr[0], (String)TAG_DERTYPE_1N_LEFTOUT, (boolean)true) == 0) {
                    this.setDERType(TAG_DERTYPE_1N_LEFTOUT);
                }
                if (StringHelper.Compare((String)arr[0], (String)TAG_DERTYPE_1N, (boolean)true) == 0) {
                    this.setDERType(TAG_DERTYPE_1N);
                }
                if (StringHelper.Compare((String)arr[0], (String)TAG_DERTYPE_1NNOT, (boolean)true) == 0) {
                    this.setDERType(TAG_DERTYPE_1NNOT);
                }
                if (StringHelper.Compare((String)arr[0], (String)TAG_DERTYPE_CUSTOM1N, (boolean)true) == 0) {
                    this.setDERType(TAG_DERTYPE_CUSTOM1N);
                }
                if (StringHelper.Compare((String)arr[0], (String)TAG_DERTYPE_CUSTOM1NNOT, (boolean)true) == 0) {
                    this.setDERType(TAG_DERTYPE_CUSTOM1NNOT);
                }
                if (StringHelper.Compare((String)arr[0], (String)TAG_DERTYPE_11, (boolean)true) == 0) {
                    this.setDERType(TAG_DERTYPE_11);
                }
                if (StringHelper.Compare((String)arr[0], (String)TAG_DERTYPE_11M, (boolean)true) == 0) {
                    this.setDERType(TAG_DERTYPE_11M);
                }
                if (StringHelper.Compare((String)arr[0], (String)TAG_DERTYPE_INDEX, (boolean)true) == 0) {
                    this.setDERType(TAG_DERTYPE_INDEX);
                }
                if (StringHelper.Compare((String)arr[0], (String)TAG_DERTYPE_INDEXM, (boolean)true) == 0) {
                    this.setDERType(TAG_DERTYPE_INDEXM);
                }
                this.setDERID(arr[1]);
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DERID, (boolean)true) == 0) {
            this.strDERID = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DERTYPE, (boolean)true) == 0) {
            this.strDERType = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getDERID() {
        return this.strDERID;
    }

    public String getDERType() {
        return this.strDERType;
    }

    public void setDERID(String strDERID) {
        this.strDERID = strDERID;
    }

    public void setDERType(String strDERType) {
        this.strDERType = strDERType;
    }
}

