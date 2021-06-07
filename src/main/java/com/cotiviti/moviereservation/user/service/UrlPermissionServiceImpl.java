package com.cotiviti.moviereservation.user.service;

import com.cotiviti.moviereservation.configuration.LoggedInUserDetail;
import com.cotiviti.moviereservation.user.domain.Role;
import com.cotiviti.moviereservation.user.domain.UrlPermission;
import com.cotiviti.moviereservation.user.dto.UrlPermissionDto;
import com.cotiviti.moviereservation.user.mapper.UrlPermissionMapper;
import com.cotiviti.moviereservation.user.repo.UrlPermissionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Transactional
@Service
public class UrlPermissionServiceImpl implements UrlPermissionService {
    private final UrlPermissionRepository urlPermissionRepository;

    public UrlPermissionServiceImpl(UrlPermissionRepository urlPermissionRepository
    ) {
        this.urlPermissionRepository = urlPermissionRepository;
    }

    @Override
    public List<UrlPermissionDto> getByRoleId() {
        Map<String, Object> loggedInUserDetail = LoggedInUserDetail.getLoggedInUserDetail();
        Set result = (Set) loggedInUserDetail.get("roles");
        Role role = (Role) result.iterator().next();
        List<UrlPermission> res = urlPermissionRepository.findAllByRole_Id(role.getId());
        return UrlPermissionMapper.INSTANCE.toDto(res);
    }
}
