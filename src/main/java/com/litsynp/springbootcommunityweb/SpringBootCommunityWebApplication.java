package com.litsynp.springbootcommunityweb;

import com.litsynp.springbootcommunityweb.domain.Board;
import com.litsynp.springbootcommunityweb.domain.User;
import com.litsynp.springbootcommunityweb.domain.enums.BoardType;
import com.litsynp.springbootcommunityweb.repository.BoardRepository;
import com.litsynp.springbootcommunityweb.repository.UserRepository;
import com.litsynp.springbootcommunityweb.resolver.UserArgumentResolver;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringBootCommunityWebApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCommunityWebApplication.class, args);
    }

    @Autowired
    private UserArgumentResolver userArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userArgumentResolver);
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
                            .title("?????????" + index)
                            .subTitle("??????" + index)
                            .content("?????????")
                            .boardType(BoardType.free)
                            .createdDate(LocalDateTime.now())
                            .updatedDate(LocalDateTime.now())
                            .user(user)
                            .build()));
        };
    }
}
