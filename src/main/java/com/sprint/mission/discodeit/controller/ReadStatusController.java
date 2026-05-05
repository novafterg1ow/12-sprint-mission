package com.sprint.mission.discodeit.controller;

import com.sprint.mission.discodeit.dto.data.readstatus.ReadStatusCreateRequest;
import com.sprint.mission.discodeit.dto.data.readstatus.ReadStatusResponse;
import com.sprint.mission.discodeit.dto.data.readstatus.ReadStatusUpdateRequest;
import com.sprint.mission.discodeit.service.ReadStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/read-statuses")
public class ReadStatusController {

    private final ReadStatusService readStatusService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ReadStatusResponse> createReadStatus(@RequestBody ReadStatusCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(readStatusService.create(request));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ReadStatusResponse> updateReadStatus(@PathVariable UUID id) {
        return ResponseEntity.ok(readStatusService.update(id, new ReadStatusUpdateRequest()));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ReadStatusResponse>> getReadStatusesByUserId(@RequestParam UUID userId) {
        return ResponseEntity.ok(readStatusService.findAllByUserId(userId));
    }
}