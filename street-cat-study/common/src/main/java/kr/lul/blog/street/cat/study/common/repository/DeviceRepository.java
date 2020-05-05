package kr.lul.blog.street.cat.study.common.repository;

import kr.lul.blog.street.cat.study.common.data.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author justburrow
 * @since 2020/05/05
 */
@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
}
