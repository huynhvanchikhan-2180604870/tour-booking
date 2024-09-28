package com.hock.tour_booking.security.auth_repo;

import com.hock.tour_booking.entity.Role;
import com.hock.tour_booking.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import javax.xml.transform.Transformer;
import java.util.List;

@Repository
public class RoleCustomRepo {
    @PersistenceContext
    private EntityManager em;

    public List<String> getAllRoles(User user) {
        StringBuilder sql = new StringBuilder()
                .append("SELECT r.name FROM users u ")
                .append("JOIN user_role ur ON u.id = ur.user_id ")
                .append("JOIN roles r ON r.id = ur.role_id ")
                .append("WHERE 1 = 1");

        if (user.getEmail() != null) {
            sql.append(" AND email = :email");
        }

        NativeQuery<String> query = ((Session) em.getDelegate()).createNativeQuery(sql.toString());

        if (user.getEmail() != null) {
            query.setParameter("email", user.getEmail());
        }

        // Không cần phải thêm scalar hoặc transformer vì bạn chỉ cần danh sách chuỗi
        return query.getResultList();
    }
}
