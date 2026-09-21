/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSXmlNode;
import SA.SRFDA.PS.Core.DynaModel.IPSXmlNodeOwner;
import SA.SRFDA.PS.Core.DynaModel.IPSXmlNodes;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class PSXmlNodesImpl<T extends IPSXmlNode>
extends PSObjectImpl
implements IPSXmlNodes<T> {
    private static final Log log = LogFactory.getLog(PSXmlNodesImpl.class);
    private IPSXmlNodeOwner iPSXmlNodeOwner = null;
    private Element xmlElement = null;
    private List<T> itemList = new ArrayList<T>();

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSXmlNodeOwner iPSXmlNodeOwner, String strName, Element xmlElement) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSXmlNodeOwner(iPSXmlNodeOwner);
            this.setName(strName);
            this.setXmlElement(xmlElement);
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    public IPSXmlNodeOwner getPSXmlNodeOwner() {
        return this.iPSXmlNodeOwner;
    }

    protected void setPSXmlNodeOwner(IPSXmlNodeOwner iPSXmlNodeOwner) {
        this.iPSXmlNodeOwner = iPSXmlNodeOwner;
    }

    @Override
    protected void onInit() throws Exception {
        NodeList nodeList = this.getXmlElement().getChildNodes();
        if (nodeList != null) {
            int i = 0;
            while (i < nodeList.getLength()) {
                Node node = nodeList.item(i);
                T t = this.getItem(String.format(this.getItemNameFormat(), this.itemList.size()), node);
                if (t != null) {
                    this.itemList.add(t);
                }
                ++i;
            }
        }
        super.onInit();
    }

    protected String getItemNameFormat() {
        return "item%1$s";
    }

    public Element getXmlElement() {
        return this.xmlElement;
    }

    protected void setXmlElement(Element xmlElement) {
        this.xmlElement = xmlElement;
    }

    protected abstract T getItem(String var1, Node var2) throws Exception;

    @Override
    @PSModelRTMeta(description="\u5b50\u9879\u96c6\u5408")
    public Iterator<T> getItems() {
        if (this.itemList == null || this.itemList.size() == 0) {
            return null;
        }
        return this.itemList.iterator();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSystem());
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSystem().getPSSysModelInstId();
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSXmlNodeOwner().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return this.getPSXmlNodeOwner().getModelId();
    }

    @Override
    public IPSSystem getPSSystem() {
        return this.getPSXmlNodeOwner().getPSSystem();
    }
}

