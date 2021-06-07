package com.cotiviti.moviereservation.user.controller;

import com.cotiviti.moviereservation.user.dto.UrlPermissionDto;
import com.cotiviti.moviereservation.user.service.UrlPermissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/url-permission")
public class UrlPermissionController {
    private final UrlPermissionService urlPermissionService;

    public UrlPermissionController(UrlPermissionService urlPermissionService) {
        this.urlPermissionService = urlPermissionService;
    }

    @GetMapping
    public ResponseEntity<List<UrlPermissionDto>> getLoggedInUserDetail() {
        return new ResponseEntity(urlPermissionService.getByRoleId(), HttpStatus.OK);
    }
}
