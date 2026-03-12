package com.pradeep.samrthrportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pradeep.samrthrportal.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}