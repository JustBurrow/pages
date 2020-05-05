package kr.lul.blog.street.cat.study.api.controller;

import kr.lul.blog.street.cat.study.api.controller.request.AddRequest;
import kr.lul.blog.street.cat.study.api.controller.response.AddResponse;
import kr.lul.blog.street.cat.study.api.service.CatService;
import kr.lul.blog.street.cat.study.api.service.params.AddCatParams;
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

  @RequestMapping("/api/add")
  @ResponseBody
  public AddResponse add(@RequestBody AddRequest request) {
    if (log.isDebugEnabled())
      log.debug("#add request={}", request);

    AddCatParams params = new AddCatParams(request.getChipId(), request.getDeviceId());
    Cat cat = this.catService.add(params);
    AddResponse response = new AddResponse(cat.getChipId(), cat.getCreatedAt());

    if (log.isDebugEnabled())
      log.debug("#add return : {}", response);
    return response;
  }
}
