package org.haozhang.services.support.persistence;

import jakarta.persistence.MappedSuperclass;
import org.haozhang.services.models.Model;

@jakarta.persistence.Entity
@MappedSuperclass
public interface Entity extends Model {
}
