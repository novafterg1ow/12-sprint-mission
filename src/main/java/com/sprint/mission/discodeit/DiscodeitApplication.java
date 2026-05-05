package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.dto.data.channel.ChannelCreatePublicRequest;
import com.sprint.mission.discodeit.dto.data.channel.ChannelResponse;
import com.sprint.mission.discodeit.dto.data.message.MessageCreateRequest;
import com.sprint.mission.discodeit.dto.data.message.MessageResponse;
import com.sprint.mission.discodeit.dto.data.message.MessageUpdateRequest;
import com.sprint.mission.discodeit.dto.data.user.UserCreateRequest;
import com.sprint.mission.discodeit.dto.data.user.UserResponse;

import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.MessageService;
import com.sprint.mission.discodeit.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DiscodeitApplication {
	public static void main(String[] args) {
		SpringApplication.run(DiscodeitApplication.class, args);
	}
}
