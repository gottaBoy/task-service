/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Utility.ClassHelper;
import SA.SRFramework.Web.AfterCheckUserInputListener;
import SA.SRFramework.Web.BeforeCheckUserInputListener;
import SA.SRFramework.Web.CheckUserInputEvent;
import SA.SRFramework.Web.ChildsCreatedListener;
import SA.SRFramework.Web.IWebCtrl;
import SA.SRFramework.Web.IWebCtrlDataRow;
import SA.SRFramework.Web.SRFBaseForm;
import SA.SRFramework.Web.SRFWebControl;
import SA.SRFramework.Web.UI.WebCtrlConfig;
import SA.SRFramework.Web.UserCtrlFillValueListener;
import SA.SRFramework.Web.UserCtrlGetValueListener;
import SA.SRFramework.Web.UserWebControlListener;
import SA.SRFramework.Web.UserWebCtrlEvent;
import SA.SRFramework.Web.WebCtrlHelper;
import java.util.EventObject;
import java.util.Vector;

public class SRFForm
extends SRFBaseForm {
    transient Vector afterCheckUserInputListeners = new Vector();
    transient Vector beforeCheckUserInputListeners = new Vector();
    transient Vector childsCreatedListeners = new Vector();
    transient Vector userWebControlListeners = new Vector();
    transient Vector userCtrlFillValueListeners = new Vector();
    transient Vector userCtrlGetValueListeners = new Vector();

    public synchronized void addAfterCheckUserInputListener(AfterCheckUserInputListener l) {
        this.afterCheckUserInputListeners.add(l);
    }

    public synchronized void removeAfterCheckUserInputListener(AfterCheckUserInputListener l) {
        this.afterCheckUserInputListeners.remove(l);
    }

    protected void fireOnAfterCheckUserInput(CheckUserInputEvent eventObject) {
        if (this.afterCheckUserInputListeners != null) {
            Vector listeners = this.afterCheckUserInputListeners;
            int count = listeners.size();
            int i = 0;
            while (i < count) {
                ((AfterCheckUserInputListener)listeners.elementAt(i)).OnAfterCheckUserInput(eventObject);
                ++i;
            }
        }
    }

    public synchronized void addBeforeCheckUserInputListener(BeforeCheckUserInputListener l) {
        this.beforeCheckUserInputListeners.add(l);
    }

    public synchronized void removeBeforeCheckUserInputListener(BeforeCheckUserInputListener l) {
        this.beforeCheckUserInputListeners.remove(l);
    }

    protected void fireOnBeforeCheckUserInput(EventObject eventObject) {
        if (this.beforeCheckUserInputListeners != null) {
            Vector listeners = this.beforeCheckUserInputListeners;
            int count = listeners.size();
            int i = 0;
            while (i < count) {
                ((BeforeCheckUserInputListener)listeners.elementAt(i)).OnBeforeCheckUserInput(eventObject);
                ++i;
            }
        }
    }

    public synchronized void addChildsCreatedListener(ChildsCreatedListener l) {
        this.childsCreatedListeners.add(l);
    }

    public synchronized void removeChildsCreatedListener(ChildsCreatedListener l) {
        this.childsCreatedListeners.remove(l);
    }

    protected void fireOnChildsCreated(EventObject eventObject) {
        if (this.childsCreatedListeners != null) {
            Vector listeners = this.childsCreatedListeners;
            int count = listeners.size();
            int i = 0;
            while (i < count) {
                ((ChildsCreatedListener)listeners.elementAt(i)).OnChildsCreated(eventObject);
                ++i;
            }
        }
    }

    public synchronized void addUserWebControlListener(UserWebControlListener l) {
        this.userWebControlListeners.add(l);
    }

    public synchronized void removeUserWebControlListener(UserWebControlListener l) {
        this.userWebControlListeners.remove(l);
    }

    protected void fireOnUserWebControl(UserWebCtrlEvent eventObject) {
        if (this.userWebControlListeners != null) {
            Vector listeners = this.userWebControlListeners;
            int count = listeners.size();
            int i = 0;
            while (i < count) {
                ((UserWebControlListener)listeners.elementAt(i)).OnUserWebControl(eventObject);
                ++i;
            }
        }
    }

    public synchronized void addUserCtrlFillValueListener(UserCtrlFillValueListener l) {
        this.userCtrlFillValueListeners.add(l);
    }

    public synchronized void removeUserCtrlFillValueListener(UserCtrlFillValueListener l) {
        this.userCtrlFillValueListeners.remove(l);
    }

    protected void fireOnUserCtrlFillValue(UserWebCtrlEvent eventObject) {
        if (this.userCtrlFillValueListeners != null) {
            Vector listeners = this.userCtrlFillValueListeners;
            int count = listeners.size();
            int i = 0;
            while (i < count) {
                ((UserCtrlFillValueListener)listeners.elementAt(i)).OnUserCtrlFillValue(eventObject);
                ++i;
            }
        }
    }

    public synchronized void addUserCtrlGetValueListener(UserCtrlGetValueListener l) {
        this.userCtrlGetValueListeners.add(l);
    }

    public synchronized void removeUserCtrlGetValueListener(UserCtrlGetValueListener l) {
        this.userCtrlGetValueListeners.remove(l);
    }

    protected void fireOnUserCtrlGetValue(UserWebCtrlEvent eventObject) {
        if (this.userCtrlGetValueListeners != null) {
            Vector listeners = this.userCtrlGetValueListeners;
            int count = listeners.size();
            int i = 0;
            while (i < count) {
                ((UserCtrlGetValueListener)listeners.elementAt(i)).OnUserCtrlGetValue(eventObject);
                ++i;
            }
        }
    }

    protected void FillCtrlValue(String strKey, String strValue, DataRow dr) {
        Object objWebCtrl = this.childCtrlList.get(strKey.toUpperCase());
        if (objWebCtrl == null) {
            return;
        }
        if (ClassHelper.ContainClass(objWebCtrl.getClass(), IWebCtrl.class)) {
            IWebCtrl interWebCtrl = (IWebCtrl)objWebCtrl;
            interWebCtrl.SetStrValue(strValue);
            if (dr != null && ClassHelper.ContainClass(objWebCtrl.getClass(), IWebCtrlDataRow.class)) {
                IWebCtrlDataRow interWebCtrlDataRow = (IWebCtrlDataRow)objWebCtrl;
                interWebCtrlDataRow.SetDataRow(dr);
            }
        } else {
            UserWebCtrlEvent userWebCtrlEvent = new UserWebCtrlEvent(this);
            userWebCtrlEvent.setIdFormat(strKey);
            userWebCtrlEvent.setValue(strValue);
            this.fireOnUserCtrlFillValue(userWebCtrlEvent);
        }
    }

    protected void FillCtrlValue(String strKey, String strValue) {
        this.FillCtrlValue(strKey, strValue, null);
    }

    protected String GetCtrlValue(String strKey) {
        Object objWebCtrl = this.childCtrlList.get(strKey.toUpperCase());
        if (objWebCtrl == null) {
            return "";
        }
        if (ClassHelper.ContainClass(objWebCtrl.getClass(), IWebCtrl.class)) {
            IWebCtrl interWebCtrl = (IWebCtrl)objWebCtrl;
            return interWebCtrl.GetCtrlValue();
        }
        UserWebCtrlEvent userWebCtrlEvent = new UserWebCtrlEvent(this);
        userWebCtrlEvent.setIdFormat(strKey);
        this.fireOnUserCtrlGetValue(userWebCtrlEvent);
        return userWebCtrlEvent.getValue();
    }

    protected SRFWebControl CreateCtrl(String strIdFormat, WebCtrlConfig webCtrlConfig) {
        SRFWebControl ctrl = WebCtrlHelper.Create(webCtrlConfig, strIdFormat);
        if (ctrl == null) {
            UserWebCtrlEvent userWebCtrlEvent = new UserWebCtrlEvent(this);
            userWebCtrlEvent.setConfig(webCtrlConfig);
            userWebCtrlEvent.setIdFormat(strIdFormat);
            this.fireOnUserWebControl(userWebCtrlEvent);
            ctrl = userWebCtrlEvent.getUserControl();
        }
        return ctrl;
    }
}

