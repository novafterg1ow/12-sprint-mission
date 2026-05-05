package com.sprint.mission.discodeit.controller;

import com.sprint.mission.discodeit.dto.data.channel.ChannelCreatePrivateRequest;
import com.sprint.mission.discodeit.dto.data.channel.ChannelCreatePublicRequest;
import com.sprint.mission.discodeit.dto.data.channel.ChannelResponse;
import com.sprint.mission.discodeit.dto.data.channel.ChannelUpdateRequest;
import com.sprint.mission.discodeit.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/channels")
public class ChannelController {

    private final ChannelService channelService;

    @RequestMapping(value = "/public", method = RequestMethod.POST)
    public ResponseEntity<ChannelResponse> createPublicChannel(@RequestBody ChannelCreatePublicRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(channelService.createPublic(request));
    }

    @RequestMapping(value = "/private", method = RequestMethod.POST)
    public ResponseEntity<ChannelResponse> createPrivateChannel(@RequestBody ChannelCreatePrivateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(channelService.createPrivate(request));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ChannelResponse> updateChannel(@PathVariable UUID id, @RequestBody ChannelUpdateRequest request) {
        return ResponseEntity.ok(channelService.update(id, request));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteChannel(@PathVariable UUID id) {
        channelService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ChannelResponse>> getChannelsByUserId(@RequestParam UUID userId) {
        return ResponseEntity.ok(channelService.findAllByUserId(userId));
    }
}