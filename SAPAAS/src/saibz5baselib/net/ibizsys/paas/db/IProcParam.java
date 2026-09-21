/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db;

import net.ibizsys.paas.core.IModelBase;

public interface IProcParam
extends IModelBase {
    public static final String TAG_DRAFTFLAG = "SRF_DRAFTFLAG";
    public static final String TAG_PERSONID = "SRF_PERSONID";
    public static final String TAG_LOGINNAME = "SRF_LOGINNAME";
    public static final String TAG_PERSONNAME = "SRF_PERSONNAME";
    public static final String TAG_CURTIME = "SRF_CURTIME";
    public static final String TAG_ORGID = "SRF_ORGID";
    public static final String TAG_ORGNAME = "SRF_ORGNAME";
    public static final String TAG_ORGSECTORID = "SRF_ORGSECTORID";
    public static final String TAG_ORGSECTORNAME = "SRF_ORGSECTORNAME";
    public static final String TAG_CHECKKEY = "SRF_CHECKKEY";
    public static final String TAG_DALOG = "SRF_DALOG";
    public static final String TAG_SAASDCID = "SRF_SAASDCID";
    public static final String TAG_RETDATA = "SRF_RETDATA";
    public static final String TAG_RETCODE = "SRF_RETCODE";
    public static final String TAG_RETINFO = "SRF_RETINFO";
    public static final String TAG_RETINFORES = "SRF_RETINFORES";
    public static final String TAG_RETINFORESARG = "SRF_RETINFORESARG";
    public static final String TAG_TAG = "SRF_TAG";
    public static final String TAG_ACTIONMODE = "SRF_ACTIONMODE";
    public static final String TAG_ACTIONARG = "SRF_ACTIONARG";
    public static final String TAG_RD = "SRF_RD";
    public static final String TAG_VAR = "VAR_";
    public static final String TAG_VF = "VF_";
    public static final String TAG_CREATEDATE = "SRF_CREATEDATE";
    public static final String TAG_UPDATEDATE = "SRF_UPDATEDATE";
    public static final String TAG_CREATEMAN = "SRF_CREATEMAN";
    public static final String TAG_UPDATEMAN = "SRF_UPDATEMAN";
    public static final String TAG_CREATEMANNAME = "SRF_CREATEMANNAME";
    public static final String TAG_UPDATEMANNAME = "SRF_UPDATEMANNAME";

    public Object getDefaultValue();

    public int getDirection();

    public String getOutputParamName();

    public int getDataType();

    public String getParamName();
}

