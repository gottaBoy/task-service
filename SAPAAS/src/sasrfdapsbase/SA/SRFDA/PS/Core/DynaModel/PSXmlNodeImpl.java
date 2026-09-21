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
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public abstract class PSXmlNodeImpl
extends PSObjectImpl
implements IPSXmlNode {
    private static final Log log = LogFactory.getLog(PSXmlNodeImpl.class);
    private IPSXmlNodeOwner iPSXmlNodeOwner = null;
    private Element xmlElement = null;
    private Node xmlNode = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSXmlNodeOwner iPSXmlNodeOwner, String strName, Node xmlNode) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSXmlNodeOwner(iPSXmlNodeOwner);
            this.setName(strName);
            this.setXmlNode(xmlNode);
            if (xmlNode instanceof Element) {
                this.setXmlElement((Element)xmlNode);
            }
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

    @Override
    public IPSXmlNodeOwner getPSXmlNodeOwner() {
        return this.iPSXmlNodeOwner;
    }

    protected void setPSXmlNodeOwner(IPSXmlNodeOwner iPSXmlNodeOwner) {
        this.iPSXmlNodeOwner = iPSXmlNodeOwner;
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    public Element getXmlElement() {
        return this.xmlElement;
    }

    protected void setXmlElement(Element xmlElement) {
        this.xmlElement = xmlElement;
    }

    @Override
    public Node getXmlNode() {
        return this.xmlNode;
    }

    protected void setXmlNode(Node xmlNode) {
        this.xmlNode = xmlNode;
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u540d\u79f0")
    public String getNodeName() {
        return this.getXmlNode().getNodeName();
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u503c", hideempty2=true)
    public String getNodeValue() {
        return this.getXmlNode().getNodeValue();
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
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSXmlNodeOwner().getModelId(), (Object)this.getName());
    }

    @Override
    public IPSSystem getPSSystem() {
        return this.getPSXmlNodeOwner().getPSSystem();
    }
}

