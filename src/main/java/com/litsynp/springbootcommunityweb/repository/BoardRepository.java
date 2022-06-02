package com.litsynp.springbootcommunityweb.repository;

import com.litsynp.springbootcommunityweb.domain.Board;
import com.litsynp.springbootcommunityweb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Board findByUser(User user);
}
