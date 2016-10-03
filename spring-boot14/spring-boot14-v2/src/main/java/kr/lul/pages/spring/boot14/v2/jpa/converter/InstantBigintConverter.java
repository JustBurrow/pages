package kr.lul.pages.spring.boot14.v2.jpa.converter;

import java.time.Instant;

import javax.persistence.AttributeConverter;

/**
 * @author Just Burrow
 * @since 2016. 10. 3.
 */
public class InstantBigintConverter implements AttributeConverter<Instant, Long> {
  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 10. 3.
   */
  @Override
  public Long convertToDatabaseColumn(Instant instant) {
    return null == instant ? null : instant.toEpochMilli();
  }

  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 10. 3.
   */
  @Override
  public Instant convertToEntityAttribute(Long column) {
    return null == column ? null : Instant.ofEpochMilli(column);
  }
}
