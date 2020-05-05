package kr.lul.blog.street.cat.study.api.service;

import kr.lul.blog.street.cat.study.api.service.params.AddCatParams;
import kr.lul.blog.street.cat.study.common.data.Cat;
import kr.lul.blog.street.cat.study.common.repository.CatRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2020/05/05
 */
@Service
@Transactional
public class CatService {
  protected static final Logger log = getLogger(CatService.class);

  @Autowired
  private CatRepository catRepository;

  public Cat add(AddCatParams params) {
    if (log.isDebugEnabled())
      log.debug("#add params={}", params);

    Cat cat = this.catRepository.findByChipIdAndDeviceId(params.getChipId(), params.getDeviceId());
    if (null == cat) {
      cat = this.catRepository.save(new Cat(params.getChipId(), params.getDeviceId()));
    }

    if (log.isDebugEnabled())
      log.debug("#add return : {}", cat);
    return cat;
  }
}
