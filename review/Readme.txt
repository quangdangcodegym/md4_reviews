==>>>>>>>>>>>>Spring security
https://viblo.asia/p/huong-dan-spring-security-co-ban-de-hieu-OeVKBdedlkW
https://viblo.asia/p/huong-dan-spring-security-jpa-hibernate-L4x5xED1KBM



Sử dụng @PreAuthorize("hasRole('ROLE_USER')")
phải bật @EnableGlobalMethodSecurity(prePostEnabled = true)

Đặt tên ROLE phải bắt đầu từ ROLE_ (ROLE_ADMIN, ROLE_USER) nếu không phải tùy chỉnh
https://docs.spring.io/spring-security/site/docs/4.2.x/reference/html/el-access.html#el-access-web

==>>>>>>>>>>>>Spring data JPA
# Sử dụng join fetch hoặc left join fetch để lấy lazy loading trong hibernate
SELECT p from Product p left join fetch p.manufacturers where p.id = ?1
https://stackoverflow.com/questions/26358189/jpa-with-hibernate-many-to-many-relationship-fetching-all-data



#Nếu sử dụng @transitional hoặc #spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
thì hibernate sẽ lấy lên toàn bộ các row có quan hệ. NÊN ta sử dụng @Query kết hợp với join fetch
https://www.baeldung.com/hibernate-lazy-loading-workaround


==>>>>>>>>>>>>Spring data JPA - Sử dụng entitymanager
https://www.baeldung.com/spring-data-entitymanager


==>>>>>>>>>>>>Spring data JPa - Sử dụng query
https://websparrow.org/spring/spring-data-jpa-query-annotation-example

==>>>>>>>>>>>>Spring data JPa - Sử dụng method
https://websparrow.org/spring/spring-data-jpa-derived-query-methods-example



