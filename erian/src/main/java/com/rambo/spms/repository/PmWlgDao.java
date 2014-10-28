
package com.rambo.spms.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rambo.spms.entity.PmWlg;

public interface PmWlgDao extends PagingAndSortingRepository<PmWlg, Long>, JpaSpecificationExecutor<PmWlg> {
 	
	
}
