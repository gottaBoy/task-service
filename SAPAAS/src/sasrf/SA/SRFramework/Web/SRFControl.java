/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.ClassHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.INamingContainer;
import SA.SRFramework.Web.SRFPage;
import SA.SRFramework.Web.WebContext;
import java.util.Hashtable;
import java.util.Vector;
import javax.servlet.jsp.JspWriter;

public abstract class SRFControl {
    private String strControlId = "";
    private boolean bEnableViewState = true;
    private SRFControl curNamingContainer = null;
    private SRFControl curParent = null;
    private SRFPage curPage = null;
    private boolean bVisible = true;
    private WebContext curWebContext = null;
    protected Vector childsList = new Vector();
    protected Hashtable childsHashtable = new Hashtable();

    public String getID() {
        return this.strControlId;
    }

    public void setID(String strValue) {
        this.strControlId = strValue;
    }

    public String getUniqueID() {
        String strTempId = "";
        if (this.curNamingContainer != null) {
            strTempId = this.curNamingContainer.getID();
        }
        if (StringHelper.StringLength(strTempId) != 0) {
            strTempId = String.valueOf(strTempId) + ":";
        }
        return String.valueOf(strTempId) + this.strControlId;
    }

    public SRFControl getNamingContainer() {
        return this.curNamingContainer;
    }

    public SRFControl getParent() {
        return this.curParent;
    }

    public void setParent(SRFControl parent) {
        boolean bNamingContainer = false;
        bNamingContainer = ClassHelper.ContainClass(parent.getClass(), INamingContainer.class);
        this.curNamingContainer = bNamingContainer ? parent : parent.getNamingContainer();
    }

    public SRFPage getPage() {
        return this.curPage;
    }

    public void setPage(SRFPage page) {
        this.curPage = page;
    }

    public boolean getVisible() {
        return this.bVisible;
    }

    public void setVisible(boolean bValue) {
        this.bVisible = bValue;
    }

    public WebContext getWebContext() {
        return this.curWebContext;
    }

    public void setWebContext(WebContext webContext) {
        this.curWebContext = webContext;
    }

    protected void OnRender(JspWriter output) {
    }

    protected void OnInit() {
    }

    protected boolean OnRaiseEvent() {
        return true;
    }

    protected boolean OnInitFromRequest() {
        return true;
    }

    public void Init() {
        this.OnInit();
    }

    public String getHTML() {
        this.RenderControl(this.getPage().getOUTPUT());
        return "";
    }

    public void RenderControl(JspWriter output) {
        if (!this.getVisible()) {
            return;
        }
        this.OnRender(output);
    }

    public void AddControl(SRFControl srfControl) {
        String strTempId = srfControl.getID();
        if (StringHelper.StringLength(strTempId) == 0) {
            strTempId = String.valueOf(srfControl.getClass().getSimpleName()) + (this.childsList.size() + 1);
            srfControl.setID(strTempId);
        }
        srfControl.setPage(this.getPage());
        srfControl.setWebContext(this.getWebContext());
        srfControl.setParent(this);
        strTempId = strTempId.toUpperCase();
        this.childsHashtable.put(strTempId, srfControl);
        this.childsList.addElement(srfControl);
        srfControl.Init();
        if (this.getPage().getIsPostBack() && this.getPage().getIsFinishLoad()) {
            srfControl.ReadFromViewStates();
            srfControl.InitFromRequest();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void RaiseControlEvents() {
        if (!this.OnRaiseEvent()) {
            return;
        }
        Vector tempVector = null;
        SRFControl sRFControl = this;
        synchronized (sRFControl) {
            tempVector = (Vector)this.childsList.clone();
            int i = 0;
            while (i < tempVector.size()) {
                ((SRFControl)tempVector.elementAt(i)).RaiseControlEvents();
                ++i;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void InitFromRequest() {
        if (!this.OnInitFromRequest()) {
            return;
        }
        Vector tempVector = null;
        SRFControl sRFControl = this;
        synchronized (sRFControl) {
            tempVector = (Vector)this.childsList.clone();
            int i = 0;
            while (i < tempVector.size()) {
                ((SRFControl)tempVector.elementAt(i)).InitFromRequest();
                ++i;
            }
        }
    }

    public SRFControl FindControl(String strControlId) {
        if (this.childsHashtable.containsKey(strControlId = strControlId.toUpperCase())) {
            return (SRFControl)this.childsHashtable.get(strControlId);
        }
        return null;
    }

    protected void OutputID(JspWriter output) {
        try {
            output.print("id=\"" + this.getUniqueID().replace(':', '_') + "\" ");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return;
        }
    }

    protected void OutputName(JspWriter output) {
        try {
            output.print("name=\"" + this.getUniqueID() + "\" ");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return;
        }
    }

    protected void OutputProperty(JspWriter output, String strName, String strValue) {
        try {
            output.print(String.valueOf(strName) + "=\"" + strValue + "\" ");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return;
        }
    }

    protected boolean OnWriteToViewStates() {
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void WriteToViewStates() {
        if (!this.bEnableViewState) {
            return;
        }
        if (!this.OnWriteToViewStates()) {
            return;
        }
        Vector tempVector = null;
        SRFControl sRFControl = this;
        synchronized (sRFControl) {
            tempVector = (Vector)this.childsList.clone();
            int i = 0;
            while (i < tempVector.size()) {
                ((SRFControl)tempVector.elementAt(i)).WriteToViewStates();
                ++i;
            }
        }
    }

    protected boolean OnReadFromViewStates() {
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void ReadFromViewStates() {
        if (!this.bEnableViewState) {
            return;
        }
        if (!this.OnReadFromViewStates()) {
            return;
        }
        Vector tempVector = null;
        SRFControl sRFControl = this;
        synchronized (sRFControl) {
            tempVector = (Vector)this.childsList.clone();
            int i = 0;
            while (i < tempVector.size()) {
                ((SRFControl)tempVector.elementAt(i)).ReadFromViewStates();
                ++i;
            }
        }
    }
}

