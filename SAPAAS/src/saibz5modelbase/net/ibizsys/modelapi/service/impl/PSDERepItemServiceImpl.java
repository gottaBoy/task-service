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
import net.ibizsys.modelapi.domain.PSDERepItem;
import net.ibizsys.modelapi.domain.PSDEReport;
import net.ibizsys.modelapi.dto.PSDERepItemDTO;
import net.ibizsys.modelapi.dto.PSDEReportDTO;
import net.ibizsys.modelapi.service.IPSDERepItemService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDERepItemServiceImpl
extends PSModelServiceImplBase<PSDERepItem, PSDERepItemDTO>
implements IPSDERepItemService {
    private static final Log log = LogFactory.getLog(PSDERepItemServiceImpl.class);

    @Override
    public List<PSDERepItem> listByPSDEReport(PSDEReport parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDERepItem get(PSDEReport parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDERepItem> list = this.listByPSDEReport(parent);
        if (list != null) {
            for (PSDERepItem item : list) {
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
    public List<PSDERepItemDTO> listDTOByPSDEReport(String strParentKey) throws Exception {
        PSDEReport psdereport = (PSDEReport)PSModelServiceUtil.getInstance().getPSDEReportService().get(strParentKey);
        List<PSDERepItem> list = this.listByPSDEReport(psdereport);
        if (list != null) {
            ArrayList<PSDERepItemDTO> dtoList = new ArrayList<PSDERepItemDTO>();
            for (PSDERepItem item : list) {
                PSDERepItemDTO dto = (PSDERepItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDERepItem> onListAll() throws Exception {
        ArrayList<PSDERepItem> list = new ArrayList<PSDERepItem>();
        List psdereports = PSModelServiceUtil.getInstance().getPSDEReportService().listAll();
        if (psdereports != null) {
            for (PSDEReport parent : psdereports) {
                List<PSDERepItem> items = this.listByPSDEReport(parent);
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
    protected PSDERepItem onGet(String strParentKey, String strCurKey) throws Exception {
        PSDERepItem item;
        PSDEReport psdereport = (PSDEReport)PSModelServiceUtil.getInstance().getPSDEReportService().get(strParentKey, true);
        if (psdereport != null && (item = this.get(psdereport, strCurKey, true)) != null) {
            return item;
        }
        return (PSDERepItem)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDERepItemDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getMajorPSDEReportId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEReportService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDERepItem et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDERepItemName())) {
            return et.getPSDERepItemName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDERepItemDTO dto, PSDERepItem t, boolean bIgnoreNull) throws Exception {
        PSDEReportDTO linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDERepItemId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getMajorPSDEReportId() != null || !bIgnoreNull) {
            dto.setMajorPSDEReportId(t.getMajorPSDEReportId());
        }
        if (t.getMajorPSDEReportName() != null || !bIgnoreNull) {
            dto.setMajorPSDEReportName(t.getMajorPSDEReportName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMinorPSDEReportId() != null || !bIgnoreNull) {
            dto.setMinorPSDEReportId(t.getMinorPSDEReportId());
        }
        if (t.getMinorPSDEReportName() != null || !bIgnoreNull) {
            dto.setMinorPSDEReportName(t.getMinorPSDEReportName());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDERepItemName() != null || !bIgnoreNull) {
            dto.setPSDERepItemName(t.getPSDERepItemName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUserCat() != null || !bIgnoreNull) {
            dto.setUserCat(t.getUserCat());
        }
        if (t.getUserTag() != null || !bIgnoreNull) {
            dto.setUserTag(t.getUserTag());
        }
        if (t.getUserTag2() != null || !bIgnoreNull) {
            dto.setUserTag2(t.getUserTag2());
        }
        if (t.getUserTag3() != null || !bIgnoreNull) {
            dto.setUserTag3(t.getUserTag3());
        }
        if (t.getUserTag4() != null || !bIgnoreNull) {
            dto.setUserTag4(t.getUserTag4());
        }
        if (StringUtils.hasLength((String)dto.getMajorPSDEReportId())) {
            dto.setMajorPSDEReportId(this.getRealPSModelId(t, dto.getMajorPSDEReportId()).replace("/", "."));
        }
        if ("PSDEREPORT".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setMajorPSDEReportId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMinorPSDEReportId())) {
            dto.setMinorPSDEReportId(this.getRealPSModelId(t, dto.getMinorPSDEReportId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMajorPSDEReportId())) {
            linkDTO = (PSDEReportDTO)PSModelServiceUtil.getInstance().getPSDEReportService().getDTO(dto.getMajorPSDEReportId());
            dto.setMajorPSDEReportName(linkDTO.getPSDEReportName());
            dto.setPSDEId(linkDTO.getPSDEId());
        } else {
            dto.setMajorPSDEReportName(null);
            dto.setPSDEId(null);
        }
        if (StringUtils.hasLength((String)dto.getMinorPSDEReportId())) {
            linkDTO = (PSDEReportDTO)PSModelServiceUtil.getInstance().getPSDEReportService().getDTO(dto.getMinorPSDEReportId());
            dto.setMinorPSDEReportName(linkDTO.getPSDEReportName());
        } else {
            dto.setMinorPSDEReportName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEREPITEM";
    }

    @Override
    public PSDERepItem createDomain() {
        return new PSDERepItem();
    }

    @Override
    public PSDERepItemDTO createDTO() {
        return new PSDERepItemDTO();
    }
}

