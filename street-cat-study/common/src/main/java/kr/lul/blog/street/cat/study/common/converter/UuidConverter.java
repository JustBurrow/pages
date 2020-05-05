package kr.lul.blog.street.cat.study.common.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.UUID;

/**
 * @author justburrow
 * @since 2020/05/05
 */
@Converter(autoApply = true)
public class UuidConverter implements AttributeConverter<UUID, String> {
  @Override
  public String convertToDatabaseColumn(UUID attribute) {
    return null == attribute
               ? null
               : attribute.toString();
  }

  @Override
  public UUID convertToEntityAttribute(String dbData) {
    return null == dbData
               ? null
               : UUID.fromString(dbData);
  }
}
