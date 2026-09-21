/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.IBIRepPIHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPartPublishContext;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Hashtable;

public class BIRepPartPublishContext
implements IBIRepPartPublishContext {
    protected IBIRepPIHelper iBIRepPIHelper = null;
    protected Hashtable<String, String> repPartModelMap = new Hashtable();
    protected Hashtable<String, String> nameSpaceMap = new Hashtable();
    private int nLastNSId = 1;

    public BIRepPartPublishContext() {
        this.nameSpaceMap.put("http://schemas.softanywhere.com/2011/xaml/bi", "sasrfbi");
        this.nameSpaceMap.put("http://schemas.softanywhere.com/2011/xaml/base", "sasrfbase");
        this.nameSpaceMap.put("http://schemas.softanywhere.com/2011/xaml/page", "sasrfpage");
        this.nameSpaceMap.put("http://schemas.telerik.com/2008/xaml/presentation", "telerik");
        this.nameSpaceMap.put("http://schemas.softanywhere.com/2011/xaml/page/plugin", "sasrfpageplugin");
        this.nameSpaceMap.put("http://schemas.infragistics.com/xaml", "ig");
    }

    @Override
    public IBIRepPIHelper getBIRepPIHelper() {
        return this.iBIRepPIHelper;
    }

    public void setBIRepPIHelper(IBIRepPIHelper iBIRepPIHelper) {
        this.iBIRepPIHelper = iBIRepPIHelper;
    }

    @Override
    public void setBIRepPIModel(String strContent) {
        this.repPartModelMap.put(this.iBIRepPIHelper.getBIRepPIId(), strContent);
    }

    public String getBIRepPIModel(String strBIRepPIId) {
        return this.repPartModelMap.get(strBIRepPIId);
    }

    @Override
    public String RegisterNS(String strNS) {
        if (this.nameSpaceMap.containsKey(strNS)) {
            return this.nameSpaceMap.get(strNS);
        }
        ++this.nLastNSId;
        String strNewName = StringHelper.Format((String)"pins%1$s", (Object)this.nLastNSId);
        this.nameSpaceMap.put(strNS, strNewName);
        return strNewName;
    }

    public String getAllNameSpaces() {
        StringBuilderEx sb = new StringBuilderEx();
        for (String strKey : this.nameSpaceMap.keySet()) {
            sb.Append("xmlns:%1$s=\"%2$s\" ", (Object)this.nameSpaceMap.get(strKey), (Object)strKey);
        }
        return sb.toString();
    }
}

