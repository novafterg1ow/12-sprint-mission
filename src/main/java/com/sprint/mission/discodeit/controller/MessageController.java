package com.sprint.mission.discodeit.controller;

import com.sprint.mission.discodeit.dto.data.message.MessageCreateRequest;
import com.sprint.mission.discodeit.dto.data.message.MessageResponse;
import com.sprint.mission.discodeit.dto.data.message.MessageUpdateRequest;
import com.sprint.mission.discodeit.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<MessageResponse> sendMessage(@RequestBody MessageCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(messageService.create(request));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MessageResponse> updateMessage(@PathVariable UUID id, @RequestBody MessageUpdateRequest request) {
        return ResponseEntity.ok(messageService.update(id, request));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteMessage(@PathVariable UUID id) {
        messageService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<MessageResponse>> getMessagesByChannelId(@RequestParam UUID channelId) {
        return ResponseEntity.ok(messageService.findAllByChannelId(channelId));
    }
}