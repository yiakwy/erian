/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.rambo.spms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rambo.spms.entity.PmWlg;
import com.rambo.spms.repository.PmWlgDao;

import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.persistence.SearchFilter.Operator;

// Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional(value="mysqlEM")
public class PmWlgService {

	private PmWlgDao PmWlgDao;

	public PmWlg getPmWlg(Long id) {
		return PmWlgDao.findOne(id);
	}

	public void savePmWlg(PmWlg entity) {
		PmWlgDao.save(entity);
	}

	public void deletePmWlg(Long id) {
		PmWlgDao.delete(id);
	}

	public List<PmWlg> getAllPmWlg() {
		return (List<PmWlg>) PmWlgDao.findAll();
	}

	public Page<PmWlg> getUserPmWlg(Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<PmWlg> spec = buildSpecification(searchParams);

		return PmWlgDao.findAll(spec, pageRequest);
	}

	/**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "id");
		} else if ("pmNum".equals(sortType)) {
			sort = new Sort(Direction.ASC, "pmnum");
		}
		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<PmWlg> buildSpecification(Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification<PmWlg> spec = DynamicSpecifications.bySearchFilter(filters.values(), PmWlg.class);
		return spec;
	}

	@Autowired
	public void setPmWlgDao(PmWlgDao PmWlgDao) {
		this.PmWlgDao = PmWlgDao;
	}
}
