package com.online.nhy.vo;

import com.online.nhy.util.Pagination;

/**
 * @author NingHaiyang
 * @date 2020-01-10 13:50
 */
public class BasePagerVo extends BaseVo{
    // serialVersionUID
    private static final long serialVersionUID = 2115510158079758308L;

    /**
     * 分页
     */
    private Pagination pager = new Pagination();

    /**
     * true--需要导出
     */
    private boolean isExport;

    /**
     * @return the pager
     */
    public Pagination getPager() {
        return pager;
    }

    /**
     * @param pager the pager to set
     */
    public void setPager(Pagination pager) {
        this.pager = pager;
    }

    /**
     * @return the isExport
     */
    public boolean isExport() {
        return isExport;
    }

    /**
     * @param isExport the isExport to set
     */
    public void setExport(boolean isExport) {
        this.isExport = isExport;
    }
}
