package com.agritrace.repository;
import com.agritrace.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    long countByRoleAndEnabled(String role, Integer enabled);

    @Query("SELECT COUNT(u) FROM User u WHERE u.lastActiveAt >= :cutoffDate")
    long countActiveUsers(@Param("cutoffDate") java.time.LocalDateTime cutoffDate);
}
