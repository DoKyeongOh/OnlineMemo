package kr.couchcoding.onlinememodemo.repository;

import kr.couchcoding.onlinememodemo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
    Optional<Memo> findByName(String name);

}
