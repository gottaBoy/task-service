/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.Control.IPSRawItemBase;
import SA.SRFDA.PS.Core.Control.IPSRawItemContainer;
import SA.SRFDA.PS.Core.Control.PSRawItemImpl;
import SA.SRFDA.PS.Core.Control.RawItem.PSHtmlItemImpl;
import SA.SRFDA.PS.Core.Control.RawItem.PSImageItemImpl;
import SA.SRFDA.PS.Core.Control.RawItem.PSMarkdownItemImpl;
import SA.SRFDA.PS.Core.Control.RawItem.PSPlaceholderItemImpl;
import SA.SRFDA.PS.Core.Control.RawItem.PSTextItemImpl;
import SA.SRFDA.PS.Core.Control.RawItem.PSVideoItemImpl;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSRawItemHelper {
    public static IPSRawItemBase createPSRawItemBase(ISRFDAGlobalHelper iDAGlobalHelper, IPSRawItemContainer iPSRawItemContainer, String strName) throws Exception {
        PSObjectImpl iPSRawItemBase = null;
        iPSRawItemBase = StringHelper.compare((String)"RAW", (String)iPSRawItemContainer.getContentType(), (boolean)false) == 0 ? new PSTextItemImpl() : (StringHelper.compare((String)"IMAGE", (String)iPSRawItemContainer.getContentType(), (boolean)false) == 0 ? new PSImageItemImpl() : (StringHelper.compare((String)"MARKDOWN", (String)iPSRawItemContainer.getContentType(), (boolean)false) == 0 ? new PSMarkdownItemImpl() : (StringHelper.compare((String)"HTML", (String)iPSRawItemContainer.getContentType(), (boolean)false) == 0 ? new PSHtmlItemImpl() : (StringHelper.compare((String)"VIDEO", (String)iPSRawItemContainer.getContentType(), (boolean)false) == 0 ? new PSVideoItemImpl() : (StringHelper.compare((String)"PLACEHOLDER", (String)iPSRawItemContainer.getContentType(), (boolean)false) == 0 ? new PSPlaceholderItemImpl() : new PSRawItemImpl())))));
        iPSRawItemBase.init(iDAGlobalHelper, iPSRawItemContainer, strName);
        return iPSRawItemBase;
    }
}

