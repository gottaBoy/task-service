/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPortlet;
import SA.SRFDA.PS.Core.SF.IPSSFCodeObject;
import SA.SRFDA.PS.Data.PSPortletType;
import SA.SRFDA.PS.Data.PSSysPortlet;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSPortletType
extends IPSObject,
IPSSFCodeObject {
    public static final String PORTLETTYPE_LIST = "LIST";
    public static final String PORTLETTYPE_CHART = "CHART";
    public static final String PORTLETTYPE_REPORT = "REPORT";
    public static final String PORTLETTYPE_VIEW = "VIEW";
    public static final String PORTLETTYPE_HTML = "HTML";
    public static final String PORTLETTYPE_TOOLBAR = "TOOLBAR";
    public static final String PORTLETTYPE_ACTIONBAR = "ACTIONBAR";
    public static final String PORTLETTYPE_CUSTOM = "CUSTOM";
    public static final String PORTLETTYPE_APPMENU = "APPMENU";
    public static final String PORTLETTYPE_CONTAINER = "CONTAINER";
    public static final String PORTLETTYPE_RAWITEM = "RAWITEM";
    public static final String PORTLETTYPE_FILTER = "FILTER";

    public void init(ISRFDAGlobalHelper var1, PSPortletType var2) throws Exception;

    public IPSSysPortlet createPSSysPortlet(PSSysPortlet var1) throws Exception;

    public IPSDBPortletPart createPSPortlet() throws Exception;

    public String getBaseClass(String var1) throws Exception;

    public boolean isSysPortlet();
}

