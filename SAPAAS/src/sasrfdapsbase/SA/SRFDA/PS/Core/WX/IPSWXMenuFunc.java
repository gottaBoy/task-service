/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.WX;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import SA.SRFDA.PS.Core.WX.IPSWXAccountObject;
import SA.SRFDA.PS.Core.WX.IPSWXEntApp;
import SA.SRFDA.PS.Data.PSWXMenuFunc;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
public interface IPSWXMenuFunc
extends IPSWXAccountObject {
    public static final String FUNCTYPE_CLICK = "click";
    public static final String FUNCTYPE_VIEW = "view";
    public static final String FUNCTYPE_SCANCODE_PUSH = "scancode_push";
    public static final String FUNCTYPE_SCANCODE_WAITMSG = "scancode_waitmsg";
    public static final String FUNCTYPE_PIC_SYSPHOTO = "pic_sysphoto";
    public static final String FUNCTYPE_PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
    public static final String FUNCTYPE_PIC_WEIXIN = "pic_weixin";
    public static final String FUNCTYPE_LOCATION_SELECT = "location_select";

    public void init(ISRFDAGlobalHelper var1, IPSWXAccount var2, IPSWXEntApp var3, PSWXMenuFunc var4) throws Exception;

    public String getWXMenuFuncType();

    public String getClickTag();

    public IPSWXEntApp getPSWXEntApp();
}

