package com.sprint.mission.discodeit.controller;

import com.sprint.mission.discodeit.dto.data.user.UserCreateRequest;
import com.sprint.mission.discodeit.dto.data.user.UserDto;
import com.sprint.mission.discodeit.dto.data.user.UserResponse;
import com.sprint.mission.discodeit.dto.data.user.UserUpdateRequest;
import com.sprint.mission.discodeit.dto.data.userstatus.UserStatusUpdateRequest;
import com.sprint.mission.discodeit.service.UserService;
import com.sprint.mission.discodeit.service.UserStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserStatusService userStatusService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserResponse> createUser(@RequestBody UserCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(request));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserResponse> updateUser(@PathVariable UUID id, @RequestBody UserUpdateRequest request) {
        return ResponseEntity.ok(userService.update(id, request));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @RequestMapping(value = "/{id}/status", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUserStatus(@PathVariable UUID id) {
        userStatusService.updateByUserId(id, new UserStatusUpdateRequest());
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> findAll() {
        List<UserDto> users = userService.findAll().stream()
                .map(user -> new UserDto(
                        user.id(),
                        user.createdAt(),
                        user.updatedAt(),
                        user.username(),
                        user.email(),
                        user.profileId(),
                        user.isOnline()
                ))
                .toList();
        return ResponseEntity.ok(users);
    }
}