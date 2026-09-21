/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package net.ibizsys.model.dataentity.dr;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysImage;

public interface IPSDEDRItem
extends IPSModelObject {
    public static final String DRITEMTYPE_DER1N = "DER1N";
    public static final String DRITEMTYPE_SYSDER1N = "SYSDER1N";
    public static final String DRITEMTYPE_DER11 = "DER11";
    public static final String DRITEMTYPE_SYSDER11 = "SYSDER11";
    public static final String ENABLEMODE_ALL = "ALL";
    public static final String ENABLEMODE_INWF = "INWF";
    public static final String ENABLEMODE_ALLWF = "ALLWF";
    public static final String ENABLEMODE_CUSTOM = "CUSTOM";
    public static final String ENABLEMODE_DEOPPRIV = "DEOPPRIV";

    public String getCaption(String var1);

    public String getItemType();

    public String getPSDEDRGroupId();

    public String getPSDEViewId();

    public IPSSysImage getPSSysImage();

    public String getEnableMode();

    public String getCounterId();

    public IPSDEAction getTestPSDEAction();

    public IPSDEOPPriv getTestPSDEOPPriv();

    public ObjectNode getViewParamJO();

    public IPSLanguageRes getCapPSLanguageRes();
}

