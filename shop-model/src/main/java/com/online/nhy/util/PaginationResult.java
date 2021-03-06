package com.online.nhy.util;

import java.io.Serializable;

/**
 * @author NingHaiyang
 * @date 2020-01-13 14:00
 */
public class PaginationResult<R> implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 2361929152482573703L;

    /**
     * 结果集
     */
    private R r;

    /**
     * 分页信息
     */
    private Pagination pagination;

    /**
     * 构造方法
     *
     * @param r 结果集
     * @param pagination 分页配置参数
     */
    public PaginationResult(R r, Pagination pagination) {
        super();
        this.r = r;
        this.pagination = pagination;
    }

    public PaginationResult() {

    }

    /**
     * 返回结果集
     *
     * @return 结果集
     */
    public R getR() {
        return r;
    }

    /**
     * 设置结果集
     *
     * @param r 结果集
     */
    public void setR(R r) {
        this.r = r;
    }

    /**
     * 获取分页配置
     *
     * @return 分页配置
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * 设置分页配置
     *
     * @param pagination 分页配置
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
