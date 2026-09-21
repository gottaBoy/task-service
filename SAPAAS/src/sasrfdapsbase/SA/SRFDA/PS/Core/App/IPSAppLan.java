/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageItem;
import SA.SRFDA.PS.Data.PSAppLan;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5e94\u7528\u8bed\u8a00\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSAppLan")
public interface IPSAppLan
extends IPSApplicationObject,
IPSModelSortable {
    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, PSAppLan var3) throws Exception;

    public String getLanguage();

    public Iterator<IPSLanguageItem> getAllPSLanguageItems();
}

