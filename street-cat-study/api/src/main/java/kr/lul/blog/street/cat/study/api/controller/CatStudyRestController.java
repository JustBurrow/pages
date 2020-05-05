package kr.lul.blog.street.cat.study.api.controller;

import kr.lul.blog.street.cat.study.api.controller.request.AddRequest;
import kr.lul.blog.street.cat.study.api.controller.response.AddResponse;
import kr.lul.blog.street.cat.study.api.service.CatService;
import kr.lul.blog.street.cat.study.common.data.Cat;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2020/05/05
 */
@RestController
@RequestMapping
public class CatStudyRestController {
  protected static final Logger log = getLogger(CatStudyRestController.class);

  @Autowired
  private CatService catService;

  /**
   * 인식표 정보를 받아 등록하고 등록된 정보를 반환한다.
   * 이미 등록된 정보인 경우에는 기존의 정보를 반환한다.
   *
   * @param request 인식표 정보.
   *
   * @return 등록된 인식표(고양이) 정보.
   */
  @RequestMapping("/api/add")
  @ResponseBody
  public AddResponse add(@RequestBody AddRequest request) {
    if (log.isDebugEnabled())
      log.debug("#add request={}", request);

    Cat cat = this.catService.add(request.getChipId(), request.getDeviceId());
    AddResponse response = new AddResponse(cat.getChipId(), cat.getCreatedAt());

    if (log.isDebugEnabled())
      log.debug("#add return : {}", response);
    return response;
  }
}
