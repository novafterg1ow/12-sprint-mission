package com.sprint.mission.discodeit.controller;

import com.sprint.mission.discodeit.dto.data.binarycontent.BinaryContentResponse;
import com.sprint.mission.discodeit.entity.BinaryContent;
import com.sprint.mission.discodeit.service.BinaryContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/binaryContent")
public class BinaryContentController {

    private final BinaryContentService binaryContentService;

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseEntity<BinaryContent> findBinaryContent(
            @RequestParam("binaryContentId") UUID binaryContentId
    ) {
        BinaryContent binaryContent = binaryContentService.findEntity(binaryContentId);
        return ResponseEntity.ok(binaryContent);
    }
}