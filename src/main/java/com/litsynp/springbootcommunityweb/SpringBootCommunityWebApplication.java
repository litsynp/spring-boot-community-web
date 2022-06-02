package com.litsynp.springbootcommunityweb;

import com.litsynp.springbootcommunityweb.domain.Board;
import com.litsynp.springbootcommunityweb.domain.User;
import com.litsynp.springbootcommunityweb.domain.enums.BoardType;
import com.litsynp.springbootcommunityweb.repository.BoardRepository;
import com.litsynp.springbootcommunityweb.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.stream.IntStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCommunityWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCommunityWebApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository, BoardRepository boardRepository)
            throws Exception {
        return (args) -> {
            User user = userRepository.save(User.builder()
                    .name("litsynp")
                    .password("test")
                    .email("litsynp.gmail.com")
                    .createdDate(LocalDateTime.now())
                    .updatedDate(LocalDateTime.now())
                    .build());

            IntStream.rangeClosed(1, 200).forEach(index ->
                    boardRepository.save(Board.builder()
                            .title("게시글" + index)
                            .subTitle("순서" + index)
                            .content("콘텐츠")
                            .boardType(BoardType.free)
                            .createdDate(LocalDateTime.now())
                            .updatedDate(LocalDateTime.now())
                            .user(user)
                            .build()));
        };
    }
}
