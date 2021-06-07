package com.cotiviti.moviereservation.user.repo;

import com.cotiviti.moviereservation.user.domain.UrlPermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UrlPermissionRepository extends JpaRepository<UrlPermission, Long> {
    List<UrlPermission> findAllByRole_Id(Long roleId);
}
