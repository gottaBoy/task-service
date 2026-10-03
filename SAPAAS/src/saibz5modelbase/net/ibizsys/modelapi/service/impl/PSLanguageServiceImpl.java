/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import net.ibizsys.modelapi.domain.PSLanguage;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSLanguageDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSLanguageService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSLanguageServiceImpl
extends PSModelServiceImplBase<PSLanguage, PSLanguageDTO>
implements IPSLanguageService {
    private static final Log log = LogFactory.getLog(PSLanguageServiceImpl.class);

    @Override
    public List<PSLanguage> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSLanguage get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSLanguage> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSLanguage item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSLanguageDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSLanguage> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSLanguageDTO> dtoList = new ArrayList<PSLanguageDTO>();
            for (PSLanguage item : list) {
                PSLanguageDTO dto = (PSLanguageDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSLanguage> onListAll() throws Exception {
        ArrayList<PSLanguage> list = new ArrayList<PSLanguage>();
        List<PSSystem> pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll();
        if (pssystems != null) {
            for (PSSystem parent : pssystems) {
                List<PSLanguage> items = this.listByPSSystem(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        return list;
    }

    @Override
    protected PSLanguage onGet(String strParentKey, String strCurKey) throws Exception {
        PSLanguage item;
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSLanguage)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSLanguageDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSystemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSystemService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSLanguage et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSLanguageDTO dto, PSLanguage t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSLanguageId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSLanguageName() != null || !bIgnoreNull) {
            dto.setPSLanguageName(t.getPSLanguageName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            PSSystemDTO linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(linkDTO.getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSLANGUAGE";
    }

    @Override
    public PSLanguage createDomain() {
        return new PSLanguage();
    }

    @Override
    public PSLanguageDTO createDTO() {
        return new PSLanguageDTO();
    }
}

