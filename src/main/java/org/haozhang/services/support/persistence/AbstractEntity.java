package org.haozhang.services.support.persistence;

import jakarta.persistence.MappedSuperclass;
import org.haozhang.services.models.AbstractModel;

@jakarta.persistence.Entity
@MappedSuperclass
public abstract class AbstractEntity extends AbstractModel implements Entity {
}
