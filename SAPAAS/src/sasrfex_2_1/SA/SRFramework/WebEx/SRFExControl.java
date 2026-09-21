/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.AttributeBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.ISRFExFormItem;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import java.io.Writer;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExControl {
    private SRFExPage curPage = null;
    protected Vector childsList = null;
    protected HashMap<String, SRFExControl> childMap = null;
    private SRFExControl curParent = null;
    protected XMLConfig config = null;
    protected BaseControlConfig baseControlConfig = null;
    private static final Log log = LogFactory.getLog(SRFExControl.class);
    private boolean bInitFlag = false;
    protected String strPageControlID = "";

    public String getID() {
        return this.getBaseControlConfig().getID();
    }

    public void setID(String strValue) {
        this.getBaseControlConfig().setID(strValue);
    }

    public String getPageControlID() {
        return this.strPageControlID;
    }

    public void setPageControlID(String strPageControlID) {
        this.strPageControlID = strPageControlID;
    }

    public String getName() {
        if (StringHelper.Length((String)this.getBaseControlConfig().getName()) != 0) {
            return this.getBaseControlConfig().getName();
        }
        return this.getUniqueID();
    }

    public void setName(String strValue) {
        this.getBaseControlConfig().setName(strValue);
    }

    public String getUniqueID() {
        return this.getPageControlID();
    }

    public SRFExControl getParent() {
        return this.curParent;
    }

    public void setParent(SRFExControl parent) {
        this.curParent = parent;
    }

    public SRFExPage getPage() {
        return this.curPage;
    }

    public void setPage(SRFExPage page) {
        this.curPage = page;
        this.OnSetPage();
    }

    protected void OnSetPage() {
        if (this.childsList == null) {
            return;
        }
        int nChildControlCount = this.childsList.size();
        int i = 0;
        while (i < nChildControlCount) {
            SRFExControl childControl = (SRFExControl)this.childsList.get(i);
            childControl.setPage(this.curPage);
            ++i;
        }
    }

    public SRFExWebContext getWebContext() {
        if (this.getPage() == null) {
            return null;
        }
        return this.getPage().getWebContext();
    }

    public void setConfig(XMLConfig config) {
        this.config = config;
        this.OnSetConfig();
    }

    public void InitConfig() {
        this.setConfig(this.CreateConfig());
    }

    protected void OnSetConfig() {
        if (this.config != null) {
            if (this.config instanceof BaseControlConfig) {
                this.baseControlConfig = (BaseControlConfig)this.config;
            }
        } else {
            this.baseControlConfig = null;
        }
    }

    public XMLConfig getConfig() {
        if (this.config == null) {
            this.setConfig(this.CreateConfig());
        }
        return this.config;
    }

    public BaseControlConfig getBaseControlConfig() {
        if (this.config == null) {
            this.getConfig();
        }
        return this.baseControlConfig;
    }

    protected XMLConfig CreateConfig() {
        return new BaseControlConfig();
    }

    public boolean getVisible() {
        return this.getBaseControlConfig().getVisible();
    }

    public void setVisible(boolean bValue) {
        this.getBaseControlConfig().setVisible(bValue);
    }

    public synchronized void AddControl(SRFExControl srfControl) {
        String strTempId;
        String strTempId2 = srfControl.getUniqueID();
        if (StringHelper.Length((String)strTempId2) == 0) {
            strTempId2 = this.getPage().GetControlUniId();
        }
        if (StringHelper.StringLength((String)(strTempId = srfControl.getID())) == 0) {
            strTempId = strTempId2;
            srfControl.setID(strTempId);
        }
        srfControl.setPageControlID(strTempId2);
        if (this.InternalFindControl(srfControl.getID()) != null) {
            return;
        }
        if (this.childsList == null) {
            this.childsList = new Vector();
        }
        if (this.childMap == null) {
            this.childMap = new HashMap();
        }
        srfControl.setPage(this.getPage());
        srfControl.setParent(this);
        this.childsList.add(srfControl);
        this.childMap.put(srfControl.getID().toUpperCase(), srfControl);
        this.childMap.put(srfControl.getUniqueID().toUpperCase(), srfControl);
        if (srfControl instanceof ISRFExFormItem) {
            this.getPage().getForms().RegisterFormControl(srfControl);
        }
        srfControl.Init();
    }

    public synchronized void RemoveControl(SRFExControl srfControl) {
        if (this.childsList == null) {
            return;
        }
        int nChildControlCount = this.childsList.size();
        int i = 0;
        while (i < nChildControlCount) {
            SRFExControl childControl = (SRFExControl)this.childsList.get(i);
            if (StringHelper.Compare((String)srfControl.getID(), (String)childControl.getID(), (boolean)true) == 0) {
                this.childsList.remove(i);
                this.childMap.remove(srfControl.getID().toUpperCase());
                this.childMap.remove(srfControl.getUniqueID().toUpperCase());
                return;
            }
            ++i;
        }
    }

    public synchronized void RemoveControls() {
        if (this.childsList == null) {
            return;
        }
        int nChildControlCount = this.childsList.size();
        int i = 0;
        while (i < nChildControlCount) {
            SRFExControl childControl = (SRFExControl)this.childsList.get(i);
            if (childControl instanceof ISRFExFormItem) {
                this.getPage().getForms().UnregisterFormControl(childControl);
            }
            ++i;
        }
        this.childsList.clear();
        this.childMap.clear();
    }

    public synchronized SRFExControl FindControl(String strControlId) {
        return this.InternalFindControl(strControlId);
    }

    public synchronized SRFExControl FindControlByUniqueId(String strControlId) {
        return this.InternalFindControlByUniqueId(strControlId);
    }

    private SRFExControl InternalFindControl(String strControlId) {
        if (this.childsList == null || this.childMap == null) {
            return null;
        }
        return this.childMap.get(strControlId.toUpperCase());
    }

    private SRFExControl InternalFindControlByUniqueId(String strControlId) {
        if (this.childsList == null || this.childMap == null) {
            return null;
        }
        return this.childMap.get(strControlId.toUpperCase());
    }

    public synchronized SRFExControl LookForControl(String strControlId) {
        SRFExControl control = this.InternalFindControl(strControlId);
        if (control != null) {
            return control;
        }
        if (this.childsList == null) {
            return null;
        }
        int nChildControlCount = this.childsList.size();
        int i = 0;
        while (i < nChildControlCount) {
            SRFExControl childControl = (SRFExControl)this.childsList.get(i);
            control = childControl.LookForControl(strControlId);
            if (control != null) {
                return control;
            }
            ++i;
        }
        return null;
    }

    public synchronized SRFExControl LookForControlByUniqueId(String strControlId) {
        SRFExControl control = this.InternalFindControlByUniqueId(strControlId);
        if (control != null) {
            return control;
        }
        if (this.childsList == null) {
            return null;
        }
        int nChildControlCount = this.childsList.size();
        int i = 0;
        while (i < nChildControlCount) {
            SRFExControl childControl = (SRFExControl)this.childsList.get(i);
            control = childControl.LookForControlByUniqueId(strControlId);
            if (control != null) {
                return control;
            }
            ++i;
        }
        return null;
    }

    public Vector GetControls() {
        return this.childsList;
    }

    public void Render(Writer writer) {
        if (this.getVisible() || this.getBaseControlConfig().getAlwaysOutput()) {
            this.OnRender(writer);
        }
    }

    public void RenderChild(Writer writer, String strControlId) {
        try {
            SRFExControl childControl = this.FindControl(strControlId);
            if (childControl == null) {
                writer.write(StringHelper.Format((String)"\u65e0\u6548\u7684\u5bf9\u8c61\u6807\u8bc6[%1$s]", (Object)strControlId));
                return;
            }
            childControl.Render(writer);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void OnRender(Writer writer) {
        if (this.childsList == null) {
            return;
        }
        int nChildControlCount = this.childsList.size();
        int i = 0;
        while (i < nChildControlCount) {
            SRFExControl childControl = (SRFExControl)this.childsList.get(i);
            childControl.Render(writer);
            ++i;
        }
    }

    public void Init() {
        this.bInitFlag = true;
        this.OnInitFormPostData();
        this.ReloadConfig();
        this.OnInit();
    }

    public void OnInitFormPostData() {
    }

    protected void OnInit() {
    }

    protected void OutputID(Writer writer) {
        SRFExControl.OutputAttribute(writer, "id", this.getUniqueID().replace(':', '_'));
    }

    protected void OutputName(Writer writer) {
        SRFExControl.OutputAttribute(writer, "name", this.getName());
    }

    protected void OutputID(Writer writer, String strAppendSTR) {
        SRFExControl.OutputAttribute(writer, "id", String.valueOf(this.getUniqueID().replace(':', '_')) + strAppendSTR);
    }

    protected void OutputName(Writer writer, String strAppendSTR) {
        SRFExControl.OutputAttribute(writer, "name", String.valueOf(this.getName()) + strAppendSTR);
    }

    protected static void OutputAttribute(Writer writer, String strKey, String strValue) {
        try {
            writer.write(StringHelper.Format((String)"%1$s=\"%2$s\" ", (Object)strKey, (Object)strValue));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void ReloadConfig() {
        if (this.config == null) {
            this.config = this.CreateConfig();
        }
        if (this.config == null) {
            return;
        }
        if (!this.bInitFlag) {
            return;
        }
        this.OnReloadConfig();
    }

    protected void OnReloadConfig() {
    }

    public void FillRealFormControlId(Vector lists) {
        lists.add(this.getUniqueID());
    }

    protected void FillAttributeBuilder(AttributeBuilder attributeBuilder) {
        attributeBuilder.SetExtAttr(this.getBaseControlConfig().getExtAttr());
        attributeBuilder.Set("class", this.getBaseControlConfig().getCssClass());
        if (!this.getBaseControlConfig().getEnabled()) {
            attributeBuilder.Set("disabled", "disabled");
        }
    }

    protected void FillStyleBuilder(StyleBuilder styleBuilder) {
        styleBuilder.AddStyle("width", this.getBaseControlConfig().getWidthString());
        styleBuilder.AddStyle("height", this.getBaseControlConfig().getHeightString());
    }
}

