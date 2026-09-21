/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.IPSModelDTO;
import net.ibizsys.modelapi.util.IPSModelService;
import net.ibizsys.modelapi.util.Inflector;
import net.ibizsys.modelapi.util.PSDynaInstModelFolder;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceSession;
import org.springframework.util.StringUtils;

public abstract class PSModelServiceImplBase<T extends PSModelBase, DTO extends PSModelDTOBase>
implements IPSModelService<T, DTO> {
    protected static ObjectMapper DTOMAPPER = new ObjectMapper();
    public static String RANDOMTAG = "RT_";
    public static final String EXPORTMODELV2_INHERITDATA = "[SRFINHERIT]";
    public static final String EXPORTMODELV2_STAR = "[SRFSTAR]";
    public static final String EXPORTMODELV2_DOT = "[SRFDOT]";
    private static List EMPTYLIST = new ArrayList();

    protected String calcParentModel(T e) throws Exception {
        return null;
    }

    protected boolean isEnableListAll() {
        return true;
    }

    @Override
    public List<T> listAll() throws Exception {
        if (!this.isEnableListAll()) {
            throw new Exception("\u4e0d\u652f\u6301\u5217\u51fa\u5168\u90e8\u6a21\u578b");
        }
        return this.onListAll();
    }

    protected List<T> onListAll() throws Exception {
        return null;
    }

    @Override
    public List<DTO> listAllDTO() throws Exception {
        List<T> list = this.listAll();
        if (list == null) {
            return null;
        }
        ArrayList<DTO> dtolist = new ArrayList<DTO>();
        for (PSModelBase item : list) {
            DTO dto = this.toDTO(item);
            dtolist.add(dto);
        }
        if (dtolist.size() == 0) {
            return null;
        }
        return dtolist;
    }

    @Override
    public List<T> listAll(IPSModel parent) throws Exception {
        return this.listAll(parent, true, false);
    }

    @Override
    public List<T> listAll(IPSModel parent, boolean bModel, boolean bDynaInst) throws Exception {
        if (parent == null) {
            return this.listAll();
        }
        PSModelServiceSession psModelServiceSession = PSModelServiceSession.getCurrent();
        String strCacheTag = String.format("%1$s#%2$s", parent.getSrfType(), parent.toString());
        List list = psModelServiceSession.getPSModelList(this.getModelName(), strCacheTag);
        if (list == null) {
            List<T> ret = this.internalListAll(parent, bModel, bDynaInst);
            if (ret == null) {
                psModelServiceSession.setPSModelList(this.getModelName(), strCacheTag, EMPTYLIST);
                return null;
            }
            psModelServiceSession.setPSModelList(this.getModelName(), strCacheTag, ret);
            return ret;
        }
        if (list == EMPTYLIST) {
            return null;
        }
        return list;
    }

    /*
     * Could not resolve type clashes
     */
    protected List<T> internalListAll(IPSModel parent, boolean bModel, boolean bDynaInst) throws Exception {
        PSModelServiceSession psModelServiceSession = PSModelServiceSession.getCurrent();
        String strPSModelsName = this.getModelName(null, false);
        List<? extends IPSModel> list = null;
        if (bModel) {
            if (parent.containsPSModels(strPSModelsName, false)) {
                list = parent.getPSModels(strPSModelsName);
                if (list != null) {
                    for (PSModelBase t : list) {
                        if (StringUtils.hasLength((String)t.getSrfTag())) continue;
                        String strTag = PSModelServiceImplBase.getModelRealTag(this.getModelTag(t));
                        t.setSrfTag(strTag);
                        t.setId(PSModelServiceImplBase.calcPSModelId(parent.getId(), strTag));
                        t.setSrfParent(parent);
                    }
                }
            } else {
                String strModelFilePath = parent.getSrfFilePath();
                if (!StringUtils.hasLength((String)strModelFilePath)) {
                    parent.isFromDynaInst();
                    if (!StringUtils.hasLength((String)strModelFilePath)) {
                        if (parent.containsPSModels(strPSModelsName, true)) {
                            list = parent.getPSModels(strPSModelsName);
                            if (list != null) {
                                for (PSModelBase t : list) {
                                    if (StringUtils.hasLength((String)t.getSrfTag())) continue;
                                    String strTag = PSModelServiceImplBase.getModelRealTag(this.getModelTag(t));
                                    t.setSrfTag(strTag);
                                    t.setId(PSModelServiceImplBase.calcPSModelId(parent.getId(), strTag));
                                    t.setSrfParent(parent);
                                }
                            }
                        } else {
                            throw new Exception("\u7236\u6a21\u578b\u672a\u6307\u5b9a\u6a21\u578b\u6587\u4ef6\u8def\u5f84");
                        }
                    }
                }
                if (list == null && StringUtils.hasLength((String)strModelFilePath)) {
                    File[] files;
                    File folder = new File(strModelFilePath).getParentFile();
                    if ((folder = new File(String.valueOf(folder.getAbsolutePath()) + File.separator + this.getModelName(null, false))).exists() && (files = folder.listFiles()) != null) {
                        list = new ArrayList<IPSModel>();
                        File[] fileArray = files;
                        int n = files.length;
                        int n2 = 0;
                        while (n2 < n) {
                            File file = fileArray[n2];
                            String strModelTag = file.getName();
                            String strModelFilePath2 = String.valueOf(file.getAbsolutePath()) + File.separator + this.getModelName() + ".json";
                            IPSModel iPSModel = psModelServiceSession.getPSModel(this.getModelName(), strModelFilePath2);
                            if (iPSModel == null) {
                                Object t = this.createDomain();
                                ((PSModelBase)t).setSrfFilePath(strModelFilePath2);
                                ((PSModelBase)t).setSrfTag(strModelTag);
                                ((PSModelBase)t).setId(PSModelServiceImplBase.calcPSModelId(parent.getId(), strModelTag));
                                ((PSModelBase)t).setSrfParent(parent);
                                psModelServiceSession.setPSModel(this.getModelName(), strModelFilePath2, (IPSModel)t);
                                iPSModel = t;
                            }
                            list.add((PSModelBase)iPSModel);
                            ++n2;
                        }
                    }
                }
            }
        }
        if (bDynaInst) {
            PSDynaInstModelFolder[] folders;
            PSDynaInstModelFolder[] pSDynaInstModelFolderArray = folders = psModelServiceSession.getPSDynaInstModelFolders();
            int n = folders.length;
            int n3 = 0;
            while (n3 < n) {
                File[] files;
                PSDynaInstModelFolder dynaInstModelFolder = pSDynaInstModelFolderArray[n3];
                String strPSDynaInstId = dynaInstModelFolder.dynaInstId;
                String strPSDynaInstFolderPath = dynaInstModelFolder.modelPath;
                ArrayList<PSModelBase> list2 = null;
                String strPSModelPath = this.getPSModelFullPath(parent);
                String strFullPSModelPath = String.format("%1$s/%2$s/%3$s", strPSDynaInstFolderPath, strPSModelPath, strPSModelsName);
                File folder = new File(strFullPSModelPath);
                if (folder.exists() && (files = folder.listFiles()) != null) {
                    list2 = new ArrayList<PSModelBase>();
                    File[] fileArray = files;
                    int n4 = files.length;
                    int n5 = 0;
                    while (n5 < n4) {
                        File file = fileArray[n5];
                        String strModelTag = file.getName();
                        String strModelFilePath2 = String.valueOf(file.getAbsolutePath()) + File.separator + this.getModelName() + ".json";
                        File jsonfile = new File(strModelFilePath2);
                        if (jsonfile.exists()) {
                            IPSModel iPSModel = psModelServiceSession.getPSModel(this.getModelName(), strModelFilePath2);
                            if (iPSModel == null) {
                                Object t = this.createDomain();
                                ((PSModelBase)t).setSrfFilePath(strModelFilePath2);
                                ((PSModelBase)t).setSrfTag(strModelTag);
                                ((PSModelBase)t).setId(PSModelServiceImplBase.calcPSModelId(parent.getId(), strModelTag));
                                ((PSModelBase)t).setSrfParent(parent);
                                ((PSModelBase)t).setSrfDynaInstId(strPSDynaInstId);
                                psModelServiceSession.setPSModel(this.getModelName(), strModelFilePath2, (IPSModel)t);
                                iPSModel = t;
                            }
                            list2.add((PSModelBase)iPSModel);
                        }
                        ++n5;
                    }
                    if (list2.size() == 0) {
                        list2 = null;
                    }
                }
                if (list != null && list2 != null) {
                    PSModelBase t2;
                    String strTag;
                    HashMap<String, PSModelBase> map2 = new HashMap<String, PSModelBase>();
                    for (PSModelBase t : list2) {
                        String strTag2 = t.getSrfTag();
                        map2.put(strTag2.toUpperCase(), t);
                    }
                    ArrayList<? extends IPSModel> listAll = new ArrayList<IPSModel>();
                    for (PSModelBase t : list) {
                        strTag = t.getSrfTag();
                        if (!StringUtils.hasLength((String)strTag)) {
                            strTag = PSModelServiceImplBase.getModelRealTag(this.getModelTag(t));
                        }
                        if ((t2 = (PSModelBase)map2.remove(strTag.toUpperCase())) != null) {
                            Map<String, Object> map;
                            if (this.isEnableTempData()) {
                                map = t.any();
                                if (map != null) {
                                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                                        if (t2.contains(entry.getKey())) continue;
                                        t2.set(entry.getKey(), entry.getValue());
                                    }
                                }
                                t2.setSrfFilePath(t.getSrfFilePath(), true);
                                listAll.add(t2);
                                continue;
                            }
                            map = t2.any();
                            if (map != null) {
                                for (Map.Entry<String, Object> entry : map.entrySet()) {
                                    t.set(entry.getKey(), entry.getValue());
                                }
                            }
                            t.setSrfDynaInstId(t2.getSrfDynaInstId());
                            listAll.add(t);
                            continue;
                        }
                        listAll.add(t);
                    }
                    for (PSModelBase t : list2) {
                        strTag = t.getSrfTag();
                        t2 = (PSModelBase)map2.remove(strTag.toUpperCase());
                        if (t2 == null) continue;
                        listAll.add(t2);
                    }
                    list = listAll;
                } else if (list2 != null) {
                    list = list2;
                }
                ++n3;
            }
        }
        if (list != null) {
            return list;
        }
        return null;
    }

    public String getModelName(T e, boolean bSingle) {
        String strModelName = this.getModelName();
        if (e != null) {
            strModelName = e.getSrfType();
        }
        if (bSingle) {
            return strModelName;
        }
        return Inflector.getInstance().pluralize(strModelName).toUpperCase();
    }

    public abstract String getModelName();

    @Override
    public T get(String strKey) throws Exception {
        return this.get(strKey, false);
    }

    @Override
    public T get(String strKey, boolean bTryMode) throws Exception {
        if (!StringUtils.hasLength((String)strKey)) {
            if (bTryMode) {
                return null;
            }
            throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b[%1$s]\uff0c\u6ca1\u6709\u6307\u5b9a\u8def\u5f84", this.getModelName()));
        }
        strKey = strKey.replace(".", "/");
        String[] keys = strKey.split("[/]");
        T t = null;
        t = keys.length > 1 ? (T)this.onGet(PSModelServiceImplBase.getKey(keys, keys.length - 1), keys[keys.length - 1]) : (T)this.onGet("", keys[0]);
        if (t != null || bTryMode) {
            return t;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b[%1$s]\uff0c\u8def\u5f84\u4e3a[%2$s]", this.getModelName(), strKey));
    }

    protected T onGet(String strParentKey, String strCurKey) throws Exception {
        return null;
    }

    @Override
    public DTO getDTO(String strKey) throws Exception {
        return this.getDTO(strKey, false);
    }

    @Override
    public DTO getDTO(String strKey, boolean bTryMode) throws Exception {
        PSModelServiceSession psModelServiceSession;
        IPSModelDTO iPSModelDTO;
        if (StringUtils.hasLength((String)strKey)) {
            strKey = strKey.replace(".", "/");
        }
        if ((iPSModelDTO = (psModelServiceSession = PSModelServiceSession.getCurrent()).getPSModelDTO(this.getModelName(), strKey)) != null) {
            return (DTO)((PSModelDTOBase)iPSModelDTO);
        }
        T t = this.get(strKey, bTryMode);
        if (t == null) {
            return null;
        }
        if (!StringUtils.hasLength((String)((PSModelBase)t).getId())) {
            ((PSModelBase)t).setId(strKey);
        }
        DTO dto = this.toDTO(t);
        psModelServiceSession.setPSModelDTO(this.getModelName(), strKey, (IPSModelDTO)dto);
        return dto;
    }

    @Override
    public String getModelTag(T t) throws Exception {
        return String.format("%1$s%2$s", RANDOMTAG, t.hashCode());
    }

    public static boolean isRandomTag(String strTag) {
        if (StringUtils.hasLength((String)strTag)) {
            return strTag.indexOf(RANDOMTAG) == 0;
        }
        return false;
    }

    public static String calcPSModelId(String strParentId, String strCurTag) {
        if (StringUtils.hasLength((String)strParentId)) {
            return String.format("%1$s/%2$s", strParentId, strCurTag);
        }
        return strCurTag;
    }

    public static String getKey(String[] keys, int nLength) {
        String strKey = "";
        int i = 0;
        while (i < nLength) {
            if (i != 0) {
                strKey = String.valueOf(strKey) + "/";
            }
            strKey = String.valueOf(strKey) + keys[i];
            ++i;
        }
        return strKey;
    }

    @Override
    public IPSModel getParentModel(DTO dto) throws Exception {
        throw new Exception("\u65e0\u6cd5\u8ba1\u7b97\u7236\u6a21\u578b\u5bf9\u8c61");
    }

    protected String getPSModelFullPath(IPSModel parentModel) throws Exception {
        String strParentPath;
        if (!StringUtils.hasLength((String)parentModel.getSrfType())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6a21\u578b\u7c7b\u578b");
        }
        if ("PSSYSTEM".compareTo(parentModel.getSrfType()) == 0) {
            return "";
        }
        if (!StringUtils.hasLength((String)parentModel.getSrfTag())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6a21\u578b\u6807\u8bb0");
        }
        String strPath = String.format("%1$s/%2$s", Inflector.getInstance().pluralize(parentModel.getSrfType()).toUpperCase(), parentModel.getSrfTag());
        if (parentModel.getSrfParent() != null && StringUtils.hasLength((String)(strParentPath = this.getPSModelFullPath(parentModel.getSrfParent())))) {
            strPath = String.valueOf(strParentPath) + "/" + strPath;
        }
        return strPath;
    }

    @Override
    public DTO toDTO(T t) throws Exception {
        IPSModelDTO iPSModelDTO;
        PSModelServiceSession psModelServiceSession = PSModelServiceSession.getCurrent();
        if (StringUtils.hasLength((String)((PSModelBase)t).getId()) && (iPSModelDTO = psModelServiceSession.getPSModelDTO(this.getModelName(), ((PSModelBase)t).getId())) != null) {
            return (DTO)((PSModelDTOBase)iPSModelDTO);
        }
        try {
            ((PSModelBase)t).init();
            Object dto = this.createDTO();
            if (StringUtils.hasLength((String)((PSModelBase)t).getId())) {
                psModelServiceSession.setPSModelDTO(this.getModelName(), ((PSModelBase)t).getId(), (IPSModelDTO)dto);
            }
            this.onFillDTO(dto, t, true);
            if (StringUtils.hasLength((String)((PSModelBase)t).getId())) {
                psModelServiceSession.resetPSModelDTO(this.getModelName(), ((PSModelBase)t).getId());
            }
            return dto;
        }
        catch (Exception ex) {
            if (StringUtils.hasLength((String)((PSModelBase)t).getId())) {
                psModelServiceSession.resetPSModelDTO(this.getModelName(), ((PSModelBase)t).getId());
            }
            throw ex;
        }
    }

    protected void onFillDTO(DTO dto, T t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)((PSModelBase)t).getSrfDynaInstId())) {
            ((PSModelDTOBase)dto).set("psdynainstid", ((PSModelBase)t).getSrfDynaInstId());
        }
    }

    protected String getRealPSModelId(IPSModel iPSModel, String strId) throws Exception {
        if (strId.indexOf("<") == -1) {
            return strId;
        }
        String[] items = strId.split("[/]");
        String strRealId = "";
        String[] stringArray = items;
        int n = items.length;
        int n2 = 0;
        while (n2 < n) {
            String strItem = stringArray[n2];
            if (strItem.indexOf("<") == 0 && strItem.indexOf(">") == strItem.length() - 1) {
                if (strItem.compareTo("<PSSYSTEM>") == 0) {
                    return strRealId;
                }
                if (StringUtils.hasLength((String)strRealId)) {
                    strRealId = String.valueOf(strRealId) + "/";
                }
                strRealId = String.valueOf(strRealId) + this.getPSModelId(iPSModel.getSrfParent(), strItem.substring(1, strItem.length() - 1));
            } else {
                if (StringUtils.hasLength((String)strRealId)) {
                    strRealId = String.valueOf(strRealId) + "/";
                }
                strRealId = String.valueOf(strRealId) + strItem;
            }
            ++n2;
        }
        return strRealId;
    }

    protected String getPSModelId(IPSModel iPSModel, String strType) throws Exception {
        if (iPSModel == null) {
            throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u7c7b\u578b\u4e3a[%1$s]\u7684\u6a21\u5f0f\u6807\u8bc6", strType));
        }
        if (strType.compareToIgnoreCase(iPSModel.getSrfType()) == 0) {
            return iPSModel.getId();
        }
        return this.getPSModelId(iPSModel.getSrfParent(), strType);
    }

    protected void fillDTOFullInfo(DTO et, boolean bCreate) throws Exception {
        this.onFillDTOFullInfo(et, bCreate);
    }

    protected void onFillDTOFullInfo(DTO et, boolean bCreate) throws Exception {
    }

    protected String checkFieldDupRule(String strFieldName, String strRangeFieldName, DTO et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected boolean checkFieldRegExRule(String strValue, String strRegExCode) throws Exception {
        Pattern p = Pattern.compile(strRegExCode);
        Matcher m = p.matcher(strValue);
        return m.matches();
    }

    public static String getModelRealTag(String strModelV2Tag) {
        if (strModelV2Tag.indexOf("*") != -1) {
            strModelV2Tag = strModelV2Tag.replace("*", EXPORTMODELV2_STAR);
        }
        if (strModelV2Tag.indexOf("/") != -1) {
            strModelV2Tag = strModelV2Tag.replace("/", "-1-");
        }
        if (strModelV2Tag.indexOf("\\") != -1) {
            strModelV2Tag = strModelV2Tag.replace("\\", "-2-");
        }
        if (strModelV2Tag.indexOf("?") != -1) {
            strModelV2Tag = strModelV2Tag.replace("?", "-3-");
        }
        if (strModelV2Tag.indexOf(":") != -1) {
            strModelV2Tag = strModelV2Tag.replace(":", "-4-");
        }
        if (strModelV2Tag.indexOf("\"") != -1) {
            strModelV2Tag = strModelV2Tag.replace("\"", "-5-");
        }
        if (strModelV2Tag.indexOf("<") != -1) {
            strModelV2Tag = strModelV2Tag.replace("<", "-6-");
        }
        if (strModelV2Tag.indexOf(">") != -1) {
            strModelV2Tag = strModelV2Tag.replace(">", "-7-");
        }
        if (strModelV2Tag.indexOf("|") != -1) {
            strModelV2Tag = strModelV2Tag.replace("|", "-8-");
        }
        return strModelV2Tag;
    }

    protected boolean isEnableTempData() {
        return false;
    }
}

