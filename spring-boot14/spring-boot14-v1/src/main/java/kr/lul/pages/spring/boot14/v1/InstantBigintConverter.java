package kr.lul.pages.spring.boot14.v1;

import java.time.Instant;

import javax.persistence.AttributeConverter;

public class InstantBigintConverter implements AttributeConverter<Instant, Long> {
  @Override
  public Long convertToDatabaseColumn(Instant instant) {
    return null == instant ? null : instant.toEpochMilli();
  }

  @Override
  public Instant convertToEntityAttribute(Long column) {
    return null == column ? null : Instant.ofEpochMilli(column);
  }
}
