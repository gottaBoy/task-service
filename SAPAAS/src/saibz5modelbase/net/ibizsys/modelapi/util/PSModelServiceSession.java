/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.IPSModelDTO;
import net.ibizsys.modelapi.util.PSDynaInstModelFolder;
import org.springframework.util.StringUtils;

public class PSModelServiceSession {
    private static ThreadLocal<PSModelServiceSession> current = new ThreadLocal();
    private String strPSModelFolderPath = null;
    private String strConfPSModelFolderPath = null;
    private String strPSGlobalModelFolderPath = null;
    private String strPSDynaInstId = null;
    private String strPSDynaInstFolderPath = null;
    private String strPPSDynaInstId = null;
    private String strPPSDynaInstFolderPath = null;
    private Map<String, IPSModel> psModelMap = new HashMap<String, IPSModel>();
    private Map<String, IPSModelDTO> psModelDTOMap = new HashMap<String, IPSModelDTO>();
    private Map<String, List> psModelListMap = new HashMap<String, List>();
    private PSDynaInstModelFolder[] dynaInstModelFolders = null;

    public static PSModelServiceSession getCurrent() throws Exception {
        return PSModelServiceSession.getCurrent(false);
    }

    public static PSModelServiceSession getCurrent(boolean bTry) throws Exception {
        PSModelServiceSession psModelServiceSession = current.get();
        if (psModelServiceSession == null && !bTry) {
            throw new Exception("\u5f53\u524d\u672a\u6253\u5f00\u6a21\u578b\u670d\u52a1\u4f1a\u8bdd");
        }
        return psModelServiceSession;
    }

    public static PSModelServiceSession open() throws Exception {
        return PSModelServiceSession.open(true);
    }

    public static PSModelServiceSession open(boolean bMustCreate) throws Exception {
        PSModelServiceSession psModelServiceSession = current.get();
        if (psModelServiceSession != null && bMustCreate) {
            throw new Exception("\u5f53\u524d\u5df2\u6253\u5f00\u6a21\u578b\u670d\u52a1\u4f1a\u8bdd");
        }
        psModelServiceSession = new PSModelServiceSession();
        current.set(psModelServiceSession);
        return psModelServiceSession;
    }

    public static void close(boolean bCommit) {
        PSModelServiceSession psModelServiceSession = current.get();
        if (psModelServiceSession == null) {
            return;
        }
        if (bCommit) {
            psModelServiceSession.commit();
        } else {
            psModelServiceSession.rollback();
        }
        current.set(null);
    }

    public void commit() {
    }

    public void rollback() {
    }

    public void setPSDynaInstId(String strPSDynaInstId) {
        this.strPSDynaInstId = strPSDynaInstId;
    }

    public String getPSDynaInstId() {
        return this.strPSDynaInstId;
    }

    public void setPSGlobalModelFolderPath(String strPSGlobalModelFolderPath) {
        this.strPSGlobalModelFolderPath = strPSGlobalModelFolderPath;
    }

    public String getPSGlobalModelFolderPath() {
        return this.strPSGlobalModelFolderPath;
    }

    public void setPSModelFolderPath(String strPSModelFolderPath) {
        this.strPSModelFolderPath = strPSModelFolderPath;
    }

    public String getPSModelFolderPath() {
        return this.strPSModelFolderPath;
    }

    public void setConfPSModelFolderPath(String strConfPSModelFolderPath) {
        this.strConfPSModelFolderPath = strConfPSModelFolderPath;
    }

    public String getConfPSModelFolderPath() {
        return this.strConfPSModelFolderPath;
    }

    public void setPSDynaInstFolderPath(String strPSDynaInstFolderPath) {
        this.strPSDynaInstFolderPath = strPSDynaInstFolderPath;
    }

    public String getPSDynaInstFolderPath() {
        return this.strPSDynaInstFolderPath;
    }

    public IPSModel getPSModel(String strType, String strTag) {
        String strFullTag = String.format("%1$s|%2$s", strType, strTag);
        return this.psModelMap.get(strFullTag);
    }

