package com.pradeep.samrthrportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pradeep.samrthrportal.entity.LeaveManagement;

@Repository
public interface LeaveManagementRepository extends JpaRepository<LeaveManagement, Long> {

}