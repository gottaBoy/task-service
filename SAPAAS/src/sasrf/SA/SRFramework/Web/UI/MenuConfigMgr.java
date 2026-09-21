/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.Web.UI.ICustomMenuBuilder;
import SA.SRFramework.Web.UI.MenuConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class MenuConfigMgr
extends ConfigMgr {
    private final byte[] key;

    public MenuConfigMgr() {
        byte[] byArray = new byte[8];
        byArray[0] = 1;
        byArray[1] = 9;
        byArray[2] = 9;
        byArray[3] = 7;
        byArray[5] = 7;
        byArray[7] = 1;
        this.key = byArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public MenuConfig Get(String strMenuId) {
        String strMenuConfigPath = this.GetConfigFilePath("menu" + this.strFolderSeperator + "menu_" + strMenuId + ".xml");
        File file = new File(strMenuConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strMenuConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strMenuConfigPath))) {
                    return (MenuConfig)this.fileList.get(strMenuConfigPath);
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(MenuConfigMgr.getContent(strMenuConfigPath, this.key));
                } else {
                    parser.parse(strMenuConfigPath);
                }
                Document doc = parser.getDocument();
                MenuConfig menuConfig = new MenuConfig();
                menuConfig.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strMenuConfigPath, menuConfig);
                    this.modifydateList.put(strMenuConfigPath, nLastModify);
                }
                return menuConfig;
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                return null;
            }
        }
        return null;
    }

    public Long GetConfigVersion(String strMenuId) {
        String strMenuConfigPath = this.GetConfigFilePath("menu" + this.strFolderSeperator + "menu_" + strMenuId + ".xml");
        File file = new File(strMenuConfigPath);
        if (file.exists()) {
            return file.lastModified();
        }
        return new Long(-1L);
    }

    public boolean IsChanged(String strMenuId, Long nCurLastModify) {
        long nLastModify;
        String strMenuConfigPath = this.GetConfigFilePath("menu" + this.strFolderSeperator + "menu_" + strMenuId + ".xml");
        File file = new File(strMenuConfigPath);
        return !file.exists() || (nLastModify = file.lastModified()) != nCurLastModify;
    }

    public MenuConfig GetCustomMenuConfig(String strMenuId, ICustomMenuBuilder customMenuBuilder) {
        String strMenuConfigPath = this.GetConfigFilePath("menu" + this.strFolderSeperator + "menu_" + strMenuId + ".xml");
        File file = new File(strMenuConfigPath);
        if (file.exists()) {
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(MenuConfigMgr.getContent(strMenuConfigPath, this.key));
                } else {
                    parser.parse(strMenuConfigPath);
                }
                Document doc = parser.getDocument();
                MenuConfig menuConfig = new MenuConfig(customMenuBuilder);
                menuConfig.LoadConfig(doc.getDocumentElement());
                return menuConfig;
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                return null;
            }
        }
        return null;
    }
}