    public void setPSModel(String strType, String strTag, IPSModel iPSModel) {
        String strFullTag = String.format("%1$s|%2$s", strType, strTag);
        this.psModelMap.put(strFullTag, iPSModel);
    }

    public void resetPSModel(String strType, String strTag) {
        String strFullTag = String.format("%1$s|%2$s", strType, strTag);
        this.psModelMap.remove(strFullTag);
    }

    public IPSModelDTO getPSModelDTO(String strType, String strTag) {
        String strFullTag = String.format("%1$s|%2$s", strType, strTag);
        return this.psModelDTOMap.get(strFullTag);
    }

    public void setPSModelDTO(String strType, String strTag, IPSModelDTO iPSModelDTO) {
        String strFullTag = String.format("%1$s|%2$s", strType, strTag);
        this.psModelDTOMap.put(strFullTag, iPSModelDTO);
    }

    public void resetPSModelDTO(String strType, String strTag) {
        String strFullTag = String.format("%1$s|%2$s", strType, strTag);
        this.psModelDTOMap.remove(strFullTag);
    }

    public List getPSModelList(String strType, String strTag) {
        String strFullTag = String.format("%1$s|%2$s", strType, strTag);
        return this.psModelListMap.get(strFullTag);
    }

    public void setPSModelList(String strType, String strTag, List list) {
        String strFullTag = String.format("%1$s|%2$s", strType, strTag);
        this.psModelListMap.put(strFullTag, list);
    }

    public void resetPSModelList(String strType, String strTag) {
        String strFullTag = String.format("%1$s|%2$s", strType, strTag);
        this.psModelListMap.remove(strFullTag);
    }

    public void resetAllPSModelList() {
        this.psModelListMap.clear();
    }

    public void setPPSDynaInstId(String strPPSDynaInstId) {
        this.strPPSDynaInstId = strPPSDynaInstId;
    }

    public String getPPSDynaInstId() {
        return this.strPPSDynaInstId;
    }

    public void setPPSDynaInstFolderPath(String strPPSDynaInstFolderPath) {
        this.strPPSDynaInstFolderPath = strPPSDynaInstFolderPath;
    }

    public String getPPSDynaInstFolderPath() {
        return this.strPPSDynaInstFolderPath;
    }

    public PSDynaInstModelFolder[] getPSDynaInstModelFolders() {
        if (this.dynaInstModelFolders == null) {
            PSDynaInstModelFolder instModelFolder;
            ArrayList<PSDynaInstModelFolder> instModelFolderList = new ArrayList<PSDynaInstModelFolder>();
            if (StringUtils.hasLength((String)this.getConfPSModelFolderPath())) {
                instModelFolder = new PSDynaInstModelFolder();
                instModelFolder.modelPath = this.getConfPSModelFolderPath();
                instModelFolderList.add(instModelFolder);
            }
            if (StringUtils.hasLength((String)this.getPPSDynaInstFolderPath())) {
                instModelFolder = new PSDynaInstModelFolder();
                instModelFolder.modelPath = this.getPPSDynaInstFolderPath();
                instModelFolder.dynaInstId = this.getPPSDynaInstId();
                instModelFolderList.add(instModelFolder);
            }
            if (StringUtils.hasLength((String)this.getPSDynaInstFolderPath())) {
                instModelFolder = new PSDynaInstModelFolder();
                instModelFolder.modelPath = this.getPSDynaInstFolderPath();
                instModelFolder.dynaInstId = this.getPSDynaInstId();
                instModelFolderList.add(instModelFolder);
            }
            this.dynaInstModelFolders = instModelFolderList.toArray(new PSDynaInstModelFolder[instModelFolderList.size()]);
        }
        return this.dynaInstModelFolders;
    }

    public void setPSDynaInstModelFolders(PSDynaInstModelFolder[] dynaInstModelFolders) {
        this.dynaInstModelFolders = dynaInstModelFolders;
    }
}

